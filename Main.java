package de.creunity.minecraftReality;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;


/**
 * Created by Daniel Stehlik on 04.08.2015.
 */

 /*****************************************************************************************************
 * This plugin's goal is making Minecraft a more realistic and also more
 * difficult experience. To make it a real "survival" game and not just
 * a lego simulator (nothing against that).
 * FEATURE LIST:
 * - You cannot mine Blocks with bare hands, to craft your first set
 *   of tools you need to collect things such as sticks from tree leaves
 *   or flint from the ground (destroying grass), which leads to
 * - New drops have been added, such as sticks from leaves, so that the player
 *   is able to continue in his adventure while not being able to mine specific
 *   blocks anymore
 * - Adding to the aspect of getting hungry, there is now also Weather affecting
 *   your character. If it stroms (or rains, which is sadly the same) you freeze
 *   and loose life. To prevent this you have to wear armor. Different armor has different
  *  stats. Leather protects the most from weather and Iron and Gold the least.
 * - Recipes have been changed, tools such as a wooden axe (srsly a wooden axe to cut wood?)
 *   have been completely removed while many other tools recipe has simply changed.
 * - There are more features to come AND:
 *   ALL THESE FEATURES ARE NOT FINISHED AND PROBABLY WILL NEVER BE REALLY "FINISHED"
 *   THERE WILL ALWAYS BE MORE TO ADD, THE AMOUNT OF FEATURES IS JUST DEPENDENT ON THE
 *   TIME USED TO WORK ON THIS PLUGIN
 *******************************************************************************************************/
//TODO: BlockBreakListener ! CheckCurrenTool Funktion fertig machen ! checkInt Variable falsch genutzt ! 

public class Main extends JavaPlugin {

    private static Main instance;

    // This is for letting other classes use the JavaPlugin Extension
    // Specifically the Weather class as it uses Schedulers
    // While there would also be the option to just put everything from the Weather class in the
    // main class, I prefer to have a structure which explains itself
    public Main() {
        instance = this;
    }

    public static Main GetInstance() {
        return instance;
    }

    @Override
    public void onEnable() {

        new OverrideListener(this);
        new PlayerLogin(this);
        new Weather(this);
        new StaticPlayer(this);
        BlockBreakListener blockBreakListener = new BlockBreakListener(this);
        Seasons seasons = new Seasons();

        seasons.SeasonCounter();
        blockBreakListener.ArrayFilling();

        getLogger().info(ChatColor.GREEN + "onEnable has been invoked!");

        this.getCommand("test").setExecutor(new RealityCommandExecutor(this));
        this.getCommand("help").setExecutor(new RealityCommandExecutor(this));
        this.getCommand("reality").setExecutor(new RealityCommandExecutor(this));
        this.getCommand("changes").setExecutor(new RealityCommandExecutor(this));

    }


    @Override
    public void onDisable() {

        getLogger().info("onDisable has been invoked!");

    }

}
