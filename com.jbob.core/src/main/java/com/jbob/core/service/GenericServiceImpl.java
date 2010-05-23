package com.jbob.core.service;

import java.io.Serializable;
import java.util.List;

import com.jbob.core.BusinessAccessException;
import com.jbob.core.Entity;
import com.jbob.core.GenericDao;
import com.jbob.core.Pageable;
import com.jbob.core.Service;
import com.jbob.core.sql.QueryFilter;

public abstract class GenericServiceImpl<T extends Entity, PK extends Serializable> implements Service<T, PK> {

	protected abstract GenericDao<T, PK> getDao();
	

	public GenericServiceImpl() {
	}

	public T get(PK id) {
		return (T) getDao().select(id);
	}

	public T save(T entity) {
		return (T) getDao().insert(entity);
	}

	public T merge(T entity) {
		getDao().merge(entity);
		return entity;
	}

	public void evict(T entity) {
		getDao().evict(entity);
	}

	public List<T> getAll() {
		return getDao().select();
	}

	public List<T> getAll(QueryFilter filter) {
		return getDao().getAll(filter);
	}

	public void remove(PK id) {
		getDao().delete(id);
	}

	@Override
	public T find(PK id) throws BusinessAccessException {
		return getDao().select(id);
	}

	@Override
	public Pageable<T> getAll(int page, int pageSize) throws BusinessAccessException {
		int length =getDao().count();
		page = realPage(page, pageSize, length);
		return new Pageable<T>(page, pageSize, length, getDao().select((page - 1) * pageSize, pageSize));
	}

	@Override
	public int getAllSize() throws BusinessAccessException {
		return getDao().count();
	}

	@Override
	public void remove(T o) throws BusinessAccessException {
		getDao().delete(o);
	}

	@Override
	public void update(T o) throws BusinessAccessException {
		getDao().update(o);
	}
	
	protected final int realPage(int page, int pageSize, int length) {
		if ((page - 1) * pageSize > length) {
			page = (length + pageSize - 1) / pageSize;
		}
		return page;
	}

}
