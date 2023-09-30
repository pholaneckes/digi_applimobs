package gq.codephon.digi_applimobs.items.tools;

import gq.codephon.digi_applimobs.group.ModGroup;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;

public class AppliAxe extends AxeItem {
    public AppliAxe() {
        super(ToolTier.APPLIINGOT, 6, -2.9f, new Item.Properties().tab(ModGroup.itemGroup));
    }
}
