package gq.codephon.digi_applimobs.items.armors;

import gq.codephon.digi_applimobs.group.ModGroup;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class AppliBoots extends ArmorItem {
    public AppliBoots() {
        super(ModArmorMaterial.APPLIINGOT, EquipmentSlotType.FEET, new Properties().tab(ModGroup.itemGroup));
    }
}
