package gq.codephon.digi_applimobs.items.armors;

import gq.codephon.digi_applimobs.group.ModGroup;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class AppliChestplate extends ArmorItem {
    public AppliChestplate() {
        super(ModArmorMaterial.APPLIINGOT, EquipmentSlotType.CHEST, new Properties().tab(ModGroup.itemGroup));
    }
}
