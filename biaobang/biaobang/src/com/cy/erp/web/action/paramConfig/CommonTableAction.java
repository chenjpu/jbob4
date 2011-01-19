package com.cy.erp.web.action.paramConfig;

import java.io.File;
import java.io.InputStream;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import com.cy.erp.web.common.BaseAction;
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
public class CommonTableAction extends BaseAction {
	private static final long serialVersionUID = -2407572876245484007L;

	private CommonTableService commonTableService;
	
	private PageBean pageBean = new PageBean();
	
	private String excelURL;
	
	private File upload;

	private String uploadContentType;

	private String uploadFileName;
	
	private InputStream inputStream;
	
	private String demoType;
	
	//唯一ID
	private String whereColumnValue;
	//表名
	private String tableName="";
	//where条件,如whereSql="where ...";
	private String whereSql="";
	//接口类型
	private String modelName;
	//条件字段
	private String whereColumn="";
	
	/**
	 * 查询数据
	 * @return
	 */
	public String queryObject() {
		try {
			// 当前页数
			pageBean.setCurrPageIndex(currPageIndex);
			
			tableName="PJ_INFORMATION";
			
			CachedRowSet rs = commonTableService.queryObject(tableName,whereSql,pageBean);
			pageBean.setRecordCount(commonTableService.queryObjectCount(tableName,whereSql));
		
			ResultSetMetaData columnName= rs.getMetaData();
			request.setAttribute("tableData", rs);
			request.getSession().setAttribute("tableColumnName", columnName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Globe.logger.error("查询数据失败！["+tableName+"]", e);
		}
		
		return SUCCESS;
	}
	
	/**
	 * 增加记录页面
	 * @return
	 */
	public String toAddObject() {
		return SUCCESS;
	}
	
	/**
	 * 修改记录页面
	 * @return
	 */
	public String toEditObject() {		
		whereColumn="ID";
		CachedRowSet rs = commonTableService.queryObjectById(tableName,whereColumn, whereColumnValue);	
		request.setAttribute("tableData", rs);
		return SUCCESS;
	}
	
	/**
	 * 保存记录
	 * @return
	 */
	public String saveObject() {
		ResultSetMetaData columnName= (ResultSetMetaData)request.getSession().getAttribute("tableColumnName");	
		commonTableService.saveObject(columnName, request, tableName,whereColumn);
		
		return SUCCESS;
	}


	public String getExcelURL() {
		return excelURL;
	}

	public void setExcelURL(String excelURL) {
		this.excelURL = excelURL;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public CommonTableService getCommonTableService() {
		return commonTableService;
	}

	public void setCommonTableService(CommonTableService commonTableService) {
		this.commonTableService = commonTableService;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public String getWhereColumnValue() {
		return whereColumnValue;
	}

	public void setWhereColumnValue(String whereColumnValue) {
		this.whereColumnValue = whereColumnValue;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getWhereColumn() {
		return whereColumn;
	}

	public void setWhereColumn(String whereColumn) {
		this.whereColumn = whereColumn;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getDemoType() {
		return demoType;
	}

	public void setDemoType(String demoType) {
		this.demoType = demoType;
	}

	public String getWhereSql() {
		return whereSql;
	}

	public void setWhereSql(String whereSql) {
		this.whereSql = whereSql;
	}

}
