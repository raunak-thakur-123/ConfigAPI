package com.raunak114.files;

import java.io.File;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;

import com.raunak114.main.ConfigAPI;

public class PerPlayerConfig {
	private ConfigAPI configapi;
	public PerPlayerConfig(ConfigAPI configapi){
		this.configapi = configapi;
	}
	PerPlayer newa;
	FolderConfig PlayerCfg;
	private String SubFolderName,FolderName, SubFull;
	public String ProvidedPlayerName;
	private FolderConfigList<String> configList;
public void setUpConfigOnline(String SubFolderName, String FolderName){
	this.newa = new PerPlayer(configapi, SubFolderName, FolderName);
	this.SubFolderName = SubFolderName;
	this.FolderName = FolderName;
	this.SubFull = FolderName.toString() + File.separator.toString() + SubFolderName.toString();
}
@SuppressWarnings("deprecation")
public FolderConfig AccessPlayerConfig(String PlayerName) throws NullPointerException{
	if(!(Bukkit.getOfflinePlayer(PlayerName) == null)){
		OfflinePlayer op = Bukkit.getOfflinePlayer(PlayerName);
		this.ProvidedPlayerName = PlayerName;
		if (op.hasPlayedBefore()){
		UUID PUUID = op.getUniqueId();
		if (newa.uuids.contains(PUUID.toString())){
			this.PlayerCfg = new FolderConfig(configapi, PUUID.toString(), this.SubFolderName, this.FolderName);
		} else {
			Bukkit.getServer().getConsoleSender().sendMessage("[ConfigAPI] " + ChatColor.GREEN + "Creating a blank Player config file for Player " + ChatColor.RED +  PlayerName + ChatColor.GREEN + " in folder " + ChatColor.RED + this.SubFull);
			this.PlayerCfg = new FolderConfig(configapi, PUUID.toString(), this.SubFolderName, this.FolderName);
			newa.uuids.add(PUUID.toString());
			newa.uList.set("Players", newa.uuids);
			newa.uList.save();
		}
		return this.PlayerCfg;
		}
		else {return null;}
	}
	else
	{
		return null;
	}
}
/*for(String name : newa.uuids){
		FolderConfig ab = new FolderConfig(configapi, name + ".yml", this.SubFolderName, this.FolderName);
		return ab;
	}*/
public FolderConfigList<String> getAllConfigs(){
	configList = new FolderConfigList<String>();
	for (String a : newa.uuids){
		configList.add(a);
	}
	return configList;
}
}
