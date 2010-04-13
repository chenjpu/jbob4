package com.jbob.core.service;

import com.jbob.core.BaseDao;
import com.jbob.core.BaseService;
import com.jbob.core.Entity;

public class BaseServiceImpl<T extends Entity> extends GenericServiceImpl<T, Long> implements BaseService<T> {

	public BaseServiceImpl(BaseDao<T> dao) {
		super(dao);
	}
}
