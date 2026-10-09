package com.ars.shortener.utils;

import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class UrlUtils {

    public boolean isValid(String url) {
        try {
            URI uri = URI.create(url);
            return ("http".equalsIgnoreCase(uri.getScheme())
                    || "https".equalsIgnoreCase(uri.getScheme()))
                    && uri.getHost() != null;
        } catch (Exception e) {
            return false;
        }
    }
}
