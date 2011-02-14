/**
 * Created on 2010-5-16
 * @version v1.0
 *
 */
package cn.blsoft.krport.engine;

import cn.blsoft.krport.po.Config;
import cn.blsoft.krport.po.KReports;

/**
 * <p>Title:  Context.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class KReportContext {

	public static String BASE;						//部署根位置
	
	public static String ROOTPATH;					//根路径
	
	public static KReports kReports;				//报表配置
	
	public static Config config;					//组件配置
	
	public static int pageMaxRows = 1000;			//页面查询最大行数
	
	public static int exportMaxRows = 2000;		//导出最大行数
	
}
