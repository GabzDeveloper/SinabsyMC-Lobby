package fr.sinabsymc.lobby.utils;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.group.GroupManager;
import net.luckperms.api.model.user.User;
import net.luckperms.api.model.user.UserManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PlayerManager {

    public static void onAdminJoin(Player player){
        LuckPerms luck = LuckPermsProvider.get();
        UserManager userManager = luck.getUserManager();

        User user = userManager.getUser(player.getName());

        GroupManager groupManager = luck.getGroupManager();
        Group group = groupManager.getGroup(user.getPrimaryGroup());

        String prefix = user.getCachedData().getMetaData().getPrefix();
        String suffix = user.getCachedData().getMetaData().getSuffix();
        if (player.isOp()){
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "§" + prefix) + player.getName() + " §6§oa rejoint votre hub !");
        }
    }
}
