/**
 * Created on 2010-5-2
 * @version v1.0
 *
 */
package cn.blsoft.krport.po;

import java.util.List;

/**
 * <p>Title:  Action.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class PageAction implements Comparable<PageAction>{

	private String name;
	
	private String displayName;
	
	private String action;
	
	private List<String> scripts;

	private int index;	

	private KReport kReport;
	
	public PageAction(KReport kReport){
		this.kReport = kReport;
	}
	
	public KReport getKReport(){
		return this.kReport;
	}
	
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
	 * @return the action
	 */
	public String getAction() {
		if(null==action)return "#";
		if(!action.startsWith("javascript:") && action.indexOf("(")>0)return "javascript:"+action;
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
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
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
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
	 * @return the kReport
	 */
	public KReport getkReport() {
		return kReport;
	}

	/**
	 * @param kReport the kReport to set
	 */
	public void setkReport(KReport kReport) {
		this.kReport = kReport;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(PageAction o) {
		return null==o?1:this.index-o.index;
	}
}
