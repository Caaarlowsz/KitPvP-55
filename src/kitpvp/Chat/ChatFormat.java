package kitpvp.Chat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ChatFormat
  implements Listener
{
  @EventHandler
  public void chatFormat(AsyncPlayerChatEvent e)
  {
    Player p = e.getPlayer();
    PermissionUser user = PermissionsEx.getUser(p);
    if (user.inGroup("default")) {
      e.setFormat(ChatColor.translateAlternateColorCodes('&', (user.getPrefix()) + p.getDisplayName() + 
        "&f: &f" + e.getMessage()));
    }
    if (user.inGroup("archer")) {
      e.setFormat(ChatColor.translateAlternateColorCodes('&', (user.getPrefix()) + p.getDisplayName() + 
        "&7: " + e.getMessage()));
    }
    if (user.inGroup("witch")) {
      e.setFormat(ChatColor.translateAlternateColorCodes('&', (user.getPrefix()) + p.getDisplayName() + 
        "&f: &f" + e.getMessage()));
    }
    if (user.inGroup("Explorer")) {
      e.setFormat(ChatColor.translateAlternateColorCodes('&', (user.getPrefix()) + p.getDisplayName() + 
        "&f: &f" + e.getMessage()));
    }
    if (user.inGroup("knight")) {
      e.setFormat(ChatColor.translateAlternateColorCodes('&', (user.getPrefix()) + p.getDisplayName() + 
        "&b: &f" + e.getMessage()));
    }
    if (user.inGroup("vip")) {
      e.setFormat(ChatColor.translateAlternateColorCodes('&', (user.getPrefix()) + p.getDisplayName() + 
        "&f: &f" + e.getMessage()));
    }
    if (user.inGroup("youtube")) {
      e.setFormat(ChatColor.translateAlternateColorCodes('&', (user.getPrefix()) + p.getDisplayName() + 
        "&f: &f" + e.getMessage()));
    }
    if (user.inGroup("jrbuildteam")) {
      e.setFormat(ChatColor.translateAlternateColorCodes('&', (user.getPrefix()) + p.getDisplayName() + 
        "&f: &e" + e.getMessage()));
    }
    if (user.inGroup("buildteam")) {
      e.setFormat(ChatColor.translateAlternateColorCodes('&', (user.getPrefix()) + p.getDisplayName() + 
        "&f: &f" + e.getMessage()));
    }
    if (user.inGroup("support")) {
      e.setFormat(ChatColor.translateAlternateColorCodes('&', (user.getPrefix()) + p.getDisplayName() + 
        "&f: &f" + e.getMessage()));
    }
    else if (user.inGroup("moderator")) {
      e.setFormat(ChatColor.translateAlternateColorCodes('&', (user.getPrefix()) + p.getDisplayName() + 
        "&f: &f" + e.getMessage()));
    }
    else if (user.inGroup("jrdeveloper")) {
      e.setFormat(ChatColor.translateAlternateColorCodes('&', (user.getPrefix()) + p.getDisplayName() + 
        "&f: &f" + e.getMessage()));
    }
    else if (user.inGroup("developer")) {
      e.setFormat(ChatColor.translateAlternateColorCodes('&', (user.getPrefix()) + p.getDisplayName() + 
        "&f: &f" + e.getMessage()));
    }
    else if (user.inGroup("srdeveloper")) {
      e.setFormat(ChatColor.translateAlternateColorCodes('&', (user.getPrefix()) + p.getDisplayName() + 
        "&f: &f" + e.getMessage()));
    }
    else if (user.inGroup("jrsysadmin")) {
        e.setFormat(ChatColor.translateAlternateColorCodes('&', (user.getPrefix()) + p.getDisplayName() + 
                "&f: &f" + e.getMessage()));
            }
    else if (user.inGroup("sysadmin")) {
        e.setFormat(ChatColor.translateAlternateColorCodes('&', (user.getPrefix()) + p.getDisplayName() + 
          "&f: &f" + e.getMessage()));
      }
    else if (user.inGroup("admin")) {
        e.setFormat(ChatColor.translateAlternateColorCodes('&', (user.getPrefix()) + p.getDisplayName() + 
          "&f: &f" + e.getMessage()));
      }
    else if (user.inGroup("sradmin")) {
        e.setFormat(ChatColor.translateAlternateColorCodes('&', (user.getPrefix()) + p.getDisplayName() + 
          "&f: &f" + e.getMessage()));
      }
    else if (user.inGroup("projectmanager")) {
     e.setFormat(ChatColor.translateAlternateColorCodes('&', (user.getPrefix()) + p.getDisplayName() + "§f: §f"
    	     + e.getMessage()));
      }
    else if (user.inGroup("eventmanager")) {
        e.setFormat(ChatColor.translateAlternateColorCodes('&', (user.getPrefix()) + p.getDisplayName() + 
          "&f: &f" + e.getMessage()));
      }
    else if (user.inGroup("owner")) {
        e.setFormat(ChatColor.translateAlternateColorCodes('&', (user.getPrefix()) + p.getDisplayName() + 
          "&f: &f" + e.getMessage()));
      }
    else if (user.inGroup("co")) {
        e.setFormat(ChatColor.translateAlternateColorCodes('&', (user.getPrefix()) + p.getDisplayName() + 
          "&f: &f" + e.getMessage()));
      }
  }
}