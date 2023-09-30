package gq.codephon.digi_applimobs.gui.hud;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import gq.codephon.digi_applimobs.AppliUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

public class DenShiHUD extends AbstractGui {
    private static final ResourceLocation TEX = new ResourceLocation(AppliUtils.MOD_ID,"textures/gui/appli_denshi.png");
    private final Minecraft minecraft;


    public DenShiHUD(MatrixStack matrixStack) {
        this.minecraft = Minecraft.getInstance();
    }

    public void render(float denshi,int height,int width,MatrixStack matrixStack){
        RenderSystem.color4f(1.0f, 1.0f,1.0f,1.0f);
        this.minecraft.getTextureManager().bind(TEX);
        blit(matrixStack, width + 159, height + 98, 0, 0, 64, 64, 64, 64);
        Minecraft.getInstance().font.draw(matrixStack, new TranslationTextComponent("appli.denshi").getString(), width + 160, height + 100, -45479);
        Minecraft.getInstance().font.draw(matrixStack, Float.toString(denshi), width + 160, height + 110, -45479);

    }
}

