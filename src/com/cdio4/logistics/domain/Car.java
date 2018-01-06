package com.cdio4.logistics.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Car entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "car", catalog = "logistics")
public class Car implements java.io.Serializable {

	// Fields

	private String carId;
	private String ifFree;
	private String carModel;
	private String description;
	private String carState;
	private String currrentspot;
	private Double carweight;
	private String driverId;
	private String driverphone;
	private String driveradress;
	private Set<Transport> transports = new HashSet<Transport>(0);

	// Constructors

	/** default constructor */
	public Car() {
	}

	/** minimal constructor */
	public Car(String carId) {
		this.carId = carId;
	}

	/** full constructor */
	public Car(String carId, String carModel,
			String description,String carState,
			String ifFree, String currrentspot,
			Double carweight, String driverId, String driverphone,
			String driveradress, Set<Transport> transports) {
		this.carId = carId;
		this.ifFree = ifFree;
		this.currrentspot = currrentspot;
		this.carModel=carModel;
		this.carState= carState;
		this.description = description;
		this.carweight = carweight;
		this.driverId = driverId;
		this.driverphone = driverphone;
		this.driveradress = driveradress;
		this.transports = transports;
	}

	// Property accessors
	@Id
	@Column(name = "car_id", unique = true, nullable = false, length = 20)
	public String getCarId() {
		return this.carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}
	@Column(name = "car_model", length = 30)
	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	@Column(name = "description", length = 255)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name = "car_state", length = 20)
	public String getCarState() {
		return carState;
	}

	public void setCarState(String carState) {
		this.carState = carState;
	}

	@Column(name = "ifFree", length = 5)
	public String getIfFree() {
		return this.ifFree;
	}

	public void setIfFree(String ifFree) {
		this.ifFree = ifFree;
	}

	@Column(name = "currrentspot", length = 20)
	public String getCurrrentspot() {
		return this.currrentspot;
	}

	public void setCurrrentspot(String currrentspot) {
		this.currrentspot = currrentspot;
	}

	@Column(name = "carweight", length = 10)
	public Double getCarweight() {
		return this.carweight;
	}

	public void setCarweight(Double carweight) {
		this.carweight = carweight;
	}

	@Column(name = "driverId", length = 15)
	public String getDriverId() {
		return this.driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	@Column(name = "driverphone", length = 20)
	public String getDriverphone() {
		return this.driverphone;
	}

	public void setDriverphone(String driverphone) {
		this.driverphone = driverphone;
	}

	@Column(name = "driveradress", length = 30)
	public String getDriveradress() {
		return this.driveradress;
	}

	public void setDriveradress(String driveradress) {
		this.driveradress = driveradress;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "car")
	public Set<Transport> getTransports() {
		return this.transports;
	}

	public void setTransports(Set<Transport> transports) {
		this.transports = transports;
	}

}