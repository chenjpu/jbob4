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
import cn.blsoft.krport.synthesizer.CrossDataSynthesizer;
import cn.blsoft.krport.synthesizer.ParamDivSynthesizer;
import cn.blsoft.krport.util.ServletUtil;

/**
 * <p>Title:  QueryAction.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class CrossQueryAction implements Action {

	/* (non-Javadoc)
	 * @see cn.blsoft.krport.action.Action#execute(java.lang.String, java.util.Map, javax.servlet.http.HttpServletResponse)
	 */
	public void execute(HttpServletRequest request,	HttpServletResponse response) throws IOException {
		String kReportName = ServletUtil.getKReportName(request);
		KReport kReport = KReportContext.kReports.getKRport(kReportName);
		Map<String,Object> param = ServletUtil.initParam(request);
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PageData pageData = SqlQuery.Query(kReport,param,kReport.canPageable());
		Writer writer = response.getWriter();
		writer.write("<html>");
		writer.write(new CrossDataSynthesizer(kReport,pageData).getHtml(param));	
		writer.write(new ParamDivSynthesizer(kReport, pageData).getHtml(param));		
		writer.write("\n</html>");
		writer.close();		
	}
	
}
