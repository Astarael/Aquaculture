package com.astarael.aquaculture;

import com.astarael.aquaculture.Blocks.*;
import com.astarael.aquaculture.Registry.ModBlocks;
import com.astarael.aquaculture.Registry.ModFluids;
import com.astarael.aquaculture.Registry.ModItems;
import com.astarael.aquaculture.TileEntitities.*;
import com.astarael.aquaculture.TileEntitities.Inventories.GuiProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.*;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.io.File;

@Mod.EventBusSubscriber
public class CommonProxy {

    // Config instance
    public static Configuration config;

    public void preInit (FMLPreInitializationEvent e) {
        File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "aquaculture.cfg"));
        Config.readConfig();

    }

    public void init (FMLInitializationEvent e) {
        NetworkRegistry.INSTANCE.registerGuiHandler(Aquaculture.instance, new GuiProxy());
    }

    public void postInit (FMLPostInitializationEvent e) {
        if (config.hasChanged()) {
            config.save();
        }
    }

    public void registerModels() {

    }

    public void registerItemRenderer (Item item, int meta, String id) {

    }

    @SubscribeEvent
    public static void registerBlocks (RegistryEvent.Register<Block> event) {

        event.getRegistry().register(new Limestone());
        event.getRegistry().register(new LimeKiln());
        event.getRegistry().register(new Ore_Rutile());

        event.getRegistry().register(ModFluids.blockBrine);

        GameRegistry.registerTileEntity(LimeKilnEntity.class, new ResourceLocation(Aquaculture.MODID + ":limekiln"));
        GameRegistry.registerTileEntity(TileEntityEvaporationTower.class, new ResourceLocation(Aquaculture.MODID + ":evaporationtower"));
        GameRegistry.registerTileEntity(TileEntityVat.class, new ResourceLocation(Aquaculture.MODID + ":vat"));

    }

    @SubscribeEvent
    public static void registerItems (RegistryEvent.Register<Item> event) {

        // Items
        ModItems.register(event.getRegistry());
        ModItems.registerModels();

        // ItemBlocks
        event.getRegistry().register(new ItemBlock(ModBlocks.limestone).setRegistryName(ModBlocks.limestone.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.vat).setRegistryName(ModBlocks.vat.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.ore_rutile).setRegistryName(ModBlocks.ore_rutile.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.limeKiln).setRegistryName(ModBlocks.limeKiln.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.evaporationTower).setRegistryName(ModBlocks.evaporationTower.getRegistryName()));

    }

    static {
        FluidRegistry.enableUniversalBucket();
    }

}





