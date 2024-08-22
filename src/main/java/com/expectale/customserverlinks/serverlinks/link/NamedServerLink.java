package com.expectale.customserverlinks.serverlinks.link;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;

import java.net.URI;

public class NamedServerLink extends AbstractServerLink {
    
    private final String name;
    
    public NamedServerLink(String name, URI url) {
        super(url);
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public TextComponent name() {
        return Component.text(name);
    }
    
}
