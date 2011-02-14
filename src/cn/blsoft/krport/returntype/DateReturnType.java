/**
 * Created on 2010-5-5
 * @version v1.0
 *
 */
package cn.blsoft.krport.returntype;

import java.util.Date;

import cn.blsoft.krport.dialect.Dialect;
import cn.blsoft.krport.engine.KReportContext;
import cn.blsoft.krport.po.Condition;
import cn.blsoft.krport.util.DateUtil;

/**
 * <p>Title:  StringReturnType.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class DateReturnType implements ReturnType {


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
		if(null==value || "".equals(value)){
			return null;
		}
		String format = condition.getExtend().trim();
		Date date = DateUtil.StirngToDate(value, format);
		Dialect dialect = KReportContext.config.getDialect(KReportContext.kReports.getDataSource(condition.getKReport().getDataSource()).getDriver());
		if(dialect!=null){
			return dialect.getDateString(date, format);
		}
		return value;
	}

}
