package com.turkcell.capability_service.application.dto;

import com.turkcell.capability_service.domain.model.CapabilityType;

public record CapabilityTypeOption(
		CapabilityType key,
		String label
) {
	public static CapabilityTypeOption from(CapabilityType type) {
		return new CapabilityTypeOption(type, type.getLabel());
	}
}
