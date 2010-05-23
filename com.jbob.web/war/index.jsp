<%-- --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String basePath=request.getContextPath();
	//登录成功后，需要把该用户显示至在线用户
	//AppUtil.addOnlineUser(request.getSession().getId(), ContextUtil.getCurrentUser());
	//if(ContextUtil.getCurrentUser().getRights().contains("__ALL")){
		request.setAttribute("IS_MANAGER",true);
	//}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="msthemecompatible" content="no">
		<title>J.Bob Inc.－－企业信息化管理系统${IS_MANAGER}</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/ext3/resources/css/ext-all-notheme.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/admin.css"/>
		
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/ext3/ux/css/ux-all.css"/>
		<!-- load the extjs libary -->
		<script type="text/javascript" src="<%=basePath%>/js/dynamic.jsp"></script>
		<script type="text/javascript" src="<%=basePath%>/ext3/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="<%=basePath%>/ext3/ext-all.js"></script>
		<script type="text/javascript" src="<%=basePath%>/ext3/ux/ux-all.js"></script>
		<script type="text/javascript" src="<%=basePath%>/ext3/ext-lang-zh_CN.js"></script>
		
		<script type="text/javascript" src="<%=basePath%>/js/core/AppUtil.js"></script>
		
		<script type="text/javascript" src="<%=basePath%>/js/core/using.js"></script>
		<script type="text/javascript" src="<%=basePath%>/ext3/ux/Toast.js"></script>
		
		<script type="text/javascript" src="<%=basePath%>/js/core/SystemCalendar.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/core/TreeSelector.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/core/date.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/core/ux/TreePanelEditor.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/core/ux/TreeXmlLoader.js"></script>

        <!-- 
		<script type="text/javascript" src="<%=basePath%>/js/selector/UserSelector.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/selector/UserSubSelector.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/selector/DepSelector.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/selector/RoleSelector.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/selector/GoodsSelector.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/selector/CarSelector.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/selector/CustomerSelector.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/selector/OnlineUserSelector.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/selector/BookSelector.js"></script>	
		<script type="text/javascript" src="<%=basePath%>/js/selector/ProjectSelector.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/selector/ProviderSelector.js"></script>
		
		<script type="text/javascript" src="<%=basePath%>/js/info/MessageWin.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/info/MessageReplyWin.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/info/MessageDetail.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/flow/ProcessNextForm.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/system/FileAttachDetail.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/personal/DutyView.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/personal/DutyForm.js"></script>
        <script type="text/javascript" src="<%=basePath%>/js/sound/soundmanager2.js"></script>
        <script type="text/javascript" src="<%=basePath%>/js/search/SearchForm.js"></script>
         -->
         
	    <script type="text/javascript">
	       var __companyName="J.Bob Inc.";
		   Ext.onReady(function(){
			   	  var storeTheme=getCookie('theme');
			   	  if(storeTheme==null || storeTheme==''){
				   	  storeTheme='ext-all';
			   	  }
			   	  Ext.QuickTips.init();
			      Ext.util.CSS.swapStyleSheet("theme", __fullPath+"/ext3/resources/css/"+storeTheme+".css");  
		    });
	    </script>
	     <script type="text/javascript" src="<%=basePath%>/js/using.register.js"></script>	
	    <script type="text/javascript" src="<%=basePath%>/js/IndexPage.js"></script>
	    <script type="text/javascript" src="<%=basePath%>/js/App.home.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/App.js"></script>		
	</head>
	<body oncontextmenu="return false">
		<div id="loading">
             <div  class="loading-indicator">
                  <img src="<%=basePath%>/images/loading.gif" alt="" width="32" height="32" style="margin-right:8px;" align="absmiddle"/>
         		   正在加载，请稍候......
             </div>
         </div>
         <div id="loading-mask">
         </div>
		<div id="app-header">
			<div style="float:left;max-width:350px;height:50px;width: auto;">
			<img id ="CompanyLogo" src="<%=basePath%>/images/jbob_logo.jpg" height="50" style="max-width:230px;"/>
			<!-- 
			<img id ="CompanyLogo" src="<%=basePath%>/images/jbob_logo.jpg" height="50" style="max-width:230px;"/><img src="<%=basePath%>/images/ht-oa.png" height="50"/>
			 -->
			</div>
			<div id="topInfoPanel" style="text-align:center;float:left;">
				<div id="welcomeMsg">欢迎您，<security:authentication property="principal.fullname"/>，[<a href="<%=basePath%>/j_logout.do">注销</a>]</div>
				<div id="currentTime"><span id="nowTime"></span><span id="nowTime2"></span></div>
			</div>
			<!-- -->
			<div id="setting">
				<a href="<%=basePath%>/help/20091225001.zip" target="blank">帮助</a>
				<c:if test="${IS_MANAGER ==true}">
					|<a href="#" onclick="App.clickTopTab('SysConfigView')">设置</a>
				</c:if>
			</div>
			 
			<div class="clear"></div>
			<div id="navHeader" style="float:left;width:365px;" >
			</div>
			<div id="searchFormDisplay" style="width:260px;float:right;">&nbsp;</div>
		</div>
	</body>
</html>