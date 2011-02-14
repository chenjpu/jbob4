/**
 * Created on 2010-4-29
 * @version v1.0
 *
 */
package cn.blsoft.krport.htmlwidget;

import java.util.Map;

import cn.blsoft.krport.po.Condition;

/**
 * <p>Title:  TextHtmlControl.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class BlankHtmlWidget implements HtmlWidget{


	/* (non-Javadoc)
	 * @see cn.blsoft.krport.synthesizer.HtmlControl#getControlHtml()
	 */
	public String getHtml(Condition field, Map<String, Object> param) {
		StringBuffer htmlBuffer = new StringBuffer();
		htmlBuffer.append("&nbsp");
		return htmlBuffer.toString();
	}

	/* (non-Javadoc)
	 * @see cn.blsoft.krport.htmlwidget.HtmlWidget#isHide()
	 */
	public boolean isHide() {
		return false;
	}

	
}
