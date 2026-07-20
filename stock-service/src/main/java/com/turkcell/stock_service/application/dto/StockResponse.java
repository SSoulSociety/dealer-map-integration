package com.turkcell.stock_service.application.dto;

import com.turkcell.stock_service.domain.model.StockLevel;

public record StockResponse(
        Long id,
        String name,
        String address,
        String city,
        String district,
        Double latitude,
        Double longitude,
        String type,
        StockLevel stockLevel,
        double distance
) {
}