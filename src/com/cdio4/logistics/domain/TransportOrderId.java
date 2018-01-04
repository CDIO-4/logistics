package com.cdio4.logistics.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TransportOrderId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TransportOrderId implements java.io.Serializable {

	// Fields

	private String transportId;
	private String orderId;

	// Constructors

	/** default constructor */
	public TransportOrderId() {
	}

	/** full constructor */
	public TransportOrderId(String transportId, String orderId) {
		this.transportId = transportId;
		this.orderId = orderId;
	}

	// Property accessors

	@Column(name = "transport_id", nullable = false, length = 20)
	public String getTransportId() {
		return this.transportId;
	}

	public void setTransportId(String transportId) {
		this.transportId = transportId;
	}

	@Column(name = "order_id", nullable = false, length = 20)
	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TransportOrderId))
			return false;
		TransportOrderId castOther = (TransportOrderId) other;

		return ((this.getTransportId() == castOther.getTransportId()) || (this
				.getTransportId() != null && castOther.getTransportId() != null && this
				.getTransportId().equals(castOther.getTransportId())))
				&& ((this.getOrderId() == castOther.getOrderId()) || (this
						.getOrderId() != null && castOther.getOrderId() != null && this
						.getOrderId().equals(castOther.getOrderId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getTransportId() == null ? 0 : this.getTransportId()
						.hashCode());
		result = 37 * result
				+ (getOrderId() == null ? 0 : this.getOrderId().hashCode());
		return result;
	}

}