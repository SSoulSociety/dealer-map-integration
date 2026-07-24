package com.turkcell.store_service.application.dto;

import com.turkcell.store_service.domain.model.Store;
import com.turkcell.store_service.domain.model.StoreStatus;
import com.turkcell.store_service.domain.model.StoreType;
import com.turkcell.store_service.domain.service.GoogleMapsDeepLink;

/**
 * Matches API contract {@code Store} type, plus Day-7 filter fields
 * ({@code status}, {@code opensWeekend}) and Day-12 {@code directionsUrl}.
 */
public record StoreResponse(
		Long id,
		String name,
		String address,
		String city,
		String district,
		double latitude,
		double longitude,
		StoreType type,
		String phone,
		String workingHours,
		StoreStatus status,
		boolean opensWeekend,
		String directionsUrl
) {
	public static StoreResponse from(Store store) {
		return new StoreResponse(
				store.getId(),
				store.getName(),
				store.getAddress(),
				store.getCity(),
				store.getDistrict(),
				store.getLatitude(),
				store.getLongitude(),
				store.getType(),
				store.getPhone(),
				store.getWorkingHours(),
				store.getStatus(),
				store.isOpensWeekend(),
				GoogleMapsDeepLink.forCoordinates(store.getLatitude(), store.getLongitude()));
	}
}
