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
public class DBQueryFailException extends RuntimeException{

	static Logger log = Logger.getLogger(DBQueryFailException.class);
	
	/**
	 * @param message
	 */
	public DBQueryFailException(String message) {
		super(DateUtil.DateToString(new Date(), "[ yyyy-MM-dd HH:mm:ss ]")+"DBQuery:"+message+" is Fial.");
		log.error(DateUtil.DateToString(new Date(), "[ yyyy-MM-dd HH:mm:ss ]")+"DBQuery:"+message+" is Fial.");
	}

}
