package kitpvp.events;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import kitpvp.Main;

public class ProjectileThrowEvent implements Listener {

	public void onProjectileThrownEvent(ProjectileLaunchEvent e) {
		Player p = (Player) e.getEntity().getShooter();
	    if ((p instanceof Player) && 
	      (e.getEntity() instanceof Arrow) || (e.getEntity() instanceof Egg) || (e.getEntity() instanceof Snowball)) {
	      Main.Projectile.add(e.getEntity());
	    }
	}
}