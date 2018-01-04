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

import com.cdio4.logistics.domain.Transport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Transport entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.cdio4.logistics.domain.Transport
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class TransportDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TransportDAO.class);
	// property constants
	public static final String NEXTSPORT = "nextsport";
	public static final String DESTINATION = "destination";
	public static final String IF_ARRAIVE = "ifArraive";

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

	public void save(Transport transientInstance) {
		log.debug("saving Transport instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Transport persistentInstance) {
		log.debug("deleting Transport instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Transport findById(com.cdio4.logistics.domain.TransportId id) {
		log.debug("getting Transport instance with id: " + id);
		try {
			Transport instance = (Transport) getCurrentSession().get(
					"com.cdio4.logistics.domain.Transport", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Transport> findByExample(Transport instance) {
		log.debug("finding Transport instance by example");
		try {
			List<Transport> results = (List<Transport>) getCurrentSession()
					.createCriteria("com.cdio4.logistics.domain.Transport")
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
		log.debug("finding Transport instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Transport as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Transport> findByNextsport(Object nextsport) {
		return findByProperty(NEXTSPORT, nextsport);
	}

	public List<Transport> findByDestination(Object destination) {
		return findByProperty(DESTINATION, destination);
	}

	public List<Transport> findByIfArraive(Object ifArraive) {
		return findByProperty(IF_ARRAIVE, ifArraive);
	}

	public List findAll() {
		log.debug("finding all Transport instances");
		try {
			String queryString = "from Transport";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Transport merge(Transport detachedInstance) {
		log.debug("merging Transport instance");
		try {
			Transport result = (Transport) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Transport instance) {
		log.debug("attaching dirty Transport instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Transport instance) {
		log.debug("attaching clean Transport instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TransportDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TransportDAO) ctx.getBean("TransportDAO");
	}
}