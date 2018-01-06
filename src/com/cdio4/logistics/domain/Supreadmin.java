package com.cdio4.logistics.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Supreadmin entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "supreadmin", catalog = "logistics")
public class Supreadmin implements java.io.Serializable {

	// Fields

	private String supreAdminId;
	private String supreAdminname;
	private String supreAminphone;
	private String supreAdminadreess;

	// Constructors

	/** default constructor */
	public Supreadmin() {
	}

	/** full constructor */
	public Supreadmin(String supreAdminId, String supreAdminname,
			String supreAminphone, String supreAdminadreess) {
		this.supreAdminId = supreAdminId;
		this.supreAdminname = supreAdminname;
		this.supreAminphone = supreAminphone;
		this.supreAdminadreess = supreAdminadreess;
	}

	// Property accessors
	@Id
	@Column(name = "supre_adminId", unique = true, nullable = false, length = 20)
	public String getSupreAdminId() {
		return this.supreAdminId;
	}

	public void setSupreAdminId(String supreAdminId) {
		this.supreAdminId = supreAdminId;
	}

	@Column(name = "supre_adminname", nullable = false)
	public String getSupreAdminname() {
		return this.supreAdminname;
	}

	public void setSupreAdminname(String supreAdminname) {
		this.supreAdminname = supreAdminname;
	}

	@Column(name = "supre_aminphone", nullable = false, length = 11)
	public String getSupreAminphone() {
		return this.supreAminphone;
	}

	public void setSupreAminphone(String supreAminphone) {
		this.supreAminphone = supreAminphone;
	}

	@Column(name = "supre_adminadreess", nullable = false)
	public String getSupreAdminadreess() {
		return this.supreAdminadreess;
	}

	public void setSupreAdminadreess(String supreAdminadreess) {
		this.supreAdminadreess = supreAdminadreess;
	}

}