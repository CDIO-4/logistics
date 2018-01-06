package com.cdio4.logistics.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cdio4.logistics.dao.SportDAO;
import com.cdio4.logistics.domain.PageBean;
import com.cdio4.logistics.domain.Sport;
@Service("SportBiz")
public class SportBiz {
	public SportDAO getSportDao() {
		return sportDao;
	}

	public void setSportDao(SportDAO sportDao) {
		this.sportDao = sportDao;
	}
	@Autowired@Qualifier("SportDAO")	
    public SportDAO sportDao;
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public Sport findById(String id) {
		   return sportDao.findById(id);
		}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public Map<String,Object> findBySportCity(Object sportCity) {
		Map<String,Object> map=new HashMap<String,Object>();
		try{
	Sport sport = sportDao.findBySportCity(sportCity).get(0);
	       map.put("sport", sport);
	       
		}catch(Exception e){
			map.put("hassport","no");
		}
		return map;
	}
	
}
