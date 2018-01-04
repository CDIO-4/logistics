package com.cdio4.logistics.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Price entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "price", catalog = "logistics")
public class Price implements java.io.Serializable {

	// Fields

	private Integer transportPriceid;
	private Double transportPrice;
	private String priceDistance;

	// Constructors

	/** default constructor */
	public Price() {
	}

	/** full constructor */
	public Price(Double transportPrice, String priceDistance) {
		this.transportPrice = transportPrice;
		this.priceDistance = priceDistance;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "transport_priceid", unique = true, nullable = false)
	public Integer getTransportPriceid() {
		return this.transportPriceid;
	}

	public void setTransportPriceid(Integer transportPriceid) {
		this.transportPriceid = transportPriceid;
	}

	@Column(name = "transport_price", nullable = false, precision = 11, scale = 0)
	public Double getTransportPrice() {
		return this.transportPrice;
	}

	public void setTransportPrice(Double transportPrice) {
		this.transportPrice = transportPrice;
	}

	@Column(name = "price_distance", nullable = false)
	public String getPriceDistance() {
		return this.priceDistance;
	}

	public void setPriceDistance(String priceDistance) {
		this.priceDistance = priceDistance;
	}

}