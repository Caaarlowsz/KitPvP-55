package kitpvp.perks;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import kitpvp.data.CurrencyKitPvP;
import kitpvp.Main;

public class perkGUI implements Listener {

	public static void openPerksGUI(Player player) {

		Inventory in = Bukkit.createInventory(null, 27, ChatColor.DARK_RED + "Perks");
		String playerstring = player.toString();

		// Speed perk
		int SpeedLevel = PlayerPerks.getPerkLevel(player, "Speed");
		ItemStack Speed = new ItemStack(Material.STRING);
		ItemMeta SpeedMeta = Speed.getItemMeta();
		SpeedMeta.setDisplayName(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "Speed");
		List<String> Speedlore = new ArrayList<String>();
		if (SpeedLevel > 0 && SpeedLevel < 3) {
			Speedlore.add(ChatColor.GRAY + "Click here to upgrade your Speed to level " + (SpeedLevel + 1));
		} else if (SpeedLevel == 3) {
			Speedlore.add(ChatColor.GREEN + "You have maxed out this perk!");
		} else {
			Speedlore.add(ChatColor.GRAY + "Unlock this perk");
		}
		Speedlore.add(ChatColor.GRAY + "");
		SpeedMeta.setLore(Speedlore);
		Speed.setItemMeta(SpeedMeta);

		// AbsorptionPerk
		int AbsorptionLevel = PlayerPerks.getPerkLevel(player, "Absorption");
		ItemStack Absorption = new ItemStack(Material.GLOWSTONE_DUST);
		ItemMeta AbsorptionMeta = Absorption.getItemMeta();
		AbsorptionMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Absorption");
		List<String> Absorptionlore = new ArrayList<String>();
		if (AbsorptionLevel > 0 && AbsorptionLevel < 5) {
			Absorptionlore
					.add(ChatColor.GRAY + "Click here to upgrade your Absorption to level " + (AbsorptionLevel + 1));
		} else if (AbsorptionLevel == 5) {
			Absorptionlore.add(ChatColor.GREEN + "You have maxed out this perk!");
		} else {
			Absorptionlore.add(ChatColor.GRAY + "Unlock this perk ");
		}
		Absorptionlore.add(ChatColor.GRAY + "");
		AbsorptionMeta.setLore(Absorptionlore);
		Absorption.setItemMeta(AbsorptionMeta);

		int HealingLevel = PlayerPerks.getPerkLevel(player, "Healing");
		ItemStack Healing = new ItemStack(Material.APPLE);
		ItemMeta HealingMeta = Healing.getItemMeta();
		HealingMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Healing");
		List<String> Healinglore = new ArrayList<String>();
		if (HealingLevel > 0 && HealingLevel < 5) {
			Healinglore.add(ChatColor.GRAY + "Click here to upgrade your Healing to level " + (HealingLevel + 1));
		} else if (HealingLevel == 5) {
			Healinglore.add(ChatColor.GREEN + "You have maxed out this perk!");
		} else {
			Healinglore.add(ChatColor.GRAY + "Unlock this perk");
		}
		Healinglore.add(ChatColor.GRAY + "");
		HealingMeta.setLore(Healinglore);
		Healing.setItemMeta(HealingMeta);

		// InformatieBlock

		in.setItem(12, Speed);
		in.setItem(13, Absorption);
		in.setItem(14, Healing);

		player.openInventory(in);
	}

	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {
		if (!ChatColor.stripColor(e.getInventory().getName()).contains(("Perks"))) {
			return;
		}
		Player player = (Player) e.getWhoClicked();
		e.setCancelled(true);
		
		String playerstring = player.toString();
		String path = player.getUniqueId().toString() + ".Perks.";
		double Balance = (Main.getEcononomy().getBalance(player));
		switch (e.getCurrentItem().getType()) {
		case STRING:
			player.closeInventory();
			int levelSP = PlayerPerks.getPerkLevel(player, "Speed");
			if (Balance >= 200 && levelSP <= 2) {
				Main.getEcononomy().withdrawPlayer(player, 200);
				CurrencyKitPvP.setData((path + "Speed"), (CurrencyKitPvP.getDataInt((path + "Speed")) + 1));
				player.sendMessage(ChatColor.GREEN + "You have upgraded this perk to level " + ChatColor.DARK_PURPLE
						+ "" + ChatColor.BOLD + PlayerPerks.getPerkLevel(player, "Speed"));
			} else if (Balance < 200) {
				player.closeInventory();
				player.sendMessage(ChatColor.DARK_RED + "You dont have enough money to buy this perk.");
			} else {
				if (PlayerPerks.getPerkLevel(player, "Speed") == 3) {
					player.sendMessage(ChatColor.GREEN + "You have already maxed out this perk!");
				}
			}
			break;

		case GLOWSTONE_DUST:
			player.closeInventory();
			int levelAB = PlayerPerks.getPerkLevel(player, "Absorption");
			int costAB = 200 * levelAB;
			if (costAB == 0)
				costAB = 100;
			if (Balance >= costAB && levelAB <= 4) {
				Main.getEcononomy().withdrawPlayer(player, costAB);
				CurrencyKitPvP.setData((path + "Absorption"), (PlayerPerks.getPerkLevel(player, "Absorption") + 1));
				player.sendMessage(ChatColor.GREEN + "You have upgraded this perk to level " + ChatColor.DARK_PURPLE
						+ "" + ChatColor.BOLD + PlayerPerks.getPerkLevel(player, "Absorption"));
			} else if (Balance < costAB) {
				player.closeInventory();
				player.sendMessage(ChatColor.DARK_RED + "You dont have enough money to buy this perk.");
			} else {
				if (PlayerPerks.getPerkLevel(player, "Absorption") == 5) {
					player.sendMessage(ChatColor.GREEN + "You have already maxed out this perk!");
				}
			}
			break;

		case APPLE:
			player.closeInventory();
			int HEPerk = PlayerPerks.getPerkLevel(player, "Healing");
			if (Balance >= 200 && HEPerk <= 4) {
				Main.getEcononomy().withdrawPlayer(player, 200);
				CurrencyKitPvP.setData((path + "Healing"), (PlayerPerks.getPerkLevel(player, "Healing") + 1));
				player.sendMessage(ChatColor.GREEN + "You have upgraded this perk to level " + ChatColor.DARK_PURPLE
						+ "" + ChatColor.BOLD + PlayerPerks.getPerkLevel(player, "Healing"));
			} else if (Balance < 200) {
				player.closeInventory();
				player.sendMessage(ChatColor.DARK_RED + "You dont have enough money to buy this perk.");
			} else {
				if (PlayerPerks.getPerkLevel(player, "Healing") == 5) {
					player.sendMessage(ChatColor.GREEN + "You have already maxed out this perk!");
				}
			}
			break;

		default:
			break;
		}
	}
}
