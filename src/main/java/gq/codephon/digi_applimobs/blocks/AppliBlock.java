package gq.codephon.digi_applimobs.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class AppliBlock extends Block {
    public AppliBlock() {
        super(Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(6.7F, 12f).sound(SoundType.NETHERITE_BLOCK));
    }
}
