package com.cdio4.logistics.domain;

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
 * Subsport entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "subsport", catalog = "logistics")
public class Subsport implements java.io.Serializable {

	// Fields

	private SubsportId id;
	private Sport sport;
	private String sportCounty;
	private String sportDetailaddress;

	// Constructors

	/** default constructor */
	public Subsport() {
	}

	/** full constructor */
	public Subsport(SubsportId id, Sport sport, String sportCounty,
			String sportDetailaddress) {
		this.id = id;
		this.sport = sport;
		this.sportCounty = sportCounty;
		this.sportDetailaddress = sportDetailaddress;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "subsportId", column = @Column(name = "subsport_id", nullable = false, length = 20)),
			@AttributeOverride(name = "supsportId", column = @Column(name = "supsport_id", nullable = false)) })
	public SubsportId getId() {
		return this.id;
	}

	public void setId(SubsportId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supsport_id", nullable = false, insertable = false, updatable = false)
	public Sport getSport() {
		return this.sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	@Column(name = "sport_county", nullable = false)
	public String getSportCounty() {
		return this.sportCounty;
	}

	public void setSportCounty(String sportCounty) {
		this.sportCounty = sportCounty;
	}

	@Column(name = "sport_detailaddress", nullable = false)
	public String getSportDetailaddress() {
		return this.sportDetailaddress;
	}

	public void setSportDetailaddress(String sportDetailaddress) {
		this.sportDetailaddress = sportDetailaddress;
	}

}