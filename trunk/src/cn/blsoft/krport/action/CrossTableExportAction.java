/**
 * Created on 2010-6-6
 * @version v1.0
 *
 */
package cn.blsoft.krport.action;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.blsoft.krport.engine.KReportContext;
import cn.blsoft.krport.po.KReport;
import cn.blsoft.krport.po.PageData;
import cn.blsoft.krport.query.SqlQuery;
import cn.blsoft.krport.reader.ReaderUtil;
import cn.blsoft.krport.synthesizer.CrossDataSynthesizer;
import cn.blsoft.krport.util.ServletUtil;
import cn.blsoft.krport.util.StringUtil;

/**
 * <p>Title:  QueryAction.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class CrossTableExportAction implements Action {

	/* (non-Javadoc)
	 * @see cn.blsoft.krport.action.Action#execute(java.lang.String, java.util.Map, javax.servlet.http.HttpServletResponse)
	 */
	public void execute(HttpServletRequest request,	HttpServletResponse response) throws IOException {
		String kReportName = ServletUtil.getKReportName(request);
		KReport kReport = KReportContext.kReports.getKRport(kReportName);
		Map<String,Object> param = ServletUtil.initParam(request);
		response.setContentType("application/x-msdownload;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String fileName = StringUtil.toStandardStr(kReport.getDisplayName());
		response.setHeader("Content-Disposition", "attachment;filename="+fileName+".xls");
		PageData pageData = SqlQuery.Query(kReport,param,kReport.canPageable());
		String csscontent = "<style type='text/css'/>"+ReaderUtil.readFile(KReportContext.ROOTPATH+"/kReport/css/"+kReport.getSkin()+"/kReport.css")+"</style>";
		Writer writer = response.getWriter();
		writer.write("<html>");	
		String htmlString = new CrossDataSynthesizer(kReport,pageData).getHtml(param);
		writer.write(htmlString.replace("<td", "<td  style='border:1px solid #cccccc;'" ).replace("<th", "<th  style='border:1px solid #cccccc;'" ).replaceAll("<a .*?>(.+?)</a>", "$1").replaceAll("<link .*?/>", csscontent)); 	
		writer.write("\n</html>");
		writer.close();		
	}
	
}
