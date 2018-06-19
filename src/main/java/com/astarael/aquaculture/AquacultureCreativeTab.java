package com.astarael.aquaculture;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class AquacultureCreativeTab extends CreativeTabs {

    public AquacultureCreativeTab () {
        super(Aquaculture.MODID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.burntBrick);
    }

}
