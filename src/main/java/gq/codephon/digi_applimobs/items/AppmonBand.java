package gq.codephon.digi_applimobs.items;

import gq.codephon.digi_applimobs.Digi_Applimobs;
import gq.codephon.digi_applimobs.group.ModGroup;
import gq.codephon.digi_applimobs.gui.inv.band.BandContainer;
import gq.codephon.digi_applimobs.network.tool.ItemCap;
import gq.codephon.digi_applimobs.network.tool.ItemCapW;
import gq.codephon.digi_applimobs.network.tool.PBand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.IItemHandlerModifiable;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class AppmonBand extends Item {

	public AppmonBand() {
		super(new Properties().tab(ModGroup.itemGroup).stacksTo(1));
	}

	@Nonnull
	@Override
	public ActionResult<ItemStack> use(@Nonnull World world, @Nonnull PlayerEntity player, @Nonnull Hand hand) {
		if (!world.isClientSide) {
			NetworkHooks.openGui((ServerPlayerEntity) player, new ContainerProvider(player.getItemInHand(hand), hand), buf -> {
				buf.writeEnum(hand);
				buf.writeByte(player.inventory.selected);
				buf.writeBoolean(false);
			});
		}

		return ActionResult.success(player.getItemInHand(hand));
	}

	public static ItemStack getWithSucItem(PlayerEntity player, NonNullList<ItemStack> inventory) {
		Optional<PBand> cap = Optional.empty();
		for (ItemStack stack : inventory) {
			if (!stack.isEmpty() && stack.getItem() instanceof AppmonBand) {
				if (!cap.isPresent()) {
					cap = player.getCapability(Digi_Applimobs.CAP_FOR_ANY_INV).resolve();
					if (!cap.isPresent()) {
						break;
					}
				}
			}
		}
		return ItemStack.EMPTY;
	}
}