package gq.codephon.digi_applimobs.items;

import gq.codephon.digi_applimobs.entities.AppliEntity;
import gq.codephon.digi_applimobs.group.ModGroup;
import gq.codephon.digi_applimobs.gui.screen.AppliStatsScreen;
import gq.codephon.digi_applimobs.keys.KeyboardManager;
import gq.codephon.digi_applimobs.network.NetworkRegHandler;
import gq.codephon.digi_applimobs.network.SendPack;
import gq.codephon.digi_applimobs.util.OpenAppliGui;
import gq.codephon.digi_applimobs.util.Ways;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.network.PacketDistributor;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AppliDrive extends Item {
    public AppliDrive(){
        super(new Properties().tab(ModGroup.itemGroup).stacksTo(1));
    }
    public static Entity appmon;
    public static AppliEntity appmonWithOwnerPointed;
    //public static ServerPlayerEntity appmonOwner;

    public static ServerWorld pubServerworld;


    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if(world instanceof ServerWorld){
            pubServerworld = (ServerWorld) world;
        }
        if(Ways.getPointedEntity(player, 64.0) != null){
            Entity onLookedEnti = Ways.getPointedEntity(player, 64.0);
            if (onLookedEnti instanceof AppliEntity){
                appmon = onLookedEnti;
                if (((AppliEntity) appmon).isTame()) {
                    appmonWithOwnerPointed = (AppliEntity)appmon;
                }
            }
        }
        if (!world.isClientSide && appmon instanceof AppliEntity) {
            if(player.isShiftKeyDown()) {
                int appmonPower = ((AppliEntity) appmon).getAppmonPower();
                NetworkRegHandler.CHANNEL.send(
                        PacketDistributor.PLAYER.with(
                                () -> (ServerPlayerEntity) player
                        ),
                        new SendPack(appmon.getUUID(), appmonPower, (short) 1));
            }
        }
        //if(world.isClientSide && player.isShiftKeyDown() && appmon instanceof AppliEntity){
        //    int power = ((AppliEntity) appmon).getAppmonPower();
        //    System.out.println(power);
        //}
        if(world.isClientSide && KeyboardManager.OPEN_APPLIDATATABLE_KEY.isDown())
        {
            if (!player.isShiftKeyDown()){
                DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliGui::new);
            }
        }
        return super.use(world, player, hand);
    }

    @OnlyIn(Dist.CLIENT)
    public static void OpenAppliStatsGui(AppliEntity entity, int power) {
        if(entity != null) {
            Minecraft.getInstance().setScreen(new AppliStatsScreen(entity,power));
        }
    }

    @Override
    public void inventoryTick(ItemStack itemStack, World worldIn, Entity enti, int i, boolean b) {
        if (!itemStack.hasTag()) {
            itemStack.setTag(new CompoundNBT());
        }

        if(itemStack.getTag().isEmpty()){
            itemStack.getTag().putString("AppmonName", "null");
            itemStack.getTag().putFloat("AppmonHP", -1);
            itemStack.getTag().putInt("AppmonPower", -1);
            itemStack.getTag().putUUID("Owner", enti.getUUID());
        }
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable World worldIn, List<ITextComponent> componentList, ITooltipFlag flagIn) {
        CompoundNBT nbtTag = itemStack.getTag();
        if (nbtTag != null) {
            if(!nbtTag.getString("AppmonName").equals("null")) {
                componentList.add(new StringTextComponent(new TranslationTextComponent("text.chip.in").getString() + new TranslationTextComponent("entity.digi_applimobs." + nbtTag.getString("AppmonName").toLowerCase()).getString()));
                componentList.add(new StringTextComponent(new TranslationTextComponent("text.power").getString() + nbtTag.getInt("AppmonPower")));
                componentList.add(new StringTextComponent(new TranslationTextComponent("text.hp").getString() + nbtTag.getFloat("AppmonHP")));
            }else {
                componentList.add(new StringTextComponent(new TranslationTextComponent("text.empty.in").getString()));
            }
        }
    }
}
