package io.github.fifcostyle.ccbedwars;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.block.Chest;
import org.bukkit.block.EnderChest;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class GameManager implements Listener{
	private ccbedwars ccbw;
	public GameManager(ccbedwars ccbw)
	{
		this.ccbw = ccbw;
		ccbw.getServer().getPluginManager().registerEvents(this, ccbw);
	}
	private PermissionsManager perm = new PermissionsManager(ccbw);
	
	public void StartSoloGame(List<Player> players)
	{
		for(int i = 0; i <= players.size(); i++)
		{
			Player target = players.get(i);
			Location tpLocation = new Location(x, y, z, pitch, yaw);
		}
	}
	public void StartDoublesGame(List<Player> players)
	{
		
	}
	
}
