package com.turkcell.capability_service.infrastructure.persistence;

import java.io.Serializable;
import java.util.Objects;

public class StoreCapabilityId implements Serializable {

	private Long storeId;
	private com.turkcell.capability_service.domain.model.CapabilityType capabilityType;

	public StoreCapabilityId() {
	}

	public StoreCapabilityId(Long storeId, com.turkcell.capability_service.domain.model.CapabilityType capabilityType) {
		this.storeId = storeId;
		this.capabilityType = capabilityType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof StoreCapabilityId that)) {
			return false;
		}
		return Objects.equals(storeId, that.storeId) && capabilityType == that.capabilityType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(storeId, capabilityType);
	}
}
