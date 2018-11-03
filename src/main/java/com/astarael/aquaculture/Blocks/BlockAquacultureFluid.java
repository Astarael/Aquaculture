package com.astarael.aquaculture.Blocks;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fluids.Fluid;

public class BlockAquacultureFluid extends BlockFluidFinite {

    public BlockAquacultureFluid(String name, Fluid fluid, Material material) {

        super(fluid, material);
        setRegistryName(name);
    }
}
