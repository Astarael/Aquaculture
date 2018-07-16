package com.astarael.aquaculture.Blocks.Fluids;

import com.astarael.aquaculture.Aquaculture;
import net.minecraft.block.material.Material;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import java.awt.*;


// from http://jabelarminecraft.blogspot.com/p/minecraft-modding-custom-fluids.html?m=1

public class AquacultureFluid extends Fluid {

    private static int mapColor = 0x164264FF;
    private static float overlayAlpha = 0.2F;
    private static final int VISCOCITY = 1150;
    private static SoundEvent emptySound = SoundEvents.ITEM_BUCKET_EMPTY;
    private static SoundEvent fillSound = SoundEvents.ITEM_BUCKET_FILL;
    private static Material material = Material.WATER;


    public AquacultureFluid(String fluidName, ResourceLocation still, ResourceLocation flowing, Color color) {

        super(fluidName, still, flowing, new Color(36, 76, 190, 0xFF));
        super.setUnlocalizedName(fluidName);
        super.setViscosity(VISCOCITY);

    }

    public AquacultureFluid (String fluidName, ResourceLocation still, ResourceLocation flowing) {
        super(fluidName, still, flowing);
    }

    public AquacultureFluid (String fluidName, ResourceLocation still, ResourceLocation flowing, int mapColor) {
        this(fluidName, still, flowing);
        setColor(mapColor);
    }

    public AquacultureFluid (String fluidName, ResourceLocation still, ResourceLocation flowing, int mapColor, float overlayAlpha) {
        this(fluidName, still, flowing, mapColor);
        setAlpha(overlayAlpha);
    }

    public AquacultureFluid setColor(int parColor) {
        mapColor = parColor;
        return this;
    }

    public float getAlpha() {
        return overlayAlpha;
    }

    public AquacultureFluid setAlpha (float parOverlayAlpha) {
        overlayAlpha = parOverlayAlpha;
        return this;
    }

    @Override
    public AquacultureFluid setEmptySound (SoundEvent parSound) {
        emptySound = parSound;
        return this;
    }

    @Override
    public SoundEvent getEmptySound () {
        return emptySound;
    }

    @Override
    public AquacultureFluid setFillSound(SoundEvent parSound)
    {
        fillSound = parSound;
        return this;
    }

    @Override
    public SoundEvent getFillSound()
    {
        return fillSound;
    }

    public AquacultureFluid setMaterial(Material parMaterial)
    {
        material = parMaterial;
        return this;
    }

    public Material getMaterial()
    {
        return material;
    }

    @Override
    public boolean doesVaporize(FluidStack fluidStack)
    {
        if (block == null)
            return false;
        return block.getDefaultState().getMaterial() == getMaterial();
    }


}