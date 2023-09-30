package gq.codephon.digi_applimobs.dimension.csb;

import com.mojang.serialization.Codec;
import gq.codephon.digi_applimobs.blocks.BlockReg;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class CSurfaceBuilderAppliMain extends SurfaceBuilder<SurfaceBuilderConfig> {
    public static final BlockState APPLI_Floor = BlockReg.appliFloor.get().defaultBlockState();
    public static final SurfaceBuilderConfig APPLI_FLOOR_CONFIG = new SurfaceBuilderConfig(APPLI_Floor,
            APPLI_Floor, APPLI_Floor);

    public CSurfaceBuilderAppliMain(Codec<SurfaceBuilderConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public void apply(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        if (random.nextInt(1) == 0) {
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
                    defaultFluid, seaLevel, seed, APPLI_FLOOR_CONFIG);
        }
    }
}
