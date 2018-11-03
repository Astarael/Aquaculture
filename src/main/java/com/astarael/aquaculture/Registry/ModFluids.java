package com.astarael.aquaculture.Registry;

import com.astarael.aquaculture.Aquaculture;
import com.astarael.aquaculture.Blocks.BlockAquacultureFluid;
import com.astarael.aquaculture.Blocks.Fluids.AquacultureFluid;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModFluids {

    public static final AquacultureFluid brineFluid = new AquacultureFluid("brine", getStill("brine"), getFlowing(("brine")));
    public static BlockAquacultureFluid blockBrine = new BlockAquacultureFluid("brine", brineFluid, Material.WATER);

    public static BlockFluidFinite registerFluidBlock (Fluid fluid, String name, Material material) {

        BlockFluidFinite fluidBlock = new BlockFluidFinite(fluid, material);
        fluidBlock.setRegistryName(name + "block");

        return fluidBlock;
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        brineFluid.initModel();
    }

    private static ResourceLocation getStill(String name) {
        return new ResourceLocation(Aquaculture.MODID, name + "_still");
    }

    private static ResourceLocation getFlowing(String name) {
        return new ResourceLocation(Aquaculture.MODID, name + "_flow");
    }


}
