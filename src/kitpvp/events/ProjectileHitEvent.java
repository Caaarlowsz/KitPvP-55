package kitpvp.events;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ProjectileHitEvent implements Listener {

	@EventHandler
    public void onHit(org.bukkit.event.entity.ProjectileHitEvent event) {
        Entity entity = event.getEntity();
        entity.remove();        
    }

}
