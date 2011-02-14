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
public class StringReturnType implements ReturnType {


	/* (non-Javadoc)
	 * @see cn.blsoft.krport.returntype.ReturnType#getKsqlString(cn.blsoft.krport.synthesizer.Condition, java.lang.String[])
	 */
	public String getKsqlString(Condition condition, String[] values) {
		if(null==values || values.length<1){
			return null;
		}
		StringBuffer merge = new StringBuffer();
		if(null == values) return null;
		for(int i=0;i<values.length;i++){
			merge.append("'").append(values[i]).append("'");
			if(i<values.length-1){
				merge.append(",");
			}
		}
		return merge.toString();
	}

	/* (non-Javadoc)
	 * @see cn.blsoft.krport.returntype.ReturnType#getKsqlString(cn.blsoft.krport.synthesizer.Condition, java.lang.String)
	 */
	public String getKsqlString(Condition condition, String value) {
		if(null==value || "".equals(value)){
			return null;
		}
		return "'" + value + "'";
	}

}
