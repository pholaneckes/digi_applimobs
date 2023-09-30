package gq.codephon.digi_applimobs.network;

import gq.codephon.digi_applimobs.appli_helpers.AppliSetup;
import gq.codephon.digi_applimobs.dimension.DimReg;
import gq.codephon.digi_applimobs.entities.*;
import gq.codephon.digi_applimobs.entities.models.AppliModel;
import gq.codephon.digi_applimobs.event.AppmonAttackEntityEvent;
import gq.codephon.digi_applimobs.items.AppliChipItem;
import gq.codephon.digi_applimobs.items.AppliDrive;
import gq.codephon.digi_applimobs.items.AppliDriveDUO;
import gq.codephon.digi_applimobs.items.AppliUnlockedChipItem;
import gq.codephon.digi_applimobs.util.NotAppmonException;
import gq.codephon.digi_applimobs.util.Ways;
import gq.codephon.digi_applimobs.util.varia.AppliDenShiNouRyoku;
import gq.codephon.digi_applimobs.util.varia.CapRegHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.PacketDistributor;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Supplier;

import static gq.codephon.digi_applimobs.appli_helpers.GattaiResult.checkGattai;
import static gq.codephon.digi_applimobs.entities.AppliEntity.getAppmonHealth;
import static gq.codephon.digi_applimobs.items.AppliDrive.*;

public class SendPack {
    private final UUID uuid;
    private final int power;
    private final short type;
    private final boolean b;
    private final String text;

    public SendPack(PacketBuffer buffer) {
        uuid = buffer.readUUID();
        power = buffer.readInt();
        type = buffer.readShort();
        b = buffer.readBoolean();
        text = buffer.readUtf();
    }

    public SendPack(UUID uuid, int power, short type) {
        this.uuid = uuid;
        this.power = power;
        this.type = type;
        this.b = false;
        this.text = "null";
    }

    public SendPack(UUID uuid, short type) {
        this.uuid = uuid;
        this.power = -1;
        this.type = type;
        this.b = false;
        this.text = "null";
    }

    public SendPack(UUID uuid, Boolean b,String text, short type) {
        this.uuid = uuid;
        this.power = -1;
        this.type = type;
        this.b = b;
        this.text = text;
    }


    public void toBytes(PacketBuffer buf) {
        buf.writeUUID(this.uuid);
        buf.writeInt(this.power);
        buf.writeShort(this.type);
        buf.writeBoolean(this.b);
        buf.writeUtf(this.text);
    }

    public void handler(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            if(type == 1) {
                tongbu(power);
                OpenAppliStatsGui((AppliEntity) appmon, ((AppliEntity) appmon).getAppmonPower());
            }
            if(type == 2){
                toDoAtt(uuid);
            }
            if(type == 3){
                chipIn(uuid);
            }
            if(type == 4){
                appliarise(uuid);
            }
            if(type == 5){
                try {
                    callBack(uuid);
                } catch (NotAppmonException e) {
                    throw new RuntimeException(e);
                }
            }
            if(type == 6){
                goAR(uuid);
            }
            if(type == 7){
                try {
                    link(uuid);
                } catch (NotAppmonException e) {
                    throw new RuntimeException(e);
                }
            }
            if(type == 8){
                updateLinkForClient(b,text);
            }
        });
        ctx.get().setPacketHandled(true);
    }

    @OnlyIn(Dist.CLIENT)
    public static void tongbu(int po){
        if(Ways.getPointedEntity(Minecraft.getInstance().getCameraEntity(), 64.0) != null) {
            ((AppliEntity) appmon).setAppmonPower(po);
        }
    }

    @OnlyIn(Dist.DEDICATED_SERVER)
    public static void toDoAtt(UUID uuid){
        if(appmonWithOwnerPointed != null) {
            PlayerEntity player = (PlayerEntity) pubServerworld.getEntity(uuid);
            AppmonAttackEntityEvent.goAttEnti(appmonWithOwnerPointed, player);
        }
    }

    @OnlyIn(Dist.DEDICATED_SERVER)
    public static void chipIn(UUID uuid) {
        if (pubServerworld != null) {
            ServerPlayerEntity player = (ServerPlayerEntity) pubServerworld.getEntity(uuid);
            ItemStack left = player.getItemInHand(Hand.OFF_HAND);
            ItemStack right = player.getItemInHand(Hand.MAIN_HAND);
            if (left.getItem() instanceof AppliDrive) {
                if (right.getItem() instanceof AppliChipItem && left.getTag().getString("AppmonName").equals("null")) {
                    if (right.getItem() instanceof AppliUnlockedChipItem) {
                        player.sendMessage(new StringTextComponent(new TranslationTextComponent("msg.chip.unlock").getString()), player.getUUID());
                    } else if (right.hasTag()) {
                        String chipName = right.getTag().getString("AppmonName");
                        int power = right.getTag().getInt("AppmonPower");
                        float health = right.getTag().getFloat("AppmonHP");
                        EntityType<? extends AppliEntity> appli = AppliSetup.AppmonTypes.valueOf(chipName).getAppmon();
                        CompoundNBT nbt = new CompoundNBT();
                        nbt.putInt("AppmonPower", power);
                        nbt.putFloat("AppmonHP", health);
                        nbt.putString("AppmonName", chipName);
                        byte type = AppliSetup.AppmonTypes.valueOf(chipName).getFormTypes().getId();
                        if(type > 1){
                            nbt.put("Standard_from",right.getTag().get("Standard_from"));
                        }
                        if(type > 2){
                            nbt.put("Super_from",right.getTag().get("Super_from"));
                            nbt.put("Off_standard_from",right.getTag().get("Off_standard_from"));
                        }
                        if(type > 3){
                            nbt.put("Ultimate_from",right.getTag().get("Ultimate_from"));
                            nbt.put("Sub_standard_from",right.getTag().get("Sub_standard_from"));
                            nbt.put("Off_super_from",right.getTag().get("Off_super_from"));
                            nbt.put("Off_sub_standard_from",right.getTag().get("Off_sub_standard_from"));
                        }
                        left.setTag(nbt);
                        player.inventory.removeItem(right);
                    }
                } else if (right.equals(ItemStack.EMPTY) && !left.getTag().getString("AppmonName").equals("null")) {
                    AppliChipItem chipItem = (AppliChipItem) AppliSetup.AppmonTypes.valueOf(left.getTag().getString("AppmonName")).getAppmonchip();
                    CompoundNBT nbt = new CompoundNBT();
                    nbt.putString("AppmonName", left.getTag().getString("AppmonName"));
                    nbt.putInt("AppmonPower", left.getTag().getInt("AppmonPower"));
                    nbt.putFloat("AppmonHP", left.getTag().getFloat("AppmonHP"));
                    byte type = AppliSetup.AppmonTypes.valueOf(left.getTag().getString("AppmonName")).getFormTypes().getId();
                    if(type > 1){
                        nbt.put("Standard_from",left.getTag().get("Standard_from"));
                    }
                    if(type > 2){
                        nbt.put("Super_from",left.getTag().get("Super_from"));
                        nbt.put("Off_standard_from",left.getTag().get("Off_standard_from"));
                    }
                    if(type > 3){
                        nbt.put("Ultimate_from",left.getTag().get("Ultimate_from"));
                        nbt.put("Sub_standard_from",left.getTag().get("Sub_standard_from"));
                        nbt.put("Off_super_from",left.getTag().get("Off_super_from"));
                        nbt.put("Off_sub_standard_from",left.getTag().get("Off_sub_standard_from"));
                    }
                    ItemStack itemStack = new ItemStack(chipItem, 1, nbt);
                    left.getTag().putString("AppmonName", "null");
                    left.getTag().putFloat("AppmonHP", -1);
                    left.getTag().putInt("AppmonPower", -1);
                    if(type > 1){
                        left.getTag().put("Standard_from",new CompoundNBT());
                    }
                    if(type > 2){
                        left.getTag().put("Super_from",new CompoundNBT());
                        left.getTag().put("Off_standard_from",new CompoundNBT());
                    }
                    if(type > 3){
                        left.getTag().put("Ultimate_from",new CompoundNBT());
                        left.getTag().put("Sub_standard_from",new CompoundNBT());
                        left.getTag().put("Off_super_from",new CompoundNBT());
                        left.getTag().put("Off_sub_standard_from",new CompoundNBT());
                    }
                    player.setItemInHand(Hand.MAIN_HAND, itemStack);
                    player.getItemInHand(Hand.MAIN_HAND).setTag(nbt);
                }
            }
        }
    }

    @OnlyIn(Dist.DEDICATED_SERVER)
    public static void appliarise(UUID uuid){
        if(pubServerworld != null){
            ServerPlayerEntity player = (ServerPlayerEntity) pubServerworld.getEntity(uuid);
            ItemStack left = player.getItemInHand(Hand.OFF_HAND);
            ItemStack right = player.getItemInHand(Hand.MAIN_HAND);
            if(left.getItem() instanceof AppliDrive) {
                summonAppmon(player , left);
            }else if(right.getItem() instanceof AppliDrive) {
                summonAppmon(player , right);
            }
        }
    }

    @OnlyIn(Dist.DEDICATED_SERVER)
    public static void summonAppmon(ServerPlayerEntity player, ItemStack stack){
        String chipName = stack.getTag().getString("AppmonName");
        if(!chipName.equals("null")) {
            int power = stack.getTag().getInt("AppmonPower");
            float health = stack.getTag().getFloat("AppmonHP");
            EntityType<? extends AppliEntity> appli = AppliSetup.AppmonTypes.valueOf(chipName).getAppmon();
            AppliEntity appmon = (AppliEntity) appli.spawn(pubServerworld, null, player, new BlockPos(player.getX(), player.getY(), player.getZ()), SpawnReason.MOB_SUMMONED, false, false);
            appmon.setHealth(health);
            stack.getTag().putString("AppmonName", "null");
            stack.getTag().putFloat("AppmonHP", -1);
            stack.getTag().putInt("AppmonPower", -1);
            player.sendMessage(new StringTextComponent(new TranslationTextComponent("msg.al.appliarise").getString()), player.getUUID());
            if (stack.getItem() instanceof AppliDriveDUO) {
                appmon.setAppmonPower((int) Math.floor(power * 1.5));
                appmon.DUOChangeTo(true);
                player.sendMessage(new StringTextComponent(new TranslationTextComponent("msg.thanks.touchin").getString()), player.getUUID());
            } else {
                appmon.setAppmonPower(power);
            }
            if(appmon instanceof SuperApplimob){
                ((SuperApplimob)appmon).setAppStandard((CompoundNBT) stack.getTag().get("Standard_from"));
            }
            if(appmon instanceof UltimateApplimob){
                ((UltimateApplimob)appmon).setAppSuper((CompoundNBT) stack.getTag().get("Super_from"));
                ((UltimateApplimob)appmon).setOffStandard((CompoundNBT) stack.getTag().get("Off_standard_from"));
            }
            if(appmon instanceof GodApplimob){
                ((GodApplimob)appmon).setAppUltimate((CompoundNBT) stack.getTag().get("Ultimate_from"));
                ((GodApplimob)appmon).setSubStandard((CompoundNBT) stack.getTag().get("Sub_standard_from"));
                ((GodApplimob)appmon).setOffSuper((CompoundNBT) stack.getTag().get("Off_super_from"));
                ((GodApplimob)appmon).setOffSubStandard((CompoundNBT) stack.getTag().get("Off_sub_standard_from"));
            }
            appmon.tame(player);
        }
    }

    @OnlyIn(Dist.DEDICATED_SERVER)
    public static void callBack(UUID uuid) throws NotAppmonException {
        if(pubServerworld != null) {
            ServerPlayerEntity player = (ServerPlayerEntity) pubServerworld.getEntity(uuid);
            AppliEntity appmonWithOwner = (AppliEntity) pubServerworld.getEntity(appmonWithOwnerPointed.getUUID());
            int appmonPower = appmonWithOwner.getAppmonPower();
            float appmonHP = appmonWithOwner.getHealth();
            String appmonName = AppliModel.getRegAppliEntiNameWithoutModId(appmonWithOwner);
            if (!AppliSetup.AppmonTypes.valueOf(appmonName).getAppmonchip().equals(Items.AIR)) {
                if(appmonWithOwner instanceof StandardApplimob){
                    if(((StandardApplimob) appmonWithOwner).isAppliLinked()){
                        return;
                    }
                }
                ItemStack left = player.getItemInHand(Hand.OFF_HAND);
                ItemStack right = player.getItemInHand(Hand.MAIN_HAND);
                if (left.getItem() instanceof AppliDrive || right.getItem() instanceof AppliDrive) {
                    if (appmonWithOwner.isTame() && Objects.equals(appmonWithOwner.getOwner(), player)) {
                        if (appmonWithOwner.isAlive()) {
                            if (left.getItem() instanceof AppliDrive && left.hasTag()) {
                                if (appmonWithOwner.isDUO()) {
                                    left.getTag().putInt("AppmonPower", (int) Math.ceil(appmonPower / 1.5));
                                } else {
                                    left.getTag().putInt("AppmonPower", appmonPower);
                                }
                                left.getTag().putFloat("AppmonHP", appmonHP);
                                left.getTag().putString("AppmonName", appmonName);
                                if(appmonWithOwner instanceof SuperApplimob){
                                    left.getTag().put("Standard_from",((SuperApplimob) appmonWithOwner).getAppStandard());
                                }
                                if(appmonWithOwner instanceof UltimateApplimob){
                                    left.getTag().put("Super_from",((UltimateApplimob) appmonWithOwner).getAppSuper());
                                    left.getTag().put("Off_standard_from",((UltimateApplimob) appmonWithOwner).getOffStandard());
                                }
                                if(appmonWithOwner instanceof GodApplimob){
                                    left.getTag().put("Ultimate_from",((GodApplimob) appmonWithOwner).getAppUltimate());
                                    left.getTag().put("Sub_standard_from",((GodApplimob) appmonWithOwner).getSubStandard());
                                    left.getTag().put("Off_super_from",((GodApplimob) appmonWithOwner).getOffSuper());
                                    left.getTag().put("Off_sub_standard_from",((GodApplimob) appmonWithOwner).getOffSubStandard());
                                }
                            } else if (right.hasTag()) {
                                if (appmonWithOwner.isDUO()) {
                                    right.getTag().putInt("AppmonPower", (int) Math.ceil(appmonPower / 1.5));
                                } else {
                                    right.getTag().putInt("AppmonPower", appmonPower);
                                }
                                right.getTag().putFloat("AppmonHP", appmonHP);
                                right.getTag().putString("AppmonName", appmonName);
                                if(appmonWithOwner instanceof SuperApplimob){
                                    right.getTag().put("Standard_from",((SuperApplimob) appmonWithOwner).getAppStandard());
                                }
                                if(appmonWithOwner instanceof UltimateApplimob){
                                    right.getTag().put("Super_from",((UltimateApplimob) appmonWithOwner).getAppSuper());
                                    right.getTag().put("Off_standard_from",((UltimateApplimob) appmonWithOwner).getOffStandard());
                                }
                                if(appmonWithOwner instanceof GodApplimob){
                                    right.getTag().put("Ultimate_from",((GodApplimob) appmonWithOwner).getAppUltimate());
                                    right.getTag().put("Sub_standard_from",((GodApplimob) appmonWithOwner).getSubStandard());
                                    right.getTag().put("Off_super_from",((GodApplimob) appmonWithOwner).getOffSuper());
                                    right.getTag().put("Off_sub_standard_from",((GodApplimob) appmonWithOwner).getOffSubStandard());
                                }
                            }
                            appmonWithOwner.remove();
                        }
                    }
                }
            }
        }
    }

    @OnlyIn(Dist.DEDICATED_SERVER)
    public static void goAR(UUID uuid){
        if(pubServerworld != null) {
            ServerPlayerEntity player = (ServerPlayerEntity) pubServerworld.getEntity(uuid);
            ServerWorld serverWorld = player.getServer().getLevel(DimReg.AR_FIELD);
            LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(CapRegHandler.DENSHINOURYOKU);
            capability.ifPresent((cpd) -> {
                if (cpd.getDenSNR() > 71) {
                    cpd.setDenSNR(cpd.getDenSNR() - 40);
                    if (!player.level.dimension().equals(DimReg.AR_FIELD)) {
                        player.teleportTo(serverWorld, player.getX(), player.getY() > 147 ? player.getY() : 147, player.getZ(), player.yRot, player.xRot);
                    } else {
                        player.teleportTo(player.getServer().getLevel(World.OVERWORLD), player.getX(), player.getY() > 70 ? player.getY() : 70, player.getZ(), player.yRot, player.xRot);
                    }
                } else {
                    player.sendMessage(new StringTextComponent(new TranslationTextComponent("msg.dsnr.not_enorgh").getString()), player.getUUID());
                }
            });
        }
    }

    @OnlyIn(Dist.DEDICATED_SERVER)
    public static void link(UUID uuid) throws NotAppmonException {
        if(pubServerworld != null){
            ServerPlayerEntity player = (ServerPlayerEntity) pubServerworld.getEntity(uuid);
            Entity pointedEntity = Ways.getPointedEntity(player, 64.0);
            if(pointedEntity instanceof StandardApplimob){
                StandardApplimob appmonFr = (StandardApplimob) pointedEntity;
                String frName = AppliModel.getRegAppliEntiNameWithoutModId(appmonFr);
                String beName;
                ItemStack stack;
                if(player.getItemInHand(Hand.OFF_HAND).getItem() instanceof AppliDrive && player.getItemInHand(Hand.OFF_HAND).hasTag()){
                    stack = player.getItemInHand(Hand.OFF_HAND);
                }else if(player.getItemInHand(Hand.MAIN_HAND).getItem() instanceof AppliDrive && player.getItemInHand(Hand.MAIN_HAND).hasTag()){
                    stack = player.getItemInHand(Hand.MAIN_HAND);
                }else {
                    return;
                }
                beName = stack.getTag().getString("AppmonName");
                String check;
                check = checkGattai(frName, beName);
                if(check.equals("noGattai")){
                    check = checkGattai(beName, frName);
                }
                if(!check.equals("noGattai")){
                    int bePower = stack.getTag().getInt("AppmonPower");
                    int frPower = appmonFr.getAppmonPower();
                    float beHp = stack.getTag().getFloat("AppmonHP");
                    float frHp = appmonFr.getHealth();
                    int beHealthMax = getAppmonHealth(bePower, AppliSetup.AppmonTypes.valueOf(beName).getFormTypes().getId());
                    int frHealthMax = getAppmonHealth(appmonFr);
                    float GattaiHP = beHp + frHp - (beHealthMax - beHp + frHealthMax - frHp) / 2.0f;
                    double x = appmonFr.getX();
                    double y = appmonFr.getY();
                    double z = appmonFr.getZ();
                    if(appmonFr.isDUO()){
                        frPower = (int) Math.ceil(frPower/1.5);
                    }
                    if(appmonFr.isAlive()) {
                        EntityType<? extends AppliEntity> appli = AppliSetup.AppmonTypes.valueOf(check).getAppmon();
                        AppliEntity appmon = (AppliEntity) appli.spawn(pubServerworld, null, player, new BlockPos(x, y, z), SpawnReason.MOB_SUMMONED, false, false);
                        assert appmon != null;
                        int extPower = AppliSetup.AppmonTypes.valueOf(frName).getPower() - frPower + AppliSetup.AppmonTypes.valueOf(beName).getPower() - bePower;
                        if (appmonFr instanceof GodApplimob) {
                            return;
                        } else if (appmonFr instanceof UltimateApplimob) {
                            UltimateApplimob ultiFr = (UltimateApplimob)appmonFr;
                            GodApplimob godApplimob = (GodApplimob) appmon;
                            godApplimob.setAppmonMainUltimateHealth(frHp);
                            godApplimob.setAppmonMainUltimateName(frName);
                            godApplimob.setAppmonMainUltimatePower(frPower);
                            godApplimob.setAppmonOffUltimateHealth(beHp);
                            godApplimob.setAppmonOffUltimateName(beName);
                            godApplimob.setAppmonOffUltimatePower(bePower);

                            godApplimob.setSubStandard((CompoundNBT) stack.getTag().get("Standard_from"));
                            godApplimob.setOffSubStandard((CompoundNBT) stack.getTag().get("Off_standard_from"));
                            godApplimob.setOffSuper((CompoundNBT) stack.getTag().get("Super_from"));
                            godApplimob.setAppSuper(ultiFr.getAppSuper());
                            godApplimob.setAppStandard(ultiFr.getAppStandard());
                            godApplimob.setOffStandard(ultiFr.getOffStandard());
                        } else if (appmonFr instanceof SuperApplimob) {
                            SuperApplimob superFr = (SuperApplimob)appmonFr;
                            UltimateApplimob ultimateApplimob = (UltimateApplimob) appmon;
                            ultimateApplimob.setAppmonMainSuperHealth(frHp);
                            ultimateApplimob.setAppmonMainSuperName(frName);
                            ultimateApplimob.setAppmonMainSuperPower(frPower);
                            ultimateApplimob.setAppmonOffSuperHealth(beHp);
                            ultimateApplimob.setAppmonOffSuperName(beName);
                            ultimateApplimob.setAppmonOffSuperPower(bePower);

                            ultimateApplimob.setAppStandard(superFr.getAppStandard());
                            ultimateApplimob.setOffStandard((CompoundNBT) stack.getTag().get("Standard_from"));
                        } else {
                            SuperApplimob superApplimob = ((SuperApplimob) appmon);
                            superApplimob.setAppmonMainStandardHealth(frHp);
                            superApplimob.setAppmonMainStandardName(frName);
                            superApplimob.setAppmonMainStandardPower(frPower);
                            superApplimob.setAppmonOffStandardHealth(beHp);
                            superApplimob.setAppmonOffStandardName(beName);
                            superApplimob.setAppmonOffStandardPower(bePower);
                        }
                        appmonFr.remove();
                        stack.getTag().putString("AppmonName", "null");
                        stack.getTag().putFloat("AppmonHP", -1);
                        stack.getTag().putInt("AppmonPower", -1);
                        appmon.setAppmonPower(appmon.getAppmonPower() + extPower);
                        if (stack.getItem() instanceof AppliDriveDUO) {
                            appmon.setAppmonPower((int) Math.floor(appmon.getAppmonPower() * 1.5));
                            appmon.DUOChangeTo(true);
                        }
                        appmon.tame(player);
                        appmon.setHealth(Math.max(GattaiHP, frHp/2.25f));
                    }
                }else {
                    if (!frName.equals(beName) && !beName.equals("null") /*&& stack.getTag().getUUID("Owner").equals(uuid)*/ && AppliSetup.AppmonTypes.valueOf(frName).getFormTypes().equals(AppliSetup.AppmonTypes.valueOf(beName).getFormTypes()) && !appmonFr.isAppliLinked() && !(appmonFr instanceof GodApplimob)) {
                        int bePower = stack.getTag().getInt("AppmonPower");
                        int frPower = appmonFr.getAppmonPower();
                        float beHp = stack.getTag().getFloat("AppmonHP");
                        float frHp = appmonFr.getHealth();
                        int beHealthMax = getAppmonHealth(bePower, AppliSetup.AppmonTypes.valueOf(beName).getFormTypes().getId());
                        int frHealthMax = getAppmonHealth(appmonFr);
                        float linkTaiHP = beHp + frHp - (beHealthMax - beHp + frHealthMax - frHp) / 2.0f;
                        if (stack.getItem() instanceof AppliDriveDUO && appmonFr.isDUO()) {
                            appmonFr.setAppmonPower((int) Math.floor((bePower * 1.5 + frPower) * 1.2));
                        } else {
                            appmonFr.setAppmonPower((int) Math.floor((bePower + frPower) * 1.2));
                        }
                        appmonFr.setHealth(linkTaiHP);
                        appmonFr.setAppmonLinkPower(bePower);
                        appmonFr.setAppmonLinkObjHealth(beHp);
                        appmonFr.setAppmonLinkObjName(beName);
                        appmonFr.setAppliLinkTo(true);

                        if(appmonFr instanceof SuperApplimob){
                            ((SuperApplimob)appmonFr).setLinkStandard((CompoundNBT) stack.getTag().get("Standard_from"));
                            if(appmonFr instanceof UltimateApplimob){
                                ((UltimateApplimob)appmonFr).setLinkOffStandard((CompoundNBT) stack.getTag().get("Off_standard_from"));
                                ((UltimateApplimob)appmonFr).setLinkSuper((CompoundNBT) stack.getTag().get("Super_from"));
                            }
                        }

                        stack.getTag().putString("AppmonName", "null");
                        stack.getTag().putFloat("AppmonHP", -1);
                        stack.getTag().putInt("AppmonPower", -1);
                        player.sendMessage(new StringTextComponent(new TranslationTextComponent("msg.applink").getString()), player.getUUID());
                        String L_a = new TranslationTextComponent("entity.digi_applimobs." + frName.toLowerCase()).getString().replaceAll("\u517d","").replaceAll("兽vi", "").replaceAll("money", "mo_ey").replaceAll("mon", "").replaceAll("mo_ey", "money");
                        String L_b = new TranslationTextComponent("entity.digi_applimobs." + beName.toLowerCase()).getString().replaceAll("\u517d","").replaceAll("兽", "").replaceAll("money", "mo_ey").replaceAll("mon", "").replaceAll("mo_ey", "money");
                        player.sendMessage(new StringTextComponent(L_a + new TranslationTextComponent("text.link.with").getString() + L_b + new TranslationTextComponent("mark.exclamation").getString()), player.getUUID());

                        NetworkRegHandler.CHANNEL.send(
                                PacketDistributor.PLAYER.with(
                                        () -> player
                                ),
                                new SendPack(uuid, true, beName, (short) 8));

                    } else if (beName.equals("null") && appmonFr.isAppliLinked()) {
                        float appmonLinkObjHealth = appmonFr.getAppmonLinkObjHealth();
                        String appChip = appmonFr.getAppmonLinkObjName();
                        int objPower = appmonFr.getAppmonLinkPower();
                        int b_power;
                        if (appmonFr.isDUO()) {
                            b_power = (int) Math.ceil(appmonFr.getAppmonPower() / 1.2 - objPower * 1.5);
                        } else {
                            b_power = (int) Math.ceil(appmonFr.getAppmonPower() / 1.2 - objPower);
                        }
                        appmonFr.setAppmonLinkPower(-1);
                        appmonFr.setAppmonLinkObjHealth(-1);
                        appmonFr.setAppmonLinkObjName("null");
                        appmonFr.setAppmonPower(b_power);
                        appmonFr.setHealth(Math.max(appmonFr.getHealth() - (appmonLinkObjHealth / 1.5f), getAppmonHealth(appmonFr) / 2f));
                        stack.getTag().putString("AppmonName", appChip);
                        stack.getTag().putFloat("AppmonHP", appmonLinkObjHealth);
                        stack.getTag().putInt("AppmonPower", objPower);
                        if(appmonFr instanceof SuperApplimob){
                            stack.getTag().put("Standard_from",((SuperApplimob) appmonFr).getLinkStandard());
                            ((SuperApplimob)appmonFr).setLinkStandard(new CompoundNBT());
                            if(appmonFr instanceof UltimateApplimob){
                                stack.getTag().put("Off_standard_from",((UltimateApplimob) appmonFr).getLinkOffStandard());
                                stack.getTag().put("Super_from",((UltimateApplimob) appmonFr).getLinkSuper());
                                ((UltimateApplimob)appmonFr).setLinkOffStandard(new CompoundNBT());
                                ((UltimateApplimob)appmonFr).setLinkSuper(new CompoundNBT());
                            }
                        }
                        appmonFr.setAppliLinkTo(false);
                        NetworkRegHandler.CHANNEL.send(
                                PacketDistributor.PLAYER.with(
                                        () -> player
                                ),
                                new SendPack(uuid, false, "null", (short) 8));
                    }else if(beName.equals("null") && appmonFr instanceof SuperApplimob){
                        int frPower = appmonFr.getAppmonPower();
                        float frHp = appmonFr.getHealth();
                        int frHealthMax = getAppmonHealth(appmonFr);
                        CompoundNBT tag = stack.getTag();
                        float chipHealth;
                        int chipPower;
                        String chipName;
                        String name;
                        float GattaiBeforeHP;
                        double x = appmonFr.getX();
                        double y = appmonFr.getY();
                        double z = appmonFr.getZ();
                        if(appmonFr.isDUO()){
                            frPower = (int) Math.ceil(frPower/1.5);
                        }
                        if(appmonFr.isAlive()) {
                            if (appmonFr instanceof GodApplimob) {
                                name = ((GodApplimob)appmonFr).getAppmonMainUltimateName();
                            } else if (appmonFr instanceof UltimateApplimob) {
                                name = ((UltimateApplimob)appmonFr).getAppmonMainSuperName();
                            } else {
                                name = ((SuperApplimob)appmonFr).getAppmonMainStandardName();
                            }
                            EntityType<? extends AppliEntity> appli = AppliSetup.AppmonTypes.valueOf(name).getAppmon();
                            AppliEntity appmon = (AppliEntity) appli.spawn(pubServerworld, null, player, new BlockPos(x, y, z), SpawnReason.MOB_SUMMONED, false, false);
                            assert appmon != null;
                            int extPower = AppliSetup.AppmonTypes.valueOf(frName).getPower() - frPower;
                            if (appmonFr instanceof GodApplimob) {
                                GodApplimob appmonGod = (GodApplimob) appmonFr;
                                GattaiBeforeHP = appmonGod.getAppmonMainUltimateHealth();
                                chipHealth = appmonGod.getAppmonOffUltimateHealth();
                                chipName = appmonGod.getAppmonOffUltimateName();
                                chipPower = appmonGod.getAppmonOffUltimatePower();

                                UltimateApplimob ultiAppmon = (UltimateApplimob) appmon;
                                ultiAppmon.setAppSuper(appmonGod.getAppSuper());
                                ultiAppmon.setAppStandard(appmonGod.getAppStandard());
                                ultiAppmon.setOffStandard(appmonGod.getOffStandard());

                                tag.put("Super_from",appmonGod.getOffSuper());
                                tag.put("Off_standard_from",appmonGod.getOffSubStandard());
                                tag.put("Standard_from",appmonGod.getSubStandard());

                            } else if (appmonFr instanceof UltimateApplimob) {
                                UltimateApplimob appmonUlti = (UltimateApplimob) appmonFr;
                                GattaiBeforeHP = appmonUlti.getAppmonMainSuperHealth();
                                chipHealth = appmonUlti.getAppmonOffSuperHealth();
                                chipName = appmonUlti.getAppmonOffSuperName();
                                chipPower = appmonUlti.getAppmonOffSuperPower();

                                SuperApplimob superAppmon = (SuperApplimob) appmon;
                                superAppmon.setAppStandard(appmonUlti.getAppStandard());
                                tag.put("Standard_from",appmonUlti.getOffStandard());

                            } else {
                                SuperApplimob appmonSuper = (SuperApplimob) appmonFr;
                                GattaiBeforeHP = appmonSuper.getAppmonMainStandardHealth();
                                chipHealth = appmonSuper.getAppmonOffStandardHealth();
                                chipName = appmonSuper.getAppmonOffStandardName();
                                chipPower = appmonSuper.getAppmonOffStandardPower();
                            }
                            tag.putString("AppmonName", chipName);
                            tag.putFloat("AppmonHP", chipHealth);
                            tag.putInt("AppmonPower", chipPower);
                            appmon.setAppmonPower(appmon.getAppmonPower() + extPower);
                            if (stack.getItem() instanceof AppliDriveDUO) {
                                appmon.setAppmonPower((int) Math.floor(appmon.getAppmonPower() * 1.5));
                                appmon.DUOChangeTo(true);
                            }
                            appmon.setHealth(Math.max(Math.max(GattaiBeforeHP,appmonFr.getHealth()-chipHealth),35));
                            appmon.tame(player);
                            appmonFr.remove();
                        }
                    }
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static void updateLinkForClient(Boolean link, String name){
        if(appmonWithOwnerPointed != null) {
            ((StandardApplimob) appmonWithOwnerPointed).setAppliLinkTo(link);
            ((StandardApplimob) appmonWithOwnerPointed).setAppmonLinkObjName(name);
        }
    }
}
