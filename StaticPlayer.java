package de.creunity.minecraftReality;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Daniel Stehlik on 14.08.2015.
 */

public class StaticPlayer implements Listener {

    public static Player staticPlayer;

    public StaticPlayer(Main plugin) {

        plugin.getServer().getPluginManager().registerEvents(this, plugin);

    }

    @EventHandler
    public static void GetPlayer(PlayerJoinEvent e) {
        staticPlayer = e.getPlayer();
    }
}
