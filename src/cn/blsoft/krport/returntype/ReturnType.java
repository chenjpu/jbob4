/**
 * Created on 2010-5-5
 * @version v1.0
 *
 */
package cn.blsoft.krport.returntype;

import cn.blsoft.krport.po.Condition;

/**
 * <p>Title:  ReturnType.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public interface ReturnType {
	
	public String getKsqlString(Condition condition, String value);
	
	public String getKsqlString(Condition condition, String[] values);
	
}
