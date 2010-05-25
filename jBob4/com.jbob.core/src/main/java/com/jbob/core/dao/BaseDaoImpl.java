package com.jbob.core.dao;

import com.jbob.core.BaseDao;
import com.jbob.core.Entity;

/**
 * 
 * @author chenb
 *
 * @param <T> 基础表类，对于主键为long类型　，则直接继承该类，若主键为其他类型，
 * 需要直接继承HibernateGenericDao
 */
public class BaseDaoImpl<T extends Entity> extends HibernateGenericDao<T, Long> implements BaseDao<T> {

	public BaseDaoImpl(Class<T> persistType) {
		super(persistType);
	}

}
