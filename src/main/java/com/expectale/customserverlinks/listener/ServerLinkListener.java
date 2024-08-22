package com.expectale.customserverlinks.listener;

import com.expectale.customserverlinks.serverlinks.ServerLinkManager;
import com.expectale.customserverlinks.serverlinks.link.NamedServerLink;
import com.expectale.customserverlinks.serverlinks.link.TypedServerLink;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLinksSendEvent;

public class ServerLinkListener implements Listener {
    
    @EventHandler
    public void onServerLinksSend(PlayerLinksSendEvent event) {
        ServerLinkManager.getLinks()
            .forEach(link -> {
                if (link instanceof TypedServerLink typedLink) {
                    event.getLinks().addLink(typedLink.getType(), typedLink.getUrl());
                } else if (link instanceof NamedServerLink namedLink) {
                    event.getLinks().addLink(namedLink.name(), namedLink.getUrl());
                }
            });
        
    }
    
}
