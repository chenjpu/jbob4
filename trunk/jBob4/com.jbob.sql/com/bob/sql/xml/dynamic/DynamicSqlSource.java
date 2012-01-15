
package com.bob.sql.xml.dynamic;

import java.util.Map;

import com.bob.sql.xml.Configuration;
import com.bob.sql.xml.builder.SqlSourceBuilder;
import com.bob.sql.xml.mapping.BoundSql;
import com.bob.sql.xml.mapping.SqlSource;

public class DynamicSqlSource implements SqlSource {

	private Configuration configuration;
	private SqlNode rootSqlNode;

	public DynamicSqlSource(Configuration configuration, SqlNode rootSqlNode) {
		this.configuration = configuration;
		this.rootSqlNode = rootSqlNode;
	}

	public BoundSql getBoundSql(Object parameterObject) {
		DynamicContext context = new DynamicContext(configuration, parameterObject);
		rootSqlNode.apply(context);
		SqlSourceBuilder sqlSourceParser = new SqlSourceBuilder(configuration);
		Class<?> parameterType = parameterObject == null ? Object.class : parameterObject.getClass();
		SqlSource sqlSource = sqlSourceParser.parse(context.getSql(), parameterType);
		BoundSql boundSql = sqlSource.getBoundSql(parameterObject);
		for (Map.Entry<String, Object> entry : context.getBindings().entrySet()) {
			boundSql.setAdditionalParameter(entry.getKey(), entry.getValue());
		}
		return boundSql;
	}

}
