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

import com.cdio4.logistics.domain.Order;

/**
 * A data access object (DAO) providing persistence and search support for Order
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.cdio4.logistics.domain.Order
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class OrderDAO {
	private static final Logger log = LoggerFactory.getLogger(OrderDAO.class);
	// property constants
	public static final String ORDER_MONEY = "orderMoney";
	public static final String ORDER_WEIGHT = "orderWeight";
	public static final String ORDE_SENDERNAME = "ordeSendername";
	public static final String ORDER_SENDERPHONE = "orderSenderphone";
	public static final String ORDER_TOCITY = "orderTocity";
	public static final String ORDER_TOCOUNTY = "orderTocounty";
	public static final String ORDER_RECEIVERPHONE = "orderReceiverphone";
	public static final String ORDER_RECEIVERNAME = "orderReceivername";
	public static final String ORDER_STATE = "orderState";
	public static final String ORDER_SIGN = "orderSign";
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

	public void save(Order transientInstance) {
		log.debug("saving Order instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Order persistentInstance) {
		log.debug("deleting Order instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Order findById(java.lang.String id) {
		log.debug("getting Order instance with id: " + id);
		try {
			Order instance = (Order) getCurrentSession().get(
					"com.cdio4.logistics.domain.Order", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Order> findByExample(Order instance) {
		log.debug("finding Order instance by example");
		try {
			List<Order> results = (List<Order>) getCurrentSession()
					.createCriteria("com.cdio4.logistics.domain.Order")
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
		log.debug("finding Order instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Order as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Order> findByOrderMoney(Object orderMoney) {
		return findByProperty(ORDER_MONEY, orderMoney);
	}

	public List<Order> findByOrderWeight(Object orderWeight) {
		return findByProperty(ORDER_WEIGHT, orderWeight);
	}

	public List<Order> findByOrdeSendername(Object ordeSendername) {
		return findByProperty(ORDE_SENDERNAME, ordeSendername);
	}

	public List<Order> findByOrderSenderphone(Object orderSenderphone) {
		return findByProperty(ORDER_SENDERPHONE, orderSenderphone);
	}

	public List<Order> findByOrderTocity(Object orderTocity) {
		return findByProperty(ORDER_TOCITY, orderTocity);
	}

	public List<Order> findByOrderTocounty(Object orderTocounty) {
		return findByProperty(ORDER_TOCOUNTY, orderTocounty);
	}

	public List<Order> findByOrderReceiverphone(Object orderReceiverphone) {
		return findByProperty(ORDER_RECEIVERPHONE, orderReceiverphone);
	}

	public List<Order> findByOrderReceivername(Object orderReceivername) {
		return findByProperty(ORDER_RECEIVERNAME, orderReceivername);
	}

	public List<Order> findByOrderState(Object orderState) {
		return findByProperty(ORDER_STATE, orderState);
	}

	public List<Order> findByOrderSign(Object orderSign) {
		return findByProperty(ORDER_SIGN, orderSign);
	}

	public List<Order> findByOperateId(Object operateId) {
		return findByProperty(OPERATE_ID, operateId);
	}

	public List findAll() {
		log.debug("finding all Order instances");
		try {
			String queryString = "from Order";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Order merge(Order detachedInstance) {
		log.debug("merging Order instance");
		try {
			Order result = (Order) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Order instance) {
		log.debug("attaching dirty Order instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Order instance) {
		log.debug("attaching clean Order instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static OrderDAO getFromApplicationContext(ApplicationContext ctx) {
		return (OrderDAO) ctx.getBean("OrderDAO");
	}
}