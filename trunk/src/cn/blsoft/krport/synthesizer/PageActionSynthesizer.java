/**
 * Created on 2010-5-5
 * @version v1.0
 *
 */
package cn.blsoft.krport.synthesizer;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import cn.blsoft.krport.po.KReport;
import cn.blsoft.krport.po.PageAction;

/**
 * <p>Title:  ActionPage.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class PageActionSynthesizer implements Synthesizer{

	private String reportName;
	
	private List<PageAction> actions;

	public PageActionSynthesizer(){}
	
	public PageActionSynthesizer(KReport kReport){
		this.reportName = kReport.getDisplayName();
		setActions(kReport.getActions().values());
	}
	
	public PageActionSynthesizer(String reportName, List<PageAction> actions){
		this.reportName = reportName;
		setActions(actions);
	}
	
	public String getHtml(Map<String, Object> param){
		StringBuffer htmlBuffer = new StringBuffer();
				
		htmlBuffer.append("<table  id='_actionTable' class='kReportActionTable'>");
		htmlBuffer.append("\n\t<tr>");
		htmlBuffer.append("\n\t\t<td align='left'>");
		htmlBuffer.append(reportName);
		htmlBuffer.append("</td>");
		htmlBuffer.append("\n\t\t<td align='right'>");
		
		for(int i=0;i<actions.size();i++){
			PageAction action = actions.get(i);
			htmlBuffer.append("\n\t\t\t<a href=\"").append(action.getAction()).append("\">").append(action.getDisplayName()).append("</a>&nbsp;&nbsp;");
		}
		
		
		htmlBuffer.append("\n\t\t</td>");
		htmlBuffer.append("\n\t</tr>");
		htmlBuffer.append("\n</table>");
	
		return htmlBuffer.toString();
	}
	
		
	/**
	 * @return the reportName
	 */
	public String getReportName() {
		return reportName;
	}

	/**
	 * @param reportName the reportName to set
	 */
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	/**
	 * @return the actions
	 */
	public List<PageAction> getActions() {
		return actions;
	}

	/**
	 * @param actions the actions to set
	 */
	public void setActions(Collection<PageAction> actions) {
		this.actions = new ArrayList<PageAction>();
		this.actions.addAll(actions);
		Collections.sort(this.actions);
	}

	
}
