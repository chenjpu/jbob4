/**
 * Created on 2010-4-29
 * @version v1.0
 *
 */
package cn.blsoft.krport.synthesizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import cn.blsoft.krport.engine.KReportContext;
import cn.blsoft.krport.htmlwidget.HtmlWidget;
import cn.blsoft.krport.po.Condition;
import cn.blsoft.krport.po.KReport;

/**
 * <p>Title:  ConditionPage.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class ConditionSynthesizer implements Synthesizer{
	
	private List<Condition> conditions;
	
	int trsize;
	
	public ConditionSynthesizer(){}
	
	public ConditionSynthesizer(KReport kReport){
		setConditions(kReport.getConditions().values());
		trsize = kReport.getConditionSize();
	}
	
	public String getHtml(Map<String, Object> param){
		StringBuffer htmlBuffer = new StringBuffer();
		htmlBuffer.append(getSubmitValid());
		
		htmlBuffer.append("\n<form id='_query' action='").append(KReportContext.BASE).append(param.get("_kReportName")).append(".kReport' method='post' onsubmit='_submitValid(this)'>");
		htmlBuffer.append("\n\t<input type='hidden' name='_base' value='").append(KReportContext.BASE).append("'/>");
		htmlBuffer.append("\n\t<input type='hidden' name='_method' value='query'/>");
		htmlBuffer.append("\n\t<input type='hidden' name='_parameter' value=''/>");
		htmlBuffer.append("\n\t<input type='hidden' name='_page' value='1'/>");
		htmlBuffer.append("\n<table id='_conditionTable' width='100%' cellspacing='1' class='kReportConditionTable'>");
		int k = trsize;
		boolean isChangeLine = false;
		StringBuffer hiddenHtmlBuffer = new StringBuffer();
		for(int i=0;i<conditions.size();i++){
			Condition condition = conditions.get(i);
			String initValue = (String)param.get(condition.getName());
			if(initValue!=null){
				condition.setDefaultValue(initValue);
			}
			HtmlWidget htmlWidget = KReportContext.config.getHtmlWidget(condition.getType());
			if(htmlWidget.isHide()){
				hiddenHtmlBuffer.append("\n").append(htmlWidget.getHtml(condition, param));
				continue;
			}else{
				if(k==trsize){
					htmlBuffer.append("\n\t<tr>");
				}
				htmlBuffer.append("\n\t\t<td nowrap align='right'>");
				htmlBuffer.append("\n\t\t\t").append(condition.getDisplayName());
				htmlBuffer.append("\n\t\t</td>");
				htmlBuffer.append("\n\t\t<td nowrap align='left'>");
				htmlBuffer.append(htmlWidget.getHtml(condition, param));
				if(condition.getRequired()){
					htmlBuffer.append("<font color=red>*</font>");
				}
				htmlBuffer.append("\n\t\t</td>");
				if(--k==0)k = trsize;
				if(k==trsize){
					htmlBuffer.append("\n\t</tr>");
					isChangeLine = true;
				}
			}
		}
		for(int i=0; isChangeLine && i<k%trsize; i++){
			htmlBuffer.append("<td></td><td></td>");
		}
		
		htmlBuffer.append("\n\t</tr>");
		
		htmlBuffer.append("\n</table>");
		htmlBuffer.append(hiddenHtmlBuffer);
		htmlBuffer.append("\n</form>");
		return htmlBuffer.toString();
	}
	
	public String getSubmitValid(){		
		StringBuffer submitValid = new StringBuffer();
		submitValid.append("\n<script type='text/javascript'>");
		submitValid.append("\nfunction _submitValid(sform){");
		
		for(Condition condition:conditions){
			if(condition.getRequired()){
				submitValid.append("\n\tif(sform.").append(condition.getName()).append(".value==''){");
				submitValid.append("\n\t\talert('").append(condition.getDisplayName()).append(" ²»ÄÜÎª¿Õ');");
				submitValid.append("\n\t\treturn false;");
				submitValid.append("\n\t}");
			}
		}
		submitValid.append("\n\treturn true;");
		submitValid.append("\n}");
		submitValid.append("\n</script>");
		return submitValid.toString();
	}


	/**
	 * @return the conditions
	 */
	public List<Condition> getConditions() {
		return conditions;
	}



	/**
	 * @param conditions the conditions to set
	 */
	public void setConditions(Collection<Condition> conditions){
		this.conditions = new ArrayList<Condition>();
		this.conditions.addAll(conditions);
		Collections.sort(this.conditions);
	}



	/**
	 * @return the trsize
	 */
	public int getTrsize() {
		return trsize;
	}



	/**
	 * @param trsize the trsize to set
	 */
	public void setTrsize(int trsize) {
		this.trsize = trsize;
	}


}
