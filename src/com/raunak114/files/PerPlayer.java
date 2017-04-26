package com.raunak114.files;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import com.raunak114.main.ConfigAPI;

public class PerPlayer {
	ArrayList<String> uuids;
	FolderConfig Players, uList;
 @SuppressWarnings("unchecked")
public PerPlayer(ConfigAPI configapi, String SubFolderName, String FolderName){
	 uList = new FolderConfig(configapi, "UserList", SubFolderName, FolderName);
	 try {
	 uuids = (ArrayList<String>) uList.getList("Players");
	 } catch (Exception e){
		 
	 }
	 if(uuids == null){
		 uuids = new ArrayList<String>();
	 }
	 for (Player p : configapi.getServer().getOnlinePlayers()){
		 uuids.add(p.getUniqueId().toString());
	 }
	 for(String uuid : uuids){
		 Players = new FolderConfig(configapi, uuid, SubFolderName, FolderName);
	 }
	 uList.set("Players", uuids);
	 uList.save();
		
 }
 
}
