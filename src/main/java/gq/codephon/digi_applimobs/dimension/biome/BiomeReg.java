package gq.codephon.digi_applimobs.dimension.biome;

import gq.codephon.digi_applimobs.AppliUtils;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class BiomeReg {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, AppliUtils.MOD_ID);
    static {
        createBiome("appli_mainland", BiomeMaker::theVoidBiome);
        createBiome("net_umi", BiomeMaker::theVoidBiome);
    }
    public static RegistryKey<Biome> APPLI_MAIN_BIOME = registerBiome("appli_mainland");
    public static RegistryKey<Biome> NET_SEA_BIOME = registerBiome("net_umi");
    public static RegistryKey<Biome> registerBiome(String biomeName) {
        return RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(AppliUtils.MOD_ID, biomeName));
    }
    public static RegistryObject<Biome> createBiome(String biomeName, Supplier<Biome> biome) {
        return BIOMES.register(biomeName, biome);
    }
    public static void registerBiomes() {
    //    BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(APPLI_MAIN_BIOME, 60));
    //    BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(NET_SEA_BIOME, 40));
    }
}
