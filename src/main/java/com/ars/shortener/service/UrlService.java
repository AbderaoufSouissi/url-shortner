package com.ars.shortener.service;

import com.ars.shortener.dto.ShortenUrlRequestDto;
import com.ars.shortener.dto.ShortenUrlResponseDto;

public interface UrlService {
    ShortenUrlResponseDto shortenUrl(ShortenUrlRequestDto request);
}
