package com.cdio4.logistics.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SportAdmin entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sport_admin", catalog = "logistics")
public class SportAdmin implements java.io.Serializable {

	// Fields

	private String adminId;
	private String adminName;
	private String adminPassword;
	private String adminOfsport;
	private String adminPhone;
	private String adminAdress;
	private String adminIdnumber;

	// Constructors

	/** default constructor */
	public SportAdmin() {
	}

	/** full constructor */
	public SportAdmin(String adminId, String adminName, String adminPassword,
			String adminOfsport, String adminPhone, String adminAdress,
			String adminIdnumber) {
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.adminOfsport = adminOfsport;
		this.adminPhone = adminPhone;
		this.adminAdress = adminAdress;
		this.adminIdnumber = adminIdnumber;
	}

	// Property accessors
	@Id
	@Column(name = "admin_id", unique = true, nullable = false)
	public String getAdminId() {
		return this.adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	@Column(name = "admin_name", nullable = false)
	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	@Column(name = "admin_password", nullable = false)
	public String getAdminPassword() {
		return this.adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Column(name = "admin_ofsport", nullable = false)
	public String getAdminOfsport() {
		return this.adminOfsport;
	}

	public void setAdminOfsport(String adminOfsport) {
		this.adminOfsport = adminOfsport;
	}

	@Column(name = "admin_phone", nullable = false, length = 11)
	public String getAdminPhone() {
		return this.adminPhone;
	}

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

	@Column(name = "admin_adress", nullable = false)
	public String getAdminAdress() {
		return this.adminAdress;
	}

	public void setAdminAdress(String adminAdress) {
		this.adminAdress = adminAdress;
	}

	@Column(name = "admin_IDNumber", nullable = false, length = 20)
	public String getAdminIdnumber() {
		return this.adminIdnumber;
	}

	public void setAdminIdnumber(String adminIdnumber) {
		this.adminIdnumber = adminIdnumber;
	}

}