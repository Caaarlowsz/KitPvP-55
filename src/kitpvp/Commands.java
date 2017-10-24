package kitpvp;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import kitpvp.Chat.chat;
import kitpvp.data.CurrencyKitPvP;
import net.minecraft.server.v1_8_R1.EnumParticle;

public class Commands implements Listener, CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
			Player player = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("togglechat")) {
				if (chat.getStatus() == true) {
					chat.setStatus(false);
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							chat.prefix + "&fYou have &cdisabled &fthe chat!"));
					return true;
				} else if (chat.getStatus() == false)
					chat.setStatus(true);
				sender.sendMessage(
						ChatColor.translateAlternateColorCodes('&', chat.prefix + "&fYou have &aenabled &fthe chat!"));
				return true;
			}
			if (cmd.getName().equalsIgnoreCase("kitpvp")) {
				if (sender instanceof Player) {
					if (args.length >= 1) {
						if (args[0].equalsIgnoreCase("setspawn")) {
							double X = player.getLocation().getX();
							double Y = player.getLocation().getY();
							double Z = player.getLocation().getZ();
							double P = player.getLocation().getPitch();
							double Yaw = player.getLocation().getYaw();
							CurrencyKitPvP.setData("Spawn.X", X);
							CurrencyKitPvP.setData("Spawn.Y", Y);
							CurrencyKitPvP.setData("Spawn.Z", Z);
							CurrencyKitPvP.setData("Spawn.Pitch", P);
							CurrencyKitPvP.setData("Spawn.Yaw", Yaw);
							CurrencyKitPvP.setData("Spawn.Set", true);
							player.sendMessage(chat.prefix + "You have set the spawn");
						}else return false;
					}
				}
			}	return true;
	}

	public void list(Player p) {
		String text = "";
		for (EnumParticle pa : EnumParticle.values()) {
			if (text.equals("")) {
				text = pa.name();
			} else {
				text += ", " + pa.name();
			}
		}
		text += ", OFF";
		p.sendMessage(ChatColor.GRAY + "/trail <particle>");
		p.sendMessage(ChatColor.GRAY + text);
	}
}