package com.astarael.aquaculture.Blocks.Fluids;

import com.astarael.aquaculture.Aquaculture;
import com.astarael.aquaculture.Registry.ModFluids;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class AquacultureFluidBlock extends BlockFluidClassic {

    private String name;

    public AquacultureFluidBlock (Fluid fluid, Material material) {

        super(fluid, material);
        setCreativeTab(Aquaculture.creativeTab);
        this.setUnlocalizedName(ModFluids.brineFluid.getUnlocalizedName());
        this.setRegistryName(ModFluids.brineFluid.getUnlocalizedName());

    }


    @Override
    public boolean canCreatureSpawn (IBlockState state, IBlockAccess world, BlockPos pos, EntityLiving.SpawnPlacementType type) {

        return false;
    }

}
