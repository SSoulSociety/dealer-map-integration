package com.turkcell.store_service.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreJpaRepository extends JpaRepository<StoreEntity, Long> {

	List<StoreEntity> findByCityIgnoreCaseAndDistrictIgnoreCase(String city, String district);

	List<StoreEntity> findByCityIgnoreCase(String city);

	List<StoreEntity> findByIdIn(List<Long> ids);
}
