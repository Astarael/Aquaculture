package com.astarael.aquaculture.Items;

import com.astarael.aquaculture.Aquaculture;
import com.astarael.aquaculture.Registry.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemArmour extends net.minecraft.item.ItemArmor {

    private String name;
    // vanilla has a hardcoded maximum air limit of 300 (15 seconds * 20 ticks)
    private static final int vanillaMaxAir = 300;

    public ItemArmour(String name, ArmorMaterial material, EntityEquipmentSlot slot) {
        super(material, 0, slot);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.name = name;
        setCreativeTab(Aquaculture.creativeTab);
    }

    @Override
    public ItemArmour setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    public void registerItemModel () {
        Aquaculture.proxy.registerItemRenderer(this,0,name);
    }

    @Override
    public void onArmorTick (World world, EntityPlayer player, ItemStack itemStack) {

        // We only want to do this once per suit, not per piece
        // This check is a copy of the code in net.minecraftforge.EntityLivingBase.onEntityUpdate()
        if (this == ModItems.neopreneMask) {
            if (player.isEntityAlive()) {
                if (!player.canBreatheUnderwater() && !player.isPotionActive(MobEffects.WATER_BREATHING) && !(player.capabilities.disableDamage)) {
                    if (player.inventory.armorItemInSlot(0).getItem() == ModItems.neopreneBoots &&
                            player.inventory.armorItemInSlot(1).getItem() == ModItems.neopreneLeggings &&
                            player.inventory.armorItemInSlot(2).getItem() == ModItems.neopreneSuit &&
                            player.inventory.armorItemInSlot(3).getItem() == ModItems.neopreneMask) {
                        if (player.getAir() < (vanillaMaxAir - 3)) {
                            // We want to increase air by a lot until we get to the Minecraft vanilla max
                            player.setAir(increaseAirSupply(player.getAir()));
                            player.setAir(increaseAirSupply(player.getAir()));
                            player.setAir(increaseAirSupply(player.getAir()));
                        } else if (player.getAir() < vanillaMaxAir) {
                            player.setAir(increaseAirSupply(player.getAir()));
                        }
                    }
                }
            }
        }
    }

    private int increaseAirSupply (int air) {

        return air + 1;

    }
}
