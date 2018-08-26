package com.astarael.aquaculture.Registry;

import com.astarael.aquaculture.Aquaculture;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluids {

    public static Fluid brineFluid;

    public static void init()
    {
        registerBrineFluid();
    }

    private static void registerBrineFluid()
    {
        brineFluid = new Fluid("brinefluid", getStill("blocks/fluids/brine_still"),getFlowing("blocks/fluids/brine_flow"));
        FluidRegistry.addBucketForFluid(brineFluid);
    }

    public static ResourceLocation getStill(String name)
    {
        return new ResourceLocation(Aquaculture.MODID, name);
    }

    public static ResourceLocation getFlowing(String name)
    {
        return new ResourceLocation(Aquaculture.MODID, name);
    }
}
