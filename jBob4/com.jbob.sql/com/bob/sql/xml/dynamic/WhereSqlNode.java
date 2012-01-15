
package com.bob.sql.xml.dynamic;

import com.bob.sql.xml.Configuration;


public class WhereSqlNode extends TrimSqlNode {

  public WhereSqlNode(Configuration configuration, SqlNode contents) {
    super(configuration, contents, "WHERE", "AND |OR ", null, null);
  }


}
