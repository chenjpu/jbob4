package com.jbob.core.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jbob.core.Entity;
import com.jbob.core.GenericDao;
import com.jbob.core.sql.QueryFilter;

/**
 * 
 * @author chenjpu
 */
@SuppressWarnings("all")
public class HibernateGenericDao<T extends Entity, PK extends Serializable> extends HibernateDaoSupport implements
		GenericDao<T, PK> {
	
	protected Class<T> clazz;
	
	public HibernateGenericDao(Class<T> clazz) {
		this.clazz = clazz;
	}

	public  T select(PK id) throws DataAccessException {
		return super.getHibernateTemplate().get(clazz, id);
	}

	public List<T> select() throws DataAccessException {
		return executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(clazz).addOrder(Order.asc("id"));
				return criteria.list();
			}
		});
	}

	public List<T> select(final int skip, final int max) throws DataAccessException {
		return executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(clazz).addOrder(Order.asc("id"));
				criteria.setFirstResult(skip);
				criteria.setMaxResults(max);
				return criteria.list();
			}
		});
	}

	public int count() throws DataAccessException {
		return executeInt(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(clazz).setProjection(Projections.rowCount());
				return criteria.uniqueResult();
			}
		});
	}

	public void delete(final PK id) throws DataAccessException {
		delete(super.getHibernateTemplate().get(clazz, id));
	}
	
	public void delete(T entity) {
		super.getHibernateTemplate().delete(entity);
	}

	public T insert(T o) throws DataAccessException {
		super.getHibernateTemplate().save(o);
		return o;
	}

	public void update(T o) throws DataAccessException {
		super.getHibernateTemplate().update(o);
	}
	public void merge(T entity) {
		super.getHibernateTemplate().merge(entity);
	}
	
	public void evict(T entity) {
		super.getHibernateTemplate().evict(entity);
	}

	protected final <B> B execute(HibernateCallback hibernateCallback) throws DataAccessException {
		return (B) super.getHibernateTemplate().execute(hibernateCallback);
	}

	protected final <B> List<B> executeFind(HibernateCallback hibernateCallback) throws DataAccessException {
		return super.getHibernateTemplate().executeFind(hibernateCallback);
	}

	protected final int executeInt(HibernateCallback hibernateCallback) throws DataAccessException {
		return this.<Number> execute(hibernateCallback).intValue();
	}

	protected final long executeLong(HibernateCallback hibernateCallback) throws DataAccessException {
		return this.<Number> execute(hibernateCallback).longValue();
	}
	public List<T> getAll(QueryFilter filter) {
		return null;
	}
}