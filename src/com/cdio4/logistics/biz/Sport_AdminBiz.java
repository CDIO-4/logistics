package com.cdio4.logistics.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cdio4.logistics.dao.SportAdminDAO;
import com.cdio4.logistics.domain.SportAdmin;
@Service("Sport_AdminBiz")
public class Sport_AdminBiz {
	@Autowired@Qualifier("SportAdminDAO")
	public SportAdminDAO sdao;

	public SportAdminDAO getSdao() {
		return sdao;
	}

	public void setSdao(SportAdminDAO sdao) {
		this.sdao = sdao;
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public Map<String,Object>  findById(SportAdmin admin) {
	Map<String,Object> map=new HashMap<String,Object>();
	SportAdmin admin_biz = sdao.findById(admin.getAdminId());
	if(admin_biz !=null){
		map.put("admin",admin_biz);
		map.put("login_result","yes" );
	}else{
		map.put("login_result", "no");
	}
        return map;
	}

}
