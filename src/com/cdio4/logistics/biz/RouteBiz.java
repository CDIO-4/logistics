package com.cdio4.logistics.biz;

import static org.hibernate.criterion.Example.create;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cdio4.logistics.dao.RouteDAO;
import com.cdio4.logistics.dao.SportDAO;
import com.cdio4.logistics.domain.PageBean;
import com.cdio4.logistics.domain.Route;
import com.cdio4.logistics.domain.Sport;
@Service("RouteBiz")
public class RouteBiz {
	@Autowired@Qualifier("RouteDAO")	
    public RouteDAO routeDao;

	public RouteDAO getRouteDao() {
		return routeDao;
	}

	public void setRouteDao(RouteDAO routeDao) {
		this.routeDao = routeDao;
	}
	
	public Map<String,Object> save(Route route){
		routeDao.save(route);
		return null;
		
	}
	public boolean findByExample(Route instance) {
	if(routeDao.findByExample(instance).size()>0){
		return true;
	}
	    return false;
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public int getTotalRows(DetachedCriteria dc){
		return routeDao.getTotalRows(dc);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public void splitPage(DetachedCriteria dc,PageBean pb){
		routeDao.splitPage(dc, pb);
	}
}
