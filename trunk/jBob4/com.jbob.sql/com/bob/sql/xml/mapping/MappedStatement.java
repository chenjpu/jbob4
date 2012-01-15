
package com.bob.sql.xml.mapping;

import java.util.ArrayList;
import java.util.List;

import org.apache.oro.util.Cache;

import com.bob.sql.xml.Configuration;

public class MappedStatement {

	private String resource;
	private Configuration configuration;
	private String id;
	private Integer fetchSize;
	private Integer timeout;
	private StatementType statementType;
	private SqlSource sqlSource;
	private Cache cache;
	private ParameterMap parameterMap;
	private SqlCommandType sqlCommandType;
	private String databaseId;

	private MappedStatement() {
	}

	public static class Builder {
		private MappedStatement mappedStatement = new MappedStatement();

		public Builder(Configuration configuration, String id, SqlSource sqlSource, SqlCommandType sqlCommandType) {
			this(configuration, id, sqlSource, sqlCommandType, null);
		}

		public Builder(Configuration configuration, String id, SqlSource sqlSource, SqlCommandType sqlCommandType, String databaseId) {
			mappedStatement.configuration = configuration;
			mappedStatement.id = id;
			mappedStatement.databaseId = databaseId;
			mappedStatement.sqlSource = sqlSource;
			mappedStatement.statementType = StatementType.PREPARED;
			mappedStatement.parameterMap = new ParameterMap.Builder("defaultParameterMap", Object.class, new ArrayList<ParameterMapping>())
					.build();
			mappedStatement.sqlCommandType = sqlCommandType;
		}

		public Builder resource(String resource) {
			mappedStatement.resource = resource;
			return this;
		}

		public String id() {
			return mappedStatement.id;
		}

		public Builder parameterMap(ParameterMap parameterMap) {
			mappedStatement.parameterMap = parameterMap;
			return this;
		}

		public Builder fetchSize(Integer fetchSize) {
			mappedStatement.fetchSize = fetchSize;
			return this;
		}

		public Builder timeout(Integer timeout) {
			mappedStatement.timeout = timeout;
			return this;
		}

		public Builder statementType(StatementType statementType) {
			mappedStatement.statementType = statementType;
			return this;
		}

		public Builder cache(Cache cache) {
			mappedStatement.cache = cache;
			return this;
		}

		public MappedStatement build() {
			assert mappedStatement.configuration != null;
			assert mappedStatement.id != null;
			assert mappedStatement.sqlSource != null;
			return mappedStatement;
		}

	}

	public SqlCommandType getSqlCommandType() {
		return sqlCommandType;
	}

	public String getResource() {
		return resource;
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public String getId() {
		return id;
	}

	public Integer getFetchSize() {
		return fetchSize;
	}

	public Integer getTimeout() {
		return timeout;
	}

	public StatementType getStatementType() {
		return statementType;
	}

	public SqlSource getSqlSource() {
		return sqlSource;
	}

	public ParameterMap getParameterMap() {
		return parameterMap;
	}

	public Cache getCache() {
		return cache;
	}

	public String getDatabaseId() {
		return databaseId;
	}

	public BoundSql getBoundSql(Object parameterObject) {
		BoundSql boundSql = sqlSource.getBoundSql(parameterObject);
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		if (parameterMappings == null || parameterMappings.size() <= 0) {
			boundSql = new BoundSql(configuration, boundSql.getSql(), parameterMap.getParameterMappings(), parameterObject);
		}
		return boundSql;
	}

}
