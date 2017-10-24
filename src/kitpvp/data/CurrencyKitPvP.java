package kitpvp.data;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;

public class CurrencyKitPvP implements Listener {
	
	public static String getDataString(String path){
		File directory = new File("plugins/KitPvP/Stats.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(directory);
	
		return  config.getString(path);
	}
	
	public static int getDataInt(String path){
		File directory = new File("plugins/KitPvP/Stats.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(directory);
		
		return  config.getInt(path);
	}
	
	public static void setData(String path, Object value){
		File directory = new File("plugins/KitPvP/Stats.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(directory);
		
		config.set(path, value);
		
		try {
			config.save(directory);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean containsPlayer(String name){
		File directory = new File("plugins/KitPvP/Stats.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(directory);
		
		return config.isConfigurationSection(name);
	}
	public static void createFile() {
		File directory = new File("plugins/KitPvP/Stats.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(directory);
		
		if(!directory.exists()){
			config.options().copyDefaults(true);
			config.options().header("Here is all the information about player PlayerPerks, coins, kills, deaths, ETC.");
			
			try {
				config.save(directory);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		try {
			config.save(directory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void reloadFile(){
		File directory = new File("plugins/KitPvP/Stats.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(directory);
		try {
		    config.load(directory);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}