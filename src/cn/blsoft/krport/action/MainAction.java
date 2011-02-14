/**
 * Created on 2010-6-7
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
import cn.blsoft.krport.synthesizer.KReportSynthesizer;
import cn.blsoft.krport.util.ServletUtil;

/**
 * <p>Title:  MainAction.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class MainAction implements Action {

	/* (non-Javadoc)
	 * @see cn.blsoft.krport.action.Action#execute(cn.blsoft.krport.po.KReport, java.util.Map, javax.servlet.http.HttpServletResponse)
	 */
	public void execute(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String kReportName = ServletUtil.getKReportName(request);
		KReport kReport = KReportContext.kReports.getKRport(kReportName);
		Map<String,Object> param = ServletUtil.initParam(request);
		param.put("_kReportName", kReportName);
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		Writer writer = response.getWriter();
		writer.write(new KReportSynthesizer(kReport).getHtml(param));
		writer.close();
	}

}
