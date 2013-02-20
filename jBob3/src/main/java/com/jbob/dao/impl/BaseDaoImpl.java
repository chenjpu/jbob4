package com.jbob.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jbob.dao.BaseDaoI;

@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDaoI<T> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(T o) {
		this.entityManager.persist(o);
	}

	@Override
	public T get(Class<T> c, Serializable id) {
		return (T) this.entityManager.find(c, id);
	}

	@Override
	public T get(String hql) {
		Query q = this.entityManager.createQuery(hql);
		return (T)q.getSingleResult();
	}

	@Override
	public T get(String hql, Map<String, Object> params) {
		Query q = this.entityManager.createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return (T)q.getSingleResult();
	}

	@Override
	public void delete(T o) {
		this.entityManager.remove(o);
	}

	@Override
	public void update(T o) {
		this.entityManager.merge(o);
	}

	@Override
	public void saveOrUpdate(T o) {
		this.entityManager.merge(o);
	}

	@Override
	public List<T> find(String hql) {
		Query q = this.entityManager.createQuery(hql);
		return (List<T>)q.getResultList();
	}

	@Override
	public List<T> find(String hql, Map<String, Object> params) {
		Query q = this.entityManager.createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return (List<T>)q.getResultList();
	}

	@Override
	public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
		Query q = this.entityManager.createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return (List<T>)q.setFirstResult((page - 1) * rows).setMaxResults(rows).getResultList();
	}

	@Override
	public List<T> find(String hql, int page, int rows) {
		Query q = this.entityManager.createQuery(hql);
		return (List<T>)q.setFirstResult((page - 1) * rows).setMaxResults(rows).getResultList();
	}

	@Override
	public Long count(String hql) {
		Query q = this.entityManager.createQuery(hql);
		return (Long) q.getSingleResult();
	}

	@Override
	public Long count(String hql, Map<String, Object> params) {
		Query q = this.entityManager.createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return (Long) q.getSingleResult();
	}

	@Override
	public int executeHql(String hql) {
		Query q = this.entityManager.createQuery(hql);
		return q.executeUpdate();
	}

	@Override
	public int executeHql(String hql, Map<String, Object> params) {
		Query q = this.entityManager.createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.executeUpdate();
	}

}
