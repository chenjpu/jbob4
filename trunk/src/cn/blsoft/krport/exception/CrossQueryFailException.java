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
public class CrossQueryFailException extends RuntimeException{

	static Logger log = Logger.getLogger(CrossQueryFailException.class);
	
	/**
	 * @param message
	 */
	public CrossQueryFailException(String message) {
		super(DateUtil.DateToString(new Date(), "[ yyyy-MM-dd HH:mm:ss ]")+"CrossQuery:"+message+" is Fial.");
		log.error(DateUtil.DateToString(new Date(), "[ yyyy-MM-dd HH:mm:ss ]")+"CrossQuery:"+message+" is Fial.");
	}

}
