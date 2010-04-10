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

	public <B> B select(Class<?> clazz, Serializable id) throws DataAccessException {
		return (B) super.getHibernateTemplate().get(clazz, id);
	}

	public <B> List<B> select(final Class<?> clazz) throws DataAccessException {
		return executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(clazz).addOrder(Order.asc("id"));
				return criteria.list();
			}
		});
	}

	public <B> List<B> select(final Class<?> clazz, final int skip, final int max) throws DataAccessException {
		return executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(clazz).addOrder(Order.asc("id"));
				criteria.setFirstResult(skip);
				criteria.setMaxResults(max);
				return criteria.list();
			}
		});
	}

	public int count(final Class<?> clazz) throws DataAccessException {
		return executeInt(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(clazz).setProjection(Projections.rowCount());
				return criteria.uniqueResult();
			}
		});
	}

	public void delete(final Class<?> clazz, final Serializable id) throws DataAccessException {
		execute(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("delete from " + clazz.getSimpleName() + " where id=:id");
				query.setParameter("id", id);
				return query.executeUpdate();
			}
		});
	}

	public <B> Serializable insert(B o) throws DataAccessException {
		return super.getHibernateTemplate().save(o);
	}

	public <B> void update(B o) throws DataAccessException {
		super.getHibernateTemplate().update(o);
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

	@Override
	public int count() {
		return 0;
	}

	@Override
	public void delete(PK id) {
		
	}

	@Override
	public void delete(T entity) {
		
	}

	@Override
	public T insert(T entity) {
		super.getHibernateTemplate().save(entity);
		return entity;
	}

	@Override
	public void merge(T entity) {
		
	}

	@Override
	public T select(PK id) {
		return null;
	}

	@Override
	public List<T> select() {
		return null;
	}

	@Override
	public List<T> select(int skip, int max) {
		return null;
	}

	@Override
	public void update(T entity) {
		
	}

	@Override
	public List<T> getAll(QueryFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}
	
}