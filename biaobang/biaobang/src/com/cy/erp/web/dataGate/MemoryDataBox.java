package com.cy.erp.web.dataGate;

import javax.servlet.http.HttpServlet;
import javax.sql.rowset.CachedRowSet;

import com.cy.erp.daolayer.dao.DaoImpl;

/*
 * 内存数据
 */
public class MemoryDataBox extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 初始化全局使用的静态数据
	 * 
	 * @param sc
	 */
	@SuppressWarnings("unchecked")
	public void init() {
		
		try {
			super.init();
			String path = this.getServletContext().getRealPath("");	
			Globe.realContextPath.clear();
			Globe.realContextPath.put("realContextPath", path);
			Globe.context = this.getServletContext();
			if (Globe.dao == null)
				Globe.dao = new DaoImpl();
			this.loadData();

		} catch (Exception e) {
			Globe.logger.error("系统加载静态数据失败。", e);
		}
	}

	@SuppressWarnings( { "unused", "unchecked" })
	public synchronized void loadData() {
		CachedRowSet rowset = null;

		try {
			
			
			Globe.logger.info("系统加载静态数据成功!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//如果有连接，请在些设置关闭
		}
	}
}
