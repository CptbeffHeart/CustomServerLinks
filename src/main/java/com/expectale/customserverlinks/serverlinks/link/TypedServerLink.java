package com.expectale.customserverlinks.serverlinks.link;

import org.bukkit.ServerLinks;

import java.net.URI;

public class TypedServerLink extends AbstractServerLink {
    
    private final ServerLinks.Type type;
    
    public TypedServerLink(ServerLinks.Type type, URI url) {
        super(url);
        this.type = type;
    }
    
    public ServerLinks.Type getType() {
        return type;
    }
    
}
