
package com.bob.sql.xml.dynamic;

import com.bob.sql.xml.Configuration;


public class SetSqlNode extends TrimSqlNode {

  public SetSqlNode(Configuration configuration,SqlNode contents) {
    super(configuration, contents, "SET", null, null, ",");
  }

}
