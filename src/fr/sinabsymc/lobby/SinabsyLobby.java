package fr.sinabsymc.lobby;


import fr.sinabsymc.lobby.commands.AnnonceServer;
import fr.sinabsymc.lobby.commands.CloseManager;
import fr.sinabsymc.lobby.commands.ServerManager;
import fr.sinabsymc.lobby.listeners.*;
import fr.sinabsymc.lobby.scoreboard.FastBoard;
import fr.sinabsymc.lobby.staffarmor.StaffAmorManager;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class SinabsyLobby extends JavaPlugin {

    private final HashMap<UUID, LivingEntity> pets = new HashMap<>();
    private final List<Player> hidingParticles = new ArrayList<>();
    private static SinabsyLobby instance;


    private List<FastBoard> boards = new ArrayList<>();
    @Override
    public void onEnable() {
        instance = this;
        System.out.println("SinabsyAPI >> Demarage d'un lobby en cours...");
        setupListeners();
        setupCommands();

        World world = Bukkit.getWorld("world");
        world.setStorm(false);
        world.setThundering(false);
        world.setDifficulty(Difficulty.PEACEFUL);

        //Bukkit.getScheduler().runTaskTimer(this, new AnnonceTask(), 120, 120);
        StaffAmorManager.SbyAnyNeverArmor();
    }


    @Override
    public void onDisable() {

    }

    public void setupListeners(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new SinabsyConnect(), this);
        pm.registerEvents(new SinabsyProtect(), this);
        pm.registerEvents(new SinabsyWeather(), this);
        pm.registerEvents(new SinabsyClick(), this);
        pm.registerEvents(new SinabsyInventory(), this);
        pm.registerEvents(new Chat(), this);
    }

    public void setupCommands(){
        this.getCommand("servers").setExecutor(new ServerManager());
        this.getCommand("annonce").setExecutor(new AnnonceServer());
        this.getCommand("close").setExecutor(new CloseManager());
    }

    public static SinabsyLobby getInstance() {
        return instance;
    }

    public List<FastBoard> getBoards() {
        return boards;
    }
    public List<Player> getHidingParticles() {
        return hidingParticles;
    }
}
