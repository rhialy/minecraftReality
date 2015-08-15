package de.creunity.minecraftReality;


import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Stehlik on 05.08.2015.
 */
public class BlockBreakListener implements Listener {

    public BlockBreakListener(Main plugin) {

        plugin.getServer().getPluginManager().registerEvents(this, plugin);

    }

    private int checkInt = 2;

    List<Material> miningTools = new ArrayList<Material>();
    List<Material> cuttingTools = new ArrayList<Material>();

    public void ArrayFilling() {
        miningTools.add(Material.IRON_PICKAXE);
        miningTools.add(Material.STONE_PICKAXE);
        miningTools.add(Material.DIAMOND_PICKAXE);
        cuttingTools.add(Material.STONE_AXE);
        cuttingTools.add(Material.IRON_AXE);
        cuttingTools.add(Material.DIAMOND_AXE);
    }


    public boolean CheckCurrentTool(Material currentTool) {

        for(int i = 0; i < miningTools.size(); i++) {
            if(currentTool == miningTools.get(i) || currentTool == cuttingTools.get(i)){
                //System.out.println("Debugger: first Conditional: checkInt: " + checkInt);
                checkInt = 1;
            } else {
                //System.out.println("Debugger: first conditional false");
            }
        }
        if(checkInt == 1) {
            //System.out.println("Debugger: second Conditional: checkInt: " + checkInt);
            checkInt = 0;
            return true;
        } else {
            return false;
        }

    }

    @EventHandler
    public void OnBlockBreak(BlockBreakEvent e) {

        Player player = e.getPlayer();
        Block block = e.getBlock();
        ItemStack currentTool = e.getPlayer().getItemInHand();
        if(!(CheckCurrentTool(currentTool.getType())) &&
                       !(block.getType() == Material.DIRT ||
                        block.getType() == Material.LEAVES ||
                        block.getType() == Material.LEAVES_2 ||
                        block.getType() == Material.GRASS ||
                        block.getType() == Material.LONG_GRASS)) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "You need another tool for this!");
        } else if(CheckCurrentTool(currentTool.getType())) {
            //player.sendMessage("Debugger: Block Break - AIR Conditional working");
        }
    }

}
