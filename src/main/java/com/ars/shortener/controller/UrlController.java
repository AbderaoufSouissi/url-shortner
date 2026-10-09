package com.ars.shortener.controller;

import com.ars.shortener.dto.ShortenUrlRequestDto;
import com.ars.shortener.dto.ShortenUrlResponseDto;
import com.ars.shortener.service.UrlService;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UrlController {

	private final UrlService urlService;


	@PostMapping("/shorten")
	@Operation(summary = "Create a short URL")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Short URL created"),
			@ApiResponse(responseCode = "400", description = "The URL is invalid")
	})
	public ResponseEntity<ShortenUrlResponseDto> shortenUrl(@Valid @RequestBody ShortenUrlRequestDto request) {
		return new ResponseEntity<>(urlService.shortenUrl(request), HttpStatus.OK);
	}

	@GetMapping("/{shorten}")
	@Operation(summary = "Redirect to the original URL")
	@ApiResponses({
			@ApiResponse(responseCode = "301", description = "Redirect to the original URL"),
			@ApiResponse(responseCode = "404", description = "Short code not found")
	})
	public ResponseEntity<Void> getRedirectionUrl(@PathVariable String shorten) {
		return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY.value())
				.location(urlService.getRedirectionUri(shorten))
				.build();
	}

}
