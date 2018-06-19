package com.astarael.aquaculture.Blocks;


import com.astarael.aquaculture.Aquaculture;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Limestone extends Block {

    public Limestone() {

        super(Material.ROCK);
        setUnlocalizedName(Aquaculture.MODID + ".limestone");     // Used for localization (en_US.lang)
        setRegistryName("limestone");        // The unique name (within your mod) that identifies this block

        setCreativeTab(Aquaculture.creativeTab);

        }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}


