package com.astarael.aquaculture.TileEntitities;

import com.astarael.aquaculture.Aquaculture;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;

public class TileEntityEvaporationTower extends TileEntity implements ITickable {

    // to prevent updating every tick we delay it for 10 ticks until the next check
    private int delayCounter = 10;

    // TODO: Config
    private int WATER_USAGE_RATE = 200;
    private int WATER_GEN_RATE = 300;
    private int BRINE_GEN_RATE = 150;

    private FluidTank waterTank;
    private FluidTank brineTank;

    private static final int MAX_FLUID_AMOUNT = 4000;

    public static final int GUI_ID = 1;

    public TileEntityEvaporationTower () {

        super();
        waterTank = new FluidTank(MAX_FLUID_AMOUNT);
        brineTank = new FluidTank(MAX_FLUID_AMOUNT);

        waterTank.setLock(FluidRegistry.WATER);
        brineTank.setLock(FluidRegistry.getFluid(Aquaculture.MODID + ".brine"));

    }

    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
                                    EnumFacing side, float hitX, float hitY, float hitZ) {
        // Only execute on the server
        if (world.isRemote) {
            return true;
        }
        TileEntity te = world.getTileEntity(pos);
        if (!(te instanceof TileEntityEvaporationTower)) {
            return false;
        }

        player.openGui(Aquaculture.instance, GUI_ID, world, pos.getX(), pos.getY(), pos.getZ());
        return true;

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
            markDirty();
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

    public boolean canInteractWith (EntityPlayer playerIn) {

        // If we are too far away from this tile entity you cannot use it
        return !isInvalid() && playerIn.getDistanceSq(pos.add(0.5D, 0.5D, 0.5D)) <= 64D;

    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return true;
        } else if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
            return true;
        }
        return super.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {

        /*AquacultureFluid brine = new AquacultureFluid(Aquaculture.MODID + ".brine", 1);
        AquacultureFluidBlock brineBlock = new AquacultureFluidBlock(brine, Material.WATER);
        //Item brineItem = Item.getItemFromBlock(brineBlock);

        if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
            return CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY.cast(FluidUtil.getFluidHandler(new ItemStack(brineBlock)));
        }*/
        return super.getCapability(capability, facing);
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
