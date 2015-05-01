package at.droelf.clippy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.getbase.floatingactionbutton.FloatingActionButton;
import com.zendesk.sdk.model.network.AnonymousIdentity;
import com.zendesk.sdk.network.impl.ZendeskConfig;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import at.droelf.clippy.broadcastreceiver.DeviceUnlock;
import at.droelf.clippy.model.AgentType;
import at.droelf.clippy.utils.IntentHelper;
import butterknife.ButterKnife;
import butterknife.InjectView;
import timber.log.Timber;


public class MainActivity extends AppCompatActivity {


    @InjectView(R.id.agent_list)
    RecyclerView recyclerView;

    @InjectView(R.id.agent_list_toolbar)
    Toolbar toolbar;

    @InjectView(R.id.main_fab_kill)
    FloatingActionButton fabKill;

    @InjectView(R.id.main_fab_start)
    FloatingActionButton fabStart;

    @InjectView(R.id.main_fab_mute)
    FloatingActionButton fabMute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        setSupportActionBar(toolbar);

        final int agentListOrientation = getResources().getInteger(R.integer.agent_list_orientation);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(getResources().getInteger(R.integer.agent_list_span), agentListOrientation));
        recyclerView.setAdapter(new AgentAdapter(getApplicationContext()));

        initFabs();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(agentBroadcastReceiver, new IntentFilter(FloatingService.AGENT_STATE_ACTION));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(agentBroadcastReceiver);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_support:
                startActivity(new Intent(MainActivity.this, HelpActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initFabs(){
        setFabVisible(false, fabKill, fabMute, fabStart);
        startService(IntentHelper.getCommandIntent(this, FloatingService.Command.State));
        Timber.d("Init FABS");
    }

    private void initFab(FloatingActionButton fab, int iconId, View.OnClickListener onClickListener){
        fab.setIcon(iconId);
//        fab.setVisibility(View.VISIBLE);
        fab.setEnabled(true);
        fab.setOnClickListener(onClickListener);
    }

    private void setFabVisible(boolean visible, FloatingActionButton... floatingActionButtons){
        for(FloatingActionButton fab : floatingActionButtons){
            if(visible){
                fab.setEnabled(true);
//                fab.setVisibility(View.VISIBLE);
            } else{
                fab.setEnabled(false);
//                fab.setVisibility(View.INVISIBLE);
            }
        }
    }

    class AgentClickListener implements View.OnClickListener{

        private final AgentType agentType;
        private final Context context;

        public AgentClickListener(Context context, AgentType agentType){
            this.agentType = agentType;
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            context.startService(IntentHelper.getCommandIntent(context, FloatingService.Command.Kill));

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent commandIntent = IntentHelper.getCommandIntent(context, FloatingService.Command.Show);
                    commandIntent.putExtra(AgentType.KEY, agentType);
                    context.startService(commandIntent);
                }
            }, 500);
        }
    }

    private BroadcastReceiver agentBroadcastReceiver = new BroadcastReceiver(){

        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(FloatingService.AGENT_STATE_ACTION)){

                final boolean isRunning = intent.getBooleanExtra(FloatingService.AGENT_STATE_RUNNING, false);
                Timber.d("AgentStateBroadcastReceiver called - isRunning: %s", isRunning);

                if(isRunning){
                    initFab(fabKill, R.drawable.ic_action_cancel, new CommandClickListener(FloatingService.Command.Kill, context));

                    final boolean mute = intent.getBooleanExtra(FloatingService.AGENT_STATE_MUTE, false);
                    final int muteIcon = mute ? R.drawable.ic_action_volume_on : R.drawable.ic_action_volume_muted;
                    final FloatingService.Command muteCommand = mute ? FloatingService.Command.UnMute : FloatingService.Command.Mute;
                    initFab(fabMute, muteIcon, new CommandClickListener(muteCommand, context));

                    final boolean started = intent.getBooleanExtra(FloatingService.AGENT_STATE_STARTED, false);
                    final int startedIcon = started ? R.drawable.ic_action_stop : R.drawable.ic_action_play;
                    final FloatingService.Command startedCommand = started ? FloatingService.Command.Stop : FloatingService.Command.Start;
                    initFab(fabStart, startedIcon, new CommandClickListener(startedCommand, context));

                    Timber.d("AgentStateBroadcastReceiver called - mute: %s, started: %s", mute, started);

                }else{
                    setFabVisible(false, fabStart, fabKill, fabMute);

                }


            }
        }

    };


    class CommandClickListener implements View.OnClickListener{

        private final FloatingService.Command command;
        private final Context context;

        public CommandClickListener(FloatingService.Command command, Context context){
            this.command = command;
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            context.startService(IntentHelper.getCommandIntent(context, command));
        }
    }

    class AgentAdapter extends RecyclerView.Adapter{

        private final List<AgentType> agents;
        private final Context context;

        public AgentAdapter(Context context){
            this.agents = Arrays.asList(AgentType.values());
            this.context = context;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
            final LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            final View inflate = inflater.inflate(R.layout.agent_list_item, viewGroup, false);
            return new AgentAdapterViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, int i) {
            final AgentAdapterViewHolder viewHolder1 = (AgentAdapterViewHolder) viewHolder;
            final AgentType agentType = agents.get(i);
            final Drawable drawable = context.getResources().getDrawable(agentType.getAgentMapping().getFirstFrameId());

            viewHolder1.itemView.setOnClickListener(new AgentClickListener(context, agentType));
            viewHolder1.getImageView().setBackgroundDrawable(drawable);
        }

        @Override
        public int getItemCount() {
            return agents.size();
        }
    }

    class AgentAdapterViewHolder extends RecyclerView.ViewHolder{

        @InjectView(R.id.agent_image)
        ImageView imageView;

        @InjectView(R.id.card_view)
        CardView cardView;

        public AgentAdapterViewHolder(View v) {
            super(v);
            ButterKnife.inject(this, v);
        }

        public ImageView getImageView(){
            return imageView;
        }

        public CardView getCardView() {
            return cardView;
        }
    }


}
