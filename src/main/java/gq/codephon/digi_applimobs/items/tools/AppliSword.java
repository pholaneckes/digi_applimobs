package gq.codephon.digi_applimobs.items.tools;

import gq.codephon.digi_applimobs.group.ModGroup;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class AppliSword extends SwordItem {
    public AppliSword() {
        super(ToolTier.APPLIINGOT, 10, -1.8F, new Item.Properties().tab(ModGroup.itemGroup));
    }
}

