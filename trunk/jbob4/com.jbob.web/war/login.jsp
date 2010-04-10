<%@page pageEncoding="UTF-8"%>
	<head>
		<title>J.Bob 用户登录</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/extjs/resources/css/ext-all.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/extjs/resources/css/ext-patch.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css" />
		<%
		response.addHeader("__timeout","true");
		%>
		<script type="text/javascript">
			var __ctxPath="<%=request.getContextPath() %>";
			var __loginImage=__ctxPath+"";
		</script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/extjs/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/extjs/ext-all.js"></script>
		
		<script type="text/javascript" src="<%=request.getContextPath()%>/extjs/ext-lang-zh_CN.js"></script>
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