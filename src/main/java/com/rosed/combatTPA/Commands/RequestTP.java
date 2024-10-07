package com.rosed.combatTPA.Commands;

import com.rosed.combatTPA.CombatTPA;
import com.rosed.combatTPA.PlayerManager;
import com.rosed.combatTPA.Request;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RequestTP implements CommandExecutor {

    private final CombatTPA combatTPA;
    private final PlayerManager playerManager;

    public RequestTP(CombatTPA combatTPA) {
        this.combatTPA = combatTPA;
        playerManager = PlayerManager.INSTANCE;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) return false;
        Player requester = (Player) commandSender;
        Player receiver;
        // check if the player verified as an arg exists
        if (!validPlayerAug(strings, requester)) return false;
        receiver = Bukkit.getPlayerExact(strings[0]);

        PlayerManager.INSTANCE.getPlayer(receiver).setRequest(new Request(requester, receiver, combatTPA));

        return false;
    }

    private static boolean validPlayerAug(String[] augs, Player commandSender) {
        if (augs.length != 1) return false;
        if (Bukkit.getPlayerExact(augs[0]) == null) return false;
        if (Bukkit.getPlayerExact(augs[0]) == commandSender) return false;
        return true;
    }
}

