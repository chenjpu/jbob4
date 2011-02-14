/**
 * Created on 2010-6-6
 * @version v1.0
 *
 */
package cn.blsoft.krport.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>Title:  Action.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public interface Action {

	void execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
}
