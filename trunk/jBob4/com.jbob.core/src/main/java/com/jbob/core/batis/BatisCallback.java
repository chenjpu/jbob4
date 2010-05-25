package com.jbob.core.batis;

import org.apache.ibatis.session.SqlSession;

public interface BatisCallback<T> {

	T doInBatis(SqlSession session);

}