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

public class HostGUI extends CustomGui implements Listener {
    private static int[] redGlass = {0,1,7,8,9,17,27,35,36,37,43,44};

    public HostGUI(Player player) {
        super(5, LanguageGUI.GUI_HOST, player);
        player.playSound(player.getLocation(), Sound.NOTE_PLING, 1f, 1f);

        for (int glass : redGlass) {
            setItem(glass, CustomItemStack.getPane(14).setName("§r"));
        }

        setItem(40, CustomItemStack.getCloseGuiItem());
        setItem(22, CustomItemStack.getSkull("http://textures.minecraft.net/texture/d69539424599d9487ed1031fa6aacfcf197358b8f188d62f7a1855efafd24f19").setName("§eHOST §6§lFallenKingdoms").setLore("\n§8» §7ID: FK-HOST1 \n \n§8» §7Hôte: §bGabriel__l \n \n§8» §7Statut: §a§lEn Ligne ✓"));
    }


    @EventHandler
    public void onClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();

        if(current == null) return;

        if(event.getInventory().getTitle().equals("§8» §aHost(s)")) {

            event.setCancelled(true);

            if (current.getType() == Material.BARRIER){
                player.closeInventory();
            }
        }
    }
}
