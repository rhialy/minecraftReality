package de.creunity.minecraftReality;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

/**
 * Created by Daniel Stehlik on 04.08.2015.
 */
public class Weather implements Listener {

    public Weather(Main plugin) {

        plugin.getServer().getPluginManager().registerEvents(this, plugin);

    }

    private StaticPlayer staticPlayer;
    private Player player = staticPlayer.staticPlayer;
    private Plugin main = Main.GetInstance();
    private int freezoMeter = 100;
    private boolean isWarm = false;


    public void PlayerFreezing() {
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(main, new Runnable() {
            @Override
            public void run() {
                Material playerChest = player.getInventory().getChestplate().getType();

                if(freezoMeter > 0 ) {
                    freezoMeter =- 1;
                } else if (freezoMeter < 0 && player.getInventory().getArmorContents() == null) {
                    player.damage(20);
                    freezoMeter = 100;
                } else if(freezoMeter < 0 && playerChest == Material.LEATHER_CHESTPLATE){
                    player.damage(0);
                    freezoMeter = 100;
                } else if(freezoMeter < 0 && playerChest == Material.IRON_CHESTPLATE || playerChest == Material.GOLD_CHESTPLATE) {
                    player.damage(15);
                    freezoMeter = 100;
                } else if(freezoMeter < 0 && playerChest == Material.DIAMOND_CHESTPLATE) {
                    player.damage(10);
                    freezoMeter = 100;
                }
            }
        }, 10L, 20L * 30);
    }

    @EventHandler
    public void WeatherChange(WeatherChangeEvent e) {
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(main, new Runnable() {
            @Override
            public void run() {
                boolean weather = Bukkit.getWorlds().get(0).hasStorm();
                if(weather) {
                    PlayerFreezing();
                }
            }
        }, 0L, 20L);
    }

}
