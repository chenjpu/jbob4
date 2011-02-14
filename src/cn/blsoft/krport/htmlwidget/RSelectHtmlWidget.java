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
public class RSelectHtmlWidget implements HtmlWidget{


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
		StringBuffer optionHtmlBuffer = new StringBuffer("\n\t\t\t\t<option value=''>请选择</option>");
		//optionHtmlBuffer.append("\n\t\t\t\t<script type='text/javascript' src='").append(KReportContext.BASE).append("/kReport/js/rSelect/rSelect.js'></script>");
		optionHtmlBuffer.append("\n\t\t\t\t<script type='text/javascript'>");
		optionHtmlBuffer.append("\n//关联多选项");
		optionHtmlBuffer.append("\nfunction _RselectValue(parent,value,text){");
		optionHtmlBuffer.append("\n\tthis.parent=parent; //父项值");
		optionHtmlBuffer.append("\n\tthis.value=value;\t//项值");
		optionHtmlBuffer.append("\n\tthis.text=text;\t\t//项显示文本");
		optionHtmlBuffer.append("\n}");
		optionHtmlBuffer.append("\n");
		optionHtmlBuffer.append("\n//添加事件");
		optionHtmlBuffer.append("\nfunction _rSelectAddEvent(obj,e,func,params){");
		optionHtmlBuffer.append("\n\tvar param = \"\";");
		optionHtmlBuffer.append("\n\tif(params){");
		optionHtmlBuffer.append("\n\t\tfor(var i=0;i<params.length;i++){");
		optionHtmlBuffer.append("\n\t\t\tparam += \",'\"+params[i]+\"'\";");
		optionHtmlBuffer.append("\n\t\t}");
		optionHtmlBuffer.append("\n\t\tif(param.length>1)param=param.substr(1);");
		optionHtmlBuffer.append("\n\t}");
		optionHtmlBuffer.append("\n\teval(\"var oldfunc=obj.\"+e+\";\");");
		optionHtmlBuffer.append("\n\tif(typeof oldfunc!='function'){");
		optionHtmlBuffer.append("\n\t\teval(\"obj.\"+e+\"=function(){func(\"+param+\");}\");");
		optionHtmlBuffer.append("\n\t}else{");
		optionHtmlBuffer.append("\n\t\teval(\"obj.\"+e+\"=function(){\toldfunc();func(\"+param+\");}\");");
		optionHtmlBuffer.append("\n\t}");
		optionHtmlBuffer.append("\n}");
		optionHtmlBuffer.append("\n");
		optionHtmlBuffer.append("\n//change事件");
		optionHtmlBuffer.append("\nfunction _rSelectChange(l1_name,l2_name){\t");
		optionHtmlBuffer.append("\n\tvar l1=document.getElementsByName(l1_name)[0];");
		optionHtmlBuffer.append("\n\tvar l2=document.getElementsByName(l2_name)[0];");
		optionHtmlBuffer.append("\n\tfor(i=l2.length-1;i>0;i--){");
		optionHtmlBuffer.append("\n\t\tl2.options[i]=null;");
		optionHtmlBuffer.append("\n\t}");
		optionHtmlBuffer.append("\n\tif(l1.value!=\"\"){");
		optionHtmlBuffer.append("\n\t\tvar j=0;");
		optionHtmlBuffer.append("\n\t\teval(\"for(i=0;i<\"+l2_name+\"_rValues.length;i++)if(\"+l2_name+\"_rValues[i].parent==l1.value)l2.options[++j]=new Option(\"+l2_name+\"_rValues[i].text,\"+l2_name+\"_rValues[i].value);\");\t\t\t");
		optionHtmlBuffer.append("\n\t}");
		optionHtmlBuffer.append("\n\tl2.options[0].selected=true;");
		optionHtmlBuffer.append("\n\tif(typeof l2.onchange=='function'){");
		optionHtmlBuffer.append("\n\t\tl2.onchange();");
		optionHtmlBuffer.append("\n\t}");
		optionHtmlBuffer.append("\n}");  
		optionHtmlBuffer.append("\n\t\t\t\tvar ").append(field.getName()).append("_rValues=[];");
		
		int index = field.getExtend().indexOf(":");
		String pfieldName = field.getExtend().substring(0, index).trim();
		String extend = field.getExtend().substring(index+1).trim();
		if(extend.startsWith("{") && extend.endsWith("}")){
			extend = extend.substring(1, extend.length()-1);
			String[] options = filtrate(extend).split(",");
			for(int i=0;i<options.length;i++){
				String[] option = options[i].split(":");
				if(option.length==3){
					optionHtmlBuffer.append("\n\t\t\t\t").append(field.getName()).append("_rValues.push(new _RselectValue('").append(StringUtil.toJSString(refiltrate(option[0]))).append("','").append(StringUtil.toJSString(refiltrate(option[1]))).append("','").append(StringUtil.toJSString(refiltrate(option[2]))).append("'));");
				}
			}
		}else{
			PageData pageData = SqlQuery.Query(field.getKReport(), param, extend, 0);
			List<String[]> options = pageData.getBodys();
			for(int i=0;i<options.size();i++){
				String[] option = options.get(i);
				if(option.length==3){
					optionHtmlBuffer.append("\n\t\t\t\t").append(field.getName()).append("_rValues.push(new _RselectValue('").append(StringUtil.toJSString(option[1])).append("','").append(StringUtil.toJSString(option[2])).append("','").append(StringUtil.toJSString(option[2])).append("'));");
				}else if(option.length>=4){
					optionHtmlBuffer.append("\n\t\t\t\t").append(field.getName()).append("_rValues.push(new _RselectValue('").append(StringUtil.toJSString(option[1])).append("','").append(StringUtil.toJSString(option[2])).append("','").append(StringUtil.toJSString(option[3])).append("'));");
				}
			}
		}		
		
		optionHtmlBuffer.append("\n\t\t\t\t_rSelectAddEvent(window,'onload',function(){");
		optionHtmlBuffer.append("\n\t\t\t\t\tvar l1=document.getElementsByName('").append(pfieldName).append("')[0];");
		optionHtmlBuffer.append("\n\t\t\t\t\tvar l2=document.getElementsByName('").append(field.getName()).append("')[0];");
		optionHtmlBuffer.append("\n\t\t\t\t\t_rSelectChange('").append(pfieldName).append("','").append(field.getName()).append("');	");
		optionHtmlBuffer.append("\n\t\t\t\t\t_rSelectAddEvent(l1,'onchange',_rSelectChange,['").append(pfieldName).append("','").append(field.getName()).append("']);	");
		if(field.getDefaultValue()!=null){
			optionHtmlBuffer.append("\n\t\t\t\t\tl2.value=\"").append(field.getDefaultValue()).append("\";");
		}
		optionHtmlBuffer.append("\n\t\t\t\t});");
		optionHtmlBuffer.append("\n\t\t\t\t</script>");
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
