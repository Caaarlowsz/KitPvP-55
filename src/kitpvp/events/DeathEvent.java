package kitpvp.events;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import kitpvp.Kits.Kits;
import kitpvp.data.ConfigYML;
import kitpvp.data.CurrencyKitPvP;
import kitpvp.Main;
import kitpvp.perks.PlayerPerks;

public class DeathEvent implements Listener {

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent PlayerDeathEvent) {
		Player player = (Player) PlayerDeathEvent.getEntity();
		String playerstring = PlayerDeathEvent.getEntity().toString();
		Player killer = (Player) PlayerDeathEvent.getEntity().getKiller();
		String killerstring = killer.toString();
		PlayerPerks.perks(killer);
		player.getEquipment().setHelmet(new ItemStack(Material.AIR));
		player.getEquipment().setChestplate(new ItemStack(Material.AIR));
		player.getEquipment().setLeggings(new ItemStack(Material.AIR));
		player.getEquipment().setBoots(new ItemStack(Material.AIR));
		player.updateInventory();
		player.getInventory().clear();
		PlayerDeathEvent.getDrops().clear();
		PlayerDeathEvent.setKeepInventory(true);
		if (killer instanceof Player) {
			// player death
			if (player.isDead()) {
				UUID uuiddead = player.getUniqueId();
				UUID uuidkiller = killer.getUniqueId();
				CurrencyKitPvP.setData(uuiddead + ".Deaths", (CurrencyKitPvP.getDataInt(uuiddead + ".Deaths") + 1));
				CurrencyKitPvP.setData(uuidkiller + ".Kills", (CurrencyKitPvP.getDataInt(uuiddead + ".Kills") + 1));
				if (Kits.VampireBlood.contains(killerstring)) {
					if (!killer.getInventory().contains(Material.REDSTONE)) {
						ItemStack Blood = new ItemStack(Material.REDSTONE, 1);
						ItemMeta BloodMeta = Blood.getItemMeta();
						BloodMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Blood");
						List<String> Bloodlore = new ArrayList<String>();
						Bloodlore.add(ChatColor.LIGHT_PURPLE + "Consume this to regain some health");
						Bloodlore.add(ChatColor.GRAY + "");
						BloodMeta.setLore(Bloodlore);
						Blood.setItemMeta(BloodMeta);
						killer.getInventory().addItem(new ItemStack(Blood));
					}
				}
				if ((player.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.PROJECTILE)
						&& PlayerDeathEvent.getDeathMessage().contains("was shot by")) {
					PlayerDeathEvent.setDeathMessage(
							PlayerEvents.color("&6" + player.getName() + " &awas sniped by " + "&6" + killer.getName()));
				} else if (PlayerDeathEvent.getDeathMessage().contains("was killed by")
						|| PlayerDeathEvent.getDeathMessage().contains("was slain by")) {
					PlayerDeathEvent.setDeathMessage(
							PlayerEvents.color("&6" + player.getName() + " &awas struck down by &6" + killer.getName()));
				}else if(PlayerDeathEvent.getDeathMessage().contains("was burnt to a crisp whilst fighting ")){
					PlayerDeathEvent.setDeathMessage(
							PlayerEvents.color("&6" + player.getName() + " &awas incinerated by &6" + killer.getName()));
				} else if (player.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
					double Balance = (Main.getEcononomy().getBalance(player));
					Main.getEcononomy().depositPlayer(killer, ConfigYML.getDataInt("Coins.Recieved upon kill"));
					if (Balance >= 10) {
						Main.getEcononomy().withdrawPlayer(player, ConfigYML.getDataInt("Coins.Recieved upon death"));
					}
					// player kill
				}
			}
		}
		Kits.VampireBlood.remove(playerstring);
		Kits.Archer.remove(player);
		Kits.Vampire.remove(player);
		Kits.Swordsman.remove(player);
		Kits.Pyro.remove(player);
		Kits.Witch.remove(player);
		Kits.Fisherman.remove(player);
		Kits.Lumberjack.remove(player);
		Kits.Tank.remove(player);
	}

}
