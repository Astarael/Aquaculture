package com.astarael.aquaculture.Items;

import com.astarael.aquaculture.Aquaculture;
import com.astarael.aquaculture.ModItems;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemArmour extends net.minecraft.item.ItemArmor {

    private String name;

    public ItemArmour(String name, ArmorMaterial material, EntityEquipmentSlot slot) {
        super(material, 0, slot);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.name = name;
    }

    public void registerItemModel () {
        Aquaculture.proxy.registerItemRenderer(this,0,name);
    }

    @Override
    public void onArmorTick (World world, EntityPlayer player, ItemStack itemStack) {

        // We only want to do this once per suit, not per piece
        if (this == ModItems.neopreneSuit) {
            if (player.isEntityAlive()) {
                if (!player.canBreatheUnderwater() && !player.isPotionActive(MobEffects.WATER_BREATHING) && !(player.capabilities.disableDamage)) {
                    if (player.inventory.armorItemInSlot(0).getItem() == ModItems.neopreneBoots &&
                            player.inventory.armorItemInSlot(1).getItem() == ModItems.neopreneLeggings &&
                            player.inventory.armorItemInSlot(2).getItem() == ModItems.neopreneSuit &&
                            player.inventory.armorItemInSlot(3).getItem() == ModItems.neopreneMask) {
                        if (player.getAir() < 300) {
                            player.setAir(increaseAirSupply(player.getAir()));
                        }
                    }
                }
            }
        }
    }

    private int increaseAirSupply (int air) {

        return air +1;

    }
}
