package com.github.upcraftlp.wastelands.item;

import com.github.upcraftlp.wastelands.capability.EnergyProviderItemStack;
import com.github.upcraftlp.wastelands.capability.EnergyStorageModifyable;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nullable;

public class ItemBattery extends Item {

    public final int capacity;
    public final int chargeRate;
    public final int dischargeRate;

    public ItemBattery(int capacity, int transfer) {
        this(capacity, transfer, transfer);
    }

    public ItemBattery(int capacity, int chargeRate, int dischargeRate) {
        this.capacity = capacity;
        this.chargeRate = chargeRate;
        this.dischargeRate = dischargeRate;
        this.setHasSubtypes(true);
        this.setMaxStackSize(1);
    }

    @Override
    public void getSubItems(CreativeTabs tabs, NonNullList<ItemStack> list) {
        if(this.isInCreativeTab(tabs)) {
            ItemStack stackFull = new ItemStack(this);
            this.setEnergyStored(stackFull, this.capacity);

            ItemStack stackEmpty = new ItemStack(this);
            list.add(stackEmpty);
        }
    }

    private void setEnergyStored(ItemStack stack, int energyStored) {
        if(stack.hasCapability(CapabilityEnergy.ENERGY, null)) {
            IEnergyStorage storage = stack.getCapability(CapabilityEnergy.ENERGY, null);
            if(storage instanceof EnergyStorageModifyable) {
                ((EnergyStorageModifyable) storage).setEnergyStored(energyStored);
            }
        }
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        if(stack.hasCapability(CapabilityEnergy.ENERGY, null)) {
            IEnergyStorage storage = stack.getCapability(CapabilityEnergy.ENERGY, null);
            if(storage != null) {
                double maxAmount = storage.getMaxEnergyStored();
                double energyDif = maxAmount - storage.getEnergyStored();
                return energyDif / maxAmount;
            }
        }
        return super.getDurabilityForDisplay(stack);
    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable NBTTagCompound nbt) {
        return new EnergyProviderItemStack(stack, this);
    }

    public int receiveEnergy(ItemStack stack, int maxReceive, boolean simulate) {
        if(stack.hasCapability(CapabilityEnergy.ENERGY, null)) {
            IEnergyStorage storage = stack.getCapability(CapabilityEnergy.ENERGY, null);
            if(storage != null) {
                return storage.receiveEnergy(maxReceive, simulate);
            }
        }
        return 0;
    }

    public int extractEnergy(ItemStack stack, int maxExtract, boolean simulate) {
        if(stack.hasCapability(CapabilityEnergy.ENERGY, null)) {
            IEnergyStorage storage = stack.getCapability(CapabilityEnergy.ENERGY, null);
            if(storage != null) return storage.extractEnergy(maxExtract, simulate);
        }
        return 0;
    }

    public int getEnergyStored(ItemStack stack) {
        if(stack.hasCapability(CapabilityEnergy.ENERGY, null)) {
            IEnergyStorage storage = stack.getCapability(CapabilityEnergy.ENERGY, null);
            if(storage != null) return storage.getEnergyStored();
        }
        return 0;
    }

    public int getMaxEnergyStored(ItemStack stack) {
        if(stack.hasCapability(CapabilityEnergy.ENERGY, null)) {
            IEnergyStorage storage = stack.getCapability(CapabilityEnergy.ENERGY, null);
            if(storage != null) return storage.getMaxEnergyStored();
        }
        return 0;
    }
}
