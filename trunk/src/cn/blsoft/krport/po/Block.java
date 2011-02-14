/**
 * Created on 2010-7-14
 * @version v1.0
 *
 */
package cn.blsoft.krport.po;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title:  block.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
@SuppressWarnings("serial")
public class Block implements Serializable {
	
	private String name;
		
	private String displayName;
	
	private List<KReport> kReports;

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
	 * @return the kReports
	 */
	public List<KReport> getkReports() {
		return kReports;
	}

	/**
	 * @param kReports the kReports to set
	 */
	public void setkReports(List<KReport> kReports) {
		this.kReports = kReports;
	} 
	
	
}
