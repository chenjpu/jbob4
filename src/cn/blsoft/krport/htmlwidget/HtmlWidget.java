/**
 * Created on 2010-4-29
 * @version v1.0
 *
 */
package cn.blsoft.krport.htmlwidget;

import java.util.Map;

import cn.blsoft.krport.po.Condition;

/**
 * <p>Title:  HtmlControl.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public interface HtmlWidget {
	
	public String getHtml(Condition condition, Map<String, Object> param);
	
	public boolean isHide();
}
