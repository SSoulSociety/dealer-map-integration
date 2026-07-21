package com.turkcell.stock_service.infrastructure.client;

import com.turkcell.stock_service.infrastructure.client.dto.StoreClientResponse;
import com.turkcell.stock_service.domain.exception.StoreServiceUnavailableException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClient;
import org.springframework.stereotype.Component;


@Component
public class StoreClient {

    private final RestClient restClient;

    public StoreClient(RestClient storeServiceRestClient) {
        this.restClient = storeServiceRestClient;
    }

    public StoreClientResponse getStoreById(Long storeId) {
        try {
            return restClient.get()
                    .uri("/stores/{id}", storeId)
                    .retrieve()
                    .body(StoreClientResponse.class);

        } catch (RestClientException exception) {
            throw new StoreServiceUnavailableException();
        }
    }
}