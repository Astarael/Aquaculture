package com.astarael.aquaculture.Blocks;

import com.astarael.aquaculture.Aquaculture;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockOre extends BlockBase {

    public BlockOre (String name) {

        super(Material.ROCK, name);

        setHardness(3f);
        setResistance(5f);
        setCreativeTab(Aquaculture.creativeTab);

    }

    @Override
    public BlockOre setCreativeTab (CreativeTabs tab) {

        super.setCreativeTab(tab);
        return this;

    }


}
