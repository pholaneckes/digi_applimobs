package gq.codephon.digi_applimobs.appli_helpers;

public class GattaiResult {
    public static String checkGattai(String appmonA, String appmonB){
        switch (appmonA){
            case "GATCHMOB" :
                switch(appmonB){
                    case "NAVIMOB" :
                    case "TUBUMOB" :
                        return "DOGATCHMOB";
                    case "ONMOB":
                        return "LOGIMOB";
                    default:
                        return "noGattai";
                }
            case "ADDMOB" :
                switch(appmonB){
                    case "CALLMOB" :
                    case "MAILMOB" :
                    case "MESSEMOB" :
                        return "SOCIAMOB";
                    default:
                        return "noGattai";
                }
            case "AIDMOB" :
                switch(appmonB){
                    case "VIRUSMOB" :
                    case "DOPEMOB" :
                        return "DOCMOB";
                    case "SPAMOB" :
                    case "SUPPLEMOB" :
                        return "MEDICMOB";
                    default:
                        return "noGattai";
                }
            case "AUCTIOMOB" :
                switch(appmonB){
                    case "MIRRORMOB" :
                    case "DRESSMOB" :
                    case "KAIMOB" :
                        return "COORDEMOB";
                    default:
                        return "noGattai";
                }
            case "BATTERIMOB" :
                switch(appmonB){
                    case "CALCUMOB" :
                    case "CARDMOB" :
                        return "SAKUSIMOB";
                    default:
                        return "noGattai";
                }
            case "BEAUTYMOB" :
                switch(appmonB){
                    case "OUJAMOB" :
                        return "POSEIDOMOB";
                    default:
                        return "noGattai";
                }
            case "BIOMOB" :
                switch(appmonB){
                    case "REVIVEMOB" :
                        return "HADESMOB";
                    default:
                        return "noGattai";
                }
            case "BOOKMOB" :
                switch(appmonB){
                    case "SETMOB" :
                    case "JISHOMOB" :
                        return "LIBRAMOB";
                    default:
                        return "noGattai";
                }
            case "BOOTMOB" :
                switch(appmonB){
                    case "SHUTMOB" :
                        return "REBOOTMOB";
                    default:
                        return "noGattai";
                }
//            case "BRAMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
            case "CALCUMOB" :
                switch(appmonB){
                    case "PUZZLEMOB" :
                    case "MUSCLEMOB" :
                        return "BRAMOB";
                    default:
                        return "noGattai";
                }
            case "CALENDAMOB" :
                switch(appmonB){
                    case "WATCHMOB" :
                    case "SAVEMOB" :
                        return "TIMEMOB";
                    case "COOKMOB" :
                    case "DIARIMOB" :
                        return "COACHMOB";
                    default:
                        return "noGattai";
                }
//            case "CALLMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
            case "CAMERAMOB" :
                switch(appmonB){
                    case "SHOTMOB" :
                    case "ROCKETMOB" :
                        return "SCORPMOB";
                    default:
                        return "noGattai";
                }
            case "CARDMOB" :
                switch(appmonB){
                    case "TELLERMOB" :
                    case "GASHAMOB" :
                        return "TAROTMOB";
                    default:
                        return "noGattai";
                }
            case "CHARISMOB" :
                switch(appmonB){
                    case "GLOBEMOB" :
                        return "GAIAMOB";
                    default:
                        return "noGattai";
                }
            case "COACHMOB" :
                switch(appmonB){
                    case "DOSUKOMOB" :
                        return "OUJAMOB";
                    default:
                        return "noGattai";
                }
            case "COMETMOB" :
                switch(appmonB){
                    case "WARUDAMOB" :
                        return "DEUSUMOB";
                    default:
                        return "noGattai";
                }
            case "COMPASSMOB" :
                switch(appmonB){
                    case "JETMOB" :
                    case "RESSHAMOB" :
                    case "YADOMOB" :
                        return "TRIPMOB";
                    default:
                        return "noGattai";
                }
            case "CONSULMOB" :
                switch(appmonB){
                    case "COORDEMOB" :
                        return "BEAUTYMOB";
                    default:
                        return "noGattai";
                }
//            case "COOKMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "COORDEMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
            case "COPIPEMOB" :
                switch(appmonB){
                    case "MIRRORMOB" :
                    case "KABEMOB" :
                    case "DRAWMOB" :
                        return "MIENUMOB";
                    default:
                        return "noGattai";
                }
            case "CRAFTMOB" :
                switch(appmonB){
                    case "LOGIMOB" :
                        return "BOOTMOB";
                    default:
                        return "noGattai";
                }
//            case "DAMEDAMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
            case "DANCEMOB" :
                switch(appmonB){
                    case "MUSIMOB" :
                    case "MCMOB" :
                    case "RECOMOB" :
                        return "MEDIAMOB";
                    default:
                        return "noGattai";
                }
//            case "DANTEMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
            case "DENPAMOB" :
                switch(appmonB){
                    case "ONPAMOB" :
                    case "JAMMINGMOB" :
                    case "GENGOMOB" :
                        return "ROAMOB";
                    default:
                        return "noGattai";
                }
//            case "DEUSUMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
            case "DEZIPMOB" :
                switch(appmonB){
                    case "RAIDRAMOB" :
                        return "REVIVEMOB";
                    default:
                        return "noGattai";
                }
//            case "DIARIMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
            case "DICEMOB" :
                switch(appmonB){
                    case "GASHAMOB" :
                    case "LUCKMOB" :
                    case "MONEYMOB" :
                        return "VEGASMOB";
                    default:
                        return "noGattai";
                }
            case "DOCMOB" :
                switch(appmonB){
                    case "MEDICMOB" :
                        return "BIOMOB";
                    default:
                        return "noGattai";
                }
            case "DOGAMOB" :
                switch(appmonB){
                    case "LIGHTMOB" :
                    case "DRAWMOB" :
                        return "EFFECMOB";
                    case "REVIEWMOB" :
                    case "KOSOMOB" :
                    case "NEWSMOB" :
                        return "GOSSIPMOB";
                    default:
                        return "noGattai";
                }
            case "DOGATCHMOB" :
                switch(appmonB){
                    case "TIMEMOB" :
                        return "GLOBEMOB";
                    default:
                        return "noGattai";
                }
            case "DOKAMOB" :
                switch(appmonB){
                    case "PERORIMOB" :
                    case "MUSCLEMOB" :
                        return "DOSUKOMOB";
                    default:
                        return "noGattai";
                }
//            case "DOPEMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "DOSUKOMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "DRAWMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
            case "DREAMMOB" :
                switch(appmonB){
                    case "MEDIAMOB" :
                        return "ENTERMOB";
                    default:
                        return "noGattai";
                }
//            case "DRESSMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
            case "ECOMOB" :
                switch(appmonB){
                    case "PEKOMOB" :
                    case "MONEYMOB" :
                    case "KAKEIMOB" :
                        return "CONSULMOB";
                    case "GOMIMOB" :
                    case "KABEMOB" :
                    case "PUZZLEMOB" :
                        return "CRAFTMOB";
                    default:
                        return "noGattai";
                }
            case "EFFECMOB" :
                switch(appmonB){
                    case "ROAMOB" :
                        return "FAKEMOB";
                    default:
                        return "noGattai";
                }
            case "ENTERMOB" :
                switch(appmonB){
                    case "FAKEMOB" :
                        return "OURANOSMOB";
                    default:
                        return "noGattai";
                }
//            case "FAKEMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "FLICKMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "GAIAMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "GASHAMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "GENGOMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "GLOBEMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "GOMIMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
            case "GOSSIPMOB" :
                switch(appmonB){
                    case "SOCIAMOB" :
                        return "CHARISMOB";
                    default:
                        return "noGattai";
                }
//            case "GUGUMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
            case "HACKMOB" :
                switch(appmonB){
                    case "OFFMOB" :
                        return "LOGAMOB";
                    case "PROTECMOB" :
                    case "PIPOMOB" :
                        return "RAIDRAMOB";
                    default:
                        return "noGattai";
                }
//            case "HADESMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "JAMMINGMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
            case "JETMOB" :
                switch(appmonB){
                    case "TRICKMOB" :
                    case "RACEMOB" :
                        return "WARPMOB";
                    default:
                        return "noGattai";
                }
//            case "JISHOMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "JUMPPLUSMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "KABEMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "KAIMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "KAKEIMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "KOSOMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "LIBRAMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "LIGHTMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
            case "LOGAMOB" :
                switch(appmonB){
                    case "TIMEMOB" :
                        return "SHUTMOB";
                    default:
                        return "noGattai";
                }
//            case "LOGIMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "LUCKMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "MAILMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "MCMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "MEDIAMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "MEDICMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "MESSEMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
            case "MIENUMOB" :
                switch(appmonB){
                    case "SAKUSIMOB" :
                        return "WARUDAMOB";
                    default:
                        return "noGattai";
                }
//            case "MIRRORMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "MONEYMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "MUSCLEMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "MUSIMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "NAVIMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
            case "NEWSMOB" :
                switch(appmonB){
                    case "ROCKETMOB" :
                    case "WEATHERMOB" :
                        return "WEATHEDRAMOB";
                    default:
                        return "noGattai";
                }
//            case "OFFMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "ONMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "ONPAMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "OUJAMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "OURANOSMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
            case "PEKOMOB" :
                switch(appmonB){
                    case "POKOMOB" :
                    case "SAVEMOB" :
                        return "DEZIPMOB";
                    default:
                        return "noGattai";
                }
//            case "PERORIMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "PIPOMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "POKOMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "POSEIDOMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "PROTECMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "PUZZLEMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "RACEMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "RAIDRAMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "REBOOTMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "RECOMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "RESSHAMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "REVIEWMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "REVIVEMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "ROAMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "ROCKETMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "ROPUREMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "SAKUSIMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "SANTAMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
            case "SATERAMOB" :
                switch(appmonB){
                    case "TRIPMOB" :
                        return "SCORPMOB";
                    default:
                        return "noGattai";
                }
//            case "SAVEMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
            case "SCORPMOB" :
                switch(appmonB){
                    case "TRIPMOB" :
                        return "SATERAMOB";
                    default:
                        return "noGattai";
                }
            case "SETMOB" :
                switch(appmonB){
                    case "SLEEPMOB" :
                    case "YADOMOB" :
                        return "DREAMMOB";
                    default:
                        return "noGattai";
                }
//            case "SHOTMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "SHUTMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "SLEEPMOB" :  //todo Leviathan
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "SOCIAMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "SPAMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "SPECIAMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "SUKASIMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "SUPERMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "SUPPLEMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "SWIPEMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "TAPMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "TAROTMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "TELLERMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "TIMEMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "TRICKMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "TRIPMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "TUBUMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "TUTOMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "URATEKUMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "VEGASMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "VIRUSMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "VJUMPMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
            case "WARPMOB" :
                switch(appmonB){
                    case "WEATHERDRAMOB" :
                        return "COMETMOB";
                    default:
                        return "noGattai";
                }
//            case "WARUDAMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "WATCHMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "WEATHERDRAMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "WEATHERMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
//            case "YADOMOB" :
//                switch(appmonB){
//                    case "" :
//                        return "";
//                }
            default:
                return "noGattai";
        }
    }
}
