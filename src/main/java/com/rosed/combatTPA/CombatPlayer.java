package com.rosed.combatTPA;

import org.bukkit.entity.Player;

public class CombatPlayer {

    private final Player player;
    private Request request;

    public CombatPlayer(Player player) {
        this.player = player;
    }

    /**
     * Player denies existing request
     */
    public void denyTPA() {
        if (request != null) request.deny();
    }

    /**
     * Player accepts existing request
     */
    public void acceptTPA() {
        if (request != null) request.accept();
    }

    // Setters and getters
    public Player getPlayer() { return player; }
    public Request getRequest() { return request; }
    public void setRequest(Request request) { this.request = request; }
}
