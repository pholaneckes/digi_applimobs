package gq.codephon.digi_applimobs.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import gq.codephon.digi_applimobs.gui.screen.ScreenHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class AppliIconButton extends Button {
    private final ResourceLocation icon;
    private final String name;
    private int dist = 33;

    public AppliIconButton(ResourceLocation icon, int x, int y, int w, int h, ITextComponent text, String name, Button.IPressable action) {
        super(x, y, w, h, text, action);
        this.icon = icon;
        this.name = name;
    }

    public AppliIconButton(ResourceLocation icon, int x, int y, int w, int h, ITextComponent text, String name, Button.IPressable action,int dist) {
        super(x, y, w, h, text, action);
        this.icon = icon;
        this.name = name;
        this.dist = dist;
    }

    public ResourceLocation getIcon() {
        return this.icon;
    }

    @Override
    public void renderButton(MatrixStack matrix, int mx, int my, float pt) {
        Minecraft minecraft = Minecraft.getInstance();
        FontRenderer fontrenderer = minecraft.font;
        int j = this.getFGColor();
        if (this.isMouseOver(mx, my)) {
            ScreenHelper.drawImage(matrix, this.getIcon(), (float)this.x, (float)this.y, (float)this.width, (float)this.height, 1.0F);
        } else {
            ScreenHelper.drawImage(matrix, this.getIcon(), (float)this.x, (float)this.y, (float)this.width, (float)this.height, 1.0F);
        }

        drawCenteredString(matrix, fontrenderer, new TranslationTextComponent(name), this.x+18, this.y +dist,  j | MathHelper.ceil(this.packedFGColor * 255.0F) << 24);
    }
}
