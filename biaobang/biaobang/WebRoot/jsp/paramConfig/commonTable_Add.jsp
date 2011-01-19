<%@ page contentType="text/html;charset=GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="javax.sql.rowset.CachedRowSet"%>
<%@ page import="java.sql.ResultSetMetaData"%>
<% 
	//设置页面不缓存   
    request.setAttribute("decorator","none");   
    response.setHeader("Cache-Control","no-cache");   
    response.setHeader("Pragma","no-cache");   
    response.setDateHeader("Expires",0);   
%> 

<html>
	<head>    
    <title>广东电信审计发现风险跟踪系统</title>
    <link href="/css/button.css" rel="stylesheet" type="text/css" media="all" />
	<style>
	*{margin:0px; padding:0px; border:1px; font-size:12px;}
	.rightpagetitle {background:url(../images/rightTitlebg.gif) repeat-x; height:31px;}
	</style>
	<script type="text/javascript">
		function saveObject() {
			
			document.MyForm.action="/commonTable/saveObject.action";
			document.MyForm.submit();
		}
		
		function back() {
			document.MyForm.action="${toURL}";
			document.MyForm.submit();
		}
	</script>
	</head>
	<body>
	<div style="overflow:auto; z-index=6; visibility:;position:absolute; display:;left: 0px; top: 0px;">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="rightpagetitle">
	  <tr>    
	    <td align="left" valign="bottom" style="padding-bottom:5px;">&nbsp;您的位置：<img src="/images/arrow.gif" />增加</td>
	    <td align="right" valign="bottom" style="padding-bottom:5px;">&nbsp;
	      <span>
	        <a target="mainBottomFrame" href="/commonTable/queryObject.action">
	          <img src="/images/kx_query.gif" alt="查询" border="0" width="16" height="16"/>查询
	        </a>
	      </span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	      
	      <span>
	        <a target="mainBottomFrame" href="/commonTable/toAddObject.action">
	          <img src="/images/kx_edit.gif" alt="增加" border="0" width="16" height="16"/>增加
	        </a>
	      </span>
	      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     
	    </td>
	  </tr>  
	</table>
	</div>
	<br><br><br><br/>
		<form name="MyForm" method="post" action="">
		
			<div style="width:100%;height:100;overflow:auto; z-index=4;">
				<%
				ResultSetMetaData data= (ResultSetMetaData)request.getSession().getAttribute("tableColumnName");
				%>
				<input type="hidden" name="<%=data.getColumnName(1) %>" value=""/>
				<input type="hidden" name="tableName" value="${tableName}"/>
				
				<table border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#BDD3E7">			
					<% 
					for(int i = 2 ; i<= data.getColumnCount() ; i++){ 
		             //获得指定列的列名 
		            String columnName = data.getColumnName(i); 
		          	%>
		          	<tr>
		          	<td style="background:#C6DFFF;" valign="bottom"><%=columnName %>:</td>
		          	<td><input type="text" name="<%=columnName %>" value=""/></td>
		          	</tr>
		          	<% 
			        }
				   %>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" width="100%" height="50">
				  <tr>
				    <td width="100%" align="center">
				    </td>
				  </tr>
				  &nbsp;&nbsp;&nbsp;
				  <tr>
				    <td width="100%" align="center">      
				      <input type="button" value="提交" class="button_1" onclick="saveObject()" />
				      &nbsp;&nbsp;&nbsp;
					  <input type="button" value="返回" class="button_1" style="cursor:'hand'" onclick="back()" />
				    </td>
				  </tr>
				</table>
		</div>
		</form>
		
	</body>
</html>







