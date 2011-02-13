package com.cy.erp.web.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.cy.erp.daolayer.base.Operatorinfo;
import com.cy.erp.daolayer.base.Sysroleinfo;
import com.cy.erp.web.dataGate.Globe;
import com.cy.erp.web.model.LoginData;

public class LoginService {

	public static Logger logger = Logger.getLogger(LoginAction.class);
	
	public LoginData getLoginData(Operatorinfo operatorinfo){
		
		String id=operatorinfo.getUser();
		String pwd=operatorinfo.getPassword();
		String hql="from Operatorinfo where user='" + id + "' and password='" + pwd + "'";
		try {
			List<?> list = Globe.dao.pubFind(hql);
			if (list.isEmpty()) {
				return null;
			}
			Operatorinfo bean = (Operatorinfo) list.get(0);
			LoginData loginData = new LoginData();
			loginData.setLoginId(bean.getUser());
			loginData.setLoginPwd(bean.getPassword());
			
			hql="from Sysroleinfo where id='" + bean.getRoleId() + "'";
			list = Globe.dao.pubFind(hql);
			if (list.isEmpty()) {
				return null;
			}
			Sysroleinfo beanRole = (Sysroleinfo) list.get(0);
			loginData.setRoleCode(beanRole.getRoleCode());
			loginData.setRoleName(beanRole.getRoleName());
			loginData.setFuncScope(beanRole.getFunctionScope());
			
			return loginData;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("µÇÂ¼Òì³£!", e);
		}
		return null;
	}
	
}
