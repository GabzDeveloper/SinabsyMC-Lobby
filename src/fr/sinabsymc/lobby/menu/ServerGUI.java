package fr.sinabsymc.lobby.menu;

import fr.sinabsymc.lobby.utils.CustomGui;
import fr.sinabsymc.lobby.utils.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ServerGUI extends CustomGui implements Listener {


    private static int[] cyanGlass = {0,1,7,8,9,17,36,44,45,46,52,53};

    public ServerGUI(Player player) {
        super(6, LanguageGUI.GUI_SERVER_MANAGEMENT, player);
        player.playSound(player.getLocation(), Sound.NOTE_PLING, 1f, 1f);
        for (int glass : cyanGlass) {
            setItem(glass, CustomItemStack.getPane(9).setName("§r"));
        }

        setItem(49, CustomItemStack.getCloseGuiItem());
        setItem(20, CustomItemStack.getSkull("http://textures.minecraft.net/texture/622872342d2cf20754b9e1bae9c0902912dcae12e63b520b6fe8bd911b91018b").setName("§b§lSERVEUR §f┃ §7Lobby-01").setLore("\n §8» §eID: §b§oLobby-01 \n §8» §eStatus: §a§lEn Ligne ✓ \n §8» §eVersion: §b1.8/1.19 \n §8» §eListe-Blanche: §c§l✘ \n \n §8» §eAmplificateur: §c§l✘ \n \n§8» §cVous y êtes déjà connecté !"));
    }


    @EventHandler
    public void onClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();

        if(current == null) return;

        if(event.getInventory().getTitle().equals("§8» §cMenu Principal")) {

            event.setCancelled(true);

            if (current.getType() == Material.BARRIER){
                player.closeInventory();
            }
        }
    }
}
