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

import com.cdio4.logistics.domain.TransportOrder;

/**
 * A data access object (DAO) providing persistence and search support for
 * TransportOrder entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.cdio4.logistics.domain.TransportOrder
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class TransportOrderDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TransportOrderDAO.class);
	// property constants

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

	public void save(TransportOrder transientInstance) {
		log.debug("saving TransportOrder instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TransportOrder persistentInstance) {
		log.debug("deleting TransportOrder instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TransportOrder findById(
			com.cdio4.logistics.domain.TransportOrderId id) {
		log.debug("getting TransportOrder instance with id: " + id);
		try {
			TransportOrder instance = (TransportOrder) getCurrentSession().get(
					"com.cdio4.logistics.domain.TransportOrder", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TransportOrder> findByExample(TransportOrder instance) {
		log.debug("finding TransportOrder instance by example");
		try {
			List<TransportOrder> results = (List<TransportOrder>) getCurrentSession()
					.createCriteria("com.cdio4.logistics.domain.TransportOrder")
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
		log.debug("finding TransportOrder instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TransportOrder as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TransportOrder instances");
		try {
			String queryString = "from TransportOrder";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TransportOrder merge(TransportOrder detachedInstance) {
		log.debug("merging TransportOrder instance");
		try {
			TransportOrder result = (TransportOrder) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TransportOrder instance) {
		log.debug("attaching dirty TransportOrder instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TransportOrder instance) {
		log.debug("attaching clean TransportOrder instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TransportOrderDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TransportOrderDAO) ctx.getBean("TransportOrderDAO");
	}
}