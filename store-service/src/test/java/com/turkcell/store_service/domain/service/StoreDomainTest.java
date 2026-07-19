package com.turkcell.store_service.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.turkcell.store_service.domain.model.Store;
import com.turkcell.store_service.domain.model.StoreStatus;
import com.turkcell.store_service.domain.model.StoreType;

class StoreDomainTest {

	@Test
	void storeHoldsMasterDataInvariants() {
		Store store = new Store(
				1L, "Turkcell Kadikoy TIM", "Sogutlucesme Cd. No: 42, Kadikoy",
				"Istanbul", "Kadikoy", 40.9901, 29.0253,
				StoreType.TIM, "+90 216 555 0101", "09:00 - 21:00",
				StoreStatus.ACTIVE, true);

		assertEquals(1L, store.getId());
		assertEquals(StoreType.TIM, store.getType());
		assertEquals(StoreStatus.ACTIVE, store.getStatus());
		assertEquals(true, store.isOpensWeekend());
	}
}
