package com.cdio4.logistics.domain;

import java.sql.Timestamp;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Transport entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "transport", catalog = "logistics")
public class Transport implements java.io.Serializable {

	// Fields

	private TransportId id;
	private Car car;
	private String nextsport;
	private String destination;
	private String ifArraive;
	private Timestamp creattime;

	// Constructors

	/** default constructor */
	public Transport() {
	}

	/** full constructor */
	public Transport(TransportId id, Car car, String nextsport,
			String destination, String ifArraive, Timestamp creattime) {
		this.id = id;
		this.car = car;
		this.nextsport = nextsport;
		this.destination = destination;
		this.ifArraive = ifArraive;
		this.creattime = creattime;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "transportId", column = @Column(name = "transport_id", nullable = false)),
			@AttributeOverride(name = "carId", column = @Column(name = "car_id", nullable = false, length = 20)) })
	public TransportId getId() {
		return this.id;
	}

	public void setId(TransportId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "car_id", nullable = false, insertable = false, updatable = false)
	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Column(name = "nextsport", nullable = false)
	public String getNextsport() {
		return this.nextsport;
	}

	public void setNextsport(String nextsport) {
		this.nextsport = nextsport;
	}

	@Column(name = "destination", nullable = false)
	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Column(name = "ifArraive", nullable = false, length = 20)
	public String getIfArraive() {
		return this.ifArraive;
	}

	public void setIfArraive(String ifArraive) {
		this.ifArraive = ifArraive;
	}

	@Column(name = "creattime", nullable = false, length = 19)
	public Timestamp getCreattime() {
		return this.creattime;
	}

	public void setCreattime(Timestamp creattime) {
		this.creattime = creattime;
	}

}