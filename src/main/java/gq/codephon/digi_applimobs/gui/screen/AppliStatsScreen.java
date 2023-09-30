package gq.codephon.digi_applimobs.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import gq.codephon.digi_applimobs.appli_helpers.AppliSetup;
import gq.codephon.digi_applimobs.entities.AppliEntity;
import gq.codephon.digi_applimobs.entities.models.AppliModel;
import gq.codephon.digi_applimobs.util.CodeShort;
import gq.codephon.digi_applimobs.util.NotAppmonException;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.TranslationTextComponent;

import static gq.codephon.digi_applimobs.event.AppliHurtEvent.getAppmonAttStats;
import static gq.codephon.digi_applimobs.util.CodeShort.*;

public class AppliStatsScreen extends Screen {
    private final AppliEntity appmon;
    private final int power;
    public AppliStatsScreen(AppliEntity appli, int power) {
        super(new TranslationTextComponent("appli.datatable.gui"));
        this.appmon = appli;
        this.power = power;
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
        String name;
        try {
            name = AppliModel.getRegAppliEntiNameWithoutModId(appmon);
        } catch (NotAppmonException e) {
            throw new RuntimeException(e);
        }

        AppliEntity appliEntity = appmon;

        powerLineLength(Math.max(power, 0));

        AppliDataInRender(matrixStack, mouseX, mouthY, parTicks, this.width);
        drawCenteredString(matrixStack, this.font, new TranslationTextComponent("entity.digi_applimobs." + name.toLowerCase()).getString(), this.width / 2 + 7, 50, 0XFFFFFF);
        drawString(matrixStack, this.font, new TranslationTextComponent("text.hp").getString() + appliEntity.getHealth() + new TranslationTextComponent("mark.leftdown_to_rightup_line").getString() + AppliEntity.getAppmonHealth(appliEntity.getAppmonPower(),AppliSetup.AppmonTypes.valueOf(name).getFormTypes().getId()), this.width / 2 + 9, 62, 0XFFFFFF);
        drawString(matrixStack, this.font, new TranslationTextComponent("text.att").getString() + getAppmonAttStats(AppliSetup.AppmonTypes.valueOf(name).getFormTypes().getId(), (byte) 4,appliEntity.getAppmonPower()) + new TranslationTextComponent("mark.fromXtoY").getString() + getAppmonAttStats(AppliSetup.AppmonTypes.valueOf(name).getFormTypes().getId(), (byte) 1,power), this.width / 2 + 9, 74, 0XFFFFFF);
    }

    @Override
    public void init() {
        super.init();
        this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
        String name;

        try {
            name = AppliModel.getRegAppliEntiNameWithoutModId(appmon);
        } catch (NotAppmonException e) {
            throw new RuntimeException(e);
        }
        CodeShort.DigitalNumber(power);
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
