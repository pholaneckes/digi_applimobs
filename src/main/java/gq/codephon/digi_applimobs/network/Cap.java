package gq.codephon.digi_applimobs.network;

import gq.codephon.digi_applimobs.util.varia.AppliDenShiNouRyoku;
import gq.codephon.digi_applimobs.util.varia.CapRegHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class Cap {
    public float dcap;
    public Cap(){}

    public Cap(float fCap){
        this.dcap = fCap;
    }

    public float getDcap() {
        return dcap;
    }

    public static void encode(Cap cap, PacketBuffer buffer){
        buffer.writeFloat(cap.dcap);
    }

    public static Cap decode(PacketBuffer buffer){
        return new Cap(buffer.readFloat());
    }

    public static void handlePacket(Cap c, Supplier<NetworkEvent.Context> contextSupplier){
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(()->{
            onClientCustomPack(c);
        });
        context.setPacketHandled(true);
    }

    @OnlyIn(Dist.CLIENT)
    public static void onClientCustomPack(Cap c){
        Minecraft mc =Minecraft.getInstance();
        ClientPlayerEntity player = mc.player;
        LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(CapRegHandler.DENSHINOURYOKU);
        capability.ifPresent((cpb)->{
            cpb.setDenSNR(c.getDcap());
        });
    }
}
