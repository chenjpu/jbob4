<%@ page contentType="text/html;charset=GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<% 
	//设置页面不缓存   
    request.setAttribute("decorator","none");   
    response.setHeader("Cache-Control","no-cache");   
    response.setHeader("Pragma","no-cache");   
    response.setDateHeader("Expires",0);   
%> 
<html>
	<head>
		<title>标榜洗车用品ERP系统</title>
		<link href="css/comm.css" type="text/css" rel="stylesheet" />
		<script src="ajax/comm.js"></script>
	</head>

<body onload="document.all.user.focus();">
<script>
	function login(){
		var user=document.all("operatorinfo.user").value;
		var password=document.all("operatorinfo.password").value;
		if(user == "" || password == ""){
			alert("请输入账号密码");
			return;
		}
		var url="login/login.action?operatorinfo.user="+user+"&operatorinfo.password="+password;
		send(url);
		if(strText == 'true'){
			window.location.href='index.jsp';
		}else{
			alert("输入的账号或密码有误，请重新输入");
		}
	}
	
	function reInput(){
		document.all("operatorinfo.user").value="";
		document.all("operatorinfo.password").value="";
	}
	
	  //回车触发某按钮的单击事件 
		function Query() 
		{ 
    		if(event.keyCode ==13) 
    		{   	    		
				login();
				return false;
    		} 
		} 
</script>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" class="lodincol">
  <tr>
    <td align="center" valign="middle"><table border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td align="left" valign="top" class="lodinbg"><table border="0" cellspacing="10" cellpadding="0" class="lodintab">
          <tr>
            <td height="30">用户名：</td>
            <td><input type="text" id="user" name="operatorinfo.user" onkeydown="Query()" /></td>
          </tr>
          <tr>
            <td height="30">密　码：</td>
            <td><input type="password" id="password" name="operatorinfo.password" onkeydown="Query()" /></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td height="50"><a href="#" onclick="login()"><img src="img/bot_lodin.png" width="84" height="31" border="0"></a> <a href="#"  onclick="reInput()"><img src="img/bot_chongzhi.png" width="84" height="31" border="0"></a></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
