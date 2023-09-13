package me.arttostog.autopressf;

import me.arttostog.autopressf.event.Event;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class AutoPressF extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(new Event(configInit()), this);
        this.getLogger().info("§aAPF successfully enabled!");
    }

    private String configInit() {
        FileConfiguration config = this.getConfig();
        config.addDefault("Prefix", "[&aAPF&r]");
        config.options().copyDefaults(true);
        saveConfig();

        return config.getString("Prefix") == null
                ? "[§aAPF§r]": config.getString("Prefix")
                .replaceAll("&", "§");
    }
}