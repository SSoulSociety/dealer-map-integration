package com.turkcell.capability_service.infrastructure.client;

/**
 * Store DTO as returned by store-service.
 * status / opensWeekend: Day-7 filter fields (additive to contract Store).
 */
public record StoreDto(
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
		String status,
		Boolean opensWeekend
) {
}
