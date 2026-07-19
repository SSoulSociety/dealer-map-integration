package com.turkcell.capability_service.domain.model;

public enum CapabilityType {
	NEW_LINE("Yeni Hat Başvurusu"),
	DEVICE_DELIVERY("Cihaz Teslim"),
	DEVICE_REPAIR("Cihaz Tamir / Teknik Servis"),
	NUMBER_PORT("Numara Taşıma"),
	BILL_PAYMENT("Fatura Ödeme");

	private final String label;

	CapabilityType(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public static CapabilityType fromKey(String key) {
		try {
			return CapabilityType.valueOf(key);
		} catch (IllegalArgumentException | NullPointerException ex) {
			return null;
		}
	}
}
