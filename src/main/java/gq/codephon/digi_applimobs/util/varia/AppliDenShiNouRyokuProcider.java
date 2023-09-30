package gq.codephon.digi_applimobs.util.varia;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AppliDenShiNouRyokuProcider implements ICapabilitySerializable<CompoundNBT> {

    private final AppliDenShiNouRyoku INSTANCE;

    public AppliDenShiNouRyokuProcider() {
        this.INSTANCE = new AppliDenShiNouRyoku();
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return cap == CapRegHandler.DENSHINOURYOKU ? LazyOptional.of(()->this.INSTANCE).cast() : LazyOptional.empty();
    }

    @Override
    public CompoundNBT serializeNBT() {
        return INSTANCE.serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.INSTANCE.deserializeNBT(nbt);
    }

}
