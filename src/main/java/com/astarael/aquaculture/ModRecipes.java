package com.astarael.aquaculture;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

    public static void init () {
        GameRegistry.addSmelting(ModBlocks.ore_rutile, new ItemStack(ModItems.ingotTitanium), 0.7f);
    }

}
