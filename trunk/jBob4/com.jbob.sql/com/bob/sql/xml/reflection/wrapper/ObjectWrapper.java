package com.bob.sql.xml.reflection.wrapper;

import com.bob.sql.xml.reflection.MetaObject;
import com.bob.sql.xml.reflection.factory.ObjectFactory;
import com.bob.sql.xml.reflection.property.PropertyTokenizer;

public interface ObjectWrapper {

  Object get(PropertyTokenizer prop);

  void set(PropertyTokenizer prop, Object value);

  String findProperty(String name, boolean useCamelCaseMapping);

  String[] getGetterNames();

  String[] getSetterNames();

  Class<?> getSetterType(String name);

  Class<?> getGetterType(String name);

  boolean hasSetter(String name);

  boolean hasGetter(String name);

  MetaObject instantiatePropertyValue(String name, PropertyTokenizer prop, ObjectFactory objectFactory);

}
