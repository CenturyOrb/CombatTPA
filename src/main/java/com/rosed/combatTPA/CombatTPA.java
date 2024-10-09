package com.rosed.combatTPA;

import com.rosed.combatTPA.Commands.AcceptTP;
import com.rosed.combatTPA.Commands.DenyTP;
import com.rosed.combatTPA.Commands.RequestTP;
import org.bukkit.plugin.java.JavaPlugin;

public final class CombatTPA extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("tpa").setExecutor(new RequestTP(this));
        getCommand("tpdeny").setExecutor(new DenyTP());
        getCommand("tpaccept").setExecutor(new AcceptTP(this));

        this.getLogger().warning("test");
    }
}
