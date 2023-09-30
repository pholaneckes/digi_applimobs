package gq.codephon.digi_applimobs.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import gq.codephon.digi_applimobs.AppliUtils;
import gq.codephon.digi_applimobs.appli_helpers.AppliCNSupports;
import gq.codephon.digi_applimobs.appli_helpers.AppliSetup;
import gq.codephon.digi_applimobs.commnds.AppliInfoCommand;
import gq.codephon.digi_applimobs.gui.AppliIconButton;
import gq.codephon.digi_applimobs.util.OpenAppliDataSearchResultScreen;
import gq.codephon.digi_applimobs.util.OpenAppliGui;
import gq.codephon.digi_applimobs.util.OpenAppliInnerGui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.settings.SliderPercentageOption;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static gq.codephon.digi_applimobs.gui.screen.AppliDatatableInnerScreen.isFailed;
import static gq.codephon.digi_applimobs.gui.screen.AppliDatatableInnerScreen.isSearched;
import static gq.codephon.digi_applimobs.util.CodeShort.*;
import static gq.codephon.digi_applimobs.util.OpenAppliGui.pageADB;

public class AppliDatatableScreen extends Screen {


    TextFieldWidget textFieldWidget;
    Button buttonSearch;
    
    private byte page;

    public AppliDatatableScreen() {
        super(new TranslationTextComponent("appli.datatable.gui"));
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouthY, float parTicks) {
        super.render(matrixStack, mouseX, mouthY, parTicks);
        this.renderBackground(matrixStack);
        RenderSystem.color4f(1.0f,1.0f,1.0f,1.0f);
        this.minecraft.getTextureManager().bind(APPLIDATAINTEXTURE);

        int wid = (this.width - xSize) / 2;
        int hei = (this.height - ySize) / 2;

        this.blit(matrixStack, wid,hei + 2, 0, 0, xSize, ySize);
        drawCenteredString(matrixStack,this.font,new TranslationTextComponent("appli.datatable.gui"),this.width / 2, 34, -45479);
        this.textFieldWidget.render(matrixStack,mouseX,mouthY,parTicks);
        buttonSearch.render(matrixStack,mouseX,mouthY,parTicks);
        AppliDatasRender(matrixStack, mouseX, mouthY, parTicks);
    }

    @Override
    public void init() {
        super.init();
        this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
        AppliDataSearchResultScreen.searchResultList = new ArrayList<>();
        isSearched = false;
        this.textFieldWidget = new TextFieldWidget(this.font, this.width / 2 - 110, 45, 160, 20, new TranslationTextComponent("appli.gui.search"));
        this.children.add(this.textFieldWidget);
        buttonSearch = new Button(this.width / 2 + 70, 45, 50, 20, new TranslationTextComponent("gui.button.gosearch"), (button) -> {

            if(!this.textFieldWidget.getValue().isEmpty()) {
                String searchValue = this.textFieldWidget.getValue().toUpperCase();
                List<String> searchResult = new ArrayList<>();
                if(!AppliInfoCommand.isEnglish(searchValue)){
                    searchValue = AppliInfoCommand.stringToUnicode(searchValue,false);
                    for (int i = 0; i <= AppliCNSupports.INCNS.length-1; i++){
                        String comp = AppliCNSupports.INCNS[i];
                        if (comp.contains(searchValue)) {
                            searchResult.add(AppliCNSupports.CNS.valueOf(comp).getSerializedName());
                        }
                    }
                }else {
                    for (int i = 0; i <= 135; i++) {
                        String comp = AppliSetup.appmonList[i];
                        if (comp.contains(searchValue)) {
                            searchResult.add(comp);
                        }
                    }
                }
                for (int i = 0;i<=15;i++){searchResult.add("nul");}
                AppliDataSearchResultScreen.searchResultList = searchResult;
                DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliDataSearchResultScreen::new);
            }
        });
        this.addButton(buttonSearch);
        buttona1 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID,"textures/gui/applichip/chip_"+AppliSetup.appmonList[pageADB*15].toLowerCase().replaceAll("mob","")+".png"),this.width / 2 - 110, 70, 35, 35, new TranslationTextComponent("gui.button.a1"), new TranslationTextComponent("entity.digi_applimobs."+AppliSetup.appmonList[pageADB * 15].toLowerCase()).getString().replaceAll("mon",""), (button) -> {
            OpenAppliInnerGui.inner = 0;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addButton(buttona1);
        buttona2 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/chip_"+AppliSetup.appmonList[1+pageADB*15].toLowerCase().replaceAll("mob","")+".png"), this.width / 2 - 65, 70, 35, 35, new TranslationTextComponent("gui.button.a2"), new TranslationTextComponent("entity.digi_applimobs."+AppliSetup.appmonList[1+pageADB * 15].toLowerCase()).getString().replaceAll("mon",""), (button) -> {
            OpenAppliInnerGui.inner = 1;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addButton(buttona2);
        buttona3 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/chip_"+AppliSetup.appmonList[2+pageADB*15].toLowerCase().replaceAll("mob","")+".png"), this.width / 2 - 20, 70, 35, 35, new TranslationTextComponent("gui.button.a3"), new TranslationTextComponent("entity.digi_applimobs."+AppliSetup.appmonList[2+pageADB*15].toLowerCase()).getString().replaceAll("mon",""), (button) -> {
            OpenAppliInnerGui.inner = 2;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addButton(buttona3);
        buttona4 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/chip_"+AppliSetup.appmonList[3+pageADB*15].toLowerCase().replaceAll("mob","")+".png"), this.width / 2 + 25, 70, 35, 35, new TranslationTextComponent("gui.button.a4"), new TranslationTextComponent("entity.digi_applimobs."+AppliSetup.appmonList[3+pageADB*15].toLowerCase()).getString().replaceAll("mon",""), (button) -> {
            OpenAppliInnerGui.inner = 3;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addButton(buttona4);
        buttona5 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/chip_"+AppliSetup.appmonList[4+pageADB*15].toLowerCase().replaceAll("mob","")+".png"), this.width / 2 + 70, 70, 35, 35, new TranslationTextComponent("gui.button.a5"), new TranslationTextComponent("entity.digi_applimobs."+AppliSetup.appmonList[4+pageADB*15].toLowerCase()).getString().replaceAll("mon",""), (button) -> {
            OpenAppliInnerGui.inner = 4;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addButton(buttona5);
        buttonb1 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID,"textures/gui/applichip/chip_"+AppliSetup.appmonList[5+pageADB*15].toLowerCase().replaceAll("mob","")+".png"),this.width / 2 - 110, 110, 35, 35, new TranslationTextComponent("gui.button.b1"), new TranslationTextComponent("entity.digi_applimobs."+AppliSetup.appmonList[5+pageADB*15].toLowerCase()).getString().replaceAll("mon",""), (button) -> {
            OpenAppliInnerGui.inner = 5;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addButton(buttonb1);
        buttonb2 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/chip_"+AppliSetup.appmonList[6+pageADB*15].toLowerCase().replaceAll("mob","")+".png"), this.width / 2 - 65, 110, 35, 35, new TranslationTextComponent("gui.button.b2"), new TranslationTextComponent("entity.digi_applimobs."+AppliSetup.appmonList[6+pageADB*15].toLowerCase()).getString().replaceAll("mon",""), (button) -> {
            OpenAppliInnerGui.inner = 6;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addButton(buttonb2);
        buttonb3 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/chip_"+AppliSetup.appmonList[7+pageADB*15].toLowerCase().replaceAll("mob","")+".png"), this.width / 2 - 20, 110, 35, 35, new TranslationTextComponent("gui.button.b3"), new TranslationTextComponent("entity.digi_applimobs."+AppliSetup.appmonList[7+pageADB*15].toLowerCase()).getString().replaceAll("mon",""), (button) -> {
            OpenAppliInnerGui.inner = 7;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addButton(buttonb3);
        buttonb4 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/chip_"+AppliSetup.appmonList[8+pageADB*15].toLowerCase().replaceAll("mob","")+".png"), this.width / 2 + 25, 110, 35, 35, new TranslationTextComponent("gui.button.b4"), new TranslationTextComponent("entity.digi_applimobs."+AppliSetup.appmonList[8+pageADB*15].toLowerCase()).getString().replaceAll("mon",""), (button) -> {
            OpenAppliInnerGui.inner = 8;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addButton(buttonb4);
        buttonb5 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/chip_"+AppliSetup.appmonList[9+pageADB*15].toLowerCase().replaceAll("mob","")+".png"), this.width / 2 + 70, 110, 35, 35, new TranslationTextComponent("gui.button.b5"), new TranslationTextComponent("entity.digi_applimobs."+AppliSetup.appmonList[9+pageADB*15].toLowerCase()).getString().replaceAll("mon",""), (button) -> {
            OpenAppliInnerGui.inner = 9;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addButton(buttonb5);
        buttonc1 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID,"textures/gui/applichip/chip_"+AppliSetup.appmonList[10+pageADB*15].toLowerCase().replaceAll("mob","")+".png"),this.width / 2 - 110, 150, 35, 35, new TranslationTextComponent("gui.button.c1"), new TranslationTextComponent("entity.digi_applimobs."+AppliSetup.appmonList[10+pageADB*15].toLowerCase()).getString().replaceAll("mon",""), (button) -> {
            OpenAppliInnerGui.inner = 10;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addButton(buttonc1);
        buttonc2 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/chip_"+AppliSetup.appmonList[11+pageADB*15].toLowerCase().replaceAll("mob","")+".png"), this.width / 2 - 65, 150, 35, 35, new TranslationTextComponent("gui.button.c2"), new TranslationTextComponent("entity.digi_applimobs."+AppliSetup.appmonList[11+pageADB*15].toLowerCase()).getString().replaceAll("mon",""), (button) -> {
            OpenAppliInnerGui.inner = 11;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addButton(buttonc2);
        buttonc3 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/chip_"+AppliSetup.appmonList[12+pageADB*15].toLowerCase().replaceAll("mob","")+".png"), this.width / 2 - 20, 150, 35, 35, new TranslationTextComponent("gui.button.c3"), new TranslationTextComponent("entity.digi_applimobs."+AppliSetup.appmonList[12+pageADB*15].toLowerCase()).getString().replaceAll("mon",""), (button) -> {
            OpenAppliInnerGui.inner = 12;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addButton(buttonc3);
        buttoncl = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/chip_"+AppliSetup.appmonList[14+pageADB*15].toLowerCase().replaceAll("mob","")+".png"), this.width / 2 + 70, 150, 35, 35, new TranslationTextComponent("gui.button.c4"), new TranslationTextComponent("entity.digi_applimobs."+AppliSetup.appmonList[14+pageADB*15].toLowerCase()).getString().replaceAll("mon",""), (button) -> {
            OpenAppliInnerGui.inner = 14;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addButton(buttoncl);
        buttonc4 = new AppliIconButton(new ResourceLocation(AppliUtils.MOD_ID, "textures/gui/applichip/chip_"+AppliSetup.appmonList[13+pageADB*15].toLowerCase().replaceAll("mob","")+".png"), this.width / 2 + 25, 150, 35, 35, new TranslationTextComponent("gui.button.c4"), new TranslationTextComponent("entity.digi_applimobs."+AppliSetup.appmonList[13+pageADB*15].toLowerCase()).getString().replaceAll("mon",""), (button) -> {
            OpenAppliInnerGui.inner = 13;
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
        });
        this.addButton(buttonc4);


        option = new SliderPercentageOption("gui.sliderbar", 5, 180, 5, (setting) -> Double.valueOf(0), (setting, value) -> {
            page = (byte)(Math.ceil(value/18)-1);
        }, (gameSettings, sliderPercentageOption1) -> new TranslationTextComponent("(" + page + ") : " + pageADB));
        SliderBar = option.createButton(Minecraft.getInstance().options, this.width / 2 - 120, 185, 120);
        this.children.add(SliderBar);
        buttonprev = new Button(this.width / 2 + 45, 185, 35, 20, new TranslationTextComponent("gui.button.prev"), (button) -> {
            if(pageADB >= 1) {
                pageADB--;
                DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliGui::new);
            }
        });
        this.addButton(buttonprev);
        buttonnext = new Button(this.width / 2 + 85, 185, 35, 20, new TranslationTextComponent("gui.button.next"), (button) -> {
            if(pageADB <= 8) {
                pageADB++;
                DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliGui::new);
            }
        });
        this.addButton(buttonnext);
        buttongo = new Button(this.width / 2 + 5, 185, 35, 20, new TranslationTextComponent("gui.button.go"), (button) -> {
            if(this.textFieldWidget.getValue().isEmpty()) {
                pageADB = page;
                DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliGui::new);
            }else {
                String searchValue = this.textFieldWidget.getValue().toUpperCase().replaceAll("MON","MOB");
                if (AppliInfoCommand.isEnglish(searchValue) && !searchValue.endsWith("MOB")){
                    searchValue = searchValue + "MOB";
                }
                if(ArrayUtils.contains(AppliSetup.appmonList,searchValue)) {
                    short found = 0;
                    for (short i = 0;i<=135;i++){
                        if (Objects.equals(AppliSetup.appmonList[i], searchValue)){
                            found = i;
                            break;
                        }
                    }
                    OpenAppliInnerGui.inner = found % 15;
                    pageADB = (byte) ((found - OpenAppliInnerGui.inner)/15);
                    DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
                }else {
                    isFailed = true;
                    DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenAppliInnerGui::new);
                }
            }
        });
        this.addButton(buttongo);
    }



}
