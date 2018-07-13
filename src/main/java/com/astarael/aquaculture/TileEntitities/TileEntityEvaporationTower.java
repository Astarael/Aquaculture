package com.astarael.aquaculture.TileEntitities;

import com.astarael.aquaculture.Aquaculture;
import com.astarael.aquaculture.TileEntitities.FluidTank;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.FluidTankProperties;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidTankProperties;

public class TileEntityEvaporationTower extends TileEntity implements ITickable {

    // to prevent updating every tick we delay it for 10 ticks until the next check
    private int delayCounter = 10;

    // TODO: Config
    private int WATER_USAGE_RATE = 200;
    private int WATER_GEN_RATE = 300;
    private int BRINE_GEN_RATE = 150;

    private FluidTank waterTank;
    private FluidTank brineTank;

    //private FluidTankCore waterTank = new FluidTank

    private static final int MAX_FLUID_AMOUNT = 4000;

    public TileEntityEvaporationTower () {

        this.waterTank = new FluidTank(MAX_FLUID_AMOUNT);
        this.brineTank = new FluidTank(MAX_FLUID_AMOUNT);

        waterTank.setLock(FluidRegistry.WATER);
        brineTank.setLock(FluidRegistry.getFluid(Aquaculture.MODID + ".brine"));

    }


    public FluidTank getWaterTank () {

        return waterTank;

    }

    public FluidTank getBrineTank () {

        return brineTank;

    }


    public FluidStack getWaterTankFluid () {

        return waterTank.getFluid();

    }

    public FluidStack getBrineTankFluid () {

        return brineTank.getFluid();

    }

    public void update () {
        // don't update every tick
        if (blockType instanceof EvaporationTower) {
            delayCounter--;
            if (delayCounter <= 0) {
                delayCounter = 10;
                // are we the server (not remote)
                // and are we in daylight
                long worldTime = world.getWorldTime();

                // TODO: check if this logic is needed
                if (world != null && !world.isRemote && (worldTime >= 1000) && (worldTime <= 12000)) {
                    blockType = getBlockType();
                    if (waterTank.getFluidAmount() >= WATER_USAGE_RATE && (brineTank.getFluidAmount() < (MAX_FLUID_AMOUNT - BRINE_GEN_RATE))) {
                        brineTank.modifyFluidStored(BRINE_GEN_RATE);
                        waterTank.modifyFluidStored(-WATER_USAGE_RATE);
                    } else if (waterTank.getFluidAmount() >= WATER_USAGE_RATE && (brineTank.getFluidAmount() < MAX_FLUID_AMOUNT)) {
                        brineTank.modifyFluidStored(BRINE_GEN_RATE);
                        waterTank.modifyFluidStored(-WATER_USAGE_RATE);
                    }
                }

                if (waterTank.getFluidAmount() < (MAX_FLUID_AMOUNT - WATER_GEN_RATE)) {
                    // TODO: if is in ocean biome
                    if (isWater(world.getBlockState(pos.down()))) {
                        waterTank.modifyFluidStored(WATER_GEN_RATE);
                    }

                } else {
                    waterTank.modifyFluidStored(MAX_FLUID_AMOUNT);
                }
            }
        }
    }

    protected static boolean isWater(IBlockState state) {

        return (state.getBlock() == Blocks.WATER || state.getBlock() == Blocks.FLOWING_WATER) && state.getValue(BlockLiquid.LEVEL) == 0;
    }

    /* NBT METHODS */
    @Override
    public void readFromNBT (NBTTagCompound nbt) {

        NBTTagCompound tag = new NBTTagCompound();
        waterTank.readFromNBT(nbt.getCompoundTag("WaterTank"));
        brineTank.readFromNBT(nbt.getCompoundTag("BrineTank"));

    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {

        nbt.setTag("WaterTank", waterTank.writeToNBT(new NBTTagCompound()));
        nbt.setTag("BrineTank", brineTank.writeToNBT(new NBTTagCompound()));
        return nbt;

    }

}
