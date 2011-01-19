<%@ page contentType="text/html;charset=GBK"%>
<%
String msg = (String)request.getAttribute("msg");
%>
<html>
  <head>    
    <title>广东电信综合网络激活系统</title>  
    <%@include file="/inc/commoncontent.inc"%>
	<link href="../css/main.css" rel="stylesheet" type="text/css" />
  </head>  
  <body>	
	<table border="0" width="100%" height="100%">
  <tr>
    <td align="center" valign="middle">
      <table width="426" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="426" height="221" background="../images/cc.gif">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="p1">
              <tr>
                <td height="60" colspan="3" align="center" valign="middle">
                  <img src="../images/fail.gif" width="59" height="59">
                </td>
              </tr>
              <tr>
                <td width="50" height="80">&nbsp;</td>
                <td align="center">
                  <font size="4" color="blue">
                    <%=msg%>
                  </font>
                </td>
                <td width="50">                </td>
              </tr>
              <tr>
                <td height="30" colspan="3" align="center" valign="middle">
                  <p  element="p" align="center">
                    <input type="button" value="返 回" style="cursor:'hand'" onclick="history.back()">
                  </p>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
  </body>
</html>
