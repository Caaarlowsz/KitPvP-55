package kitpvp.data;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;

public class ConfigYML implements Listener {
	
	public static String getDataString(String path){
		File directory = new File("plugins/KitPvP/Config.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(directory);

		return  config.getString(path);
	}
	
	public static double getDataInt(String path){
		File directory = new File("plugins/KitPvP/Config.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(directory);
		
		return  config.getInt(path);
	}
	
	public static boolean getDataBoolean(String path){
		File directory = new File("plugins/KitPvP/Config.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(directory);
		
		return  config.getBoolean(path);
	}
	
	public static void setData(String path, Object value){
		File directory = new File("plugins/KitPvP/Config.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(directory);
		
		config.set(path, value);
		
		try {
			config.save(directory);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean containsPlayer(String name){
		File directory = new File("plugins/KitPvP/Config.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(directory);
		
		return config.contains(name);
	}
	public static void createFile() {
		File directory = new File("plugins/KitPvP/Config.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(directory);
		
		if(!directory.exists()){
			
			config.options().copyDefaults(true);
			config.options().header("KitPvP Plugin made by Bazzlock. Version 1.0.1");
			config.set("Scoreboard", "");
			config.set("Scoreboard.Enabled", true );
			config.set("Scoreboard.Name", "&9&lWitchGames:" );
			config.set("Scoreboard.Color", "&6");
			config.set("Allow ItemDrop", false);
			config.set("No Hunger", true);
			config.set("Coins", "");
			config.set("Coins.Recieved upon kill", 25);
			config.set("Coins.Recieved upon death", 10);
			config.set("Chat.Status", true);
			config.set("Spawn.Set", false);
			config.set("Spawn.X", null);
			config.set("Spawn.Y", null);
			config.set("Spawn.Z", null);
			config.set("Spawn.Pitch", null);
			config.set("Spawn.Yaw", null);
			//config.set("Allow Block Breaking", true);
			//config.set("Allow Item Pick-up", true);
			config.set("RandomTp", "");
			config.set("RandomTp.Enabled", false);
			
			
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
		File directory = new File("plugins/KitPvP/Config.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(directory);
		try {
		    config.load(directory);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}