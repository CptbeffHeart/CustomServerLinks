package com.expectale.customserverlinks.serverlinks;

import com.expectale.customserverlinks.CustomServerLinks;
import com.expectale.customserverlinks.serverlinks.link.AbstractServerLink;
import com.expectale.customserverlinks.serverlinks.link.NamedServerLink;
import com.expectale.customserverlinks.serverlinks.link.TypedServerLink;
import org.bukkit.ServerLinks;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServerLinkManager {
    
    private static final List<AbstractServerLink> LINKS = new ArrayList<>();
    
    public static void addLink(AbstractServerLink link) {
        LINKS.add(link);
    }
    
    public static List<AbstractServerLink> getLinks() {
        return new ArrayList<>(LINKS);
    }
    
    public static void reloadLinks() {
        FileConfiguration config = CustomServerLinks.INSTANCE.getConfig();
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
            
            if (type != null && isValidType(type)) {
                addLink(new TypedServerLink(ServerLinks.Type.valueOf(type.toUpperCase()), url));
            } else if (name != null) {
                addLink(new NamedServerLink(name, url));
            } else {
                CustomServerLinks.LOGGER.warning("Could not load link for: " + key);
            }
            
        }
        
    }
    
    public static boolean isValidType(String value) {
        return Arrays.stream(ServerLinks.Type.values())
            .map(Enum::name)
            .anyMatch(enumName -> enumName.equalsIgnoreCase(value.toUpperCase()));
    }
}
