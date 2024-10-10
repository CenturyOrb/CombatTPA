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
        receiver.sendMessage("tp req from " + requester.getName());
        requester.sendMessage("tp req to " + receiver.getName());

        // receiver doesn't accept the request in 30s
        Bukkit.getScheduler().runTaskLater(CombatTPA.getInstance(), () -> {
            if (!isDenied) {
                System.out.println("3");
                deny();
            }
        }, 600);
    }

    public void deny() {
        requester.sendMessage("Request denied");
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
