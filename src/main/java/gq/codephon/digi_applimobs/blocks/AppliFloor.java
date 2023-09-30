package gq.codephon.digi_applimobs.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class AppliFloor extends Block {
    public AppliFloor() {
        super(Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.1F, 9f).sound(SoundType.NETHERRACK));
    }
}
