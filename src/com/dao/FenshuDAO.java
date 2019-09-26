package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.Fenshu;

/**
 * Data access object (DAO) for domain model class Fenshu.
 * 
 * @see com.model.Fenshu
 * @author MyEclipse Persistence Tools
 */

public class FenshuDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(FenshuDAO.class);

	// property constants
	public static final String FENSHU_FENSHU = "fenshuFenshu";

	public static final String FENSHU_TEA_ID = "fenshuTeaId";

	public static final String FENSHU_STU_ID = "fenshuStuId";

	public static final String SHIJIAN = "shijian";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Fenshu transientInstance)
	{
		log.debug("saving Fenshu instance");
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

	public void delete(Fenshu persistentInstance)
	{
		log.debug("deleting Fenshu instance");
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

	public Fenshu findById(java.lang.Integer id)
	{
		log.debug("getting Fenshu instance with id: " + id);
		try
		{
			Fenshu instance = (Fenshu) getHibernateTemplate().get(
					"com.model.Fenshu", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Fenshu instance)
	{
		log.debug("finding Fenshu instance by example");
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
		log.debug("finding Fenshu instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Fenshu as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFenshuFenshu(Object fenshuFenshu)
	{
		return findByProperty(FENSHU_FENSHU, fenshuFenshu);
	}

	public List findByFenshuTeaId(Object fenshuTeaId)
	{
		return findByProperty(FENSHU_TEA_ID, fenshuTeaId);
	}

	public List findByFenshuStuId(Object fenshuStuId)
	{
		return findByProperty(FENSHU_STU_ID, fenshuStuId);
	}

	public List findByShijian(Object shijian)
	{
		return findByProperty(SHIJIAN, shijian);
	}

	public List findAll()
	{
		log.debug("finding all Fenshu instances");
		try
		{
			String queryString = "from Fenshu";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Fenshu merge(Fenshu detachedInstance)
	{
		log.debug("merging Fenshu instance");
		try
		{
			Fenshu result = (Fenshu) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Fenshu instance)
	{
		log.debug("attaching dirty Fenshu instance");
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

	public void attachClean(Fenshu instance)
	{
		log.debug("attaching clean Fenshu instance");
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

	public static FenshuDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (FenshuDAO) ctx.getBean("FenshuDAO");
	}
}