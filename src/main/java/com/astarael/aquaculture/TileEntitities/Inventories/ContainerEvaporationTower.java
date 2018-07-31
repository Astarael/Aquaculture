package com.astarael.aquaculture.TileEntitities.Inventories;

import com.astarael.aquaculture.TileEntitities.TileEntityEvaporationTower;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nullable;

public class ContainerEvaporationTower extends BaseContainer<TileEntityEvaporationTower> {

    private TileEntityEvaporationTower tower;

    public ContainerEvaporationTower(IInventory playerInventory, TileEntityEvaporationTower tile) {
        super(playerInventory, tile);
        tower = tile;
        addPlayerSlots(playerInventory);
    }

    private void addOwnSlots() {
        IItemHandler itemHandler = tower.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
        IFluidHandler fluidHandler = tower.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null);
        int x = 9;
        int y = 6;

        // Add our own slots
        int slotIndex = 0;
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex, x, y));
            slotIndex++;
            x += 18;
        }
    }

    @Nullable
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = null;
        Slot slot = inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < 9) {
                if (!mergeItemStack(itemstack1, 9, inventorySlots.size(), true)) {
                    return null;
                }
            } else if (!mergeItemStack(itemstack1, 0, 9, false)) {
                return null;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }

    @Override
    public boolean canInteractWith (EntityPlayer playerIn) {

        return tower.canInteractWith(playerIn);

    }

}
