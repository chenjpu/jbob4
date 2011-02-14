/**
 * Created on 2010-4-29
 * @version v1.0
 *
 */
package cn.blsoft.krport.htmlwidget;

import java.util.Map;

import cn.blsoft.krport.po.Condition;
import cn.blsoft.krport.util.StringUtil;

/**
 * <p>Title:  TextHtmlControl.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class InitActionHtmlWidget implements HtmlWidget{


	/* (non-Javadoc)
	 * @see cn.blsoft.krport.synthesizer.HtmlControl#getControlHtml()
	 */
	public String getHtml(Condition field, Map<String, Object> param) {
		StringBuffer htmlBuffer = new StringBuffer();
		htmlBuffer.append("\n\t\t\t<script type='text/javascript'>\n\t\t\t\taddEvent(window,'onload',function(){\n").append(StringUtil.objectToString(field.getExtend())).append(";\n\t\t\t\t});</script>");
		return htmlBuffer.toString();
	}

	/* (non-Javadoc)
	 * @see cn.blsoft.krport.htmlwidget.HtmlWidget#isHide()
	 */
	public boolean isHide() {
		return true;
	}

	
}
