package com.raunak114.files;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.libs.jline.internal.InputStreamReader;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import com.raunak114.main.ConfigAPI;

public class AbstractConfig {
protected ConfigAPI configapi;
private File file;
protected FileConfiguration config;
public String filen;
public String FolderName;
public AbstractConfig(ConfigAPI configapi, String fileName, String FolderName){
	this.configapi = configapi;
	if(!fileName.contains(".yml")){
		fileName = fileName + ".yml";
	}
	this.filen = fileName;
	this.FolderName = "plugins" + File.separator + FolderName;
	this.file = new File(this.FolderName, fileName);
	if(!this.file.exists()){
		configapi.getServer().getConsoleSender().sendMessage("[ConfigAPI] " + ChatColor.RED.toString() + ChatColor.BOLD.toString() + fileName + ChatColor.GREEN.toString() + " was not found in folder " + ChatColor.RED.toString() +  this.FolderName + ", Generating one!");
		try {
			this.file.createNewFile();
		} catch (IOException e){
			
		}
	}
	this.config = YamlConfiguration.loadConfiguration(this.file);
	try {
		configapi.getServer().getConsoleSender().sendMessage("[ConfigAPI] " + ChatColor.RED.toString() + ChatColor.BOLD.toString() + fileName + ChatColor.GREEN.toString() + " is now loaded!");
		this.config.save(this.file);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void save(){
	try {
		config.save(file);
	} catch (IOException e){
		e.printStackTrace();
	}
}
public FileConfiguration getConfig(){
	return config;
}
public String toString(){
	return getConfig().toString();
}
public void setDefaults(Configuration defaults){
	getConfig().setDefaults(defaults);
}
public String saveToString(){
	return getConfig().saveToString();
}
public void save(String file){
	try {
		getConfig().save(file);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void save(File file){
	try {
		getConfig().save(file);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public FileConfigurationOptions options(){
	return getConfig().options();
}
public void loadFromString(String contents){
	try {
		getConfig().loadFromString(contents);
	} catch (InvalidConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void load(String file){
	try {
		getConfig().load(file);
	} catch (IOException | InvalidConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void load(Reader reader){
try {
	getConfig().load(reader);
} catch (IOException | InvalidConfigurationException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
@SuppressWarnings("deprecation")
public void load(InputStream stream){
	try {
		getConfig().load(stream);
	} catch (IOException | InvalidConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void load(File file){
	
		try {
			getConfig().load(file);
		} catch (IOException | InvalidConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
public Boolean isString(String path){
	return getConfig().isString(path);
}
public Boolean isVector(String path){
	return getConfig().isVector(path);
}
public Boolean isSet(String path){
	return getConfig().isSet(path);
}
public Boolean isLong(String path){
	return getConfig().isLong(path);
}
public Boolean isOfflinePlayer(String path){
	return getConfig().isOfflinePlayer(path);
}
public Boolean isList(String path){
	return getConfig().isList(path);
}
public Boolean isItemStack(String path){
	return getConfig().isItemStack(path);
}
public Boolean isInt(String path){
	return getConfig().isInt(path);
}
public Boolean isDouble(String path){
	return getConfig().isDouble(path);
}
public Boolean isConfigurationSection(String path){
	return getConfig().isConfigurationSection(path);
}
public Boolean isColor(String path){
	return getConfig().isColor(path);
}
public Boolean isBoolean(String path){
	return getConfig().isBoolean(path);
}
public Vector getVector(String path, Vector def){
	return getConfig().getVector(path, def);
}
public Vector getVector(String path){
	return getConfig().getVector(path);
}
public Map<String, Object> getValues(Boolean deep){
	return getConfig().getValues(deep);
}
public List<String> getStringList(String path){
	return getConfig().getStringList(path);
}
public String getString(String path, String def){
	return getConfig().getString(path, def);
}
public String getString(String path){
	return getConfig().getString(path);
}
public List<Short> getShortList(String path){
	return getConfig().getShortList(path);
}
public Configuration getRoot(){
	return getConfig().getRoot();
}
public ConfigurationSection getParent(){
	return getConfig().getParent();
}
public OfflinePlayer getOfflinePlayer(String path, OfflinePlayer def){
	return getConfig().getOfflinePlayer(path, def);
}
public OfflinePlayer getOfflinePlayer(String path){
	return getConfig().getOfflinePlayer(path);
}
public String getName(){
	return getConfig().getName();
}
public List<?> getMapList(String path){
	return getConfig().getMapList(path);
}
public List<Long> getLongList(String path){
	return getConfig().getLongList(path);
}
public long getLong(String path,Long def){
	return getConfig().getLong(path, def);
}
public long getLong(String path){
	return getConfig().getLong(path);
}
public List<?> getList(String path, List<?> def){
	return getConfig().getList(path, def);
}
public List<?> getList(String path){
	return getConfig().getList(path);
}
public Set<String> getKeys(Boolean deep){
	return getConfig().getKeys(deep);
}
public ItemStack getItemStack(String path, ItemStack def){
	return getConfig().getItemStack(path, def);
}
public ItemStack getItemStack(String path){
	return getConfig().getItemStack(path);
}
public List<Integer> getIntegerList(String path){
	return getConfig().getIntegerList(path);
}
public int getInt(String path, int def){
	return getConfig().getInt(path, def);
}
public int getInt(String path){
	return getConfig().getInt(path);
}
public List<Float> getFloatList(String path){
	return getConfig().getFloatList(path);
}
public double getDouble(String path, double def){
	return getConfig().getDouble(path, def);
}
public double getDouble(String path){
	return getConfig().getDouble(path);
}
public ConfigurationSection getDefaultSection(){
	return getConfig().getDefaultSection();
}
public Configuration getDefaults(){
	return getConfig().getDefaults();
}
public String getCurrentPath(){
	return getConfig().getCurrentPath();
}
public ConfigurationSection getConfigurationSection(String path){
	return getConfig().getConfigurationSection(path);
}
public Color getColor(String path, Color def){
	return getConfig().getColor(path, def);
}
public Color getColor(String path){
	return getConfig().getColor(path);
}
public List<Character> getCharacterList(String path){
	return getConfig().getCharacterList(path);
}
public List<Byte> getByteList(String path){
	return getConfig().getByteList(path);
}
public List<Boolean> getBooleanList(String path){
	return getConfig().getBooleanList(path);
}
public boolean getBoolean(String path, Boolean ignoreDefault){
	return getConfig().contains(path, ignoreDefault);
}
public boolean getBoolean(String path){
	return getConfig().getBoolean(path);
}
public Object get(String path, Object def){
	return getConfig().get(path, def);
}
public Object get(String path){
	return getConfig().get(path);
}
public ConfigurationSection createSection(String path, Map<?,?>map){
	getConfig().createSection(path, map);
	return getConfig().createSection(path, map);
}
public ConfigurationSection createSection(String path){
	getConfig().createSection(path);
	return getConfig().createSection(path);
}
public boolean contains(String path, Boolean ignoreDefault){
	return getConfig().contains(path, ignoreDefault);
}
public void addDefaults(Map<String,Object> defaults){
	getConfig().addDefaults(defaults);
}
public void addDefaults(Configuration defaults){
	getConfig().addDefaults(defaults);
}
public void addDefault(String path, Object value){
	getConfig().addDefault(path, value);
}
public void set(String path, Object value){
	getConfig().set(path, value);
}
public boolean contains(String path){
	return getConfig().contains(path);
}
public void saveAndUnload(){
	this.file = null;
	this.config = null;
	this.file = new File(configapi.getDataFolder(), filen);
	this.config = YamlConfiguration.loadConfiguration(this.file);
}
public void copyDefaults(Boolean def){
	if(def = true){
		InputStreamReader defaultConfigStream;
		try {
			
			defaultConfigStream = new InputStreamReader(configapi.getResource(filen.toLowerCase()), "UTF8");
			YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(defaultConfigStream);
			getConfig().setDefaults(defaultConfig);
			getConfig().options().copyDefaults(true);
			try {
				getConfig().save(this.file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException | NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}

