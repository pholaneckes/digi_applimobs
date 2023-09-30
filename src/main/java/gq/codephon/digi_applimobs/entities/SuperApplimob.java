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

public class SuperApplimob extends StandardApplimob{
    public SuperApplimob(EntityType<? extends TameableEntity> type, World worldIn, boolean fly) {
        super(type, worldIn, fly);
    }

    private static final DataParameter<CompoundNBT> STANDARD_FROM = EntityDataManager.defineId(SuperApplimob.class, DataSerializers.COMPOUND_TAG);

    private static final DataParameter<CompoundNBT> STANDARD_LINK_DATA = EntityDataManager.defineId(SuperApplimob.class, DataSerializers.COMPOUND_TAG);

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(STANDARD_FROM, new CompoundNBT());
        this.getEntityData().define(STANDARD_LINK_DATA, new CompoundNBT());

    }

    @Override
    public void addAdditionalSaveData(CompoundNBT saveData) {
        super.addAdditionalSaveData(saveData);
        if(!getAppStandard().isEmpty()) {
            saveData.put("Standard_from", this.getAppStandard());
        }
        if(!getLinkStandard().isEmpty()) {
            saveData.put("Standard_Link", this.getLinkStandard());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT saveData) {
        super.readAdditionalSaveData(saveData);
        if(saveData.contains("Standard_from")){
            this.setAppStandard(saveData.getCompound("Standard_from"));
        }
        if(saveData.contains("Standard_Link")){
            this.setLinkStandard(saveData.getCompound("Standard_Link"));
        }
    }

    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld serverWorld, DifficultyInstance difficultyInstance, SpawnReason spawnReason, @Nullable ILivingEntityData livingEntityData, @Nullable CompoundNBT compoundNBT) {
        this.setAppmonMainStandardPower(-1);
        this.setAppmonMainStandardName("null");
        this.setAppmonMainStandardHealth(-1);
        this.setAppmonOffStandardPower(-1);
        this.setAppmonOffStandardName("null");
        this.setAppmonOffStandardHealth(-1);
        return super.finalizeSpawn(serverWorld, difficultyInstance, spawnReason, livingEntityData, compoundNBT);
    }

    public CompoundNBT getAppStandard() {
        return this.getEntityData().get(STANDARD_FROM);
    }

    public void setAppStandard(CompoundNBT tag) {
        this.getEntityData().set(STANDARD_FROM, tag);
    }
    public CompoundNBT getLinkStandard() {
        return this.getEntityData().get(STANDARD_LINK_DATA);
    }

    public void setLinkStandard(CompoundNBT tag) {
        this.getEntityData().set(STANDARD_LINK_DATA, tag);
    }

    public int getAppmonMainStandardPower() {return this.getAppStandard().getInt("standard_main_obj_power");}

    public void setAppmonMainStandardPower(int power) {this.getAppStandard().putInt("standard_main_obj_power", power);}

    public String getAppmonMainStandardName() {return this.getAppStandard().getString("standard_main_obj_name");}

    public void setAppmonMainStandardName(String name) {this.getAppStandard().putString("standard_main_obj_name", name);}

    public float getAppmonMainStandardHealth() {return this.getAppStandard().getFloat("standard_main_obj_health");}

    public void setAppmonMainStandardHealth(float health) {this.getAppStandard().putFloat("standard_main_obj_health", health);}

    public int getAppmonOffStandardPower() {return this.getAppStandard().getInt("standard_off_obj_power");}

    public void setAppmonOffStandardPower(int power) {this.getAppStandard().putInt("standard_off_obj_power", power);}

    public String getAppmonOffStandardName() {return this.getAppStandard().getString("standard_off_obj_name");}

    public void setAppmonOffStandardName(String name) {this.getAppStandard().putString("standard_off_obj_name", name);}

    public float getAppmonOffStandardHealth() {return this.getAppStandard().getFloat("standard_off_obj_health");}

    public void setAppmonOffStandardHealth(float health) {this.getAppStandard().putFloat("standard_off_obj_health", health);}

}
