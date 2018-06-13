package com.astarael.aquaculture;

import com.astarael.aquaculture.Items.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    public static ItemBase ingotTitanium = new ItemBase("ingot_titanium").setCreativeTab(CreativeTabs.MATERIALS);
    public static ItemBase burntBrick = new ItemBase("burnt_brick").setCreativeTab(CreativeTabs.MATERIALS);

    public static void register(IForgeRegistry<Item> registry) {

        registry.registerAll(ingotTitanium,burntBrick);

    }

    public static void registerModels() {

        ingotTitanium.registerItemModel();
        burntBrick.registerItemModel();

    }

}
