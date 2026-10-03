package com.ars.shortener.controller;

import com.ars.shortener.service.UrlService;
import com.ars.shortener.service.impl.UrlServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UrlController {

	private final UrlService urlService;


	@PostMapping("/shorten")
	public String shortenUrl(@RequestParam String url) {

		return urlService.shortenUrl(url);
	}
}
