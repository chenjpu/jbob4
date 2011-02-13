/**
 *com.eshore.tips.daolayer.dao.DaoInit
 *作者：ZhangYong
 *版本：1.0
 *修改日期：2005-12-15  21:01:24
 */
package com.cy.erp.daolayer.dao;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 * 初始化spring的DAO框架
 */
public class DaoInit {
	private static SessionFactory sessionFactory = null;
	private static BeanFactory beanFactory = null;
	private static Logger logger = Logger.getLogger(DaoInit.class);

	/**
	 * 初始化SessionFactory 默认的spring配置文件全路径： etc/RTS_DAO.xml
	 */
	static{
		Resource rs = null;
		SessionFactory tmpFactory = null;
		// 读取配置文件 RTS_DAO.xml
		try {
			rs = new FileSystemResource("etc/HF_DAO.xml");
		} catch (Exception e) {
			logger.error("初始化默认配置文件[RTS_DAO.xml]失败,请检查文件路径,系统中止执行",e);
			System.exit(-1);
		}
		// 建立bean工厂
		try {
			beanFactory = new XmlBeanFactory(rs);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("建立spring的bean工厂失败,请检查文件路径,系统中止执行", e);
			System.exit(-1);
		}
		
		// 获取session工厂
		try {
			tmpFactory = (SessionFactory) beanFactory.getBean("sessionFactory");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("获取hibernate的session工厂失败,请检查文件路径,系统中止执行", e);
			System.exit(-1);
		}
		
		sessionFactory = tmpFactory;
	}
	
	public static SessionFactory init() throws Exception {
		return sessionFactory;
	}
}
