package com.expectale.customserverlinks.serverlinks.link;

import java.net.URI;

public abstract class AbstractServerLink {
    
    private final URI url;
    
    AbstractServerLink(URI url) {
        this.url = url;
    }
    
    public URI getUrl() {
        return url;
    }
    
}
