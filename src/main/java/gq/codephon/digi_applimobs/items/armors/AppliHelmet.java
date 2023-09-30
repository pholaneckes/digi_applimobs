package gq.codephon.digi_applimobs.items.armors;

import gq.codephon.digi_applimobs.group.ModGroup;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class AppliHelmet extends ArmorItem {
    public AppliHelmet() {
        super(ModArmorMaterial.APPLIINGOT, EquipmentSlotType.HEAD, new Properties().tab(ModGroup.itemGroup));
    }
}
