/**
 * Created on 2010-4-27
 * @version v1.0
 *
 */
package cn.blsoft.krport.synthesizer;

import static cn.blsoft.krport.util.StringUtil.isBlank;
import static cn.blsoft.krport.util.StringUtil.objectToString;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.blsoft.krport.engine.KReportContext;
import cn.blsoft.krport.po.KReport;
import cn.blsoft.krport.po.PageData;
import cn.blsoft.krport.util.Expression;
import cn.blsoft.krport.util.StringUtil;

/**
 * <p>Title:  Page.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class DataSynthesizer  implements Synthesizer{
	
	/**
	 * 
	 */
	private KReport kReport;
	
	/**
	 * Êý¾Ý
	 */
	private PageData pageData;
	
	/**
	 * @param kReport
	 */
	public DataSynthesizer(KReport kReport){
		this.kReport = kReport;
	}

	/**
	 * @param data
	 * @param head
	 * @param bodys
	 */
	public DataSynthesizer(KReport kReport, PageData pageData){
		this.kReport = kReport;
		this.pageData = pageData;
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

		
	/**
	 * @return the pageData
	 */
	public PageData getPageData() {
		return pageData;
	}

	/**
	 * @param pageData the pageData to set
	 */
	public void setPageData(PageData pageData) {
		this.pageData = pageData;
	}

	public String getHeadHtml(){
		StringBuffer headHtmlBuffer = new StringBuffer();
		if(isBlank(kReport.getData().getHeadModel())){
			headHtmlBuffer.append("\n\t<thead class='kReportDataTable_thead'>");
			headHtmlBuffer.append("\n\t\t<tr>");
			for(int i=kReport.canPageable()?0:1;i<pageData.getHead().length;i++){
				headHtmlBuffer.append("\n\t\t\t<td nowrap>").append(pageData.getHead()[i]).append("</td>");
			}
			headHtmlBuffer.append("\n\t\t</tr>");
			headHtmlBuffer.append("\n\t</thead>");
		}else{
			headHtmlBuffer.append("\n\t<thead class='kReportDataTable_thead'>");
			headHtmlBuffer.append("\n").append(kReport.getData().getHeadModel());
			headHtmlBuffer.append("\n\t</thead>");
		}
		return headHtmlBuffer.toString();
	}
	
	public String getBodyHtml(){
		StringBuffer bodyHtmlBuffer = new StringBuffer();
		if(isBlank(kReport.getData().getBodyModel())){
			bodyHtmlBuffer.append("\n\t<tbody class='kReportDataTable_tbody'>");
			for(int i=0;i<pageData.getBodys().size();i++){
				Object[] content = pageData.getBodys().get(i);
				bodyHtmlBuffer.append("\n\t\t<tr>");
				for(int j=kReport.canPageable()?0:1;j<content.length;j++){
					bodyHtmlBuffer.append("\n\t\t\t<td>").append(StringUtil.toHtmlString(content[j])).append("</td>");
				}
				bodyHtmlBuffer.append("\n\t\t</tr>");
			}
			bodyHtmlBuffer.append("\n\t</tbody>");
		}else{
			bodyHtmlBuffer.append("\n\t<tbody class='kReportDataTable_tbody'>");
			for(int i=0;i<pageData.getBodys().size();i++){
				Object[] content = pageData.getBodys().get(i);
				String bodyModel = kReport.getData().getBodyModel();
				bodyHtmlBuffer.append("\n\t\t");
				for(int j=kReport.canPageable()?0:1;j<pageData.getHead().length;j++){
					bodyModel = bodyModel.replace("${"+j+"}", objectToString(StringUtil.toHtmlString(content[j])));
					bodyModel = bodyModel.replace("${"+pageData.getHead()[j]+"}", objectToString(StringUtil.toHtmlString(StringUtil.toHtmlString(content[j]))));
				}
				bodyHtmlBuffer.append("\n").append(bodyModel);
			}
			bodyHtmlBuffer.append("\n\t</tbody>");
		}
		return bodyHtmlBuffer.toString();
	}
	
	public String getFootHtml(){
		StringBuffer footHtmlBuffer = new StringBuffer();
		if(!isBlank(kReport.getData().getFootModel()) && getPageData().getBodys().size()>0){
			footHtmlBuffer.append("\n\t<tfoot>");
			String footModel = kReport.getData().getFootModel();
			footHtmlBuffer.append("\n\t\t");
			
			footModel = footModel.replace("${count}", getPageData().getBodys().size()+"");
			for(int j=kReport.canPageable()?0:1;j<pageData.getHead().length;j++){
				footModel = footModel.replace("${"+j+"}", objectToString(pageData.getFoot()[j]));
				footModel = footModel.replace("${"+pageData.getHead()[j]+"}", objectToString(StringUtil.toHtmlString(pageData.getFoot()[j])));
			}
			
			String e = "\\$\\[([^\\]]+)\\]";
			
			java.util.regex.Pattern p = Pattern.compile(e);
			Matcher m = p.matcher(footModel);
			while(m.find()){
				footModel = m.replaceFirst((String) Expression.calculate(m.group(1)));
				m=p.matcher(footModel);
			}
			
			footHtmlBuffer.append("\n").append(footModel);
			footHtmlBuffer.append("\n\t</tfoot>");
		}
		return footHtmlBuffer.toString();
	}
	
	public String getHtml(Map<String, Object> param){
		StringBuffer htmlBuffer = new StringBuffer();
		htmlBuffer.append("\n<head>");
		htmlBuffer.append("\n\t<title>").append(kReport.getDisplayName()).append("</title>");
		htmlBuffer.append("\n\t<link type='text/css' rel='stylesheet' href='").append(KReportContext.BASE).append("/kReport/css/").append(kReport.getSkin()).append("/kReport.css' />");
		htmlBuffer.append("\n\t<script type='text/javascript' src='").append(KReportContext.BASE).append("/kReport/js/action.js'></script>");	
		htmlBuffer.append("\n\t<script type='text/javascript' src='").append(KReportContext.BASE).append("/kReport/js/data.js'></script>");	
		htmlBuffer.append("\n</head>");
		htmlBuffer.append("\n<body leftmargin='0' topmargin='1' marginwidth='0' marginheight='0'  style='overflow: auto'>");	
		htmlBuffer.append("<table  width='100%' cellspacing='1'  class='kReportDataTable'>");
		htmlBuffer.append(getHeadHtml());
		htmlBuffer.append(getBodyHtml());
		htmlBuffer.append(getFootHtml());
		htmlBuffer.append("\n</table>");
		htmlBuffer.append("\n<div style='font-size:9pt;color=#999999'><pre>").append(StringUtil.objectToString(kReport.getComment())).append("</pre><div>");
		htmlBuffer.append("\n</body>");
		return htmlBuffer.toString();		
	}
	

}
