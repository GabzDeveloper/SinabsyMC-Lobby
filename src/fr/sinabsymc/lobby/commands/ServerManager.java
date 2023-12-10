package fr.sinabsymc.lobby.commands;

import fr.sinabsymc.lobby.menu.ServerGUI;
import net.minecraft.server.v1_8_R3.PathfinderGoalLookAtPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ServerManager implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player){
            if (sender.hasPermission("sinabsymc.management")){
                Player player = (Player) sender;
                if (args.length == 0){
                    player.sendMessage("§8§m-----------------------------------------------");
                    player.sendMessage("");
                    player.sendMessage("§c§lAIDE §f┃ §eAide aux commandes de Serveur(s) !");
                    player.sendMessage("");
                    player.sendMessage("§8» §e/servers add <type> (FK,FFARUSH,BEDWARS)");
                    player.sendMessage("§8» §e/servers list §f┃ §eAffiche les serveurs en ligne.");
                    player.sendMessage("");
                    player.sendMessage("§8§m-----------------------------------------------");
                } else if (args[0].equalsIgnoreCase("list")){
                    new ServerGUI(player).open(player);

                } else if (args[0].equalsIgnoreCase("add")){
                    player.sendMessage("§f┃ §cFonctionnalité en Développement.");
                }
            }
        }
        return false;
    }
}
