package com.astarael.aquaculture;

import com.astarael.aquaculture.Blocks.*;
import com.astarael.aquaculture.Blocks.Fluids.AquacultureFluid;
import com.astarael.aquaculture.Blocks.Fluids.AquacultureFluidBlock;
import com.astarael.aquaculture.TileEntitities.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.*;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.io.File;

@Mod.EventBusSubscriber
public class CommonProxy {

    // Config instance
    public static Configuration config;

    public void preInit(FMLPreInitializationEvent e) {
        File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "aquaculture.cfg"));
        Config.readConfig();
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
        if (config.hasChanged()) {
            config.save();
        }
    }

    public void registerItemRenderer(Item item, int meta, String id) {

    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

        event.getRegistry().register(new Limestone());
        event.getRegistry().register(new LimeKiln());
        event.getRegistry().register(new Ore_Rutile());
        //event.getRegistry().register(new Vat());

        GameRegistry.registerTileEntity(LimeKilnEntity.class, new ResourceLocation(Aquaculture.MODID + ".limekiln"));
        GameRegistry.registerTileEntity(new EvaporationTower().getTileEntityClass(), new ResourceLocation(Aquaculture.MODID + ".evaporationtower"));
        GameRegistry.registerTileEntity(new Vat().getTileEntityClass(), new ResourceLocation(Aquaculture.MODID + ".vat"));

        // FLUIDS
        AquacultureFluid brine = new AquacultureFluid(Aquaculture.MODID + ".brine", new ResourceLocation(Aquaculture.MODID + ".brine_still"), new ResourceLocation(Aquaculture.MODID + ".brine_flowing"));
        FluidRegistry.registerFluid(brine);
        FluidRegistry.addBucketForFluid(brine);
        AquacultureFluidBlock brineBlock = new AquacultureFluidBlock(brine, Material.WATER, Aquaculture.MODID + ".brine");
        Item brineItem = Item.getItemFromBlock(brineBlock);
        brineItem.setCreativeTab(Aquaculture.creativeTab);
        StateMapper mapper = new StateMapper (Aquaculture.MODID, "fluid", Aquaculture.MODID + ".brine");

        ModelBakery.registerItemVariants(brineItem);
        ModelLoader.setCustomMeshDefinition(brineItem,mapper);
        ModelLoader.setCustomStateMapper(brineBlock, mapper);

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

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





