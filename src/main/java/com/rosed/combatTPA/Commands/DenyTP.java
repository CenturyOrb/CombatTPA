package com.rosed.combatTPA.Commands;

import com.rosed.combatTPA.PlayerManager;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;

public class DenyTP {

    @Command("tpaccept")
    public void denyTeleport(Player commandSender) {
        PlayerManager.INSTANCE.getPlayer(commandSender).denyTPA();
    }
}
