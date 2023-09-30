package gq.codephon.digi_applimobs.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import gq.codephon.digi_applimobs.appli_helpers.AppliSetup;
import gq.codephon.digi_applimobs.util.CodeShort;
import gq.codephon.digi_applimobs.util.OpenAppliDataSearchResultScreen;
import gq.codephon.digi_applimobs.util.OpenAppliGui;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

import static gq.codephon.digi_applimobs.gui.screen.AppliDataSearchResultScreen.searchResultList;
import static gq.codephon.digi_applimobs.util.CodeShort.*;
import static gq.codephon.digi_applimobs.util.OpenAppliDataSearchResultScreen.pageSADB;
import static gq.codephon.digi_applimobs.util.OpenAppliGui.pageADB;

public class AppliDatatableInnerScreen extends Screen {

    private final int pose;
    Button back;
    public static boolean isSearched = false;
    public static boolean isFailed = false;
    
    public AppliDatatableInnerScreen(byte pose) {
        super(new TranslationTextComponent("appli.datatable.gui"));
        this.pose = pose;
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouthY, float parTicks) {
        super.render(matrixStack, mouseX, mouthY, parTicks);
        this.renderBackground(matrixStack);
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.minecraft.getTextureManager().bind(APPLIDATAINTEXTURE);

        int wid = (this.width - xSize) / 2;
        int hei = (this.height - ySize) / 2;

        this.blit(matrixStack, wid, hei + 2, 0, 0, xSize, ySize);
        drawCenteredString(matrixStack, this.font, new TranslationTextComponent("appli.datatable.gui"), this.width / 2, 34, -45479);
        this.back.render(matrixStack, mouseX, mouthY, parTicks);
        String name;
        if(isFailed) {
            name = "FAILED";
        }else {
            if (isSearched) {
                name = searchResultList.get(pose + pageSADB * 15);
            } else {
                name = AppliSetup.appmonList[pose + pageADB * 15];
            }
        }

        powerLineLength(Math.max(AppliSetup.AppmonTypes.valueOf(name).getPower(), 0));
        AppliDataInRender(matrixStack, mouseX, mouthY, parTicks, this.width);
        drawString(matrixStack, this.font, AppliSetup.AppmonTypes.valueOf(name).getData().getString(), this.width / 2 + 17, 69, 0Xfdeca6);
        drawCenteredString(matrixStack, this.font, new TranslationTextComponent("entity.digi_applimobs." + name.toLowerCase()).getString(), this.width / 2 + 7, 50, 0XFFFFFF);
    }
    

    @Override
    public void init() {
        super.init();
        this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
        this.back = new Button(this.width / 2 + 70, 45, 50, 20, new TranslationTextComponent("gui.button.back"), (button) -> {
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> isSearched ? OpenAppliDataSearchResultScreen::new : OpenAppliGui::new);
        });
        this.addButton(back);
        String name;
        if(isFailed) {
            name = "FAILED";
        }else {
            if (isSearched) {
                name = searchResultList.get(pose + pageSADB * 15);
            } else {
                name = AppliSetup.appmonList[pose + pageADB * 15];
            }
        }
        CodeShort.DigitalNumber(AppliSetup.AppmonTypes.valueOf(name).getPower());
        CodeShort.AppliInInit(name,width);
        this.addButton(bigIcon);
        this.addButton(formIcon);
        this.addButton(attributesIcon);
        this.addButton(u1);
        this.addButton(u2);
        this.addButton(u3);
        this.addButton(u4);
        this.addButton(u5);
        this.addButton(u6);
        this.addButton(ub);
    }
}
