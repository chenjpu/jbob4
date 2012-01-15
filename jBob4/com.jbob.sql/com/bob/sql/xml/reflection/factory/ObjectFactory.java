
package com.bob.sql.xml.reflection.factory;

import java.util.List;
import java.util.Properties;

public interface ObjectFactory {

  <T> T create(Class<T> type);

  <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs);

  void setProperties(Properties properties);

}
