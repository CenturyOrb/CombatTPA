package com.rosed.combatTPA;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Request {

    private final Player requester;
    private final Player receiver;
    private boolean isDenied;

    public Request(Player requester, Player receiver, CombatTPA combatTPA) {
        this.requester = requester;
        this.receiver = receiver;
        receiver.sendMessage(ChatColor.GOLD + "Request from " + requester.getName());

        Bukkit.getScheduler().runTaskLater(combatTPA, () -> {
            deny();
            receiver.sendMessage(ChatColor.RED + "Request from " + requester.getName() + " has been expired");
        }, 600);
    }

    public void deny() { isDenied = true; }

    public void accept() {
        if (!isDenied) {
            requester.teleport(receiver);
            isDenied = true;
        }
    }
}
