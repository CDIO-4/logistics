package com.cdio4.logistics.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.cdio4.logistics.domain.Car;

/**
 * A data access object (DAO) providing persistence and search support for Car
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.cdio4.logistics.domain.Car
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class CarDAO {
	private static final Logger log = LoggerFactory.getLogger(CarDAO.class);
	// property constants
	public static final String IF_FREE = "ifFree";
	public static final String CURRRENTSPOT = "currrentspot";
	public static final String CARWEIGHT = "carweight";
	public static final String DRIVER_ID = "driverId";
	public static final String DRIVERPHONE = "driverphone";
	public static final String DRIVERADRESS = "driveradress";

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

	public void save(Car transientInstance) {
		log.debug("saving Car instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Car persistentInstance) {
		log.debug("deleting Car instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Car findById(java.lang.String id) {
		log.debug("getting Car instance with id: " + id);
		try {
			Car instance = (Car) getCurrentSession().get(
					"com.cdio4.logistics.domain.Car", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Car> findByExample(Car instance) {
		log.debug("finding Car instance by example");
		try {
			List<Car> results = (List<Car>) getCurrentSession()
					.createCriteria("com.cdio4.logistics.domain.Car")
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
		log.debug("finding Car instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Car as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Car> findByIfFree(Object ifFree) {
		return findByProperty(IF_FREE, ifFree);
	}

	public List<Car> findByCurrrentspot(Object currrentspot) {
		return findByProperty(CURRRENTSPOT, currrentspot);
	}

	public List<Car> findByCarweight(Object carweight) {
		return findByProperty(CARWEIGHT, carweight);
	}

	public List<Car> findByDriverId(Object driverId) {
		return findByProperty(DRIVER_ID, driverId);
	}

	public List<Car> findByDriverphone(Object driverphone) {
		return findByProperty(DRIVERPHONE, driverphone);
	}

	public List<Car> findByDriveradress(Object driveradress) {
		return findByProperty(DRIVERADRESS, driveradress);
	}

	public List findAll() {
		log.debug("finding all Car instances");
		try {
			String queryString = "from Car";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Car merge(Car detachedInstance) {
		log.debug("merging Car instance");
		try {
			Car result = (Car) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Car instance) {
		log.debug("attaching dirty Car instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Car instance) {
		log.debug("attaching clean Car instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CarDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CarDAO) ctx.getBean("CarDAO");
	}
}