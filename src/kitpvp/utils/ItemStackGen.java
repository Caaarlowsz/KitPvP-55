package kitpvp.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.ChatColor;

public class ItemStackGen {

	public static ItemStack ItemStackGen(Material material, String displayName, int amount) {
		ItemStack item = new ItemStack(material);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayName));
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack ItemStackGenGlass(Material material, String displayName, int type, int amount) {
		ItemStack item = new ItemStack(material, (short) type);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayName);
		item.setItemMeta(meta);
		return item;
	}

}
