/**
 * Created on 2010-4-18
 * @version v1.0
 *
 */
package cn.blsoft.krport.engine;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import cn.blsoft.krport.action.Action;
import cn.blsoft.krport.reader.ConfigReader;
import cn.blsoft.krport.reader.KReportsReader;
import cn.blsoft.krport.util.DateUtil;
import cn.blsoft.krport.util.ServletUtil;
import cn.blsoft.krport.util.StringUtil;

import common.Logger;

/**
 * <p>Title:  KReportEngine.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
@SuppressWarnings("serial")
public class KReportEngine extends HttpServlet {
	
	public static Logger log = Logger.getLogger(KReportEngine.class);
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("base", request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		
		if(KReportContext.BASE==null){
			if(StringUtil.isBlank(request.getContextPath())){
				KReportContext.BASE="";
			}else{
				KReportContext.BASE=request.getContextPath();
			}
		}
		
		String method = request.getParameter("_method");
		String kReportName = ServletUtil.getKReportName(request);
		if("/main".equals(kReportName)){
			RequestDispatcher rd = null;
			if(StringUtil.isBlank(method)){
				rd = request.getRequestDispatcher("/kReport/main/main.jsp");
			}else{
				rd = request.getRequestDispatcher("/kReport/main/"+method+".jsp");
			}
			rd.forward(request, response);
		}else if("/reload".equals(kReportName)){
			log.info(DateUtil.DateToString(new Date(), "[ yyyy-MM-dd HH:mm:ss ]")+"kReport reload...");
			load();
		}else{
			log.info(DateUtil.DateToString(new Date(), "[ yyyy-MM-dd HH:mm:ss ]")+"kReport:"+kReportName+"("+method+")");
			Action action = KReportContext.config.getAction(method);
			action.execute(request, response);
		}
	}


	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		super.init();
		load();
	}
	
	public void load(){		
		try {
			KReportContext.ROOTPATH = getServletContext().getRealPath("/");
			KReportContext.config = ConfigReader.read(getServletContext().getRealPath("/kReport/config.xml"));
			KReportContext.kReports = KReportsReader.read(getServletContext().getRealPath("/kReport/kReports.xml"), getServletContext());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}			
	
	}

	
}
