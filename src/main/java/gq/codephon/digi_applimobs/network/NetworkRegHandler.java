package gq.codephon.digi_applimobs.network;

import gq.codephon.digi_applimobs.AppliUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class NetworkRegHandler {
    public static SimpleChannel CHANNEL;
    private static final String VERSION = "0_CAP";
    private static int ID = 0;
    public static int nextID(){
        return ID++;
    }
    public static void registerMessage(){
        CHANNEL = NetworkRegistry.newSimpleChannel(new ResourceLocation(AppliUtils.MOD_ID, "applicap"),
        ()->VERSION,
                (version)-> version.equals(VERSION),
                (version)-> version.equals(VERSION));
        CHANNEL.registerMessage(nextID(),Cap.class,Cap::encode,Cap::decode,Cap::handlePacket);
        CHANNEL.messageBuilder(SendPack.class, nextID())
                .encoder(SendPack::toBytes)
                .decoder(SendPack::new)
                .consumer(SendPack::handler)
                .add();
    }
}
