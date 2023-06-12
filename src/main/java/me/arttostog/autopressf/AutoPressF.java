package me.arttostog.autopressf;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class AutoPressF extends JavaPlugin implements Listener {
    private static String prefix;

    @Override
    public void onEnable() {
        FileConfiguration config = this.getConfig();
        config.addDefault("Prefix", "[&aAPF&r]");
        config.options().copyDefaults(true);
        saveConfig();

        prefix = config.getString("Prefix");
        if (prefix != null) {
            prefix = prefix.replaceAll("&", "§");
        } else {
            prefix = "[§aAPF§r]";
        }

        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        this.getLogger().info("§aAPF successfully enabled!");
    }

    @EventHandler (priority = EventPriority.LOWEST)
    public void OnDeath(PlayerDeathEvent event) {
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, () -> {
            for (Player player: Bukkit.getOnlinePlayers()) {
                player.sendMessage(prefix + " F");
            }
        }, 5L);
    }
}
