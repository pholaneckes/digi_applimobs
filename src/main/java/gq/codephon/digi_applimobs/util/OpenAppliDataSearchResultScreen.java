package gq.codephon.digi_applimobs.util;

import gq.codephon.digi_applimobs.gui.screen.AppliDataSearchResultScreen;
import gq.codephon.digi_applimobs.gui.screen.AppliDatatableInnerScreen;
import net.minecraft.client.Minecraft;

public class OpenAppliDataSearchResultScreen {

    public static byte pageSADB = 0;
    public OpenAppliDataSearchResultScreen() {
        AppliDatatableInnerScreen.isFailed = false;
        Minecraft.getInstance().setScreen(new AppliDataSearchResultScreen());
    }
}
