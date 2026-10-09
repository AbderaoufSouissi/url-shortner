package com.ars.shortener.dto;

import jakarta.validation.constraints.NotBlank;

public record ShortenUrlRequestDto(
        String shortCode,
        @NotBlank
        String url
)
{}
