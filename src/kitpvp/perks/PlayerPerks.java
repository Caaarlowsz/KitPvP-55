package kitpvp.perks;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import kitpvp.data.CurrencyKitPvP;

public class PlayerPerks implements Listener {

	public static void perks(Player player) {

		int perkLevelHealing = PlayerPerks.getPerkLevel(player, "Healing");
		if (perkLevelHealing <= 3 && perkLevelHealing > 0) {
			PotionEffect Healing = new PotionEffect(PotionEffectType.REGENERATION, perkLevelHealing * 50, 1, true, false);
			player.addPotionEffect(Healing);
		
		} else if (perkLevelHealing >= 4 && perkLevelHealing <= 5) {
			PotionEffect Healing = new PotionEffect(PotionEffectType.REGENERATION, perkLevelHealing * 20, 2, true, false);
			player.addPotionEffect(Healing);
		}

		int perkLevelSpeed = PlayerPerks.getPerkLevel(player, "Speed");
		if (perkLevelSpeed <= 3 && perkLevelSpeed > 0) {
			PotionEffect Speed = new PotionEffect(PotionEffectType.SPEED, perkLevelSpeed * 40, 1, true, false);
			player.addPotionEffect(Speed);
		}
		
		int perkLevelAbsorption = PlayerPerks.getPerkLevel(player, "Absorption");
		if (perkLevelAbsorption <= 3 && perkLevelAbsorption > 0) {
			PotionEffect Absorption = new PotionEffect(PotionEffectType.ABSORPTION, perkLevelAbsorption * 50, 1, true, false);
			player.addPotionEffect(Absorption);

		} else if (perkLevelAbsorption == 4 || perkLevelAbsorption == 5) {
			PotionEffect Absorption = new PotionEffect(PotionEffectType.ABSORPTION, perkLevelAbsorption* 20, 2, true, false);
			player.addPotionEffect(Absorption);
		}
	}
	
	// kansen op golden appels perk!!

	public static int getPerkLevel(Player player, String perk) {
		String playerUUID = player.getUniqueId().toString();
		int level = CurrencyKitPvP.getDataInt((playerUUID + ".Perks." + perk));
		return level;
	}
}
