package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.Yijizhibiao;

/**
 * Data access object (DAO) for domain model class Yijizhibiao.
 * 
 * @see com.model.Yijizhibiao
 * @author MyEclipse Persistence Tools
 */

public class YijizhibiaoDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(YijizhibiaoDAO.class);

	// property constants
	public static final String YIJIZHIBIAO_NAME = "yijizhibiaoName";

	public static final String YIJIZHIBIAO_NEIRONG = "yijizhibiaoNeirong";

	public static final String YIJIZHIBIAO_QUANZHONG = "yijizhibiaoQuanzhong";

	public static final String YIJIZHIBIAO_FENSHU = "yijizhibiaoFenshu";

	public static final String DEL = "del";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Yijizhibiao transientInstance)
	{
		log.debug("saving Yijizhibiao instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Yijizhibiao persistentInstance)
	{
		log.debug("deleting Yijizhibiao instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public Yijizhibiao findById(java.lang.Integer id)
	{
		log.debug("getting Yijizhibiao instance with id: " + id);
		try
		{
			Yijizhibiao instance = (Yijizhibiao) getHibernateTemplate().get(
					"com.model.Yijizhibiao", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Yijizhibiao instance)
	{
		log.debug("finding Yijizhibiao instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding Yijizhibiao instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Yijizhibiao as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByYijizhibiaoName(Object yijizhibiaoName)
	{
		return findByProperty(YIJIZHIBIAO_NAME, yijizhibiaoName);
	}

	public List findByYijizhibiaoNeirong(Object yijizhibiaoNeirong)
	{
		return findByProperty(YIJIZHIBIAO_NEIRONG, yijizhibiaoNeirong);
	}

	public List findByYijizhibiaoQuanzhong(Object yijizhibiaoQuanzhong)
	{
		return findByProperty(YIJIZHIBIAO_QUANZHONG, yijizhibiaoQuanzhong);
	}

	public List findByYijizhibiaoFenshu(Object yijizhibiaoFenshu)
	{
		return findByProperty(YIJIZHIBIAO_FENSHU, yijizhibiaoFenshu);
	}

	public List findByDel(Object del)
	{
		return findByProperty(DEL, del);
	}

	public List findAll()
	{
		log.debug("finding all Yijizhibiao instances");
		try
		{
			String queryString = "from Yijizhibiao";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Yijizhibiao merge(Yijizhibiao detachedInstance)
	{
		log.debug("merging Yijizhibiao instance");
		try
		{
			Yijizhibiao result = (Yijizhibiao) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Yijizhibiao instance)
	{
		log.debug("attaching dirty Yijizhibiao instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Yijizhibiao instance)
	{
		log.debug("attaching clean Yijizhibiao instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static YijizhibiaoDAO getFromApplicationContext(
			ApplicationContext ctx)
	{
		return (YijizhibiaoDAO) ctx.getBean("YijizhibiaoDAO");
	}
}