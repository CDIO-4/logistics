package com.cdio4.logistics.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * LostOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "lost_order", catalog = "logistics")
public class LostOrder implements java.io.Serializable {

	// Fields

	private String orderId;
	private String lastcarId;
	private String lostSpot;
	private Timestamp lostTime;
	private String operateId;

	// Constructors

	/** default constructor */
	public LostOrder() {
	}

	/** full constructor */
	public LostOrder(String orderId, String lastcarId, String lostSpot,
			Timestamp lostTime, String operateId) {
		this.orderId = orderId;
		this.lastcarId = lastcarId;
		this.lostSpot = lostSpot;
		this.lostTime = lostTime;
		this.operateId = operateId;
	}

	// Property accessors
	@Id
	@Column(name = "order_id", unique = true, nullable = false, length = 30)
	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Column(name = "lastcar_id", nullable = false, length = 20)
	public String getLastcarId() {
		return this.lastcarId;
	}

	public void setLastcarId(String lastcarId) {
		this.lastcarId = lastcarId;
	}

	@Column(name = "lost_spot", nullable = false, length = 20)
	public String getLostSpot() {
		return this.lostSpot;
	}

	public void setLostSpot(String lostSpot) {
		this.lostSpot = lostSpot;
	}

	@Column(name = "lost_time", nullable = false, length = 19)
	public Timestamp getLostTime() {
		return this.lostTime;
	}

	public void setLostTime(Timestamp lostTime) {
		this.lostTime = lostTime;
	}

	@Column(name = "operate_id", nullable = false, length = 20)
	public String getOperateId() {
		return this.operateId;
	}

	public void setOperateId(String operateId) {
		this.operateId = operateId;
	}

}