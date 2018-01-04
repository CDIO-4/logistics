package com.cdio4.logistics.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TransportLineId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TransportLineId implements java.io.Serializable {

	// Fields

	private String transportId;
	private Integer lineId;

	// Constructors

	/** default constructor */
	public TransportLineId() {
	}

	/** full constructor */
	public TransportLineId(String transportId, Integer lineId) {
		this.transportId = transportId;
		this.lineId = lineId;
	}

	// Property accessors

	@Column(name = "transport_id", nullable = false)
	public String getTransportId() {
		return this.transportId;
	}

	public void setTransportId(String transportId) {
		this.transportId = transportId;
	}

	@Column(name = "line_id", nullable = false)
	public Integer getLineId() {
		return this.lineId;
	}

	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TransportLineId))
			return false;
		TransportLineId castOther = (TransportLineId) other;

		return ((this.getTransportId() == castOther.getTransportId()) || (this
				.getTransportId() != null && castOther.getTransportId() != null && this
				.getTransportId().equals(castOther.getTransportId())))
				&& ((this.getLineId() == castOther.getLineId()) || (this
						.getLineId() != null && castOther.getLineId() != null && this
						.getLineId().equals(castOther.getLineId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getTransportId() == null ? 0 : this.getTransportId()
						.hashCode());
		result = 37 * result
				+ (getLineId() == null ? 0 : this.getLineId().hashCode());
		return result;
	}

}