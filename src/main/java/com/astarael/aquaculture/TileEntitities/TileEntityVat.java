package com.astarael.aquaculture.TileEntitities;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileEntityVat extends TileEntity implements ITickable {

    // to prevent updating every tick we delay it for 10 ticks until the next check
    private int delayCounter = 10;

    private ItemStack[] inputStack;
    private ItemStack[] outputStack;
    private FluidTank fluidTank;

    public TileEntityVat () {

        super();
        fluidTank = new FluidTank(128000);
        inputStack = new ItemStack[0];
        outputStack = new ItemStack[0];


    }

    public ItemStack[] getInputStack () {
        return inputStack;
    }

    public ItemStack[] getOutputStack () {
        return outputStack;
    }

    public FluidTank getFluidTank () {
        return fluidTank;
    }

    public void update () {
        // don't update every tick
        if (blockType instanceof Vat) {
            delayCounter--;
            markDirty();
            if (delayCounter <= 0) {
                delayCounter = 10;
            }
        }
    }

    /* NBT METHODS */
    @Override
    public void readFromNBT (NBTTagCompound nbt) {

        NBTTagCompound tag = new NBTTagCompound();
        // TODO add itemstacks
        fluidTank.readFromNBT(nbt.getCompoundTag("WaterTank"));

    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {

        nbt.setTag("FluidTank", fluidTank.writeToNBT(new NBTTagCompound()));
        return nbt;

    }

}
