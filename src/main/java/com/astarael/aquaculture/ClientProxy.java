package com.astarael.aquaculture;

import com.astarael.aquaculture.Registry.ModBlocks;
import com.astarael.aquaculture.Registry.ModFluids;
import com.astarael.aquaculture.Registry.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.item.Item;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    public void registerItemRenderer (Item item, int meta, String id) {

        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));

    }

    @Override
    public void preInit (FMLPreInitializationEvent e) {

        super.preInit(e);

        OBJLoader.INSTANCE.addDomain(Aquaculture.MODID);

    }

    public void registerModels(ModelRegistryEvent event) {
        ModBlocks.initModels(event);
        //ModItems.initModels(event);
        ModFluids.initModels();

        //registerRenderers();
    }

    /*@SubscribeEvent
    public static void registerModels (ModelRegistryEvent event) {

        ModBlocks.initModels(event);
        ModItems.registerModels();

    }*/
}
