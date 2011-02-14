/**
 * Created on 2010-4-29
 * @version v1.0
 *
 */
package cn.blsoft.krport.htmlwidget;

import java.util.List;
import java.util.Map;

import cn.blsoft.krport.engine.KReportContext;
import cn.blsoft.krport.po.Condition;
import cn.blsoft.krport.po.PageData;
import cn.blsoft.krport.query.SqlQuery;
import cn.blsoft.krport.util.StringUtil;

/**
 * <p>Title:  TextHtmlControl.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class MSelectHtmlWidget implements HtmlWidget{


	/* (non-Javadoc)
	 * @see cn.blsoft.krport.htmlcontrol.HtmlControl#getControlHtml(cn.blsoft.krport.synthesizer.Condition)
	 */
	public String getHtml(Condition field, Map<String, Object> param) {
		StringBuffer htmlBuffer = new StringBuffer();
		htmlBuffer.append("\n\t\t\t<script type='text/javascript' src='").append(KReportContext.BASE).append("/kReport/js/mSelect/mSelect.js'></script>");
		htmlBuffer.append("\n\t\t\t<link rel='stylesheet' type='text/css' href='").append(KReportContext.BASE).append("/kReport/js/mSelect/mSelect.css'/>");
		htmlBuffer.append("\n\t\t\t<input id='_mselect_text_").append(field.getName()).append("' onfocus='_mselect_doSelect(\"").append(field.getName()).append("\");' readonly class='mselect'/>");
		htmlBuffer.append("\n\t\t\t<div class='mselect_hideDiv' id='_mselect_div_").append(field.getName()).append("'>");
		htmlBuffer.append("\n\t\t\t\t<div class='mselect_tableDiv'>");
		htmlBuffer.append("\n\t\t\t\t\t<table>");
		htmlBuffer.append(getOptions(field, param));
		htmlBuffer.append("\n\t\t\t\t\t</table>");
		htmlBuffer.append("\n\t\t\t\t</div>");
		htmlBuffer.append("\n\t\t\t\t<div><hr></div>");
		htmlBuffer.append("\n\t\t\t\t<div align='right'><input type='button' value='确定' onClick='_mselect_hideSelect(\"").append(field.getName()).append("\")'/></div>");
		htmlBuffer.append("\n\t\t\t</div>");

		return htmlBuffer.toString();
	}
	
	private String getOptions(Condition field, Map<String, Object> param){
		StringBuffer optionHtmlBuffer = new StringBuffer();
		String extend = field.getExtend().trim();
		if(extend.startsWith("{") && extend.endsWith("}")){
			extend = extend.substring(1, extend.length()-1);
			String[] options = filtrate(extend).split(",");
			for(int i=0;i<options.length;i++){
				String[] option = options[i].split(":");
				if(option.length==2){
					optionHtmlBuffer.append("\n\t\t\t\t\t\t<tr><td width='10'><input type='checkbox' name='").append(field.getName()).append("' value=\"").append(StringUtil.toHtmlString(refiltrate(option[0]))).append("\"/></td><td>").append(StringUtil.toHtmlString(refiltrate(option[1]))).append("</td></tr>");
				}
			}
		}else{
			PageData pageData = SqlQuery.Query(field.getKReport(), param, field.getExtend(), 0);
			List<String[]> options = pageData.getBodys();
			for(int i=0;i<options.size();i++){
				String[] option = options.get(i);
				if(option.length==2){
					optionHtmlBuffer.append("\n\t\t\t\t\t\t<tr><td width='10'><input type='checkbox' name='").append(field.getName()).append("' value=\"").append(StringUtil.toHtmlString(option[1])).append("\"/></td><td>").append(StringUtil.toHtmlString(option[1])).append("</td></tr>");
				}else if(option.length>=3){
					optionHtmlBuffer.append("\n\t\t\t\t\t\t<tr><td width='10'><input type='checkbox' name='").append(field.getName()).append("' value=\"").append(StringUtil.toHtmlString(option[1])).append("\"/></td><td>").append(StringUtil.toHtmlString(option[2])).append("</td></tr>");
				}
			}
		}
		if(optionHtmlBuffer.length()==0){
			optionHtmlBuffer.append("<tr><td>无可选值<td><tr>");
		}
		return optionHtmlBuffer.toString();
	}

	private String filtrate(String d){
		if(d==null)return null;
		return d.replace("\\\\", "@replace@").replace("\\,", "@comma@").replace("\\:", "@colon@");
	}
	
	private String refiltrate(String d){
		if(d==null)return null;
		return d.replace("@comma@", ",").replace("@replace@", "\\").replace("@colon@", ":");
	}

	/* (non-Javadoc)
	 * @see cn.blsoft.krport.htmlwidget.HtmlWidget#isHide()
	 */
	public boolean isHide() {
		return false;
	}
}
