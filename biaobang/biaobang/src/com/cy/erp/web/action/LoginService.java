package com.cy.erp.web.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.cy.erp.web.dataGate.Globe;
import com.cy.erp.web.model.LoginData;
import com.eshore.inas.daolayer.base.OperatorInfo;
import com.eshore.inas.daolayer.base.SysRoleInfo;

public class LoginService {

	public static Logger logger = Logger.getLogger(LoginAction.class);
	
	public LoginData getLoginData(OperatorInfo operatorInfo){
		
		String id=operatorInfo.getCrId();
		String pwd=operatorInfo.getPassword();
//		String hql="from OperatorInfo where crId='" + id + "' and password='" + pwd + "'";
		try {
//			List<?> list = Globe.dao.pubFind(hql);
//			if (list.isEmpty()) {
//				return null;
//			}
//			OperatorInfo bean = (OperatorInfo) list.get(0);
			LoginData loginData = new LoginData();
			loginData.setLoginId(id);
			loginData.setLoginPwd(pwd);
			
//			loginData.setLoginId(bean.getCrId());
//			loginData.setLoginPwd(bean.getPassword());
			
//			hql="from SysRoleInfo where id='" + bean.getRoleId() + "'";
//			list = Globe.dao.pubFind(hql);
//			if (list.isEmpty()) {
//				return null;
//			}
//			SysRoleInfo beanRole = (SysRoleInfo) list.get(0);
//			loginData.setRoleCode(beanRole.getRoleCode());
//			loginData.setRoleName(beanRole.getRoleName());
//			loginData.setOrganizationScope(beanRole.getOrganizationScope());
//			loginData.setFuncScope(beanRole.getFunctionalScope());
			
			return loginData;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("µÇÂ¼Òì³£!", e);
		}
		return null;
	}
	
}
