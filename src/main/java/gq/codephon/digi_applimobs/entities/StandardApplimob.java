package gq.codephon.digi_applimobs.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class StandardApplimob extends AppliEntity{
    public StandardApplimob(EntityType<? extends TameableEntity> type, World worldIn, boolean fly) {
        super(type, worldIn, fly);
    }

    private static final DataParameter<CompoundNBT> APPMON_LINK_OBJ = EntityDataManager.defineId(StandardApplimob.class, DataSerializers.COMPOUND_TAG);

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(APPMON_LINK_OBJ, new CompoundNBT());
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT saveData) {
        super.addAdditionalSaveData(saveData);
        if(!getAppLink().isEmpty()) {
            saveData.put("app_link", this.getAppLink());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT saveData) {
        super.readAdditionalSaveData(saveData);
        if(saveData.contains("app_link")){
            this.setAppLink(saveData.getCompound("app_link"));
        }
    }

    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld serverWorld, DifficultyInstance difficultyInstance, SpawnReason spawnReason, @Nullable ILivingEntityData livingEntityData, @Nullable CompoundNBT compoundNBT) {
        this.setAppmonLinkPower(-1);
        this.setAppmonLinkObjName("null");
        this.setAppmonLinkObjHealth(-1);
        this.setAppliLinkTo(false);
        return super.finalizeSpawn(serverWorld, difficultyInstance, spawnReason, livingEntityData, compoundNBT);
    }

    public CompoundNBT getAppLink() {
        return this.getEntityData().get(APPMON_LINK_OBJ);
    }

    public void setAppLink(CompoundNBT tag) {
        this.getEntityData().set(APPMON_LINK_OBJ, tag);
    }

    public int getAppmonLinkPower() {return this.getAppLink().getInt("link_obj_power");}

    public void setAppmonLinkPower(int power) {this.getAppLink().putInt("link_obj_power", power);}

    public String getAppmonLinkObjName() {return this.getAppLink().getString("link_obj_name");}

    public void setAppmonLinkObjName(String name) {this.getAppLink().putString("link_obj_name", name);}

    public float getAppmonLinkObjHealth() {return this.getAppLink().getFloat("link_obj_health");}

    public void setAppmonLinkObjHealth(float health) {this.getAppLink().putFloat("link_obj_health", health);}
    public boolean isAppliLinked() {return this.getAppmon().getBoolean("be_link");}

    public void setAppliLinkTo(boolean isL) {this.getAppmon().putBoolean("be_link", isL);}
}
