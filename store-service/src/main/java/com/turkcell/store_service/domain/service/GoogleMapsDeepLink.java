package com.turkcell.store_service.domain.service;

import java.util.Locale;

/**
 * Builds Google Maps directions deep links from store coordinates (Day 12).
 * Example: https://www.google.com/maps/dir/?api=1&amp;destination=40.990100,29.025300
 */
public final class GoogleMapsDeepLink {

	private static final String DIRECTIONS_TEMPLATE =
			"https://www.google.com/maps/dir/?api=1&destination=%.6f,%.6f";

	private GoogleMapsDeepLink() {
	}

	public static String forCoordinates(double latitude, double longitude) {
		return String.format(Locale.US, DIRECTIONS_TEMPLATE, latitude, longitude);
	}
}
