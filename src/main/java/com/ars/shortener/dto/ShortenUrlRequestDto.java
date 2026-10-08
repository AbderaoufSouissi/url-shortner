package com.ars.shortener.dto;

public record ShortenUrlRequestDto(
        String shortCode,
        String url
)
{}
