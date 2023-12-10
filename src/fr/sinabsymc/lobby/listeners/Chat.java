package fr.sinabsymc.lobby.listeners;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.group.GroupManager;
import net.luckperms.api.model.user.User;
import net.luckperms.api.model.user.UserManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.*;

public class Chat implements Listener {
    private List<UUID> sayEz = new ArrayList<>();
    private HashMap<UUID, String> lastMessages = new HashMap<>();
    private String[] badWords = {"fuck", "connard", "connard", "con", "fdp", "ta mère", "pute", "encule", "enculé", "batard", "batar", "negro", "nègre", "nigga", "merde", "shit", "pd", "tchoin", "salop", "salaud", "salau", "salo", "adopté", "suce", "bite", "couille", "couilles", "bites", "nique", "niqué", "niquer", "ntm", "ntr"};




    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (e.getPlayer() == null) return;
        Player player = (Player) e.getPlayer();
        String message = e.getMessage();

        LuckPerms luck = LuckPermsProvider.get();
        UserManager userManager = luck.getUserManager();

        User user = userManager.getUser(player.getName());

        GroupManager groupManager = luck.getGroupManager();
        Group group = groupManager.getGroup(user.getPrimaryGroup());

        String prefix = user.getCachedData().getMetaData().getPrefix();
        String suffix = user.getCachedData().getMetaData().getSuffix();

        e.setFormat(ChatColor.translateAlternateColorCodes('&', "§" + prefix) + player.getName() + " §8» §f" + message);
    }

    private boolean isEz(String message) {
        if (message.equalsIgnoreCase("ez")) return true;
        if (message.startsWith("e z")) return true;
        if (message.startsWith("ez")) return true;
        if (message.contains(" ")) {
            String[] words = message.split(" ");
            for (String word : words) {
                if (word.equalsIgnoreCase("ez")) return true;
                if (word.startsWith("ez")) return true;
            }
        }
        return false;
    }

    private boolean containsBadword(String message) {
        if (message.contains(" ")) {
            String[] words = message.split(" ");
            for (String word : words) {
                if (Arrays.asList(badWords).contains(word.toLowerCase())) return true;
            }
        } else {
            if (Arrays.asList(badWords).contains(message.toLowerCase())) return true;
        }
        return false;
    }

    private String getUnFlood(String message) {
        if (message.length() < 4) return message;
        String tempMessage = message;
        char oldLetter = message.charAt(0);
        int count = 1;
        for (int i = 1; i < tempMessage.length(); i++) {
            char letter = tempMessage.charAt(i);
            if (i == tempMessage.length() - 1 && oldLetter == letter) {
                count++;
                letter = ' ';
            }
            if (oldLetter == letter) {
                count++;
            } else {
                if (count >= 3) {
                    StringBuilder chars = new StringBuilder();
                    for (int j = 0; j < count; j++) {
                        chars.append(oldLetter);
                    }
                    message = message.replaceFirst(chars.toString(), String.valueOf(oldLetter));
                }
                count = 1;
            }
            oldLetter = letter;
        }
        return message;
    }

    private int difference(int a, int b) {
        return Math.abs(a - b);
    }
}
