package com.cdio4.logistics.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TransportOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "transport-order", catalog = "logistics")
public class TransportOrder implements java.io.Serializable {

	// Fields

	private TransportOrderId id;

	// Constructors

	/** default constructor */
	public TransportOrder() {
	}

	/** full constructor */
	public TransportOrder(TransportOrderId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "transportId", column = @Column(name = "transport_id", nullable = false, length = 20)),
			@AttributeOverride(name = "orderId", column = @Column(name = "order_id", nullable = false, length = 20)) })
	public TransportOrderId getId() {
		return this.id;
	}

	public void setId(TransportOrderId id) {
		this.id = id;
	}

}