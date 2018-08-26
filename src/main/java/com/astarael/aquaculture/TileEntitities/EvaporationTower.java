package com.astarael.aquaculture.TileEntitities;

import com.astarael.aquaculture.Aquaculture;
import jline.internal.Nullable;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EvaporationTower extends BlockTileEntity<TileEntityEvaporationTower> {

    public static final int GUI_ID = 1;

    public EvaporationTower () {
        super(Material.ROCK, Aquaculture.MODID + ".evaporationtower");
        setCreativeTab(Aquaculture.creativeTab);
    }

    @Override
    public Class<TileEntityEvaporationTower> getTileEntityClass () {
        return TileEntityEvaporationTower.class;
    }

    @Nullable
    @Override
    public TileEntityEvaporationTower createTileEntity (World world, IBlockState state) {
        return new TileEntityEvaporationTower();
    }

    // Called just after the player places a block.  Start the tileEntity's timer
    @Override
    public void onBlockPlacedBy (World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {

        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        if (tileentity instanceof TileEntityEvaporationTower) { // prevent a crash if not the right type, or is null
            TileEntityEvaporationTower tileEntityEvaporationTower = (TileEntityEvaporationTower)tileentity;
        }

    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
                                    EnumFacing side, float hitX, float hitY, float hitZ) {

        //TODO Bucket handling

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
}
