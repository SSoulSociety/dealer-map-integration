package com.turkcell.stock_service.application.service;

import com.turkcell.stock_service.domain.model.Stock;
import com.turkcell.stock_service.infrastructure.client.StoreClient;
import com.turkcell.stock_service.infrastructure.persistence.StockMapper;
import com.turkcell.stock_service.infrastructure.persistence.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;
    private final StockMapper stockMapper;
    private final StoreClient storeClient;

    public StockService(
            StockRepository stockRepository,
            StockMapper stockMapper,
            StoreClient storeClient
    ) {
        this.stockRepository = stockRepository;
        this.stockMapper = stockMapper;
        this.storeClient = storeClient;
    }

    public List<Stock> getStocksByProductId(Long productId) {
        return stockRepository.findByProductId(productId)
                .stream()
                .map(stockMapper::toDomain)
                .toList();
    }
}