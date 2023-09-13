package me.arttostog.autopressf.event;

import me.arttostog.autopressf.AutoPressF;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Event implements Listener {
	private final String message;

	public Event(String prefix) {
		message = new StringBuilder(prefix)
				.append(" F")
				.toString();
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onDeath(PlayerDeathEvent event) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(AutoPressF.getPlugin(AutoPressF.class), () -> {
			for (Player player: Bukkit.getOnlinePlayers())
				player.sendMessage(message);
		}, 5L);
	}
}
