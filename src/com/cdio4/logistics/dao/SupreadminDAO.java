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

import com.cdio4.logistics.domain.Supreadmin;

/**
 * A data access object (DAO) providing persistence and search support for
 * Supreadmin entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.cdio4.logistics.domain.Supreadmin
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class SupreadminDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SupreadminDAO.class);
	// property constants
	public static final String SUPRE_ADMINNAME = "supreAdminname";
	public static final String SUPRE_AMINPHONE = "supreAminphone";
	public static final String SUPRE_ADMINADREESS = "supreAdminadreess";

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

	public void save(Supreadmin transientInstance) {
		log.debug("saving Supreadmin instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Supreadmin persistentInstance) {
		log.debug("deleting Supreadmin instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Supreadmin findById(java.lang.String id) {
		log.debug("getting Supreadmin instance with id: " + id);
		try {
			Supreadmin instance = (Supreadmin) getCurrentSession().get(
					"com.cdio4.logistics.domain.Supreadmin", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Supreadmin> findByExample(Supreadmin instance) {
		log.debug("finding Supreadmin instance by example");
		try {
			List<Supreadmin> results = (List<Supreadmin>) getCurrentSession()
					.createCriteria("com.cdio4.logistics.domain.Supreadmin")
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
		log.debug("finding Supreadmin instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Supreadmin as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Supreadmin> findBySupreAdminname(Object supreAdminname) {
		return findByProperty(SUPRE_ADMINNAME, supreAdminname);
	}

	public List<Supreadmin> findBySupreAminphone(Object supreAminphone) {
		return findByProperty(SUPRE_AMINPHONE, supreAminphone);
	}

	public List<Supreadmin> findBySupreAdminadreess(Object supreAdminadreess) {
		return findByProperty(SUPRE_ADMINADREESS, supreAdminadreess);
	}

	public List findAll() {
		log.debug("finding all Supreadmin instances");
		try {
			String queryString = "from Supreadmin";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Supreadmin merge(Supreadmin detachedInstance) {
		log.debug("merging Supreadmin instance");
		try {
			Supreadmin result = (Supreadmin) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Supreadmin instance) {
		log.debug("attaching dirty Supreadmin instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Supreadmin instance) {
		log.debug("attaching clean Supreadmin instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SupreadminDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SupreadminDAO) ctx.getBean("SupreadminDAO");
	}
}