package com.ars.shortener.service.impl;

import com.ars.shortener.entity.UrlEntity;
import com.ars.shortener.repository.UrlRepository;
import com.ars.shortener.service.UrlService;
import com.ars.shortener.utils.UrlUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {
	private final UrlRepository urlRepository;
	private final UrlUtils urlUtils;

	@Override
	public String shortenUrl(String url) {
		boolean isValid = urlUtils.isValid(url);
		if(!isValid){
			throw new RuntimeException("URL is invalid ");
		}
		String shortCode = "TODO";
		var urlEntity = UrlEntity.builder()
				.mainUrl(url)
				.shortCode(shortCode)
				.build();

		urlRepository.save(urlEntity);

		return shortCode;
	}


}
