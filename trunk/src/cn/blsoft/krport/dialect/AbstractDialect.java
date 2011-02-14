/**
 * Created on 2010-6-27
 * @version v1.0
 *
 */
package cn.blsoft.krport.dialect;

import java.util.Date;

import cn.blsoft.krport.util.DateUtil;

/**
 * <p>Title:  AbstractDialect.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public abstract class AbstractDialect implements Dialect{

	/* (non-Javadoc)
	 * @see cn.blsoft.krport.query.Dialect#getSql(java.lang.String, int, int)
	 */
	public String getPageableSql(String sql, int page, int pageSize) {
		return null;
	}

	/* (non-Javadoc)
	 * @see cn.blsoft.krport.query.Dialect#getDateString(java.util.Date, java.lang.String)
	 */
	public String getDateString(Date date, String format) {
		return DateUtil.DateToString(date, format);
	}

	
}
