package kitpvp.events;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import kitpvp.Main;
import kitpvp.Chat.chat;
import kitpvp.data.ConfigYML;
import kitpvp.data.CurrencyKitPvP;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class OnPlayerJoin implements Listener {

	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		e.setJoinMessage(null);
		KitPvPSpawn(player);
		player.getInventory().clear();
		player.getInventory().setHelmet(null);
		player.getInventory().setChestplate(null);
		player.getInventory().setLeggings(null);
		player.getInventory().setBoots(null);
		player.setGameMode(GameMode.ADVENTURE);
		UUID uuidPlayer = player.getUniqueId();
		String playeruuid = uuidPlayer.toString();
		String path = uuidPlayer.toString() + ".Perks";
		if (!CurrencyKitPvP.containsPlayer(playeruuid)) {
			CurrencyKitPvP.setData(playeruuid + ".Name", player.getName().toString());
			CurrencyKitPvP.setData(playeruuid + ".Kills", 0);
			CurrencyKitPvP.setData(playeruuid + ".Deaths", 0);
			CurrencyKitPvP.setData(path + ".Healing", 0);
			CurrencyKitPvP.setData(path + ".Absorption", 0);
			CurrencyKitPvP.setData(path + ".Speed", 0);
			CurrencyKitPvP.setData(uuidPlayer.toString() + ".Trail", "none");
		}
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		new org.bukkit.scheduler.BukkitRunnable() {
			public void run() {

				final Scoreboard board = manager.getNewScoreboard();
				final Objective objective = board.registerNewObjective("test", "dummy");
				// Data
				CurrencyKitPvP.reloadFile();
				PermissionUser user = PermissionsEx.getUser(player);
				UUID uuidp = player.getUniqueId();
				int kills = CurrencyKitPvP.getDataInt(uuidp.toString() + ".Kills");
				int deaths = CurrencyKitPvP.getDataInt(uuidp.toString() + ".Deaths");
				double Balance = (Main.getEcononomy().getBalance(player));
				Math.round(Balance);

				objective.setDisplaySlot(DisplaySlot.SIDEBAR);
				objective.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&9&lWitchGames:"));

				Score score2q = objective.getScore("   ");
				score2q.setScore(10);

				Score score1q = objective.getScore(ChatColor.translateAlternateColorCodes('&', "&7Rank:"));
				score1q.setScore(9);

				if (user.inGroup("Owner")) {
					objective.getScore("§4§lOwner").setScore(8);
				} else if (user.inGroup("CO")) {
					objective.getScore("§4§lCO-Owner").setScore(8);
				} else if (user.inGroup("BuildTeam")) {
					objective.getScore("§3BuildTeam").setScore(8);
				} else if (user.inGroup("Support")) {
					objective.getScore("§6Support").setScore(8);
				} else if (user.inGroup("Developer")) {
					objective.getScore("§4Developer").setScore(8);
				} else if (user.inGroup("Mod")) {
					objective.getScore("§9§lMod").setScore(8);
				} else if (user.inGroup("Archer")) {
					objective.getScore("§2Archer").setScore(8);
				} else if (user.inGroup("Witch")) {
					objective.getScore("§dWitch").setScore(8);
				} else if (user.inGroup("Explorer")) {
					objective.getScore("§3Explorer").setScore(8);
				} else if (user.inGroup("Knight")) {
					objective.getScore("§6Knight").setScore(8);
				} else if (user.inGroup("Youtube")) {
					objective.getScore("§4You§fTube").setScore(8);
				} else if (user.inGroup("VIP")) {
					objective.getScore("§cVIP").setScore(8);
				} else if (user.inGroup("Admin")) {
					objective.getScore("§4§lAdmin").setScore(8);
				} else if (user.inGroup("Top")) {
					objective.getScore("§dTOP").setScore(8);
				} else if (user.inGroup("EventManager")) {
					objective.getScore("§5EventManager").setScore(8);
				} else if (user.inGroup("ProjectManager")) {
					objective.getScore("§4ProjectManager").setScore(8);
				} else if (user.inGroup("Jrdeveloper")) {
					objective.getScore("§4Jr. Dev").setScore(8);
				} else if (user.inGroup("Srdeveloper")) {
					objective.getScore("§4Sr. Dev").setScore(8);
				} else if (user.inGroup("JrSysadmin")) {
					objective.getScore("§4Jr. Sys. Admin").setScore(8);
				} else if (user.inGroup("Sysadmin")) {
					objective.getScore("§4Sys. Admin").setScore(8);
				} else if (user.inGroup("Sradmin")) {
					objective.getScore("§4Sr. Admin").setScore(8);
				} else if (user.inGroup("Jrbuildteam")) {
					objective.getScore("§3Jr. BuildTeam").setScore(8);
				}

				Score score1 = objective.getScore("      ");
				score1.setScore(7);

				Score score2 = objective
						.getScore(ChatColor.translateAlternateColorCodes('&', ("Kills: ") + ChatColor.GRAY + kills));
				score2.setScore(6);

				Score score8 = objective.getScore(ChatColor.translateAlternateColorCodes('&',
						(ChatColor.WHITE + "Deaths: ") + ChatColor.GRAY + deaths));
				score8.setScore(5);

				if (kills >= 0 && deaths >= 0) {
					if (kills >= 1 && deaths >= 1) {
						double kd = (kills * 100) / deaths;
						Math.round(kd);
						double kdr = (kd / 100);
						Score score6 = objective.getScore(ChatColor.translateAlternateColorCodes('&',
								(ChatColor.WHITE + "K/D Ratio: ") + ChatColor.GRAY + kdr));
						score6.setScore(4);
					} else if (kills <= 0) {
						double kdr = 0;
						Score score6 = objective.getScore(ChatColor.translateAlternateColorCodes('&',
								(ChatColor.WHITE + "K/D Ratio: ") + ChatColor.GRAY + kdr));
						score6.setScore(4);
					} else if (deaths <= 0) {
						double kdr = kills;
						Score score6 = objective.getScore(ChatColor.translateAlternateColorCodes('&',
								(ChatColor.WHITE + "K/D Ratio: ") + ChatColor.GRAY + kdr));
						score6.setScore(4);
					} else {
						double kdr = 0;
						Score score6 = objective.getScore(ChatColor.translateAlternateColorCodes('&',
								(ChatColor.WHITE + "K/D Ratio: ") + ChatColor.GRAY + kdr));
						score6.setScore(4);
					}
				}

				Score score9 = objective.getScore(ChatColor.translateAlternateColorCodes('&',
						(ChatColor.WHITE + "&fCoins: &7" + (short) Balance)));
				score9.setScore(3);

				Score score10 = objective.getScore(ChatColor.translateAlternateColorCodes('&', " "));
				score10.setScore(2);

				Score score11 = objective.getScore(ChatColor.WHITE + "Chat Status:");
				score11.setScore(1);

				if (chat.getStatus() == true) {
					Score score14 = objective.getScore(ChatColor.translateAlternateColorCodes('&', "&a&lOpen"));
					score14.setScore(0);
				} else {
					Score score14 = objective.getScore(ChatColor.translateAlternateColorCodes('&', "&c&lClosed"));
					score14.setScore(0);
				}

				player.setScoreboard(board);
			}
		}.runTaskTimer(Main.plugin, 0l, 20 * 5);
		// Item voor KitsGUI
		ItemStack GoldSword = new ItemStack(Material.GOLD_SWORD, 1);
		ItemMeta GoldSwordMeta = GoldSword.getItemMeta();
		GoldSwordMeta.setDisplayName(PlayerEvents.color("&6§l>>§r&3 Kit Selector &6§l<<"));
		GoldSwordMeta.spigot().setUnbreakable(true);
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "Click here to select a Kit");
		lore.add(ChatColor.GRAY + "");
		GoldSwordMeta.setLore(lore);
		GoldSword.setItemMeta(GoldSwordMeta);
		player.getInventory().addItem(new ItemStack(GoldSword));

		// Item voor PlayerPerks menu
		ItemStack Perks = new ItemStack(Material.BOOK, 1);
		ItemMeta PerksMeta = Perks.getItemMeta();
		PerksMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&2&l&km&r &4&lPerks&r &2&l&km&r"));
		List<String> lore2 = new ArrayList<String>();
		lore2.add(ChatColor.GRAY + "Click here to buy PlayerPerks");
		lore2.add(ChatColor.GRAY + "");
		PerksMeta.setLore(lore2);
		Perks.setItemMeta(PerksMeta);
		player.getInventory().addItem(Perks);

		player.setTotalExperience(0);
		player.setCanPickupItems(false);
	}

	public static void KitPvPSpawn(Player p) {
		try {
			if (ConfigYML.getDataBoolean("Spawn.Set")) {
				double Xc = ConfigYML.getDataInt("Spawn.X");
				double Yc = ConfigYML.getDataInt("Spawn.Y");
				double Zc = ConfigYML.getDataInt("Spawn.Z");
				float Pi = (float) ConfigYML.getDataInt("Spawn.Pitch");
				float Ya = (float) ConfigYML.getDataInt("Spawn.Yaw");
				Location loc = new Location(null, Xc, Yc, Zc, Ya, Pi);
				p.teleport(loc);
			}
		} catch (NullPointerException e){}
	}

}
