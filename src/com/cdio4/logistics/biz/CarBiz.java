package com.cdio4.logistics.biz;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cdio4.logistics.dao.CarDAO;
import com.cdio4.logistics.domain.Car;
import com.cdio4.logistics.domain.PageBean;
@Service("CarBiz")
public class CarBiz {
	@Autowired@Qualifier("CarDAO")
	public CarDAO carDao;

	public CarDAO getCarDao() {
		return carDao;
	}

	public void setCarDao(CarDAO carDao) {
		this.carDao = carDao;
	}
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
	public void save(Car transientInstance) {
		this.carDao.save(transientInstance);;
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public void getCarSpilt(DetachedCriteria dc,PageBean pb){
		this.carDao.getPageList(dc, pb);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public int getTotalRows(DetachedCriteria dc){
		return this.carDao.getTotalRows(dc);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public Car findById(java.lang.String id) {
		return this.carDao.findById(id);
	}
	

}
