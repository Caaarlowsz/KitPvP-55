package kitpvp;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;

import kitpvp.Commands;
import kitpvp.Chat.ChatFormat;
import kitpvp.Chat.chat;
import kitpvp.Kits.KitBuyGUI;
import kitpvp.Kits.Kits;
import kitpvp.data.ConfigYML;
import kitpvp.data.CurrencyKitPvP;
import kitpvp.events.DeathEvent;
import kitpvp.events.EntityDamagePrevent;
import kitpvp.events.LeaveEvent;
import kitpvp.events.PlayerEvents;
import kitpvp.events.OnPlayerJoin;
import kitpvp.events.ProjectileHitEvent;
import kitpvp.events.ProjectileThrowEvent;
import kitpvp.events.RandomTeleport;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.entity.Projectile;
import kitpvp.perks.perkGUI;
import kitpvp.trails.Trail;

public class Main extends JavaPlugin implements Listener {

	public static Main plugin;
	public Scoreboard s;
	private static Permission perms = null;
	public static Economy econ = null;
	private static final Logger log = Logger.getLogger("Minecraft");
	public static EconomyResponse r;
	public static ArrayList<Projectile> Projectile = new ArrayList<Projectile>();
	public static Map<UUID, Trail> ActiveTrail = new HashMap<>();

	@Override
	public void onEnable() {
		plugin = this;
		if (!setupEconomy()) {
			log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		setupPermissions();

		s = Bukkit.getScoreboardManager().getMainScoreboard();
		getLogger().info("Plugin has been enabled!");
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Kits(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new KitBuyGUI(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new RandomTeleport(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new CurrencyKitPvP(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Commands(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new chat(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ChatFormat(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new perkGUI(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new DeathEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new EntityDamagePrevent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ProjectileHitEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new LeaveEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ProjectileThrowEvent(), this);
		getCommand("kitpvp").setExecutor(new Commands());
		getCommand("togglechat").setExecutor(new Commands());
		if (!new File(this.getDataFolder(), "Stats.yml").exists()) {
			CurrencyKitPvP.createFile();
		} else {
			return;
		}
		if (!new File(this.getDataFolder(), "Config.yml").exists()) {
			ConfigYML.createFile();
		} else {
			return;
		}
	}

	private boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}

	private boolean setupPermissions() {
		RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
		perms = rsp.getProvider();
		return perms != null;
	}

	public static Economy getEcononomy() {
		return econ;
	}

	public static Permission getPermissions() {
		return perms;
	}
}