package me.zax71.svl;

import me.zax71.svl.events.vote;
import org.bukkit.plugin.java.JavaPlugin;

public final class SVL extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new vote(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
