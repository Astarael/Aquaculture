package com.astarael.aquaculture.Registry;

import com.astarael.aquaculture.Aquaculture;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.IFluidBlock;

import java.util.function.Consumer;
import java.util.function.Function;

public class ModFluids {

    public static Fluid registerFluid(String name) {

        name += "Fluid";
        Fluid fluid = new Fluid(name, getStill(name), getFlowing(name));
        FluidRegistry.addBucketForFluid(fluid);

        return fluid;
    }

    public static BlockFluidFinite registerFluidBlock (Fluid fluid, String name, Material material) {

        BlockFluidFinite fluidBlock = new BlockFluidFinite(fluid, material);
        fluidBlock.setRegistryName(name + "Block");

        return fluidBlock;
    }

    private static ResourceLocation getStill(String name) {
        return new ResourceLocation(Aquaculture.MODID, name + "_still");
    }

    private static ResourceLocation getFlowing(String name) {
        return new ResourceLocation(Aquaculture.MODID, name + "_flow");
    }


}
