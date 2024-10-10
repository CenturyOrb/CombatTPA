package com.rosed.combatTPA;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

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
     * Player accepts existing request if it exists and is not denied, stand still for 10s
     * from both players
     */
    public void acceptTPA() {
        if (request == null) return;

        player.sendMessage(ChatColor.GOLD + "Remain still for 10 seconds");
        request.getRequester().sendMessage(ChatColor.GOLD + "Remain still for 10 seconds");
        // check every 0.5 seconds for up to 10s if the players are standing still
        // if they are still after 10s, teleport
        new BukkitRunnable() {
            int interval = 0;
            final Location playerLoc = player.getLocation();
            final Location requesterLoc = request.getRequester().getLocation();
            @Override
            public void run() {
                // timer hits 10s
                if (interval > 19) {
                    request.accept();
                    cancel();
                }
                // if player moves during the timer intervals
                if (!Util.equalCord(player.getLocation(), playerLoc) ||
                    !Util.equalCord(request.getRequester().getLocation(), requesterLoc)) {
                    request.deny();
                    cancel();
                }
                interval++;
            }
        }.runTaskTimer(CombatTPA.getInstance(), 0, 10L);
    }

    // Setters and getters
    public Player getPlayer() { return player; }
    public Request getRequest() { return request; }
    public void setRequest(Request request) { this.request = request; }
}
