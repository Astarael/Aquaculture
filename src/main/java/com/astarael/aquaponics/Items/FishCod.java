package com.astarael.aquaponics.Items;

import net.minecraft.item.Item;
import com.astarael.aquaponics.Aquaponics;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FishCod extends Item {

    public FishCod() {
        setRegistryName("fishcod");        // The unique name (within your mod) that identifies this item
        setUnlocalizedName(Aquaponics.MODID + ".fishcod");     // Used for localization (en_US.lang)
    }
}
