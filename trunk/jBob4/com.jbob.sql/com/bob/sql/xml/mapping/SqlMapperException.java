
package com.bob.sql.xml.mapping;

import com.bob.sql.xml.parsing.PersistenceException;

public class SqlMapperException extends PersistenceException {

  private static final long serialVersionUID = 4428144475952469726L;

  public SqlMapperException() {
    super();
  }

  public SqlMapperException(String message) {
    super(message);
  }

  public SqlMapperException(String message, Throwable cause) {
    super(message, cause);
  }

  public SqlMapperException(Throwable cause) {
    super(cause);
  }

}
