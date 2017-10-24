package kitpvp.events;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import kitpvp.data.ConfigYML;

public class RandomTeleport implements Listener {

	public static void RandomTeleport(Player player) {
		if (ConfigYML.getDataBoolean("RandomTp.Enabled") == true) {
			Random rn = new Random();
			int randomLocGetal = rn.nextInt(8);
			if (randomLocGetal == 0) {
				Location loc = new Location(player.getWorld(), 47, 6, 48, 90, 0);
				player.teleport(loc);
			} else if (randomLocGetal == 1) {
				Location loc = new Location(player.getWorld(), -5, 12, 24, -90, 0);
				player.teleport(loc);
			} else if (randomLocGetal == 2) {
				Location loc = new Location(player.getWorld(), 7, 4, 106, -140, 0);
				player.teleport(loc);
			} else if (randomLocGetal == 3) {
				Location loc = new Location(player.getWorld(), 4, 4, 57, 30, 0);
				player.teleport(loc);
			} else if (randomLocGetal == 4) {
				Location loc = new Location(player.getWorld(), 34, 8, 11, 36, 0);
				player.teleport(loc);
			} else if (randomLocGetal == 5) {
				Location loc = new Location(player.getWorld(), 22, 5, 72, 180, 0);
				player.teleport(loc);
			} else if (randomLocGetal == 6) {
				Location loc = new Location(player.getWorld(), 15, 5, 80, 90, 0);
				player.teleport(loc);
			} else if (randomLocGetal == 7) {
				Location loc = new Location(player.getWorld(), 31, 14, 122, 140, 0);
				player.teleport(loc);
			} /*else if (randomLocGetal == 8) {
				Location loc = new Location(player.getWorld(), 1416, 9, -594.5, 0, 0);
				player.teleport(loc);
			}*/
		}
	}
}
