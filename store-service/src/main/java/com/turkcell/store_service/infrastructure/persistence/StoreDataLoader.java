package com.turkcell.store_service.infrastructure.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.turkcell.store_service.domain.model.StoreStatus;
import com.turkcell.store_service.domain.model.StoreType;

/**
 * Seeds STORE table when empty (Oracle init volume may already have schema).
 */
@Component
public class StoreDataLoader implements ApplicationRunner {

	private static final Logger log = LoggerFactory.getLogger(StoreDataLoader.class);

	private final StoreJpaRepository storeRepository;

	public StoreDataLoader(StoreJpaRepository storeRepository) {
		this.storeRepository = storeRepository;
	}

	@Override
	@Transactional
	public void run(ApplicationArguments args) {
		if (storeRepository.count() > 0) {
			log.info("STORE already has {} rows — skip seed", storeRepository.count());
			return;
		}
		log.info("Seeding STORE with 15 Istanbul dealers...");
		storeRepository.saveAll(seedStores());
		log.info("STORE seed completed");
	}

	private static java.util.List<StoreEntity> seedStores() {
		return java.util.List.of(
				store(1L, "Turkcell Kadikoy TIM", "Sogutlucesme Cd. No: 42, Kadikoy", "Istanbul", "Kadikoy",
						40.9901, 29.0253, StoreType.TIM, "+90 216 555 0101", "09:00 - 21:00", StoreStatus.ACTIVE, true),
				store(2L, "Turkcell Besiktas TIM", "Barbaros Blv. No: 12, Besiktas", "Istanbul", "Besiktas",
						41.0428, 29.0075, StoreType.TIM, "+90 212 555 0102", "09:00 - 21:00", StoreStatus.ACTIVE, true),
				store(3L, "Turkcell Sisli TIM", "Halaskargazi Cd. No: 150, Sisli", "Istanbul", "Sisli",
						41.0602, 28.9877, StoreType.TIM, "+90 212 555 0103", "09:00 - 22:00", StoreStatus.ACTIVE, true),
				store(4L, "Turkcell Uskudar TIM", "Hakimiyeti Milliye Cd. No: 80, Uskudar", "Istanbul", "Uskudar",
						41.0267, 29.0152, StoreType.TIM, "+90 216 555 0104", "09:00 - 20:00", StoreStatus.ACTIVE, false),
				store(5L, "Turkcell Fatih TIM", "Fevzipasa Cd. No: 210, Fatih", "Istanbul", "Fatih",
						41.0186, 28.9497, StoreType.TIM, "+90 212 555 0105", "09:00 - 20:00", StoreStatus.ACTIVE, true),
				store(6L, "Turkcell Beyoglu TIM", "Istiklal Cd. No: 75, Beyoglu", "Istanbul", "Beyoglu",
						41.0370, 28.9764, StoreType.TIM, "+90 212 555 0106", "10:00 - 22:00", StoreStatus.ACTIVE, true),
				store(7L, "Turkcell Kadikoy Franchise 1", "Moda Cd. No: 18, Kadikoy", "Istanbul", "Kadikoy",
						40.9880, 29.0300, StoreType.FRANCHISE, "+90 216 555 0107", "09:00 - 20:00", StoreStatus.ACTIVE, false),
				store(8L, "Turkcell Besiktas Franchise 1", "Sinanpasa Pasaji No: 5, Besiktas", "Istanbul", "Besiktas",
						41.0410, 29.0090, StoreType.FRANCHISE, "+90 212 555 0108", "09:00 - 20:00", StoreStatus.ACTIVE, true),
				store(9L, "Turkcell Sisli Franchise 1", "Abdi Ipekci Cd. No: 45, Nisantasi", "Istanbul", "Sisli",
						41.0580, 28.9850, StoreType.FRANCHISE, "+90 212 555 0109", "10:00 - 20:00", StoreStatus.ACTIVE, false),
				store(10L, "Turkcell Uskudar Franchise 1", "Baglarbasi Cd. No: 120, Uskudar", "Istanbul", "Uskudar",
						41.0250, 29.0120, StoreType.FRANCHISE, "+90 216 555 0110", "09:00 - 20:00", StoreStatus.ACTIVE, true),
				store(11L, "Turkcell Fatih Franchise 1", "Vatan Cd. No: 33, Fatih", "Istanbul", "Fatih",
						41.0150, 28.9450, StoreType.FRANCHISE, "+90 212 555 0111", "09:00 - 19:00", StoreStatus.INACTIVE, false),
				store(12L, "Turkcell Kadikoy Franchise 2", "Acibadem Cd. No: 88, Kadikoy", "Istanbul", "Kadikoy",
						40.9850, 29.0200, StoreType.FRANCHISE, "+90 216 555 0112", "09:00 - 20:00", StoreStatus.ACTIVE, true),
				store(13L, "Turkcell Besiktas Franchise 2", "Ortakoy Meydan No: 3, Besiktas", "Istanbul", "Besiktas",
						41.0450, 29.0020, StoreType.FRANCHISE, "+90 212 555 0113", "10:00 - 21:00", StoreStatus.ACTIVE, true),
				store(14L, "Turkcell Sisli Franchise 2", "Mecidiyekoy Yolu No: 12, Sisli", "Istanbul", "Sisli",
						41.0620, 28.9920, StoreType.FRANCHISE, "+90 212 555 0114", "09:00 - 20:00", StoreStatus.ACTIVE, false),
				store(15L, "Turkcell Uskudar Franchise 2", "Libadiye Cd. No: 200, Uskudar", "Istanbul", "Uskudar",
						41.0290, 29.0200, StoreType.FRANCHISE, "+90 216 555 0115", "09:00 - 20:00", StoreStatus.ACTIVE, true));
	}

	private static StoreEntity store(
			Long id, String name, String address, String city, String district,
			double lat, double lng, StoreType type, String phone, String hours,
			StoreStatus status, boolean opensWeekend) {
		StoreEntity e = new StoreEntity();
		e.setId(id);
		e.setName(name);
		e.setAddress(address);
		e.setCity(city);
		e.setDistrict(district);
		e.setLatitude(lat);
		e.setLongitude(lng);
		e.setType(type);
		e.setPhone(phone);
		e.setWorkingHours(hours);
		e.setStatus(status);
		e.setOpensWeekend(opensWeekend);
		return e;
	}
}
