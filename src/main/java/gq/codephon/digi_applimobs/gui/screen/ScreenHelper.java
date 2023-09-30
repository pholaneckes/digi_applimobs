package gq.codephon.digi_applimobs.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;

public class ScreenHelper {
    public static void drawCenteredString(MatrixStack matrix, String text, float x, float y, int color) {
        drawCenteredString(matrix, text, x, y, color, false);
    }

    public static void drawCenteredString(MatrixStack matrix, String text, float x, float y, int color, boolean dropShadow) {
        FontRenderer fontRenderer = (Minecraft.getInstance()).font;
        drawCenteredString(matrix, fontRenderer, text, x, y, color, dropShadow);
    }

    public static void drawCenteredString(MatrixStack matrix, FontRenderer fontRenderer, String text, float x, float y, int color, boolean dropShadow) {
        if (dropShadow) {
            fontRenderer.draw(matrix, text, x - fontRenderer.width(text) / 2.0F, y, color);
        } else {
            fontRenderer.draw(matrix, text, x - fontRenderer.width(text) / 2.0F, y, color);
        }
    }

    public static void drawImageQuad(ResourceLocation texture, MatrixStack matrix, float x, float y, float w, float h, float us, float vs, float ue, float ve, float zLevel) {
        drawImageQuad(texture, matrix, x, y, w, h, us, vs, ue, ve, 1.0F, 1.0F, 1.0F, 1.0F, zLevel);
    }

    public static void drawImageQuad(ResourceLocation texture, MatrixStack matrix, float x, float y, float w, float h, float us, float vs, float ue, float ve, float r, float g, float b, float a, float zLevel) {
        Minecraft.getInstance().getTextureManager().bind(texture);
        int texW = GlStateManager._getTexLevelParameter(3553, 0, 4096);
        int texH = GlStateManager._getTexLevelParameter(3553, 0, 4097);
        float u = ue - us;
        float v = ve - vs;
        matrix.pushPose();
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(770, 771);
        RenderSystem.color4f(r, g, b, a);
        matrix.translate(0.0D, 0.0D, zLevel);
        AbstractGui.blit(matrix, (int)x, (int)y, us * texW, vs * texH, (int)w, (int)h, (u == 1.0F) ? (int)w : texW, (v == 1.0F) ? (int)h : texH);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(770, 771);
        matrix.popPose();
    }

    public static void drawImage(ResourceLocation texture, MatrixStack matrix, float x, float y, float width, float height, float zLevel) {
        drawImageQuad(texture, matrix, x, y, width, height, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, zLevel);
    }

    public static void drawImage(MatrixStack matrix, ResourceLocation texture, float x, float y, float width, float height, float zLevel) {
        drawImageQuad(texture, matrix, x, y, width, height, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, zLevel);
    }

    public static void drawImage(ResourceLocation texture, MatrixStack matrix, float x, float y, float width, float height, float r, float g, float b, float a, float zLevel) {
        drawImageQuad(texture, matrix, x, y, width, height, 0.0F, 0.0F, 1.0F, 1.0F, r, g, b, a, zLevel);
    }

    public static void drawImage(MatrixStack matrix, ResourceLocation texture, float x, float y, float width, float height, float r, float g, float b, float a, float zLevel) {
        drawImageQuad(texture, matrix, x, y, width, height, 0.0F, 0.0F, 1.0F, 1.0F, r, g, b, a, zLevel);
    }
}
