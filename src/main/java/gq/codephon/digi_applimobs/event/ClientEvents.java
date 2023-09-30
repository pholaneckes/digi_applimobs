package gq.codephon.digi_applimobs.event;

import gq.codephon.digi_applimobs.entities.EntiReg;
import gq.codephon.digi_applimobs.entities.render.AppliRender;
import gq.codephon.digi_applimobs.entities.render.AppliObjRender;
import gq.codephon.digi_applimobs.liq.FluidReg;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onClientSetupEvent(FMLClientSetupEvent event) {
        //添加渲染注册语句
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.naviMOB.get(), AppliRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.gatchMOB.get(), AppliRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.dogatchMOB.get(), AppliRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.woody.get(), AppliRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.tapMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, (byte) 1));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.onMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "onmob"));

        RenderingRegistry.registerEntityRenderingHandler(EntiReg.callMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "callmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.mailMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "mailmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.tubuMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "tubumob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.gengoMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "gengomob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.addMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "addmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.reviewMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "reviewmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.setMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "setmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.messeMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "messemob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.rocketMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "rocketmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.jetMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "jetmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.weatherMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "weathermob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.compassMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "compassmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.yadoMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "yadomob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.newsMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "newsmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.protecMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "protecmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.hackMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "hackmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.batteriMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "batterimob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.pekoMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "pekomob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.pokoMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "pokomob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.copipeMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "copipemob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.saveMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "savemob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.kabeMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "kabemob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.ecoMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "ecomob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.pipoMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "pipomob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.drawMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "drawmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.tellerMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "tellermob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.musiMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "musimob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.peroriMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "perorimob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.dressMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "dressmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.bookMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "bookmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.gashaMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "gashamob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.luckMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "luckmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.trickMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "trickmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.diceMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "dicemob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.cookMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "cookmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.sleepMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "sleepmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.muscleMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "musclemob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.aidMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "aidmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.moneyMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "moneymob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.spaMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "spamob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.suppleMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "supplemob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.dopeMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "dopemob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.auctioMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "auctiomob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.kakeiMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "kakeimob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.kaiMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "kaimob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.jishoMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "jishomob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.cameraMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "cameramob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.recoMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "recomob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.calcuMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "calcumob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.gomiMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "gomimob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.mirrorMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "mirrormob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.lightMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "lightmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.watchMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "watchmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.diariMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "diarimob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.calendaMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "calendamob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.onpaMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "onpamob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.dokaMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "dokamob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.shotMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "shotmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.cardMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "cardmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.ropureMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "ropuremob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.puzzleMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "puzzlemob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.danceMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "dancemob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.raceMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "racemob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.sociaMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "sociamob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.gossipMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "gossipmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.sukasiMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "sukasimob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.tripMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "tripmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.raidraMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "raidramob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.dezipMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "dezipmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.mienuMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "mienumob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.warpMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "warpmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.effecMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "effecmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.tarotMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "tarotmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.coordeMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "coordemob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.mediaMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "mediamob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.vegasMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "vegasmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.dreamMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "dreammob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.medicMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "medicmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.docMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "docmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.consulMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "consulmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.libraMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "libramob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.timeMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "timemob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.roaMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "roamob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.scorpMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "scorpmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.craftMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "craftmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.dosukoMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "dosukomob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.braMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "bramob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.coachMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "coachmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.globeMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "globemob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.charisMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "charismob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.damedaMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "damedamob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.cometMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "cometmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.reviveMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "revivemob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.warudaMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "warudamob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.enterMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "entermob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.bioMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "biomob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.beautyMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "beautymob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.fakeMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "fakemob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.gaiaMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "gaiamob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.hadesMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "hadesmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.poseidoMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "poseidomob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.kosoMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "kosomob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.tutoMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "tutomob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.denpaMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "denpamob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.jammingMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "jammingmob"));

        RenderingRegistry.registerEntityRenderingHandler(EntiReg.offMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "offmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.logiMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "logimob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.bootMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "bootmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.shutMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "shutmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.rebootMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "rebootmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.jumpplusMOB.get(), AppliRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.guguMOB.get(), AppliRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.flickMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "flick_green"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.danteMOB.get(), AppliRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.deusuMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "deusumob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.dogaMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "dogamob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.logaMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "logamob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.mcMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "mcmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.ouranosMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "ouranosmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.oujaMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "oujamob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.resshaMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "resshamob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.sakusiMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "sakusimob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.santaMOB.get(), AppliRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.sateraMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "sateramob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.speciaMOB.get(), AppliRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.superMOB.get(), AppliRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.swipeMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "swipe_green"));

        RenderingRegistry.registerEntityRenderingHandler(EntiReg.uratekuMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "uratekumob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.virusMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "virusmob"));
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.vjumpMOB.get(), AppliRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntiReg.weatherdraMOB.get(), (EntityRendererManager manager) -> new AppliObjRender(manager, "weatherdramob"));

        RenderTypeLookup.setRenderLayer(FluidReg.netWater.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(FluidReg.netWaterFlowing.get(), RenderType.translucent());
    }

    /*
    @SubscribeEvent
    public static void onClientSetupEvent(FMLClientSetupEvent event){
        event.enqueueWork(()-> {
            Minecraft mc = Minecraft.getInstance();
            EntityRendererManager manager = mc.getEntityRenderDispatcher();
            manager.register(EntiReg.gatchMOB.get(),new GatchRender_Old(manager));
        });
    }
     */
}
