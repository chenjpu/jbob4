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
public class HiddenHtmlWidget implements HtmlWidget{


	/* (non-Javadoc)
	 * @see cn.blsoft.krport.synthesizer.HtmlControl#getControlHtml()
	 */
	public String getHtml(Condition field, Map<String, Object> param) {
		StringBuffer htmlBuffer = new StringBuffer();
		htmlBuffer.append("\n\t\t\t<input type='hidden' id='").append(field.getName()).append("' name='")
			.append(field.getName()).append("' value='").append(StringUtil.objectToString(field.getDefaultValue())).append("' />");

		return htmlBuffer.toString();
	}

	/* (non-Javadoc)
	 * @see cn.blsoft.krport.htmlwidget.HtmlWidget#isHide()
	 */
	public boolean isHide() {
		return true;
	}

	
}
