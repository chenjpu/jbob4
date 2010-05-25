package com.jbob.core.batis;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SessionException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.jdbc.support.JdbcAccessor;

public class BatisTemplate extends JdbcAccessor {
	private SqlSessionFactory sqlSessionFactory;

	public BatisTemplate() {
	}

	public BatisTemplate(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public SqlSessionFactory getSqlSessionFactory() {
		return this.sqlSessionFactory;
	}
	
	public DataSource getDataSource() {
		DataSource ds = super.getDataSource();
		return (ds != null ? ds : getDataSourceFromEnvironment(sqlSessionFactory.getConfiguration().getEnvironment()));
	}
	
	 private DataSource getDataSourceFromEnvironment(Environment environment) {
		    if (environment == null || environment.getDataSource() == null) {
		      throw new SessionException("Configuration does not include an environment with a DataSource, so session cannot be created unless a connection is passed in.");
		    }
		    return environment.getDataSource();
		  }
	 
	public <T> T execute(BatisCallback<T> action) {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			T result = action.doInBatis(session);
			return result;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Object selectOne(final String statement, final Object parameter) {
		return execute(new BatisCallback<Object>() {
			public Object doInBatis(SqlSession session) {
				return session.selectOne(statement, parameter);
			}
		});
	}
	public Object selectOne(final String statement) {
		return execute(new BatisCallback<Object>() {
			public Object doInBatis(SqlSession session) {
				return session.selectOne(statement);
			}
		});
	}

	public List<?> selectList(final String statement, final Object parameter, final int offset, final int limit) {
		return (List<?>) execute(new BatisCallback<List<?>>() {
			public List<?> doInBatis(SqlSession session) {
				return session.selectList(statement, parameter, new RowBounds(offset, limit));
			}
		});
	}
	public List<?> selectList(final String statement, final Object parameter) {
		return (List<?>) execute(new BatisCallback<List<?>>() {
			public List<?> doInBatis(SqlSession session) {
				return session.selectList(statement, parameter);
			}
		});
	}
	public List<?> selectList(final String statement, final int offset, final int limit) {
		return (List<?>) execute(new BatisCallback<List<?>>() {
			public List<?> doInBatis(SqlSession session) {
				return session.selectList(statement, null, new RowBounds(offset, limit));
			}
		});
	}
	public List<?> selectList(final String statement) {
		return (List<?>) execute(new BatisCallback<List<?>>() {
			public List<?> doInBatis(SqlSession session) {
				return session.selectList(statement);
			}
		});
	}

	public int delete(final String statement, final Object parameter) {
		return (Integer) execute(new BatisCallback<Integer>() {
			public Integer doInBatis(SqlSession session) {
				return session.delete(statement, parameter);
			}
		});
	}

	public int update(final String statement, final Object parameter) {
		return (Integer) execute(new BatisCallback<Integer>() {
			public Integer doInBatis(SqlSession session) {
				return session.update(statement, parameter);
			}
		});
	}

	public int insert(final String statement, final Object parameter) {
		return (Integer) execute(new BatisCallback<Integer>() {
			public Integer doInBatis(SqlSession session) {
				return session.insert(statement, parameter);
			}
		});
	}
}
