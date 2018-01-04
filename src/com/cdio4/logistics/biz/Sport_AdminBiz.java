package com.cdio4.logistics.biz;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cdio4.logistics.dao.SportAdminDAO;
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
	public void findById(String id) {
			System.out.println("章显");
		 System.out.println(sdao.findById(id).getAdminName());
	}

}
