/**
 * 
 */
package cn.blsoft.krport.initparam;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title:  Initparam.java</p>    
 * <p>Description: </p>
 * <p>Created in 2010-8-30</p>
 * <p>Company: Eshore Technology Co.Ltd.</p>
 *
 * @author wangzhiping
 * @version v1.8
 */
public interface Initparam {
	
	public Map<String, String> getParam(HttpServletRequest request);
	
}
