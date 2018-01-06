package com.cdio4.logistics.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.cdio4.logistics.domain.Sport;
import com.cdio4.logistics.domain.PageBean;

/**
 * A data access object (DAO) providing persistence and search support for Sport
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.cdio4.logistics.domain.Sport
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class SportDAO {
	private static final Logger log = LoggerFactory.getLogger(SportDAO.class);
	// property constants
	public static final String SPORT_POSTCODE = "sportPostcode";
	public static final String SPORT_CITY = "sportCity";
	public static final String SPORT_DETAILADDRESS = "sportDetailaddress";
	public static final String SPORT_PHONE = "sportPhone";

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

	public void save(Sport transientInstance) {
		log.debug("saving Sport instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Sport persistentInstance) {
		log.debug("deleting Sport instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Sport findById(java.lang.String id) {
		log.debug("getting Sport instance with id: " + id);
		try {
			Sport instance = (Sport) getCurrentSession().get(
					"com.cdio4.logistics.domain.Sport", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Sport> findByExample(Sport instance) {
		log.debug("finding Sport instance by example");
		try {
			List<Sport> results = (List<Sport>) getCurrentSession()
					.createCriteria("com.cdio4.logistics.domain.Sport")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<Sport> findByProperty(String propertyName, Object value) {
		log.debug("finding Sport instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Sport as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Sport> findBySportPostcode(Object sportPostcode) {
		return findByProperty(SPORT_POSTCODE, sportPostcode);
	}

	public List<Sport> findBySportCity(Object sportCity) {
		return findByProperty(SPORT_CITY, sportCity);
	}

	public List<Sport> findBySportDetailaddress(Object sportDetailaddress) {
		return findByProperty(SPORT_DETAILADDRESS, sportDetailaddress);
	}

	public List<Sport> findBySportPhone(Object sportPhone) {
		return findByProperty(SPORT_PHONE, sportPhone);
	}

	public List findAll() {
		log.debug("finding all Sport instances");
		try {
			String queryString = "from Sport";
			System.out.println("章显");
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Sport merge(Sport detachedInstance) {
		log.debug("merging Sport instance");
		try {
			Sport result = (Sport) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Sport instance) {
		log.debug("attaching dirty Sport instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Sport instance) {
		log.debug("attaching clean Sport instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
}