package com.turkcell.capability_service.infrastructure.client;

public class StoreServiceUnavailableException extends RuntimeException {

	public StoreServiceUnavailableException(String message, Throwable cause) {
		super(message, cause);
	}
}
