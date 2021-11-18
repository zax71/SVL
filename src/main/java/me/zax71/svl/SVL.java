package me.zax71.svl;

import me.zax71.svl.events.vote;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class SVL extends JavaPlugin {

    FileConfiguration config = this.getConfig();
    @Override
    public void onEnable() {
        // Config
        saveDefaultConfig();

        // Register vote class
        this.getServer().getPluginManager().registerEvents(new vote(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
