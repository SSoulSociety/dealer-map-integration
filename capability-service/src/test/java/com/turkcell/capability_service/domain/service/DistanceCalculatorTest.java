package com.turkcell.capability_service.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DistanceCalculatorTest {

	private final DistanceCalculator calculator = new DistanceCalculator();

	@Test
	void samePoint_isZero() {
		assertEquals(0.0, calculator.calculate(41.0, 29.0, 41.0, 29.0));
	}

	@Test
	void kadikoyToBesiktas_isReasonable() {
		double km = calculator.calculate(40.9901, 29.0253, 41.0428, 29.0075);
		assertTrue(km > 4.0 && km < 8.0, "expected ~5-7 km, got " + km);
	}
}
