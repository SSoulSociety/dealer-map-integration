package com.turkcell.store_service.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GoogleMapsDeepLinkTest {

	@Test
	void buildsDirectionsDeepLinkFromCoordinates() {
		String url = GoogleMapsDeepLink.forCoordinates(40.9901, 29.0253);

		assertEquals(
				"https://www.google.com/maps/dir/?api=1&destination=40.990100,29.025300",
				url);
	}
}
