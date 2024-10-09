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
        receiver.sendMessage(ChatColor.GOLD + "Teleport request from " + ChatColor.LIGHT_PURPLE + requester.getName());
        requester.sendMessage(ChatColor.GOLD + "Teleport request sent to " + ChatColor.LIGHT_PURPLE + receiver.getName());

        Bukkit.getScheduler().runTaskLater(combatTPA, () -> {
            if (!isDenied) {
                deny();
                receiver.sendMessage(ChatColor.RED + "Teleport request from " + ChatColor.LIGHT_PURPLE + requester.getName() + ChatColor.RED + " has been expired");
                requester.sendMessage(ChatColor.RED + "Teleport request to " + ChatColor.LIGHT_PURPLE + receiver.getName() + ChatColor.RED + " has been expired");
            }
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
