package com.astarael.aquaculture.TileEntitities;

import com.astarael.aquaculture.Aquaculture;
import jline.internal.Nullable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EvaporationTower extends BlockTileEntity<TileEntityEvaporationTower> {

    public EvaporationTower () {
        super(Material.ROCK, Aquaculture.MODID + ".evaporationtower");
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



}
