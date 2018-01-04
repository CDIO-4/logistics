package com.cdio4.logistics.dao;

import java.sql.Timestamp;
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

import com.cdio4.logistics.domain.LostOrder;

/**
 * A data access object (DAO) providing persistence and search support for
 * LostOrder entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.cdio4.logistics.domain.LostOrder
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class LostOrderDAO {
	private static final Logger log = LoggerFactory
			.getLogger(LostOrderDAO.class);
	// property constants
	public static final String LASTCAR_ID = "lastcarId";
	public static final String LOST_SPOT = "lostSpot";
	public static final String OPERATE_ID = "operateId";

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

	public void save(LostOrder transientInstance) {
		log.debug("saving LostOrder instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LostOrder persistentInstance) {
		log.debug("deleting LostOrder instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LostOrder findById(java.lang.String id) {
		log.debug("getting LostOrder instance with id: " + id);
		try {
			LostOrder instance = (LostOrder) getCurrentSession().get(
					"com.cdio4.logistics.domain.LostOrder", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<LostOrder> findByExample(LostOrder instance) {
		log.debug("finding LostOrder instance by example");
		try {
			List<LostOrder> results = (List<LostOrder>) getCurrentSession()
					.createCriteria("com.cdio4.logistics.domain.LostOrder")
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
		log.debug("finding LostOrder instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from LostOrder as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<LostOrder> findByLastcarId(Object lastcarId) {
		return findByProperty(LASTCAR_ID, lastcarId);
	}

	public List<LostOrder> findByLostSpot(Object lostSpot) {
		return findByProperty(LOST_SPOT, lostSpot);
	}

	public List<LostOrder> findByOperateId(Object operateId) {
		return findByProperty(OPERATE_ID, operateId);
	}

	public List findAll() {
		log.debug("finding all LostOrder instances");
		try {
			String queryString = "from LostOrder";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public LostOrder merge(LostOrder detachedInstance) {
		log.debug("merging LostOrder instance");
		try {
			LostOrder result = (LostOrder) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LostOrder instance) {
		log.debug("attaching dirty LostOrder instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LostOrder instance) {
		log.debug("attaching clean LostOrder instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LostOrderDAO getFromApplicationContext(ApplicationContext ctx) {
		return (LostOrderDAO) ctx.getBean("LostOrderDAO");
	}
}