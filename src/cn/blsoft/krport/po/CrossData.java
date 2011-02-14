/**
 * 
 */
package cn.blsoft.krport.po;

/**
 * <p>Title:  CrossData.java</p>    
 * <p>Description: </p>
 * <p>Created in 2010-8-18</p>
 * <p>Company: Eshore Technology Co.Ltd.</p>
 *
 * @author wangzhiping
 * @version v1.8
 */
public class CrossData {
	CrossKey topRowKey = new CrossKey();	
	CrossKey topColKey = new CrossKey();
	CrossKey topCellKey = new CrossKey();
	/**
	 * @return the topRowKey
	 */
	public CrossKey getTopRowKey() {
		return topRowKey;
	}
	/**
	 * @param topRowKey the topRowKey to set
	 */
	public void setTopRowKey(CrossKey topRowKey) {
		this.topRowKey = topRowKey;
	}
	/**
	 * @return the topColKey
	 */
	public CrossKey getTopColKey() {
		return topColKey;
	}
	/**
	 * @param topColKey the topColKey to set
	 */
	public void setTopColKey(CrossKey topColKey) {
		this.topColKey = topColKey;
	}
	/**
	 * @return the cellKey
	 */
	public CrossKey getTopCellKey() {
		return topCellKey;
	}
	/**
	 * @param cellKey the cellKey to set
	 */
	public void setTopCellKey(CrossKey cellKey) {
		this.topCellKey = topCellKey;
	}
	
}