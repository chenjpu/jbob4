package com.jbob.core.service;

import com.jbob.core.BaseService;
import com.jbob.core.Entity;

public abstract class BaseServiceImpl<T extends Entity> extends GenericServiceImpl<T, Long> implements BaseService<T> {

}
