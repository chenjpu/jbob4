/**
 * 
 */
package cn.blsoft.krport.po;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>Title:  CrossKey.java</p>    
 * <p>Description: </p>
 * <p>Created in 2010-8-16</p>
 * <p>Company: Eshore Technology Co.Ltd.</p>
 *
 * @author wangzhiping
 * @version v1.8
 */
@SuppressWarnings("unchecked")
public class CrossKey<T extends Comparable> implements Comparable<CrossKey<T>>{
	
	private T sortObj;
	
	private String fieldName;
	
	private String key;
	
	Map<String, Double> values;
	
	CrossKey parent;
	
	List<CrossKey> childs = new ArrayList<CrossKey>();
	
	public CrossKey() {}
	
	public CrossKey(String fieldName, T sortObj, String key){
		this.fieldName=fieldName;
		this.sortObj=sortObj;
		this.key=key;
	}

	public CrossKey(String fieldName, T sortObj, String key, CrossKey parent){
		this.fieldName=fieldName;
		this.sortObj=sortObj;
		this.key=key;
		this.parent=parent;
	}
	
	public void addChildCrossKey(CrossKey child){
		CrossKey ck = getChild(child.key);
		if(child.childs.size()==0){
			if(ck!=null){
				Map<String,Double> childValue = child.getValues();
				for(String vkey:childValue.keySet()){
					Double value = (Double) ck.getValues().get(vkey) + childValue.get(vkey);
					ck.getValues().put(vkey,value);
				}
			}else{
				childs.add(child);
			}
		}else{
			if(ck!=null){
				ck.addChildCrossKey((CrossKey) child.childs.get(0));
			}else{
				childs.add(child);
			}
		}
	}
	
	public int getSize(){
		if(childs.size()==0){
			return 1;
		}else{
			int size = 0;
			for(CrossKey child:childs){
				size += child.getSize();
			}
			return size;
		}
	}
	
	public Map<String,Double> getValues(){
		if(childs.size()==0){
			return values;			
		}else{
			if(values==null){
				values=new HashMap<String,Double>();
				for(CrossKey child:childs){
					Map<String,Double> childValues=child.getValues();
					for(String key:childValues.keySet()){
						if(!values.containsKey(key)){
							values.put(key, childValues.get(key));
						}else{
							values.put(key, values.get(key)+childValues.get(key));
						}
					}
				}
			}
			return values;
		}
	}

	public int compareTo(CrossKey<T> o) {
		if(o==null)return 1;
		int index = sortObj.compareTo(o.sortObj);
		if(index==0){
			return key.compareTo(o.key);
		}else{
			return  index;
		}
	}


	public String toString() {		
		return this.key+" : "+this.sortObj;
	}

	/**
	 * @return the sortObj
	 */
	public T getSortObj() {
		return sortObj;
	}

	/**
	 * @param sortObj the sortObj to set
	 */
	public void setSortObj(T sortObj) {
		this.sortObj = sortObj;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * @return the parent
	 */
	public CrossKey getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(CrossKey parent) {
		this.parent = parent;
	}

	/**
	 * @return the childs
	 */
	public List<CrossKey> getChilds() {
		return childs;
	}

	/**
	 * @param childs the childs to set
	 */
	public void setChilds(List<CrossKey> childs) {
		this.childs = childs;
	}

	/**
	 * @param values the values to set
	 */
	public void setValues(Map<String, Double> values) {
		this.values = values;
	}
	
	public CrossKey getChild(String childKey){
		for(CrossKey child:childs){
			if(child.key.equals(childKey)){
				return child;
			}
		}
		return null;
	}


	public CrossKey clone() {
		CrossKey clone = new CrossKey(fieldName,sortObj,key,parent);
		for(CrossKey child:childs){
			clone.childs.add(child.clone());
		}
		if(values!=null){
			Map<String, Double> cloneValues = new HashMap<String, Double>();
			for(String valueName:values.keySet()){
				cloneValues.put(valueName, values.get(valueName));
			}
			clone.setValues(cloneValues);
		}
		return clone;
	}
	
	public Object getValue(String key){
		Double value = getValues().get(key);
		if(value.longValue()==value){
			return value.longValue();
		}else{
			return value;
		}
		
	}
	
	public String getQueryString(){
		if(this.parent==null){
			return this.fieldName+"="+this.key;
		}else{
			return this.parent.getQueryString()+"&"+this.fieldName+"="+this.key;
		}
	}
	
}
