package gq.codephon.digi_applimobs.liq;

import gq.codephon.digi_applimobs.AppliUtils;
import gq.codephon.digi_applimobs.blocks.BlockReg;
import gq.codephon.digi_applimobs.items.ItemRegistry;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidReg {
    public static final ResourceLocation NET_WATER_TEX = new ResourceLocation(AppliUtils.MOD_ID,"liq/net_water");
    public static final ResourceLocation FLOWING_NET_WATER_TEX = new ResourceLocation(AppliUtils.MOD_ID,"liq/net_water_flow");
    public static final DeferredRegister<Fluid> LIQ = DeferredRegister.create(ForgeRegistries.FLUIDS, AppliUtils.MOD_ID);
    public static final RegistryObject<FlowingFluid> netWater = LIQ.register("appli_net_water",  () -> new ForgeFlowingFluid.Source(FluidReg.PROPERTIES));
    public static final RegistryObject<FlowingFluid> netWaterFlowing = LIQ.register("appli_net_water_flowing",  () -> new ForgeFlowingFluid.Flowing(FluidReg.PROPERTIES));
    public static ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(netWater, netWaterFlowing, FluidAttributes.builder(NET_WATER_TEX, FLOWING_NET_WATER_TEX).color(0x4ED4EED4).density(1350).viscosity(40)).bucket(ItemRegistry.NetFluidBucket).slopeFindDistance(0).explosionResistance(0F).block(BlockReg.appliNetWater);

}
