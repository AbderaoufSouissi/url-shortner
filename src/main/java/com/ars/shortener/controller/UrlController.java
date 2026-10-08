package com.ars.shortener.controller;

import com.ars.shortener.dto.ShortenUrlRequestDto;
import com.ars.shortener.dto.ShortenUrlResponseDto;
import com.ars.shortener.service.UrlService;
import com.ars.shortener.service.impl.UrlServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UrlController {

	private final UrlService urlService;


	@PostMapping("/shorten")
	public ShortenUrlResponseDto shortenUrl(@RequestBody ShortenUrlRequestDto request) {

		return urlService.shortenUrl(request);
	}
}
