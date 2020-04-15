package io.github.fifcostyle.ccbedwars;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class SetupExecutor implements CommandExecutor, Listener{
	private ccbedwars ccbw;
	public SetupExecutor(ccbedwars ccbw)
	{
		this.ccbw = ccbw;
		ccbw.getServer().getPluginManager().registerEvents(this, ccbw);
	}
	private PermissionsManager perm = new PermissionsManager(ccbw);
	private Player csender;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (cmd.getName().equalsIgnoreCase("ccbw"))
		{
			if (args.length == 0)
			{
				if (sender.hasPermission(perm.getPluginInfo))
				{
					sender.sendMessage("ccbedwars");
					return true;
				}
			}
			else if (args.length == 2)
			{
				if (args[0].equalsIgnoreCase("create"))
				{
					if (sender instanceof Player)
					{
						if (sender.hasPermission(perm.mapCreate))
						{
							csender = (Player) sender;
							if (csender.hasMetadata("creatingBWArena"))
							{
								csender.removeMetadata("creatingBWArena", ccbw);
							}
							else
							{
								csender.setMetadata("creatingBWArenas", new FixedMetadataValue(ccbw, args[1]));
							}
						}
					}
				}
				else if (args[0].equalsIgnoreCase("spawnpos"))
				{
					
				}
			}
		}
		return false;
	}
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent evt)
	{
		if (evt.getPlayer().hasMetadata("creatingBWArena"))
		{
			if (evt.getAction() == Action.LEFT_CLICK_BLOCK)
			{
				evt.setCancelled(true);
				ccbw.getConfig().set("arenas." + evt.getPlayer().getMetadata("creatingBWArena").get(1) + ".pos1" + ".x", evt.getClickedBlock().getLocation().getBlockX());
				ccbw.getConfig().set("arenas." + evt.getPlayer().getMetadata("creatingBWArena").get(1) + ".pos1" +".y", evt.getClickedBlock().getLocation().getBlockY());
				ccbw.getConfig().set("arenas." + evt.getPlayer().getMetadata("creatingBWArena").get(1) + ".pos1" +".z", evt.getClickedBlock().getLocation().getBlockZ());
				ccbw.getConfig().set("arenas." + evt.getPlayer().getMetadata("creatingBWArena").get(1) + ".pos1" +".world", evt.getClickedBlock().getWorld().getName());
				evt.getPlayer().sendMessage("BW: Set position 1 for arena " + evt.getPlayer().getMetadata("creatingBWArena").get(1));
			}
			else if (evt.getAction() == Action.RIGHT_CLICK_BLOCK)
			{
				evt.setCancelled(true);
				ccbw.getConfig().set("arenas." + evt.getPlayer().getMetadata("creatingBWArena").get(1) + ".pos2" + ".x", evt.getClickedBlock().getLocation().getBlockX());
				ccbw.getConfig().set("arenas." + evt.getPlayer().getMetadata("creatingBWArena").get(1) + ".pos2" +".y", evt.getClickedBlock().getLocation().getBlockY());
				ccbw.getConfig().set("arenas." + evt.getPlayer().getMetadata("creatingBWArena").get(1) + ".pos2" +".z", evt.getClickedBlock().getLocation().getBlockZ());
				ccbw.getConfig().set("arenas." + evt.getPlayer().getMetadata("creatingBWArena").get(1) + ".pos2" +".world", evt.getClickedBlock().getWorld().getName());
				evt.getPlayer().sendMessage("BW: Set position 2 for arena " + evt.getPlayer().getMetadata("creatingBWArena").get(1));
			}
		}
	}
}
