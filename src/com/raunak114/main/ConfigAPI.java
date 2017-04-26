package com.raunak114.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import com.raunak114.files.Example;
import com.raunak114.files.FolderConfig;
import com.raunak114.files.FolderExample;
import com.raunak114.files.PerPlayerConfig;

public class ConfigAPI extends JavaPlugin{
	private Example example;
	private FolderExample fexample;
	private String name = this.getDescription().getName();
	private FolderConfig a = new FolderConfig(this, "abc.yml", "daABcfolder", name);
	private FolderConfig b = new FolderConfig(this, "bca.yml", "daABcfolder", name);
	private FolderConfig d = new FolderConfig(this, "123ab-c.yml", "daABcfolder" + File.separator + "test", name);
	private PerPlayerConfig PerPC = new PerPlayerConfig(this);
	public static ConfigAPI instance;
@SuppressWarnings("deprecation")
@Override
public void onEnable(){
	this.instance = this;
	this.fexample = new  FolderExample(this);
	this.example = new Example(this);
	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
		@Override
		public void run(){
			PerPC.setUpConfigOnline("ConfigDir", name);
			try{
				 FolderConfig raunak114 = PerPC.getAllConfigs().getPlayerConfig("raunak114", PerPC);
				   raunak114.set("a", "a");
				   raunak114.save();

			} catch (NullPointerException e){
				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED.toString() + PerPC.ProvidedPlayerName + ChatColor.RED.toString() + " does not exist, or has not Played on the server");
				
				}
		}
	}, 100);
	
			
			
	
	enableExample();
	Bukkit.getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);
}
@Override
public void onDisable(){
	example.saveAndUnload();
}
public void enableExample(){
	example.copyDefaults(true);
	example.save();
}
public ConfigAPI getInstance(){
	return instance;
}
}
