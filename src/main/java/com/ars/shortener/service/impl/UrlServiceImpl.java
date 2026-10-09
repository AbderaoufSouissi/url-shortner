package com.ars.shortener.service.impl;

import com.ars.shortener.dto.ShortenUrlRequestDto;
import com.ars.shortener.dto.ShortenUrlResponseDto;
import com.ars.shortener.entity.UrlEntity;
import com.ars.shortener.repository.UrlRepository;
import com.ars.shortener.service.UrlService;
import com.ars.shortener.utils.UrlUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {
	private final UrlRepository urlRepository;
	private final UrlUtils urlUtils;

	@Override
	public ShortenUrlResponseDto shortenUrl(final ShortenUrlRequestDto request) {
		if (!urlUtils.isValid(request.url())) {
			throw new IllegalArgumentException("URL must be an absolute HTTP or HTTPS URL");
		}

		String shortCode = RandomStringUtils.randomAlphanumeric(6);
		while (urlRepository.existsByShortCode(shortCode)) {
			shortCode = RandomStringUtils.randomAlphanumeric(6);
		}

		var urlEntity = UrlEntity.builder()
				.mainUrl(request.url())
				.shortCode(shortCode)
				.build();
		urlRepository.save(urlEntity);

		return new ShortenUrlResponseDto(urlEntity.getShortCode());
	}

	@Override
	public URI getRedirectionUri(String shortCode) {
		String url = urlRepository.findByShortCode(shortCode)
				.map(UrlEntity::getMainUrl)
				.orElseThrow(() -> new NoSuchElementException("Short code not found"));

		return URI.create(url);
	}
}
