package com.rosed.combatTPA.Commands;

import com.rosed.combatTPA.CombatTPA;
import com.rosed.combatTPA.PlayerManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class AcceptTP implements CommandExecutor {

    private final CombatTPA combatTPA;

    public AcceptTP(CombatTPA combatTPA)  { this.combatTPA = combatTPA; }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) return false;
        Player player = (Player) commandSender;
        PlayerManager.INSTANCE.getPlayer(player).acceptTPA();

        // add functionality of the waiting
        // check player locations every 5 seconds. if they
        // move during any of this time deny
//        new BukkitRunnable() {
//            @Override
//            public void run() {
//
//            }
//        }.runTaskTimer(combatTPA, 0, 200L);

        return false;
    }
}
