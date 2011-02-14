/**
 * Created on 2010-6-18
 * @version v1.0
 *
 */
package cn.blsoft.krport.dialect;

import java.util.Date;

/**
 * <p>Title:  PageSqlParser.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public interface Dialect {

	/**
	 * Description: 构造分页查询语句，返回的sql语句比原sql多一个字段，用于辅助分页，如无需此字段，则加入一个空字段。
	 * @param sql 原sql
	 * @param page 查询页
	 * @param pageSize 页记录数
	 * @return 分页sql
	 */
	String getPageableSql(String sql,int page,int pageSize);
	
	String getDateString(Date date, String format);
	
}
