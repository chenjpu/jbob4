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
public class PaginationSynthesizer implements Synthesizer {
	
	private KReport kReport;

	/**
	 * 数据
	 */
	private PageData pageData;
	
	public PaginationSynthesizer(){}
	
	/**
	 * @param kReport
	 * @param pageData
	 * @param param
	 */
	public PaginationSynthesizer(KReport kReport, PageData pageData){
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
		int countPage = pageData.getPageSize()==0?0:(pageData.getCount()+pageData.getPageSize()-1)/pageData.getPageSize();
		StringBuffer htmlBuffer = new StringBuffer();
		if(kReport.canPageable()){
			htmlBuffer.append("\n<script type='text/javascript'>");
			htmlBuffer.append("\nfunction _gotoPage(page){");
			htmlBuffer.append("\n\tvar queryForm = document.getElementById('_query');");
			htmlBuffer.append("\n\tqueryForm._page.value=page;");
			htmlBuffer.append("\n\tqueryForm.submit();");
			htmlBuffer.append("\n}");
			htmlBuffer.append("\nfunction _go(){");
			htmlBuffer.append("\n\tvar pageOb=document.getElementById('pagination_page');");
			htmlBuffer.append("\n\tvar input=pageOb.value");
			htmlBuffer.append("\n\tvar pageNum=parseInt('").append(countPage).append("')//总页数");
			htmlBuffer.append("\n\tvar inPageIndex=parseInt('").append(pageData.getPage()).append("')//当前页数");
			htmlBuffer.append("\n\tif(parseInt(input)>pageNum){");
			htmlBuffer.append("\n\t\talert('输入的页数超过总页数');");
			htmlBuffer.append("\n\t\tpageOb.value='';");
			htmlBuffer.append("\n\t\treturn;");
			htmlBuffer.append("\n\t}");
			htmlBuffer.append("\n\tif(parseInt(input)<1){");
			htmlBuffer.append("\n\t\talert('输入的页数必需大于1');");
			htmlBuffer.append("\n\t\tpageOb.value='';");
			htmlBuffer.append("\n\t\treturn;");
			htmlBuffer.append("\n\t}else{");
			htmlBuffer.append("\n\t\tpageOb.value=parseInt(input);");
			htmlBuffer.append("\n\t}");		
			htmlBuffer.append("\n\t_gotoPage(input);");
			htmlBuffer.append("\n}");
			htmlBuffer.append("\n</script>");
			htmlBuffer.append("\n<div align='right' class='kReportPaginationDiv'>");
			htmlBuffer.append("\n第").append(pageData.getPage()).append("页/共").append(countPage).append("页(").append(pageData.getCount()).append("条)");
			if(countPage>1){
				if(pageData.getPage()!=1){
					htmlBuffer.append("\n<a href='javascript:_gotoPage(1)'>首页</a>");
					htmlBuffer.append("\n<a href='javascript:_gotoPage(").append(pageData.getPage()-1).append(")'>上页</a>");
				}
				if(pageData.getPage()!=countPage){
					htmlBuffer.append("\n<a href='javascript:_gotoPage(").append(pageData.getPage()+1).append(")'>下页</a>");
					htmlBuffer.append("\n<a href='javascript:_gotoPage(").append(countPage).append(")'>尾页</a>");
				}
				htmlBuffer.append("\n<input type='text' id='pagination_page' name='pagination_page' style='width:30px' value='").append(pageData.getPage()).append("'/>");
				htmlBuffer.append("\n<img src='").append(KReportContext.BASE).append("/kReport/image/go.png' align='absmiddle' onclick='javascript:_go()' style='cursor:hand'/>");
			}
			htmlBuffer.append("</div>");
		}
		return htmlBuffer.toString();
	}

}
