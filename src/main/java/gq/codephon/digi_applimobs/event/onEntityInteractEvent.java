package gq.codephon.digi_applimobs.event;

import gq.codephon.digi_applimobs.entities.AppliEntity;
import gq.codephon.digi_applimobs.items.ItemRegistry;
import net.minecraft.util.Hand;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static gq.codephon.digi_applimobs.entities.AppliEntity.EMOTION;
import static gq.codephon.digi_applimobs.event.AppliTickEvent.doTick;

@Mod.EventBusSubscriber(modid = "digi_applimobs", bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class onEntityInteractEvent {

    public static int doFeedTimes = -1;

    @SubscribeEvent
    public static void onEntityInteract(PlayerInteractEvent.EntityInteractSpecific event){
        if (event.getTarget() instanceof AppliEntity) {
            if (event.getHand() == Hand.MAIN_HAND) {
                if (event.getItemStack().getItem() == ItemRegistry.gatch_monaka.get()) {
                    if (!event.getWorld().isClientSide) {
                        if(!((AppliEntity) event.getTarget()).isTame()) {
                            ((AppliEntity) event.getTarget()).tameAppli(event.getPlayer());
                        }
                        event.getTarget().getEntityData().set(EMOTION,"haha");
                        event.getItemStack().shrink(1);
                        ((AppliEntity) event.getTarget()).setAppmonPower(((AppliEntity) event.getTarget()).getAppmonPower()+1);
                        doFeedTimes ++;
                        doTick(55,"changeEmoToNormal", event.getTarget(), doFeedTimes);
                    }
                }
            }
        }
    }
    /*
    @SubscribeEvent
    public static void onClientSetupEvent(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
        });
    }
     */
}



