package fr.sinabsymc.lobby.listeners;

import fr.sinabsymc.lobby.SinabsyLobby;
import fr.sinabsymc.lobby.scoreboard.FastBoard;
import fr.sinabsymc.lobby.scoreboard.ScoreboardTeam;
import fr.sinabsymc.lobby.utils.CustomItemStack;
import fr.sinabsymc.lobby.utils.HologramManager;
import fr.sinabsymc.lobby.utils.Title;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.group.GroupManager;
import net.luckperms.api.model.user.User;
import net.luckperms.api.model.user.UserManager;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SinabsyConnect implements Listener {


    Location npclocation = new Location(Bukkit.getWorld("world"), 0.515, 65, -15.526);
    private static CustomItemStack Boutique = new CustomItemStack(CustomItemStack.getSkull("http://textures.minecraft.net/texture/7e3deb57eaa2f4d403ad57283ce8b41805ee5b6de912ee2b4ea736a9d1f465a7")).setName("§e§lBoutique §8▪ §7Clique-Droit");
    private static CustomItemStack lobby = new CustomItemStack(Material.NETHER_STAR).setName("§b§lLobby §8▪ §7Clique-Droit");
    private static CustomItemStack menu = new CustomItemStack(CustomItemStack.getSkull("http://textures.minecraft.net/texture/98daa1e3ed94ff3e33e1d4c6e43f024c47d78a57ba4d38e75e7c9264106")).setName("§c§lMenu Principal §8▪ §7Clique-Droit");

    private static CustomItemStack cosmetics = new CustomItemStack(CustomItemStack.getSkull("http://textures.minecraft.net/texture/a6cc486c2be1cb9dfcb2e53dd9a3e9a883bfadb27cb956f1896d602b4067")).setName("§5§lCosmétiques §8▪ §7Clique-Droit");




    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        Location lobbyLocation = new Location(Bukkit.getWorld("world"), 165.537, 212, 255.512);
        player.teleport(lobbyLocation);
        HologramManager.initHolograms(player);

        event.setJoinMessage(null);
        LuckPerms luck = LuckPermsProvider.get();
        UserManager userManager = luck.getUserManager();

        User user = userManager.getUser(player.getName());

        GroupManager groupManager = luck.getGroupManager();
        Group group = groupManager.getGroup(user.getPrimaryGroup());

        String prefix = user.getCachedData().getMetaData().getPrefix();
        String suffix = user.getCachedData().getMetaData().getSuffix();

        Title.sendTitle(player, 20, 40, 20, "§f»» §c§lSinasbyMC §f««", "§eBienvenue et bon jeu !");

        player.sendMessage("");
        player.sendMessage(" §c§lSinabsyMC §7- §fHeureux de te revoir !");
        player.sendMessage("");
        player.sendMessage(" §7┃ §fDécouvrez le §6§lFallenKingdom §fà partir de la §cBêta§f.");
        player.sendMessage(" §7┃ §fVous pouvez accéder à nos jeux avec le §bglobe§f.");
        player.sendMessage("");
        player.sendMessage(" §c§lSinabsyMC §fvous souhaite un agréable moment !");
        player.sendMessage("");



        player.setMaxHealth(20);
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setWalkSpeed(0.2f);
        player.setFireTicks(0);
        player.setFallDistance(0);
        player.setGameMode(GameMode.ADVENTURE);
        player.getInventory().clear();
        player.getInventory().setItem(1, Boutique);
        player.getInventory().setItem(0, menu);
        player.getInventory().setItem(8, lobby);
        player.getInventory().setItem(4, cosmetics);
        for (PotionEffect activePotionEffect : player.getActivePotionEffects()) {
            player.removePotionEffect(activePotionEffect.getType());
        }
        player.playSound(player.getLocation(), Sound.PORTAL_TRAVEL, 1f, 1f);

        FastBoard board = new FastBoard(player);
        board.updateTitle("§f• §c§lSinabsyMC §f•");
        board.updateLine(0, "");
        board.updateLine(1, "§7▪ §fNom: §6" + player.getName());
        board.updateLine(2, "§7▪ §fGrade: §r" + ChatColor.translateAlternateColorCodes('&', "§" + prefix));
        board.updateLine(3, "§7▪ §fCoins: §e0");
        board.updateLine(4, "");
        board.updateLine(5, "§7▪ §fLobby: §dHub-01");
        board.updateLine(6, "§7▪ §fConnecté(s): §6" + Bukkit.getOnlinePlayers().size());
        board.updateLine(7, "");
        board.updateLine(8, "§c» play.sinabsymc.fr");

        SinabsyLobby.getInstance().getBoards().add(board);

        if (player.isOp()){
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "§" + prefix) + player.getName() + " §c§oà rejoint votre hub !");
        }
    }


    public static CustomItemStack getBoutique() {
        return Boutique;
    }

    public static CustomItemStack getMenu() {
        return menu;
    }

    public static CustomItemStack getLobbys() {
        return lobby;
    }

    public static CustomItemStack getCosmetics() {
        return cosmetics;
    }
}
