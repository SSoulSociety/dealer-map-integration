package com.turkcell.capability_service.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.turkcell.capability_service.domain.model.CapabilityType;

public interface StoreCapabilityRepository extends JpaRepository<StoreCapabilityEntity, StoreCapabilityId> {

	@Query("select sc.storeId from StoreCapabilityEntity sc where sc.capabilityType = :type")
	List<Long> findStoreIdsByCapabilityType(@Param("type") CapabilityType type);
}
