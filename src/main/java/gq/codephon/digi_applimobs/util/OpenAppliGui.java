package gq.codephon.digi_applimobs.util;

import gq.codephon.digi_applimobs.gui.screen.AppliDatatableInnerScreen;
import gq.codephon.digi_applimobs.gui.screen.AppliDatatableScreen;
import net.minecraft.client.Minecraft;

public class OpenAppliGui {

    public static byte pageADB = 0;
        public OpenAppliGui() {
            AppliDatatableInnerScreen.isFailed = false;
            Minecraft.getInstance().setScreen(new AppliDatatableScreen());
        }

}
