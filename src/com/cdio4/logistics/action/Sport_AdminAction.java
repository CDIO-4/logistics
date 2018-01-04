package com.cdio4.logistics.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cdio4.logistics.biz.Sport_AdminBiz;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("struts-default")
@Namespace("/sport_admin")
@Controller
@Scope("prototype")
public class Sport_AdminAction extends ActionSupport implements SessionAware,
RequestAware {
	public Map<String, Object> request;
	public Map<String, Object> session;
	public String adminId;
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	@Autowired
	@Qualifier("Sport_AdminBiz")
	private Sport_AdminBiz abiz;
	public Sport_AdminBiz getAbiz() {
		return abiz;
	}

	public void setAbiz(Sport_AdminBiz abiz) {
		this.abiz = abiz;
	}
	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	@Action(value = "adminlogin", results = {
			@Result(name = "success", location = "/admin/login") })
	public String login(){
		abiz.findById(adminId);
		return "success";
	}

	

}
