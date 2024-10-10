package com.rosed.combatTPA;

import com.rosed.combatTPA.Commands.AcceptTP;
import com.rosed.combatTPA.Commands.DenyTP;
import com.rosed.combatTPA.Commands.RequestTP;
import it.unimi.dsi.fastutil.chars.Char2ObjectAVLTreeMap;
import org.bukkit.plugin.java.JavaPlugin;
import revxrsal.commands.Lamp;
import revxrsal.commands.bukkit.BukkitLamp;
import revxrsal.commands.bukkit.actor.BukkitCommandActor;

public final class CombatTPA extends JavaPlugin {

    public static CombatTPA instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        Lamp<BukkitCommandActor> lamp = BukkitLamp.builder(this).build();
        lamp.register(new AcceptTP());
        lamp.register(new RequestTP());
        lamp.register(new DenyTP());
        this.getLogger().info("Started");
    }

    public static CombatTPA getInstance() { return instance; }
}
