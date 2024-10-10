package com.rosed.combatTPA;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Request {

    private final Player requester;
    private final Player receiver;
    private boolean isDenied;

    public Request(Player requester, Player receiver) {
        this.requester = requester;
        this.receiver = receiver;
        receiver.sendMessage(ChatColor.GOLD + "Teleport request sent from " + ChatColor.LIGHT_PURPLE + requester.getName());
        requester.sendMessage(ChatColor.GOLD + "Teleport request sent to " + ChatColor.LIGHT_PURPLE + receiver.getName());

        // receiver doesn't accept the request in 30s
        Bukkit.getScheduler().runTaskLater(CombatTPA.getInstance(), () -> {
            if (!isDenied) {
                deny();
            }
        }, 600);
    }

    public void deny() {
        requester.sendMessage(ChatColor.RED + "Request has been denied");
        isDenied = true;
    }

    public void accept() {
        if (!isDenied) {
            requester.teleport(receiver);
            isDenied = true;
        }
    }

    public Player getRequester() { return requester; }
    public boolean isDenied() { return isDenied; }
}
