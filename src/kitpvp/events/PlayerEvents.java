package kitpvp.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import kitpvp.data.ConfigYML;

public class PlayerEvents implements Listener {

	public static String color(String msg) {
		String coloredMsg = "";
		for (int i = 0; i < msg.length(); i++) {
			if (msg.charAt(i) == '&')
				coloredMsg += '§';
			else
				coloredMsg += msg.charAt(i);
		}
		return coloredMsg;
	}

	@EventHandler
	public void foodLoss(FoodLevelChangeEvent e) {
		if (e.getFoodLevel() < 20) {
			e.setFoodLevel(20);
		}
	}

	@EventHandler
	public void ItemDropEvent(PlayerDropItemEvent e) {
		if (ConfigYML.getDataBoolean("Allow ItemDrop") == false) {
			if (!(e.getItemDrop().getItemStack().getType() == null)) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void BlockPlaceEvent(BlockPlaceEvent e) {		
		if(!e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) e.setCancelled(true);
	}

	public void breakPreventEvent(BlockBreakEvent e) {
		if (ConfigYML.getDataBoolean("Allow Block Breaking") == false) {
			Player player = e.getPlayer();
			if (e.getBlock().getType() != Material.AIR) {
				if (player.getGameMode() == GameMode.SURVIVAL) {
					e.setCancelled(true);
				}
			}
		}
	}

	public void onPickupEvent(PlayerPickupItemEvent e) {
		if (ConfigYML.getDataBoolean("Allow Item Pick-up") == false) {
			if (e.getItem() != new ItemStack(Material.AIR)) {
				if (e.getItem().getType() != null) {
					e.setCancelled(true);
				}
			}
		}
	}

	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent PlayerRespawnEvent) {
		Player player = PlayerRespawnEvent.getPlayer();
		PlayerRespawnEvent.getPlayer().getInventory().clear();
		PlayerRespawnEvent.getPlayer().getEquipment().clear();
		ItemStack GoldSword = new ItemStack(Material.GOLD_SWORD, 1);
		ItemMeta GoldSwordMeta = GoldSword.getItemMeta();
		GoldSwordMeta.setDisplayName(color("&6§l>>§r&3 Kit Selector &6§l<<"));
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
		PlayerRespawnEvent.getPlayer().setFireTicks(0);
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		// Only handle clicks by players
		if (!(event.getWhoClicked() instanceof Player)) {
			return;
		}
		// If the player has permission to modify there is no need for checks

		if (event.isShiftClick()) {
			// If shift clicking outside of player inventory the item would not
			// move to an armor slot
			if (event.getClickedInventory().getType() != InventoryType.PLAYER) {
				return;
			}

			// Check if the item would move to or out of an armor slot
			ItemStack item = event.getCurrentItem();
			if (item != null && item.getType() != Material.AIR) {
				if (item.getType().equals(Material.IRON_HELMET) || item.getType().equals(Material.IRON_CHESTPLATE)
						|| item.getType().equals(Material.IRON_LEGGINGS) || item.getType().equals(Material.IRON_BOOTS)
						|| item.getType().equals(Material.LEATHER_HELMET)
						|| item.getType().equals(Material.LEATHER_CHESTPLATE)
						|| item.getType().equals(Material.LEATHER_LEGGINGS)
						|| item.getType().equals(Material.LEATHER_BOOTS)
						|| item.getType().equals(Material.DIAMOND_HELMET)
						|| item.getType().equals(Material.DIAMOND_CHESTPLATE)
						|| item.getType().equals(Material.DIAMOND_LEGGINGS)
						|| item.getType().equals(Material.DIAMOND_BOOTS) || item.getType().equals(Material.GOLD_HELMET)
						|| item.getType().equals(Material.GOLD_CHESTPLATE)
						|| item.getType().equals(Material.GOLD_LEGGINGS) || item.getType().equals(Material.GOLD_BOOTS)
						|| item.getType().equals(Material.CHAINMAIL_HELMET)
						|| item.getType().equals(Material.CHAINMAIL_CHESTPLATE)
						|| item.getType().equals(Material.CHAINMAIL_LEGGINGS)
						|| item.getType().equals(Material.CHAINMAIL_BOOTS)) {
					event.setCancelled(true);
				}
			}
		} else if (event.getSlotType() == InventoryType.SlotType.ARMOR) {
			// Player directly clicked on an armor slot
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onInventoryDrag(InventoryDragEvent event) {
		// Only handle drags by players
		if (!(event.getWhoClicked() instanceof Player)) {
			return;
		}
		// If the player has permission to modify there is no need for checks

		ItemStack item = event.getOldCursor();
		if (item != null && item.getType() != Material.AIR) {

			if (item.getType().equals(Material.IRON_HELMET) || item.getType().equals(Material.IRON_CHESTPLATE)
					|| item.getType().equals(Material.IRON_LEGGINGS) || item.getType().equals(Material.IRON_BOOTS)
					|| item.getType().equals(Material.LEATHER_HELMET)
					|| item.getType().equals(Material.LEATHER_CHESTPLATE)
					|| item.getType().equals(Material.LEATHER_LEGGINGS) || item.getType().equals(Material.LEATHER_BOOTS)
					|| item.getType().equals(Material.DIAMOND_HELMET)
					|| item.getType().equals(Material.DIAMOND_CHESTPLATE)
					|| item.getType().equals(Material.DIAMOND_LEGGINGS) || item.getType().equals(Material.DIAMOND_BOOTS)
					|| item.getType().equals(Material.GOLD_HELMET) || item.getType().equals(Material.GOLD_CHESTPLATE)
					|| item.getType().equals(Material.GOLD_LEGGINGS) || item.getType().equals(Material.GOLD_BOOTS)
					|| item.getType().equals(Material.CHAINMAIL_HELMET)
					|| item.getType().equals(Material.CHAINMAIL_CHESTPLATE)
					|| item.getType().equals(Material.CHAINMAIL_LEGGINGS)
					|| item.getType().equals(Material.CHAINMAIL_BOOTS)) {
				event.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			ItemStack item = event.getItem();
			if (item == null || item.getType() == Material.AIR) {
				return;
			}
			if (item.getType().equals(Material.IRON_HELMET) || item.getType().equals(Material.IRON_CHESTPLATE)
					|| item.getType().equals(Material.IRON_LEGGINGS) || item.getType().equals(Material.IRON_BOOTS)
					|| item.getType().equals(Material.LEATHER_HELMET)
					|| item.getType().equals(Material.LEATHER_CHESTPLATE)
					|| item.getType().equals(Material.LEATHER_LEGGINGS) || item.getType().equals(Material.LEATHER_BOOTS)
					|| item.getType().equals(Material.DIAMOND_HELMET)
					|| item.getType().equals(Material.DIAMOND_CHESTPLATE)
					|| item.getType().equals(Material.DIAMOND_LEGGINGS) || item.getType().equals(Material.DIAMOND_BOOTS)
					|| item.getType().equals(Material.GOLD_HELMET) || item.getType().equals(Material.GOLD_CHESTPLATE)
					|| item.getType().equals(Material.GOLD_LEGGINGS) || item.getType().equals(Material.GOLD_BOOTS)
					|| item.getType().equals(Material.CHAINMAIL_HELMET)
					|| item.getType().equals(Material.CHAINMAIL_CHESTPLATE)
					|| item.getType().equals(Material.CHAINMAIL_LEGGINGS)
					|| item.getType().equals(Material.CHAINMAIL_BOOTS)) {
				event.setCancelled(true);
			}

			if (item.getType().equals(Material.REDSTONE)
					&& item.getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Blood")) {
				player.getInventory().remove(Material.REDSTONE);
				player.setHealth(player.getHealth() + 2);
			}
		}
	}
}
