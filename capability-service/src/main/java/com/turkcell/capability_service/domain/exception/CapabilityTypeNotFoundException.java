package com.turkcell.capability_service.domain.exception;

public class CapabilityTypeNotFoundException extends RuntimeException {

	public CapabilityTypeNotFoundException(String type) {
		super("İşlem tipi bulunamadı: type=" + type);
	}
}
