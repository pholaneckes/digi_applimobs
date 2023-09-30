package gq.codephon.digi_applimobs.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class AppliOre extends Block {
    public AppliOre() {
        super(Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(2.9F, 3.2f));
    }
}
