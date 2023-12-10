package fr.sinabsymc.lobby.staffarmor;

import fr.sinabsymc.lobby.utils.CustomItemStack;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.util.EulerAngle;

public class StaffAmorManager {

    public static void SbyAnyNeverArmor(){

        ItemStack playerhead = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);

        SkullMeta playerheadmeta = (SkullMeta) playerhead.getItemMeta();
        playerheadmeta.setOwner("SbyAnyNever");
        playerhead.setItemMeta(playerheadmeta);
        Location location = new Location(Bukkit.getWorld("world"), -26.575, 69, -23.524);

        ArmorStand stand = (ArmorStand) Bukkit.getWorld("world").spawnEntity(location, EntityType.ARMOR_STAND);
        stand.setHelmet(playerhead);
        stand.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
        stand.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
        stand.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
        stand.setArms(true);
        stand.setBasePlate(false);

        stand.setRightLegPose(new EulerAngle(Math.toRadians(42f), Math.toRadians(269f), Math.toRadians(0f)));
        stand.setLeftLegPose(new EulerAngle(Math.toRadians(42f), Math.toRadians(96f), Math.toRadians(0f)));

        stand.setRightArmPose(new EulerAngle(Math.toRadians(177f), Math.toRadians(0f), Math.toRadians(336f)));
        stand.setLeftArmPose(new EulerAngle(Math.toRadians(112f), Math.toRadians(78f), Math.toRadians(332f)));

    }
}
