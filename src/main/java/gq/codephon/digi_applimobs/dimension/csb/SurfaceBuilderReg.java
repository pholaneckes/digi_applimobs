package gq.codephon.digi_applimobs.dimension.csb;

import gq.codephon.digi_applimobs.AppliUtils;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SurfaceBuilderReg {
    public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, AppliUtils.MOD_ID);

    public static final RegistryObject<CSurfaceBuilderAppliMain> MAIN_SURFACE_BUILDER = SURFACE_BUILDERS.register("appli_mainland_csb",
            () -> new CSurfaceBuilderAppliMain(SurfaceBuilderConfig.CODEC));
    public static final RegistryObject<CSurfaceBuilderNetSea> SEA_SURFACE_BUILDER = SURFACE_BUILDERS.register("net_umi_csb",
            () -> new CSurfaceBuilderNetSea(SurfaceBuilderConfig.CODEC));
}
