/**
 * 
 */
package com.cy.erp.kReport.initparam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.blsoft.krport.initparam.Initparam;

import com.cy.erp.web.model.LoginData;

/**
 * <p>Title:  UserInitparam.java</p>    
 * <p>Description: </p>
 * <p>Created in 2010-8-30</p>
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
		LoginData loginData = (LoginData) request.getSession().getAttribute("loginData");
		/*List<DataDictionary> areas = logonVO.getAreas();
		StringBuffer user_areas = new StringBuffer();
		for(DataDictionary area:areas){
			user_areas.append(",'").append(area.getDvalue()).append("'");
		}
		if(user_areas.length()>0){
			userParam.put("s@user_areas", user_areas.substring(1));
		}else if(user_areas.length()==0){
			userParam.put("s@user_areas","'--nothing--'");
		}*/
		userParam.put("s@user_id", loginData.getLoginId());
		userParam.put("s@user_name", loginData.getLoginId());
		userParam.put("s@user_orgid", loginData.getOrganizationScope());
		userParam.put("s@user_orgname", loginData.getOrganizationScope());
		return userParam;
	}

}
