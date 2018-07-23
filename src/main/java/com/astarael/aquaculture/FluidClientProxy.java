package com.astarael.aquaculture;

import com.astarael.aquaculture.Blocks.Fluids.AquacultureFluid;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

import javax.annotation.Nonnull;

public class FluidClientProxy extends ClientProxy {

    @Override
    public void registerModels () {

        registerFluidModels(AquacultureFluids.brine);

    }

    public void registerFluidModels (AquacultureFluid fluid) {
        if (fluid == null) {
            return;
        }

        Block block = fluid.getBlock();
        if (block != null) {
            Item item = Item.getItemFromBlock(block);
            FluidStateMapper mapper = new FluidStateMapper(fluid);

            // item model
            ModelLoader.registerItemVariants(item);
            ModelLoader.setCustomMeshDefinition(item, mapper);

            // block model
            ModelLoader.setCustomStateMapper(block, mapper);
        }
    }

    public static class FluidStateMapper extends StateMapperBase implements ItemMeshDefinition {

        public final AquacultureFluid fluid;
        public final ModelResourceLocation location;

        public FluidStateMapper (AquacultureFluid fluid) {

            this.fluid = fluid;
            this.location = new ModelResourceLocation(new ResourceLocation("fluid_block"), fluid.getName());

        }

        @Nonnull
        @Override
        protected ModelResourceLocation getModelResourceLocation (@Nonnull IBlockState state) {

            return location;

        }

        @Nonnull
        @Override
        public ModelResourceLocation getModelLocation (@Nonnull ItemStack stack) {

            return location;

        }
    }

}
