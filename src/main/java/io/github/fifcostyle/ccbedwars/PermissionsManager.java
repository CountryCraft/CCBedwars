package io.github.fifcostyle.ccbedwars;

public class PermissionsManager {
	private ccbedwars ccbw;
	public PermissionsManager(ccbedwars ccbw)
	{
		this.ccbw = ccbw;
	}
	
	//Admin perms
	public String mapCreate = "countrycraft.bedwars.admin.map.create";
	public String mapDelete = "countrycraft.bedwars.admin.map.delete";
	public String getPluginInfo = "countrycraft.bedwars.admin.info";
	
	
	//Queue perms
	public String useQueue = "countrycraft.bedwars.queue.use";
	public String kickQueue = "countrycraft.bedwars.queue.kick";
	
}
