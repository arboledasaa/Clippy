package at.droelf.clippy.backend.converter.mapping;

import at.droelf.clippy.R;

public class GenieMapping implements AgentMapping {

    private final static int NUMBER_COLUMNS = 21;
    private final static int NUMBER_ROWS = 20;

    private final static int [] IMAGE_MAPPING = {
            R.drawable.genie_0000,
            R.drawable.genie_0001,
            R.drawable.genie_0002,
            R.drawable.genie_0003,
            R.drawable.genie_0004,
            R.drawable.genie_0005,
            R.drawable.genie_0006,
            R.drawable.genie_0007,
            R.drawable.genie_0008,
            R.drawable.genie_0009,
            R.drawable.genie_0010,
            R.drawable.genie_0011,
            R.drawable.genie_0012,
            R.drawable.genie_0013,
            R.drawable.genie_0014,
            R.drawable.genie_0015,
            R.drawable.genie_0016,
            R.drawable.genie_0017,
            R.drawable.genie_0018,
            R.drawable.genie_0019,
            R.drawable.genie_0020,
            R.drawable.genie_0021,
            R.drawable.genie_0022,
            R.drawable.genie_0023,
            R.drawable.genie_0024,
            R.drawable.genie_0025,
            R.drawable.genie_0026,
            R.drawable.genie_0027,
            R.drawable.genie_0028,
            R.drawable.genie_0029,
            R.drawable.genie_0030,
            R.drawable.genie_0031,
            R.drawable.genie_0032,
            R.drawable.genie_0033,
            R.drawable.genie_0034,
            R.drawable.genie_0035,
            R.drawable.genie_0036,
            R.drawable.genie_0037,
            R.drawable.genie_0038,
            R.drawable.genie_0039,
            R.drawable.genie_0040,
            R.drawable.genie_0041,
            R.drawable.genie_0042,
            R.drawable.genie_0043,
            R.drawable.genie_0044,
            R.drawable.genie_0045,
            R.drawable.genie_0046,
            R.drawable.genie_0047,
            R.drawable.genie_0048,
            R.drawable.genie_0049,
            R.drawable.genie_0050,
            R.drawable.genie_0051,
            R.drawable.genie_0052,
            R.drawable.genie_0053,
            R.drawable.genie_0054,
            R.drawable.genie_0055,
            R.drawable.genie_0056,
            R.drawable.genie_0057,
            R.drawable.genie_0058,
            R.drawable.genie_0059,
            R.drawable.genie_0060,
            R.drawable.genie_0061,
            R.drawable.genie_0062,
            R.drawable.genie_0063,
            R.drawable.genie_0064,
            R.drawable.genie_0065,
            R.drawable.genie_0066,
            R.drawable.genie_0067,
            R.drawable.genie_0068,
            R.drawable.genie_0069,
            R.drawable.genie_0070,
            R.drawable.genie_0071,
            R.drawable.genie_0072,
            R.drawable.genie_0073,
            R.drawable.genie_0074,
            R.drawable.genie_0075,
            R.drawable.genie_0076,
            R.drawable.genie_0077,
            R.drawable.genie_0078,
            R.drawable.genie_0079,
            R.drawable.genie_0080,
            R.drawable.genie_0081,
            R.drawable.genie_0082,
            R.drawable.genie_0083,
            R.drawable.genie_0084,
            R.drawable.genie_0085,
            R.drawable.genie_0086,
            R.drawable.genie_0087,
            R.drawable.genie_0088,
            R.drawable.genie_0089,
            R.drawable.genie_0090,
            R.drawable.genie_0091,
            R.drawable.genie_0092,
            R.drawable.genie_0093,
            R.drawable.genie_0094,
            R.drawable.genie_0095,
            R.drawable.genie_0096,
            R.drawable.genie_0097,
            R.drawable.genie_0098,
            R.drawable.genie_0099,
            R.drawable.genie_0100,
            R.drawable.genie_0101,
            R.drawable.genie_0102,
            R.drawable.genie_0103,
            R.drawable.genie_0104,
            R.drawable.genie_0105,
            R.drawable.genie_0106,
            R.drawable.genie_0107,
            R.drawable.genie_0108,
            R.drawable.genie_0109,
            R.drawable.genie_0110,
            R.drawable.genie_0111,
            R.drawable.genie_0112,
            R.drawable.genie_0113,
            R.drawable.genie_0114,
            R.drawable.genie_0115,
            R.drawable.genie_0116,
            R.drawable.genie_0117,
            R.drawable.genie_0118,
            R.drawable.genie_0119,
            R.drawable.genie_0120,
            R.drawable.genie_0121,
            R.drawable.genie_0122,
            R.drawable.genie_0123,
            R.drawable.genie_0124,
            R.drawable.genie_0125,
            R.drawable.genie_0126,
            R.drawable.genie_0127,
            R.drawable.genie_0128,
            R.drawable.genie_0129,
            R.drawable.genie_0130,
            R.drawable.genie_0131,
            R.drawable.genie_0132,
            R.drawable.genie_0133,
            R.drawable.genie_0134,
            R.drawable.genie_0135,
            R.drawable.genie_0136,
            R.drawable.genie_0137,
            R.drawable.genie_0138,
            R.drawable.genie_0139,
            R.drawable.genie_0140,
            R.drawable.genie_0141,
            R.drawable.genie_0142,
            R.drawable.genie_0143,
            R.drawable.genie_0144,
            R.drawable.genie_0145,
            R.drawable.genie_0146,
            R.drawable.genie_0147,
            R.drawable.genie_0148,
            R.drawable.genie_0149,
            R.drawable.genie_0150,
            R.drawable.genie_0151,
            R.drawable.genie_0152,
            R.drawable.genie_0153,
            R.drawable.genie_0154,
            R.drawable.genie_0155,
            R.drawable.genie_0156,
            R.drawable.genie_0157,
            R.drawable.genie_0158,
            R.drawable.genie_0159,
            R.drawable.genie_0160,
            R.drawable.genie_0161,
            R.drawable.genie_0162,
            R.drawable.genie_0163,
            R.drawable.genie_0164,
            R.drawable.genie_0165,
            R.drawable.genie_0166,
            R.drawable.genie_0167,
            R.drawable.genie_0168,
            R.drawable.genie_0169,
            R.drawable.genie_0170,
            R.drawable.genie_0171,
            R.drawable.genie_0172,
            R.drawable.genie_0173,
            R.drawable.genie_0174,
            R.drawable.genie_0175,
            R.drawable.genie_0176,
            R.drawable.genie_0177,
            R.drawable.genie_0178,
            R.drawable.genie_0179,
            R.drawable.genie_0180,
            R.drawable.genie_0181,
            R.drawable.genie_0182,
            R.drawable.genie_0183,
            R.drawable.genie_0184,
            R.drawable.genie_0185,
            R.drawable.genie_0186,
            R.drawable.genie_0187,
            R.drawable.genie_0188,
            R.drawable.genie_0189,
            R.drawable.genie_0190,
            R.drawable.genie_0191,
            R.drawable.genie_0192,
            R.drawable.genie_0193,
            R.drawable.genie_0194,
            R.drawable.genie_0195,
            R.drawable.genie_0196,
            R.drawable.genie_0197,
            R.drawable.genie_0198,
            R.drawable.genie_0199,
            R.drawable.genie_0200,
            R.drawable.genie_0201,
            R.drawable.genie_0202,
            R.drawable.genie_0203,
            R.drawable.genie_0204,
            R.drawable.genie_0205,
            R.drawable.genie_0206,
            R.drawable.genie_0207,
            R.drawable.genie_0208,
            R.drawable.genie_0209,
            R.drawable.genie_0210,
            R.drawable.genie_0211,
            R.drawable.genie_0212,
            R.drawable.genie_0213,
            R.drawable.genie_0214,
            R.drawable.genie_0215,
            R.drawable.genie_0216,
            R.drawable.genie_0217,
            R.drawable.genie_0218,
            R.drawable.genie_0219,
            R.drawable.genie_0220,
            R.drawable.genie_0221,
            R.drawable.genie_0222,
            R.drawable.genie_0223,
            R.drawable.genie_0224,
            R.drawable.genie_0225,
            R.drawable.genie_0226,
            R.drawable.genie_0227,
            R.drawable.genie_0228,
            R.drawable.genie_0229,
            R.drawable.genie_0230,
            R.drawable.genie_0231,
            R.drawable.genie_0232,
            R.drawable.genie_0233,
            R.drawable.genie_0234,
            R.drawable.genie_0235,
            R.drawable.genie_0236,
            R.drawable.genie_0237,
            R.drawable.genie_0238,
            R.drawable.genie_0239,
            R.drawable.genie_0240,
            R.drawable.genie_0241,
            R.drawable.genie_0242,
            R.drawable.genie_0243,
            R.drawable.genie_0244,
            R.drawable.genie_0245,
            R.drawable.genie_0246,
            R.drawable.genie_0247,
            R.drawable.genie_0248,
            R.drawable.genie_0249,
            R.drawable.genie_0250,
            R.drawable.genie_0251,
            R.drawable.genie_0252,
            R.drawable.genie_0253,
            R.drawable.genie_0254,
            R.drawable.genie_0255,
            R.drawable.genie_0256,
            R.drawable.genie_0257,
            R.drawable.genie_0258,
            R.drawable.genie_0259,
            R.drawable.genie_0260,
            R.drawable.genie_0261,
            R.drawable.genie_0262,
            R.drawable.genie_0263,
            R.drawable.genie_0264,
            R.drawable.genie_0265,
            R.drawable.genie_0266,
            R.drawable.genie_0267,
            R.drawable.genie_0268,
            R.drawable.genie_0269,
            R.drawable.genie_0270,
            R.drawable.genie_0271,
            R.drawable.genie_0272,
            R.drawable.genie_0273,
            R.drawable.genie_0274,
            R.drawable.genie_0275,
            R.drawable.genie_0276,
            R.drawable.genie_0277,
            R.drawable.genie_0278,
            R.drawable.genie_0279,
            R.drawable.genie_0280,
            R.drawable.genie_0281,
            R.drawable.genie_0282,
            R.drawable.genie_0283,
            R.drawable.genie_0284,
            R.drawable.genie_0285,
            R.drawable.genie_0286,
            R.drawable.genie_0287,
            R.drawable.genie_0288,
            R.drawable.genie_0289,
            R.drawable.genie_0290,
            R.drawable.genie_0291,
            R.drawable.genie_0292,
            R.drawable.genie_0293,
            R.drawable.genie_0294,
            R.drawable.genie_0295,
            R.drawable.genie_0296,
            R.drawable.genie_0297,
            R.drawable.genie_0298,
            R.drawable.genie_0299,
            R.drawable.genie_0300,
            R.drawable.genie_0301,
            R.drawable.genie_0302,
            R.drawable.genie_0303,
            R.drawable.genie_0304,
            R.drawable.genie_0305,
            R.drawable.genie_0306,
            R.drawable.genie_0307,
            R.drawable.genie_0308,
            R.drawable.genie_0309,
            R.drawable.genie_0310,
            R.drawable.genie_0311,
            R.drawable.genie_0312,
            R.drawable.genie_0313,
            R.drawable.genie_0314,
            R.drawable.genie_0315,
            R.drawable.genie_0316,
            R.drawable.genie_0317,
            R.drawable.genie_0318,
            R.drawable.genie_0319,
            R.drawable.genie_0320,
            R.drawable.genie_0321,
            R.drawable.genie_0322,
            R.drawable.genie_0323,
            R.drawable.genie_0324,
            R.drawable.genie_0325,
            R.drawable.genie_0326,
            R.drawable.genie_0327,
            R.drawable.genie_0328,
            R.drawable.genie_0329,
            R.drawable.genie_0330,
            R.drawable.genie_0331,
            R.drawable.genie_0332,
            R.drawable.genie_0333,
            R.drawable.genie_0334,
            R.drawable.genie_0335,
            R.drawable.genie_0336,
            R.drawable.genie_0337,
            R.drawable.genie_0338,
            R.drawable.genie_0339,
            R.drawable.genie_0340,
            R.drawable.genie_0341,
            R.drawable.genie_0342,
            R.drawable.genie_0343,
            R.drawable.genie_0344,
            R.drawable.genie_0345,
            R.drawable.genie_0346,
            R.drawable.genie_0347,
            R.drawable.genie_0348,
            R.drawable.genie_0349,
            R.drawable.genie_0350,
            R.drawable.genie_0351,
            R.drawable.genie_0352,
            R.drawable.genie_0353,
            R.drawable.genie_0354,
            R.drawable.genie_0355,
            R.drawable.genie_0356,
            R.drawable.genie_0357,
            R.drawable.genie_0358,
            R.drawable.genie_0359,
            R.drawable.genie_0360,
            R.drawable.genie_0361,
            R.drawable.genie_0362,
            R.drawable.genie_0363,
            R.drawable.genie_0364,
            R.drawable.genie_0365,
            R.drawable.genie_0366,
            R.drawable.genie_0367,
            R.drawable.genie_0368,
            R.drawable.genie_0369,
            R.drawable.genie_0370,
            R.drawable.genie_0371,
            R.drawable.genie_0372,
            R.drawable.genie_0373,
            R.drawable.genie_0374,
            R.drawable.genie_0375,
            R.drawable.genie_0376,
            R.drawable.genie_0377,
            R.drawable.genie_0378,
            R.drawable.genie_0379,
            R.drawable.genie_0380,
            R.drawable.genie_0381,
            R.drawable.genie_0382,
            R.drawable.genie_0383,
            R.drawable.genie_0384,
            R.drawable.genie_0385,
            R.drawable.genie_0386,
            R.drawable.genie_0387,
            R.drawable.genie_0388,
            R.drawable.genie_0389,
            R.drawable.genie_0390,
            R.drawable.genie_0391,
            R.drawable.genie_0392,
            R.drawable.genie_0393,
            R.drawable.genie_0394,
            R.drawable.genie_0395,
            R.drawable.genie_0396,
            R.drawable.genie_0397,
            R.drawable.genie_0398,
            R.drawable.genie_0399,
            R.drawable.genie_0400,
            R.drawable.genie_0401,
            R.drawable.genie_0402,
            R.drawable.genie_0403,
            R.drawable.genie_0404,
            R.drawable.genie_0405,
            R.drawable.genie_0406,
            R.drawable.genie_0407,
            R.drawable.genie_0408,
            R.drawable.genie_0409,
            R.drawable.genie_0410,
            R.drawable.genie_0411,
            R.drawable.genie_0412,
            R.drawable.genie_0413,
            R.drawable.genie_0414,
            R.drawable.genie_0415,
            R.drawable.genie_0416,
            R.drawable.genie_0417,
            R.drawable.genie_0418,
            R.drawable.genie_0419
    };

    private final static int [] SOUND_MAPPING = {
            R.raw.genie_snd_01,
            R.raw.genie_snd_02,
            R.raw.genie_snd_03,
            R.raw.genie_snd_04,
            R.raw.genie_snd_05,
            R.raw.genie_snd_06,
            R.raw.genie_snd_07,
            R.raw.genie_snd_08,
            R.raw.genie_snd_09,
            R.raw.genie_snd_10,
            R.raw.genie_snd_11,
            R.raw.genie_snd_12,
            R.raw.genie_snd_13,
            R.raw.genie_snd_14
    };

    @Override
    public int[] getMapping() {
        return IMAGE_MAPPING;
    }

    @Override
    public int[] getSOUND_MAPPING() {
        return SOUND_MAPPING;
    }

    @Override
    public int getNumberRows() {
        return NUMBER_ROWS;
    }

    @Override
    public int getNUMBER_COLUMNS() {
        return NUMBER_COLUMNS;
    }

    @Override
    public int getEmptyFrameId() {
        return R.drawable.genie_0419;
    }

    @Override
    public int getFirstFrameId() {
        return R.drawable.genie_0000;
    }
}
