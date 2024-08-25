package com.expectale.customserverlinks.serverlinks;

import com.expectale.customserverlinks.CustomServerLinks;
import org.bukkit.Bukkit;
import org.bukkit.ServerLinks;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

public class ServerLinkManager {
    
    public static void reloadLinks() {
        CustomServerLinks instance = CustomServerLinks.INSTANCE;
        clearServerLinks();
        instance.reloadConfig();
        FileConfiguration config = instance.getConfig();
        for (String key : config.getKeys(false)) {
            
            ConfigurationSection section = config.getConfigurationSection(key);
            if (section == null) {
                CustomServerLinks.LOGGER.warning("Could not load link for: " + key);
                continue;
            }
            String name = section.getString("name");
            String type = section.getString("type");
            String link = section.getString("link");
            
            if (link == null) {
                CustomServerLinks.LOGGER.warning("Could not load link for: " + key);
                continue;
            }
            
            URI url;
            try {
                url = new URI(link);
            } catch (URISyntaxException e) {
                CustomServerLinks.LOGGER.warning("Could not load link for: " + key);
                continue;
            }
            
            ServerLinks serverLinks = instance.getServer().getServerLinks();
            if (type != null && isValidType(type)) {
                serverLinks.addLink(ServerLinks.Type.valueOf(type.toUpperCase()), url);
            } else if (name != null) {
                serverLinks.addLink(name.replace("&", "§"), url);
            } else {
                CustomServerLinks.LOGGER.warning("Could not load link for: " + key);
            }
            
        }
        
        Bukkit.getOnlinePlayers().forEach(player -> player.sendLinks(instance.getLinks()));
        
    }
    
    public static boolean isValidType(String value) {
        return Arrays.stream(ServerLinks.Type.values())
            .map(Enum::name)
            .anyMatch(enumName -> enumName.equalsIgnoreCase(value.toUpperCase()));
    }
    
    public static void clearServerLinks() {
        ServerLinks serverLinks = CustomServerLinks.INSTANCE.getServer().getServerLinks();
        serverLinks.getLinks().forEach(serverLinks::removeLink);
    }
}
