package de.creunity.minecraftReality;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;


/**
 * Created by Daniel Stehlik on 04.08.2015.
 */
public final class OverrideListener implements Listener {

    public OverrideListener(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    // This is for deleting Items entirely, while the one in the "PlayerLogin" class is
    // for removing the item because the recipe has to be overridden
    @EventHandler
    public void OverrideCrafting(PrepareItemCraftEvent e) {
        Material itemType = e.getRecipe().getResult().getType();
        Byte itemData = e.getRecipe().getResult().getData().getData();
        if(        itemType == Material.STICK
                || itemType == Material.HOPPER
                || itemType == Material.WOOD_AXE
                || itemType == Material.WOOD_PICKAXE
                || itemType == Material.STONE_SWORD) {
            e.getInventory().setResult(new ItemStack(Material.AIR));
            for(HumanEntity he:e.getViewers()) {
                if(he instanceof Player) {
                    ((Player)he).sendMessage(ChatColor.RED + "You cannot craft this!");
                }
            }
        }
    }

    @EventHandler
    public void OverrideLeavesDrop(BlockBreakEvent e) {
        Block b = e.getBlock();
        Player player = e.getPlayer();
        if(b.getType() == Material.LEAVES ||b.getType() == Material.LEAVES_2) {
            player.getWorld().dropItemNaturally(player.getLocation(), new ItemStack(Material.STICK));
        }
        if(b.getType() == Material.GRASS ||b.getType() == Material.LONG_GRASS) {
            player.getWorld().dropItemNaturally(player.getLocation(), new ItemStack(Material.FLINT));
        }
    }

}
