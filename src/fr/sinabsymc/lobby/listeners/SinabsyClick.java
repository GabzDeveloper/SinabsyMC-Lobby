package fr.sinabsymc.lobby.listeners;

import fr.sinabsymc.lobby.SinabsyLobby;
import fr.sinabsymc.lobby.menu.GamesGUI;
import fr.sinabsymc.lobby.menu.LobbyGui;
import fr.sinabsymc.lobby.menu.ShopGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class SinabsyClick implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getAction() == Action.PHYSICAL) return;
        ItemStack current = e.getItem();
        if (current == null) return;
        if (getName(current).equalsIgnoreCase(getName(SinabsyConnect.getMenu()))){
            new GamesGUI(player).open(player);
            e.setCancelled(true);

        } else if (getName(current).equalsIgnoreCase(getName(SinabsyConnect.getBoutique()))){
            player.sendMessage("§e§lBOUTIQUE §f┃ §eNotre boutique n'est pas disponible pendant la §cBêta §e!");
            e.setCancelled(true);

        } else if (getName(current).equalsIgnoreCase(getName(SinabsyConnect.getCosmetics()))){
            player.sendMessage("§6§lCOSMÉTIQUES §f┃ §6Nos cosmétiques ne sont pas disponible pendant la §cBêta §e!");
            e.setCancelled(true);
        } else if (getName(current).equalsIgnoreCase(getName(SinabsyConnect.getLobbys()))){
            new LobbyGui(player).open(player);
            e.setCancelled(true);
        }
    }


    public String getName(ItemStack it) {
        if (it.hasItemMeta() && it.getItemMeta().hasDisplayName()) return it.getItemMeta().getDisplayName();
        return it.getType().toString();
    }
}
