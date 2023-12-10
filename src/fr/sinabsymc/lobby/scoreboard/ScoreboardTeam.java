package fr.sinabsymc.lobby.scoreboard;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.group.GroupManager;
import net.luckperms.api.model.user.User;
import net.luckperms.api.model.user.UserManager;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardTeam;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by Alexis on 19/02/2017.
 */
public class ScoreboardTeam {

    public ScoreboardTeam(Player player) {
        createPacket(player);
    }

    private PacketPlayOutScoreboardTeam createPacket(Player player){
        PacketPlayOutScoreboardTeam packet = new PacketPlayOutScoreboardTeam();

        LuckPerms luck = LuckPermsProvider.get();
        UserManager userManager = luck.getUserManager();

        User user = userManager.getUser(player.getName());

        GroupManager groupManager = luck.getGroupManager();
        Group group = groupManager.getGroup(user.getPrimaryGroup());

        String prefix = user.getCachedData().getMetaData().getPrefix();
        String suffix = user.getCachedData().getMetaData().getSuffix();

        setField(packet, "a", ChatColor.translateAlternateColorCodes('&', "§" + prefix));
        setField(packet, "b", "");
        setField(packet, "c", ChatColor.translateAlternateColorCodes('&', "§" + prefix));
        setField(packet, "d", "");
        setField(packet, "e", "always");
        setField(packet, "f", "never");

        return packet;
    }


    private void setField(Object edit, String fieldName, Object value) {
        try {
            Field field = edit.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(edit, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
