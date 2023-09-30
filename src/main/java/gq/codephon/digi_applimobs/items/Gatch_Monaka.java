package gq.codephon.digi_applimobs.items;

import gq.codephon.digi_applimobs.group.ModGroup;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Gatch_Monaka extends Item {
    private static final Food food = (new Food.Builder())
            .saturationMod(4)
            .nutrition(7)
            .effect(() -> new EffectInstance(Effects.DAMAGE_BOOST, 13 * 20, 2), 0.95f)
            .alwaysEat()
            .build();

    public Gatch_Monaka() {
        super(new Properties().food(food).tab(ModGroup.itemGroup));
    }
}