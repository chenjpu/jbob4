/**
 * Created on 2010-4-29
 * @version v1.0
 *
 */
package cn.blsoft.krport.htmlwidget;

import java.util.Date;
import java.util.Map;

import cn.blsoft.krport.engine.KReportContext;
import cn.blsoft.krport.po.Condition;
import cn.blsoft.krport.util.DateUtil;
import cn.blsoft.krport.util.StringUtil;

/**
 * <p>Title:  TextHtmlControl.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class DateHtmlWidget implements HtmlWidget{


	/* (non-Javadoc)
	 * @see cn.blsoft.krport.synthesizer.HtmlControl#getControlHtml()
	 */
	public String getHtml(Condition field, Map<String, Object> param) {
		StringBuffer htmlBuffer = new StringBuffer();
		String defaultTime = "";
		if(!StringUtil.isBlank(field.getDefaultValue())){
			Date date = new Date();
			try{
				date = DateUtil.moveDate(date, field.getDefaultValue());
			}catch(Exception e){
				date = new Date();
			}
			defaultTime = DateUtil.DateToString(date, field.getExtend());
		}
		htmlBuffer.append("\n\t\t\t<script type='text/javascript' src='").append(KReportContext.BASE).append("/kReport/js/DatePicker/WdatePicker.js'></script>");
		htmlBuffer.append("\n\t\t\t<input type='text' id='").append(field.getName()).append("' name='")
			.append(field.getName()).append("' value='").append(defaultTime).append("'  onfocus=\"WdatePicker({dateFmt:'").append(field.getExtend()).append("'})\" readonly='true' class='Wdate'/>");
		return htmlBuffer.toString();
	}

	/* (non-Javadoc)
	 * @see cn.blsoft.krport.htmlwidget.HtmlWidget#isHide()
	 */
	public boolean isHide() {
		return false;
	}
	


	
}
