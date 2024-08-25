package com.expectale.customserverlinks;

import com.expectale.customserverlinks.command.ServerLinksReloadCommand;
import com.expectale.customserverlinks.serverlinks.ServerLinkManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class CustomServerLinks extends JavaPlugin {

    public static CustomServerLinks INSTANCE;
    public static Logger LOGGER;
    
    @Override
    public void onEnable() {
        INSTANCE = this;
        LOGGER = getLogger();
        
        saveDefaultConfig();
        getCommand("customserverlinks").setExecutor(new ServerLinksReloadCommand());
        ServerLinkManager.reloadLinks();
        
        LOGGER.info("CustomServerLinks enabled");
    }

    @Override
    public void onDisable() {
        LOGGER.info("Disabling CustomServerLinks");
    }
}
