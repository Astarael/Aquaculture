package com.astarael.aquaculture.Blocks.Fluids;

import com.astarael.aquaculture.Aquaculture;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class AquacultureFluidBlock extends BlockFluidClassic {

    private String name;

    public AquacultureFluidBlock (Fluid fluid, Material material) {

        super(fluid, material);
        setCreativeTab(Aquaculture.creativeTab);

    }


    @Override
    public boolean canCreatureSpawn (IBlockState state, IBlockAccess world, BlockPos pos, net.minecraft.entity.EntityLiving.SpawnPlacementType type) {

        return false;
    }

    @Override
    public BlockFaceShape getBlockFaceShape (IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {

        return BlockFaceShape.UNDEFINED;

    }


}
