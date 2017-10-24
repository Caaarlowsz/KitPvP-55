package kitpvp.Chat;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import kitpvp.data.ConfigYML;

public class chat implements Listener{

	  public static String prefix = "§f[§9§lWitch§f] §r";
	  public static boolean chatStatus;
	  
	  public static void setStatus(boolean status)
	  {
		    File directory = new File("plugins/KitPvP/Config.yml");
			YamlConfiguration config = YamlConfiguration.loadConfiguration(directory);
			
			config.set("Chat.Status", status);
			
			try {
				config.save(directory);
			} catch (Exception e) {
				e.printStackTrace();
			}
	  }
	  
	  public static boolean getStatus()
	  {
		  return ConfigYML.getDataBoolean("Chat.Status");
	  }
	  
	  @EventHandler
	  public void onChat(AsyncPlayerChatEvent e)
	  {
	    Player p = e.getPlayer();
	    if ((getStatus() == false) && 
	      (!p.hasPermission("HUB.bypass.chat")))
	    {
	      e.setCancelled(true);
	      p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&fThe chat is &cdisabled!"));
	    }
	  }
	}