package com.astarael.aquaculture.Blocks.Fluids;


import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;


// TODO: care of tinkers construct

public class AquacultureFluid extends Fluid {

    private static int color;

    public static ResourceLocation LiquidStill = new ResourceLocation("blocks/fluids/fluid");
    public static ResourceLocation LiquidFlowing = new ResourceLocation("blocks/fluids/fluid_flow");

    public AquacultureFluid (String fluidName, int color) {

        super(fluidName, LiquidStill, LiquidFlowing);

        // make opaque if no alpha is set
        if(((color >> 24) & 0xFF) == 0) {
            color |= 0xFF << 24;
        }
        this.color = color;

    }

    @Override
    public int getColor() {
        return color;
    }

}