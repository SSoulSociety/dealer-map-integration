package com.turkcell.capability_service.application.dto;

/**
 * Matches API contract {@code StoreCapabilityResult} (StoreWithDistance + Day-12 directionsUrl).
 */
public record StoreCapabilityResult(
		Long id,
		String name,
		String address,
		String city,
		String district,
		double latitude,
		double longitude,
		String type,
		String phone,
		String workingHours,
		double distance,
		String directionsUrl
) {
}
