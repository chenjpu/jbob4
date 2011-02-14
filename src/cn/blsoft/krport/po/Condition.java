/**
 * Created on 2010-4-29
 * @version v1.0
 *
 */
package cn.blsoft.krport.po;

/**
 * <p>Title:  ConditionField.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class Condition implements Comparable<Condition>{

	private String name;
	
	private String displayName;
	
	private int index;
	
	private String type;
	
	private String defaultValue;
	
	private String extend;
	
	private String returnType;
	
	private String valid;
	
	private Boolean required;

	private KReport kReport;
	
	public Condition(KReport kReport){
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the defaultValue
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * @param defaultValue the defaultValue to set
	 */
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	/**
	 * @return the extend
	 */
	public String getExtend() {
		return extend;
	}

	/**
	 * @param extend the extend to set
	 */
	public void setExtend(String extend) {
		this.extend = extend;
	}
	

	/**
	 * @return the returnType
	 */
	public String getReturnType() {
		return returnType;
	}

	/**
	 * @param returnType the returnType to set
	 */
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
		
	/**
	 * @return the valid
	 */
	public String getValid() {
		return valid;
	}

	/**
	 * @param valid the valid to set
	 */
	public void setValid(String valid) {
		this.valid = valid;
	}
	
	

	/**
	 * @return the required
	 */
	public Boolean getRequired() {
		return required;
	}

	/**
	 * @param required the required to set
	 */
	public void setRequired(Boolean required) {
		this.required = required;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Condition o) {
		return null==o?1:this.index-o.index;
	}
	
	
	
}
