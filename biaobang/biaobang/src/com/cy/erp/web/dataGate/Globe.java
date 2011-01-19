package com.cy.erp.web.dataGate;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;

import com.eshore.inas.daolayer.dao.DaoImpl;

public class Globe {
	public static ServletContext context;
	public static HashMap<String,String> realContextPath = new HashMap<String,String>();
	public static DaoImpl dao;
	
	public static Logger logger= Logger.getLogger(Globe.class) ;
	
	//日期和字符格式
	public static SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	public static SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat df3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
