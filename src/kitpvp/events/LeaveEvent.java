package kitpvp.events;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {

	public void PlayerLeaveEvent(PlayerQuitEvent e) {
		e.setQuitMessage(null);
	}

}
