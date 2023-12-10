package fr.sinabsymc.lobby.listeners;

import fr.sinabsymc.lobby.menu.LanguageGUI;
import fr.sinabsymc.lobby.utils.CustomItemStack;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class SinabsyInventory implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();

        if (current == null) return;

        if (event.getInventory().getTitle().equals(LanguageGUI.GUI_GAMES)) {

            event.setCancelled(true);
            if (current.getType() == Material.BARRIER) {
                player.closeInventory();
            }

        } else if (event.getInventory().getTitle().equals(LanguageGUI.GUI_SHOP)) {

            event.setCancelled(true);
            if (current.getType() == Material.BARRIER){
                player.closeInventory();
            }

        } else if (event.getInventory().getTitle().equalsIgnoreCase(LanguageGUI.GUI_SERVER_MANAGEMENT)){
            event.setCancelled(true);
            if (current.getType() == Material.BARRIER){
                player.closeInventory();
            }


        } else if (event.getInventory().getTitle().equalsIgnoreCase("§8» §bLobby(s)")){
            event.setCancelled(true);
            if (current.getType() == Material.BARRIER){
                player.closeInventory();
            }
        }
    }
}
