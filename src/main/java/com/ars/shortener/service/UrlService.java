package com.ars.shortener.service;

import com.ars.shortener.dto.ShortenUrlRequestDto;
import com.ars.shortener.dto.ShortenUrlResponseDto;

import java.net.URI;

public interface UrlService {
    ShortenUrlResponseDto shortenUrl(ShortenUrlRequestDto request);

    URI getRedirectionUri(String shortCode);
}
