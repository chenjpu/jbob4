<%@ page contentType="text/html;charset=GBK"%>
<%@page import="com.cy.erp.web.model.LoginData;"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
LoginData loginData = (LoginData) request.getSession().getAttribute("loginData");
if (loginData == null) {
%>
	<script>window.location.href='login.jsp';</script>
<%	
}
%>
<html>
<head>
	<title>标榜洗车用品ERP系统</title>
	<link href="css/comm.css" type="text/css" rel="stylesheet" />
	<script src="ajax/comm.js"></script>
	
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.2/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.2/themes/icon.css">
	<script type="text/javascript" src="jquery-easyui-1.2/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.2/jquery.easyui.min.js"></script>
	<script>
		function relogin(){
			send('login/logout.action');
			window.location.reload();
		}
		
		var indexNo=0;
		function addTab(nameTabs,actionURL){
			indexNo++;
			$('#mainTabs').tabs('add',{
				title:nameTabs+indexNo,
				content:'<iframe scrolling="yes" frameborder="0"  src="'+actionURL+'" style="width:100%;height:100%;"></iframe>',
				closable:true
			});
		}
	</script>
</head>
<body class="easyui-layout">
	<!-- div id="mymenu" style="width:150px;">
		<div>item1</div>
		<div>item2</div>
	</div-->
		<div region="north" border="false" style="height:59px;padding:0px;">
			<table width="100%" height="59" border="0" cellpadding="0" cellspacing="0">
			  <tr>
			    <td width="918"><img src="img/toptit.gif" width="918" /></td>
			    <td align="right" valign="bottom" class="topbg"><a href="#" onclick="relogin()"><img src="img/tuichu.png" border="0" /></a></td>
			  </tr>
			</table>
		</div>
		<!-- div region="south" title="South Title" split="true" style="height:100px;padding:10px;background:#efefef;">
			<div class="easyui-layout" fit="true" style="background:#ccc;">
				<div region="center">sub center</div>
				<div region="east" split="true" style="width:200px;">sub center</div>
			</div>
		</div-->
		<!-- div region="east" iconCls="icon-reload" title="Tree Menu" split="true" style="width:180px;">
			<ul class="easyui-tree" url="tree_data.json"></ul>
		</div-->
		<div region="west" split="true" title="系统菜单" style="width:168px;padding1:1px;overflow:hidden;">
			<div class="easyui-accordion" fit="true" border="false">
				<div title="货单管理" selected="true" style="overflow:auto;">
					<table width="100%" border="0" cellspacing="0" cellpadding="0" class="topline">
				      <tr>
				        <td align="center"><a href="#" onclick="addTab('提货单输单','jsp/trackOrder/trackOrderQuery.jsp');"><img src="img/bot_xiangmu.gif" border="0" /><br/>提货单输单</a></td>
				      </tr>
				      <tr>
				        <td align="center"><a href="#" onclick="addTab('提货单查询','jsp/trackOrder/trackOrderQuery.jsp');"><img src="img/bot_shengji.gif" border="0" /><br/>提货单查询</a></td>
				      </tr>
				    </table>
				</div>
				<div title="统计报表" style="overflow:auto;">
					<table width="100%" border="0" cellspacing="0" cellpadding="0" class="topline">
				      <tr>
				        <td align="center" ><a href="#" onclick="addTab('风险管理','risk/queryObject.action');"><img src="img/bot_faxian.gif" border="0" /></a></td>
				      </tr>
				      
				    </table>
				</div>
				<div title="业务数据管理">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"  class="topline">
				      <tr>
				        <td align="center"><a href="#" onclick="addTab('项目覆盖情况统计','totalInfo/queryObject.action');"><img src="img/bot_fugai.gif" border="0" /></a></td>
				      </tr>
				      <tr>
				        <td align="center"><a href="#" onclick="addTab('审计发现问题情况统计','totalRisks/queryObject.action');"><img src="img/bot_wenti.gif" border="0" /></a></td>
				      </tr>
				      <tr>
				        <td align="center"><a href="#" onclick="addTab('项目情况统计','totalMember/queryObject.action');"><img src="img/bot_qingkuang.gif" border="0" /></a></td>
				      </tr>
				    </table>
				</div>
				<div title="数据维护" style="">
					<table width="100%" border="0" cellspacing="0" cellpadding="0" class="topline">
				      <tr>
				        <td align="center"><a href="#"><img src="img/bot_shengji.gif" border="0" /></a></td>
				      </tr>
				      <tr>
				        <td align="center"><a href="#"><img src="img/bot_laiyuan.gif" border="0" /></a></td>
				      </tr>
				      <tr>
				        <td align="center"><a href="#"><img src="img/bot_zuzhi.gif" border="0" /></a></td>
				      </tr>
				      <tr>
				        <td align="center"><a href="#"><img src="img/bot_fengxian.gif" border="0" /></a></td>
				      </tr>
				    </table>
				</div>
			</div>
		</div>
		<!-- 可不加title="工作区"  -->
		<div region="center" style="overflow:hidden;">
			<div id="mainTabs"  class="easyui-tabs" fit="true" border="false">
				<div title="主界面" style="padding:20px;overflow:hidden;"> 
					
					<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0" >
				      <tr>
				        <td valign="bottom" align="right"><font>广州市创壹广告设计有限公司 版权所有</font></td>
				      </tr>
				    </table>
					
				</div>
			</div>
		</div>
</body>
</html>

