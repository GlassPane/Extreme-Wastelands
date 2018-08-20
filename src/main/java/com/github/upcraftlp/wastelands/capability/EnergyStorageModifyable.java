package com.github.upcraftlp.wastelands.capability;

import net.minecraft.util.math.MathHelper;
import net.minecraftforge.energy.EnergyStorage;

public class EnergyStorageModifyable extends EnergyStorage {

    public EnergyStorageModifyable(int capacity) {
        super(capacity);
    }

    public EnergyStorageModifyable(int capacity, int maxTransfer) {
        super(capacity, maxTransfer);
    }

    public EnergyStorageModifyable(int capacity, int maxReceive, int maxExtract) {
        super(capacity, maxReceive, maxExtract);
    }

    public EnergyStorageModifyable(int capacity, int maxReceive, int maxExtract, int energy) {
        super(capacity, maxReceive, maxExtract, energy);
    }

    public void setEnergyStored(int energy) {
        this.energy = MathHelper.clamp(energy, 0, this.getMaxEnergyStored());
    }
}
