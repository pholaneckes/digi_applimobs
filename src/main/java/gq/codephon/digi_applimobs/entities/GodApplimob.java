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

public class GodApplimob extends UltimateApplimob{
    public GodApplimob(EntityType<? extends TameableEntity> type, World worldIn, boolean fly) {
        super(type, worldIn, fly);
    }

    private static final DataParameter<CompoundNBT> ULTIMATE_FROM = EntityDataManager.defineId(GodApplimob.class, DataSerializers.COMPOUND_TAG);
    private static final DataParameter<CompoundNBT> OFF_SUPER_FROM = EntityDataManager.defineId(GodApplimob.class, DataSerializers.COMPOUND_TAG);
    private static final DataParameter<CompoundNBT> SUB_STANDARD_FROM = EntityDataManager.defineId(GodApplimob.class, DataSerializers.COMPOUND_TAG);

    private static final DataParameter<CompoundNBT> OFF_SUB_STANDARD_FROM = EntityDataManager.defineId(GodApplimob.class, DataSerializers.COMPOUND_TAG);

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(ULTIMATE_FROM, new CompoundNBT());
        this.getEntityData().define(OFF_SUPER_FROM, new CompoundNBT());
        this.getEntityData().define(SUB_STANDARD_FROM, new CompoundNBT());
        this.getEntityData().define(OFF_SUB_STANDARD_FROM, new CompoundNBT());
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT saveData) {
        super.addAdditionalSaveData(saveData);
        if(!getAppUltimate().isEmpty()) {
            saveData.put("Ultimate_from", this.getAppUltimate());
        }
        if(!getSubStandard().isEmpty()) {
            saveData.put("Sub_standard_from", this.getSubStandard());
        }
        if(!getOffSuper().isEmpty()) {
            saveData.put("Off_super_from", this.getOffSuper());
        }
        if(!getOffSubStandard().isEmpty()) {
            saveData.put("Off_sub_standard_from", this.getOffSubStandard());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT saveData) {
        super.readAdditionalSaveData(saveData);
        if(saveData.contains("Ultimate_from")){
            this.setAppUltimate(saveData.getCompound("Super_from"));
        }
        if(saveData.contains("Sub_standard_from")){
            this.setSubStandard(saveData.getCompound("Sub_standard_from"));
        }
        if(saveData.contains("Off_super_from")){
            this.setOffSuper(saveData.getCompound("Off_super_from"));
        }
        if(saveData.contains("Off_sub_standard_from")){
            this.setOffSubStandard(saveData.getCompound("Off_sub_standard_from"));
        }
    }

    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld serverWorld, DifficultyInstance difficultyInstance, SpawnReason spawnReason, @Nullable ILivingEntityData livingEntityData, @Nullable CompoundNBT compoundNBT) {
        this.setSubAppmonMainStandardPower(-1);
        this.setSubAppmonMainStandardName("null");
        this.setSubAppmonMainStandardHealth(-1);
        this.setSubAppmonOffStandardPower(-1);
        this.setSubAppmonOffStandardName("null");
        this.setSubAppmonOffStandardHealth(-1);
        this.setSubOffAppmonMainStandardPower(-1);
        this.setSubOffAppmonMainStandardName("null");
        this.setSubOffAppmonMainStandardHealth(-1);
        this.setSubOffAppmonOffStandardPower(-1);
        this.setSubOffAppmonOffStandardName("null");
        this.setSubOffAppmonOffStandardHealth(-1);

        this.setOffAppmonMainSuperPower(-1);
        this.setOffAppmonMainSuperName("null");
        this.setOffAppmonMainSuperHealth(-1);
        this.setOffAppmonOffSuperPower(-1);
        this.setOffAppmonOffSuperName("null");
        this.setOffAppmonOffSuperHealth(-1);
        this.setAppmonMainUltimatePower(-1);
        this.setAppmonMainUltimateName("null");
        this.setAppmonMainUltimateHealth(-1);
        this.setAppmonOffUltimatePower(-1);
        this.setAppmonOffUltimateName("null");
        this.setAppmonOffUltimateHealth(-1);
        return super.finalizeSpawn(serverWorld, difficultyInstance, spawnReason, livingEntityData, compoundNBT);
    }

    public CompoundNBT getAppUltimate() {
        return this.getEntityData().get(ULTIMATE_FROM);
    }

    public void setAppUltimate(CompoundNBT tag) {
        this.getEntityData().set(ULTIMATE_FROM, tag);
    }

    public CompoundNBT getSubStandard() {
        return this.getEntityData().get(SUB_STANDARD_FROM);
    }

    public void setSubStandard(CompoundNBT tag) {
        this.getEntityData().set(SUB_STANDARD_FROM, tag);
    }

    public CompoundNBT getOffSuper() {
        return this.getEntityData().get(OFF_SUPER_FROM);
    }

    public void setOffSuper(CompoundNBT tag) {
        this.getEntityData().set(OFF_SUPER_FROM, tag);
    }

    public CompoundNBT getOffSubStandard() {
        return this.getEntityData().get(OFF_SUB_STANDARD_FROM);
    }

    public void setOffSubStandard(CompoundNBT tag) {
        this.getEntityData().set(OFF_SUB_STANDARD_FROM, tag);
    }

    public int getSubAppmonMainStandardPower() {return this.getSubStandard().getInt("standard_main_obj_power");}

    public void setSubAppmonMainStandardPower(int power) {this.getSubStandard().putInt("standard_main_obj_power", power);}

    public String getSubAppmonMainStandardName() {return this.getSubStandard().getString("standard_main_obj_name");}

    public void setSubAppmonMainStandardName(String name) {this.getSubStandard().putString("standard_main_obj_name", name);}

    public float getSubAppmonMainStandardHealth() {return this.getSubStandard().getFloat("standard_main_obj_health");}

    public void setSubAppmonMainStandardHealth(float health) {this.getSubStandard().putFloat("standard_main_obj_health", health);}

    public int getSubAppmonOffStandardPower() {return this.getSubStandard().getInt("standard_off_obj_power");}

    public void setSubAppmonOffStandardPower(int power) {this.getSubStandard().putInt("standard_off_obj_power", power);}

    public String getSubAppmonOffStandardName() {return this.getSubStandard().getString("standard_off_obj_name");}

    public void setSubAppmonOffStandardName(String name) {this.getSubStandard().putString("standard_off_obj_name", name);}

    public float getSubAppmonOffStandardHealth() {return this.getSubStandard().getFloat("standard_off_obj_health");}

    public void setSubAppmonOffStandardHealth(float health) {this.getSubStandard().putFloat("standard_off_obj_health", health);}
    public int getSubOffAppmonMainStandardPower() {return this.getOffSubStandard().getInt("standard_main_obj_power");}

    public void setSubOffAppmonMainStandardPower(int power) {this.getOffSubStandard().putInt("standard_main_obj_power", power);}

    public String getSubOffAppmonMainStandardName() {return this.getOffSubStandard().getString("standard_main_obj_name");}

    public void setSubOffAppmonMainStandardName(String name) {this.getOffSubStandard().putString("standard_main_obj_name", name);}

    public float getSubOffAppmonMainStandardHealth() {return this.getOffSubStandard().getFloat("standard_main_obj_health");}

    public void setSubOffAppmonMainStandardHealth(float health) {this.getOffSubStandard().putFloat("standard_main_obj_health", health);}

    public int getSubOffAppmonOffStandardPower() {return this.getOffSubStandard().getInt("standard_off_obj_power");}

    public void setSubOffAppmonOffStandardPower(int power) {this.getOffSubStandard().putInt("standard_off_obj_power", power);}

    public String getSubOffAppmonOffStandardName() {return this.getOffSubStandard().getString("standard_off_obj_name");}

    public void setSubOffAppmonOffStandardName(String name) {this.getOffSubStandard().putString("standard_off_obj_name", name);}

    public float getSubOffAppmonOffStandardHealth() {return this.getOffSubStandard().getFloat("standard_off_obj_health");}

    public void setSubOffAppmonOffStandardHealth(float health) {this.getOffSubStandard().putFloat("standard_off_obj_health", health);}

    public int getOffAppmonMainSuperPower() {return this.getOffSuper().getInt("super_main_obj_power");}

    public void setOffAppmonMainSuperPower(int power) {this.getOffSuper().putInt("super_main_obj_power", power);}

    public String getOffAppmonMainSuperName() {return this.getOffSuper().getString("super_main_obj_name");}

    public void setOffAppmonMainSuperName(String name) {this.getOffSuper().putString("super_main_obj_name", name);}

    public float getOffAppmonMainSuperHealth() {return this.getOffSuper().getFloat("super_main_obj_health");}

    public void setOffAppmonMainSuperHealth(float health) {this.getOffSuper().putFloat("super_main_obj_health", health);}

    public int getOffAppmonOffSuperPower() {return this.getOffSuper().getInt("super_off_obj_power");}

    public void setOffAppmonOffSuperPower(int power) {this.getOffSuper().putInt("super_off_obj_power", power);}

    public String getOffAppmonOffSuperName() {return this.getOffSuper().getString("super_off_obj_name");}

    public void setOffAppmonOffSuperName(String name) {this.getOffSuper().putString("super_off_obj_name", name);}

    public float getOffAppmonOffSuperHealth() {return this.getOffSuper().getFloat("super_off_obj_health");}

    public void setOffAppmonOffSuperHealth(float health) {this.getOffSuper().putFloat("super_off_obj_health", health);}
    public int getAppmonMainUltimatePower() {return this.getAppUltimate().getInt("ultimate_main_obj_power");}

    public void setAppmonMainUltimatePower(int power) {this.getAppUltimate().putInt("ultimate_main_obj_power", power);}

    public String getAppmonMainUltimateName() {return this.getAppUltimate().getString("ultimate_main_obj_name");}

    public void setAppmonMainUltimateName(String name) {this.getAppUltimate().putString("ultimate_main_obj_name", name);}

    public float getAppmonMainUltimateHealth() {return this.getAppUltimate().getFloat("ultimate_main_obj_health");}

    public void setAppmonMainUltimateHealth(float health) {this.getAppUltimate().putFloat("ultimate_main_obj_health", health);}

    public int getAppmonOffUltimatePower() {return this.getAppUltimate().getInt("ultimate_off_obj_power");}

    public void setAppmonOffUltimatePower(int power) {this.getAppUltimate().putInt("ultimate_off_obj_power", power);}

    public String getAppmonOffUltimateName() {return this.getAppUltimate().getString("ultimate_off_obj_name");}

    public void setAppmonOffUltimateName(String name) {this.getAppUltimate().putString("ultimate_off_obj_name", name);}

    public float getAppmonOffUltimateHealth() {return this.getAppUltimate().getFloat("ultimate_off_obj_health");}

    public void setAppmonOffUltimateHealth(float health) {this.getAppUltimate().putFloat("ultimate_off_obj_health", health);}
}
