package gq.codephon.digi_applimobs.entities;

import gq.codephon.digi_applimobs.appli_helpers.AppliSetup;
import gq.codephon.digi_applimobs.entities.ai.AppliAttackGoal;
import gq.codephon.digi_applimobs.entities.models.AppliModel;
import gq.codephon.digi_applimobs.util.NotAppmonException;
import gq.codephon.digi_applimobs.util.varia.AppliDenShiNouRyoku;
import gq.codephon.digi_applimobs.util.varia.CapRegHandler;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.Random;

public class AppliEntity extends TameableEntity implements IAnimatable{

    public AnimationFactory factory = GeckoLibUtil.createFactory(this);
    public boolean playWalkingAnimation = true;

    public boolean playFlyingAnimation = true;

    protected boolean canfly;

    public AppliEntity(EntityType<? extends TameableEntity> type, World worldIn, boolean fly) {
        super(type, worldIn);
        this.canfly = fly;
    }

    public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity ageable) {
        return null;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(EMOTION, "normal");
        this.getEntityData().define(APPMON, new CompoundNBT());
        this.getEntityData().define(ATTTYPE, 0);
        this.getEntityData().define(DATA_ATT_ID, -1);
        this.getEntityData().define(IS_APPLIDUOING, false);
    }

    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld serverWorld, DifficultyInstance difficultyInstance, SpawnReason spawnReason, @Nullable ILivingEntityData livingEntityData, @Nullable CompoundNBT compoundNBT) {
        this.getEntityData().set(EMOTION,"normal");
        this.getEntityData().set(ATTTYPE, 0);
        this.getEntityData().set(DATA_ATT_ID, -1);
        this.getEntityData().set(IS_APPLIDUOING, false);
        String name;
        try {
            name = AppliModel.getRegAppliEntiNameWithoutModId(this.getEntity());
        } catch (NotAppmonException e) {
            throw new RuntimeException(e);
        }
        this.setAppmonPower(AppliSetup.AppmonTypes.valueOf(name).getPower());
        this.setHealth(getAppmonHealth(getAppmonPower(), AppliSetup.AppmonTypes.valueOf(name).getFormTypes().getId()));
        return super.finalizeSpawn(serverWorld, difficultyInstance, spawnReason, livingEntityData, compoundNBT);
    }

    public static final DataParameter<String> EMOTION = EntityDataManager.defineId(AppliEntity.class, DataSerializers.STRING);
    private static final DataParameter<CompoundNBT> APPMON = EntityDataManager.defineId(AppliEntity.class, DataSerializers.COMPOUND_TAG);
    public static final DataParameter<Integer> ATTTYPE = EntityDataManager.defineId(AppliEntity.class, DataSerializers.INT);
    protected static final DataParameter<Integer> DATA_ATT_ID = EntityDataManager.defineId(AppliEntity.class, DataSerializers.INT);
    protected static final DataParameter<Boolean> IS_APPLIDUOING = EntityDataManager.defineId(AppliEntity.class, DataSerializers.BOOLEAN);


    @Override
    public void addAdditionalSaveData(CompoundNBT saveData) {
        super.addAdditionalSaveData(saveData);
        saveData.putString("emo", this.getEmotion());
        saveData.putInt("att_type", this.getAppmonAtt());
        saveData.putInt("att_to", this.getAppmonAttTo());
        saveData.putBoolean("is_used_duo", this.isDUO());
        if(!getAppmon().isEmpty()) {
            saveData.put("Appmon", this.getAppmon());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT saveData) {
        super.readAdditionalSaveData(saveData);
        this.getEntityData().set(EMOTION, saveData.getString("emo"));
        this.getEntityData().set(ATTTYPE,saveData.getInt("att_type"));
        this.getEntityData().set(DATA_ATT_ID, saveData.getInt("att_to"));
        this.getEntityData().set(IS_APPLIDUOING, saveData.getBoolean("is_used_duo"));
        if(saveData.contains("Appmon")){
            this.setAppmon(saveData.getCompound("Appmon"));
        }
    }

    public CompoundNBT getAppmon() {
        return this.getEntityData().get(APPMON);
    }

    public void setAppmon(CompoundNBT tag) {
        this.getEntityData().set(APPMON, tag);
    }

    public int getAppmonPower() {
        return this.getAppmon().getInt("power");
    }

    public void setAppmonPower(int power) {this.getAppmon().putInt("power", power);}

    public int getAppmonAtt() {return this.getEntityData().get(ATTTYPE);}

    public void setAppmonAtt(Integer type) {
        this.getEntityData().set(ATTTYPE, type);
    }

    public int getAppmonAttTo() {return this.getEntityData().get(DATA_ATT_ID);}

    public void setAppmonAttTo(int att) {
        this.getEntityData().set(DATA_ATT_ID, att);
    }

    public boolean isDUO() {return this.getEntityData().get(IS_APPLIDUOING);}

    public void DUOChangeTo(boolean duo) {this.getEntityData().set(IS_APPLIDUOING, duo);}

    public String getEmotion() {
        return this.getEntityData().get(EMOTION);
    }


    public void doTechniques(){
        System.out.println("tec");
    }


    public void tameAppli(PlayerEntity player) {
        this.setTame(true);
        this.setOwnerUUID(player.getUUID());
        if (player instanceof ServerPlayerEntity) {
            CriteriaTriggers.TAME_ANIMAL.trigger((ServerPlayerEntity)player, this);
        }

    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving() && playFlyingAnimation && canfly) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("flying", ILoopType.EDefaultLoopTypes.LOOP));
            return PlayState.CONTINUE;
        }else if(event.isMoving() && playWalkingAnimation){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("walking", ILoopType.EDefaultLoopTypes.LOOP));

            return PlayState.CONTINUE;
        } else {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", ILoopType.EDefaultLoopTypes.LOOP));
            return PlayState.CONTINUE;
        }
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    protected void registerGoals(){
        super.registerGoals();
        this.goalSelector.addGoal(0,new SitGoal(this));
        this.goalSelector.addGoal(5,new FollowOwnerGoal(this, 1.6, 6.5F, 2.5F, canfly));
        if(!this.isTame()) {
            this.goalSelector.addGoal(4,new AppliAttackGoal(this,1.0, true,0));
            this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
            this.targetSelector.addGoal(3, new OwnerHurtByTargetGoal(this));
            this.targetSelector.addGoal(4, new OwnerHurtTargetGoal(this));
        }else{
            PlayerEntity player = (PlayerEntity) this.getOwner();
            LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(CapRegHandler.DENSHINOURYOKU);
            capability.ifPresent((cpd)->{
                float appliDenSNR = cpd.getDenSNR();
                if(appliDenSNR >= 35){
                    this.goalSelector.addGoal(4,new AppliAttackGoal(this,1.0, true,0));
                    this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
                    this.targetSelector.addGoal(3, new OwnerHurtByTargetGoal(this));
                    this.targetSelector.addGoal(4, new OwnerHurtTargetGoal(this));
                }else if(MathHelper.nextInt(new Random(),0,2)==1){
                    this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
                }
            });
        }

        if(!isTame()){
            this.goalSelector.addGoal(4, new RandomWalkingGoal(this,0.8));
            if(isInWater()){
                this.goalSelector.addGoal(3, new RandomSwimmingGoal(this,0.7,5));
            }
            if(canfly){
                this.goalSelector.addGoal(4,new WaterAvoidingRandomFlyingGoal(this,0.9));
            }
        }else {
            this.goalSelector.addGoal(4, new RandomWalkingGoal(this,0.3));
            if(isInWater()){
                this.goalSelector.addGoal(3, new RandomSwimmingGoal(this,0.25,3));
            }
            if(canfly){
                this.goalSelector.addGoal(4,new WaterAvoidingRandomFlyingGoal(this,0.4));
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        if(!this.level.isClientSide && getAppmonAttTo() > 0 && getTarget() == null){
            setAppmonAttTo(0);
        }
        /*
        try {
            if(this.getHealth() > getAppmonHealth(this)){
                this.setHealth(getAppmonHealth(this));
            }
        } catch (NotAppmonException e) {
            throw new RuntimeException(e);
        }
        */
    }


    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.3F).add(Attributes.ATTACK_DAMAGE, 2.0D).add(Attributes.MAX_HEALTH, 10000.0F);
    }

    public static int getAppmonHealth(int power, byte type){
        int health = 30;
        if(type == 1){
            health += (int) (Math.ceil(power/25.0) + Math.ceil(power/225.0));
        }else if(type == 2){
            health += Math.ceil(power/225.0) + 75;
        }else if (type == 3){
            health += Math.ceil(power/225.0) + 135;
        }else if (type == 4){
            health += Math.ceil(power/225.0) + 245;
        }else if (type == 0){
            health = 44;
        }else if (type == -1){
            health += Math.ceil(power/207.0);
        }
        return health;
    }

    public static int getAppmonHealth(AppliEntity appliEntity) throws NotAppmonException {
        int power = appliEntity.getAppmonPower();
        byte type = AppliSetup.AppmonTypes.valueOf(AppliModel.getRegAppliEntiNameWithoutModId(appliEntity)).getFormTypes().getId();
        return getAppmonHealth(power,type);
    }
}
