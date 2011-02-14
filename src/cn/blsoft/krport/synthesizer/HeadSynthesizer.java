/**
 * Created on 2010-6-6
 * @version v1.0
 *
 */
package cn.blsoft.krport.synthesizer;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import cn.blsoft.krport.engine.KReportContext;
import cn.blsoft.krport.po.KReport;
import cn.blsoft.krport.po.PageAction;

/**
 * <p>Title:  HeadPage.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class HeadSynthesizer  implements Synthesizer{
	
	private KReport kReport;
	
	public HeadSynthesizer(){};
	
	public HeadSynthesizer(KReport kReport){
		this.kReport = kReport;
	}

	/**
	 * @return the kReport
	 */
	public KReport getkReport() {
		return kReport;
	}

	/**
	 * @param kReport the kReport to set
	 */
	public void setkReport(KReport kReport) {
		this.kReport = kReport;
	}
	
	public String getHtml(Map<String, Object> param){
		Set<String> scripts = new HashSet<String>();
		StringBuffer htmlBuffer = new StringBuffer();
		scripts.addAll(kReport.getScripts());
		for(PageAction action:kReport.getActions().values()){
			scripts.addAll(action.getScripts());
		}
		htmlBuffer.append("\n<head>");
		htmlBuffer.append("\n\t<title>").append(kReport.getDisplayName()).append("</title>");
		htmlBuffer.append("\n\t<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>");
		htmlBuffer.append("\n\t<link type='text/css' rel='stylesheet' href='").append(KReportContext.BASE).append("/kReport/css/").append(kReport.getSkin()).append("/kReport.css' />");
		htmlBuffer.append("\n\t<link type='text/css' rel='stylesheet' href='").append(KReportContext.BASE).append("/kReport/css/").append(kReport.getSkin()).append("/main.css' />");
		htmlBuffer.append("\n\t<script type='text/javascript' src='").append(KReportContext.BASE).append("/kReport/js/action.js'></script>");	
		htmlBuffer.append("\n\t<script type='text/javascript' src='").append(KReportContext.BASE).append("/kReport/js/user.js'></script>");	
		htmlBuffer.append("\n\t<script type='text/javascript' src='").append(KReportContext.BASE).append("/kReport/js/kReport.js'></script>");
		for(String script:scripts){
			htmlBuffer.append("\n\t<script type='text/javascript' src='").append(KReportContext.BASE).append(script).append("'></script>");
		}	
//		htmlBuffer.append("\n\t<script type='text/javascript'>");
//		htmlBuffer.append("\n\tfunction init(){");
//		htmlBuffer.append("\n\t\tdocument.getElementById('_viewer').height=document.body.offsetHeight-document.getElementById('_actionTable').offsetHeight-document.getElementById('_conditionTable').offsetHeight-5;");
//		htmlBuffer.append("\n\t}");
//		htmlBuffer.append("\n\twindow.onload=function(){init()};");
//		htmlBuffer.append("\n\tfunction addLoadEvent(func){");
//		htmlBuffer.append("\n\t\tvar oldonload=window.onload;");
//		htmlBuffer.append("\n\t\tif(typeof window.onload!='function'){");
//		htmlBuffer.append("\n\t\t\twindow.onload=func;");
//		htmlBuffer.append("\n\t\t}else{");
//		htmlBuffer.append("\n\t\t\twindow.onload=function(){");
//		htmlBuffer.append("\n\t\t\toldonload();");
//		htmlBuffer.append("\n\t\t\tfunc();");
//		htmlBuffer.append("\n\t\t}");
//		htmlBuffer.append("\n\t}");
//		htmlBuffer.append("\n\t}");
//		htmlBuffer.append("\n\t</script>");
		htmlBuffer.append("\n</head>");
		return htmlBuffer.toString();
	}

	
	
}
