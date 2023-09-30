package gq.codephon.digi_applimobs.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import gq.codephon.digi_applimobs.AppliUtils;
import gq.codephon.digi_applimobs.gui.container.TodoContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


@OnlyIn(Dist.CLIENT)
public class TodoScreen extends ContainerScreen<TodoContainer> {

    private static final ResourceLocation TEXGUI = new ResourceLocation(AppliUtils.MOD_ID,"/textures/gui/appli_datatable.png");

    public TodoScreen(TodoContainer todoContainer, PlayerInventory inventory, ITextComponent component) {
        super(todoContainer,inventory,component);
        this.leftPos = 0;
        this.topPos = 0;
        this.imageWidth = 176;
        this.imageHeight = 176;
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouthY, float parTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack,mouseX,mouthY,parTicks);
    }

    @Override
    protected void renderBg(MatrixStack matrixStack, float parTick, int MouseX, int MouseY) {
        RenderSystem.color4f(1.0f,1.0f,1.0f,1.0f);
        this.minecraft.textureManager.bind(TEXGUI);

        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) /2;

        this.blit(matrixStack,x,y,0,0,this.imageWidth,this.imageHeight);
    }
}
