package com.bob.sql.xml.reflection.wrapper;

import com.bob.sql.xml.reflection.MetaObject;

public interface ObjectWrapperFactory {

  boolean hasWrapperFor(Object object);
  
  ObjectWrapper getWrapperFor(MetaObject metaObject, Object object);
  
}
