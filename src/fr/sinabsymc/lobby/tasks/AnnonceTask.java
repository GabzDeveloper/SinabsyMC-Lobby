package fr.sinabsymc.lobby.tasks;

import org.bukkit.Bukkit;

public class AnnonceTask implements Runnable{

    private String[] messages = {"§7Rejoignez le discord §e(discord.sinabsymc.fr)§7",
            "§7Supportez nous en achetant un grade sur la boutique §e(/boutique)§7",
            "§7N'oubliez pas de follow la chaîne Twitch du LEADER: §5SbyMath§7"};
    private int index = 0;

    @Override
    public void run() {
        if (messages.length <= index) index = 0;
        Bukkit.broadcastMessage("§7§m---------------------------------------------------------");
        Bukkit.broadcastMessage("");
        Bukkit.broadcastMessage("§c§lANNONCE AUTO §f┃ §r" + messages[index]);
        Bukkit.broadcastMessage("");
        Bukkit.broadcastMessage("§7§m---------------------------------------------------------");
        index++;
    }
}
