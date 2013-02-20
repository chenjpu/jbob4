<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML >
<html>
<head>
<title>PingGuoSoft系统</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="springmvc,hibernate">
<meta http-equiv="description" content="springmvc+hibernate+easyui示例项目">
<jsp:include page="/WEB-INF/jsp/static_resource.jsp"></jsp:include>
</head>
<body class="easyui-layout layout" oncontextmenu="return false" onbeforeunload="return '确认要离开？';" >
	<div data-options="region:'north',border:false,href:'${pageContext.request.contextPath}/layout/north.jsp'" style="height: 60px;overflow: hidden;" class="logo">
	</div>
	<div data-options="region:'west',split:true,title:'导航',iconCls:'icon-navigation',href:'${pageContext.request.contextPath}/layout/west.jsp'" style="width: 200px;overflow: hidden;">
	</div>
	<div data-options="region:'center',href:'${pageContext.request.contextPath}/layout/center.jsp'" style="overflow: hidden;"></div>
	<!--
	<div data-options="region:'east',title:'日历',split:true" style="width: 200px;overflow: hidden;">
		<jsp:include page="layout/east.jsp"></jsp:include>
	</div>-->
	<div data-options="region:'south'" style="height: 27px;overflow: hidden;">
		<jsp:include page="layout/south.jsp"></jsp:include>
	</div>
	<jsp:include page="user/login.jsp"></jsp:include>
	<jsp:include page="user/reg.jsp"></jsp:include>
</body>
</html>