package com.github.upcraftlp.wastelands.capability;

import com.github.upcraftlp.wastelands.ExtremeWastelands;
import com.github.upcraftlp.wastelands.item.ItemBattery;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.energy.CapabilityEnergy;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class EnergyProviderItemStack implements ICapabilityProvider {

    public static final String KEY_ENERGY = ExtremeWastelands.MODID + ":energy";
    public final EnergyStorageModifyable storage;

    public EnergyProviderItemStack(ItemStack stack, ItemBattery battery) {
        this.storage = new EnergyStorageModifyable(battery.capacity, battery.chargeRate, battery.dischargeRate){
            @Override
            public int getEnergyStored() {
                if(stack.hasTagCompound()) {
                    stack.getTagCompound().getInteger(KEY_ENERGY);
                }
                return 0;
            }

            @Override
            public void setEnergyStored(int energy) {
                stack.setTagInfo(KEY_ENERGY, new NBTTagInt(energy));
            }
        };
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityEnergy.ENERGY;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityEnergy.ENERGY ? CapabilityEnergy.ENERGY.cast(this.storage) : null;
    }
}
