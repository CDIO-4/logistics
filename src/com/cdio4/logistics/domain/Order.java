package com.cdio4.logistics.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "order", catalog = "logistics")
public class Order implements java.io.Serializable {

	// Fields

	private String orderId;
	private Sport sportByOrderReceivesport;
	private Sport sportByOrderSendsport;
	private Double orderMoney;
	private Double orderWeight;
	private String ordeSendername;
	private String orderSenderphone;
	private String orderTocity;
	private String orderTocounty;
	private String orderReceiverphone;
	private String orderReceivername;
	private String orderState;
	private String orderSign;
	private Timestamp createtime;
	private String operateId;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(String orderId, Sport sportByOrderReceivesport,
			Sport sportByOrderSendsport, Double orderMoney, Double orderWeight,
			String ordeSendername, String orderSenderphone, String orderTocity,
			String orderTocounty, String orderReceiverphone,
			String orderReceivername, String orderState, String orderSign,
			Timestamp createtime, String operateId) {
		this.orderId = orderId;
		this.sportByOrderReceivesport = sportByOrderReceivesport;
		this.sportByOrderSendsport = sportByOrderSendsport;
		this.orderMoney = orderMoney;
		this.orderWeight = orderWeight;
		this.ordeSendername = ordeSendername;
		this.orderSenderphone = orderSenderphone;
		this.orderTocity = orderTocity;
		this.orderTocounty = orderTocounty;
		this.orderReceiverphone = orderReceiverphone;
		this.orderReceivername = orderReceivername;
		this.orderState = orderState;
		this.orderSign = orderSign;
		this.createtime = createtime;
		this.operateId = operateId;
	}

	// Property accessors
	@Id
	@Column(name = "order_id", unique = true, nullable = false, length = 20)
	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_receivesport", nullable = false)
	public Sport getSportByOrderReceivesport() {
		return this.sportByOrderReceivesport;
	}

	public void setSportByOrderReceivesport(Sport sportByOrderReceivesport) {
		this.sportByOrderReceivesport = sportByOrderReceivesport;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_sendsport", nullable = false)
	public Sport getSportByOrderSendsport() {
		return this.sportByOrderSendsport;
	}

	public void setSportByOrderSendsport(Sport sportByOrderSendsport) {
		this.sportByOrderSendsport = sportByOrderSendsport;
	}

	@Column(name = "order_money", nullable = false, precision = 22, scale = 0)
	public Double getOrderMoney() {
		return this.orderMoney;
	}

	public void setOrderMoney(Double orderMoney) {
		this.orderMoney = orderMoney;
	}

	@Column(name = "order_weight", nullable = false, precision = 22, scale = 0)
	public Double getOrderWeight() {
		return this.orderWeight;
	}

	public void setOrderWeight(Double orderWeight) {
		this.orderWeight = orderWeight;
	}

	@Column(name = "orde_sendername", nullable = false, length = 20)
	public String getOrdeSendername() {
		return this.ordeSendername;
	}

	public void setOrdeSendername(String ordeSendername) {
		this.ordeSendername = ordeSendername;
	}

	@Column(name = "order_senderphone", nullable = false, length = 11)
	public String getOrderSenderphone() {
		return this.orderSenderphone;
	}

	public void setOrderSenderphone(String orderSenderphone) {
		this.orderSenderphone = orderSenderphone;
	}

	@Column(name = "order_tocity", nullable = false, length = 11)
	public String getOrderTocity() {
		return this.orderTocity;
	}

	public void setOrderTocity(String orderTocity) {
		this.orderTocity = orderTocity;
	}

	@Column(name = "order_tocounty", nullable = false)
	public String getOrderTocounty() {
		return this.orderTocounty;
	}

	public void setOrderTocounty(String orderTocounty) {
		this.orderTocounty = orderTocounty;
	}

	@Column(name = "order_receiverphone", nullable = false, length = 11)
	public String getOrderReceiverphone() {
		return this.orderReceiverphone;
	}

	public void setOrderReceiverphone(String orderReceiverphone) {
		this.orderReceiverphone = orderReceiverphone;
	}

	@Column(name = "order_receivername", nullable = false)
	public String getOrderReceivername() {
		return this.orderReceivername;
	}

	public void setOrderReceivername(String orderReceivername) {
		this.orderReceivername = orderReceivername;
	}

	@Column(name = "order_state", nullable = false, length = 20)
	public String getOrderState() {
		return this.orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	@Column(name = "order_sign", nullable = false, length = 5)
	public String getOrderSign() {
		return this.orderSign;
	}

	public void setOrderSign(String orderSign) {
		this.orderSign = orderSign;
	}

	@Column(name = "createtime", nullable = false, length = 19)
	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	@Column(name = "operate_id", nullable = false)
	public String getOperateId() {
		return this.operateId;
	}

	public void setOperateId(String operateId) {
		this.operateId = operateId;
	}

}