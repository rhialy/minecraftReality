package de.creunity.minecraftReality;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

/**
 * Created by Daniel Stehlik on 15.08.2015.
 */

// New Feature: Seasons - a lot to do
    // TODO: Summer() and Winter() functions to work repeatedly, but only in there specific Season
    // TODO: What changes in Summer and Winter?

public class Seasons implements Listener {

    private Plugin main = Main.GetInstance();
    private boolean isSummer = true;
    private StaticPlayer staticPlayer;
    private Player player = staticPlayer.staticPlayer;

    // This task is executed every 2 hours, making a Season last 2 hours
    public void SeasonCounter() {
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(main, new Runnable() {
            @Override
            public void run() {
                if(isSummer == false) {
                    Summer();
                    isSummer = true;
                } else if (isSummer == true) {
                    Winter();
                    isSummer = false;
                }
            }
        }, 0L, 144000L);
    }

    public void Summer() {
        if(isSummer == true) {

        }
    }

    public void Winter() {
        if(isSummer == false) {
            if(player.getInventory().getArmorContents() == null) {
                player.damage(0.01);
            }
        }
    }

}
