package com.astarael.aquaculture.TileEntitities;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraftforge.fluids.FluidUtil;

public class TileEntityVat extends TileEntity implements ITickable {

    // to prevent updating every tick we delay it for 10 ticks until the next check
    private int delayCounter = 10;

    private ItemStack inputStack;
    private ItemStack outputStack;
    private FluidTank fluidTank;

    public TileEntityVat () {

        super();
        fluidTank = new FluidTank(128000);
        inputStack = new ItemStack((Item) null);
        outputStack = new ItemStack((Item) null);


    }

    public ItemStack getInputStack () {
        return inputStack;
    }

    public ItemStack getOutputStack () {
        return outputStack;
    }

    public FluidTank getFluidTank () {
        return fluidTank;
    }

    public ItemStack getStack(boolean input) {
        if (input) {
            return inputStack;
        } else {
            return outputStack;
        }
    }

    public void setStack(ItemStack stack, boolean input) {
        if (input) {
            inputStack = stack;
        } else {
            outputStack = stack;
        }
        markDirty();
        if (world != null) {
            IBlockState state = null;
                    //getBlockState(getPos());
            world.notifyBlockUpdate(getPos(), state, state, 3);
        }
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

        super.readFromNBT(nbt);
        if (nbt.hasKey("inputItem")) {
            inputStack = new ItemStack(nbt.getCompoundTag("inputItem"));
        } else {
            inputStack = ItemStack.EMPTY;
        }
        if (nbt.hasKey("outputItem")) {
            outputStack = new ItemStack(nbt.getCompoundTag("outputItem"));
        } else {
            outputStack = ItemStack.EMPTY;
        }
        fluidTank.readFromNBT(nbt.getCompoundTag("FluidTank"));

    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {

        super.writeToNBT(nbt);
        if (!inputStack.isEmpty()) {
            NBTTagCompound tagCompound = new NBTTagCompound();
            inputStack.writeToNBT(tagCompound);
            nbt.setTag("inputItem", tagCompound);
        }
        if (!outputStack.isEmpty()) {
            NBTTagCompound tagCompound = new NBTTagCompound();
            outputStack.writeToNBT(tagCompound);
            nbt.setTag("outputItem", tagCompound);
        }
        nbt.setTag("FluidTank", fluidTank.writeToNBT(new NBTTagCompound()));
        return nbt;

    }

    @Override
    public NBTTagCompound getUpdateTag() {
        // getUpdateTag() is called whenever the chunkdata is sent to the
        // client. In contrast getUpdatePacket() is called when the tile entity
        // itself wants to sync to the client. In many cases you want to send
        // over the same information in getUpdateTag() as in getUpdatePacket().
        return writeToNBT(new NBTTagCompound());
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        // Prepare a packet for syncing our TE to the client. Since we only have to sync the stack
        // and that's all we have we just write our entire NBT here. If you have a complex
        // tile entity that doesn't need to have all information on the client you can write
        // a more optimal NBT here.
        NBTTagCompound nbtTag = new NBTTagCompound();
        this.writeToNBT(nbtTag);
        return new SPacketUpdateTileEntity(getPos(), 1, nbtTag);
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
        // Here we get the packet from the server and read it into our client side tile entity
        this.readFromNBT(packet.getNbtCompound());
    }

}
