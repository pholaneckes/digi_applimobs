package gq.codephon.digi_applimobs.items.tools;

import gq.codephon.digi_applimobs.group.ModGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;

public class AppliShovel extends ShovelItem {
    public AppliShovel() {
        super(ToolTier.APPLIINGOT, 2, -1.1f, new Item.Properties().tab(ModGroup.itemGroup));
    }
}

