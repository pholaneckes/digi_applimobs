package gq.codephon.digi_applimobs.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.world.World;

public class Temporary extends AppliEntity{
    public Temporary(EntityType<? extends AppliEntity> type, World worldIn) {super(type, worldIn, true);}

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.43F).add(Attributes.MAX_HEALTH, 43.7D).add(Attributes.ATTACK_DAMAGE, 2.5D);
    }
}