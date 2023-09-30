package gq.codephon.digi_applimobs.group;

import gq.codephon.digi_applimobs.items.ItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ChipGroup extends ItemGroup {
    public ChipGroup() {
        super("chip_group");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemRegistry.appliChipGatchmob.get());
    }
}
