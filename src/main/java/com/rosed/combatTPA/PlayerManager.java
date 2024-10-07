package com.rosed.combatTPA;

import org.bukkit.entity.Player;

import java.util.HashMap;

public enum PlayerManager {
    INSTANCE;

    PlayerManager() {};

    private HashMap<Player, CombatPlayer> players = new HashMap<>();

    /**
     * Returns custom player instance CombatPlayer
     * if instance does not exist, create and return
     * @param player Bukkit.Player instance
     * @return CombatTPA.CombatPlayer instance
     */
    public CombatPlayer getPlayer(Player player) {
        if (players.get(player) != null) return players.get(player);

        players.put(player, new CombatPlayer(player));
        return players.get(player);
    }

}
