package gq.codephon.digi_applimobs.items.tools;

import gq.codephon.digi_applimobs.group.ModGroup;
import net.minecraft.item.*;

public class AppliPickaxe extends PickaxeItem {
    public AppliPickaxe() {
        super(ToolTier.APPLIINGOT, 3, -2.7f, new Item.Properties().tab(ModGroup.itemGroup));
    }
}

