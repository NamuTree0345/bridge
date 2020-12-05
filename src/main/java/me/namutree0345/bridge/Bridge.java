package me.namutree0345.bridge;

import org.bukkit.plugin.java.JavaPlugin;

public final class Bridge extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Interact(), this);
    }
}
