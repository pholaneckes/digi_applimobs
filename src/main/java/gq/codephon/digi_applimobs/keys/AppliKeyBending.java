package gq.codephon.digi_applimobs.keys;

import gq.codephon.digi_applimobs.AppliUtils;
import net.minecraft.client.settings.KeyBinding;

public class AppliKeyBending extends KeyBinding {
    public AppliKeyBending(String description, int keyCode, String category) {
        super(String.format("key.%s.%s", AppliUtils.MOD_ID, description), keyCode, category);
        KeyboardManager.KEY_BINDINGS.add(this);
    }
}
