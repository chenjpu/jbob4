/**
 * Created on 2010-5-15
 * @version v1.0
 *
 */
package cn.blsoft.krport.po;

import java.util.Map;

import cn.blsoft.krport.util.StringUtil;

/**
 * <p>Title:  Group.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class KReportGroup {
	
	private String name;
	
	private String namespace;
	
	private String path;
	
	private String displayName;
	
	private String defaultDataSource;	
	
	private Integer pageSize;
	
	private Integer conditionSize;
	
	private String skin;
	
	private Map<String, KReport> kreports;

	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the namespace
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * @param namespace the namespace to set
	 */
	public void setNamespace(String namespace) {
		if(StringUtil.isBlank(namespace)){
			this.namespace = "/";
		}else{
			this.namespace=namespace+"/";
		}
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		if(StringUtil.isBlank(path)){
			this.path = "/";
		}else{
			this.path=path+"/";
		}
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return the defaultDataSource
	 */
	public String getDefaultDataSource() {
		return defaultDataSource;
	}

	/**
	 * @param defaultDataSource the defaultDataSource to set
	 */
	public void setDefaultDataSource(String defaultDataSource) {
		this.defaultDataSource = defaultDataSource;
	}

	/**
	 * @return the kreports
	 */
	public Map<String, KReport> getKreports() {
		return kreports;
	}

	/**
	 * @param kreports the kreports to set
	 */
	public void setKreports(Map<String, KReport> kreports) {
		this.kreports = kreports;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the conditionSize
	 */
	public Integer getConditionSize() {
		return conditionSize;
	}

	/**
	 * @param conditionSize the conditionSize to set
	 */
	public void setConditionSize(Integer conditionSize) {
		this.conditionSize = conditionSize;
	}

	/**
	 * @return the skin
	 */
	public String getSkin() {
		return skin;
	}

	/**
	 * @param skin the skin to set
	 */
	public void setSkin(String skin) {
		this.skin = skin;
	}


}
