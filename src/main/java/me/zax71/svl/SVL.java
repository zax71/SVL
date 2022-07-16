package me.zax71.svl;

import co.aikar.commands.PaperCommandManager;
import me.zax71.svl.commands.SVLCommand;
import me.zax71.svl.events.vote;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class SVL extends JavaPlugin {

    public static SVL plugin;
    public String prefix = ChatColor.GOLD + "[" + ChatColor.GRAY + "SVL" + ChatColor.GOLD + "] ";


    @Override
    public void onEnable() {

        // Config
        plugin = this;
        saveDefaultConfig();
        FileConfiguration config = getConfig();

        // Bstats
        int pluginId = 15800; // <-- Replace with the id of your plugin!
        Metrics metrics = new Metrics(this, pluginId);

        // Register vote class
        this.getServer().getPluginManager().registerEvents(new vote(), this);

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
            getLogger().warning("PlaceholderAPI is required for this plugin, download it at: https://www.spigotmc.org/resources/placeholderapi.6245");
        }
        // Register commands
        PaperCommandManager commandManager = new PaperCommandManager(this);
        commandManager.registerCommand(new SVLCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
