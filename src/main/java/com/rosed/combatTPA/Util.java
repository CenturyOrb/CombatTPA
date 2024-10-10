package com.rosed.combatTPA;

import org.bukkit.Location;

public class Util {

    public static boolean equalCord(Location loc1, Location loc2) {
        if (loc1.x() != loc2.x()) return false;
        if (loc1.y() != loc2.y()) return false;
        if (loc1.z() != loc2.z()) return false;
        return true;
    }

}
