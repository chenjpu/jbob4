
package com.bob.sql.xml.builder;

import com.bob.sql.xml.Configuration;
import com.bob.sql.xml.parsing.BuilderException;
import com.bob.sql.xml.type.JdbcType;
import com.bob.sql.xml.type.TypeAliasRegistry;

public abstract class BaseBuilder {

	protected final Configuration configuration;

	protected final TypeAliasRegistry typeAliasRegistry;

	public BaseBuilder(Configuration configuration) {
		this.configuration = configuration;
		this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
	}

	protected String stringValueOf(String value, String defaultValue) {
		return value == null ? defaultValue : value;
	}

	protected Boolean booleanValueOf(String value, Boolean defaultValue) {
		return value == null ? defaultValue : Boolean.valueOf(value);
	}

	protected Integer integerValueOf(String value, Integer defaultValue) {
		return value == null ? defaultValue : Integer.valueOf(value);
	}

	protected JdbcType resolveJdbcType(String alias) {
		if (alias == null)
			return null;
		try {
			return JdbcType.valueOf(alias);
		} catch (IllegalArgumentException e) {
			throw new BuilderException("Error resolving JdbcType. Cause: " + e, e);
		}
	}

	protected Class<?> resolveClass(String alias) {
		if (alias == null)
			return null;
		try {
			return resolveAlias(alias);
		} catch (Exception e) {
			throw new BuilderException("Error resolving class . Cause: " + e, e);
		}
	}

	protected Class<?> resolveAlias(String alias) {
		return typeAliasRegistry.resolveAlias(alias);
	}

}
