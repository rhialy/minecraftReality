package de.creunity.minecraftReality;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Daniel Stehlik on 04.08.2015.
 */
public class RealityCommandExecutor implements CommandExecutor {

    private final Main plugin;

    public RealityCommandExecutor(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(cmd.getName().equalsIgnoreCase("test")){
            if(!(sender instanceof Player)) {
                sender.sendMessage("Plugin is loaded and working correctly ... hopefully");
            } else {
                sender.sendMessage("This command can only be run from the console");
            }
            return true;
        }
        if(cmd.getName().equalsIgnoreCase("help")){
            if(sender instanceof Player) {
                sender.sendMessage("For more Information about what your playing \n please type" + ChatColor.GREEN + " /reality \n"
                                   + ChatColor.RESET + "For more Information about what changed \n please type" + ChatColor.GREEN + " /changes \n"
                                   + ChatColor.RESET + "For a list of available commands please type" + ChatColor.GREEN + " /commands");
                return true;
            }
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be used by a logged in Player!");
            }
        }
        if(cmd.getName().equalsIgnoreCase("reality")) {
            if(sender instanceof Player) {
                sender.sendMessage("This plugin's goal is to increase the realism in Minecraft. \n" +
                                   "Some things are easier and some are harder, but overall \n" +
                                   "your experience will be much harder");
            } else {
                sender.sendMessage("This command can only be used by a logged in Player!");
            }
        }
        if(cmd.getName().equalsIgnoreCase("changes")) {
            if(sender instanceof Player) {
                sender.sendMessage("For a list of all features please visit the official forum site \n" +
                                   "For starters you cannot just mine nearly every block \n" +
                                   "with bare hands nor can you use some unrealistic wooden tools. \n" +
                                   "Weather makes you cold or hot and loose life. \n" +
                                   "Recipes are changed and you can find new ressources. \n" +
                                   "For example try to use" + ChatColor.BLUE + " sticks" + ChatColor.RESET + "(from trees perhaps ?) and" + ChatColor.BLUE + " flint stones \n" + ChatColor.RESET +
                                   "(perhaps you can find some on the 'ground'?) and try to make a pickaxe.");
            } else {
                sender.sendMessage("This command can only be used by a logged in Player!");
            }
        }
        if(cmd.getName().equalsIgnoreCase("commands")) {
            if(sender instanceof Player) {

            } else {
                sender.sendMessage("This command can only be used by a logged in Player!");
            }
        }
        return false;
    }
}
