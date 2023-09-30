package gq.codephon.digi_applimobs.event;

import com.mojang.blaze3d.matrix.MatrixStack;
import gq.codephon.digi_applimobs.AppliUtils;
import gq.codephon.digi_applimobs.gui.hud.DenShiHUD;
import gq.codephon.digi_applimobs.util.varia.AppliDenShiNouRyoku;
import gq.codephon.digi_applimobs.util.varia.CapRegHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.ArrayUtils;

import static gq.codephon.digi_applimobs.util.varia.Arrows.appliDenryokuItem;

@Mod.EventBusSubscriber
public class ClientRenderHUD {
    private static final ResourceLocation TEX = new ResourceLocation(AppliUtils.MOD_ID,"textures/gui/appli_denshi.png");
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onRenderGameOverlayPost(RenderGameOverlayEvent event) {
        if (!RenderGameOverlayEvent.ElementType.ALL.equals(event.getType())) {
            return;
        }
        int Width = event.getWindow().getGuiScaledWidth();
        int Height = event.getWindow().getGuiScaledHeight();
        int halfWidth = Width / 2;
        int halfheight = Height / 2;
        Minecraft minecraft = Minecraft.getInstance();
        MatrixStack matrixStack = event.getMatrixStack();
        if (minecraft.player != null) {
            ClientPlayerEntity player = minecraft.player;
            if (ArrayUtils.contains(appliDenryokuItem,player.getMainHandItem().getItem())|| ArrayUtils.contains(appliDenryokuItem,player.getOffhandItem().getItem())) {
                LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(CapRegHandler.DENSHINOURYOKU);
                capability.ifPresent((cpb) -> {
                    float denSNR = cpb.getDenSNR();
                    DenShiHUD hud = new DenShiHUD(event.getMatrixStack());
                    hud.render(denSNR,halfheight,halfWidth,matrixStack);
                });
            }
        }
    }
}
