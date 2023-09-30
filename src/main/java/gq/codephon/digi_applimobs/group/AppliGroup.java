package gq.codephon.digi_applimobs.group;

import gq.codephon.digi_applimobs.items.ItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class AppliGroup extends ItemGroup {
    public AppliGroup() {
        super("appli_group");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemRegistry.appliIngot.get());
    }
}

