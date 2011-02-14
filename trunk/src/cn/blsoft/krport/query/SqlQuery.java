/**
 * Created on 2010-4-27
 * @version v1.0
 *
 */
package cn.blsoft.krport.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.blsoft.krport.engine.KReportContext;
import cn.blsoft.krport.exception.DBConnectFailException;
import cn.blsoft.krport.exception.DBQueryFailException;
import cn.blsoft.krport.po.Condition;
import cn.blsoft.krport.po.DataSource;
import cn.blsoft.krport.po.KReport;
import cn.blsoft.krport.po.PageData;
import cn.blsoft.krport.returntype.ReturnType;

/**
 * <p>Title:  SqlQuery.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class SqlQuery implements Query {

	/**
	 * Description: 数据查询
	 * @param kReport	报表
	 * @param param  参数
	 * @return 报表数据对象
	 */
	public static PageData Query(KReport kReport, Map<String, Object> param, int maxRows){
		KSqlParser kSqlParser = createKSqlParser(kReport, param);
		String kSql = kSqlParser.getSql();
		return Query(kReport.getDataSource(), kSql, maxRows);
	}

	/**
	 * Description: 数据查询
	 * @param kReport 报表
	 * @param param 参数
	 * @param pageable 是否分页
	 * @return 报表数据对象
	 */
	public static PageData Query(KReport kReport, Map<String, Object> param, boolean pageable){
		if(pageable){
			KSqlParser kSqlParser = createKSqlParser(kReport, param);
			String kSql = kSqlParser.getSql();
			return Query(kReport.getDataSource(), kSql, Integer.parseInt((String)param.get("_page")),kReport.getPageSize(), KReportContext.pageMaxRows);			
		}else{
			return Query(kReport, param, KReportContext.pageMaxRows);
		}		
	}
	
	/**
	 * Description: 数据查询
	 * @param kReport	报表
	 * @param param  参数
	 * @return 报表数据对象
	 */
	public static PageData Query(KReport kReport, Map<String, Object> param, String kSql, int maxRows){
		KSqlParser kSqlParser = createKSqlParser(kReport, param, kSql);
		return Query(kReport.getDataSource(), kSqlParser.getSql(), maxRows);
	}


	/**
	 * Description: 数据查询
	 * @param dataSource　数据库连接
	 * @param sql　查询语句
	 * @return  报表数据对象
	 */
	public static PageData Query(String dataSource, String sql, int maxRows) {
		PageData pageData = null;
		Connection conn = getConnection(dataSource);
		try {
			Statement statement = conn.createStatement();
			if(maxRows>0){
				statement.setMaxRows(maxRows);
			}
			ResultSet rs = statement.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			String[] head = new String[rsmd.getColumnCount()+1]; 
			int[] headType = new int[rsmd.getColumnCount()+1]; 
			
			Object[] foot = new Object[rsmd.getColumnCount()+1];
			
			head[0] = "序号";
			headType[0] = 4 ;//整型
			foot[0] = "";
			
			for(int i=1;i<= rsmd.getColumnCount();i++){
				head[i] = rsmd.getColumnName(i);
				headType[i] = rsmd.getColumnType(i);
				foot[i]=getCountSum(rsmd.getColumnType(i));
			}
			
			List<String[]> bodys = new ArrayList<String[]>();
			int index = 0;
			while(rs.next()){
				String[] body = new String[rsmd.getColumnCount()+1]; 
				body[0] = ++index + "";
				for(int i=1;i <= rsmd.getColumnCount();i++){
					body[i] = rs.getObject(i)==null?"":rs.getObject(i).toString();
					
					Object obj = rs.getObject(i);
					if(obj!=null && foot[i] instanceof Long){
						foot[i] = (Long)foot[i]+((Number)obj).longValue();
					}else if(obj!=null && foot[i] instanceof Double){
						foot[i] = (Double)foot[i]+((Number)obj).doubleValue();
					}					
				}
				bodys.add(body);
			}
			pageData = new PageData(1,bodys.size(),bodys.size(),head,headType,bodys,foot);
			
			rs.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new DBQueryFailException(e.getMessage()+sql);
		}
		return pageData;
	}

	/**
	 * Description: 
	 * @param type
	 * @return
	 */
	private static Object getCountSum(int type) {
		Object sum;
		switch (type) {
		case Types.TINYINT:
		case Types.SMALLINT:
		case Types.INTEGER:
		case Types.BIGINT:
			sum=new Long(0);
			break;
		case Types.REAL:
		case Types.NUMERIC:
		case Types.FLOAT:
		case Types.DOUBLE:
		case Types.DECIMAL:
			sum=new Double(0);
			break;
		default:
			sum="";
			break;
		}
		return sum;
	}

	/**
	 * Description: 数据分页查询
	 * @param dataSource　数据库连接
	 * @param sql　查询语句
	 * @param page 当前页
	 * @param pageSize 页记录数
	 * @return 报表数据对象
	 */
	public static PageData Query(String dataSource, String sql, int page, int pageSize, int maxRows){
		PageData pageData = null;
		Connection conn = getConnection(dataSource);
		try {
			Statement statement = conn.createStatement();
			if(maxRows>0){
				statement.setMaxRows(maxRows);
			}
			ResultSet countRs = statement.executeQuery(getCountSql(sql));
			countRs.next();
			int count = countRs.getBigDecimal(1).intValue();
			page = getRealPage(page,pageSize,count);
			
			ResultSet rs = statement.executeQuery(KReportContext.config.getDialect(KReportContext.kReports.getDataSource(dataSource).getDriver()).getPageableSql(sql,page,pageSize));
			ResultSetMetaData rsmd = rs.getMetaData();
			
			String[] head = new String[rsmd.getColumnCount()]; 
			int[] headType = new int[rsmd.getColumnCount()+1]; 

			Object[] foot = new Object[rsmd.getColumnCount()];
			
			head[0] = "序号";
			headType[0]=4; //整型
			foot[0] = "";
			
			for(int i=1;i< rsmd.getColumnCount();i++){
				head[i] = rsmd.getColumnName(i);
				headType[i] = rsmd.getColumnType(i);
				foot[i]=getCountSum(rsmd.getColumnType(i));
			}
			
			List<String[]> bodys = new ArrayList<String[]>();
			int index = 0;
			while(rs.next()){
				String[] body = new String[rsmd.getColumnCount()]; 
				body[0] = ++index + "";
				for(int i=1;i < rsmd.getColumnCount();i++){
					body[i] = rs.getObject(i)==null?"":rs.getObject(i).toString();
					
					Object obj = rs.getObject(i);
					if(obj!=null && foot[i] instanceof Long){
						foot[i] = (Long)foot[i]+((Number)obj).longValue();
					}else if(obj!=null && foot[i] instanceof Double){
						foot[i] = (Double)foot[i]+((Number)obj).doubleValue();
					}
				}
				bodys.add(body);
			}
			pageData = new PageData(page,pageSize,count,head,headType,bodys,foot);
			
			countRs.close();
			rs.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new DBQueryFailException(e.getMessage()+"(分页)"+sql);
		}
		return pageData;
	}

	
	/**
	 * Description: 取实际页
	 * @param page 当前页
	 * @param pageSize 页记录数
	 * @param count 总记录数
	 * @return
	 */
	private static int getRealPage(int page,int pageSize,int count){
		int countPage = (count+pageSize-1)/pageSize;
		if(page>countPage)page=countPage;
		if(page<=1) page=1;
		return page;
	}
	
	/**
	 * Description: 构造记录数sql
	 * @param sql 原sql
	 * @return 记录数sql
	 */
	private static String getCountSql(String sql){
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select count(*) from(").append("\n");
		sqlBuffer.append(sql).append("\n");
		sqlBuffer.append(") countsql");
		return sqlBuffer.toString();
	}
	
	

	/**
	 * Description: 生成sql语句
	 * @param kReport 报表
	 * @param param  参数
	 * @return sql语句
	 */
	public static KSqlParser createKSqlParser(KReport kReport, Map<String, Object> param) {
		KSqlParser kSqlParser = new KSqlParser(kReport.getkSql());
		Map<String, Condition> conditions = kReport.getConditions();
		for(String name:param.keySet()){
			Object obj = param.get(name);
			if(conditions.containsKey(name)){
				Condition condition = conditions.get(name);
				ReturnType returnType = KReportContext.config.getReturnType(condition.getReturnType());
				if(obj instanceof String){
					kSqlParser.setParam(name, returnType.getKsqlString(condition, (String)obj));
				}else{
					kSqlParser.setParam(name, returnType.getKsqlString(condition, (String[])obj));
				}				
			}else{
				if(obj instanceof String){
					kSqlParser.setParam(name, (String)obj);
				}else{
					kSqlParser.setParam(name, ((String[])obj)[0]);
				}
			}
		}
		return kSqlParser;
	}
	
	/**
	 * Description: 生成sql语句
	 * @param kReport 报表
	 * @param param  参数
	 * @return sql语句
	 */
	public static KSqlParser createKSqlParser(KReport kReport, Map<String, Object> param, String kSql) {
		KSqlParser kSqlParser = new KSqlParser(kSql);
		Map<String, Condition> conditions = kReport.getConditions();
		for(String name:param.keySet()){
			Object obj = param.get(name);
			if(conditions.containsKey(name)){				
				Condition condition = conditions.get(name);
				ReturnType returnType = KReportContext.config.getReturnType(condition.getReturnType());
				if(obj instanceof String){
					kSqlParser.setParam(name, returnType.getKsqlString(condition, (String)obj));
				}else{
					kSqlParser.setParam(name, returnType.getKsqlString(condition, (String[])obj));
				}				
			}else{
				kSqlParser.setParam(name, (String)obj);
			}
		}
		return kSqlParser;
	}
	
	/**
	 * Description: 获取数据库连接
	 * @param dataSourceName 数据库连接参数对象名
	 * @return 数据库连接
	 */
	public static Connection getConnection(String dataSourceName){
		DataSource dataSource = KReportContext.kReports.getDataSource(dataSourceName);
		Connection conn = null;
		try {
			Class.forName(dataSource.getDriver());
			conn = DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
		} catch (Exception e) {
			throw new DBConnectFailException(dataSource.getUrl());
		}
		return conn;
	}

}
