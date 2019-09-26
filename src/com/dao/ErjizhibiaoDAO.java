package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.Erjizhibiao;

/**
 * Data access object (DAO) for domain model class Erjizhibiao.
 * 
 * @see com.model.Erjizhibiao
 * @author MyEclipse Persistence Tools
 */

public class ErjizhibiaoDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(ErjizhibiaoDAO.class);

	// property constants
	public static final String ERJIZHIBIAO_NAME = "erjizhibiaoName";

	public static final String ERJIZHIBIAO_NEIRONG = "erjizhibiaoNeirong";

	public static final String ERJIZHIBIAO_QUANZHONG = "erjizhibiaoQuanzhong";

	public static final String ERJIZHIBIAO_FENSHU = "erjizhibiaoFenshu";

	public static final String YIJIZHIBIAO_ID = "yijizhibiaoId";

	public static final String DEL = "del";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Erjizhibiao transientInstance)
	{
		log.debug("saving Erjizhibiao instance");
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

	public void delete(Erjizhibiao persistentInstance)
	{
		log.debug("deleting Erjizhibiao instance");
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

	public Erjizhibiao findById(java.lang.Integer id)
	{
		log.debug("getting Erjizhibiao instance with id: " + id);
		try
		{
			Erjizhibiao instance = (Erjizhibiao) getHibernateTemplate().get(
					"com.model.Erjizhibiao", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Erjizhibiao instance)
	{
		log.debug("finding Erjizhibiao instance by example");
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
		log.debug("finding Erjizhibiao instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Erjizhibiao as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByErjizhibiaoName(Object erjizhibiaoName)
	{
		return findByProperty(ERJIZHIBIAO_NAME, erjizhibiaoName);
	}

	public List findByErjizhibiaoNeirong(Object erjizhibiaoNeirong)
	{
		return findByProperty(ERJIZHIBIAO_NEIRONG, erjizhibiaoNeirong);
	}

	public List findByErjizhibiaoQuanzhong(Object erjizhibiaoQuanzhong)
	{
		return findByProperty(ERJIZHIBIAO_QUANZHONG, erjizhibiaoQuanzhong);
	}

	public List findByErjizhibiaoFenshu(Object erjizhibiaoFenshu)
	{
		return findByProperty(ERJIZHIBIAO_FENSHU, erjizhibiaoFenshu);
	}

	public List findByYijizhibiaoId(Object yijizhibiaoId)
	{
		return findByProperty(YIJIZHIBIAO_ID, yijizhibiaoId);
	}

	public List findByDel(Object del)
	{
		return findByProperty(DEL, del);
	}

	public List findAll()
	{
		log.debug("finding all Erjizhibiao instances");
		try
		{
			String queryString = "from Erjizhibiao";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Erjizhibiao merge(Erjizhibiao detachedInstance)
	{
		log.debug("merging Erjizhibiao instance");
		try
		{
			Erjizhibiao result = (Erjizhibiao) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Erjizhibiao instance)
	{
		log.debug("attaching dirty Erjizhibiao instance");
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

	public void attachClean(Erjizhibiao instance)
	{
		log.debug("attaching clean Erjizhibiao instance");
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

	public static ErjizhibiaoDAO getFromApplicationContext(
			ApplicationContext ctx)
	{
		return (ErjizhibiaoDAO) ctx.getBean("ErjizhibiaoDAO");
	}
}