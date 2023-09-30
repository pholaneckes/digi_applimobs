package gq.codephon.digi_applimobs;

import gq.codephon.digi_applimobs.blocks.BlockReg;
import gq.codephon.digi_applimobs.dimension.DimReg;
import gq.codephon.digi_applimobs.dimension.biome.BiomeReg;
import gq.codephon.digi_applimobs.dimension.csb.SurfaceBuilderReg;
import gq.codephon.digi_applimobs.entities.EntiReg;
import gq.codephon.digi_applimobs.gui.ContainerReg;
import gq.codephon.digi_applimobs.gui.TileEntiReg;
import gq.codephon.digi_applimobs.gui.inv.band.BandScreen;
import gq.codephon.digi_applimobs.gui.screen.TodoScreen;
import gq.codephon.digi_applimobs.items.ItemRegistry;
import gq.codephon.digi_applimobs.keys.KeyboardManager;
import gq.codephon.digi_applimobs.liq.FluidReg;
import gq.codephon.digi_applimobs.network.NetworkRegHandler;
import gq.codephon.digi_applimobs.network.tool.BandIm;
import gq.codephon.digi_applimobs.network.tool.PBand;
import gq.codephon.digi_applimobs.network.tool.PacketHandler;
import gq.codephon.digi_applimobs.world.OreGen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

import static gq.codephon.digi_applimobs.AppliUtils.ΪɶҪӌŌᐁ_;

@Mod("digi_applimobs")
@Mod.EventBusSubscriber(modid = "digi_applimobs")
public class Digi_Applimobs {
    public Digi_Applimobs() {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemRegistry.ITEMS.register(modEventBus);
        BlockReg.BLOCKS.register(modEventBus);
        EntiReg.ENTITIES.register(modEventBus);
        FluidReg.LIQ.register(modEventBus);

        DimReg.register();
        BiomeReg.BIOMES.register(modEventBus);
        BiomeReg.registerBiomes();
        SurfaceBuilderReg.SURFACE_BUILDERS.register(modEventBus);

        TileEntiReg.TILE_ENTITY_TYPE.register(modEventBus);
        ContainerReg.CONTAINERS.register(modEventBus);

        modEventBus.addListener(this::onCommomSetup);
        modEventBus.addListener(this::onClientSetup);

        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGen::genOres);

        GeckoLib.initialize();

        ΪɶҪӌŌᐁ_();

        //
        MOD_CONTAINER = ModLoadingContext.get().getActiveContainer();
        modEventBus.addListener(this::commonSetup);
    }

    @CapabilityInject(PBand.class)
    public static Capability<PBand> CAP_FOR_ANY_INV;

    public static ModContainer MOD_CONTAINER;

    private void commonSetup(FMLCommonSetupEvent event) {
        BandIm.init();
        event.enqueueWork(PacketHandler::register);
    }

    public void onCommomSetup(FMLCommonSetupEvent event){
        NetworkRegHandler.registerMessage();
    }

    public void onClientSetup(FMLClientSetupEvent event){
        KeyboardManager.init();
        ScreenManager.register(ContainerReg.TODOCONTAINER.get(), TodoScreen::new);
        ScreenManager.register(ContainerReg.BAND_CONTAINER.get(), BandScreen::new);
    }


}
