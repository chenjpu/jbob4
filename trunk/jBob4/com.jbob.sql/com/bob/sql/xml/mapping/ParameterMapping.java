
package com.bob.sql.xml.mapping;

import com.bob.sql.xml.type.JdbcType;

public class ParameterMapping {

	private String property;
	private Class<?> javaType = Object.class;
	private JdbcType jdbcType;
	private Integer numericScale;
	private String jdbcTypeName;

	private ParameterMapping() {
	}

	public static class Builder {
		private ParameterMapping parameterMapping = new ParameterMapping();

		public Builder(String property) {
			parameterMapping.property = property;
		}

		public Builder(String property, Class<?> javaType) {
			parameterMapping.property = property;
			parameterMapping.javaType = javaType;
		}

		public Builder javaType(Class<?> javaType) {
			parameterMapping.javaType = javaType;
			return this;
		}

		public Builder jdbcType(JdbcType jdbcType) {
			parameterMapping.jdbcType = jdbcType;
			return this;
		}

		public Builder numericScale(Integer numericScale) {
			parameterMapping.numericScale = numericScale;
			return this;
		}

		public Builder jdbcTypeName(String jdbcTypeName) {
			parameterMapping.jdbcTypeName = jdbcTypeName;
			return this;
		}

		public ParameterMapping build() {
			return parameterMapping;
		}

	}

	public String getProperty() {
		return property;
	}

	public Class<?> getJavaType() {
		return javaType;
	}

	public JdbcType getJdbcType() {
		return jdbcType;
	}

	public Integer getNumericScale() {
		return numericScale;
	}

	public String getJdbcTypeName() {
		return jdbcTypeName;
	}

}
