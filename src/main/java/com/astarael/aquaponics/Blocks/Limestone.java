package com.astarael.aquaponics.Blocks;


import com.astarael.aquaponics.Aquaponics;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.common.registry.GameRegistry;



public class Limestone extends Block {
    public Limestone() {
        super(Material.ROCK);
        setUnlocalizedName(Aquaponics.MODID + ".limestone");     // Used for localization (en_US.lang)
        setRegistryName("limestone");        // The unique name (within your mod) that identifies this block
        }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}


