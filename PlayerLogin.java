package de.creunity.MinecraftReality;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Recipe;

import java.util.Iterator;

/**
 * Created by Daniel Stehlik on 04.08.2015.
 */
public class PlayerLogin implements Listener {

    public PlayerLogin(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    NewRecipes newRecipes = new NewRecipes();

    // This removes the recipe completely so that there can be a new recipe for crafting a
    // specific item as opposed to the function in the OverrideListener class
    // which makes it just impossible to craft the specific item
    public void RemoveVanillaItem(Material itemType, Player player) {
        Iterator<Recipe> it = player.getServer().recipeIterator();
        while(it.hasNext()) {
            Recipe r = it.next();
            if(r.getResult().getType() == itemType) {
                it.remove();
                //player.sendMessage("Debugger: Item Removal working");
            }
        }
    }

    @EventHandler
    public void OnPlayerLogin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        player.sendMessage(ChatColor.BOLD + "Welcome to the Minecraft Reality Project! If you're new please type" + ChatColor.GREEN + " /help!");
        RemoveVanillaItem(Material.STONE_AXE, player);
        RemoveVanillaItem(Material.STONE_PICKAXE, player);
        RemoveVanillaItem(Material.WORKBENCH, player);
        newRecipes.NewStoneAxe(player);
        newRecipes.NewStonePickAxe(player);
        newRecipes.NewCraftingTable(player);
    }

}
