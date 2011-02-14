/**
 * Created on 2010-4-29
 * @version v1.0
 *
 */
package cn.blsoft.krport.htmlwidget;

import java.util.Map;

import cn.blsoft.krport.engine.KReportContext;
import cn.blsoft.krport.po.Condition;
import cn.blsoft.krport.util.StringUtil;

/**
 * <p>Title:  TextHtmlControl.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class RefreshHtmlWidget implements HtmlWidget{


	/* (non-Javadoc)
	 * @see cn.blsoft.krport.synthesizer.HtmlControl#getControlHtml()
	 */
	public String getHtml(Condition field, Map<String, Object> param) {
		StringBuffer htmlBuffer = new StringBuffer();
		int total = 60;
		try{
			total = Integer.parseInt(StringUtil.objectToString(field.getDefaultValue()));
		}catch(Exception e){
		}
		htmlBuffer.append("\n\t\t\t<div><input id='").append(field.getName()).append("_remain' type='text'  disabled='disabled' style='width:30px; text-align:center'/>/")
				  .append("<input id='").append(field.getName()).append("_total' type='text'  style='width:30px; text-align:center' value=").append(total).append(" onchange='_").append(field.getName()).append("_change()'/>s&nbsp;")
				  .append("<img title='刷新' src='").append(KReportContext.BASE).append("/kReport/js/refresh/refresh.gif' onclick='_").append(field.getName()).append("_do()' /></div>");
		
		htmlBuffer.append("\n<script type='text/javascript'>");
		htmlBuffer.append("\n\t\tvar ").append(field.getName()).append("_total=").append(total).append(";");   
		htmlBuffer.append("\n\t\tvar ").append(field.getName()).append("_remain=").append(total).append(";");
		htmlBuffer.append("\n\t\tfunction _").append(field.getName()).append("_run(){");
		htmlBuffer.append("\n\t\tif(").append(field.getName()).append("_remain==0){");
		htmlBuffer.append("\n\t\t\t\t_").append(field.getName()).append("_do();");
		htmlBuffer.append("\n\t\t}else{");
		htmlBuffer.append("\n\t\t\t\t").append(field.getName()).append("_remain--;");
		htmlBuffer.append("\n\t\t}");
		htmlBuffer.append("\n\t\tdocument.getElementById('").append(field.getName()).append("_remain').value=").append(field.getName()).append("_remain;");
		htmlBuffer.append("\n\t\tsetTimeout('_").append(field.getName()).append("_run()',1000);");
		htmlBuffer.append("\n\t\t}");
		htmlBuffer.append("\n\t\t");
		htmlBuffer.append("\n\t\tfunction _").append(field.getName()).append("_change(){");
		htmlBuffer.append("\n\t\t\t\tvar total = document.getElementById('").append(field.getName()).append("_total');");
		htmlBuffer.append("\n\t\t\t\tif(!parseInt(total.value)>0){");
		htmlBuffer.append("\n\t\t\t\talert('刷新周期必须是一个大于0的数字!');");
		htmlBuffer.append("\n\t\t\t\ttotal.value=").append(field.getName()).append("_total;");
		htmlBuffer.append("\n\t\t}else{");
		htmlBuffer.append("\n\t\t\t\ttotal.value=parseInt(total.value);");
		htmlBuffer.append("\n\t\t\t\t").append(field.getName()).append("_total=parseInt(total.value);");
		htmlBuffer.append("\n\t\t\t\t").append(field.getName()).append("_remain=parseInt(total.value);");
		htmlBuffer.append("\n\t\t}");
		htmlBuffer.append("\n\t\t}");
		htmlBuffer.append("\n\t\tfunction _").append(field.getName()).append("_do(){");
		htmlBuffer.append("\n\t\t\t").append(field.getName()).append("_remain=").append(field.getName()).append("_total;");
		htmlBuffer.append("\n\t\t\t").append(field.getExtend()).append(";");
		htmlBuffer.append("\n\t\t}");
		htmlBuffer.append("\n\t\tsetTimeout('_").append(field.getName()).append("_run()',1000);");
		htmlBuffer.append("\n</script>");
		
		return htmlBuffer.toString();
	}

	/* (non-Javadoc)
	 * @see cn.blsoft.krport.htmlwidget.HtmlWidget#isHide()
	 */
	public boolean isHide() {
		return false;
	}

	
}
