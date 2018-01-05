package com.cdio4.logistics.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cdio4.logistics.biz.SportBiz;
import com.cdio4.logistics.biz.CarBiz;
import com.cdio4.logistics.biz.RouteBiz;
import com.cdio4.logistics.domain.Car;
import com.cdio4.logistics.domain.PageBean;
import com.cdio4.logistics.domain.Route;
import com.cdio4.logistics.domain.Sport;
import com.cdio4.logistics.domain.SportAdmin;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
@Namespace("/sport_admin")
@Controller
@Scope("prototype")
public class routeAction  extends ActionSupport implements SessionAware,
RequestAware{
	public Map<String, Object> request;
	public Map<String, Object> session;
	public Route route ;
	public int page;
	public PageBean pb = new PageBean();
	@Autowired@Qualifier("RouteBiz")
	public RouteBiz routeBiz;
	@Autowired@Qualifier("SportBiz")
	public SportBiz SportBiz;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	@Override
	public void setSession(Map<String, Object> session) {
	this.session = session;
		
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	
	public RouteBiz getRouteBiz() {
		return routeBiz;
	}
	public void setRouteBiz(RouteBiz routeBiz) {
		this.routeBiz = routeBiz;
	}
	public SportBiz getSportBiz() {
		return SportBiz;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public void setSportBiz(SportBiz sportBiz) {
		SportBiz = sportBiz;
	}
	@Action(value = "route_add", results = {
			@Result(name = "success", location = "/sport_admin/route_add.jsp"),
			@Result(name = "error", location = "/sport_admin/login.jsp")
			})
	public String save(){
	SportAdmin sportAdmin = (SportAdmin) session.get("SportAdmin");
	Map<String, Object> map =SportBiz.findBySportCity(route.getLineEnd());
	if(map.get("hassport").equals("no")){
		return "error";//站点不存在
	}
	Sport sport = SportBiz.findById(sportAdmin.getAdminOfsport());
	route.setLineStart(sport.getSportCity());
	String startCity= sport.getSportCity();
	route.setSport(sport);
	if(routeBiz.findByExample(route)){
		return "error";//路线已经存在
	}
	routeBiz.save(route);
	sport = (Sport) map.get("sport");
	route.setLineEnd(startCity);
	route.setLineStart(sport.getSportCity());
	route.setSport(sport);
	routeBiz.save(route);
	System.out.println("sportCity"+5555);
		return "success";
	}
	@Action(value = "route_Page", results = {
			@Result(name = "success", location = "/sport_admin/route_list.jsp"),
			@Result(name = "error", location = "/sport_admin/login.jsp")
			})	
 public String routePage(){
	 pb.setCurrentPage(page);
	 SportAdmin sportAdmin = (SportAdmin) session.get("SportAdmin");
	 Sport sport = SportBiz.findById(sportAdmin.getAdminOfsport());
	 DetachedCriteria dc = DetachedCriteria.forClass(Route.class);
	 dc.add(Restrictions.eq("lineId",1));
	 pb.setTotalRows(routeBiz.getTotalRows(dc));

	 DetachedCriteria dc1 = DetachedCriteria.forClass(Route.class);
	 routeBiz.splitPage(dc1, pb);
	 
	 Sport s = (Sport)pb.getList().get(0);
	 System.out.println("s.getSportCity():"+s.getSportCity());
	 session.put("pb", pb);
	return "success";
 }
}
