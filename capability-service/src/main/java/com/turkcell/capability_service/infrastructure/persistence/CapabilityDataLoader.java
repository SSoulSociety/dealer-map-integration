package com.turkcell.capability_service.infrastructure.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.turkcell.capability_service.domain.model.CapabilityType;

/**
 * Day 12 enriched seed: TIM bayileri uzmanlık alanına göre farklılaşır;
 * franchise'larda nadir yetkinlikler (DEVICE_REPAIR, DEVICE_DELIVERY) dağılır.
 */
@Component
public class CapabilityDataLoader implements ApplicationRunner {

	private static final Logger log = LoggerFactory.getLogger(CapabilityDataLoader.class);

	private final StoreCapabilityRepository repository;

	public CapabilityDataLoader(StoreCapabilityRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public void run(ApplicationArguments args) {
		if (repository.count() > 0) {
			log.info("STORE_CAPABILITY already has {} rows — skip seed", repository.count());
			return;
		}
		log.info("Seeding enriched STORE_CAPABILITY (Day 12)...");
		repository.saveAll(seed());
		log.info("STORE_CAPABILITY seed completed ({} rows)", repository.count());
	}

	private static List<StoreCapabilityEntity> seed() {
		Map<Long, List<CapabilityType>> data = Map.ofEntries(
				// TIM — tam yetkin hub'lar
				Map.entry(1L, List.of(CapabilityType.values())),
				Map.entry(3L, List.of(CapabilityType.values())),
				// TIM — tamir / teknik servis odaklı
				Map.entry(2L, List.of(
						CapabilityType.DEVICE_REPAIR,
						CapabilityType.DEVICE_DELIVERY,
						CapabilityType.BILL_PAYMENT,
						CapabilityType.NEW_LINE)),
				Map.entry(5L, List.of(
						CapabilityType.DEVICE_REPAIR,
						CapabilityType.NUMBER_PORT,
						CapabilityType.BILL_PAYMENT,
						CapabilityType.NEW_LINE)),
				// TIM — hat / numara taşıma odaklı (tamir yok)
				Map.entry(4L, List.of(
						CapabilityType.NEW_LINE,
						CapabilityType.NUMBER_PORT,
						CapabilityType.BILL_PAYMENT,
						CapabilityType.DEVICE_DELIVERY)),
				Map.entry(6L, List.of(
						CapabilityType.NEW_LINE,
						CapabilityType.NUMBER_PORT,
						CapabilityType.BILL_PAYMENT,
						CapabilityType.DEVICE_DELIVERY)),
				// Franchise — çeşitlendirilmiş alt setler
				Map.entry(7L, List.of(
						CapabilityType.NEW_LINE,
						CapabilityType.NUMBER_PORT,
						CapabilityType.BILL_PAYMENT)),
				Map.entry(8L, List.of(
						CapabilityType.NEW_LINE,
						CapabilityType.DEVICE_DELIVERY,
						CapabilityType.BILL_PAYMENT)),
				Map.entry(9L, List.of(
						CapabilityType.NEW_LINE,
						CapabilityType.DEVICE_DELIVERY,
						CapabilityType.NUMBER_PORT,
						CapabilityType.DEVICE_REPAIR)),
				Map.entry(10L, List.of(
						CapabilityType.NEW_LINE,
						CapabilityType.BILL_PAYMENT)),
				Map.entry(11L, List.of(
						CapabilityType.NEW_LINE,
						CapabilityType.NUMBER_PORT,
						CapabilityType.BILL_PAYMENT)),
				Map.entry(12L, List.of(
						CapabilityType.NEW_LINE,
						CapabilityType.DEVICE_DELIVERY,
						CapabilityType.BILL_PAYMENT,
						CapabilityType.DEVICE_REPAIR)),
				Map.entry(13L, List.of(
						CapabilityType.NEW_LINE,
						CapabilityType.NUMBER_PORT,
						CapabilityType.DEVICE_DELIVERY)),
				Map.entry(14L, List.of(
						CapabilityType.NEW_LINE,
						CapabilityType.DEVICE_REPAIR,
						CapabilityType.BILL_PAYMENT,
						CapabilityType.DEVICE_DELIVERY)),
				Map.entry(15L, List.of(
						CapabilityType.NEW_LINE,
						CapabilityType.BILL_PAYMENT,
						CapabilityType.NUMBER_PORT)));

		List<StoreCapabilityEntity> rows = new ArrayList<>();
		data.forEach((storeId, types) -> types.forEach(type -> rows.add(new StoreCapabilityEntity(storeId, type))));
		return rows;
	}
}
