package com.cdio4.logistics.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SubsportId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class SubsportId implements java.io.Serializable {

	// Fields

	private String subsportId;
	private String supsportId;

	// Constructors

	/** default constructor */
	public SubsportId() {
	}

	/** full constructor */
	public SubsportId(String subsportId, String supsportId) {
		this.subsportId = subsportId;
		this.supsportId = supsportId;
	}

	// Property accessors

	@Column(name = "subsport_id", nullable = false, length = 20)
	public String getSubsportId() {
		return this.subsportId;
	}

	public void setSubsportId(String subsportId) {
		this.subsportId = subsportId;
	}

	@Column(name = "supsport_id", nullable = false)
	public String getSupsportId() {
		return this.supsportId;
	}

	public void setSupsportId(String supsportId) {
		this.supsportId = supsportId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SubsportId))
			return false;
		SubsportId castOther = (SubsportId) other;

		return ((this.getSubsportId() == castOther.getSubsportId()) || (this
				.getSubsportId() != null && castOther.getSubsportId() != null && this
				.getSubsportId().equals(castOther.getSubsportId())))
				&& ((this.getSupsportId() == castOther.getSupsportId()) || (this
						.getSupsportId() != null
						&& castOther.getSupsportId() != null && this
						.getSupsportId().equals(castOther.getSupsportId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getSubsportId() == null ? 0 : this.getSubsportId()
						.hashCode());
		result = 37
				* result
				+ (getSupsportId() == null ? 0 : this.getSupsportId()
						.hashCode());
		return result;
	}

}