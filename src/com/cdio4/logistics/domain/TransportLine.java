package com.cdio4.logistics.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TransportLine entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "transport_line", catalog = "logistics")
public class TransportLine implements java.io.Serializable {

	// Fields

	private TransportLineId id;
	private Integer ordinal;

	// Constructors

	/** default constructor */
	public TransportLine() {
	}

	/** full constructor */
	public TransportLine(TransportLineId id, Integer ordinal) {
		this.id = id;
		this.ordinal = ordinal;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "transportId", column = @Column(name = "transport_id", nullable = false)),
			@AttributeOverride(name = "lineId", column = @Column(name = "line_id", nullable = false)) })
	public TransportLineId getId() {
		return this.id;
	}

	public void setId(TransportLineId id) {
		this.id = id;
	}

	@Column(name = "ordinal", nullable = false)
	public Integer getOrdinal() {
		return this.ordinal;
	}

	public void setOrdinal(Integer ordinal) {
		this.ordinal = ordinal;
	}

}