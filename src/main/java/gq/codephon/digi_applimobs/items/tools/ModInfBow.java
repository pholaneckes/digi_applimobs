package gq.codephon.digi_applimobs.items.tools;

import gq.codephon.digi_applimobs.util.varia.AppliDenShiNouRyoku;
import gq.codephon.digi_applimobs.util.varia.CapRegHandler;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.*;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;

import static gq.codephon.digi_applimobs.event.test.CapTest.serverPackSend;

public class ModInfBow extends ShootableItem implements IVanishable {
    public ModInfBow(Item.Properties itemProp) {
        super(itemProp);
    }

    public void releaseUsing(ItemStack item_stack, World world, LivingEntity livEnti, int i4) {
        if (livEnti instanceof PlayerEntity && !world.isClientSide) {
            PlayerEntity playerentity = (PlayerEntity)livEnti;
            LazyOptional<AppliDenShiNouRyoku> capability = playerentity.getCapability(CapRegHandler.DENSHINOURYOKU);
            capability.ifPresent(cpb->{
            boolean flag = true;//playerentity.abilities.instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, item_stack) > 0;
            ItemStack itemstack = playerentity.getProjectile(item_stack);

            int i = this.getUseDuration(item_stack) - i4;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(item_stack, world, playerentity, i, !itemstack.isEmpty() || flag);
            if (i < 0) {
                return;
            }

                itemstack.isEmpty();
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(Items.ARROW);
                }

                float f = getPowerForTime(i);
                if (!((double)f < 0.05D)) {
                    //boolean flag1 = true;//playerentity.abilities.instabuild || (itemstack.getItem() instanceof ArrowItem && ((ArrowItem)itemstack.getItem()).isInfinite(itemstack, item_stack, playerentity));
                    ArrowItem arrowitem = (ArrowItem) (itemstack.getItem() instanceof ArrowItem ? itemstack.getItem() : Items.ARROW);
                    if (arrowitem != Items.TIPPED_ARROW || arrowitem != Items.SPECTRAL_ARROW){
                        arrowitem = (ArrowItem)Items.ARROW;
                    }
                    AbstractArrowEntity abstractarrowentity = arrowitem.createArrow(world, itemstack, playerentity);
                    abstractarrowentity = customArrow(abstractarrowentity);
                    abstractarrowentity.shootFromRotation(playerentity, playerentity.xRot, playerentity.yRot, 0.0F, f * 3.0F, 1.0F);
                    if (f == 0.6F) {
                        abstractarrowentity.setCritArrow(true);
                    }

                    int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, item_stack);
                    if (j > 0) {
                        abstractarrowentity.setBaseDamage(abstractarrowentity.getBaseDamage() + (double)j * 0.5D + 0.5D);
                        cpb.setDenSNR(cpb.getDenSNR()-0.05f);
                    }

                    int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, item_stack);
                    if (k > 0) {
                        abstractarrowentity.setKnockback(k);
                        cpb.setDenSNR(cpb.getDenSNR()-0.05f);
                    }

                    if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, item_stack) > 0) {
                        abstractarrowentity.setSecondsOnFire(100);
                        cpb.setDenSNR(cpb.getDenSNR()-0.15f);
                    }

                    item_stack.hurtAndBreak(1, playerentity, (p_220009_1_) -> {
                        p_220009_1_.broadcastBreakEvent(playerentity.getUsedItemHand());
                    });
                    if (playerentity.abilities.instabuild || itemstack.getItem() != Items.TIPPED_ARROW || (itemstack.getItem() == Items.TIPPED_ARROW && cpb.getDenSNR() >= 25)) {
                            abstractarrowentity.pickup = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
                        if(cpb.getDenSNR() >= 25) {
                            cpb.setDenSNR(cpb.getDenSNR() - 3.5f);
                            serverPackSend(playerentity,cpb);
                        }else {itemstack.shrink(1);}
                        }

                    world.addFreshEntity(abstractarrowentity);
                    if (itemstack.getItem() == Items.TIPPED_ARROW) {
                            if(cpb.getDenSNR() >= 25){
                                cpb.setDenSNR(cpb.getDenSNR()-24);
                                //NetworkRegHandler.CHANNEL.send(PacketDistributor.PLAYER.with(()-> (ServerPlayerEntity)playerentity), new Cap(cpb.getDenSNR()));
                                serverPackSend(playerentity,cpb);
                            }else {
                                itemstack.shrink(1);
                            }
                        if (itemstack.isEmpty()) {
                            playerentity.inventory.removeItem(itemstack);
                        }
                    }

                    world.playSound(playerentity, playerentity.getX(), playerentity.getY(), playerentity.getZ(), SoundEvents.ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    playerentity.awardStat(Stats.ITEM_USED.get(this));
                }
            });
        }
    }

    public static float getPowerForTime(int forTime) {
        float f = (float)forTime / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    @Override
    public int getUseDuration(ItemStack itemstack) {
        return 72000;
    }

    @Override
    public UseAction getUseAnimation(ItemStack itemstackA) {
        return UseAction.BOW;
    }

    //@OnlyIn(Dist.CLIENT)
    public boolean isPowerOff(PlayerEntity player){
        AtomicBoolean isPowerOver = new AtomicBoolean(false);
            LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(CapRegHandler.DENSHINOURYOKU);
            capability.ifPresent(cpb -> {
                isPowerOver.set(!(cpb.getDenSNR() >= 25));
                if(cpb.getDenSNR() >= 25){
                    cpb.setDenSNR(cpb.getDenSNR()-1f);
                }
            });
            return isPowerOver.get();
    }

    public void setBowDamage(ItemStack itemStack, PlayerEntity player){
        LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(CapRegHandler.DENSHINOURYOKU);
        capability.ifPresent(cpb -> {
            int dsnrNow = (int)cpb.getDenSNR();
            int dsnrSet = Math.max(0,dsnrNow <=3 ? (itemStack.getMaxDamage()-(itemStack.getMaxDamage()-5)) : itemStack.getMaxDamage()-dsnrNow-1);
            itemStack.setDamageValue(dsnrSet);
        });
    }

    @Override
    public ActionResult<ItemStack> use(World worldUse, PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        boolean flag = !player.getProjectile(itemstack).isEmpty();

        ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldUse, player, hand, flag);
        if (ret != null) return ret;


        if (!player.abilities.instabuild && !flag && isPowerOff(player)) {
            return ActionResult.fail(itemstack);
        } else {
            player.startUsingItem(hand);
            setBowDamage(itemstack,player);
            return ActionResult.consume(itemstack);
        }
    }


    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_ONLY;
    }

    public AbstractArrowEntity customArrow(AbstractArrowEntity arrow) {
        return arrow;
    }

    @Override
    public int getDefaultProjectileRange() {
        return 15;
    }
}
