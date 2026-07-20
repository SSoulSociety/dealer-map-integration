package com.turkcell.stock_service.infrastructure.client.dto;

public record StoreClientResponse(
        Long id,
        String name,
        String address,
        String city,
        String district,
        Double latitude,
        Double longitude,
        String type
) {
}