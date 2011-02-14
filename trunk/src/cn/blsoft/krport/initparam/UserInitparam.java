/**
 * 
 */
package cn.blsoft.krport.initparam;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title:  UserInitparam.java</p>    
 * <p>Description: </p>
 * <p>Created in 2010-9-16</p>
 * <p>Company: Eshore Technology Co.Ltd.</p>
 *
 * @author wangzhiping
 * @version v1.8
 */
public class UserInitparam implements Initparam {

	/* (non-Javadoc)
	 * @see cn.blsoft.krport.initparam.Initparam#getParam(javax.servlet.http.HttpServletRequest)
	 */
	public Map<String, String> getParam(HttpServletRequest request) {
		Map<String, String> userParam = new HashMap<String, String>();
		userParam.put("s@user_areas","'0757','0001','1000','0668','0758','0663','0752','0751','0754','0000','0769','0768','0766','0763','0760','0759','0756','0755','0999','0990','0753','0750','0762','0660','0662','0020'");
	
		userParam.put("s@user_id", "E6E92C1310F9A49E2AD18D9691E01F7F");
		userParam.put("s@user_name", "超级用户");
		userParam.put("s@user_orgid", "1000");
		userParam.put("s@user_orgname", "广东电信");
		return userParam;
	}

}
