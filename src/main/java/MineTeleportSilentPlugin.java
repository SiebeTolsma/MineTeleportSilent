package net.bot2k3.siebe.MineTeleportSilent;

import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.plugin.java.*;
import org.bukkit.scheduler.*;

/**
 * Provides the main plugin interface.
 */
public class MineTeleportSilentPlugin extends JavaPlugin
{
    /**
     * Occurs when the plugin is being enabled.
     */
    public void onEnable()
    {
    }

    /**
     * Occurs when the plugin is being disabled.
     */
    public void onDisable()
    {
    }
    
    /**
     * Occurs when a command has been sent.
     */
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        
        // figure out if we actually wanted to use the /tps command, or what.
        String name = command.getName();
        
        if (name.equals("tps"))
        {
            if (sender instanceof BlockCommandSender)
            {
                // transport the player with the given name to the given coordinates.
                if (args.length == 4)
                {
                    String playerName = args[0];
                    
                    // fetch the player with that name.
                    Player player = this.getServer().getPlayerExact(playerName);
                    if (player != null)
                    {
                        // fetch the location and coordinates.
                        int x = Integer.parseInt(args[1]);
                        int y = Integer.parseInt(args[2]);
                        int z = Integer.parseInt(args[3]);
                    
                        Location location = new Location(player.getWorld(), x + 0.5, y + 0.5, z + 0.5);
                        
                        // teleport the player.
                        player.teleport(location);
                    }
                }
            }
            else
            {
                String playerName = sender.getName();
                Player player = this.getServer().getPlayerExact(playerName);
        
                if (player != null)
                {
                    // send a message back to the user.
                    player.sendMessage(ChatColor.RED + "This command must used with a Command Block!");
                }
            }
            
            // we handled the command.
            return true;
        }
        
        return false;
    }
}

