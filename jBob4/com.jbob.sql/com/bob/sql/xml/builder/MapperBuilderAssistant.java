
package com.bob.sql.xml.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bob.sql.xml.Configuration;
import com.bob.sql.xml.ErrorContext;
import com.bob.sql.xml.mapping.MappedStatement;
import com.bob.sql.xml.mapping.ParameterMap;
import com.bob.sql.xml.mapping.ParameterMapping;
import com.bob.sql.xml.mapping.SqlCommandType;
import com.bob.sql.xml.mapping.SqlSource;
import com.bob.sql.xml.mapping.StatementType;
import com.bob.sql.xml.parsing.BuilderException;
import com.bob.sql.xml.reflection.MetaClass;
import com.bob.sql.xml.type.JdbcType;

public class MapperBuilderAssistant extends BaseBuilder {

	private String currentNamespace;
	private String resource;

	public MapperBuilderAssistant(Configuration configuration, String resource) {
		super(configuration);
		ErrorContext.instance().resource(resource);
		this.resource = resource;
	}

	public String getCurrentNamespace() {
		return currentNamespace;
	}

	public void setCurrentNamespace(String currentNamespace) {
		if (currentNamespace == null) {
			throw new BuilderException("The mapper element requires a namespace attribute to be specified.");
		}

		if (this.currentNamespace != null && !this.currentNamespace.equals(currentNamespace)) {
			throw new BuilderException("Wrong namespace. Expected '" + this.currentNamespace + "' but found '" + currentNamespace + "'.");
		}

		this.currentNamespace = currentNamespace;
	}

	public String applyCurrentNamespace(String base, boolean isReference) {
		if (base == null)
			return null;
		if (isReference) {
			// is it qualified with any namespace yet?
			if (base.contains("."))
				return base;
		} else {
			// is it qualified with this namespace yet?
			if (base.startsWith(currentNamespace + "."))
				return base;
			if (base.contains("."))
				throw new BuilderException("Dots are not allowed in element names, please remove it from " + base);
		}
		return currentNamespace + "." + base;
	}

	public ParameterMap addParameterMap(String id, Class<?> parameterClass, List<ParameterMapping> parameterMappings) {
		id = applyCurrentNamespace(id, false);
		ParameterMap.Builder parameterMapBuilder = new ParameterMap.Builder(id, parameterClass, parameterMappings);
		ParameterMap parameterMap = parameterMapBuilder.build();
		configuration.addParameterMap(parameterMap);
		return parameterMap;
	}

	public ParameterMapping buildParameterMapping(Class<?> parameterType, String property, Class<?> javaType, JdbcType jdbcType,
			Integer numericScale) {

		// Class parameterType = parameterMapBuilder.type();
		Class<?> javaTypeClass = resolveParameterJavaType(parameterType, property, javaType, jdbcType);

		ParameterMapping.Builder builder = new ParameterMapping.Builder(property, javaTypeClass);
		builder.jdbcType(jdbcType);
		builder.numericScale(numericScale);
		return builder.build();
	}

	public MappedStatement addMappedStatement(String id, SqlSource sqlSource, StatementType statementType, SqlCommandType sqlCommandType,
			Integer fetchSize, Integer timeout, String parameterMap, Class<?> parameterType, Class<?> resultType,String databaseId) {
		id = applyCurrentNamespace(id, false);

		MappedStatement.Builder statementBuilder = new MappedStatement.Builder(configuration, id, sqlSource, sqlCommandType, databaseId);
		statementBuilder.resource(resource);
		statementBuilder.fetchSize(fetchSize);
		statementBuilder.statementType(statementType);
		setStatementTimeout(timeout, statementBuilder);

		setStatementParameterMap(parameterMap, parameterType, statementBuilder);

		MappedStatement statement = statementBuilder.build();
		configuration.addMappedStatement(statement);
		return statement;
	}

	private void setStatementParameterMap(String parameterMap, Class<?> parameterTypeClass, MappedStatement.Builder statementBuilder) {
		parameterMap = applyCurrentNamespace(parameterMap, true);

		if (parameterMap != null) {
			statementBuilder.parameterMap(configuration.getParameterMap(parameterMap));
		} else if (parameterTypeClass != null) {
			List<ParameterMapping> parameterMappings = new ArrayList<ParameterMapping>();
			ParameterMap.Builder inlineParameterMapBuilder = new ParameterMap.Builder(statementBuilder.id() + "-Inline",
					parameterTypeClass, parameterMappings);
			statementBuilder.parameterMap(inlineParameterMapBuilder.build());
		}
	}

	private void setStatementTimeout(Integer timeout, MappedStatement.Builder statementBuilder) {
		if (timeout == null) {
			timeout = configuration.getDefaultStatementTimeout();
		}
		statementBuilder.timeout(timeout);
	}

	private Class<?> resolveParameterJavaType(Class<?> resultType, String property, Class<?> javaType, JdbcType jdbcType) {
		if (javaType == null) {
			if (JdbcType.CURSOR.equals(jdbcType)) {
				javaType = java.sql.ResultSet.class;
			} else if (Map.class.isAssignableFrom(resultType)) {
				javaType = Object.class;
			} else {
				MetaClass metaResultType = MetaClass.forClass(resultType);
				javaType = metaResultType.getGetterType(property);
			}
		}
		if (javaType == null) {
			javaType = Object.class;
		}
		return javaType;
	}

}
