package com.jbob.core.service;

import java.io.Serializable;
import java.util.List;

import com.jbob.core.BusinessAccessException;
import com.jbob.core.Entity;
import com.jbob.core.GenericDao;
import com.jbob.core.Pageable;
import com.jbob.core.Service;
import com.jbob.core.sql.QueryFilter;

public class GenericServiceImpl<T extends Entity, PK extends Serializable> implements Service<T, PK> {

	protected GenericDao<T, PK> dao = null;

	public void setDao(GenericDao<T, PK> dao) {
		this.dao = dao;
	}

	public GenericServiceImpl(GenericDao<T, PK> dao) {
		this.dao = dao;
	}

	public T get(PK id) {
		return (T) dao.select(id);
	}

	public T save(T entity) {
		return (T) dao.insert(entity);
	}

	public T merge(T entity) {
		dao.merge(entity);
		return entity;
	}

	public void evict(T entity) {
		dao.evict(entity);
	}

	public List<T> getAll() {
		return dao.select();
	}

	public List<T> getAll(QueryFilter filter) {
		return dao.getAll(filter);
	}

	public void remove(PK id) {
		dao.delete(id);
	}

	@Override
	public T find(PK id) throws BusinessAccessException {
		return null;
	}

	@Override
	public Pageable<T> getAll(int page, int pageSize) throws BusinessAccessException {
		return null;
	}

	@Override
	public int getAllSize() throws BusinessAccessException {
		return 0;
	}

	@Override
	public void remove(T o) throws BusinessAccessException {
		
	}

	@Override
	public void update(T o) throws BusinessAccessException {
		
	}

}
