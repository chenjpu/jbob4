package com.cy.erp.web.common;

import java.io.FileOutputStream;
import java.util.Date;

/**
 * 公共方法类
 * @author chenchen
 *
 */
public class Util {
	
	/**
	 * 判断是否空值--String<br>
	 * 
	 * @return
	 * @throws Exception
	 */
	public static boolean isNull(String content) {
		boolean isExist = false;
		if(content == null || content.equals("")){
			isExist = true;
		}
		return isExist;
	}
	
	/**
	 * 判断是否空值--Double<br>
	 * 
	 * @return
	 * @throws Exception
	 */
	public static boolean isNull(Double content) {
		boolean isExist = false;
		if(content == null || content.equals("")){
			isExist = true;
		}
		return isExist;
	}
	
	/**
	 * 判断是否空值--Date<br>
	 * 
	 * @return
	 * @throws Exception
	 */
	public static boolean isNull(Date content) {
		boolean isExist = false;
		if(content == null || content.equals("")){
			isExist = true;
		}
		return isExist;
	}
	
	/**
	 * 取值--Double<br>
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Double getDouble(Double content) {
		Double isExist = 0.00;
		if(content != null){
			isExist = content;
		}
		return isExist;
	}
	
	/**
	 * 创建静态数据json
	 * @param bean
	 */
	public static void createComboData(StringBuffer json,String fieldName) {
		try {
			if(json.length()>0){
				String str=json.toString();
				str="{\"id\":\"\",\"text\":\"空值\"}"+str;
				str="["+str+"]";
				createField(str,fieldName);
			}else{
				String str="[{\"id\":\"\",\"text\":\"--数据为空--\"}]";
				createField(str,fieldName);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 创建json文件
	 * @param str
	 * @param fieldName
	 */
	public static void createField(String str, String fieldName) {
		try {
			byte[] bytes = str.getBytes("UTF-8");
			
			FileOutputStream fileOutputStream = new FileOutputStream("../webapps/RTS/staticData/"+fieldName+".json");
			fileOutputStream.write(bytes);
			fileOutputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 创建静态数据json
	 * @param bean
	 */
	public static String createComboData(StringBuffer json) {
		try {
			if(json.length()>0){
				String str=json.toString();
				str="{\"id\":\"\",\"text\":\"空值\"}"+str;
				str="["+str+"]";
				return str;
			}else{
				String str="[{\"id\":\"\",\"text\":\"--数据为空--\"}]";
				return str;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
