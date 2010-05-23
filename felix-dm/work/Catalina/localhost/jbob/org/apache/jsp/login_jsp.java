package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>J.Bob 用户登录</title>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath());
      out.write("/ext3/resources/css/ext-all.css\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/login.css\" />\r\n");
      out.write("\t\t");

		response.addHeader("__timeout","true");
		
      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\tvar __ctxPath=\"");
      out.print(request.getContextPath() );
      out.write("\";\r\n");
      out.write("\t\t\tvar __loginImage=__ctxPath+\"/images/jbob_logo.jpg\";\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/ext3/adapter/ext/ext-base.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/ext3/ext-all.js\"></script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/ext3/ext-lang-zh_CN.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/js/App.LoginWin.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t \t\tExt.onReady(function(){\r\n");
      out.write("\t\t \t\tExt.QuickTips.init(); \r\n");
      out.write("\t\t \t\tnew App.LoginWin().show();\r\n");
      out.write("\t\t\t});\t\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<div style=\"text-align: center;\">\r\n");
      out.write("\t\t\t<div id=\"loginArea\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
