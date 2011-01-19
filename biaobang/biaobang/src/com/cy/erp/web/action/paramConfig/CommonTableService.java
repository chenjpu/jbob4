package com.cy.erp.web.action.paramConfig;

import java.sql.ResultSetMetaData;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.CachedRowSet;

import com.cy.erp.web.dataGate.Globe;
import com.cy.erp.web.model.PageBean;

/**
 * @Title:CommonTableAction
 * @Description: 通用表操作
 * @Copyright: Copyright (C) 2002 - 2009 GuangDong Eshore Techonlogy Co. Ltd
 * @Company: Eshore
 * 
 * @author zhengyuanhong
 * @version 1.0
 * @date Jan 26, 2010 3:55:34 PM
 */
public class CommonTableService {
	
	public CachedRowSet queryObject(String tableName, String whereSql, PageBean page){
		CachedRowSet tf=null;
		try {
			int rowcount = page.getRowCount();
			int first = (page.getCurrPageIndex()) * rowcount;
			String sql="select * from "+ tableName + whereSql;
			String sqlhead = "SELECT * FROM(SELECT ROWNUM RN,A.* FROM (";
			String sqlfoot = ") A WHERE ROWNUM <= " + (first + rowcount) + ")WHERE RN >= " + first;
			sql = new StringBuffer().append(sqlhead).append(sql).append(sqlfoot).toString();
			tf= Globe.dao.oracleFindBySQL(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Globe.logger.error("查询出错！",e);
		}
		return tf;
	}
	
	public Integer queryObjectCount(String tableName, String whereSql){
		CachedRowSet tf=null;
		Integer sum=0;
		try {;
			String sql="select count(*) as id from "+ tableName + whereSql;
			tf= Globe.dao.oracleFindBySQL(sql);
			tf.next();
			sum=tf.getInt("id");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Globe.logger.error("查询数据出错！",e);
		}
		return sum;
	}
	
	public CachedRowSet queryObjectById(String tableName, String columnName,String value){
		CachedRowSet tf=null;
		try {
			String sql="select * from "+ tableName + " where "+columnName+"='"+value+"'";
			tf= Globe.dao.oracleFindBySQL(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Globe.logger.error("查询出错！",e);
		}
		return tf;
	}
	
	public Boolean saveObject(ResultSetMetaData data,HttpServletRequest request,String tableName, String selectColumn){
		boolean tf=false;
		try {
			StringBuffer str=new StringBuffer();
			String sql="update "+ tableName +" set ";			
			for (int i = 3; i <= data.getColumnCount(); i++) {
				String columnName = data.getColumnName(i);
				String columnTypeName=data.getColumnTypeName(i); 
				
				String columnValue = request.getParameter(columnName);
				
				
				if(columnTypeName.equals("NUMBER")){
					if(!columnValue.equals("") && !columnValue.equals("null")){
						str.append(",");
						str.append(columnName);
						str.append("=");
						str.append(columnValue);
					}
				}else{
					if(!columnValue.equals("") && !columnValue.equals("null")){
						str.append(",");
						str.append(columnName);
						str.append("='");
						str.append(columnValue);
						str.append("'");
					}
				}								
			}
			String temp=str.toString();
			temp=temp.substring(1, temp.length());
			sql+=temp+" where " + selectColumn +"='"+request.getParameter(selectColumn)+"'";
			tf=Globe.dao.executeBySQL(sql);
				
		} catch (Exception ex) {
			Globe.logger.error("保存数据失败!", ex);
		}
		return tf;
	}
}
