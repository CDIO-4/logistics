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

import com.cdio4.logistics.domain.TransportLine;

/**
 * A data access object (DAO) providing persistence and search support for
 * TransportLine entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.cdio4.logistics.domain.TransportLine
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class TransportLineDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TransportLineDAO.class);
	// property constants
	public static final String ORDINAL = "ordinal";

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

	public void save(TransportLine transientInstance) {
		log.debug("saving TransportLine instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TransportLine persistentInstance) {
		log.debug("deleting TransportLine instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TransportLine findById(com.cdio4.logistics.domain.TransportLineId id) {
		log.debug("getting TransportLine instance with id: " + id);
		try {
			TransportLine instance = (TransportLine) getCurrentSession().get(
					"com.cdio4.logistics.domain.TransportLine", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TransportLine> findByExample(TransportLine instance) {
		log.debug("finding TransportLine instance by example");
		try {
			List<TransportLine> results = (List<TransportLine>) getCurrentSession()
					.createCriteria("com.cdio4.logistics.domain.TransportLine")
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
		log.debug("finding TransportLine instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TransportLine as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TransportLine> findByOrdinal(Object ordinal) {
		return findByProperty(ORDINAL, ordinal);
	}

	public List findAll() {
		log.debug("finding all TransportLine instances");
		try {
			String queryString = "from TransportLine";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TransportLine merge(TransportLine detachedInstance) {
		log.debug("merging TransportLine instance");
		try {
			TransportLine result = (TransportLine) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TransportLine instance) {
		log.debug("attaching dirty TransportLine instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TransportLine instance) {
		log.debug("attaching clean TransportLine instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TransportLineDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TransportLineDAO) ctx.getBean("TransportLineDAO");
	}
}