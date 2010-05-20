package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/WEB-INF/lib/security.tld");
    _jspx_dependants.add("/WEB-INF/lib/c.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsecurity_005fauthentication_0026_005fproperty_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fsecurity_005fauthentication_0026_005fproperty_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fsecurity_005fauthentication_0026_005fproperty_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	String basePath=request.getContextPath();
	//登录成功后，需要把该用户显示至在线用户
	//AppUtil.addOnlineUser(request.getSession().getId(), ContextUtil.getCurrentUser());
	//if(ContextUtil.getCurrentUser().getRights().contains("__ALL")){
		request.setAttribute("IS_MANAGER",true);
	//}

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\t\t<meta http-equiv=\"msthemecompatible\" content=\"no\">\r\n");
      out.write("\t\t<title>J.Bob Inc.－－企业信息化管理系统");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${IS_MANAGER}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</title>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(basePath);
      out.write("/ext3/resources/css/ext-all-notheme.css\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(basePath);
      out.write("/css/admin.css\"/>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(basePath);
      out.write("/ext3/ux/css/ux-all.css\"/>\r\n");
      out.write("\t\t<!-- load the extjs libary -->\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/dynamic.jsp\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/ext3/adapter/ext/ext-base.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/ext3/ext-all.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/ext3/ux/ux-all.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/ext3/ext-lang-zh_CN.js\"></script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/core/AppUtil.js\"></script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/core/using.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/ext3/ux/Toast.js\"></script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/core/SystemCalendar.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/core/TreeSelector.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/core/date.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/core/ux/TreePanelEditor.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/core/ux/TreeXmlLoader.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- \r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/selector/UserSelector.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/selector/UserSubSelector.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/selector/DepSelector.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/selector/RoleSelector.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/selector/GoodsSelector.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/selector/CarSelector.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/selector/CustomerSelector.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/selector/OnlineUserSelector.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/selector/BookSelector.js\"></script>\t\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/selector/ProjectSelector.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/selector/ProviderSelector.js\"></script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/info/MessageWin.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/info/MessageReplyWin.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/info/MessageDetail.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/flow/ProcessNextForm.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/system/FileAttachDetail.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/personal/DutyView.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/personal/DutyForm.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/sound/soundmanager2.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/search/SearchForm.js\"></script>\r\n");
      out.write("         -->\r\n");
      out.write("         \r\n");
      out.write("\t    <script type=\"text/javascript\">\r\n");
      out.write("\t       var __companyName=\"J.Bob Inc.\";\r\n");
      out.write("\t\t   Ext.onReady(function(){\r\n");
      out.write("\t\t\t   \t  var storeTheme=getCookie('theme');\r\n");
      out.write("\t\t\t   \t  if(storeTheme==null || storeTheme==''){\r\n");
      out.write("\t\t\t\t   \t  storeTheme='ext-all';\r\n");
      out.write("\t\t\t   \t  }\r\n");
      out.write("\t\t\t   \t  Ext.QuickTips.init();\r\n");
      out.write("\t\t\t      Ext.util.CSS.swapStyleSheet(\"theme\", __fullPath+\"/ext3/resources/css/\"+storeTheme+\".css\");  \r\n");
      out.write("\t\t    });\r\n");
      out.write("\t    </script>\r\n");
      out.write("\t     <script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/using.register.js\"></script>\t\r\n");
      out.write("\t    <script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/IndexPage.js\"></script>\r\n");
      out.write("\t    <script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/App.home.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/js/App.js\"></script>\t\t\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body oncontextmenu=\"return false\">\r\n");
      out.write("\t\t<div id=\"loading\">\r\n");
      out.write("             <div  class=\"loading-indicator\">\r\n");
      out.write("                  <img src=\"");
      out.print(basePath);
      out.write("/images/loading.gif\" alt=\"\" width=\"32\" height=\"32\" style=\"margin-right:8px;\" align=\"absmiddle\"/>\r\n");
      out.write("         \t\t   正在加载，请稍候......\r\n");
      out.write("             </div>\r\n");
      out.write("         </div>\r\n");
      out.write("         <div id=\"loading-mask\">\r\n");
      out.write("         </div>\r\n");
      out.write("\t\t<div id=\"app-header\">\r\n");
      out.write("\t\t\t<div style=\"float:left;max-width:350px;height:50px;width: auto;\">\r\n");
      out.write("\t\t\t<img id =\"CompanyLogo\" src=\"");
      out.print(basePath);
      out.write("/images/jbob_logo.jpg\" height=\"50\" style=\"max-width:230px;\"/>\r\n");
      out.write("\t\t\t<!-- \r\n");
      out.write("\t\t\t<img id =\"CompanyLogo\" src=\"");
      out.print(basePath);
      out.write("/images/jbob_logo.jpg\" height=\"50\" style=\"max-width:230px;\"/><img src=\"");
      out.print(basePath);
      out.write("/images/ht-oa.png\" height=\"50\"/>\r\n");
      out.write("\t\t\t -->\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"topInfoPanel\" style=\"text-align:center;float:left;\">\r\n");
      out.write("\t\t\t\t<div id=\"welcomeMsg\">欢迎您，");
      if (_jspx_meth_security_005fauthentication_005f0(_jspx_page_context))
        return;
      out.write("，[<a href=\"");
      out.print(basePath);
      out.write("/j_logout.do\">注销</a>]</div>\r\n");
      out.write("\t\t\t\t<div id=\"currentTime\"><span id=\"nowTime\"></span><span id=\"nowTime2\"></span></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- -->\r\n");
      out.write("\t\t\t<div id=\"setting\">\r\n");
      out.write("\t\t\t\t<a href=\"");
      out.print(basePath);
      out.write("/help/20091225001.zip\" target=\"blank\">帮助</a>\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t<div id=\"navHeader\" style=\"float:left;width:365px;\" >\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"searchFormDisplay\" style=\"width:260px;float:right;\">&nbsp;</div>\r\n");
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

  private boolean _jspx_meth_security_005fauthentication_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  security:authentication
    org.springframework.security.taglibs.authz.AuthenticationTag _jspx_th_security_005fauthentication_005f0 = (org.springframework.security.taglibs.authz.AuthenticationTag) _005fjspx_005ftagPool_005fsecurity_005fauthentication_0026_005fproperty_005fnobody.get(org.springframework.security.taglibs.authz.AuthenticationTag.class);
    _jspx_th_security_005fauthentication_005f0.setPageContext(_jspx_page_context);
    _jspx_th_security_005fauthentication_005f0.setParent(null);
    // /index.jsp(99,29) name = property type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_security_005fauthentication_005f0.setProperty("principal.fullname");
    int _jspx_eval_security_005fauthentication_005f0 = _jspx_th_security_005fauthentication_005f0.doStartTag();
    if (_jspx_th_security_005fauthentication_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsecurity_005fauthentication_0026_005fproperty_005fnobody.reuse(_jspx_th_security_005fauthentication_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsecurity_005fauthentication_0026_005fproperty_005fnobody.reuse(_jspx_th_security_005fauthentication_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /index.jsp(105,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${IS_MANAGER ==true}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t|<a href=\"#\" onclick=\"App.clickTopTab('SysConfigView')\">设置</a>\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }
}
