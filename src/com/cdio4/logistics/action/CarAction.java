package com.cdio4.logistics.action;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cdio4.logistics.biz.CarBiz;
import com.cdio4.logistics.domain.Car;
import com.cdio4.logistics.domain.PageBean;
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
	public PageBean pb=new PageBean();
	public int p=1;
	
	public String carNumber;
	public String carModel;
	public Double weightLow;
	public Double weightHight;
	public String carId;
	
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
	@Action(value="CarEdit",results={
			@Result(name="success",location="/sport_admin/car_edit.jsp")
	})
	public String CarEdit(){
		Car car=this.carBiz.findById(carId);
		session.put("car", car);
		return SUCCESS;
	}
	@Action(value="CarList",results={
			@Result(name="success",location="/sport_admin/car_list.jsp")
	})
	public String CarList(){
		DetachedCriteria dc=DetachedCriteria.forClass(Car.class);
		
		if(p<1||p>pb.getTotalPage()){
			
		}else{
			pb.setCurrentPage(p);
		}
		if(carNumber!=null){
			dc.add(Restrictions.like("carId", carNumber ,MatchMode.ANYWHERE));
		}
		if(carModel!=null){
			dc.add(Restrictions.like("carModel", carModel ,MatchMode.ANYWHERE));
		}
		if(weightLow!=null&&weightHight!=null){
			dc.add(Restrictions.between("carweight", weightLow, weightHight));
		}else if(weightLow==null&&weightHight!=null){
			dc.add(Restrictions.le("carweight", weightHight));
			
		}else if(weightLow!=null&&weightHight==null){
			dc.add(Restrictions.ge("carweight", weightLow));
		}
		pb.setTotalRows(this.carBiz.getTotalRows(dc));
		DetachedCriteria dc1=DetachedCriteria.forClass(Car.class);
		if(p<1||p>pb.getTotalPage()){
			
		}else{
			pb.setCurrentPage(p);
		}
		if(carNumber!=null){
			dc1.add(Restrictions.like("carId", carNumber ,MatchMode.ANYWHERE));
		}
		if(carModel!=null){
			dc1.add(Restrictions.like("carModel", carModel ,MatchMode.ANYWHERE));
		}
		if(weightLow!=null&&weightHight!=null){
			dc1.add(Restrictions.between("carweight", weightLow, weightHight));
		}else if(weightLow==null&&weightHight!=null){
			dc1.add(Restrictions.le("carweight", weightHight));
			
		}else if(weightLow!=null&&weightHight==null){
			dc1.add(Restrictions.ge("carweight", weightLow));
		}
		this.carBiz.getCarSpilt(dc1, pb);
		session.put("pb", pb);
		return SUCCESS;
	}
	@Action(value="addCar",results={
			@Result(name="success",type="redirectAction" , location="CarList")
	})
	public String addCar(){
		
		this.car.setIfFree("true");
		this.carBiz.save(this.car);
		
		return SUCCESS;
	}
	
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) throws UnsupportedEncodingException {
		this.carId = new String (carId.getBytes("iso-8859-1"),"utf-8");
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
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public Double getWeightLow() {
		return weightLow;
	}
	public void setWeightLow(Double weightLow) {
		this.weightLow = weightLow;
	}
	public Double getWeightHight() {
		return weightHight;
	}
	public void setWeightHight(Double weightHight) {
		this.weightHight = weightHight;
	}
	
	
	
	
}
