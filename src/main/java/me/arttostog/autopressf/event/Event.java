package me.arttostog.autopressf.event;

import me.arttostog.autopressf.AutoPressF;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Event implements Listener {
	@EventHandler(priority = EventPriority.LOWEST)
	public void OnDeath(PlayerDeathEvent event) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(AutoPressF.getPlugin(AutoPressF.class), () -> {
			for (Player player: Bukkit.getOnlinePlayers()) {
				player.sendMessage(AutoPressF.prefix + " F");
			}
		}, 5L);
	}
}
