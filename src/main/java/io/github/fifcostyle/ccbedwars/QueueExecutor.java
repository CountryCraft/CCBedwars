package io.github.fifcostyle.ccbedwars;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class QueueExecutor extends GameManager implements CommandExecutor {
	private ccbedwars ccbw;
	public QueueExecutor(ccbedwars ccbw)
	{
		super (ccbw);
		this.ccbw = ccbw;
	}
	private PermissionsManager perm = new PermissionsManager(ccbw);
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (cmd.getName().equalsIgnoreCase("bwjoin"))
		{
			if (args.length == 0) return false;
			else if (args.length == 1)
			{
				if (sender instanceof Player)
				{
					if (sender.hasPermission(perm.useQueue))
					{
						Player player = (Player) sender;
						if (args[0].equalsIgnoreCase("solo") || args[0].equalsIgnoreCase("one"))
						{
							ccbw.soloQueue.add(player);
							if (ccbw.soloQueue.size() == 4)
							{
								StartSoloGame(ccbw.soloQueue);
								ccbw.soloQueue.clear();
							}
							return true;
						}
						else if (args[0].equalsIgnoreCase("doubles") || args[0].equalsIgnoreCase("two"))
						{
							ccbw.doublesQueue.add(player);
							if (ccbw.doublesQueue.size() == 8)
							{
								StartDoublesGame(ccbw.doublesQueue);
								ccbw.doublesQueue.clear();
							}
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
}
