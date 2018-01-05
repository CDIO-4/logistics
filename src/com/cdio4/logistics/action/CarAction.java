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

import com.cdio4.logistics.biz.CarBiz;
import com.cdio4.logistics.domain.Car;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("struts-default")
@Namespace("/sport_admin")
@Controller
@Scope("prototype")
public class CarAction extends ActionSupport implements SessionAware,
RequestAware{
	public Map<String, Object> request;
	public Map<String, Object> session;
	@Autowired@Qualifier("CarBiz")
	public CarBiz carBiz;
	public Car car;
	
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
	@Action(value="addCar",results={
			/*@Result(name="success",l)*/
	})
	public String addCar(){
		
		this.car.setIfFree("true");
		this.carBiz.save(this.car);
		
		return SUCCESS;
	}
	public CarBiz getCarBiz() {
		return carBiz;
	}
	public void setCarBiz(CarBiz carBiz) {
		this.carBiz = carBiz;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
}
