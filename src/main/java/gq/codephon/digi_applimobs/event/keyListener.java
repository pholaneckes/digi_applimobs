package gq.codephon.digi_applimobs.event;

import gq.codephon.digi_applimobs.network.NetworkRegHandler;
import gq.codephon.digi_applimobs.network.SendPack;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static gq.codephon.digi_applimobs.items.AppliDrive.appmonWithOwnerPointed;
import static gq.codephon.digi_applimobs.keys.KeyboardManager.*;

@Mod.EventBusSubscriber(modid = "digi_applimobs", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class keyListener {
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onKeyPressed(InputEvent.KeyInputEvent event) {
        if (Minecraft.getInstance().screen == null) {
            if (event.getKey() == CHOOSE_TO_ATT_APPMON.getKey().getValue()){
                if(event.getAction() == 0 && Minecraft.getInstance().getCameraEntity() instanceof PlayerEntity) {
                    NetworkRegHandler.CHANNEL.sendToServer(new SendPack(Minecraft.getInstance().getCameraEntity().getUUID(), (short) 2));
                }
            }
            if(event.getKey() == CHIP_IN.getKey().getValue()) {
                if(event.getAction() == 0) {
                    PlayerEntity player = Minecraft.getInstance().player;
                    if (player != null){
                        NetworkRegHandler.CHANNEL.sendToServer(new SendPack(player.getUUID(), (short) 3));
                    }
                }
            }
            if(event.getKey() == LET_APPLI_ARISE.getKey().getValue()){
                if(event.getAction() == 0) {
                    PlayerEntity player = Minecraft.getInstance().player;
                    if (player != null) {
                        NetworkRegHandler.CHANNEL.sendToServer(new SendPack(player.getUUID(), (short) 4));
                    }
                }
            }else if(event.getKey() == LET_APPLI_ARISE_BACK.getKey().getValue() && appmonWithOwnerPointed != null){
                if(event.getAction() == 0) {
                    PlayerEntity player = Minecraft.getInstance().player;
                    if (player != null && appmonWithOwnerPointed != null) {
                        NetworkRegHandler.CHANNEL.sendToServer(new SendPack(player.getUUID(), (short) 5));
                    }
                }
            }
            if(event.getKey() == GO_TO_APPLI_FIELD.getKey().getValue()){
                if(event.getAction() == 0) {
                    PlayerEntity player = Minecraft.getInstance().player;
                    if (player != null) {
                        NetworkRegHandler.CHANNEL.sendToServer(new SendPack(player.getUUID(), (short) 6));
                    }
                }
            }
            if (event.getKey() == APPMON_LINK_OR_GATTAI.getKey().getValue()){
                if(event.getAction() == 0){
                    PlayerEntity player = Minecraft.getInstance().player;
                    if (player != null) {
                        NetworkRegHandler.CHANNEL.sendToServer(new SendPack(player.getUUID(), (short) 7));
                    }
                }
            }
        }
    }


/*
    public static void setAppmonOwner(){
        System.out.println("011");
        if(appmon!=null && ((AppliEntity) appmon).getOwner() instanceof ServerPlayerEntity) {
            appmonOwner = (ServerPlayerEntity) ((AppliEntity) appmon).getOwner();
            System.out.println("231" + appmonOwner);
        }
    }

 */
}
