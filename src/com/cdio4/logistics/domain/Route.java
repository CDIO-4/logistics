package com.cdio4.logistics.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Route entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "route", catalog = "logistics")
public class Route implements java.io.Serializable {

	// Fields

	private Integer lineId;
	private Sport sport;
	private Double lineDistance;
	private String lineStart;
	private String lineEnd;

	// Constructors

	/** default constructor */
	public Route() {
	}

	/** full constructor */
	public Route(Sport sport, Double lineDistance, String lineStart,
			String lineEnd) {
		this.sport = sport;
		this.lineDistance = lineDistance;
		this.lineStart = lineStart;
		this.lineEnd = lineEnd;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "line_id", unique = true, nullable = false)
	public Integer getLineId() {
		return this.lineId;
	}

	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ofspot", nullable = false)
	public Sport getSport() {
		return this.sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	@Column(name = "line_distance", nullable = false, precision = 10, scale = 0)
	public Double getLineDistance() {
		return this.lineDistance;
	}

	public void setLineDistance(Double lineDistance) {
		this.lineDistance = lineDistance;
	}

	@Column(name = "line_start", nullable = false, length = 20)
	public String getLineStart() {
		return this.lineStart;
	}

	public void setLineStart(String lineStart) {
		this.lineStart = lineStart;
	}

	@Column(name = "line_end", nullable = false, length = 20)
	public String getLineEnd() {
		return this.lineEnd;
	}

	public void setLineEnd(String lineEnd) {
		this.lineEnd = lineEnd;
	}

}