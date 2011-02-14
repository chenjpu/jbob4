/**
 * Created on 2010-5-2
 * @version v1.0
 *
 */
package cn.blsoft.krport.po;

import java.util.List;
import java.util.Map;

import cn.blsoft.krport.engine.KReportContext;


/**
 * <p>Title:  KReport.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class KReport {
	
	private String name;
	
	private String displayName;
	
	private String comment;
		
	private Boolean pageable;

	private Integer pageSize;
		
	private Integer conditionSize;
	
	private String skin;
	
	private Map<String, PageAction> actions;
	
	private Map<String, Condition> conditions;	

	private Cross cross;
	
	private Data data;
	
	private String kSql;
	
	private List<String> scripts;
	
	private String dataSource;
	

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
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
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

	/**
	 * @return the actions
	 */
	public Map<String, PageAction> getActions() {
		return actions;
	}

	/**
	 * @param actions the actions to set
	 */
	public void setActions(Map<String, PageAction> actions) {
		this.actions = actions;
	}

	/**
	 * @return the conditions
	 */
	public Map<String, Condition> getConditions() {
		return conditions;
	}

	/**
	 * @param conditions the conditions to set
	 */
	public void setConditions(Map<String, Condition> conditions) {
		this.conditions = conditions;
	}

	/**
	 * @return the cross
	 */
	public Cross getCross() {
		return cross;
	}

	/**
	 * @param cross the cross to set
	 */
	public void setCross(Cross cross) {
		this.cross = cross;
	}

	/**
	 * @return the data
	 */
	public Data getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Data data) {
		this.data = data;
	}

	/**
	 * @return the kSql
	 */
	public String getkSql() {
		return kSql;
	}

	/**
	 * @param kSql the kSql to set
	 */
	public void setkSql(String kSql) {
		this.kSql = kSql;
	}

	/**
	 * @return the dataSource
	 */
	public String getDataSource() {
		return dataSource;
	}

	/**
	 * @param dataSource the dataSource to set
	 */
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * @return the scripts
	 */
	public List<String> getScripts() {
		return scripts;
	}

	/**
	 * @param scripts the scripts to set
	 */
	public void setScripts(List<String> scripts) {
		this.scripts = scripts;
	}

	
	/**
	 * @return the pageable
	 */
	public Boolean getPageable() {
		return pageable;
	}

	/**
	 * @param pageable the pageable to set
	 */
	public void setPageable(Boolean pageable) {
		this.pageable = pageable;
	}
	
	
	
	public boolean canPageable(){		
		return pageable
			&&KReportContext.config.getDialect(KReportContext.kReports.getDataSource(dataSource).getDriver())!=null
			&&KReportContext.config.getDialect(KReportContext.kReports.getDataSource(dataSource).getDriver()).getPageableSql("", 1, 1)!=null;		
	}
	
}
