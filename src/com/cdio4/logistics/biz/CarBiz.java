package com.cdio4.logistics.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cdio4.logistics.dao.CarDAO;
import com.cdio4.logistics.domain.Car;
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
	
	

}
