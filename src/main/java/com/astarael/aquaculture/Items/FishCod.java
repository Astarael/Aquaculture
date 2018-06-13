package com.astarael.aquaculture.Items;

import com.astarael.aquaculture.Aquaculture;
import net.minecraft.item.Item;

public class FishCod extends Item {

    public FishCod() {
        setRegistryName("fishcod");        // The unique name (within your mod) that identifies this item
        setUnlocalizedName(Aquaculture.MODID + ".fishcod");     // Used for localization (en_US.lang)
    }
}
