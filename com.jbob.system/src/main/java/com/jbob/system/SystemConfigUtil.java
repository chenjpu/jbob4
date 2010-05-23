/*
 * 
 * 创建日期：2010-4-16 下午05:25:04
 *
 * 创  建  人 ：chenjpu
 * 
 * 版权所有：J.Bob
 */

package com.jbob.system;


public class SystemConfigUtil {
	public static String getCompanyLogo() {
		String defaultLogoPath = "/images/jbob_logo.jpg";
		//String path = (String) configMap.get("app.logoPath");
		//if (StringUtils.hasText(path)){
		//	defaultLogoPath = (new StringBuilder("/attachFiles/")).append(path).toString();
		//}
		return defaultLogoPath;
	}

	public static String getCompanyName() {
		String defaultName = "J.Bob Inc.";
		//String companyName = (String) configMap.get("app.companyName");
		//if (StringUtils.hasText(companyName)){
		//	defaultName = companyName;
		//}
		return defaultName;
	}
}
