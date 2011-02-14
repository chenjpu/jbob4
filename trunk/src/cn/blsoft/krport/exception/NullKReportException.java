/**
 * Created on 2010-4-27
 * @version v1.0
 *
 */
package cn.blsoft.krport.exception;

import common.Logger;


@SuppressWarnings("serial")
public class NullKReportException extends RuntimeException{
	
	static Logger log = Logger.getLogger(NullKReportException.class);
	/**
	 * @param message
	 */
	public NullKReportException(String message) {
		super("KReport:"+message+".kreport is Null.");
		log.error("KReport:"+message+".kreport is Null.");
	}

}
