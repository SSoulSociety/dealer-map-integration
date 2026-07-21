package com.turkcell.stock_service.domain.exception;

public class StoreServiceUnavailableException extends RuntimeException {

    public StoreServiceUnavailableException() {
        super("Store service şu anda kullanılamıyor");
    }
}