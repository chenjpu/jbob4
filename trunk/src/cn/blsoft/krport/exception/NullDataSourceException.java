/**
 * Created on 2010-4-27
 * @version v1.0
 *
 */
package cn.blsoft.krport.exception;

import java.util.Date;

import cn.blsoft.krport.util.DateUtil;
import common.Logger;


@SuppressWarnings("serial")
public class NullDataSourceException extends RuntimeException{

	static Logger log = Logger.getLogger(NullDataSourceException.class);
	/**
	 * @param message
	 */
	public NullDataSourceException(String message) {
		super(DateUtil.DateToString(new Date(), "[ yyyy-MM-dd HH:mm:ss ]")+"DataSource:"+message+" is Null.");
		log.error(DateUtil.DateToString(new Date(), "[ yyyy-MM-dd HH:mm:ss ]")+"DataSource:"+message+" is Null.");
	}

}
