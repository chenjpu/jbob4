/**
 * Created on 2010-6-18
 * @version v1.0
 *
 */
package cn.blsoft.krport.dialect;

import java.util.Date;

import cn.blsoft.krport.util.DateUtil;

/**
 * <p>Title:  OraclePageSqlParser.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class MySQLDialect extends AbstractDialect implements Dialect {

	/* (non-Javadoc)
	 * @see cn.blsoft.krport.query.PageSqlParser#getSql(java.lang.String, int, int)
	 */
	@Override
	public String getPageableSql(String sql, int page, int pageSize) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select _page.*,1 from (").append("\n");
		sqlBuffer.append(sql).append(" limit ").append((page-1)*pageSize).append(",").append(pageSize).append("\n");
		sqlBuffer.append(") as _page");
		return sqlBuffer.toString();
	}

	/* (non-Javadoc)
	 * @see cn.blsoft.krport.query.AbstractDialect#getDateString(java.util.Date, java.lang.String)
	 */
	@Override
	public String getDateString(Date date, String format) {
		return "time'"+DateUtil.DateToString(date, "yyyy-MM-dd HH:mm:ss")+"'";
	}
	
	

}
