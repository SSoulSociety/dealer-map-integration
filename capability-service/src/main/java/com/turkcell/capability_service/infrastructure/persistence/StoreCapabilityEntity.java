package com.turkcell.capability_service.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import com.turkcell.capability_service.domain.model.CapabilityType;

@Entity
@Table(name = "STORE_CAPABILITY")
@IdClass(StoreCapabilityId.class)
public class StoreCapabilityEntity {

	@Id
	@Column(name = "STORE_ID", nullable = false)
	private Long storeId;

	@Id
	@Enumerated(EnumType.STRING)
	@Column(name = "CAPABILITY_TYPE", nullable = false, length = 40)
	private CapabilityType capabilityType;

	protected StoreCapabilityEntity() {
	}

	public StoreCapabilityEntity(Long storeId, CapabilityType capabilityType) {
		this.storeId = storeId;
		this.capabilityType = capabilityType;
	}

	public Long getStoreId() {
		return storeId;
	}

	public CapabilityType getCapabilityType() {
		return capabilityType;
	}
}
