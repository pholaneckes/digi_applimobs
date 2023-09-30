package gq.codephon.digi_applimobs.appli_helpers;

import gq.codephon.digi_applimobs.entities.AppliEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.text.TranslationTextComponent;
import org.jetbrains.annotations.NotNull;

import static gq.codephon.digi_applimobs.appli_helpers.AppliAttributes.Attributes.*;
import static gq.codephon.digi_applimobs.appli_helpers.AppliFormTypes.FormTypes.*;
import static gq.codephon.digi_applimobs.entities.EntiReg.*;
import static gq.codephon.digi_applimobs.items.ItemRegistry.*;

public class AppliSetup {

    public static String[] appmonList = new String[]{"GATCHMOB", "ADDMOB", "AIDMOB", "AUCTIOMOB", "BATTERIMOB", "BEAUTYMOB", "BIOMOB", "BOOKMOB", "BOOTMOB", "BRAMOB", "CALCUMOB", "CALENDAMOB", "CALLMOB", "CAMERAMOB", "CARDMOB", "CHARISMOB", "COACHMOB", "COMETMOB", "COMPASSMOB", "CONSULMOB", "COOKMOB", "COORDEMOB", "COPIPEMOB", "CRAFTMOB", "DAMEDAMOB", "DANCEMOB", "DANTEMOB", "DENPAMOB", "DEUSUMOB", "DEZIPMOB", "DIARIMOB", "DICEMOB", "DOCMOB", "DOGAMOB", "DOGATCHMOB", "DOKAMOB", "DOPEMOB", "DOSUKOMOB", "DRAWMOB", "DREAMMOB", "DRESSMOB", "ECOMOB", "EFFECMOB", "ENTERMOB", "FAKEMOB", "FLICKMOB", "GAIAMOB", "GASHAMOB", "GENGOMOB", "GLOBEMOB", "GOMIMOB", "GOSSIPMOB", "GUGUMOB", "HACKMOB", "HADESMOB", "JAMMINGMOB", "JETMOB", "JISHOMOB", "JUMPPLUSMOB", "KABEMOB", "KAIMOB", "KAKEIMOB", "KOSOMOB", "LIBRAMOB", "LIGHTMOB", "LOGAMOB", "LOGIMOB", "LUCKMOB", "MAILMOB", "MCMOB", "MEDIAMOB", "MEDICMOB", "MESSEMOB", "MIENUMOB", "MIRRORMOB", "MONEYMOB", "MUSCLEMOB", "MUSIMOB", "NAVIMOB", "NEWSMOB", "OFFMOB", "ONMOB", "ONPAMOB", "OUJAMOB", "OURANOSMOB", "PEKOMOB", "PERORIMOB", "PIPOMOB", "POKOMOB", "POSEIDOMOB", "PROTECMOB", "PUZZLEMOB", "RACEMOB", "RAIDRAMOB", "REBOOTMOB", "RECOMOB", "RESSHAMOB", "REVIEWMOB", "REVIVEMOB", "ROAMOB", "ROCKETMOB", "ROPUREMOB", "SAKUSIMOB", "SANTAMOB", "SATERAMOB", "SAVEMOB", "SCORPMOB", "SETMOB", "SHOTMOB", "SHUTMOB", "SLEEPMOB", "SOCIAMOB", "SPAMOB", "SPECIAMOB", "SUKASIMOB", "SUPERMOB", "SUPPLEMOB", "SWIPEMOB", "TAPMOB", "TAROTMOB", "TELLERMOB", "TIMEMOB", "TRICKMOB", "TRIPMOB", "TUBUMOB", "TUTOMOB", "URATEKUMOB", "VEGASMOB", "VIRUSMOB", "VJUMPMOB", "WARPMOB", "WARUDAMOB", "WATCHMOB", "WEATHERDRAMOB", "WEATHERMOB", "YADOMOB","nul","nul","nul","nul","nul","nul","nul","nul","nul","nul","nul","nul","nul","nul","nul","nul"};
    public enum AppmonTypes implements IStringSerializable{
        GATCHMOB("Gatchmon", "Gatch", STANDARD, SOCIAL, 1000, "", new TranslationTextComponent("null"), appliChipGatchmob.get(),gatchMOB.get()),
        ADDMOB("Addmon", "Address_Book", STANDARD, SOCIAL, 320, "", new TranslationTextComponent("null"),appliChipAddmob.get(),addMOB.get()),
        AIDMOB("Aidmon", "Rescue", STANDARD, LIFE, 490, "", new TranslationTextComponent("null"),appliChipAidmob.get(),aidMOB.get()),
        AUCTIOMOB("Auctiomon", "Auction", STANDARD, LIFE, 130, "", new TranslationTextComponent("null"),appliChipAuctiomob.get(),auctioMOB.get()),
        BATTERIMOB("Batterimon", "Battery", STANDARD, SYSTEM, 190, "", new TranslationTextComponent("null"),appliChipBatterimob.get(),batteriMOB.get()),
        BEAUTYMOB("Beautymon", "Beauty", ULTIMATE, LIFE, 45000, "", new TranslationTextComponent("null"),appliChipBeautymob.get(),beautyMOB.get()),
        BIOMOB("Biomon", "Life", ULTIMATE, LIFE, 70000, "", new TranslationTextComponent("null"),appliChipBiomob.get(),bioMOB.get()),
        BOOKMOB("Bookmon", "eBook", STANDARD, ENTERTAINMENT, 620, "", new TranslationTextComponent("null"),appliChipBookmob.get(),bookMOB.get()),
        BOOTMOB("Bootmon", "Super_Boot", ULTIMATE, TOOL, 57000, "", new TranslationTextComponent("null"),appliChipBootmob.get(),bootMOB.get()),
        BRAMOB("Bramon", "Brain_Training", SUPER, GAME, 5000, "", new TranslationTextComponent("null"),appliChipBramob.get(),braMOB.get()),
        CALCUMOB("Calcumon", "Calculator", STANDARD, TOOL, 220, "", new TranslationTextComponent("null"),appliChipCalcumob.get(),calcuMOB.get()),
        CALENDAMOB("Calendamon", "Calendar", STANDARD, TOOL, 170, "", new TranslationTextComponent("null"),appliChipCalendamob.get(),calendaMOB.get()),
        CALLMOB("Callmon", "Phone", STANDARD, SOCIAL, 520, "", new TranslationTextComponent("null"),appliChipCallmob.get(),callMOB.get()),
        CAMERAMOB("Cameramon", "Camera", STANDARD, TOOL, 1200, "", new TranslationTextComponent("null"),appliChipCameramob.get(),cameraMOB.get()),
        CARDMOB("Cardmon", "Card", STANDARD, GAME, 650, "", new TranslationTextComponent("null"),appliChipCardmob.get(),cardMOB.get()),
        CHARISMOB("Charismon", "Mind_Control", ULTIMATE, SOCIAL, 55000, "", new TranslationTextComponent("null"),appliChipCharismob.get(),charisMOB.get()),
        COACHMOB("Coachmon", "Training", SUPER, GAME, 6000, "", new TranslationTextComponent("null"),appliChipCoachmob.get(),coachMOB.get()),
        COMETMOB("Cometmon", "Astrology", ULTIMATE, NAVI, 65000, "", new TranslationTextComponent("null"),appliChipCometmob.get(),cometMOB.get()),
        COMPASSMOB("Compassmon", "Compass", STANDARD, NAVI, 230, "", new TranslationTextComponent("null"),appliChipCompassmob.get(),compassMOB.get()),
        CONSULMOB("Consulmon", "Saving", SUPER, LIFE, 6400, "", new TranslationTextComponent("null"),appliChipConsulmob.get(),consulMOB.get()),
        COOKMOB("Cookmon", "Cook", STANDARD, ENTERTAINMENT, 200, "", new TranslationTextComponent("null"),appliChipCookmob.get(),cookMOB.get()),
        COORDEMOB("Coordemon", "Coordinate", SUPER, ENTERTAINMENT, 9600, "", new TranslationTextComponent("null"),appliChipCoordemob.get(),coordeMOB.get()),
        COPIPEMOB("Copipemon", "Copy_and_Paste", STANDARD, SYSTEM, 710, "", new TranslationTextComponent("null"),appliChipCopipemob.get(),copipeMOB.get()),
        CRAFTMOB("Craftmon", "Design", SUPER, TOOL, 7200, "", new TranslationTextComponent("null"),appliChipCraftmob.get(),craftMOB.get()),
        DAMEDAMOB("Damedamon", "Dame_Dame", ULTIMATE, SOCIAL, 38000, "", new TranslationTextComponent("null"),appliChipDamedamob.get(),damedaMOB.get()),
        DANCEMOB("Dancemon", "Rhythm", STANDARD, GAME, 440, "", new TranslationTextComponent("null"),appliChipDancemob.get(),danceMOB.get()),
        DANTEMOB("Dantemon", "Open", AppliFormTypes.FormTypes.__,OTHER,77777, "", new TranslationTextComponent("null"),appliChipDantemob.get(),danteMOB.get()),
        DENPAMOB("Denpamon", "Communication", STANDARD, SYSTEM, 680, "", new TranslationTextComponent("null"),appliChipDenpamob.get(),denpaMOB.get()),
        DEUSUMOB("Deusumon", "Omnipotence", AppliFormTypes.FormTypes.GOD, AppliAttributes.Attributes.GOD, 340000, "", new TranslationTextComponent("null"),appliChipDeusumob.get(),deusuMOB.get()),
        DEZIPMOB("Dezipmon", "Zip_or_Unzip", SUPER, SYSTEM, 10500, "", new TranslationTextComponent("null"),appliChipDezipmob.get(),dezipMOB.get()),
        DIARIMOB("Diarimon", "Diary", STANDARD, TOOL, 180, "", new TranslationTextComponent("null"),appliChipDiarimob.get(),diariMOB.get()),
        DICEMOB("Dicemon", "Dice", STANDARD, ENTERTAINMENT, 120, "", new TranslationTextComponent("null"),appliChipDicemob.get(),diceMOB.get()),
        DOCMOB("Docmon", "Doctor", SUPER, LIFE, 8800, "", new TranslationTextComponent("null"),appliChipDocmob.get(),docMOB.get()),
        DOGAMOB("Dogamon", "Video", STANDARD, ENTERTAINMENT, 740, "", new TranslationTextComponent("null"),appliChipDogamob.get(),dogaMOB.get()),
        DOGATCHMOB("Dogatchmon", "Super_Search", SUPER, SOCIAL, 7500, "", new TranslationTextComponent("null"),appliChipDogatchmob.get(),dogatchMOB.get()),
        DOKAMOB("Dokamon", "Action", STANDARD, GAME, 900, "", new TranslationTextComponent("null"),appliChipDokamob.get(),dokaMOB.get()),
        DOPEMOB("Dopemon", "Enhancement", STANDARD, LIFE, 360, "", new TranslationTextComponent("null"),appliChipDopemob.get(),dopeMOB.get()),
        DOSUKOMOB("Dosukomon", "Fighting", SUPER, GAME, 11000, "", new TranslationTextComponent("null"),appliChipDosukomob.get(),dosukoMOB.get()),
        DRAWMOB("Drawmon", "Paint", STANDARD, ENTERTAINMENT, 800, "", new TranslationTextComponent("null"),appliChipDrawmob.get(),drawMOB.get()),
        DREAMMOB("Dreammon", "Dream", SUPER, ENTERTAINMENT, 7800, "", new TranslationTextComponent("null"),appliChipDreamob.get(),dreamMOB.get()),
        DRESSMOB("Dressmon", "Fashion", STANDARD, ENTERTAINMENT, 240, "", new TranslationTextComponent("null"),appliChipDressmob.get(),dressMOB.get()),
        ECOMOB("Ecomon", "Energy_Saving", STANDARD, SYSTEM, 100, "", new TranslationTextComponent("null"),appliChipEcomob.get(),ecoMOB.get()),
        EFFECMOB("Effecmon", "Effect", SUPER, ENTERTAINMENT, 7000, "", new TranslationTextComponent("null"),appliChipEffecmob.get(),effecMOB.get()),
        ENTERMOB("Entermon", "Entertainment", ULTIMATE, ENTERTAINMENT, 42000, "", new TranslationTextComponent("null"),appliChipEntermob.get(),enterMOB.get()),
        FAKEMOB("Fakemon", "Camouflage", ULTIMATE, TOOL, 50000, "", new TranslationTextComponent("null"),appliChipFakemob.get(),fakeMOB.get()),
        FLICKMOB("Flickmon", "Flick", STANDARD, OTHER, 8, "", new TranslationTextComponent("null"),appliChipFlickmob.get(),flickMOB.get()),
        GAIAMOB("Gaiamon", "Creation", AppliFormTypes.FormTypes.GOD, AppliAttributes.Attributes.GOD, 300000, "", new TranslationTextComponent("null"),appliChipGaiamob.get(),gaiaMOB.get()),
        GASHAMOB("Gashamon", "Gasha", STANDARD, ENTERTAINMENT, 300, "", new TranslationTextComponent("null"),appliChipGashamob.get(),gashaMOB.get()),
        GENGOMOB("Gengomon", "Translation", STANDARD, SOCIAL, 460, "", new TranslationTextComponent("null"),appliChipGengomob.get(),gengoMOB.get()),
        GLOBEMOB("Globemon", "Global", ULTIMATE, SOCIAL, 60000, "", new TranslationTextComponent("null"),appliChipGlobemob.get(),globeMOB.get()),
        GOMIMOB("Gomimon", "Trashbin", STANDARD, TOOL, 10, "", new TranslationTextComponent("null"),appliChipGomimob.get(),gomiMOB.get()),
        GOSSIPMOB("Gossipmon", "Gossip", SUPER, SOCIAL, 4800, "", new TranslationTextComponent("null"),appliChipGossipmob.get(),gossipMOB.get()),
        GUGUMOB("Gugumon", "Search", STANDARD, SOCIAL, 1100, "", new TranslationTextComponent("null"),appliChipGugumob.get(),guguMOB.get()),
        HACKMOB("Hackmon", "Hacking", STANDARD, SYSTEM, 1400, "", new TranslationTextComponent("null"),appliChipHackmob.get(),hackMOB.get()),
        HADESMOB("Hadesmon", "Variation", AppliFormTypes.FormTypes.GOD, AppliAttributes.Attributes.GOD, 315000, "", new TranslationTextComponent("null"),appliChipHadesmob.get(),hadesMOB.get()),
        JAMMINGMOB("Jammingmon", "Jamming", STANDARD, TOOL, 930, "", new TranslationTextComponent("null"),appliChipJammingmob.get(),jammingMOB.get()),
        JETMOB("Jetmon", "Flight", STANDARD, NAVI, 1100, "", new TranslationTextComponent("null"),appliChipJetmob.get(),jetMOB.get()),
        JISHOMOB("Jishomon", "Dictionary", STANDARD, LIFE, 680, "", new TranslationTextComponent("null"),appliChipJishomob.get(),jishoMOB.get()),
        JUMPPLUSMOB("Jumpplusmon", "Jumpplus", STANDARD, ENTERTAINMENT, 550, "", new TranslationTextComponent("null"),appliChipJumpplusmob.get(),jumpplusMOB.get()),
        KABEMOB("Kabemon", "Wallpaper", STANDARD, SYSTEM, 140, "", new TranslationTextComponent("null"),appliChipKabemob.get(),kabeMOB.get()),
        KAIMOB("Kaimon", "Shopping", STANDARD, LIFE, 330, "", new TranslationTextComponent("null"),appliChipKaimob.get(),kaiMOB.get()),
        KAKEIMOB("Kakeimon", "Account Book", STANDARD, LIFE, 210, "", new TranslationTextComponent("null"),appliChipKakeimob.get(),kakeiMOB.get()),
        KOSOMOB("Kosomon", "Gossip_Review", STANDARD, SOCIAL, 230, "", new TranslationTextComponent("null"),appliChipKosomob.get(),kosoMOB.get()),
        LIBRAMOB("Libramon", "Library", SUPER, LIFE, 5400, "", new TranslationTextComponent("null"),appliChipLibramob.get(),libraMOB.get()),
        LIGHTMOB("Lightmon", "Light", STANDARD, TOOL, 150, "", new TranslationTextComponent("null"),appliChipLightmob.get(),lightMOB.get()),
        LOGAMOB("Logamon", "Logoff", SUPER, SOCIAL, 7200, "", new TranslationTextComponent("null"),appliChipLogamob.get(),logaMOB.get()),
        LOGIMOB("Logimon", "Login", SUPER, SOCIAL, 7200, "", new TranslationTextComponent("null"),appliChipLogimob.get(),logiMOB.get()),
        LUCKMOB("Luckmon", "Slot", STANDARD, ENTERTAINMENT, 777, "", new TranslationTextComponent("null"),appliChipLuckmob.get(),luckMOB.get()),
        MAILMOB("Mailmon", "Mail", STANDARD, SOCIAL, 510, "", new TranslationTextComponent("null"),appliChipMailmob.get(),mailMOB.get()),
        MCMOB("Mcmon", "Broadcasting", STANDARD, NAVI, 780, "", new TranslationTextComponent("null"),appliChipMcmob.get(),mcMOB.get()),
        MEDIAMOB("Mediamon", "Media_Player", SUPER, ENTERTAINMENT, 5800, "", new TranslationTextComponent("null"),appliChipMediamob.get(),mediaMOB.get()),
        MEDICMOB("Medicmon", "Medical", SUPER, LIFE, 8000, "", new TranslationTextComponent("null"),appliChipMedicmob.get(),medicMOB.get()),
        MESSEMOB("Messemon", "Message", STANDARD, SOCIAL, 500, "", new TranslationTextComponent("null"),appliChipMessemob.get(),messeMOB.get()),
        MIENUMOB("Mienumon", "Stealth", SUPER, SYSTEM, 8400, "", new TranslationTextComponent("null"),appliChipMienumob.get(),mienuMOB.get()),
        MIRRORMOB("Mirrormon", "Mirror", STANDARD, TOOL, 700, "", new TranslationTextComponent("null"),appliChipMirrormob.get(),mirrorMOB.get()),
        MONEYMOB("Moneymon", "emoney", STANDARD, LIFE, 110, "", new TranslationTextComponent("null"),appliChipMoneymob.get(),moneyMOB.get()),
        MUSCLEMOB("Musclemon", "Muscle_Training", STANDARD, LIFE, 920, "", new TranslationTextComponent("null"),appliChipMusclemob.get(),muscleMOB.get()),
        MUSIMOB("Musimon", "Music", STANDARD, ENTERTAINMENT, 880, "", new TranslationTextComponent("null"),appliChipMusimob.get(),musiMOB.get()),
        NAVIMOB("Navimon", "Navi", STANDARD, NAVI, 560, "", new TranslationTextComponent("null"),appliChipNavimob.get(),naviMOB.get()),
        NEWSMOB("Newsmon", "News", STANDARD, NAVI, 390, "", new TranslationTextComponent("null"),appliChipNewsmob.get(),newsMOB.get()),
        OFFMOB("Offmon", "Offline", STANDARD, GAME, 950, "", new TranslationTextComponent("null"),appliChipOffmob.get(),offMOB.get()),
        ONMOB("Onmon", "Online", STANDARD, GAME, 950, "", new TranslationTextComponent("null"),appliChipOnmob.get(),onMOB.get()),
        ONPAMOB("Onpamon", "Ultrasound", STANDARD, TOOL, 580, "", new TranslationTextComponent("null"),appliChipOnpamob.get(),onpaMOB.get()),
        OUJAMOB("Oujamon", "Battle", ULTIMATE, GAME, 95000, "", new TranslationTextComponent("null"),appliChipOujamob.get(),oujaMOB.get()),
        OURANOSMOB("Ouranosmon", "Arousal", AppliFormTypes.FormTypes.GOD, AppliAttributes.Attributes.GOD, 290000, "", new TranslationTextComponent("null"),appliChipOuranosmob.get(),ouranosMOB.get()),
        PEKOMOB("Pekomon", "Compression", STANDARD, SYSTEM, 80, "", new TranslationTextComponent("null"),appliChipPekomob.get(),pekoMOB.get()),
        PERORIMOB("Perorimon", "Gourmet", STANDARD, ENTERTAINMENT, 690, "", new TranslationTextComponent("null"),appliChipPerorimob.get(),peroriMOB.get()),
        PIPOMOB("Pipomon", "Warning", STANDARD, SYSTEM, 950, "", new TranslationTextComponent("null"),appliChipPipomob.get(),pipoMOB.get()),
        POKOMOB("Pokomon", "Decompression", STANDARD, SYSTEM, 80, "", new TranslationTextComponent("null"),appliChipPokomob.get(),pokoMOB.get()),
        POSEIDOMOB("Poseidomon", "Invincible", AppliFormTypes.FormTypes.GOD, AppliAttributes.Attributes.GOD, 270000, "", new TranslationTextComponent("null"),appliChipPoseidomob.get(),poseidoMOB.get()),
        PROTECMOB("Protecmon", "Security", STANDARD, SYSTEM, 750, "", new TranslationTextComponent("null"),appliChipProtecmob.get(),protecMOB.get()),
        PUZZLEMOB("Puzzlemon", "Puzzle", STANDARD, GAME, 350, "", new TranslationTextComponent("null"),appliChipPuzzlemob.get(),puzzleMOB.get()),
        RACEMOB("Racemon", "Race", STANDARD, GAME, 550, "", new TranslationTextComponent("null"),appliChipRacemob.get(),raceMOB.get()),
        RAIDRAMOB("Raidramon", "Super_Hacking", SUPER, SYSTEM, 12500, "", new TranslationTextComponent("null"),appliChipRaidramob.get(),raidraMOB.get()),
        REBOOTMOB("Rebootmon", "Reboot", AppliFormTypes.FormTypes.GOD, AppliAttributes.Attributes.GOD, 280000, "", new TranslationTextComponent("null"),appliChipRebootmob.get(),rebootMOB.get()),
        RECOMOB("Recomon", "Recording", STANDARD, TOOL, 290, "", new TranslationTextComponent("null"),appliChipRecomob.get(),recoMOB.get()),
        RESSHAMOB("Resshamon", "Transfer", STANDARD, NAVI, 720, "", new TranslationTextComponent("null"),appliChipResshamob.get(),resshaMOB.get()),
        REVIEWMOB("Reviewmon", "Review", STANDARD, SOCIAL, 250, "", new TranslationTextComponent("null"),appliChipReviewmob.get(),reviewMOB.get()),
        REVIVEMOB("Revivemon", "Restoration", ULTIMATE, SYSTEM, 78000, "", new TranslationTextComponent("null"),appliChipRevivemob.get(),reviveMOB.get()),
        ROAMOB("Roamon", "Voice_Change", SUPER, TOOL, 4400, "", new TranslationTextComponent("null"),appliChipRoamob.get(),roaMOB.get()),
        ROCKETMOB("Rocketmon", "Rocket", STANDARD, NAVI, 1600, "", new TranslationTextComponent("null"),appliChipRocketmob.get(),rocketMOB.get()),
        ROPUREMOB("Ropuremon", "Ropure", STANDARD, GAME, 1500, "", new TranslationTextComponent("null"),appliChipRopuremob.get(),ropureMOB.get()),
        SAKUSIMOB("Sakusimon", "Simulation", SUPER, GAME, 14000, "", new TranslationTextComponent("null"),appliChipSakusimob.get(),sakusiMOB.get()),
        SANTAMOB("Santamon", "Christmas", SUPER, ENTERTAINMENT, 12250, "", new TranslationTextComponent("null"),appliChipSantamob.get(),santaMOB.get()),
        SATERAMOB("Sateramon", "GPS", ULTIMATE, NAVI, 100000, "", new TranslationTextComponent("null"),appliChipSateramob.get(),sateraMOB.get()),
        SAVEMOB("Savemon", "Backup", STANDARD, SYSTEM, 1100, "", new TranslationTextComponent("null"),appliChipSavemob.get(),saveMOB.get()),
        SCORPMOB("Scorpmon", "monitoring", SUPER, TOOL, 13000, "", new TranslationTextComponent("null"),appliChipScorpmob.get(),scorpMOB.get()),
        SETMOB("Setmon", "Setup", STANDARD, SOCIAL, 50, "", new TranslationTextComponent("null"),appliChipSetmob.get(),setMOB.get()),
        SHOTMOB("Shotmon", "Shooting", STANDARD, GAME, 1300, "", new TranslationTextComponent("null"),appliChipShotmob.get(),shotMOB.get()),
        SHUTMOB("Shutmon", "Forced_Termination", ULTIMATE, TOOL, 57000, "", new TranslationTextComponent("null"),appliChipShutmob.get(),shutMOB.get()),
        SLEEPMOB("Sleepmon", "Sleep", STANDARD, LIFE, 270, "", new TranslationTextComponent("null"),appliChipSleepmob.get(),sleepMOB.get()),
        SOCIAMOB("Sociamon", "SNS", SUPER, SOCIAL, 6800, "", new TranslationTextComponent("null"),appliChipSociamob.get(),sociaMOB.get()),
        SPAMOB("Spamon", "Spa", STANDARD, LIFE, 260, "", new TranslationTextComponent("null"),appliChipSpamob.get(),spaMOB.get()),
        SPECIAMOB("Speciamon", "Secret", ULTIMATE, NAVI, 100000, "", new TranslationTextComponent("null"),appliChipSpeciamob.get(),speciaMOB.get()),
        SUKASIMOB("Sukasimon", "Failed", SUPER, SOCIAL, 4000, "", new TranslationTextComponent("null"),appliChipSukasimob.get(),sukasiMOB.get()),
        SUPERMOB("Supermon", "Super", SUPER, SYSTEM, 10000, "", new TranslationTextComponent("null"),appliChipSupermob.get(),superMOB.get()),
        SUPPLEMOB("Supplemon", "Supple", STANDARD, LIFE, 310, "", new TranslationTextComponent("null"),appliChipSupplemob.get(),suppleMOB.get()),
        SWIPEMOB("Swipemon", "Swipe", STANDARD, OTHER, 8, "", new TranslationTextComponent("null"),appliChipSwipemob.get(),swipeMOB.get()),
        TAPMOB("Tapmon", "Tap", STANDARD, OTHER, 8, "", new TranslationTextComponent("null"),appliChipTapmob.get(),tapMOB.get()),
        TAROTMOB("Tarotmon", "Super_Fortune_Telling", SUPER, ENTERTAINMENT, 11500, "", new TranslationTextComponent("null"),appliChipTarotmob.get(),tarotMOB.get()),
        TELLERMOB("Tellermon", "Fortune_Telling", STANDARD, ENTERTAINMENT, 400, "", new TranslationTextComponent("null"),appliChipTellermob.get(),tellerMOB.get()),
        TIMEMOB("Timemon", "Time_Slip", SUPER, TOOL, 10000, "", new TranslationTextComponent("null"),appliChipTimemob.get(),timeMOB.get()),
        TRICKMOB("Trickmon", "Trick", STANDARD, ENTERTAINMENT, 530, "", new TranslationTextComponent("null"),appliChipTrickmob.get(),trickMOB.get()),
        TRIPMOB("Tripmon", "Trip", SUPER, NAVI, 6200, "", new TranslationTextComponent("null"),appliChipTripmob.get(),tripMOB.get()),
        TUBUMOB("Tubumon", "Tweet", STANDARD, SOCIAL, 480, "", new TranslationTextComponent("null"),appliChipTubumob.get(),tubuMOB.get()),
        TUTOMOB("Tutomon", "Commentary", STANDARD, NAVI, 200, "", new TranslationTextComponent("null"),appliChipTutomob.get(),tutoMOB.get()),
        URATEKUMOB("Uratekumon", "Hints_and_Tips", SUPER, GAME, 9000, "", new TranslationTextComponent("null"),appliChipUratekumob.get(),uratekuMOB.get()),
        VEGASMOB("Vegasmon", "Roulette", SUPER, ENTERTAINMENT, 9800, "", new TranslationTextComponent("null"),appliChipVegasmob.get(),vegasMOB.get()),
        VIRUSMOB("Virusmon", "Virus", STANDARD, LIFE, 640, "", new TranslationTextComponent("null"),appliChipVirusmob.get(),virusMOB.get()),
        VJUMPMOB("Vjumpmon", "V_Jump", SUPER, GAME, 5500, "", new TranslationTextComponent("null"),appliChipV_jumpmob.get(),vjumpMOB.get()),
        WARPMOB("Warpmon", "Transmission", SUPER, SYSTEM, 12000, "", new TranslationTextComponent("null"),appliChipWarpmob.get(),warpMOB.get()),
        WARUDAMOB("Warudamon", "Strategy", ULTIMATE, SYSTEM, 88000, "", new TranslationTextComponent("null"),appliChipWarudamob.get(),warudaMOB.get()),
        WATCHMOB("Watchmon", "Watch", STANDARD, TOOL, 160, "", new TranslationTextComponent("null"),appliChipWatchmob.get(),watchMOB.get()),
        WEATHERDRAMOB("Weatherdramon", "Weathers", SUPER, NAVI, 15000, "", new TranslationTextComponent("null"),appliChipWeatherdramob.get(),weatherdraMOB.get()),
        WEATHERMOB("Weathermon", "Weather", STANDARD, NAVI, 1050, "", new TranslationTextComponent("null"),appliChipWeathermob.get(),weatherMOB.get()),
        YADOMOB("Yadomon", "Hotel", STANDARD, NAVI, 470, "", new TranslationTextComponent("null"),appliChipYadomob.get(),yadoMOB.get()),
        nul("Nul","None", AppliFormTypes.FormTypes.__,OTHER,-199302,"NO",new TranslationTextComponent("text.nul"), Items.AIR , woody.get()),
        FAILED("Nul", "failed", AppliFormTypes.FormTypes.__,OTHER, Integer.MAX_VALUE,"FAIL", new TranslationTextComponent("text.nul.failed"), Items.AIR, woody.get()),

        WOODY("Woody", "Temporary", AppliFormTypes.FormTypes.Temp, AppliAttributes.Attributes.GOD, 1, "Temp", new TranslationTextComponent("text.temp"), Items.AIR, woody.get());



        private final String name;
        private final int power;
        private final String application;

        private final AppliFormTypes.FormTypes formTypes;
        private final AppliAttributes.Attributes attributes;

        private final String techniques;
        private final TranslationTextComponent data;

        private final Item appmonchip;

        private final EntityType<? extends AppliEntity> appmon;

        AppmonTypes(String name, String app, AppliFormTypes.FormTypes appliFormTypes, AppliAttributes.Attributes attributes, int power, String techniques, TranslationTextComponent datatable, Item appmonchip, EntityType<? extends AppliEntity> appmon){
            this.name = name;
            this.power = power;
            this.application = app;
            this.attributes = attributes;
            this.formTypes = appliFormTypes;
            this.techniques = techniques;
            this.data = datatable;
            this.appmonchip = appmonchip;
            this.appmon = appmon;
        }


        @Override
        public @NotNull String getSerializedName() {
            return this.name;
        }

        public int getPower() {
            return this.power;
        }

        public String getApplication() {
            return new TranslationTextComponent("application." + this.application).getString();
        }

        public String getApplicationWithoutTranslation(){
            return this.application;
        }

        public AppliFormTypes.FormTypes getFormTypes() {
            return this.formTypes;
        }

        public AppliAttributes.Attributes getAttributes() {
            return this.attributes;
        }

        public String getTechniques() {
            return this.techniques;
        }

        public TranslationTextComponent getData() {
            return this.data;
        }

        public Item getAppmonchip(){
            return this.appmonchip;
        }

        public EntityType<? extends AppliEntity> getAppmon(){
            return this.appmon;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
