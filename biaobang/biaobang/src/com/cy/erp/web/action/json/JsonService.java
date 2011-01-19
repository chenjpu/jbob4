package com.cy.erp.web.action.json;

import java.util.List;

import com.cy.erp.web.common.Util;
import com.cy.erp.web.dataGate.Globe;
import com.eshore.inas.daolayer.base.PjInformation;
import com.eshore.inas.daolayer.base.RiskLevelInfo;

public class JsonService {
	
	/**
	 * 获取项目信息的json
	 * @param rId
	 * @return
	 */
	public String getPjInfo(){
		try {
			//项目信息
			List<PjInformation> pjInfoList = (List<PjInformation>) Globe.dao.findAll("PjInformation order by pjName");
			
			//构造json数据
			StringBuffer json = new StringBuffer();
			for (PjInformation bean : pjInfoList) {
				
				json.append(",{");
				json.append("\"id\":\"");
				json.append(bean.getPjNo());
				json.append("\",\"text\":\"");
				json.append(bean.getPjName());
				json.append("\"}");
			}
			//创建静态数据ComboData
			String str = Util.createComboData(json);
			return str;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取风险二级分类信息的json
	 * @param rId
	 * @return
	 */
	public String getRiskLevelInfo2(String rId){
		try {
			//风险分类2
			List<RiskLevelInfo> riskLevelInfoList2 = (List<RiskLevelInfo>) Globe.dao.findAll("RiskLevelInfo where riskLevel='2' and relativeId='"+rId+"' order by riskLevelName");
			
			//构造json数据
			StringBuffer json = new StringBuffer();
			for (RiskLevelInfo bean : riskLevelInfoList2) {
				
				json.append(",{");
				json.append("\"id\":\"");
				json.append(bean.getId());
				json.append("\",\"text\":\"");
				json.append(bean.getRiskLevelName());
				json.append("\"}");
			}
			//创建静态数据ComboData
			String str = Util.createComboData(json);
			return str;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取风险三级分类信息的json
	 * @param rId
	 * @return
	 */
	public String getRiskLevelInfo3(String rId){
		try {
			//风险分类2
			List<RiskLevelInfo> riskLevelInfoList3 = (List<RiskLevelInfo>) Globe.dao.findAll("RiskLevelInfo where riskLevel='3' and relativeId='"+rId+"' order by riskLevelName");
			
			//构造json数据
			StringBuffer json = new StringBuffer();
			for (RiskLevelInfo bean : riskLevelInfoList3) {
				
				json.append(",{");
				json.append("\"id\":\"");
				json.append(bean.getId());
				json.append("\",\"text\":\"");
				json.append(bean.getRiskLevelName());
				json.append("\"}");
			}
			//创建静态数据ComboData
			String str = Util.createComboData(json);
			return str;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
