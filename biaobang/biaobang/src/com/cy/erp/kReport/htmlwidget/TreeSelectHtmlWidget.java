/**
 * Created on 2010-4-29
 * @version v1.0
 *
 */
package com.cy.erp.kReport.htmlwidget;

import java.util.Map;

import cn.blsoft.krport.engine.KReportContext;
import cn.blsoft.krport.htmlwidget.HtmlWidget;
import cn.blsoft.krport.po.Condition;

/**
 * <p>Title:  TextHtmlControl.java</p>    
 * <p>Description: </p>
 *
 * @author chenb
 */
public class TreeSelectHtmlWidget implements HtmlWidget{

	
	public String getHtml(Condition field, Map<String, Object> param) {
		StringBuilder htmlBuffer = new StringBuilder(2048);
		//htmlBuffer.append("\n\t\t\t<link rel='stylesheet' type='text/css' href='").append(KReportContext.BASE).append("/scripts/jquery-easyui/themes/def/dialog.css'/>");
		//htmlBuffer.append("\n\t\t\t<link rel='stylesheet' type='text/css' href='").append(KReportContext.BASE).append("/scripts/jquery-easyui/themes/icon.css'/>");
		
		//htmlBuffer.append("\n\t\t\t<script type='text/javascript' src='").append(KReportContext.BASE).append("/scripts/jquery-easyui/jquery-1.4.2.min.js'></script>");
		//htmlBuffer.append("\n\t\t\t<script type='text/javascript' src='").append(KReportContext.BASE).append("/scripts/jquery-easyui/jquery.easyui.min.js'></script>");
		
		htmlBuffer.append("\n\t\t\t<link rel='stylesheet' type='text/css' href='").append(KReportContext.BASE).append("/themes/base/ui.all.css'/>");
		htmlBuffer.append("\n\t\t\t<script type='text/javascript' src='").append(KReportContext.BASE).append("/js/jquery/jquery-1.3.2.min.js'></script>");
		htmlBuffer.append("\n\t\t\t<script type='text/javascript' src='").append(KReportContext.BASE).append("/js/jquery/ui/ui.core.js'></script>");
		htmlBuffer.append("\n\t\t\t<script type='text/javascript' src='").append(KReportContext.BASE).append("/js/jquery/ui/ui.dialog.js'></script>");
		
		
		htmlBuffer.append("\n\t\t\t<script type='text/javascript'>");
		
		String name = field.getName();
		
		htmlBuffer.append("\n\t\t\t function set" + name + "(){");
		htmlBuffer.append("\n\t\t\t	var url = \"" + KReportContext.BASE +  field.getExtend().trim() +"\";");
		htmlBuffer.append("\n\t\t\t	document.getElementById(\"" + name + "Select\").src = url;");
		htmlBuffer.append("\n\t\t\t }");
		htmlBuffer.append("\n\t\t\t function ready" + name + "(){");
		htmlBuffer.append("\n\t\t\t $(\"#" + name + "Dialog\").dialog({");
		htmlBuffer.append("\n\t\t\t bgiframe: true,");
		htmlBuffer.append("\n\t\t\t autoOpen: false,");
		htmlBuffer.append("\n\t\t\t modal: true,");
		htmlBuffer.append("\n\t\t\t width: 500,");
		htmlBuffer.append("\n\t\t\t position:['center','center'] ,");
		htmlBuffer.append("\n\t\t\t buttons: {");
		htmlBuffer.append("\n\t\t\t '取消': function() {");
		htmlBuffer.append("\n\t\t\t $(this).dialog('close');");
		htmlBuffer.append("\n\t\t\t },");
		htmlBuffer.append("\n\t\t\t '确定': function() {");
		htmlBuffer.append("\n\t\t\t confirm" + name + "(" + name + "Select.confirm());");
		htmlBuffer.append("\n\t\t\t $(this).dialog('close');");
		htmlBuffer.append("\n\t\t\t }");
		htmlBuffer.append("\n\t\t\t },");
		htmlBuffer.append("\n\t\t\t close: function() {");
		htmlBuffer.append("\n\t\t\t }");
		htmlBuffer.append("\n\t\t\t });");
		htmlBuffer.append("\n\t\t\t }");

		htmlBuffer.append("\n\t\t\t var inited" + name + " = false;");
  
		htmlBuffer.append("\n\t\t\t function open" + name + "Dialog(selected){");
		htmlBuffer.append("\n\t\t\t if(!inited" + name + "){");
		htmlBuffer.append("\n\t\t\t ready" + name + "();");
		htmlBuffer.append("\n\t\t\t set" + name + "();");
		htmlBuffer.append("\n\t\t\t inited" + name + " = true;");
		htmlBuffer.append("\n\t\t\t }		  ");
		htmlBuffer.append("\n\t\t\t $('#" + name + "Dialog').dialog('open');");
		htmlBuffer.append("\n\t\t\t }");


		htmlBuffer.append("\n\t\t\t function confirm" + name + "(selected){");
		htmlBuffer.append("\n\t\t\t var ids = [];");
		htmlBuffer.append("\n\t\t\t var names = \"\";");
		htmlBuffer.append("\n\t\t\t for(var i = 0;i < selected.length;i++){");
		htmlBuffer.append("\n\t\t\t		ids[i] = selected[i].id ;");
		htmlBuffer.append("\n\t\t\t 	names += selected[i].name + ',';");
		htmlBuffer.append("\n\t\t\t }");

		htmlBuffer.append("\n\t\t\t if(selected.length > 0){");
		htmlBuffer.append("\n\t\t\t //ids = ids.substr(0,ids.length - 1);");
		htmlBuffer.append("\n\t\t\t names = names.substr(0,names.length - 1);");
		htmlBuffer.append("\n\t\t\t }");

		htmlBuffer.append("\n\t\t\t document.getElementById(\"" + name + "Div\").innerHTML = '';");
		
		htmlBuffer.append("\n\t\t\t var idHtm = \"\";");
		htmlBuffer.append("\n\t\t\t for(var i = 0;i < ids.length;i++){");
		htmlBuffer.append("\n\t\t\t	 idHtm += \"<input type='hidden' name='" + name + "' value='\" + ids[i] + \"' />\";");
		htmlBuffer.append("\n\t\t\t }");
		
		
		htmlBuffer.append("\n\t\t\t document.getElementById(\"" + name + "Div\").innerHTML = idHtm;");
		htmlBuffer.append("\n\t\t\t document.getElementById(\"" + name + "Names\").value = names;");
		htmlBuffer.append("\n\t\t\t }");

		htmlBuffer.append("\n\t\t\t function getSelected" + name + "(){");
		htmlBuffer.append("\n\t\t\t return [");
		htmlBuffer.append(field.getDefaultValue());
		htmlBuffer.append("\n\t\t\t ];");
		htmlBuffer.append("\n\t\t\t }");
		
		htmlBuffer.append("\n\t\t\t</script>");
		
		htmlBuffer.append("\n\t\t\t<div id=\"" + name + "Dialog\" title=\"请选择\" style=\"display: none\">");
		htmlBuffer.append("\n\t\t\t<iframe src='about:blank' width='500'  height=\"310\" scrolling=\"yes\" frameborder=0  name='" + name + "Select' id=\"" + name + "Select\"></iframe>");
		htmlBuffer.append("\n\t\t\t</div>");
		htmlBuffer.append("\n\t\t\t<div id=\"" + name + "Div\" style=\"display: none\">");
		//htmlBuffer.append("\n\t\t\t<input type='hidden' name=\"" + name + "\" id=\"" + name + "\" value=\"\"/>");
		htmlBuffer.append("\n\t\t\t</div>");
		htmlBuffer.append("\n\t\t\t<input type='text' id=\"" + name + "Names\" readonly></input><img src=\"" +KReportContext.BASE + "/images/xp/person.png\" alt=\"选择\" style=\"cursor: pointer;\"  onclick=\"open" + name + "Dialog('maintainer')\"/>");
		return htmlBuffer.toString();
	}
	
	public boolean isHide(){
		return false;
	}
	
}
