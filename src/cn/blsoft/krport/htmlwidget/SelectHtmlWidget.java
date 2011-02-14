/**
 * Created on 2010-4-29
 * @version v1.0
 *
 */
package cn.blsoft.krport.htmlwidget;

import java.util.List;
import java.util.Map;

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
public class SelectHtmlWidget implements HtmlWidget{


	/* (non-Javadoc)
	 * @see cn.blsoft.krport.htmlcontrol.HtmlControl#getControlHtml(cn.blsoft.krport.synthesizer.Condition)
	 */
	public String getHtml(Condition field, Map<String, Object> param) {
		StringBuffer htmlBuffer = new StringBuffer();
		htmlBuffer.append("\n\t\t\t<select id='").append(field.getName()).append("' name='")
			.append(field.getName()).append("'>");
		htmlBuffer.append(getOptions(field, param));
		htmlBuffer.append("\n\t\t\t</select>");
		return htmlBuffer.toString();
	}
	
	private String getOptions(Condition field, Map<String, Object> param){
		StringBuffer optionHtmlBuffer = new StringBuffer("\n\t\t\t\t<option value=''>«Î—°‘Ò</option>");
		String extend = field.getExtend().trim();
		if(extend.startsWith("{") && extend.endsWith("}")){
			extend = extend.substring(1, extend.length()-1);
			String[] options = filtrate(extend).split(",");
			for(int i=0;i<options.length;i++){
				String[] option = options[i].split(":");
				if(option.length==2){
					optionHtmlBuffer.append("\n\t\t\t\t<option value=\"").append(StringUtil.toHtmlString(refiltrate(option[0]))).append("\" ").append(option[1]!=null&&refiltrate(option[1]).equals(field.getDefaultValue())?"selected":"").append(">").append(StringUtil.toHtmlString(refiltrate(option[1]))).append("</option>");
				}
			}
		}else{
			PageData pageData = SqlQuery.Query(field.getKReport(), param, field.getExtend(), 0);
			List<String[]> options = pageData.getBodys();
			for(int i=0;i<options.size();i++){
				String[] option = options.get(i);
				if(option.length==2){
					optionHtmlBuffer.append("\n\t\t\t\t<option value=\"").append(StringUtil.toHtmlString(option[1])).append("\" ").append(option[1]!=null&&option[1].equals(field.getDefaultValue())?"selected":"").append(">").append(StringUtil.toHtmlString(option[1])).append("</option>");
				}else if(option.length>=3){
					optionHtmlBuffer.append("\n\t\t\t\t<option value=\"").append(StringUtil.toHtmlString(option[1])).append("\" ").append(option[1]!=null&&option[1].equals(field.getDefaultValue())?"selected":"").append(">").append(StringUtil.toHtmlString(option[2])).append("</option>");
				}
			}
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
