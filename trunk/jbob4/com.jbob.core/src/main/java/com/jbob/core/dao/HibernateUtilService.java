/*
 * 文件名称：ddddd.java 创建日期：2006-9-7
 * 版权所有：J.Bob
 */

package com.jbob.core.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.jbob.core.BusinessAccessException;
import com.jbob.core.ObjectRetrievalFailureException;
import com.jbob.core.Pageable;

/**
 * 通用管理接口的实现，这个类是一个抽象类。用户自己定义的服务需要继承这个对象
 * 
 * @author chenjpu
 */
@SuppressWarnings("unchecked")
public abstract class HibernateUtilService {

	protected final Log logger = LogFactory.getLog(getClass());

	protected abstract HibernateTemplate getHibernateTemplate();

	protected final <T> T find(Class clazz, Serializable id) throws BusinessAccessException {
		return this.<T> exists(clazz, this.<T> select(clazz, id), id);
	}

	protected final <T> T find(String entityName, Serializable id) throws BusinessAccessException {
		return (T) this.getHibernateTemplate().get(entityName, id);
	}

	protected final <T> T exists(T t, Object id) throws BusinessAccessException {
		return exists("UNKNOW", t, id);
	}

	protected final <T> T exists(Class<?> persistentClass, T t, Object id) throws BusinessAccessException {
		return exists(persistentClass.getName(), t, id);
	}

	protected final <T> T exists(String persistentClass, T t, Object id) throws BusinessAccessException {
		if (t == null) {
			throw new ObjectRetrievalFailureException(persistentClass, id);
		}
		return t;
	}

	protected final <T> Serializable insert(T o) throws DataAccessException {
		return this.getHibernateTemplate().save(o);
	}

	protected final <T> Serializable insert(String entityName, T o) throws DataAccessException {
		return this.getHibernateTemplate().save(entityName, o);
	}

	protected final <T> void saveOrUpdate(T o) throws DataAccessException {
		this.getHibernateTemplate().saveOrUpdate(o);
	}

	protected final <T> void saveOrUpdate(String entityName, T o) throws DataAccessException {
		this.getHibernateTemplate().saveOrUpdate(entityName, o);
	}

	protected final <T> T select(Class<?> clazz, Serializable id) throws DataAccessException {
		return (T) this.getHibernateTemplate().get(clazz, id);
	}

	protected final <T> List<T> select(final Class<?> clazz) throws DataAccessException {
		return executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(clazz).addOrder(Order.asc("id"));
				return criteria.list();
			}
		});
	}

	protected final <T> List<T> select(final Class<?> clazz, final int skip, final int max) throws DataAccessException {
		return executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(clazz).addOrder(Order.asc("id"));
				criteria.setFirstResult(skip);
				criteria.setMaxResults(max);
				return criteria.list();
			}
		});
	}

	protected final Pageable selectPageable(final Class<?> clazz, int page, int pageSize) throws BusinessAccessException {
		int length = this.count(clazz);
		page = realPage(page, pageSize, length);
		List<?> data = select(clazz, (page - 1) * pageSize, pageSize);
		return new Pageable(page, pageSize, length, data);
	}

	protected final List select(final String hql, final int skip, final int max) throws DataAccessException {
		return executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hql);
				query.setFirstResult(skip);
				query.setMaxResults(max);
				return query.list();
			}
		});
	}

	protected final int count(final Class<?> clazz) throws DataAccessException {
		return executeInt(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(clazz).setProjection(Projections.rowCount());
				return criteria.uniqueResult();
			}
		});
	}

	/**
	 * 
	 * @author huangzhihui
	 * @param hql
	 * @return
	 * @throws DataAccessException
	 */
	protected final int count(final String hql) throws DataAccessException {
		return executeInt(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				if (hql.indexOf("distinct") > 0) {
					Query query = session.createQuery(hql);
					List lst = query.list();
					if (lst.isEmpty()) {
						return 0;
					}
					return lst.size();
				} else {
					String sql = "select count(*) ";
					sql = sql + hql.substring(hql.indexOf("from"));
					Query query = session.createQuery(sql);
					return ((Number) query.uniqueResult()).intValue();
				}
			}
		});
	}

	protected final Pageable find(int page, int pageSize, String hql) throws BusinessAccessException {
		int length = this.count(hql);
		page = realPage(page, pageSize, length);
		List<?> data = select(hql, (page - 1) * pageSize, pageSize);
		return new Pageable(page, pageSize, length, data);
	}

	protected final void delete(Class<?> clazz, Serializable id) throws DataAccessException {
		delete(clazz.getName(), id);
	}

	protected final void delete(final String entityName, final Serializable id) throws DataAccessException {
		execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				//Query query = session.createQuery("delete from " + entityName + " as d_ob where d_ob.id=:id");
				//query.setParameter("id", id);
				Object object = session.get(entityName, id);
				if (null != object) {
					session.delete(object);
				}
				return null;
			}
		});
	}

	protected final <T> T execute(HibernateCallback hibernateCallback) throws DataAccessException {
		return (T) getHibernateTemplate().execute(hibernateCallback);
	}

	protected final <T> List<T> executeFind(HibernateCallback hibernateCallback) throws DataAccessException {
		return getHibernateTemplate().executeFind(hibernateCallback);
	}

	protected final int executeInt(HibernateCallback hibernateCallback) throws DataAccessException {
		Number number = this.<Number> execute(hibernateCallback);
		return number != null ? number.intValue() : 0;
	}

	protected final long executeLong(HibernateCallback hibernateCallback) throws DataAccessException {
		Number number = this.<Number> execute(hibernateCallback);
		return number != null ? number.longValue() : 0;
	}

	protected final float executeFloat(HibernateCallback hibernateCallback) throws DataAccessException {
		Number number = this.<Number> execute(hibernateCallback);
		return number != null ? number.floatValue() : 0;
	}

	protected final double executeDouble(HibernateCallback hibernateCallback) throws DataAccessException {
		Number number = this.<Number> execute(hibernateCallback);
		return number != null ? number.doubleValue() : 0;
	}

	/**
		 * 计算合法的页面
		 * @param page
		 * @param pageSize
		 * @param length
		 * @return
		 */
	protected final int realPage(int page, int pageSize, int length) {
		if ((page - 1) * pageSize > length) {
			page = (length + pageSize - 1) / pageSize;
		}
		return page;
	}
}
