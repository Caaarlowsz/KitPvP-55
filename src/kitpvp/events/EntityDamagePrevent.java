package kitpvp.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.inventory.ItemStack;

public class EntityDamagePrevent implements Listener {

	@EventHandler
	public void noWeaponBreakDamage( EntityShootBowEvent event){
	    // Bow
	    if( event.getEntity() instanceof Player )
	        event.getBow().setDurability((short) 0);
	}
	@EventHandler
	public void noWeaponBreakDamage( PlayerItemBreakEvent event){
	    ItemStack item = event.getBrokenItem().clone();
	    item.setDurability((short) 100);
	    event.getPlayer().getInventory().addItem(item);
	}
}
