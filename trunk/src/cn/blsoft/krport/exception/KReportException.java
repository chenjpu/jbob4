/**
 * Created on 2010-4-27
 * @version v1.0
 *
 */
package cn.blsoft.krport.exception;

/**
 * <p>Title:  ReaderException.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
@SuppressWarnings("serial")
public class KReportException extends RuntimeException{

	/**
	 * @param message
	 */
	public KReportException(String message) {
		super(message);
	}

}
