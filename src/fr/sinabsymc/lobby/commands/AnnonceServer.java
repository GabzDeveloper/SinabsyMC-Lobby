package fr.sinabsymc.lobby.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AnnonceServer implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("annonce"))
            if (sender.isOp()) {
                if (sender instanceof org.bukkit.command.ConsoleCommandSender) {
                    Player player = (Player) sender;
                } else if (sender instanceof Player) {
                    Player player = (Player) sender;
                    if (args.length == 0) {
                        player.sendMessage("§c§lSinabsyMC §f┃ §cVeuillez suivre le modèle: /annonce <message>");
                        return true;
                    }
                    if (args.length >= 1) {
                        StringBuilder builder = new StringBuilder();
                        for (int i = 0; i < args.length; i++)
                            builder.append(ChatColor.translateAlternateColorCodes('&', args[i])).append(" ");
                        Bukkit.broadcastMessage("§7§m---------------------------------------------------");
                        Bukkit.broadcastMessage("");
                        Bukkit.broadcastMessage("§c§lSINABSYMC §f┃ §r" + builder.toString());
                        Bukkit.broadcastMessage("");
                        Bukkit.broadcastMessage("§7§m---------------------------------------------------");
                    }
                }
            }
        return false;
    }
}
