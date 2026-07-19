package com.turkcell.store_service.infrastructure.persistence;

import org.springframework.stereotype.Component;

import com.turkcell.store_service.domain.model.Store;

@Component
public class StoreMapper {

	public Store toDomain(StoreEntity entity) {
		return new Store(
				entity.getId(),
				entity.getName(),
				entity.getAddress(),
				entity.getCity(),
				entity.getDistrict(),
				entity.getLatitude(),
				entity.getLongitude(),
				entity.getType(),
				entity.getPhone(),
				entity.getWorkingHours(),
				entity.getStatus(),
				Boolean.TRUE.equals(entity.getOpensWeekend()));
	}
}
