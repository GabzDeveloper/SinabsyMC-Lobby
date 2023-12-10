package fr.sinabsymc.lobby.menu;

import fr.sinabsymc.lobby.utils.CustomGui;
import fr.sinabsymc.lobby.utils.CustomItemStack;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class ShopGUI extends CustomGui {

    private static int[] yellowGlass = {0,1,7,8,9,17,27,35,36,37,43,44};

    public ShopGUI(Player player) {
        super(5, LanguageGUI.GUI_SHOP, player);
        player.playSound(player.getLocation(), Sound.NOTE_PLING, 1f, 1f);

        for (int glass : yellowGlass) {
            setItem(glass, CustomItemStack.getPane(4).setName("§r"));
        }

        setItem(40, CustomItemStack.getCloseGuiItem());
        setItem(22, CustomItemStack.getSkull("http://textures.minecraft.net/texture/790f62ec5fa2e93e67cf1e00db8af4b47ac7ac769aa09a203a1f575a12710b10").setName("§c§lSinabsy+ ").setLore("\n"));
    }

}

