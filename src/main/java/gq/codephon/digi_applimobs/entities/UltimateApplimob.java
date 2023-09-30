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

public class UltimateApplimob extends SuperApplimob{
    public UltimateApplimob(EntityType<? extends TameableEntity> type, World worldIn, boolean fly) {
        super(type, worldIn, fly);
    }

    private static final DataParameter<CompoundNBT> SUPER_FROM = EntityDataManager.defineId(UltimateApplimob.class, DataSerializers.COMPOUND_TAG);
    private static final DataParameter<CompoundNBT> OFF_STANDARD_FROM = EntityDataManager.defineId(UltimateApplimob.class, DataSerializers.COMPOUND_TAG);
    private static final DataParameter<CompoundNBT> SUPER_LINK_DATA = EntityDataManager.defineId(UltimateApplimob.class, DataSerializers.COMPOUND_TAG);
    private static final DataParameter<CompoundNBT> OFF_STANDARD_LINK_DATA = EntityDataManager.defineId(UltimateApplimob.class, DataSerializers.COMPOUND_TAG);


    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(SUPER_FROM, new CompoundNBT());
        this.getEntityData().define(OFF_STANDARD_FROM, new CompoundNBT());
        this.getEntityData().define(SUPER_LINK_DATA, new CompoundNBT());
        this.getEntityData().define(OFF_STANDARD_LINK_DATA, new CompoundNBT());
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT saveData) {
        super.addAdditionalSaveData(saveData);
        if(!getAppSuper().isEmpty()) {
            saveData.put("Super_from", this.getAppSuper());
        }
        if(!getOffStandard().isEmpty()) {
            saveData.put("Off_standard_from", this.getOffStandard());
        }
        if(!getLinkSuper().isEmpty()) {
            saveData.put("Super_Link", this.getLinkSuper());
        }
        if(!getLinkOffStandard().isEmpty()) {
            saveData.put("Off_standard_Link", this.getLinkOffStandard());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT saveData) {
        super.readAdditionalSaveData(saveData);
        if(saveData.contains("Super_from")){
            this.setAppSuper(saveData.getCompound("Super_from"));
        }
        if(saveData.contains("Off_standard_from")){
            this.setOffStandard(saveData.getCompound("Off_standard_from"));
        }
        if(saveData.contains("Super_Link")){
            this.setLinkSuper(saveData.getCompound("Super_Link"));
        }
        if(saveData.contains("Off_standard_Link")){
            this.setLinkOffStandard(saveData.getCompound("Off_standard_Link"));
        }
    }

    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld serverWorld, DifficultyInstance difficultyInstance, SpawnReason spawnReason, @Nullable ILivingEntityData livingEntityData, @Nullable CompoundNBT compoundNBT) {
        this.setOffAppmonMainStandardPower(-1);
        this.setOffAppmonMainStandardName("null");
        this.setOffAppmonMainStandardHealth(-1);
        this.setOffAppmonOffStandardPower(-1);
        this.setOffAppmonOffStandardName("null");
        this.setOffAppmonOffStandardHealth(-1);
        this.setAppmonMainSuperPower(-1);
        this.setAppmonMainSuperName("null");
        this.setAppmonMainSuperHealth(-1);
        this.setAppmonOffSuperPower(-1);
        this.setAppmonOffSuperName("null");
        this.setAppmonOffSuperHealth(-1);
        return super.finalizeSpawn(serverWorld, difficultyInstance, spawnReason, livingEntityData, compoundNBT);
    }

    public CompoundNBT getAppSuper() {
        return this.getEntityData().get(SUPER_FROM);
    }

    public void setAppSuper(CompoundNBT tag) {
        this.getEntityData().set(SUPER_FROM, tag);
    }

    public CompoundNBT getOffStandard() {
        return this.getEntityData().get(OFF_STANDARD_FROM);
    }

    public void setOffStandard(CompoundNBT tag) {
        this.getEntityData().set(OFF_STANDARD_FROM, tag);
    }
    public CompoundNBT getLinkSuper() {
        return this.getEntityData().get(SUPER_LINK_DATA);
    }

    public void setLinkSuper(CompoundNBT tag) {
        this.getEntityData().set(SUPER_LINK_DATA, tag);
    }

    public CompoundNBT getLinkOffStandard() {
        return this.getEntityData().get(OFF_STANDARD_LINK_DATA);
    }

    public void setLinkOffStandard(CompoundNBT tag) {
        this.getEntityData().set(OFF_STANDARD_LINK_DATA, tag);
    }

    public int getOffAppmonMainStandardPower() {return this.getOffStandard().getInt("standard_main_obj_power");}

    public void setOffAppmonMainStandardPower(int power) {this.getOffStandard().putInt("standard_main_obj_power", power);}

    public String getOffAppmonMainStandardName() {return this.getOffStandard().getString("standard_main_obj_name");}

    public void setOffAppmonMainStandardName(String name) {this.getOffStandard().putString("standard_main_obj_name", name);}

    public float getOffAppmonMainStandardHealth() {return this.getOffStandard().getFloat("standard_main_obj_health");}

    public void setOffAppmonMainStandardHealth(float health) {this.getOffStandard().putFloat("standard_main_obj_health", health);}

    public int getOffAppmonOffStandardPower() {return this.getOffStandard().getInt("standard_off_obj_power");}

    public void setOffAppmonOffStandardPower(int power) {this.getOffStandard().putInt("standard_off_obj_power", power);}

    public String getOffAppmonOffStandardName() {return this.getOffStandard().getString("standard_off_obj_name");}

    public void setOffAppmonOffStandardName(String name) {this.getOffStandard().putString("standard_off_obj_name", name);}

    public float getOffAppmonOffStandardHealth() {return this.getOffStandard().getFloat("standard_off_obj_health");}

    public void setOffAppmonOffStandardHealth(float health) {this.getOffStandard().putFloat("standard_off_obj_health", health);}

    public int getAppmonMainSuperPower() {return this.getAppSuper().getInt("super_main_obj_power");}

    public void setAppmonMainSuperPower(int power) {this.getAppSuper().putInt("super_main_obj_power", power);}

    public String getAppmonMainSuperName() {return this.getAppSuper().getString("super_main_obj_name");}

    public void setAppmonMainSuperName(String name) {this.getAppSuper().putString("super_main_obj_name", name);}

    public float getAppmonMainSuperHealth() {return this.getAppSuper().getFloat("super_main_obj_health");}

    public void setAppmonMainSuperHealth(float health) {this.getAppSuper().putFloat("super_main_obj_health", health);}

    public int getAppmonOffSuperPower() {return this.getAppSuper().getInt("super_off_obj_power");}

    public void setAppmonOffSuperPower(int power) {this.getAppSuper().putInt("super_off_obj_power", power);}

    public String getAppmonOffSuperName() {return this.getAppSuper().getString("super_off_obj_name");}

    public void setAppmonOffSuperName(String name) {this.getAppSuper().putString("super_off_obj_name", name);}

    public float getAppmonOffSuperHealth() {return this.getAppSuper().getFloat("super_off_obj_health");}

    public void setAppmonOffSuperHealth(float health) {this.getAppSuper().putFloat("super_off_obj_health", health);}
}
