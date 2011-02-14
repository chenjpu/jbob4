/**
 *Created on 2009-8-31
 */
package cn.blsoft.krport.render;


/**
 * <p>Title:  DateRender.java </p>    
 * <p>Description:  ±º‰‰÷»æ∆˜</p>
 * <p>Created in 2009-8-31</p>
 * <p>Company: Eshore Technology Co.Ltd.</p>
 *
 * @author wangzhiping 
 * @version v1.0
 */
public class DateRender implements Render {

	/* (non-Javadoc)
	 * @see com.eshore.workorder.service.Render#rend(java.lang.Object)
	 */
	public String rend(Object data) {
		if(data==null) return "";
		return (String)data;
		//return DateUtil.DateToString((Date) data, "yyyy-MM-dd HH:mm");
	}

}
