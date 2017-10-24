package kitpvp.Kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.Statistic;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import kitpvp.Main;
import kitpvp.Chat.chat;
import kitpvp.events.PlayerEvents;
import kitpvp.events.RandomTeleport;
import kitpvp.perks.perkGUI;

public class Kits implements Listener {

	public static ArrayList<String> Vampire = new ArrayList<String>();
	public static ArrayList<String> VampireBlood = new ArrayList<String>();
	public static ArrayList<String> Swordsman = new ArrayList<String>();
	public static ArrayList<String> Archer = new ArrayList<String>();
	public static ArrayList<String> Pyro = new ArrayList<String>();
	public static ArrayList<String> Witch = new ArrayList<String>();
	public static ArrayList<String> Fisherman = new ArrayList<String>();
	public static ArrayList<String> Lumberjack = new ArrayList<String>();
	public static ArrayList<String> Tank = new ArrayList<String>();

	public static void openGUI(Player player) {
		Inventory i = Bukkit.createInventory(null, 54, ChatColor.DARK_RED + "Kit Selector");
		// Alle items in de gui zelf
		// Vampire Item in KitsGUI
		ItemStack Vampire = new ItemStack(Material.REDSTONE);
		ItemMeta VampireMeta = Vampire.getItemMeta();
		VampireMeta.spigot().setUnbreakable(true);
		VampireMeta.setDisplayName(ChatColor.WHITE + "Vampire");
		if (!player.hasPermission("Kitpvp.Kit.Vampire")) {
			List<String> Vampirelore = new ArrayList<String>();
			Vampirelore.add(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You do not own this kit");
			Vampirelore.add(ChatColor.GRAY + "This kit costs: 7500 Coins");
			VampireMeta.setLore(Vampirelore);
		} else {
			List<String> lore = new ArrayList<String>();
			lore.add(ChatColor.GREEN + "" + ChatColor.BOLD + "Kit unlocked");
			lore.add(ChatColor.GRAY + "");
			VampireMeta.setLore(lore);
		}
		Vampire.setItemMeta(VampireMeta);

		// Swordsman Item in KitsGUI
		ItemStack Swordsman = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta SwordsmanMeta = Swordsman.getItemMeta();
		SwordsmanMeta.setDisplayName(ChatColor.AQUA + "Swordsman");
		if (!player.hasPermission("Kitpvp.Kit.Swordsman")) {
			List<String> Swordslore = new ArrayList<String>();
			Swordslore.add(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You do not own this kit");
			Swordslore.add(ChatColor.GRAY + "This kit costs: 12000 Coins");
			SwordsmanMeta.setLore(Swordslore);
		} else {
			List<String> Swordslore = new ArrayList<String>();
			Swordslore.add(ChatColor.GREEN + "" + ChatColor.BOLD + "Kit unlocked");
			Swordslore.add(ChatColor.GRAY + "");
			SwordsmanMeta.setLore(Swordslore);
		}
		Swordsman.setItemMeta(SwordsmanMeta);

		// Pyro Item in KitsGUI
		ItemStack Pyro = new ItemStack(Material.BLAZE_POWDER);
		ItemMeta PyroMeta = Pyro.getItemMeta();
		PyroMeta.setDisplayName(ChatColor.RED + "Pyro");
		if (!player.hasPermission("Kitpvp.Kit.Pyro")) {
			List<String> Pyrolore = new ArrayList<String>();
			Pyrolore.add(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You do not own this kit");
			Pyrolore.add(ChatColor.GRAY + "This kit costs: 6500 Coins");
			PyroMeta.setLore(Pyrolore);
		} else {
			List<String> Pyrolore = new ArrayList<String>();
			Pyrolore.add(ChatColor.GREEN + "" + ChatColor.BOLD + "Kit unlocked");
			Pyrolore.add(ChatColor.GRAY + "");
			PyroMeta.setLore(Pyrolore);
		}
		Pyro.setItemMeta(PyroMeta);

		// Witch Item in KitsGUI
		ItemStack Witch = new ItemStack(Material.QUARTZ, 1);
		ItemMeta WitchMeta = Witch.getItemMeta();
		WitchMeta.setDisplayName(ChatColor.DARK_AQUA + "Witch");
		if (!player.hasPermission("Kitpvp.Kit.Witch")) {
			List<String> Witchlore = new ArrayList<String>();
			Witchlore.add(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You do not own this kit");
			Witchlore.add(ChatColor.GRAY + "This kit costs: 5000 Coins");
			WitchMeta.setLore(Witchlore);
		} else {
			List<String> Witchlore = new ArrayList<String>();
			Witchlore.add(ChatColor.GREEN + "" + ChatColor.BOLD + "Kit unlocked");
			Witchlore.add(ChatColor.GRAY + "");
			WitchMeta.setLore(Witchlore);
		}
		Witch.setItemMeta(WitchMeta);

		// Archer Item in KitsGUI
		ItemStack Archer = new ItemStack(Material.BOW);
		ItemMeta ArcherMeta = Archer.getItemMeta();
		ArcherMeta.setDisplayName(ChatColor.DARK_GREEN + "Archer");
		if (!player.hasPermission("Kitpvp.Kit.Archer")) {
			List<String> Archerlore = new ArrayList<String>();
			Archerlore.add(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You do not own this kit");
			Archerlore.add(ChatColor.GRAY + "This kit costs: 4500 Coins");
			ArcherMeta.setLore(Archerlore);
		} else {
			List<String> Archerlore = new ArrayList<String>();
			Archerlore.add(ChatColor.GREEN + "" + ChatColor.BOLD + "Kit unlocked");
			Archerlore.add(ChatColor.GRAY + "");
			ArcherMeta.setLore(Archerlore);
		}
		Archer.setItemMeta(ArcherMeta);

		// Fisherman Item in KitsGUI
		ItemStack Fisherman = new ItemStack(Material.FISHING_ROD);
		ItemMeta FishermanMeta = Fisherman.getItemMeta();
		FishermanMeta.setDisplayName(ChatColor.DARK_BLUE + "Fisherman");
		if (!player.hasPermission("Kitpvp.Kit.Fisherman")) {
			List<String> Fishermanlore = new ArrayList<String>();
			Fishermanlore.add(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You do not own this kit");
			Fishermanlore.add(ChatColor.GRAY + "This kit costs: 4000 Coins");
			FishermanMeta.setLore(Fishermanlore);
		} else {
			List<String> Fishermanlore = new ArrayList<String>();
			Fishermanlore.add(ChatColor.GREEN + "" + ChatColor.BOLD + "Kit unlocked");
			Fishermanlore.add(ChatColor.GRAY + "");
			FishermanMeta.setLore(Fishermanlore);
		}
		Fisherman.setItemMeta(FishermanMeta);

		// Troll Item in KitsGUI
		ItemStack Lumberjack = new ItemStack(Material.IRON_AXE, 1);
		ItemMeta LumberjackMeta = (ItemMeta) Lumberjack.getItemMeta();
		LumberjackMeta.setDisplayName(ChatColor.DARK_PURPLE + "LumberJack");
		if (!player.hasPermission("Kitpvp.Kit.Lumberjack")) {
			List<String> Lumberjacklore = new ArrayList<String>();
			Lumberjacklore.add(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You do not own this kit");
			Lumberjacklore.add(ChatColor.GRAY + "This kit costs: 3500 Coins");
			LumberjackMeta.setLore(Lumberjacklore);
		} else {
			List<String> Lumberjacklore = new ArrayList<String>();
			Lumberjacklore.add(ChatColor.GREEN + "" + ChatColor.BOLD + "Kit unlocked");
			Lumberjacklore.add(ChatColor.GRAY + "");
			LumberjackMeta.setLore(Lumberjacklore);
		}
		Lumberjack.setItemMeta(LumberjackMeta);

		// Tank Item in KitsGUI
		ItemStack Tank = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta TankMeta = Tank.getItemMeta();
		TankMeta.setDisplayName(ChatColor.WHITE + "Tank");
		if (!player.hasPermission("Kitpvp.Kit.Tank")) {
			List<String> Tanklore = new ArrayList<String>();
			Tanklore.add(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You do not own this kit");
			Tanklore.add(ChatColor.GRAY + "This kit costs: 3500 Coins");
			TankMeta.setLore(Tanklore);
		} else {
			List<String> Tanklore = new ArrayList<String>();
			Tanklore.add(ChatColor.GREEN + "" + ChatColor.BOLD + "Kit unlocked");
			Tanklore.add(ChatColor.GRAY + "");
			TankMeta.setLore(Tanklore);
		}
		Tank.setItemMeta(TankMeta);

		// Scout Item in KitsGUI
		ItemStack Scout = new ItemStack(Material.BREAD);
		ItemMeta ScoutMeta = Scout.getItemMeta();
		ScoutMeta.setDisplayName(ChatColor.WHITE + "Scout");
		if (!player.hasPermission("Kitpvp.Kit.Scout")) {
			List<String> Scoutlore = new ArrayList<String>();
			Scoutlore.add(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You do not own this kit");
			Scoutlore.add(ChatColor.GRAY + "If you don't own this free kit please contact a server admin.");
			ScoutMeta.setLore(Scoutlore);
		} else {
			List<String> Scoutlore = new ArrayList<String>();
			Scoutlore.add(ChatColor.GREEN + "" + ChatColor.BOLD + "Kit unlocked");
			Scoutlore.add(ChatColor.GRAY + "");
			ScoutMeta.setLore(Scoutlore);
		}
		Scout.setItemMeta(ScoutMeta);

		// Donator Item in KitsGUI
		ItemStack Donator = new ItemStack(Material.SNOW_BALL);
		ItemMeta DonatorMeta = Donator.getItemMeta();
		DonatorMeta.setDisplayName(ChatColor.WHITE + "Olaf");
		if (!player.hasPermission("Kitpvp.Kit.Olaf")) {
			List<String> Donatorlore = new ArrayList<String>();
			Donatorlore.add(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You do not own this kit");
			Donatorlore.add(ChatColor.GRAY + "This kit is only available to donators");
			DonatorMeta.setLore(Donatorlore);
		} else {
			List<String> Donatorlore = new ArrayList<String>();
			Donatorlore.add(ChatColor.GREEN + "" + ChatColor.BOLD + "Kit unlocked");
			Donatorlore.add(ChatColor.GRAY + "");
			DonatorMeta.setLore(Donatorlore);
		}
		Donator.setItemMeta(DonatorMeta);

		ItemStack GlasOranje = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3);
		ItemMeta GlasOranjeMeta = GlasOranje.getItemMeta();
		GlasOranjeMeta.setDisplayName(ChatColor.AQUA + "");
		GlasOranje.setItemMeta(GlasOranjeMeta);

		ItemStack GlasRood = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 10);
		ItemMeta GlasRoodMeta = GlasRood.getItemMeta();
		GlasRoodMeta.setDisplayName(ChatColor.AQUA + "");
		GlasRood.setItemMeta(GlasRoodMeta);

		ItemStack GlasWit = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
		ItemMeta GlasWitMeta = GlasWit.getItemMeta();
		GlasWitMeta.setDisplayName(ChatColor.AQUA + "");
		GlasWit.setItemMeta(GlasWitMeta);

		ItemStack CloseMenu = new ItemStack(Material.ARROW);
		ItemMeta CloseMenuMeta = CloseMenu.getItemMeta();
		CloseMenuMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Close");
		CloseMenu.setItemMeta(CloseMenuMeta);

		ItemStack InfoBook = new ItemStack(Material.BOOK);
		ItemMeta InfoBookMeta = InfoBook.getItemMeta();
		InfoBookMeta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Player Info");
		List<String> InfoBooklore = new ArrayList<String>();
		InfoBooklore.add(ChatColor.WHITE + "Coins: " + Main.getEcononomy().getBalance(player));
		InfoBooklore.add(ChatColor.WHITE + "Kills: " + player.getStatistic(Statistic.PLAYER_KILLS));
		InfoBooklore.add(ChatColor.WHITE + "Deaths: " + player.getStatistic(Statistic.DEATHS));
		InfoBooklore.add(ChatColor.WHITE + "Total damage dealt: " + player.getStatistic(Statistic.DAMAGE_DEALT));
		InfoBookMeta.setLore(InfoBooklore);
		InfoBook.setItemMeta(InfoBookMeta);

		i.setItem(0, GlasRood);
		i.setItem(1, GlasOranje);
		i.setItem(2, GlasWit);
		i.setItem(3, GlasWit);
		i.setItem(5, GlasWit);
		i.setItem(6, GlasWit);
		i.setItem(7, GlasOranje);
		i.setItem(8, GlasRood);
		i.setItem(9, GlasOranje);
		i.setItem(17, GlasOranje);
		i.setItem(18, GlasWit);
		i.setItem(20, Archer);
		i.setItem(21, Vampire);
		i.setItem(22, Swordsman);
		i.setItem(23, Pyro);
		i.setItem(24, Witch);
		i.setItem(26, GlasWit);
		i.setItem(27, GlasWit);
		i.setItem(29, Fisherman);
		i.setItem(30, Lumberjack);
		i.setItem(31, Tank);
		i.setItem(32, Scout);
		i.setItem(33, Donator);
		i.setItem(35, GlasWit);
		i.setItem(36, GlasOranje);
		i.setItem(44, GlasOranje);
		i.setItem(45, GlasRood);
		i.setItem(46, GlasOranje);
		i.setItem(47, GlasWit);
		i.setItem(48, InfoBook);
		i.setItem(49, GlasWit);
		i.setItem(50, CloseMenu);
		i.setItem(51, GlasWit);
		i.setItem(52, GlasOranje);
		i.setItem(53, GlasRood);

		player.openInventory(i);
	}

	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent InvClickEvent) {
		if (!ChatColor.stripColor(InvClickEvent.getInventory().getName()).equalsIgnoreCase("Kit Selector"))
			return;
		Player player = (Player) InvClickEvent.getWhoClicked();
		InvClickEvent.setCancelled(true);

		String playerstring = player.toString();

		switch (InvClickEvent.getCurrentItem().getType()) {
		case REDSTONE:
			player.closeInventory();
			if (player.hasPermission("Kitpvp.Kit.Vampire")) {
				VampireBlood.add(playerstring);
				player.getInventory().clear();
				// Helmet Vampire
				ItemStack Vh = new ItemStack(Material.LEATHER_HELMET);
				LeatherArmorMeta VhMeta = (LeatherArmorMeta) Vh.getItemMeta();
				VhMeta.spigot().setUnbreakable(true);
				VhMeta.setColor(Color.fromRGB(10, 9, 9));
				Vh.setItemMeta(VhMeta);
				Vh.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				player.getInventory().setHelmet(Vh);

				// ChestPlate Vampire
				ItemStack Vc = new ItemStack(Material.LEATHER_CHESTPLATE);
				LeatherArmorMeta VcMeta = (LeatherArmorMeta) Vc.getItemMeta();
				VcMeta.spigot().setUnbreakable(true);
				VcMeta.setColor(Color.fromRGB(45, 7, 30));
				Vc.setItemMeta(VcMeta);
				Vc.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				player.getInventory().setChestplate(Vc);

				// Leggings Vampire
				ItemStack Vl = new ItemStack(Material.LEATHER_LEGGINGS);
				LeatherArmorMeta VlMeta = (LeatherArmorMeta) Vl.getItemMeta();
				VlMeta.spigot().setUnbreakable(true);
				VlMeta.setColor(Color.fromRGB(23, 14, 16));
				Vl.setItemMeta(VlMeta);
				Vl.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				player.getInventory().setLeggings(Vl);

				// Boots Vampire
				ItemStack Vb = new ItemStack(Material.LEATHER_BOOTS);
				LeatherArmorMeta VbMeta = (LeatherArmorMeta) Vb.getItemMeta();
				VbMeta.spigot().setUnbreakable(true);
				VbMeta.setColor(Color.fromRGB(23, 14, 16));
				Vb.setItemMeta(VbMeta);
				Vb.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				player.getInventory().setBoots(Vb);

				// Vampire Fang
				ItemStack Vw = new ItemStack(Material.GHAST_TEAR);
				ItemMeta VwMeta = Vw.getItemMeta();
				VwMeta.setDisplayName(ChatColor.WHITE + "Vampire's Fang");
				Vw.setItemMeta(VwMeta);
				Vw.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 6);
				player.getInventory().addItem(Vw);

				// teleport
				RandomTeleport.RandomTeleport(player);

				player.sendMessage(ChatColor.translateAlternateColorCodes('&', chat.prefix + "You have selected kit &6&lVampire&f!"));
			}
			if (!player.hasPermission("Kitpvp.Kit.Vampire")) {
				Vampire.add(playerstring);
				KitBuyGUI.openBuyGUI(player);
			}
			break;
		case DIAMOND_SWORD:
			player.closeInventory();
			if (player.hasPermission("Kitpvp.Kit.Swordsman")) {
				player.getInventory().clear();
				// Helmet Swordsman
				ItemStack Sh = new ItemStack(Material.LEATHER_HELMET);
				LeatherArmorMeta ShMeta = (LeatherArmorMeta) Sh.getItemMeta();
				ShMeta.spigot().setUnbreakable(true);
				ShMeta.setColor(Color.fromRGB(40, 38, 74));
				Sh.setItemMeta(ShMeta);
				Sh.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				player.getInventory().setHelmet(Sh);

				// Chestplate Swordsman
				ItemStack Sc = new ItemStack(Material.LEATHER_CHESTPLATE);
				LeatherArmorMeta ScMeta = (LeatherArmorMeta) Sc.getItemMeta();
				ScMeta.spigot().setUnbreakable(true);
				ScMeta.setColor(Color.fromRGB(40, 38, 74));
				Sc.setItemMeta(ScMeta);
				Sc.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				player.getInventory().setChestplate(Sc);

				// Leggings Swordsman
				ItemStack Sl = new ItemStack(Material.IRON_LEGGINGS);
				ItemMeta SlMeta = Sl.getItemMeta();
				SlMeta.spigot().setUnbreakable(true);
				Sl.setItemMeta(SlMeta);
				Sl.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				player.getInventory().setLeggings(Sl);

				// Boots Swordsman
				ItemStack Sb = new ItemStack(Material.LEATHER_BOOTS);
				LeatherArmorMeta SbMeta = (LeatherArmorMeta) Sb.getItemMeta();
				SbMeta.spigot().setUnbreakable(true);
				SbMeta.setColor(Color.fromRGB(40, 38, 74));
				Sb.setItemMeta(SbMeta);
				Sb.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				player.getInventory().setBoots(Sb);

				// Weapon Swordsman
				ItemStack Ss = new ItemStack(Material.IRON_SWORD);
				ItemMeta SsMeta = Ss.getItemMeta();
				SsMeta.spigot().setUnbreakable(true);
				Ss.setItemMeta(SsMeta);
				player.getInventory().addItem(Ss);

				// teleport
				RandomTeleport.RandomTeleport(player);

				player.sendMessage(ChatColor.translateAlternateColorCodes('&', chat.prefix + "You have selected kit &6&lSwordsman&f!"));
			}
			if (!player.hasPermission("Kitpvp.Kit.Swordsman")) {
				Swordsman.add(playerstring);
				KitBuyGUI.openBuyGUI(player);
			}
			break;
		case BLAZE_POWDER:
			player.closeInventory();
			if (player.hasPermission("Kitpvp.Kit.Pyro")) {
				player.getInventory().clear();

				// Helmet Pyro
				ItemStack Ph = new ItemStack(Material.GOLD_HELMET);
				ItemMeta PhMeta = Ph.getItemMeta();
				PhMeta.spigot().setUnbreakable(true);
				Ph.setItemMeta(PhMeta);
				player.getInventory().setHelmet(Ph);

				// Chestplate Pyro
				ItemStack Pc = new ItemStack(Material.LEATHER_CHESTPLATE);
				LeatherArmorMeta PcMeta = (LeatherArmorMeta) Pc.getItemMeta();
				PcMeta.spigot().setUnbreakable(true);
				PcMeta.setColor(Color.fromRGB(209, 187, 3));
				Pc.setItemMeta(PcMeta);
				Pc.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				player.getInventory().setChestplate(Pc);

				// Leggins Pyro
				ItemStack Pl = new ItemStack(Material.LEATHER_LEGGINGS);
				LeatherArmorMeta PlMeta = (LeatherArmorMeta) Pl.getItemMeta();
				PlMeta.spigot().setUnbreakable(true);
				PlMeta.setColor(Color.fromRGB(209, 187, 3));
				Pl.setItemMeta(PlMeta);
				Pl.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				player.getInventory().setLeggings(Pl);

				// Boots Pyro
				ItemStack Pb = new ItemStack(Material.GOLD_BOOTS);
				ItemMeta PbMeta = Pb.getItemMeta();
				PbMeta.spigot().setUnbreakable(true);
				Pb.setItemMeta(PbMeta);
				player.getInventory().setBoots(Pb);

				// Weapon Pyro
				ItemStack Pw = new ItemStack(Material.GOLD_SWORD);
				ItemMeta PwMeta = Pw.getItemMeta();
				PwMeta.spigot().setUnbreakable(true);
				PwMeta.setDisplayName(ChatColor.WHITE + "Pyro Sword");
				Pw.setItemMeta(PwMeta);
				Pw.addEnchantment(Enchantment.FIRE_ASPECT, 1);
				Pw.addEnchantment(Enchantment.DAMAGE_ALL, 1);
				player.getInventory().addItem(Pw);

				// potion Fire Resistance
				Potion Ppot = new Potion(PotionType.FIRE_RESISTANCE, 1);
				ItemStack PpotItem = Ppot.toItemStack(1);
				player.getInventory().addItem(PpotItem);

				// teleport
				RandomTeleport.RandomTeleport(player);

				player.sendMessage(ChatColor.translateAlternateColorCodes('&', chat.prefix + "You have selected kit &6&lPyro&f!"));
			}
			if (!player.hasPermission("Kitpvp.Kit.Pyro")) {
				Pyro.add(playerstring);
				KitBuyGUI.openBuyGUI(player);
			}
			break;
		case QUARTZ:
			player.closeInventory();
			if (player.hasPermission("Kitpvp.Kit.Witch")) {
				player.getInventory().clear();
				// Helmet Witch
				ItemStack Wh = new ItemStack(Material.GOLD_HELMET);
				ItemMeta WhMeta = Wh.getItemMeta();
				WhMeta.spigot().setUnbreakable(true);
				Wh.setItemMeta(WhMeta);
				Wh.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				player.getInventory().setHelmet(Wh);

				// Chestplate Witch
				ItemStack Wc = new ItemStack(Material.LEATHER_CHESTPLATE);
				LeatherArmorMeta WcMeta = (LeatherArmorMeta) Wc.getItemMeta();
				WcMeta.spigot().setUnbreakable(true);
				WcMeta.setColor(Color.fromRGB(9, 18, 16));
				Wc.setItemMeta(WcMeta);
				Wc.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				player.getInventory().setChestplate(Wc);

				// Leggings Witch
				ItemStack Wl = new ItemStack(Material.LEATHER_LEGGINGS);
				LeatherArmorMeta WlMeta = (LeatherArmorMeta) Wl.getItemMeta();
				WlMeta.spigot().setUnbreakable(true);
				WlMeta.setColor(Color.fromRGB(9, 18, 16));
				Wl.setItemMeta(WlMeta);
				player.getInventory().setLeggings(Wl);

				// Boots Witch
				ItemStack Wb = new ItemStack(Material.IRON_BOOTS);
				ItemMeta WbMeta = Wb.getItemMeta();
				WbMeta.spigot().setUnbreakable(true);
				Wb.setItemMeta(WbMeta);
				player.getInventory().setBoots(Wb);

				// Weapon Witch
				ItemStack Ww = new ItemStack(Material.STONE_SWORD);
				ItemMeta WwMeta = Ww.getItemMeta();
				WwMeta.spigot().setUnbreakable(true);
				WwMeta.setDisplayName(ChatColor.WHITE + "Witch sword");
				Ww.setItemMeta(WwMeta);
				Ww.addEnchantment(Enchantment.DAMAGE_ALL, 2);
				player.getInventory().addItem(Ww);

				// Potion Witch
				Potion Wpot = new Potion(PotionType.POISON, 1);// poison 1
				Wpot.setSplash(true);
				player.getInventory().addItem(Wpot.toItemStack(1));

				// teleport
				RandomTeleport.RandomTeleport(player);

				player.sendMessage(ChatColor.translateAlternateColorCodes('&', chat.prefix + "You have selected kit &6&lWitch&f!"));
			}
			if (!player.hasPermission("Kitpvp.Kit.Witch")) {
				Witch.add(playerstring);
				KitBuyGUI.openBuyGUI(player);
			}
			break;
		case BOW:
			player.closeInventory();
			if (player.hasPermission("Kitpvp.Kit.Archer")) {
				player.getInventory().clear();

				// Helmet Archer
				ItemStack Ah = new ItemStack(Material.LEATHER_HELMET);
				LeatherArmorMeta AhMeta = (LeatherArmorMeta) Ah.getItemMeta();
				AhMeta.spigot().setUnbreakable(true);
				AhMeta.setColor(Color.fromRGB(34, 43, 31));
				Ah.setItemMeta(AhMeta);
				Ah.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				player.getInventory().setHelmet(Ah);

				// Chestplate Archer
				ItemStack Ac = new ItemStack(Material.LEATHER_CHESTPLATE);
				LeatherArmorMeta AcMeta = (LeatherArmorMeta) Ac.getItemMeta();
				AcMeta.spigot().setUnbreakable(true);
				AcMeta.setColor(Color.fromRGB(23, 71, 10));
				Ac.setItemMeta(AcMeta);
				Ac.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				player.getInventory().setChestplate(Ac);

				// Leggings Archer
				ItemStack Al = new ItemStack(Material.LEATHER_LEGGINGS);
				LeatherArmorMeta AlMeta = (LeatherArmorMeta) Al.getItemMeta();
				AlMeta.spigot().setUnbreakable(true);
				AlMeta.setColor(Color.fromRGB(23, 71, 10));
				Al.setItemMeta(AlMeta);
				Al.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				player.getInventory().setLeggings(Al);

				// Boots Archer
				ItemStack Ab = new ItemStack(Material.IRON_BOOTS);
				ItemMeta AbMeta = Ab.getItemMeta();
				AbMeta.spigot().setUnbreakable(true);
				Ab.setItemMeta(AbMeta);
				player.getInventory().setBoots(Ab);

				// Weapon Archer
				ItemStack Aw = new ItemStack(Material.IRON_SWORD);
				ItemMeta AwMeta = Aw.getItemMeta();
				AwMeta.spigot().setUnbreakable(true);
				AwMeta.setDisplayName(ChatColor.WHITE + "Hunting knife");
				Aw.setItemMeta(AwMeta);
				player.getInventory().addItem(Aw);

				// Bow Archer
				ItemStack Abow = new ItemStack(Material.BOW);
				ItemMeta AbowMeta = Abow.getItemMeta();
				AbowMeta.spigot().setUnbreakable(true);
				AbowMeta.setDisplayName(ChatColor.WHITE + "Longbow");
				Abow.setItemMeta(AbowMeta);
				Abow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
				player.getInventory().addItem(Abow);
				player.getInventory().addItem(new ItemStack(Material.ARROW, 16));

				// teleport
				RandomTeleport.RandomTeleport(player);

				player.sendMessage(ChatColor.translateAlternateColorCodes('&', chat.prefix + "You have selected kit &6&lArcher&f!"));
			}
			if (!player.hasPermission("Kitpvp.Kit.Archer")) {
				Archer.add(playerstring);
				KitBuyGUI.openBuyGUI(player);
			}
			break;

		case FISHING_ROD:
			player.closeInventory();
			if (player.hasPermission("Kitpvp.Kit.Fisherman")) {
				player.getInventory().clear();

				// Helmet Fisherman
				ItemStack Fh = new ItemStack(Material.LEATHER_HELMET);
				LeatherArmorMeta FhMeta = (LeatherArmorMeta) Fh.getItemMeta();
				FhMeta.spigot().setUnbreakable(true);
				FhMeta.setColor(Color.fromRGB(11, 46, 97));
				Fh.setItemMeta(FhMeta);
				Fh.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				player.getInventory().setHelmet(Fh);

				// Chestplate Fisherman
				ItemStack Fc = new ItemStack(Material.LEATHER_CHESTPLATE);
				LeatherArmorMeta FcMeta = (LeatherArmorMeta) Fc.getItemMeta();
				FcMeta.spigot().setUnbreakable(true);
				FcMeta.setColor(Color.fromRGB(11, 46, 97));
				Fc.setItemMeta(FcMeta);
				Fc.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				player.getInventory().setChestplate(Fc);

				// Leggings Fisherman
				ItemStack Fl = new ItemStack(Material.LEATHER_LEGGINGS);
				LeatherArmorMeta FlMeta = (LeatherArmorMeta) Fl.getItemMeta();
				FlMeta.spigot().setUnbreakable(true);
				FlMeta.setColor(Color.fromRGB(11, 46, 97));
				Fl.setItemMeta(FlMeta);
				Fl.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				player.getInventory().setLeggings(Fl);

				// Boots Fisherman
				ItemStack Fb = new ItemStack(Material.DIAMOND_BOOTS);
				ItemMeta FbMeta = Fb.getItemMeta();
				FbMeta.spigot().setUnbreakable(true);
				Fb.setItemMeta(FbMeta);
				Fb.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				player.getInventory().setBoots(Fb);

				// Weapon Fisherman
				ItemStack Fw = new ItemStack(Material.STONE_SWORD);
				ItemMeta FwMeta = Fw.getItemMeta();
				FwMeta.spigot().setUnbreakable(true);
				FwMeta.setDisplayName(ChatColor.WHITE + "Filleting knife");
				Fw.setItemMeta(FwMeta);
				Fw.addEnchantment(Enchantment.DAMAGE_ALL, 1);
				player.getInventory().addItem(Fw);

				// Rod Fisherman
				ItemStack Frod = new ItemStack(Material.FISHING_ROD);
				ItemMeta FrodMeta = Frod.getItemMeta();
				FrodMeta.spigot().setUnbreakable(true);
				FrodMeta.setDisplayName(ChatColor.WHITE + "Rod");
				Frod.setItemMeta(FrodMeta);
				player.getInventory().addItem(Frod);

				// SwiftPot Fisherman
				Potion Fpot = new Potion(PotionType.SPEED, 1);
				Fpot.setSplash(true);
				player.getInventory().addItem(Fpot.toItemStack(1));

				// teleport
				RandomTeleport.RandomTeleport(player);

				player.sendMessage(ChatColor.translateAlternateColorCodes('&', chat.prefix + "You have selected kit &6&lFisherman&f!"));
			}
			if (!player.hasPermission("Kitpvp.Kit.Fisherman")) {
				Fisherman.add(playerstring);
				KitBuyGUI.openBuyGUI(player);
			}
			break;

		case IRON_AXE:
			player.closeInventory();
			if (player.hasPermission("Kitpvp.Kit.Lumberjack")) {
				player.getInventory().clear();

				// Helmet Troll
				ItemStack Th = new ItemStack(Material.LEATHER_HELMET);
				LeatherArmorMeta ThMeta = (LeatherArmorMeta) Th.getItemMeta();
				ThMeta.setDisplayName(ChatColor.WHITE + "Lumberjack");
				ThMeta.spigot().setUnbreakable(true);
				Th.setItemMeta(ThMeta);
				player.getInventory().setHelmet(Th);

				// Chestplate Troll
				ItemStack Tc = new ItemStack(Material.LEATHER_CHESTPLATE);
				LeatherArmorMeta TcMeta = (LeatherArmorMeta) Tc.getItemMeta();
				TcMeta.setColor(Color.fromRGB(232, 209, 14));
				TcMeta.spigot().setUnbreakable(true);
				Tc.setItemMeta(TcMeta);
				Tc.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				player.getInventory().setChestplate(Tc);

				// Leggins Troll
				ItemStack Tl = new ItemStack(Material.LEATHER_LEGGINGS);
				LeatherArmorMeta TlMeta = (LeatherArmorMeta) Tl.getItemMeta();
				TlMeta.setColor(Color.fromRGB(227, 84, 53));
				TlMeta.spigot().setUnbreakable(true);
				Tl.setItemMeta(TlMeta);
				Tl.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				player.getInventory().setLeggings(Tl);

				// Boots Troll
				ItemStack Tb = new ItemStack(Material.LEATHER_BOOTS);
				LeatherArmorMeta TbMeta = (LeatherArmorMeta) Tb.getItemMeta();
				TbMeta.setColor(Color.fromRGB(25, 201, 200));
				TbMeta.spigot().setUnbreakable(true);
				Tb.setItemMeta(TbMeta);
				player.getInventory().setBoots(Tb);

				// Weapon Lumberjack
				ItemStack Tw = new ItemStack(Material.IRON_AXE);
				ItemMeta TwMeta = Tw.getItemMeta();
				TwMeta.setDisplayName(ChatColor.WHITE + "Axe");
				TwMeta.spigot().setUnbreakable(true);
				Tw.setItemMeta(TwMeta);
				Tw.addEnchantment(Enchantment.DAMAGE_ALL, 1);
				player.getInventory().addItem(Tw);


				// teleport
				RandomTeleport.RandomTeleport(player);

				player.sendMessage(ChatColor.translateAlternateColorCodes('&', chat.prefix + "You have selected kit &6&lLumberjack&f!"));
			}
			if (!player.hasPermission("Kitpvp.Kit.Lumberjack")) {
				Lumberjack.add(playerstring);
				KitBuyGUI.openBuyGUI(player);
			}
			break;

		case IRON_CHESTPLATE:
			player.closeInventory();
			if (player.hasPermission("Kitpvp.Kit.Tank")) {
				player.getInventory().clear();

				// Helmet Tank
				ItemStack Tankh = new ItemStack(Material.IRON_HELMET);
				ItemMeta TankhMeta = Tankh.getItemMeta();
				TankhMeta.spigot().setUnbreakable(true);
				Tankh.setItemMeta(TankhMeta);
				player.getInventory().setHelmet(Tankh);

				// Chestplate Tank
				ItemStack Tankc = new ItemStack(Material.IRON_CHESTPLATE);
				ItemMeta TankcMeta = Tankc.getItemMeta();
				TankcMeta.spigot().setUnbreakable(true);
				Tankc.setItemMeta(TankcMeta);
				player.getInventory().setChestplate(Tankc);

				// Leggins Tank
				ItemStack Tankl = new ItemStack(Material.IRON_LEGGINGS);
				ItemMeta TanklMeta = Tankl.getItemMeta();
				TanklMeta.spigot().setUnbreakable(true);
				Tankl.setItemMeta(TanklMeta);
				player.getInventory().setLeggings(Tankl);

				// Boots Tank
				ItemStack Tankb = new ItemStack(Material.IRON_BOOTS);
				ItemMeta TankbMeta = Tankb.getItemMeta();
				TankbMeta.spigot().setUnbreakable(true);
				Tankb.setItemMeta(TankbMeta);
				player.getInventory().setBoots(Tankb);

				// Weapon Tank
				ItemStack Tankw = new ItemStack(Material.STONE_SWORD);
				ItemMeta TankwMeta = Tankw.getItemMeta();
				TankwMeta.setDisplayName(ChatColor.WHITE + "Tank Sword");
				TankwMeta.spigot().setUnbreakable(true);
				Tankw.setItemMeta(TankwMeta);
				Tankw.addEnchantment(Enchantment.DAMAGE_ALL, 1);
				player.getInventory().addItem(Tankw);

				// GoldenAppels Tank
				ItemStack Gapples = new ItemStack(Material.GOLDEN_APPLE, 2);
				player.getInventory().addItem(Gapples);

				// teleport
				RandomTeleport.RandomTeleport(player);

				player.sendMessage(ChatColor.translateAlternateColorCodes('&', chat.prefix + "You have selected kit &6&lTank&f!"));
			}
			if (!player.hasPermission("Kitpvp.Kit.Tank")) {
				Tank.add(playerstring);
				KitBuyGUI.openBuyGUI(player);
			}
			break;

		case BREAD:
			player.closeInventory();
			if (player.hasPermission("Kitpvp.Kit.Scout")) {
				player.getInventory().clear();

				// Helmet Scout
				ItemStack Sch = new ItemStack(Material.CHAINMAIL_HELMET);
				ItemMeta SchMeta = Sch.getItemMeta();
				SchMeta.spigot().setUnbreakable(true);
				Sch.setItemMeta(SchMeta);
				player.getInventory().setHelmet(Sch);

				// Chestplate Scout
				ItemStack Scc = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
				ItemMeta SccMeta = Scc.getItemMeta();
				SccMeta.spigot().setUnbreakable(true);
				Scc.setItemMeta(SccMeta);
				player.getInventory().setChestplate(Scc);

				// Leggins Scout
				ItemStack Scl = new ItemStack(Material.CHAINMAIL_LEGGINGS);
				ItemMeta SclMeta = Scl.getItemMeta();
				SclMeta.spigot().setUnbreakable(true);
				Scl.setItemMeta(SclMeta);
				player.getInventory().setLeggings(Scl);

				// Boots Scout
				ItemStack Scb = new ItemStack(Material.CHAINMAIL_BOOTS);
				ItemMeta ScbMeta = Scb.getItemMeta();
				ScbMeta.spigot().setUnbreakable(true);
				Scb.setItemMeta(ScbMeta);
				player.getInventory().setBoots(Scb);

				// Weapon Scout
				ItemStack Scw = new ItemStack(Material.STONE_SWORD);
				ItemMeta ScwMeta = Scw.getItemMeta();
				ScwMeta.spigot().setUnbreakable(true);
				ScwMeta.setDisplayName(ChatColor.WHITE + "Scout Sword");
				Scw.setItemMeta(ScwMeta);
				Scw.addEnchantment(Enchantment.DAMAGE_ALL, 1);
				player.getInventory().addItem(Scw);

				// SpeedPots and Bread Scout
				Potion Scpot = new Potion(PotionType.SPEED, 1);
				Scpot.setSplash(true);
				player.getInventory().addItem(Scpot.toItemStack(1));

				// teleport
				RandomTeleport.RandomTeleport(player);

				player.sendMessage(ChatColor.translateAlternateColorCodes('&', chat.prefix + "You have selected kit &6&lScout&f!"));
			}
			break;

		case SNOW_BALL:
			player.closeInventory();
			if (player.hasPermission("Kitpvp.Kit.Olaf")) {
				player.getInventory().clear();
				// Helmet Donator
				ItemStack Dh = new ItemStack(Material.LEATHER_HELMET);
				LeatherArmorMeta DhMeta = (LeatherArmorMeta) Dh.getItemMeta();
				DhMeta.setColor(Color.fromRGB(255, 255, 255));
				DhMeta.spigot().setUnbreakable(true);
				Dh.setItemMeta(DhMeta);
				player.getInventory().setHelmet(Dh);

				// Chestplate Donator
				ItemStack Dc = new ItemStack(Material.LEATHER_CHESTPLATE);
				LeatherArmorMeta DcMeta = (LeatherArmorMeta) Dc.getItemMeta();
				DcMeta.spigot().setUnbreakable(true);
				DcMeta.setColor(Color.fromRGB(255, 255, 255));
				Dc.setItemMeta(DcMeta);
				Dc.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				player.getInventory().setChestplate(Dc);

				// Leggings Donator
				ItemStack Dl = new ItemStack(Material.LEATHER_LEGGINGS);
				LeatherArmorMeta DlMeta = (LeatherArmorMeta) Dl.getItemMeta();
				DlMeta.spigot().setUnbreakable(true);
				DlMeta.setColor(Color.fromRGB(255, 255, 255));
				Dl.setItemMeta(DlMeta);
				player.getInventory().setLeggings(Dl);

				// Boots Donator
				ItemStack Db = new ItemStack(Material.LEATHER_BOOTS);
				LeatherArmorMeta DbMeta = (LeatherArmorMeta) Db.getItemMeta();
				DbMeta.setColor(Color.fromRGB(255, 255, 255));
				DbMeta.spigot().setUnbreakable(true);
				Db.setItemMeta(DbMeta);
				Db.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				player.getInventory().setBoots(Db);

				// Weapon Donator
				ItemStack Dw = new ItemStack(Material.STICK);
				ItemMeta DwMeta = Dw.getItemMeta();
				DwMeta.spigot().setUnbreakable(true);
				DwMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE });
				DwMeta.setDisplayName(ChatColor.WHITE + "Olaf's arm");
				Dw.setItemMeta(DwMeta);
				Dw.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);
				player.getInventory().addItem(Dw);

				// Gapples Donator
				ItemStack DGapples = new ItemStack(Material.SNOW_BALL, 32);
				player.getInventory().addItem(DGapples);

				// teleport
				RandomTeleport.RandomTeleport(player);

				player.sendMessage(ChatColor.translateAlternateColorCodes('&', chat.prefix + "You have selected kit &6&lOlaf&f!"));
			}
			if (!player.hasPermission("Kitpvp.Kit.Olaf")) {
				player.sendMessage(ChatColor.RED + "You must be a donator to unlock this kit");
			}
			break;

		case ARROW:
			player.closeInventory();
			Kits.Archer.remove(player);
			Kits.Vampire.remove(player);
			Kits.Swordsman.remove(player);
			Kits.Pyro.remove(player);
			Kits.Witch.remove(player);
			Kits.Fisherman.remove(player);
			Kits.Lumberjack.remove(player);
			Kits.Tank.remove(player);
			break;

		default:
			break;
		}
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent KitsInteractEvent) {
		Player player = KitsInteractEvent.getPlayer();
		Action a = KitsInteractEvent.getAction();
		if (a == Action.PHYSICAL || KitsInteractEvent.getItem() == null
				|| KitsInteractEvent.getItem().getType() == Material.AIR)
			return;

		if (KitsInteractEvent.getItem().getType() == Material.GOLD_SWORD && KitsInteractEvent.getItem().getItemMeta()
				.getDisplayName().equalsIgnoreCase(PlayerEvents.color("&6§l>>§r&3 Kit Selector &6§l<<"))) {
			openGUI(player);
		} else if ((KitsInteractEvent.getItem().getType().equals(Material.BOOK) && KitsInteractEvent.getItem()
				.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Perks")))) {
			perkGUI.openPerksGUI(player);
		}
	}
}