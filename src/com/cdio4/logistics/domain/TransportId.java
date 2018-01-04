package com.cdio4.logistics.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TransportId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TransportId implements java.io.Serializable {

	// Fields

	private String transportId;
	private String carId;

	// Constructors

	/** default constructor */
	public TransportId() {
	}

	/** full constructor */
	public TransportId(String transportId, String carId) {
		this.transportId = transportId;
		this.carId = carId;
	}

	// Property accessors

	@Column(name = "transport_id", nullable = false)
	public String getTransportId() {
		return this.transportId;
	}

	public void setTransportId(String transportId) {
		this.transportId = transportId;
	}

	@Column(name = "car_id", nullable = false, length = 20)
	public String getCarId() {
		return this.carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TransportId))
			return false;
		TransportId castOther = (TransportId) other;

		return ((this.getTransportId() == castOther.getTransportId()) || (this
				.getTransportId() != null && castOther.getTransportId() != null && this
				.getTransportId().equals(castOther.getTransportId())))
				&& ((this.getCarId() == castOther.getCarId()) || (this
						.getCarId() != null && castOther.getCarId() != null && this
						.getCarId().equals(castOther.getCarId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getTransportId() == null ? 0 : this.getTransportId()
						.hashCode());
		result = 37 * result
				+ (getCarId() == null ? 0 : this.getCarId().hashCode());
		return result;
	}

}