/**
 * Created on 2010-5-5
 * @version v1.0
 *
 */
package cn.blsoft.krport.returntype;

import cn.blsoft.krport.po.Condition;

/**
 * <p>Title:  StringReturnType.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class LikeReturnType implements ReturnType {


	/* (non-Javadoc)
	 * @see cn.blsoft.krport.returntype.ReturnType#getKsqlString(cn.blsoft.krport.synthesizer.Condition, java.lang.String[])
	 */
	public String getKsqlString(Condition condition, String[] values) {
		return null;	
	}

	/* (non-Javadoc)
	 * @see cn.blsoft.krport.returntype.ReturnType#getKsqlString(cn.blsoft.krport.synthesizer.Condition, java.lang.String)
	 */
	public String getKsqlString(Condition condition, String value) {
		if(null==value || "".equals(value.trim())){
			return null;
		}
		return "'%" + value.trim() + "%'";
	}

}
