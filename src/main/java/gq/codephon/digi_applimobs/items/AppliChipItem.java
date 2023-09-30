package gq.codephon.digi_applimobs.items;

import gq.codephon.digi_applimobs.appli_helpers.AppliSetup;
import gq.codephon.digi_applimobs.group.ModGroup;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static gq.codephon.digi_applimobs.entities.AppliEntity.getAppmonHealth;

public class AppliChipItem extends Item {
    public AppliChipItem(){
        super(new Properties().tab(ModGroup.chipGroup).stacksTo(1));
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable World worldIn, List<ITextComponent> componentList, ITooltipFlag flagIn) {
        CompoundNBT nbtTag = itemStack.getTag();
        if (nbtTag != null) {
            componentList.add(new StringTextComponent(new TranslationTextComponent("text.power").getString() + nbtTag.getInt("AppmonPower")));
            componentList.add(new StringTextComponent(new TranslationTextComponent("text.hp").getString() + nbtTag.getFloat("AppmonHP")));
        }
    }

    @Override
    public void inventoryTick(ItemStack itemStack, World worldIn, Entity enti, int i, boolean b) {
        if (!itemStack.hasTag()) {
            itemStack.setTag(new CompoundNBT());
        }

        if(itemStack.getTag().isEmpty()){
            String chipName = itemStack.getItem().getRegistryName().getPath().toUpperCase().replaceAll("APPLICHIP_","").replaceAll("_UNLOCKED","");
            int power = AppliSetup.AppmonTypes.valueOf(chipName).getPower();
            byte type = AppliSetup.AppmonTypes.valueOf(chipName).getFormTypes().getId();
            float health = getAppmonHealth(power,type);
            itemStack.getTag().putString("AppmonName",chipName);
            itemStack.getTag().putFloat("AppmonHP", health);
            itemStack.getTag().putInt("AppmonPower", power);

            if(type > 1){
                itemStack.getTag().put("Standard_from",standard());
            }

            if(type > 2){
                itemStack.getTag().put("Off_standard_from",standard());
                itemStack.getTag().put("Super_from",sUper());
            }

            if(type > 3){
                itemStack.getTag().put("Sub_standard_from",standard());
                itemStack.getTag().put("Off_sub_standard_from",standard());
                itemStack.getTag().put("Off_super_from",sUper());
                itemStack.getTag().put("Ultimate_from",ulti());
            }
        }
    }

    public static CompoundNBT standard() {
        CompoundNBT stand = new CompoundNBT();
        stand.putString("standard_main_obj_name","null");
        stand.putString("standard_off_obj_name","null");
        stand.putInt("standard_main_obj_power",1);
        stand.putInt("standard_off_obj_power",1);
        stand.putFloat("standard_main_obj_health",1);
        stand.putFloat("standard_off_obj_health",1);
        return stand;
    }

    public static CompoundNBT sUper(){
        CompoundNBT supeR = new CompoundNBT();
        supeR.putString("super_main_obj_name","null");
        supeR.putString("super_off_obj_name","null");
        supeR.putInt("super_main_obj_power",1);
        supeR.putInt("super_off_obj_power",1);
        supeR.putFloat("super_main_obj_health",1);
        supeR.putFloat("super_off_obj_health",1);
        return supeR;
    }

    public static CompoundNBT ulti(){
        CompoundNBT ultimate = new CompoundNBT();
        ultimate.putString("ultimate_main_obj_name","null");
        ultimate.putString("ultimate_off_obj_name","null");
        ultimate.putInt("ultimate_main_obj_power",1);
        ultimate.putInt("ultimate_off_obj_power",1);
        ultimate.putFloat("ultimate_main_obj_health",1);
        ultimate.putFloat("ultimate_off_obj_health",1);
        return ultimate;
    }
}
