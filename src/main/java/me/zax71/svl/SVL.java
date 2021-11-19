package me.zax71.svl;

import me.zax71.svl.events.vote;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class SVL extends JavaPlugin {

    public static SVL plugin;

    @Override
    public void onEnable() {
        // Config
        plugin = this;
        saveDefaultConfig();
        FileConfiguration config = getConfig();

        // Register vote class
        this.getServer().getPluginManager().registerEvents(new vote(), this);

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
            getLogger().warning("PlaceholderAPI not found. This is recommended for the use of this plugin, download it at: https://www.spigotmc.org/resources/placeholderapi.6245");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
