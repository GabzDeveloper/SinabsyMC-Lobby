package fr.sinabsymc.lobby.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CloseManager implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.isOp()) {
                Player player = (Player) sender;
                if (args.length == 0){
                    System.out.println("SinabsyLobby >> Fermeture du Lobby en cours...");
                    for (Player players : Bukkit.getOnlinePlayers()){
                        players.kickPlayer("§• §c§lSinabsyMC redémarre leurs Serveur(s) ! §•");
                        Bukkit.shutdown();
                    }
                }
            }
        }
        return false;
    }
}
