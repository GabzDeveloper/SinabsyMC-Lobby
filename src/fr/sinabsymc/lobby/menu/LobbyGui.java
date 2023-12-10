package fr.sinabsymc.lobby.menu;

import fr.sinabsymc.lobby.utils.CustomGui;
import fr.sinabsymc.lobby.utils.CustomItemStack;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class LobbyGui extends CustomGui {


    private static int[] redGlass = {0, 1, 7, 8, 9, 17, 27, 35, 36, 37, 43, 44};

    public LobbyGui(Player player) {
        super(5, "§8» §bLobby(s)", player);
        player.playSound(player.getLocation(), Sound.NOTE_PLING, 1f, 1f);

        for (int glass : redGlass) {
            setItem(glass, CustomItemStack.getPane(9).setName("§r"));
        }

        setItem(40, CustomItemStack.getCloseGuiItem());
        setItem(22, CustomItemStack.getSkull("http://textures.minecraft.net/texture/622872342d2cf20754b9e1bae9c0902912dcae12e63b520b6fe8bd911b91018b").setName("§b§lSERVEUR §f┃ §7Lobby-01").setLore("\n §8» §eID: §b§oLobby-01 \n §8» §bStatus: §a§lEn Ligne ✓ \n §8» §bVersion: §b1.8/1.19 \n §8» §bListe-Blanche: §c§l✘  \n \n§8» §cVous y êtes déjà connecté !"));
    }
}
