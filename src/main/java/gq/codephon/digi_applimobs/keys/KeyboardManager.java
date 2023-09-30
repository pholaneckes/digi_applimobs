package gq.codephon.digi_applimobs.keys;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import java.util.ArrayList;
import java.util.List;

public class KeyboardManager {
    public static final List<KeyBinding> KEY_BINDINGS = new ArrayList<>();
    public static final KeyBinding OPEN_APPLIDATATABLE_KEY = new AppliKeyBending(new TranslationTextComponent("open_applidatatable").getString(),  299 ,new TranslationTextComponent("key.dga").getString());
    public static final KeyBinding CHOOSE_TO_ATT_APPMON =new AppliKeyBending(new TranslationTextComponent("choose_att").getString(), 39,new TranslationTextComponent("key.dga").getString());
    public static final KeyBinding GO_TO_APPLI_FIELD =new AppliKeyBending(new TranslationTextComponent("go_af").getString(), 298 ,new TranslationTextComponent("key.dga").getString());
    public static final KeyBinding LET_APPLI_ARISE =new AppliKeyBending(new TranslationTextComponent("appli_arise").getString(), 61 ,new TranslationTextComponent("key.dga").getString());
    public static final KeyBinding LET_APPLI_ARISE_BACK =new AppliKeyBending(new TranslationTextComponent("appli_arise_back").getString(), 89 ,new TranslationTextComponent("key.dga").getString());
    public static final KeyBinding CHIP_IN =new AppliKeyBending(new TranslationTextComponent("appmon_chip_put_in").getString(), 79 ,new TranslationTextComponent("key.dga").getString());
    public static final KeyBinding APPMON_LINK_OR_GATTAI = new AppliKeyBending(new TranslationTextComponent("link_or_gattai").getString(),75,new TranslationTextComponent("key.dga").getString());


    @OnlyIn(Dist.CLIENT)
    public static void init() {
        for (KeyBinding key: KEY_BINDINGS) {
            ClientRegistry.registerKeyBinding(key);
        }
    }
}
