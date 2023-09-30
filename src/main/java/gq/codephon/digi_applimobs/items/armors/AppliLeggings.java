package gq.codephon.digi_applimobs.items.armors;

import gq.codephon.digi_applimobs.group.ModGroup;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class AppliLeggings extends ArmorItem {
    public AppliLeggings() {
        super(ModArmorMaterial.APPLIINGOT, EquipmentSlotType.LEGS, new Properties().tab(ModGroup.itemGroup));
    }
}
