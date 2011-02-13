/**
 * 
 */
package com.cy.erp.daolayer.dao;

import org.hibernate.dialect.OracleDialect;

/**
 * @author zhangyong
 *
 */
public class InasOracleDialect extends OracleDialect {

	/**
	 * 
	 */
	public InasOracleDialect() {
		super();
		this.registerFunction("datediff",new Datediff());
		this.registerFunction("tosecond",new ToSecond());
	}

}
