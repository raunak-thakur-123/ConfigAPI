package com.raunak114.main;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoin implements Listener{
@EventHandler
public void onPlayerJoin(PlayerJoinEvent e){
	if(e.getPlayer().getName().equalsIgnoreCase("raunak114")){
		e.getPlayer().sendMessage(ChatColor.RED + "This server runs your ConfigAPI!");
	}
}
}
