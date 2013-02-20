<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
request.setAttribute("IS_MANAGER",true);
%>

<script type="text/javascript">
<!--
$(function() {
	/* $("#header-nav").tabs('add',{  
		    title:'New Tab',  
		    content:'Tab Body',  
		    closable:true,  
		    tools:[{  
		        iconCls:'icon-mini-refresh',  
		        handler:function(){  
		            alert('refresh');  
		        }  
		    }]  
		});   */
});
//-->
</script>


<div id="app-header" style="margin-left: 250px;">
    <div id="header-left">
	</div>
	<div id="header-main">
		<div id="header-info">
			<a href="javascript:void(0)" onclick="App.MyDesktopClick()" style="text-indent:25px;padding-left: 28px;" class="menu-company" >公司主页</a>
			<a href="javascript:void(0)" onclick="App.clickTopTab('AppHome')" style="text-indent:25px; padding-left: 28px" class="menu-desktop">个人桌面</a>
			<a href="javascript:void(0)" onclick="App.clickTopTab('PersonalMailBoxView')" style="text-indent:25px; padding-left: 28px" class="menu-mail_box">邮件</a>
			&nbsp;
			欢迎您，<c:if test="${sessionInfo.userId != null}"><strong>${sessionInfo.loginName}</strong>，[<a href="#" onclick = "App.Logout()">注销</a>]</c:if>
		</div>
		<div id="header-nav" class="easyui-tabs" data-options="plain:true">
			<div title="协同办公" data-options="iconCls:'icon-nav-oa'" style="padding:20px;display:none;">  
		    </div>  
		    <div title="我的流程" data-options="iconCls:'icon-nav-flow'" style="overflow:auto;padding:20px;display:none;">  
		    </div>  
		    <div title="系统管理" data-options="iconCls:'icon-nav-setting'" style="padding:20px;display:none;">  
		    </div>
		</div>
	</div>
	<div id="header-right">
		<div id="setting">
		    <a href="javascript:void(0)" onclick="alert('开发中')" target="blank">帮助</a>
			<c:if test="${IS_MANAGER ==true}">
				|&nbsp;<a href="javascript:void(0)" onclick="alert('开发中')">设置</a>
			</c:if>
			|&nbsp;<a href="/jforum" target="blank">论坛</a>
		</div>
		<div id="searchFormDisplay" style="width:260px;height:30px;float:right;padding-top:8px;">&nbsp;</div>
	</div>
</div>
