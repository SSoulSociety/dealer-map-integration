package com.turkcell.store_service.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.turkcell.store_service.domain.model.StoreStatus;
import com.turkcell.store_service.domain.model.StoreType;

@Entity
@Table(name = "STORE")
public class StoreEntity {

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME", nullable = false, length = 150)
	private String name;

	@Column(name = "ADDRESS", nullable = false, length = 255)
	private String address;

	@Column(name = "CITY", nullable = false, length = 80)
	private String city;

	@Column(name = "DISTRICT", nullable = false, length = 80)
	private String district;

	@Column(name = "LATITUDE", nullable = false)
	private Double latitude;

	@Column(name = "LONGITUDE", nullable = false)
	private Double longitude;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE", nullable = false, length = 20)
	private StoreType type;

	@Column(name = "PHONE", length = 30)
	private String phone;

	@Column(name = "WORKING_HOURS", length = 120)
	private String workingHours;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS", nullable = false, length = 20)
	private StoreStatus status;

	@Column(name = "OPENS_WEEKEND", nullable = false)
	private Boolean opensWeekend;

	protected StoreEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public StoreType getType() {
		return type;
	}

	public void setType(StoreType type) {
		this.type = type;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}

	public StoreStatus getStatus() {
		return status;
	}

	public void setStatus(StoreStatus status) {
		this.status = status;
	}

	public Boolean getOpensWeekend() {
		return opensWeekend;
	}

	public void setOpensWeekend(Boolean opensWeekend) {
		this.opensWeekend = opensWeekend;
	}
}
