package gq.codephon.digi_applimobs.world;

import gq.codephon.digi_applimobs.blocks.BlockReg;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreGen {
    public static void genOres(final BiomeLoadingEvent event){
        if(event.getCategory().equals(Biome.Category.OCEAN) || event.getCategory().equals(Biome.Category.PLAINS) || event.getCategory().equals(Biome.Category.MESA)){
            BiomeGenerationSettingsBuilder generation = event.getGeneration();
            generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                    Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockReg.appliOre.get().defaultBlockState(),
                            3)).decorated(Placement.RANGE.configured
                            (new TopSolidRangeConfig(5,2,17))).squared().count(4));
        }
    }
}
