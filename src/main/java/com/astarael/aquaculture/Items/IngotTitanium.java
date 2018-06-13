package com.astarael.aquaculture.Items;

import com.astarael.aquaculture.Aquaculture;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class IngotTitanium extends Item {

    public IngotTitanium() {
        setRegistryName("ingottitanium");        // The unique name (within your mod) that identifies this item
        setUnlocalizedName(Aquaculture.MODID + ".ingottitanium");     // Used for localization (en_US.lang)
        //setCreativeTab(CreativeTabs.MATERIALS);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @SideOnly(Side.CLIENT)
    public void registerItemModel() {
        Aquaculture.proxy.registerItemRenderer(this,0,getUnlocalizedName());
    }
}
