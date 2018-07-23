package com.astarael.aquaculture;

import com.astarael.aquaculture.Blocks.Fluids.AquacultureFluid;
import com.astarael.aquaculture.Blocks.Fluids.AquacultureFluidBlock;
import com.google.common.eventbus.Subscribe;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;


public class AquacultureFluids {

    @SidedProxy(clientSide = "com.astarael.aquaculture.FluidClientProxy", serverSide = "com.astarael.aquaculture.CommonProxy")
    public static CommonProxy proxy;

    public static AquacultureFluid brine;

    static {
        setupFluids();
    }

    public static void setupFluids() {

        FluidRegistry.enableUniversalBucket();

        // hex code
        brine = new AquacultureFluid(Aquaculture.MODID + ":brine", 0x103464);
        brine.setViscosity(1100);


    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();
        registerFluidBlock(registry, brine);
    }

    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        proxy.registerModels();
    }

    @Subscribe
    public void preInit (FMLPreInitializationEvent e) {
        proxy.preInit(e);
    }

    @Subscribe
    public void init (FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Subscribe
    public void postInit (FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

    /** Registers a non-burning water based block for the fluid */
    public static BlockFluidBase registerFluidBlock(IForgeRegistry<Block> registry, Fluid fluid) {

        registry.register(new AquacultureFluidBlock(fluid, Material.WATER));
        return registerBlock(registry, new AquacultureFluidBlock(fluid, Material.WATER), fluid.getName());
    }

    protected static <T extends Block> T registerBlock(IForgeRegistry<Block> registry, T block, String name) {
        register(registry, block, name);
        return block;
    }

    protected static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T thing, String name) {

        registry.register(thing);
        return thing;
    }

}


