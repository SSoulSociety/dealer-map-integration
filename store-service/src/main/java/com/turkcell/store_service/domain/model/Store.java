package com.turkcell.store_service.domain.model;

/**
 * Store aggregate root — bayi master data (single source of truth).
 */
public class Store {

	private final Long id;
	private final String name;
	private final String address;
	private final String city;
	private final String district;
	private final double latitude;
	private final double longitude;
	private final StoreType type;
	private final String phone;
	private final String workingHours;
	private final StoreStatus status;
	private final boolean opensWeekend;

	public Store(
			Long id,
			String name,
			String address,
			String city,
			String district,
			double latitude,
			double longitude,
			StoreType type,
			String phone,
			String workingHours,
			StoreStatus status,
			boolean opensWeekend) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Store name is required");
		}
		if (type == null) {
			throw new IllegalArgumentException("Store type is required");
		}
		if (status == null) {
			throw new IllegalArgumentException("Store status is required");
		}
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.district = district;
		this.latitude = latitude;
		this.longitude = longitude;
		this.type = type;
		this.phone = phone;
		this.workingHours = workingHours;
		this.status = status;
		this.opensWeekend = opensWeekend;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getDistrict() {
		return district;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public StoreType getType() {
		return type;
	}

	public String getPhone() {
		return phone;
	}

	public String getWorkingHours() {
		return workingHours;
	}

	public StoreStatus getStatus() {
		return status;
	}

	public boolean isOpensWeekend() {
		return opensWeekend;
	}
}
