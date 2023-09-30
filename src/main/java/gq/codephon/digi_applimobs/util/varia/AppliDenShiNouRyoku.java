package gq.codephon.digi_applimobs.util.varia;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraftforge.common.util.INBTSerializable;

public class AppliDenShiNouRyoku implements INBTSerializable {

    private float denSNR;

    public AppliDenShiNouRyoku() {
        this.denSNR = 700.0f;
    }

    public float getDenSNR() {
        return denSNR;
    }

    public void setDenSNR(float denSNR) {
        this.denSNR = denSNR;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT nbt = new CompoundNBT();
        nbt.putFloat("应用能源",denSNR);
        return nbt;
    }

    @Override
    public void deserializeNBT(INBT nbt) {
        if(nbt instanceof CompoundNBT){
            CompoundNBT compoundNBT = (CompoundNBT) nbt;
            this.denSNR = compoundNBT.getFloat("应用能源");
        }
    }
}
