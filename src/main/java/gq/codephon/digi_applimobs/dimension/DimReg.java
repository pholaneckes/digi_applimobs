
package gq.codephon.digi_applimobs.dimension;

import gq.codephon.digi_applimobs.AppliUtils;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

public class DimReg{

    public static final RegistryKey<World> AR_FIELD = RegistryKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation("digi_applimobs","arfield"));
    public static final RegistryKey<DimensionType> AR_FIELD_TYPE =
            RegistryKey.create(Registry.DIMENSION_TYPE_REGISTRY, AR_FIELD.getRegistryName());

    public static void register() {
        System.out.println("Registering Dimensions for " + AppliUtils.MOD_ID);
    }
}

