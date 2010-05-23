<%@page pageEncoding="UTF-8"%>
<html>
	<head>
		<title>J.Bob 用户登录</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/ext3/resources/css/ext-all.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css" />
		<%
		response.addHeader("__timeout","true");
		%>
		<script type="text/javascript">
			var __ctxPath="<%=request.getContextPath() %>";
			var __loginImage=__ctxPath+"/images/jbob_logo.jpg";
		</script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/ext3/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/ext3/ext-all.js"></script>
		
		<script type="text/javascript" src="<%=request.getContextPath()%>/ext3/ext-lang-zh_CN.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/App.LoginWin.js"></script>
		<script type="text/javascript">
	 		Ext.onReady(function(){
		 		Ext.QuickTips.init(); 
		 		new App.LoginWin().show();
			});	
		</script>
	</head>
	<body>
		<div style="text-align: center;">
			<div id="loginArea">
			</div>
		</div>
	</body>
</html>