package gq.codephon.digi_applimobs.util;

import com.mojang.blaze3d.matrix.MatrixStack;
import gq.codephon.digi_applimobs.AppliUtils;
import gq.codephon.digi_applimobs.appli_helpers.AppliSetup;
import gq.codephon.digi_applimobs.gui.AppliIconButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.settings.SliderPercentageOption;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

import static net.minecraft.client.gui.AbstractGui.blit;

public class CodeShort {
    public static final ResourceLocation APPLIDATAINTEXTURE = new ResourceLocation(AppliUtils.MOD_ID,"textures/gui/appli_datatable.png");
    public static final ResourceLocation TEXPOWER = new ResourceLocation(AppliUtils.MOD_ID,"textures/gui/applichip/power_line.png");

    public static int power1 , power2, power3 , power4 ,power5, power6;

    public static int xSize = 256;
    public static int ySize = 197;

    public static int lasheng;

    public static int length;

    public static AppliIconButton bigIcon, formIcon, attributesIcon;

    public static AppliIconButton u6, u5 , u4, u3 , u2 , u1 , ub;

    public static Button buttonprev,buttonnext,buttongo;

    public static Widget SliderBar;

    public static AppliIconButton buttona1,buttona2,buttona3,buttona4,buttona5;
    public static AppliIconButton buttonb1,buttonb2,buttonb3,buttonb4,buttonb5;
    public static AppliIconButton buttonc1,buttonc2,buttonc3,buttonc4,buttoncl;

    public static SliderPercentageOption option;


    public static void DigitalNumber(int power){
        if(power < 999999) {
            power1 = power / 100000 % 10;
            power2 = power / 10000 % 10;
            power3 = power / 1000 % 10;
            power4 = power / 100 % 10;
            power5 = power / 10 % 10;
            power6 = power % 10;
        }else {
            power1 = -6;
            power2 = -11;
            power3 = -10;
            power4 = -6;
            power5 = 5;
            power6 = 5;
        }
    }

    public static void AppliDatasRender(MatrixStack matrixStack, int mouseX, int mouthY, float parTicks) {
        SliderBar.render(matrixStack,mouseX,mouthY,parTicks);
        buttona1.render(matrixStack,mouseX,mouthY,parTicks);
        buttona2.render(matrixStack,mouseX,mouthY,parTicks);
        buttona3.render(matrixStack,mouseX,mouthY,parTicks);
        buttona4.render(matrixStack,mouseX,mouthY,parTicks);
        buttona5.render(matrixStack,mouseX,mouthY,parTicks);
        buttonb1.render(matrixStack,mouseX,mouthY,parTicks);
        buttonb2.render(matrixStack,mouseX,mouthY,parTicks);
        buttonb3.render(matrixStack,mouseX,mouthY,parTicks);
        buttonb4.render(matrixStack,mouseX,mouthY,parTicks);
        buttonb5.render(matrixStack,mouseX,mouthY,parTicks);
        buttonc1.render(matrixStack,mouseX,mouthY,parTicks);
        buttonc2.render(matrixStack,mouseX,mouthY,parTicks);
        buttonc3.render(matrixStack,mouseX,mouthY,parTicks);
        buttonc4.render(matrixStack,mouseX,mouthY,parTicks);
        buttoncl.render(matrixStack,mouseX,mouthY,parTicks);
        buttonprev.render(matrixStack,mouseX,mouthY,parTicks);
        buttonnext.render(matrixStack,mouseX,mouthY,parTicks);
        buttongo.render(matrixStack,mouseX,mouthY,parTicks);
    }

    public static void AppliDataInRender(MatrixStack matrixStack, int mouseX, int mouthY, float parTicks, int width) {
        formIcon.render(matrixStack, mouseX, mouthY, parTicks);
        bigIcon.render(matrixStack, mouseX, mouthY, parTicks);
        attributesIcon.render(matrixStack, mouseX, mouthY, parTicks);
        ub.render(matrixStack, mouseX, mouthY, parTicks);
        u1.render(matrixStack, mouseX, mouthY, parTicks);
        u2.render(matrixStack, mouseX, mouthY, parTicks);
        u3.render(matrixStack, mouseX, mouthY, parTicks);
        u4.render(matrixStack, mouseX, mouthY, parTicks);
        u5.render(matrixStack, mouseX, mouthY, parTicks);
        u6.render(matrixStack, mouseX, mouthY, parTicks);
        Minecraft.getInstance().getTextureManager().bind(TEXPOWER);
        blit(matrixStack, width / 2 + 14, 149, 0, 0, length, 46, lasheng, 46);
    }

    public static void AppliInInit(String name,int width){
        bigIcon = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/chip_" + name.replaceAll("MOB", "").toLowerCase() + ".png"), width / 2 - 110, 45, 98, 98, new TranslationTextComponent("gui.button.inner"), "", (button) -> {
        }, 76);
        formIcon = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/forms_" + AppliSetup.AppmonTypes.valueOf(name).getFormTypes().getSerializedName() + ".png"), width / 2 - 108, 152, 34, 34, new TranslationTextComponent("gui.button.inner.form"), new TranslationTextComponent("forms." + AppliSetup.AppmonTypes.valueOf(name).getFormTypes().getSerializedName().toLowerCase()).getString(), (button) -> {
        });
        attributesIcon = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/attri_" + AppliSetup.AppmonTypes.valueOf(name).getAttributes().getSerializedName() + ".png"), width / 2 - 62, 152, 34, 34, new TranslationTextComponent("gui.button.inner.attribute"), new TranslationTextComponent("attributes." + AppliSetup.AppmonTypes.valueOf(name).getAttributes().getSerializedName().toLowerCase()).getString(), (button) -> {
        });
        u1 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/power_"+power1+".png"), width / 2 +10, 157, 12, 18, new TranslationTextComponent("gui.button.inner.u1"), "        ", (button) -> {
        });
        u2 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/power_"+power2+".png"), width / 2 +24, 158, 12, 18, new TranslationTextComponent("gui.button.inner.u2"), "        ", (button) -> {
        });
        u3 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/power_"+power3+".png"), width / 2 +37, 162, 10, 15, new TranslationTextComponent("gui.button.inner.u3"), "        ", (button) -> {
        });
        u4 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/power_"+power4+".png"), width / 2 +48, 163, 10, 15, new TranslationTextComponent("gui.button.inner.u4"), "        ", (button) -> {
        });
        u5 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/power_"+power5+".png"), width / 2 +59, 164, 10, 15, new TranslationTextComponent("gui.button.inner.u5"), "        ", (button) -> {
        });
        u6 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/power_"+power6+".png"), width / 2 +70, 164, 10, 15, new TranslationTextComponent("gui.button.inner.u6"), "        ", (button) -> {
        });
        ub = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/power.png"), width / 2 - 5, 149, 90, 46, new TranslationTextComponent("gui.button.inner.power"), "        ", (button) -> {
        });

    }

    public static void powerLineLength(int force){
        lasheng = 63;
        length = force > 999999 ? 83 + (force-1000000)/150000 : force > 250000 ? 59 + (force-250000)/30000 : force > 100000 ? 50 + (force-100000)/16666 : force > 50000 ? 35 + (force-50000)/3333 : force > 10000 ? 24 + (force-10000)/3636 : force > 5000? 15 + (force-5000)/555 : force >1000 ? 8 + (force-1000)/571 : force > 10 ? (int)Math.ceil(2.0 + force/166.0) : force > 0 ? 1 : 0;

        if(length > 63){
            lasheng = length;
            length = 63;
        }
    }
}
