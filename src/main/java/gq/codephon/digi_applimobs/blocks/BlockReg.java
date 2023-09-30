package gq.codephon.digi_applimobs.blocks;

import gq.codephon.digi_applimobs.AppliUtils;
import gq.codephon.digi_applimobs.liq.FluidReg;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockReg {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AppliUtils.MOD_ID);

    public static final RegistryObject<Block> appliBlock = BLOCKS.register("appli_block", AppliBlock::new);
    public static final RegistryObject<Block> appliOre = BLOCKS.register("appli_ore", AppliOre::new);

    public static final RegistryObject<Block> appliFloor = BLOCKS.register("appli_floor", AppliFloor::new);

    public static final RegistryObject<FlowingFluidBlock> appliNetWater = BLOCKS.register("appli_net_water", () -> new FlowingFluidBlock(FluidReg.netWater, Block.Properties.of(Material.WATER).noCollission().strength(101.0F).noDrops()));

    public static final RegistryObject<Block> BANDTILE = BLOCKS.register("bander", TestBlock::new);
}
