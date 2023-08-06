package me.arttostog.autopressf;

import me.arttostog.autopressf.event.Event;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class AutoPressF extends JavaPlugin {
    public static String prefix;

    @Override
    public void onEnable() {
        FileConfiguration config = this.getConfig();
        config.addDefault("Prefix", "[&aAPF&r]");
        config.options().copyDefaults(true);
        saveConfig();

        prefix = config.getString("Prefix") == null ? "[§aAPF§r]": Objects.requireNonNull(config.getString("Prefix")).replaceAll("&", "§");

        Bukkit.getServer().getPluginManager().registerEvents(new Event(), this);

        this.getLogger().info("§aAPF successfully enabled!");
    }
}