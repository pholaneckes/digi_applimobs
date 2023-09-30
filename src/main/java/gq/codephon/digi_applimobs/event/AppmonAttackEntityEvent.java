package gq.codephon.digi_applimobs.event;

import gq.codephon.digi_applimobs.entities.AppliEntity;
import gq.codephon.digi_applimobs.entities.models.AppliModel;
import gq.codephon.digi_applimobs.util.NotAppmonException;
import gq.codephon.digi_applimobs.util.Ways;
import gq.codephon.digi_applimobs.util.varia.AppliDenShiNouRyoku;
import gq.codephon.digi_applimobs.util.varia.CapRegHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = "digi_applimobs", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AppmonAttackEntityEvent {
    public static void goAttEnti(AppliEntity attacker, PlayerEntity owner) {
        Entity beAttack;
        if (attacker.isTame() && Objects.equals(attacker.getOwner(), owner)) {
            beAttack = Ways.getPointedEntity(attacker.getOwner(), 64.0);
            PlayerEntity player = (PlayerEntity) attacker.getOwner();
            LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(CapRegHandler.DENSHINOURYOKU);
            capability.ifPresent((cpd)-> {
                float appliDenSNR = cpd.getDenSNR();
                if(appliDenSNR >= 27) {
                    DSNRISEnough(attacker, beAttack);
                }else {
                    player.sendMessage(new StringTextComponent(new TranslationTextComponent("msg.dsnr.not_enorgh").getString()), player.getUUID());
                }
            });
        }
    }

    public static void DSNRISEnough(AppliEntity attacker, Entity beAttack){
        if (beAttack != null && !attacker.equals(beAttack)) {
            if(beAttack instanceof TameableEntity){
                if(((TameableEntity) beAttack).getOwner().equals(attacker.getOwner())){
                    return;
                }
            }
            attacker.setTarget((LivingEntity) beAttack);
            attacker.setAppmonAttTo(beAttack.getId());
            beAttack.hurt(DamageSource.mobAttack(attacker), (float) 0.01);
            PlayerEntity player = (PlayerEntity) attacker.getOwner().getEntity();
            String attackerName, beAttackEntiName;
            if (beAttack instanceof AppliEntity) {
                try {
                    beAttackEntiName = new TranslationTextComponent("entity.digi_applimobs." + AppliModel.getRegAppliEntiNameWithoutModId(beAttack)).getString().toLowerCase();
                } catch (NotAppmonException e) {
                    throw new RuntimeException(e);
                }
            } else if (beAttack instanceof PlayerEntity) {
                beAttackEntiName = new TranslationTextComponent("enti.player") + beAttack.getName().getString();
            } else {
                beAttackEntiName = beAttack.getName().getString();
            }
            try {
                attackerName = AppliModel.getRegAppliEntiNameWithoutModId(attacker).toLowerCase();
            } catch (NotAppmonException e) {
                throw new RuntimeException(e);
            }
            player.sendMessage(new StringTextComponent(new TranslationTextComponent("entity.digi_applimobs." + attackerName).getString() + new TranslationTextComponent("msg.att").getString() + new TranslationTextComponent(beAttackEntiName).getString()), player.getUUID());
        }
    }
}
