/**
 * Created on 2010-6-8
 * @version v1.0
 *
 */
package cn.blsoft.krport.synthesizer;

import java.util.Map;

import cn.blsoft.krport.engine.KReportContext;
import cn.blsoft.krport.po.KReport;
import cn.blsoft.krport.po.PageData;

/**
 * <p>Title:  PaginationSynthesizer.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class ParamDivSynthesizer implements Synthesizer {
	
	private KReport kReport;

	/**
	 * Êý¾Ý
	 */
	private PageData pageData;
	

	public ParamDivSynthesizer(){}
	
	/**
	 * @param kReport
	 * @param pageData
	 * @param param
	 */
	public ParamDivSynthesizer(KReport kReport, PageData pageData){
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

	/* (non-Javadoc)
	 * @see cn.blsoft.krport.synthesizer.Synthesizer#getHtml()
	 */
	public String getHtml(Map<String, Object> param) {
		StringBuffer htmlBuffer = new StringBuffer();
		htmlBuffer.append("\n<div id='_kreportParam'>\n<form id='_query' method='post' style='display:none;'>");
		for(String key:param.keySet()){
			Object obj = param.get(key);
			if(obj instanceof String){
				htmlBuffer.append("\n\t<input type='hidden' name='").append(key).append("' value=\"").append(obj).append("\"/>");
			}else{
				for(String o:(String[])obj){
					htmlBuffer.append("\n\t<input type='hidden' name='").append(key).append("' value=\"").append(o).append("\"/>");
				}
			}
		}
		htmlBuffer.append("\n</form>\n</div>");	
		return htmlBuffer.toString();
	}

}
