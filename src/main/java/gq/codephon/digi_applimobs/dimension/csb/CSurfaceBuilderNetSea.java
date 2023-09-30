package gq.codephon.digi_applimobs.dimension.csb;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class CSurfaceBuilderNetSea extends SurfaceBuilder<SurfaceBuilderConfig> {
    public static final BlockState AIR = Blocks.AIR.defaultBlockState();
    public static final SurfaceBuilderConfig APPLI_FLOOR_CONFIG = new SurfaceBuilderConfig(AIR,
            AIR, AIR);

    public CSurfaceBuilderNetSea(Codec<SurfaceBuilderConfig> configCodec) {
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
