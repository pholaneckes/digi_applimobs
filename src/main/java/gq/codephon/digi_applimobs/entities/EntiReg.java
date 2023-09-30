package gq.codephon.digi_applimobs.entities;

import gq.codephon.digi_applimobs.AppliUtils;
import gq.codephon.digi_applimobs.entities.temporary.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntiReg {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, AppliUtils.MOD_ID);

    public static final RegistryObject<EntityType<Gatchmob>> gatchMOB =
            ENTITIES.register("gatchmob", ()->EntityType.Builder.of(Gatchmob::new, EntityClassification.CREATURE)
                    .sized(0.9f,2.7f).build("gatchmob"));



    public static final RegistryObject<EntityType<Callmob>> callMOB =
            ENTITIES.register("callmob", ()->EntityType.Builder.of(Callmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("callmob"));
    public static final RegistryObject<EntityType<Mailmob>> mailMOB =
            ENTITIES.register("mailmob", ()->EntityType.Builder.of(Mailmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("mailmob"));
    public static final RegistryObject<EntityType<Tubumob>> tubuMOB =
            ENTITIES.register("tubumob", ()->EntityType.Builder.of(Tubumob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("tubumob"));
    public static final RegistryObject<EntityType<Gengomob>> gengoMOB =
            ENTITIES.register("gengomob", ()->EntityType.Builder.of(Gengomob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("gengomob"));
    public static final RegistryObject<EntityType<Addmob>> addMOB =
            ENTITIES.register("addmob", ()->EntityType.Builder.of(Addmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("addmob"));
    public static final RegistryObject<EntityType<Reviewmob>> reviewMOB =
            ENTITIES.register("reviewmob", ()->EntityType.Builder.of(Reviewmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("reviewmob"));
    public static final RegistryObject<EntityType<Setmob>> setMOB =
            ENTITIES.register("setmob", ()->EntityType.Builder.of(Setmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("setmob"));
    public static final RegistryObject<EntityType<Messemob>> messeMOB =
            ENTITIES.register("messemob", ()->EntityType.Builder.of(Messemob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("messemob"));
    public static final RegistryObject<EntityType<Rocketmob>> rocketMOB =
            ENTITIES.register("rocketmob", ()->EntityType.Builder.of(Rocketmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("rocketmob"));
    public static final RegistryObject<EntityType<Navimob>> naviMOB =
            ENTITIES.register("navimob", ()->EntityType.Builder.of(Navimob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("navimob"));
    public static final RegistryObject<EntityType<Jetmob>> jetMOB =
            ENTITIES.register("jetmob", ()->EntityType.Builder.of(Jetmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("jetmob"));
    public static final RegistryObject<EntityType<Weathermob>> weatherMOB =
            ENTITIES.register("weathermob", ()->EntityType.Builder.of(Weathermob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("weathermob"));
    public static final RegistryObject<EntityType<Compassmob>> compassMOB =
            ENTITIES.register("compassmob", ()->EntityType.Builder.of(Compassmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("compassmob"));
    public static final RegistryObject<EntityType<Yadomob>> yadoMOB =
            ENTITIES.register("yadomob", ()->EntityType.Builder.of(Yadomob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("yadomob"));
    public static final RegistryObject<EntityType<Newsmob>> newsMOB =
            ENTITIES.register("newsmob", ()->EntityType.Builder.of(Newsmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("newsmob"));
    public static final RegistryObject<EntityType<Protecmob>> protecMOB =
            ENTITIES.register("protecmob", ()->EntityType.Builder.of(Protecmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("protecmob"));
    public static final RegistryObject<EntityType<Hackmob>> hackMOB =
            ENTITIES.register("hackmob", ()->EntityType.Builder.of(Hackmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("hackmob"));
    public static final RegistryObject<EntityType<Batterimob>> batteriMOB =
            ENTITIES.register("batterimob", ()->EntityType.Builder.of(Batterimob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("batterimob"));
    public static final RegistryObject<EntityType<Pekomob>> pekoMOB =
            ENTITIES.register("pekomob", ()->EntityType.Builder.of(Pekomob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("pekomob"));
    public static final RegistryObject<EntityType<Pokomob>> pokoMOB =
            ENTITIES.register("pokomob", ()->EntityType.Builder.of(Pokomob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("pokomob"));
    public static final RegistryObject<EntityType<Copipemob>> copipeMOB =
            ENTITIES.register("copipemob", ()->EntityType.Builder.of(Copipemob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("copipemob"));
    public static final RegistryObject<EntityType<Savemob>> saveMOB =
            ENTITIES.register("savemob", ()->EntityType.Builder.of(Savemob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("savemob"));
    public static final RegistryObject<EntityType<Kabemob>> kabeMOB =
            ENTITIES.register("kabemob", ()->EntityType.Builder.of(Kabemob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("kabemob"));
    public static final RegistryObject<EntityType<Ecomob>> ecoMOB =
            ENTITIES.register("ecomob", ()->EntityType.Builder.of(Ecomob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("ecomob"));
    public static final RegistryObject<EntityType<Pipomob>> pipoMOB =
            ENTITIES.register("pipomob", ()->EntityType.Builder.of(Pipomob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("pipomob"));
    public static final RegistryObject<EntityType<Drawmob>> drawMOB =
            ENTITIES.register("drawmob", ()->EntityType.Builder.of(Drawmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("drawmob"));
    public static final RegistryObject<EntityType<Tellermob>> tellerMOB =
            ENTITIES.register("tellermob", ()->EntityType.Builder.of(Tellermob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("tellermob"));
    public static final RegistryObject<EntityType<Musimob>> musiMOB =
            ENTITIES.register("musimob", ()->EntityType.Builder.of(Musimob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("musimob"));
    public static final RegistryObject<EntityType<Perorimob>> peroriMOB =
            ENTITIES.register("perorimob", ()->EntityType.Builder.of(Perorimob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("perorimob"));
    public static final RegistryObject<EntityType<Dressmob>> dressMOB =
            ENTITIES.register("dressmob", ()->EntityType.Builder.of(Dressmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("dressmob"));
    public static final RegistryObject<EntityType<Bookmob>> bookMOB =
            ENTITIES.register("bookmob", ()->EntityType.Builder.of(Bookmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("bookmob"));
    public static final RegistryObject<EntityType<Gashamob>> gashaMOB =
            ENTITIES.register("gashamob", ()->EntityType.Builder.of(Gashamob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("gashamob"));
    public static final RegistryObject<EntityType<Luckmob>> luckMOB =
            ENTITIES.register("luckmob", ()->EntityType.Builder.of(Luckmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("luckmob"));
    public static final RegistryObject<EntityType<Trickmob>> trickMOB =
            ENTITIES.register("trickmob", ()->EntityType.Builder.of(Trickmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("trickmob"));
    public static final RegistryObject<EntityType<Dicemob>> diceMOB =
            ENTITIES.register("dicemob", ()->EntityType.Builder.of(Dicemob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("dicemob"));
    public static final RegistryObject<EntityType<Cookmob>> cookMOB =
            ENTITIES.register("cookmob", ()->EntityType.Builder.of(Cookmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("cookmob"));
    public static final RegistryObject<EntityType<Sleepmob>> sleepMOB =
            ENTITIES.register("sleepmob", ()->EntityType.Builder.of(Sleepmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("sleepmob"));
    public static final RegistryObject<EntityType<Musclemob>> muscleMOB =
            ENTITIES.register("musclemob", ()->EntityType.Builder.of(Musclemob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("musclemob"));
    public static final RegistryObject<EntityType<Aidmob>> aidMOB =
            ENTITIES.register("aidmob", ()->EntityType.Builder.of(Aidmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("aidmob"));
    public static final RegistryObject<EntityType<Moneymob>> moneyMOB =
            ENTITIES.register("moneymob", ()->EntityType.Builder.of(Moneymob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("moneymob"));
    public static final RegistryObject<EntityType<Spamob>> spaMOB =
            ENTITIES.register("spamob", ()->EntityType.Builder.of(Spamob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("spamob"));
    public static final RegistryObject<EntityType<Supplemob>> suppleMOB =
            ENTITIES.register("supplemob", ()->EntityType.Builder.of(Supplemob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("supplemob"));
    public static final RegistryObject<EntityType<Dopemob>> dopeMOB =
            ENTITIES.register("dopemob", ()->EntityType.Builder.of(Dopemob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("dopemob"));
    public static final RegistryObject<EntityType<Auctiomob>> auctioMOB =
            ENTITIES.register("auctiomob", ()->EntityType.Builder.of(Auctiomob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("auctiomob"));
    public static final RegistryObject<EntityType<Kakeimob>> kakeiMOB =
            ENTITIES.register("kakeimob", ()->EntityType.Builder.of(Kakeimob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("kakeimob"));
    public static final RegistryObject<EntityType<Kaimob>> kaiMOB =
            ENTITIES.register("kaimob", ()->EntityType.Builder.of(Kaimob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("kaimob"));
    public static final RegistryObject<EntityType<Jishomob>> jishoMOB =
            ENTITIES.register("jishomob", ()->EntityType.Builder.of(Jishomob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("jishomob"));
    public static final RegistryObject<EntityType<Cameramob>> cameraMOB =
            ENTITIES.register("cameramob", ()->EntityType.Builder.of(Cameramob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("cameramob"));
    public static final RegistryObject<EntityType<Recomob>> recoMOB =
            ENTITIES.register("recomob", ()->EntityType.Builder.of(Recomob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("recomob"));
    public static final RegistryObject<EntityType<Calcumob>> calcuMOB =
            ENTITIES.register("calcumob", ()->EntityType.Builder.of(Calcumob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("calcumob"));
    public static final RegistryObject<EntityType<Gomimob>> gomiMOB =
            ENTITIES.register("gomimob", ()->EntityType.Builder.of(Gomimob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("gomimob"));
    public static final RegistryObject<EntityType<Mirrormob>> mirrorMOB =
            ENTITIES.register("mirrormob", ()->EntityType.Builder.of(Mirrormob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("mirrormob"));
    public static final RegistryObject<EntityType<Lightmob>> lightMOB =
            ENTITIES.register("lightmob", ()->EntityType.Builder.of(Lightmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("lightmob"));
    public static final RegistryObject<EntityType<Watchmob>> watchMOB =
            ENTITIES.register("watchmob", ()->EntityType.Builder.of(Watchmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("watchmob"));
    public static final RegistryObject<EntityType<Diarimob>> diariMOB =
            ENTITIES.register("diarimob", ()->EntityType.Builder.of(Diarimob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("diarimob"));
    public static final RegistryObject<EntityType<Calendamob>> calendaMOB =
            ENTITIES.register("calendamob", ()->EntityType.Builder.of(Calendamob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("calendamob"));
    public static final RegistryObject<EntityType<Onpamob>> onpaMOB =
            ENTITIES.register("onpamob", ()->EntityType.Builder.of(Onpamob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("onpamob"));
    public static final RegistryObject<EntityType<Dokamob>> dokaMOB =
            ENTITIES.register("dokamob", ()->EntityType.Builder.of(Dokamob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("dokamob"));
    public static final RegistryObject<EntityType<Shotmob>> shotMOB =
            ENTITIES.register("shotmob", ()->EntityType.Builder.of(Shotmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("shotmob"));
    public static final RegistryObject<EntityType<Cardmob>> cardMOB =
            ENTITIES.register("cardmob", ()->EntityType.Builder.of(Cardmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("cardmob"));
    public static final RegistryObject<EntityType<Ropuremob>> ropureMOB =
            ENTITIES.register("ropuremob", ()->EntityType.Builder.of(Ropuremob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("ropuremob"));
    public static final RegistryObject<EntityType<Puzzlemob>> puzzleMOB =
            ENTITIES.register("puzzlemob", ()->EntityType.Builder.of(Puzzlemob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("puzzlemob"));
    public static final RegistryObject<EntityType<Dancemob>> danceMOB =
            ENTITIES.register("dancemob", ()->EntityType.Builder.of(Dancemob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("dancemob"));
    public static final RegistryObject<EntityType<Racemob>> raceMOB =
            ENTITIES.register("racemob", ()->EntityType.Builder.of(Racemob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("racemob"));
    public static final RegistryObject<EntityType<Dogatchmob>> dogatchMOB =
            ENTITIES.register("dogatchmob", ()->EntityType.Builder.of(Dogatchmob::new, EntityClassification.CREATURE)
                    .sized(1.0f,2.7f).build("dogatchmob"));
    public static final RegistryObject<EntityType<Sociamob>> sociaMOB =
            ENTITIES.register("sociamob", ()->EntityType.Builder.of(Sociamob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("sociamob"));
    public static final RegistryObject<EntityType<Gossipmob>> gossipMOB =
            ENTITIES.register("gossipmob", ()->EntityType.Builder.of(Gossipmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("gossipmob"));
    public static final RegistryObject<EntityType<Sukasimob>> sukasiMOB =
            ENTITIES.register("sukasimob", ()->EntityType.Builder.of(Sukasimob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("sukasimob"));
    public static final RegistryObject<EntityType<Tripmob>> tripMOB =
            ENTITIES.register("tripmob", ()->EntityType.Builder.of(Tripmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("tripmob"));
    public static final RegistryObject<EntityType<Raidramob>> raidraMOB =
            ENTITIES.register("raidramob", ()->EntityType.Builder.of(Raidramob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("raidramob"));
    public static final RegistryObject<EntityType<Dezipmob>> dezipMOB =
            ENTITIES.register("dezipmob", ()->EntityType.Builder.of(Dezipmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("dezipmob"));
    public static final RegistryObject<EntityType<Mienumob>> mienuMOB =
            ENTITIES.register("mienumob", ()->EntityType.Builder.of(Mienumob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("mienumob"));
    public static final RegistryObject<EntityType<Warpmob>> warpMOB =
            ENTITIES.register("warpmob", ()->EntityType.Builder.of(Warpmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("warpmob"));
    public static final RegistryObject<EntityType<Effecmob>> effecMOB =
            ENTITIES.register("effecmob", ()->EntityType.Builder.of(Effecmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("effecmob"));
    public static final RegistryObject<EntityType<Tarotmob>> tarotMOB =
            ENTITIES.register("tarotmob", ()->EntityType.Builder.of(Tarotmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("tarotmob"));
    public static final RegistryObject<EntityType<Coordemob>> coordeMOB =
            ENTITIES.register("coordemob", ()->EntityType.Builder.of(Coordemob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("coordemob"));
    public static final RegistryObject<EntityType<Mediamob>> mediaMOB =
            ENTITIES.register("mediamob", ()->EntityType.Builder.of(Mediamob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("mediamob"));
    public static final RegistryObject<EntityType<Vegasmob>> vegasMOB =
            ENTITIES.register("vegasmob", ()->EntityType.Builder.of(Vegasmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("vegasmob"));
    public static final RegistryObject<EntityType<Dreammob>> dreamMOB =
            ENTITIES.register("dreammob", ()->EntityType.Builder.of(Dreammob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("dreammob"));
    public static final RegistryObject<EntityType<Medicmob>> medicMOB =
            ENTITIES.register("medicmob", ()->EntityType.Builder.of(Medicmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("medicmob"));
    public static final RegistryObject<EntityType<Docmob>> docMOB =
            ENTITIES.register("docmob", ()->EntityType.Builder.of(Docmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("docmob"));
    public static final RegistryObject<EntityType<Consulmob>> consulMOB =
            ENTITIES.register("consulmob", ()->EntityType.Builder.of(Consulmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("consulmob"));
    public static final RegistryObject<EntityType<Libramob>> libraMOB =
            ENTITIES.register("libramob", ()->EntityType.Builder.of(Libramob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("libramob"));
    public static final RegistryObject<EntityType<Timemob>> timeMOB =
            ENTITIES.register("timemob", ()->EntityType.Builder.of(Timemob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("timemob"));
    public static final RegistryObject<EntityType<Roamob>> roaMOB =
            ENTITIES.register("roamob", ()->EntityType.Builder.of(Roamob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("roamob"));
    public static final RegistryObject<EntityType<Scorpmob>> scorpMOB =
            ENTITIES.register("scorpmob", ()->EntityType.Builder.of(Scorpmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("scorpmob"));
    public static final RegistryObject<EntityType<Craftmob>> craftMOB =
            ENTITIES.register("craftmob", ()->EntityType.Builder.of(Craftmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("craftmob"));
    public static final RegistryObject<EntityType<Dosukomob>> dosukoMOB =
            ENTITIES.register("dosukomob", ()->EntityType.Builder.of(Dosukomob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("dosukomob"));
    public static final RegistryObject<EntityType<Bramob>> braMOB =
            ENTITIES.register("bramob", ()->EntityType.Builder.of(Bramob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("bramob"));
    public static final RegistryObject<EntityType<Coachmob>> coachMOB =
            ENTITIES.register("coachmob", ()->EntityType.Builder.of(Coachmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("coachmob"));
    public static final RegistryObject<EntityType<Globemob>> globeMOB =
            ENTITIES.register("globemob", ()->EntityType.Builder.of(Globemob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("globemob"));
    public static final RegistryObject<EntityType<Charismob>> charisMOB =
            ENTITIES.register("charismob", ()->EntityType.Builder.of(Charismob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("charismob"));
    public static final RegistryObject<EntityType<Damedamob>> damedaMOB =
            ENTITIES.register("damedamob", ()->EntityType.Builder.of(Damedamob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("damedamob"));
    public static final RegistryObject<EntityType<Cometmob>> cometMOB =
            ENTITIES.register("cometmob", ()->EntityType.Builder.of(Cometmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("cometmob"));
    public static final RegistryObject<EntityType<Revivemob>> reviveMOB =
            ENTITIES.register("revivemob", ()->EntityType.Builder.of(Revivemob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("revivemob"));
    public static final RegistryObject<EntityType<Warudamob>> warudaMOB =
            ENTITIES.register("warudamob", ()->EntityType.Builder.of(Warudamob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("warudamob"));
    public static final RegistryObject<EntityType<Entermob>> enterMOB =
            ENTITIES.register("entermob", ()->EntityType.Builder.of(Entermob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("entermob"));
    public static final RegistryObject<EntityType<Biomob>> bioMOB =
            ENTITIES.register("biomob", ()->EntityType.Builder.of(Biomob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("biomob"));
    public static final RegistryObject<EntityType<Beautymob>> beautyMOB =
            ENTITIES.register("beautymob", ()->EntityType.Builder.of(Beautymob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("beautymob"));
    public static final RegistryObject<EntityType<Fakemob>> fakeMOB =
            ENTITIES.register("fakemob", ()->EntityType.Builder.of(Fakemob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("fakemob"));
    public static final RegistryObject<EntityType<Gaiamob>> gaiaMOB =
            ENTITIES.register("gaiamob", ()->EntityType.Builder.of(Gaiamob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("gaiamob"));
    public static final RegistryObject<EntityType<Hadesmob>> hadesMOB =
            ENTITIES.register("hadesmob", ()->EntityType.Builder.of(Hadesmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("hadesmob"));
    public static final RegistryObject<EntityType<Poseidomob>> poseidoMOB =
            ENTITIES.register("poseidomob", ()->EntityType.Builder.of(Poseidomob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("poseidomob"));
    public static final RegistryObject<EntityType<Kosomob>> kosoMOB =
            ENTITIES.register("kosomob", ()->EntityType.Builder.of(Kosomob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("kosomob"));
    public static final RegistryObject<EntityType<Tutomob>> tutoMOB =
            ENTITIES.register("tutomob", ()->EntityType.Builder.of(Tutomob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("tutomob"));
    public static final RegistryObject<EntityType<Denpamob>> denpaMOB =
            ENTITIES.register("denpamob", ()->EntityType.Builder.of(Denpamob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("denpamob"));
    public static final RegistryObject<EntityType<Jammingmob>> jammingMOB =
            ENTITIES.register("jammingmob", ()->EntityType.Builder.of(Jammingmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("jammingmob"));
    public static final RegistryObject<EntityType<Onmob>> onMOB =
            ENTITIES.register("onmob", ()->EntityType.Builder.of(Onmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("onmob"));
    public static final RegistryObject<EntityType<Offmob>> offMOB =
            ENTITIES.register("offmob", ()->EntityType.Builder.of(Offmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("offmob"));
    public static final RegistryObject<EntityType<Logimob>> logiMOB =
            ENTITIES.register("logimob", ()->EntityType.Builder.of(Logimob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("logimob"));
    public static final RegistryObject<EntityType<Bootmob>> bootMOB =
            ENTITIES.register("bootmob", ()->EntityType.Builder.of(Bootmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("bootmob"));
    public static final RegistryObject<EntityType<Shutmob>> shutMOB =
            ENTITIES.register("shutmob", ()->EntityType.Builder.of(Shutmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("shutmob"));
    public static final RegistryObject<EntityType<Rebootmob>> rebootMOB =
            ENTITIES.register("rebootmob", ()->EntityType.Builder.of(Rebootmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("rebootmob"));
    public static final RegistryObject<EntityType<Jumpplusmob>> jumpplusMOB =
            ENTITIES.register("jumpplusmob", ()->EntityType.Builder.of(Jumpplusmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("jumpplusmob"));
    public static final RegistryObject<EntityType<Gugumob>> guguMOB =
            ENTITIES.register("gugumob", ()->EntityType.Builder.of(Gugumob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("gugumob"));
    public static final RegistryObject<EntityType<Flickmob>> flickMOB =
            ENTITIES.register("flickmob", ()->EntityType.Builder.of(Flickmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("flickmob"));
    public static final RegistryObject<EntityType<Dantemob>> danteMOB =
            ENTITIES.register("dantemob", ()->EntityType.Builder.of(Dantemob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("dantemob"));
    public static final RegistryObject<EntityType<Deusumob>> deusuMOB =
            ENTITIES.register("deusumob", ()->EntityType.Builder.of(Deusumob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("deusumob"));
    public static final RegistryObject<EntityType<Dogamob>> dogaMOB =
            ENTITIES.register("dogamob", ()->EntityType.Builder.of(Dogamob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("dogamob"));
    public static final RegistryObject<EntityType<Logamob>> logaMOB =
            ENTITIES.register("logamob", ()->EntityType.Builder.of(Logamob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("logamob"));
    public static final RegistryObject<EntityType<Mcmob>> mcMOB =
            ENTITIES.register("mcmob", ()->EntityType.Builder.of(Mcmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("mcmob"));
    public static final RegistryObject<EntityType<Ouranosmob>> ouranosMOB =
            ENTITIES.register("ouranosmob", ()->EntityType.Builder.of(Ouranosmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("ouranosmob"));
    public static final RegistryObject<EntityType<Oujamob>> oujaMOB =
            ENTITIES.register("oujamob", ()->EntityType.Builder.of(Oujamob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("oujamob"));
    public static final RegistryObject<EntityType<Resshamob>> resshaMOB =
            ENTITIES.register("resshamob", ()->EntityType.Builder.of(Resshamob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("resshamob"));
    public static final RegistryObject<EntityType<Sakusimob>> sakusiMOB =
            ENTITIES.register("sakusimob", ()->EntityType.Builder.of(Sakusimob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("sakusimob"));
    public static final RegistryObject<EntityType<Santamob>> santaMOB =
            ENTITIES.register("santamob", ()->EntityType.Builder.of(Santamob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("santamob"));
    public static final RegistryObject<EntityType<Sateramob>> sateraMOB =
            ENTITIES.register("sateramob", ()->EntityType.Builder.of(Sateramob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("sateramob"));
    public static final RegistryObject<EntityType<Speciamob>> speciaMOB =
            ENTITIES.register("speciamob", ()->EntityType.Builder.of(Speciamob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("speciamob"));
    public static final RegistryObject<EntityType<Supermob>> superMOB =
            ENTITIES.register("supermob", ()->EntityType.Builder.of(Supermob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("supermob"));
    public static final RegistryObject<EntityType<Swipemob>> swipeMOB =
            ENTITIES.register("swipemob", ()->EntityType.Builder.of(Swipemob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("swipemob"));
    public static final RegistryObject<EntityType<Tapmob>> tapMOB =
            ENTITIES.register("tapmob", ()->EntityType.Builder.of(Tapmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,0.65f).build("tapmob"));
    public static final RegistryObject<EntityType<Uratekumob>> uratekuMOB =
            ENTITIES.register("uratekumob", ()->EntityType.Builder.of(Uratekumob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("uratekumob"));
    public static final RegistryObject<EntityType<Virusmob>> virusMOB =
            ENTITIES.register("virusmob", ()->EntityType.Builder.of(Virusmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("virusmob"));
    public static final RegistryObject<EntityType<Vjumpmob>> vjumpMOB =
            ENTITIES.register("vjumpmob", ()->EntityType.Builder.of(Vjumpmob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("vjumpmob"));
    public static final RegistryObject<EntityType<Weatherdramob>> weatherdraMOB =
            ENTITIES.register("weatherdramob", ()->EntityType.Builder.of(Weatherdramob::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("weatherdramob"));


    public static final RegistryObject<EntityType<Temporary>> woody =
            ENTITIES.register("woody", ()->EntityType.Builder.of(Temporary::new, EntityClassification.CREATURE)
                    .sized(0.65f,1.3f).build("woody"));
}
