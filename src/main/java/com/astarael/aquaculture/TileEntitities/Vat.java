package com.astarael.aquaculture.TileEntitities;

import com.astarael.aquaculture.Aquaculture;
import jline.internal.Nullable;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class Vat extends BlockTileEntity<TileEntityVat> {

    private static boolean INPUT = true;
    private static boolean OUTPUT = false;

    public Vat() {

        super(Material.ROCK, Aquaculture.MODID +".vat");
        setCreativeTab(Aquaculture.creativeTab);

    }

    @Override
    public Class<TileEntityVat> getTileEntityClass () {
        return TileEntityVat.class;
    }

    @Nullable
    @Override
    public TileEntityVat createTileEntity (World world, IBlockState state) {
        return new TileEntityVat();
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    // Called just after the player places a block.  Start the tileEntity's timer
    @Override
    public void onBlockPlacedBy (World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {

        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        if (tileentity instanceof TileEntityVat) { // prevent a crash if not the right type, or is null
            TileEntityVat tileEntityVat = (TileEntityVat)tileentity;


        }



    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
                                    EnumFacing side, float hitX, float hitY, float hitZ) {

        //TODO Bucket handling

        // Only execute on the server
        if (world.isRemote) {
            return true;
        }



        TileEntityVat te = (TileEntityVat) world.getTileEntity(pos);
        if (!(te instanceof TileEntityVat)) {
            return false;
        }

        if (FluidUtil.interactWithFluidHandler(player, hand, world, pos, side)) {
        } else {

            ItemStack heldItem = player.getHeldItem(hand);

            if (te.getStack(INPUT).isEmpty()) {

                if (!heldItem.isEmpty()) {
                    // There is no item in the pedestal and the player is holding an item. We move that item
                    // to the pedestal
                    te.setStack(heldItem,INPUT);
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
                    // Make sure the client knows about the changes in the player inventory
                    player.openContainer.detectAndSendChanges();
                }
            } else if (te.getStack(INPUT).isItemEqual(heldItem)) {
                te.setStack(new ItemStack (heldItem.getItem(),(te.getStack(INPUT).getCount() + heldItem.getCount())), INPUT);
                player.openContainer.detectAndSendChanges();
            } else {
                // There is a stack in the pedestal. In this case we remove it and try to put it in the
                // players inventory if there is room
                ItemStack stack = te.getStack(OUTPUT);
                te.setStack(ItemStack.EMPTY, OUTPUT);
                if (!player.inventory.addItemStackToInventory(stack)) {
                    // Not possible. Throw item in the world
                    EntityItem entityItem = new EntityItem(world, pos.getX(), pos.getY() + 1, pos.getZ(), stack);
                    world.spawnEntity(entityItem);
                } else {
                    player.openContainer.detectAndSendChanges();
                }
            }
        }

        return true;
    }

}
