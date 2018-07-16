package com.astarael.aquaculture.Blocks.Fluids;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fluids.Fluid;

public class AquacultureFluidBlock extends BlockFluidFinite {

    private String name;

    public AquacultureFluidBlock(Fluid fluid, Material material, String name) {

        super(fluid, material);
        this.name = name;

    }


    @Override
    public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, net.minecraft.entity.EntityLiving.SpawnPlacementType type) {

        return false;
    }


}
