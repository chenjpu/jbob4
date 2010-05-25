package com.jbob.core.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.jbob.core.Entity;
import com.jbob.core.GenericDao;
import com.jbob.core.batis.BatisCallback;
import com.jbob.core.batis.support.BatisDaoSupport;
import com.jbob.core.sql.QueryFilter;

/**
 * 
 * @author chenjpu
 */
@SuppressWarnings("all")
public class BatisGenericDao<T extends Entity, PK extends Serializable> extends BatisDaoSupport implements GenericDao<T, PK> {

	protected Class<T> clazz;

	public BatisGenericDao(Class<T> clazz) {
		this.clazz = clazz;
	}

	public T select(PK id) throws DataAccessException {
		return (T) super.getBatisTemplate().selectOne(clazz.getName(), id);
	}

	public List<T> select() throws DataAccessException {
		return (List<T>)super.getBatisTemplate().selectList(selectStatement(clazz));
	}

	public List<T> select(final int skip, final int max) throws DataAccessException {
		return (List<T>)super.getBatisTemplate().selectList(selectStatement(clazz),skip,max);
	}

	public int count() throws DataAccessException {
		return ((Number)super.getBatisTemplate().selectOne(countStatement(clazz))).intValue();
	}

	public void delete(final PK id) throws DataAccessException {
		super.getBatisTemplate().delete(deleteStatement(clazz), id);
	}

	public void delete(T entity) {
		super.getBatisTemplate().delete(deleteStatement(clazz), entity.getId());
	}

	public T insert(T o) throws DataAccessException {
		super.getBatisTemplate().insert(insertStatement(clazz), o);
		return o;
	}

	public void update(T o) throws DataAccessException {
		super.getBatisTemplate().update(updateStatement(clazz), o);
	}

	public void merge(T entity) {
		super.getBatisTemplate().update(mergeStatement(clazz),entity);
	}

	public void evict(T entity) {
		//super.getBatisTemplate().evict(entity);
	}

	protected final <B> B execute(BatisCallback BatisCallback) throws DataAccessException {
		return (B) super.getBatisTemplate().execute(BatisCallback);
	}

	protected final <B> List<B> executeFind(BatisCallback BatisCallback) throws DataAccessException {
		return super.getBatisTemplate().execute(BatisCallback);
	}

	protected final int executeInt(BatisCallback BatisCallback) throws DataAccessException {
		return this.<Number> execute(BatisCallback).intValue();
	}

	protected final long executeLong(BatisCallback BatisCallback) throws DataAccessException {
		return this.<Number> execute(BatisCallback).longValue();
	}

	public List<T> getAll(QueryFilter filter) {
		return null;
	}

	// 所有这些方法都可以重写

	protected String getNamespace(Class<?> clazz) {
		return clazz.getName();
	}

	protected String selectByIdStatement(Class<?> clazz) {
		return getNamespace(clazz) + ".getById";
	}

	protected String selectStatement(Class<?> clazz) {
		return getNamespace(clazz) + ".select";
	}

	protected String countStatement(Class<?> clazz) {
		return getNamespace(clazz) + ".count";
	}

	protected String deleteStatement(Class<?> clazz) {
		return getNamespace(clazz) + ".delete";
	}

	protected String insertStatement(Class<?> clazz) {
		return getNamespace(clazz) + ".insert";
	}

	protected String updateStatement(Class<?> clazz) {
		return getNamespace(clazz) + ".update";
	}
	protected String mergeStatement(Class<?> clazz) {
		return getNamespace(clazz) + ".merge";
	}
}