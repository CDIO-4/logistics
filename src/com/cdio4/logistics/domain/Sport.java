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
 * Sport entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sport", catalog = "logistics")
public class Sport implements java.io.Serializable {

	// Fields

	private String sportId;
	private String sportPostcode;
	private String sportCity;
	private String sportDetailaddress;
	private String sportPhone;
	private Set<Order> ordersForOrderSendsport = new HashSet<Order>(0);
	private Set<Order> ordersForOrderReceivesport = new HashSet<Order>(0);
	private Set<Subsport> subsports = new HashSet<Subsport>(0);
	private Set<Route> routes = new HashSet<Route>(0);

	// Constructors

	/** default constructor */
	public Sport() {
	}

	/** minimal constructor */
	public Sport(String sportId, String sportPostcode, String sportCity,
			String sportPhone) {
		this.sportId = sportId;
		this.sportPostcode = sportPostcode;
		this.sportCity = sportCity;
		this.sportPhone = sportPhone;
	}

	/** full constructor */
	public Sport(String sportId, String sportPostcode, String sportCity,
			String sportDetailaddress, String sportPhone,
			Set<Order> ordersForOrderSendsport,
			Set<Order> ordersForOrderReceivesport, Set<Subsport> subsports,
			Set<Route> routes) {
		this.sportId = sportId;
		this.sportPostcode = sportPostcode;
		this.sportCity = sportCity;
		this.sportDetailaddress = sportDetailaddress;
		this.sportPhone = sportPhone;
		this.ordersForOrderSendsport = ordersForOrderSendsport;
		this.ordersForOrderReceivesport = ordersForOrderReceivesport;
		this.subsports = subsports;
		this.routes = routes;
	}

	// Property accessors
	@Id
	@Column(name = "sport_id", unique = true, nullable = false)
	public String getSportId() {
		return this.sportId;
	}

	public void setSportId(String sportId) {
		this.sportId = sportId;
	}

	@Column(name = "sport_postcode", nullable = false, length = 11)
	public String getSportPostcode() {
		return this.sportPostcode;
	}

	public void setSportPostcode(String sportPostcode) {
		this.sportPostcode = sportPostcode;
	}

	@Column(name = "sport_city", nullable = false, length = 11)
	public String getSportCity() {
		return this.sportCity;
	}

	public void setSportCity(String sportCity) {
		this.sportCity = sportCity;
	}

	@Column(name = "sport_detailaddress")
	public String getSportDetailaddress() {
		return this.sportDetailaddress;
	}

	public void setSportDetailaddress(String sportDetailaddress) {
		this.sportDetailaddress = sportDetailaddress;
	}

	@Column(name = "sport_phone", nullable = false, length = 11)
	public String getSportPhone() {
		return this.sportPhone;
	}

	public void setSportPhone(String sportPhone) {
		this.sportPhone = sportPhone;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sportByOrderSendsport")
	public Set<Order> getOrdersForOrderSendsport() {
		return this.ordersForOrderSendsport;
	}

	public void setOrdersForOrderSendsport(Set<Order> ordersForOrderSendsport) {
		this.ordersForOrderSendsport = ordersForOrderSendsport;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sportByOrderReceivesport")
	public Set<Order> getOrdersForOrderReceivesport() {
		return this.ordersForOrderReceivesport;
	}

	public void setOrdersForOrderReceivesport(
			Set<Order> ordersForOrderReceivesport) {
		this.ordersForOrderReceivesport = ordersForOrderReceivesport;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sport")
	public Set<Subsport> getSubsports() {
		return this.subsports;
	}

	public void setSubsports(Set<Subsport> subsports) {
		this.subsports = subsports;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sport")
	public Set<Route> getRoutes() {
		return this.routes;
	}

	public void setRoutes(Set<Route> routes) {
		this.routes = routes;
	}

}