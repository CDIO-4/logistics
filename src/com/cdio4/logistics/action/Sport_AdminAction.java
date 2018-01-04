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
import com.cdio4.logistics.domain.SportAdmin;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("struts-default")
@Namespace("/sport_admin")
@Controller
@Scope("prototype")
public class Sport_AdminAction extends ActionSupport implements SessionAware,
RequestAware {
	public Map<String, Object> request;
	public Map<String, Object> session;
	public SportAdmin admin;
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}

	public SportAdmin getAdmin() {
		return admin;
	}

	public void setAdmin(SportAdmin admin) {
		this.admin = admin;
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
	
	@Action(value = "adminlogin", results = {
			@Result(name = "success", location = "/sport_admin/login.jsp"),
			@Result(name = "error", location = "/sport_admin/login.jsp")
			}
	      
			)
	public String login(){
		Map<String, Object> map =abiz.findById(admin);
		if(map.get("login_result").equals("yes")){
			admin = (SportAdmin) map.get("admin");
			session.put("SportAdmin", admin);
			return "success";
		}
	request.put("login_result",map.get("login_result").toString());
		return "error";
	}

	

}
