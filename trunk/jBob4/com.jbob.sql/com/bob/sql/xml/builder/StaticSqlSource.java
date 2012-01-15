
package com.bob.sql.xml.builder;

import java.util.List;

import com.bob.sql.xml.Configuration;
import com.bob.sql.xml.mapping.BoundSql;
import com.bob.sql.xml.mapping.ParameterMapping;
import com.bob.sql.xml.mapping.SqlSource;

public class StaticSqlSource implements SqlSource {

  private String sql;
  private List<ParameterMapping> parameterMappings;
  private Configuration configuration;

  public StaticSqlSource(Configuration configuration, String sql) {
    this(configuration, sql, null);
  }

  public StaticSqlSource(Configuration configuration, String sql, List<ParameterMapping> parameterMappings) {
    this.sql = sql;
    this.parameterMappings = parameterMappings;
    this.configuration = configuration;
  }

  public BoundSql getBoundSql(Object parameterObject) {
    return new BoundSql(configuration, sql, parameterMappings, parameterObject);
  }

}
