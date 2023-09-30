package gq.codephon.digi_applimobs.util.varia;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.jetbrains.annotations.Nullable;

@Mod.EventBusSubscriber(modid = "digi_applimobs" , bus = Mod.EventBusSubscriber.Bus.MOD)
public class CapRegHandler {
    @CapabilityInject(AppliDenShiNouRyoku.class)
    public static Capability<AppliDenShiNouRyoku> DENSHINOURYOKU;

    @SubscribeEvent
    public static void onSetupEvent(FMLCommonSetupEvent event){
        event.enqueueWork(()->
        {
            CapabilityManager.INSTANCE.register(AppliDenShiNouRyoku.class,
                    new Capability.IStorage<AppliDenShiNouRyoku>() {
                        @Nullable
                        @Override
                        public INBT writeNBT(Capability<AppliDenShiNouRyoku> capability, AppliDenShiNouRyoku instance, Direction side) {
                            return null;
                        }

                        @Override
                        public void readNBT(Capability<AppliDenShiNouRyoku> capability, AppliDenShiNouRyoku instance, Direction side, INBT nbt) {

                        }
                    },()->null
            );
        });
    }
}
