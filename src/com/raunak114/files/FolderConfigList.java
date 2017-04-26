package com.raunak114.files;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

public class FolderConfigList<T> extends ArrayList<T>{
T obj;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;  
public FolderConfig getPlayerConfig(String PlayerName, PerPlayerConfig ppc){
		return ppc.AccessPlayerConfig(PlayerName);

}
public FolderConfig getPlayerConfig(UUID UUID, PerPlayerConfig ppc){
	OfflinePlayer op = Bukkit.getOfflinePlayer(UUID);
	return ppc.AccessPlayerConfig(op.getName());
}

}
