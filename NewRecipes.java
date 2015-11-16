package de.creunity.minecraftReality;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Iterator;

/**
 * Created by Daniel Stehlik on 10.08.2015.
 */
public final class NewRecipes{

    // Test Item for using NewRecipes as outsourcing class
    ItemStack flint = new ItemStack(Material.FLINT);

    public ItemStack getTest() {
        return flint;
    }
    // End::TestItem
    
    public void NewCraftingTable (Player player) {
        ItemStack craftingTable = new ItemStack(Material.WORKBENCH);
        ShapedRecipe craftingTableRecipe = new ShapedRecipe(craftingTable);
        craftingTableRecipe.shape("BB","BB");
        craftingTableRecipe.setIngredient('B', Material.STICK);
        
        player.getServer().addRecipe(craftingTableRecipe);
    }
    
    public void NewStoneAxe(Player player) {
        ItemStack stoneAxe = new ItemStack(Material.STONE_AXE);
        ShapedRecipe stoneAxeRecipe = new ShapedRecipe(stoneAxe);
        stoneAxeRecipe.shape(" %%"," B%"," B ");
        stoneAxeRecipe.setIngredient('B', Material.STICK);
        stoneAxeRecipe.setIngredient('%', Material.FLINT);

        player.getServer().addRecipe(stoneAxeRecipe);
        //player.sendMessage("Debugger: New Recipe added");
    }

    public void NewStonePickAxe(Player player) {
        ItemStack stonePickAxe = new ItemStack(Material.STONE_PICKAXE);
        ShapedRecipe stonePickAxeRecipe = new ShapedRecipe(stonePickAxe);
        stonePickAxeRecipe.shape("&&&"," B "," B ");
        stonePickAxeRecipe.setIngredient('&', Material.FLINT);
        stonePickAxeRecipe.setIngredient('B', Material.STICK);

        player.getServer().addRecipe(stonePickAxeRecipe);
        //player.sendMessage("Debugger: New Recipe added");
    }

}
