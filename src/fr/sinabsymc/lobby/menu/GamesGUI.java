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
import org.bukkit.inventory.meta.SkullMeta;

public class GamesGUI extends CustomGui implements Listener {


    private static int[] redGlass = {0, 1, 7, 8, 9, 17, 36, 44, 45, 46, 52, 53};

    public GamesGUI(Player player) {

        super(6, LanguageGUI.GUI_GAMES, player);
        ItemStack playerhead = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);

        SkullMeta playerheadmeta = (SkullMeta) playerhead.getItemMeta();
        playerheadmeta.setOwner("SbyAnyNever");
        playerhead.setItemMeta(playerheadmeta);
        player.playSound(player.getLocation(), Sound.NOTE_PLING, 1f, 1f);
        for (int glass : redGlass) {
            setItem(glass, CustomItemStack.getPane(14).setName("§r"));
        }

        setItem(49, CustomItemStack.getCloseGuiItem());
        setItem(20, CustomItemStack.getSkull("http://textures.minecraft.net/texture/d69539424599d9487ed1031fa6aacfcf197358b8f188d62f7a1855efafd24f19").setName("§6§lFallen Kingdoms §f┃ §dPOPULAIRE").setLore("\n §8» §eDéveloppeur: §b@Gabriel__l \n §8» §eVersion: §b1.8 \n §8» §eStatut: §eOuvert \n \n§8» §eBooster(s): §c§l✘ \n \n§8» §eImpossible de Rejoindre..."), player1 ->
                player1.sendMessage("§c§lPROXY §f• §cAucun serveur 'FALLENKINGDOMS' n'est Disponible.")) ;
        setItem(22, CustomItemStack.getSkull("http://textures.minecraft.net/texture/c3fe24a91e14944861ff37c7a60e18c5fc54a41a8531f9ba6124d15292249824").setName("§f┃ §e§lFFARush ").setLore("\n §8» §eDéveloppeur: §b@Gabriel__l \n §8» §eVersion: §b1.8 \n §8» §eStatut: §aOuvert \n \n§8» §eBooster(s): §c§l✘ \n \n§8» §eImpossible de Rejoindre..."), player1 ->
                player1.sendMessage("§c§lPROXY §f• §cAucun serveur 'FFARUSH' n'est Disponible.")) ;
        setItem(24, CustomItemStack.getSkull("http://textures.minecraft.net/texture/8d416117aedb88f0f459830e072a3c8ae575f8e3b2f1c6f68ef9adddc9b2adb1").setName("§f┃ §c§lPVPFight").setLore("\n §8» §eDéveloppeur: §b@Gabriel__l \n §8» §eVersion: §b1.8 \n §8» §eStatut: §aOuvert \n \n§8» §eBooster(s): §c§l✘ \n \n§8» §eImpossible de Rejoindre..."), player1 ->
                player1.sendMessage("§c§lPROXY §f• §cAucun serveur 'PVPFIGHT' n'est Disponible.")) ;
        setItem(30, CustomItemStack.getSkull("http://textures.minecraft.net/texture/16bb9fb97ba87cb727cd0ff477f769370bea19ccbfafb581629cd5639f2fec2b").setName("§a§lSurvie §f┃ §dPOPULAIRE").setLore("\n §8» §eDéveloppeur: §b@Gabriel__l \n §8» §eVersion: §b1.19 \n §8» §eStatut: §aOuvert \n \n§8» §eBooster(s): §c§l✘ \n \n§8» §eImpossible de Rejoindre..."), player1 ->
                player1.sendMessage("§c§lPROXY §f• §cAucun serveur 'Survie' n'est Disponible.")) ;
        setItem(32, CustomItemStack.getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025").setName("§f┃ §c§kééééééé").setLore("\n §8» §eDéveloppeur: §b@Gabriel__l \n §8» §eVersion: §c§kéééé \n §8» §eStatut: §cHors-Ligne \n \n§8» §eBooster(s): §c§l✘ \n \n§8» §eImpossible de Rejoindre..."), player1 ->
                player1.sendMessage("§c§lSinabsyMC §f• §cCe Jeux n'est pas encore Disponible.")) ;
        setItem(4, CustomItemStack.getSkull("http://textures.minecraft.net/texture/ba9053d2163d0f561145d33a513145d4ac1f8a458baa796be383e7525a05f45").setName("§a✪ §f┃ §a§lCréer ton Serveur !").setLore("\n§8• §7Créer ton Serveur, et joue avec tes Amis ! \n§8• §7Pleins de MDJ y sont proposé ! \n \n§8» §7Grade REQUIS: §9Titan \n \n§8» §eClique-Droit pour ouvrir."));
        setItem(2, CustomItemStack.getNeverHead().setName("§a✪ §f┃ §dServeur: Événementiel").setLore("\n §8» §eDéveloppeur: §b@Gabriel__l \n §8» §eVersion: §b1.8  1.19 \n §8» §eStatut: §cFermé \n \n§8» §eBooster(s): §c§l✘ \n \n§8» §eAucun Évenement en Cours..."));
    }

}
