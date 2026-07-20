package com.turkcell.capability_service.infrastructure.client;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Component
public class StoreServiceClient {

	private static final Logger log = LoggerFactory.getLogger(StoreServiceClient.class);

	private final RestClient restClient;

	public StoreServiceClient(
			RestClient.Builder restClientBuilder,
			@Value("${store-service.base-url:http://localhost:8081}") String baseUrl,
			@Value("${store-service.connect-timeout-ms:2000}") int connectTimeoutMs,
			@Value("${store-service.read-timeout-ms:3000}") int readTimeoutMs) {
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		requestFactory.setConnectTimeout(connectTimeoutMs);
		requestFactory.setReadTimeout(readTimeoutMs);
		this.restClient = restClientBuilder
				.baseUrl(baseUrl)
				.requestFactory(requestFactory)
				.build();
	}

	/**
	 * Bulk fetch via GET /stores?ids=1,2,3 (Day 9 contract).
	 */
	public List<StoreDto> getStoresByIds(List<Long> ids) {
		if (ids == null || ids.isEmpty()) {
			return List.of();
		}
		String idsParam = ids.stream().map(String::valueOf).collect(Collectors.joining(","));
		try {
			StoreDto[] body = restClient.get()
					.uri(uriBuilder -> uriBuilder.path("/stores").queryParam("ids", idsParam).build())
					.retrieve()
					.body(StoreDto[].class);
			return body == null ? List.of() : Arrays.asList(body);
		} catch (RestClientException ex) {
			log.error("store-service call failed for ids={}: {}", idsParam, ex.getMessage());
			throw new StoreServiceUnavailableException("store-service erişilemedi: " + ex.getMessage(), ex);
		}
	}
}
