/**
 *Created on 2009-10-24
 */
package cn.blsoft.krport.query;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>Title:  SqlStringFactory.java </p>  
 * <p>Description: SQL语句构造器</p>
 * <p>语法与sql一致</p>
 * <p>${参数名}:参数标签 代替参数，有效sql代码中不能有未赋值参数</p>
 * <p>#[sql代码段]:存在标签 当标签内有未赋值参数时，将标签内sql代码视为无效</p>
 * <p></p>
 * <p>Created in 2009-10-24</p>
 * <p>Company: Eshore Technology Co.Ltd.</p>
 *
 * @author wangzhiping 
 * @version v1.0
 */
public class KSqlParser {
	
	/*
	 * #[${}]无效规则
	 */
	private final String INVALIDREGEX = "\\#\\[[^\\}\\]]*\\$\\{[^\\}\\]]+\\}[^\\]]*\\]";
	/*
	 * #[]有效规则
	 */
	private final String VALIDREGEX = "\\#\\[([^\\]]*)\\]";
	
	/*
	 * 原始类SQL语句，在sql基础上用${参数名}来代替插入部分
	 */
	private String ksql;
	
	/*
	 * 参数Map
	 */
	private Map<String,String> parameterMap = new HashMap<String,String>();

	public KSqlParser(){};
	
	public KSqlParser(String ksql){
		setKsql(ksql);
	}
	


	/**
	 * Description: 获取SQL
	 * @return SQL
	 */
	public String getSql() {
		String sqlString = ksql;
		for(String key:parameterMap.keySet()){
			sqlString = sqlString.replace("${" + key + "}", parameterMap.get(key));
		}
		Pattern validPattern = Pattern.compile(VALIDREGEX); //有效规则
		Pattern inValidPattern = Pattern.compile(INVALIDREGEX);//无效规则
		Matcher matcher = inValidPattern.matcher(sqlString);
		while(matcher.find()){//无效去掉#[]的内容
			sqlString = matcher.replaceAll("");
			matcher = inValidPattern.matcher(sqlString);
		}
		matcher = validPattern.matcher(sqlString);
		while(matcher.find()){//无效去掉#[]的内容
			matcher = matcher.reset();
			while(matcher.find()){
				sqlString = sqlString.replace(matcher.group(0), matcher.group(1));//有效去掉#[]标签
			}
			matcher = validPattern.matcher(sqlString);
		}

		return sqlString;
	}

	/**
	 * Description: 设置原始类SQL
	 * @param sql 原始类SQL
	 */
	public void setKsql(String ksql) {
		this.ksql = ksql;
	}

	/**
	 * Description: 获取已设置参数Map
	 * @return 参数Map
	 */
	public Map<String, String> getParameterMap() {
		return parameterMap;
	}
    
	/**
	 * Description: 设置字符串参数
	 * @param parameter 参数名
	 * @param string 字符串
	 */
	public void setParam(String parameter,String value){
		if(null!=value && !"".equals(value.trim())){
			parameterMap.put(parameter, value);
		}
	}
			
	/**
	 * Description: 移除参数
	 * @param parameter
	 */
	public void remove(String parameter) {
		parameterMap.remove(parameter);
	}
	
	/**
	 * Description: 移除所有参数
	 */
	public void removeAll() {
		parameterMap.clear();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return getSql();		
	}
}
