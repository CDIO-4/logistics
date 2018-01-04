package com.cdio4.logistics.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.cdio4.logistics.domain.SportAdmin;

/**
 * A data access object (DAO) providing persistence and search support for
 * SportAdmin entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.cdio4.logistics.domain.SportAdmin
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class SportAdminDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SportAdminDAO.class);
	// property constants
	public static final String ADMIN_NAME = "adminName";
	public static final String ADMIN_PASSWORD = "adminPassword";
	public static final String ADMIN_OFSPORT = "adminOfsport";
	public static final String ADMIN_PHONE = "adminPhone";
	public static final String ADMIN_ADRESS = "adminAdress";
	public static final String ADMIN_IDNUMBER = "adminIdnumber";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(SportAdmin transientInstance) {
		log.debug("saving SportAdmin instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SportAdmin persistentInstance) {
		log.debug("deleting SportAdmin instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SportAdmin findById(java.lang.String id) {
		System.out.println("殷献博");
		log.debug("getting SportAdmin instance with id: " + id);
		try {
			SportAdmin instance = (SportAdmin) getCurrentSession().get(
					"com.cdio4.logistics.domain.SportAdmin", id);
			System.out.println("殷献博");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<SportAdmin> findByExample(SportAdmin instance) {
		log.debug("finding SportAdmin instance by example");
		try {
			List<SportAdmin> results = (List<SportAdmin>) getCurrentSession()
					.createCriteria("com.cdio4.logistics.domain.SportAdmin")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding SportAdmin instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SportAdmin as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<SportAdmin> findByAdminName(Object adminName) {
		return findByProperty(ADMIN_NAME, adminName);
	}

	public List<SportAdmin> findByAdminPassword(Object adminPassword) {
		return findByProperty(ADMIN_PASSWORD, adminPassword);
	}

	public List<SportAdmin> findByAdminOfsport(Object adminOfsport) {
		return findByProperty(ADMIN_OFSPORT, adminOfsport);
	}

	public List<SportAdmin> findByAdminPhone(Object adminPhone) {
		return findByProperty(ADMIN_PHONE, adminPhone);
	}

	public List<SportAdmin> findByAdminAdress(Object adminAdress) {
		return findByProperty(ADMIN_ADRESS, adminAdress);
	}

	public List<SportAdmin> findByAdminIdnumber(Object adminIdnumber) {
		return findByProperty(ADMIN_IDNUMBER, adminIdnumber);
	}

	public List findAll() {
		log.debug("finding all SportAdmin instances");
		try {
			String queryString = "from SportAdmin";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SportAdmin merge(SportAdmin detachedInstance) {
		log.debug("merging SportAdmin instance");
		try {
			SportAdmin result = (SportAdmin) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SportAdmin instance) {
		log.debug("attaching dirty SportAdmin instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SportAdmin instance) {
		log.debug("attaching clean SportAdmin instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SportAdminDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SportAdminDAO) ctx.getBean("SportAdminDAO");
	}
}