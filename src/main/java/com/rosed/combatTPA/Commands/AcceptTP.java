package com.rosed.combatTPA.Commands;

import com.rosed.combatTPA.CombatTPA;
import com.rosed.combatTPA.PlayerManager;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;

public class AcceptTP {

    @Command("tpaccept")
    public void acceptTeleport(Player commandSender) {
        // Command logic here
        PlayerManager.INSTANCE.getPlayer(commandSender).acceptTPA();
    }

}
