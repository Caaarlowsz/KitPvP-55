package kitpvp.Kits;

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

import kitpvp.Main;
import kitpvp.Chat.chat;

public class KitBuyGUI implements Listener {

	public static void openBuyGUI(Player player) {

		Inventory in = Bukkit.createInventory(null, 27, ChatColor.DARK_RED + "Buy this kit");

		// Confirm Block
		ItemStack ConfirmBlock = new ItemStack(Material.EMERALD_BLOCK);
		ItemMeta ConfirmBlockMeta = ConfirmBlock.getItemMeta();
		ConfirmBlockMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Confirm");
		List<String> ConfirmBlocklore = new ArrayList<String>();
		ConfirmBlocklore.add(ChatColor.GREEN + "" + "Purchase this kit");
		ConfirmBlocklore.add(ChatColor.GRAY + "");
		ConfirmBlockMeta.setLore(ConfirmBlocklore);
		ConfirmBlock.setItemMeta(ConfirmBlockMeta);

		// Cancel Block
		ItemStack CancelBlock = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta CancelBlockMeta = CancelBlock.getItemMeta();
		CancelBlockMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Cancel");
		List<String> CancelBlocklore = new ArrayList<String>();
		CancelBlocklore.add(ChatColor.GRAY + "Click here to Cancel");
		CancelBlocklore.add(ChatColor.GRAY + "");
		CancelBlockMeta.setLore(CancelBlocklore);
		CancelBlock.setItemMeta(CancelBlockMeta);

		// InformatieBlock
		ItemStack InfoBlock = new ItemStack(Material.SIGN, 1);
		ItemMeta InfoBlockMeta = CancelBlock.getItemMeta();
		InfoBlockMeta.setDisplayName(ChatColor.WHITE + "Info");
		List<String> InfoBlocklore = new ArrayList<String>();
		if (Kits.Vampire.contains(player.toString())) {
			InfoBlocklore.add(ChatColor.GRAY + "The kit Vampire Costs: 3500");
		} else if (Kits.Archer.contains(player.toString())) {
			InfoBlocklore.add(ChatColor.GRAY + "The kit Archer Costs: 4500");
		} else if (Kits.Swordsman.contains(player.toString())) {
			InfoBlocklore.add(ChatColor.GRAY + "The kit Swordsman Costs: 6000");
		} else if (Kits.Pyro.contains(player.toString())) {
			InfoBlocklore.add(ChatColor.GRAY + "The kit Pyro Costs: 6500");
		} else if (Kits.Witch.contains(player.toString())) {
			InfoBlocklore.add(ChatColor.GRAY + "The kit Witch Costs: 5000");
		} else if (Kits.Fisherman.contains(player.toString())) {
			InfoBlocklore.add(ChatColor.GRAY + "The kit Fisherman Costs: 4000");
		} else if (Kits.Lumberjack.contains(player.toString())) {
			InfoBlocklore.add(ChatColor.GRAY + "The kit Lumberjack Costs: 3500");
		} else if (Kits.Tank.contains(player.toString())) {
			InfoBlocklore.add(ChatColor.GRAY + "The kit Tank Costs: 3500");
		}
		InfoBlocklore.add(ChatColor.GRAY + "");
		InfoBlockMeta.setLore(InfoBlocklore);
		InfoBlock.setItemMeta(InfoBlockMeta);

		in.setItem(11, ConfirmBlock);
		in.setItem(13, InfoBlock);
		in.setItem(15, CancelBlock);

		player.openInventory(in);
	}

	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {
		if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Buy this kit"))
			return;
		Player player = (Player) e.getWhoClicked();
		e.setCancelled(true);

		switch (e.getCurrentItem().getType()) {
		case EMERALD_BLOCK:
			double Balance = (Main.getEcononomy().getBalance(player));
			if (Kits.Vampire.contains(player.toString())) {
				if (Balance >= 3500) {
					Main.getEcononomy().withdrawPlayer(player, 3500);
					Main.getPermissions().playerAdd(player, "Kitpvp.kit.Vampire");
					player.sendMessage(ChatColor.AQUA + "You have bought kit Vampire");
				} else if (Balance < 3500) {
					player.sendMessage(chat.prefix + ChatColor.RED + "You dont have enough money to buy this kit");
				}
			} else if (Kits.Archer.contains(player.toString())) {
				if (Balance >= 4500) {
					Main.getEcononomy().withdrawPlayer(player, 4500);
					Main.getPermissions().playerAdd(player, "Kitpvp.kit.Archer");
					player.sendMessage(ChatColor.AQUA + "You have bought kit Archer");
				} else if (Balance < 4500) {
					player.sendMessage(chat.prefix + ChatColor.RED + "You dont have enough money to buy this kit");
				}
			} else if (Kits.Swordsman.contains(player.toString())) {
				if (Balance >= 6000) {
					Main.getEcononomy().withdrawPlayer(player, 6000);
					Main.getPermissions().playerAdd(player, "Kitpvp.kit.Swordsman");
					player.sendMessage(ChatColor.AQUA + "You have bought kit Swordsman");
				} else if (Balance < 6000) {
					player.sendMessage(chat.prefix + ChatColor.RED + "You dont have enough money to buy this kit");
				}
			} else if (Kits.Pyro.contains(player.toString())) {
				if (Balance >= 6500) {
					Main.getEcononomy().withdrawPlayer(player, 6500);
					Main.getPermissions().playerAdd(player, "Kitpvp.kit.Pyro");
					player.sendMessage(ChatColor.AQUA + "You have bought kit Pyro");
				} else if (Balance < 6500) {
					player.sendMessage(chat.prefix + chat.prefix + ChatColor.RED + "You dont have enough money to buy this kit");
				}
			} else if (Kits.Witch.contains(player.toString())) {
				if (Balance >= 5000) {
					Main.getEcononomy().withdrawPlayer(player, 5000);
					Main.getPermissions().playerAdd(player, "Kitpvp.kit.Witch");
					player.sendMessage(ChatColor.AQUA + "You have bought kit Witch");
				} else if (Balance < 5000) {
					player.sendMessage(chat.prefix + ChatColor.RED + "You dont have enough money to buy this kit");
				}
			} else if (Kits.Fisherman.contains(player.toString())) {
				if (Balance >= 4000) {
					Main.getEcononomy().withdrawPlayer(player, 4000);
					Main.getPermissions().playerAdd(player, "Kitpvp.kit.Fisherman");
					player.sendMessage(ChatColor.AQUA + "You have bought kit Fisherman");
				} else if (Balance < 4000) {
					player.sendMessage(chat.prefix + ChatColor.RED + "You dont have enough money to buy this kit");
				}
			} else if (Kits.Lumberjack.contains(player.toString())) {
				if (Balance >= 2000) {
					Main.getEcononomy().withdrawPlayer(player, 3500);
					Main.getPermissions().playerAdd(player, "Kitpvp.kit.Lumberjack");
					player.sendMessage(ChatColor.AQUA + "You have bought kit Lumberjack");
				} else if (Balance < 2000) {
					player.sendMessage(chat.prefix + ChatColor.RED + "You dont have enough money to buy this kit");
				}
			} else if (Kits.Tank.contains(player.toString())) {
				if (Balance >= 3500) {
					Main.getEcononomy().withdrawPlayer(player, 3500);
					Main.getPermissions().playerAdd(player, "Kitpvp.kit.Tank");
					player.sendMessage(ChatColor.AQUA + "You have bought kit Tank");
				} else if (Balance < 3500) {
					player.sendMessage(chat.prefix + ChatColor.RED + "You dont have enough money to buy this kit");
				}
			}
			Kits.Archer.remove(player);
			Kits.Vampire.remove(player);
			Kits.Swordsman.remove(player);
			Kits.Pyro.remove(player);
			Kits.Witch.remove(player);
			Kits.Fisherman.remove(player);
			Kits.Lumberjack.remove(player);
			Kits.Tank.remove(player);
			player.closeInventory();
			break;
		case REDSTONE_BLOCK:
			Kits.openGUI(player);
			break;
		case SIGN:
			break;
		default:
			break;
		}
	}
}
