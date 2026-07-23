package com.turkcell.capability_service.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GoogleMapsDeepLinkTest {

	@Test
	void buildsDirectionsDeepLinkFromCoordinates() {
		String url = GoogleMapsDeepLink.forCoordinates(41.0602, 28.9877);

		assertEquals(
				"https://www.google.com/maps/dir/?api=1&destination=41.060200,28.987700",
				url);
	}
}
