package com.turkcell.store_service.domain.exception;

public class StoreNotFoundException extends RuntimeException {

	public StoreNotFoundException(Long id) {
		super("Bayi bulunamadı: id=" + id);
	}
}
