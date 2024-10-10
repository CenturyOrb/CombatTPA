package com.rosed.combatTPA.Commands;

import com.rosed.combatTPA.PlayerManager;
import com.rosed.combatTPA.Request;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;

public class RequestTP {

    @Command("tpa")
    public void requestTeleport(Player commandSender, Player receiver) {
        // Command logic here
        if (receiver == commandSender) {
            commandSender.sendMessage(ChatColor.RED + "You can't send requests to yourself");
            return;
        }
        PlayerManager.INSTANCE.getPlayer(receiver).setRequest(new Request(commandSender, receiver));
    }
}

