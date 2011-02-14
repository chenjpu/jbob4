/**
 * Created on 2010-5-15
 * @version v1.0
 *
 */
package cn.blsoft.krport.po;

import java.util.HashMap;
import java.util.Map;

import cn.blsoft.krport.exception.NullDataSourceException;
import cn.blsoft.krport.exception.NullKReportException;


/**
 * <p>Title:  KReports.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class KReports {	
	
	private Integer pageSize;
	
	private Integer conditionSize;
	
	private String skin;
	
	private String defaultDataSource;

	public Map<String, DataSource> dataSources = new HashMap<String, DataSource>();
	
	public Map<String, KReportGroup> kreportGroups = new HashMap<String, KReportGroup>();

		
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
	 * @return the dataSources
	 */
	public Map<String, DataSource> getDataSources() {
		return dataSources;
	}

	/**
	 * @param dataSources the dataSources to set
	 */
	public void setDataSources(Map<String, DataSource> dataSources) {
		this.dataSources = dataSources;
	}

	/**
	 * @return the kreportGroups
	 */
	public Map<String, KReportGroup> getKreportGroups() {
		return kreportGroups;
	}

	/**
	 * @param kreportGroups the kreportGroups to set
	 */
	public void setKreportGroups(Map<String, KReportGroup> kreportGroups) {
		this.kreportGroups = kreportGroups;
	}
	
	public KReport getKRport(String name){
		KReport kReport = null;
		for(KReportGroup kreportGroup:kreportGroups.values()){
			kReport = kreportGroup.getKreports().get(name);
			if(kReport!=null){
				break;
			}
		}
		if(kReport==null){
			throw new NullKReportException(name);
		}
		return kReport;
	}

	/**
	 * Description: 
	 * @param dataSourceName
	 * @return
	 */
	public DataSource getDataSource(String dataSourceName) {
		DataSource dataSource = this.dataSources.get(dataSourceName);
		if(dataSource==null){
			throw new NullDataSourceException(dataSourceName);
		}
		return dataSource;
	}

}
