/**
 *Created on 2009-9-23
 */
package cn.blsoft.krport.render;


/**
 * <p>Title:  StringRender.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class StringRender implements Render {

	/* (non-Javadoc)
	 * @see com.eshore.render.Render#rend(java.lang.Object)
	 */
	public String rend(Object data) {		
		return data==null?"":data.toString();
	}

}
