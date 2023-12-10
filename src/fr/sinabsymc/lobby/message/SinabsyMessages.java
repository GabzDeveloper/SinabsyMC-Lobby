package fr.sinabsymc.lobby.message;

import java.util.Date;

public class SinabsyMessages {

    private static boolean debug = true;

    private static String PREFIX_LOBBY = "§c§lSinabsyMC §8•";

    private static String ERREUR = "§c§lERREUR §f•";

    private static String NOFOUND = PREFIX_LOBBY + " commande est ";

    private static String NOPERMS = PREFIX_LOBBY + " ne pouvez pas cette commande.";

    public static String getLobbyPrefix() {
        return PREFIX_LOBBY;
    }

    public static String getNoFound() {
        return NOFOUND;
    }

    public static String getErreur() {
        return ERREUR;
    }

    public static String getNoPerms() {
        return NOPERMS;
    }

    public static String getActualDate() {
        return (new Date(System.currentTimeMillis())).toString();
    }
}
