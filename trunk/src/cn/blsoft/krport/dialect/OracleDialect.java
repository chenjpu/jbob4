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
public class OracleDialect extends AbstractDialect implements Dialect {

	/* (non-Javadoc)
	 * @see cn.blsoft.krport.query.PageSqlParser#getSql(java.lang.String, int, int)
	 */
	@Override
	public String getPageableSql(String sql, int page, int pageSize) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select * from (").append("\n");
		sqlBuffer.append("select t.*,rownum RN from (").append("\n");
		sqlBuffer.append(sql).append("\n");
		sqlBuffer.append(") t").append("\n");
		sqlBuffer.append("where rownum < ").append(page*pageSize+1).append("\n");
		sqlBuffer.append(")").append("\n");
		sqlBuffer.append("where RN>").append((page-1)*pageSize).append("\n");
		return sqlBuffer.toString();
	}

	/* (non-Javadoc)
	 * @see cn.blsoft.krport.query.AbstractDialect#getDateString(java.util.Date, java.lang.String)
	 */
	@Override
	public String getDateString(Date date, String format) {
		return "to_date('"+DateUtil.DateToString(date, "yyyy-MM-dd HH:mm:ss")+"','yyyy-mm-dd hh24:mi:ss')";
	}
	
}
