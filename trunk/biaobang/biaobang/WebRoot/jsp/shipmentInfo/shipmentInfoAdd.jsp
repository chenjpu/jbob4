<%@ page contentType="text/html;charset=GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>    
    <title>业务跟踪系统</title>
    <link href="../../css/comm.css" type="text/css" rel="stylesheet"/>
	<link rel="stylesheet" type="text/css" href="../../jquery-easyui-1.2/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../../jquery-easyui-1.2/themes/icon.css">
	<script type="text/javascript" src="../../jquery-easyui-1.2/jquery-1.4.4.js"></script>
	<script type="text/javascript" src="../../jquery-easyui-1.2/jquery.easyui.min.js"></script>
</head>

<body>
<script>
	onload=function(){
		$('#pjSources').combobox({
				url:'../../staticData/pjSourceInfo.json',
				missingMessage : '必填',
				valueField:'id',
				textField:'text'
			});
			
		$('#pjCategory').combobox({
				url:'../../staticData/pjStatusInfo.json',
				missingMessage : '必填',
				valueField:'id',
				textField:'text'
			});
	   $('#pjDepartment').combobox({
				url:'../../staticData/organizationInfo.json',
				missingMessage : '必填',
				valueField:'id',
				textField:'text'
		    });
	    $('#pjManager').combobox({
				url:'../../staticData/pjAuditorsInfo.json',
				missingMessage : '必填',
				valueField:'id',
				textField:'text'
		    });
		$('#pjName').validatebox({
				missingMessage : '必填.注：20个汉字以内'
			});
		$.extend($.fn.validatebox.defaults.rules, { 
			    minLength: { 
			        validator: function(value, param){ 
			            return value.length >= param[0]; 
			        }, 
			        message: 'Please enter at least {0} characters.' 
			    },
			    maxLength: { 
			        validator: function(value, param){ 
			            return value.length <= param[0]; 
			        }, 
			        message: 'Please enter at least {0} characters.' 
			    }
			});
	}
		
		/*  
		 将Date/String类型,解析为String类型.  
		 传入String类型,则先解析为Date类型  
		 不正确的Date,返回 ''  
		 如果时间部分为0,则忽略,只返回日期部分.  
		 */
		function formatDate(v) {
			if (v instanceof Date) {
				var y = v.getFullYear();
				var m = v.getMonth() + 1;
				var d = v.getDate();
				var h = v.getHours();
				var i = v.getMinutes();
				var s = v.getSeconds();
				var ms = v.getMilliseconds();
				if (ms > 0)
					return y + '-' + m + '-' + d + ' ' + h + ':' + i + ':' + s
							+ '.' + ms;
				if (h > 0 || i > 0 || s > 0)
					return y + '-' + m + '-' + d + ' ' + h + ':' + i + ':' + s;
				return y + '-' + m + '-' + d;
			}
			return '';
		}
	
		$( function() {
			$('#pjItime').datebox( {
				currentText : '今天',
				closeText : '关闭',
				disabled : false,
				required : true,
				missingMessage : '必填',
				formatter : formatDate
	
			});
		});
		
		function quxiao(){
		   parent.document.all.addObjectDIV.style.display="none";
		}
		
		function pjInfoSaveAdd(){
			if(ischecked()){
				document.MyForm.action="../../pjInfo/saveObjectAdd.action";
				document.MyForm.submit();
				parent.document.all.addObjectDIV.style.display="none";
				
			    //alert("操作成功!");
				//parent.pjInfoQuery();
			}
		}
		
		function ischecked(){
			var str=$('#pjSources').combobox('getValue');
			if(str == ""){
				alert("项目来源不允许为空");
				return false;
			}
			str=$('#pjCategory').combobox('getValue');
			if(str == ""){
			    alert("项目类别不允许为空");
				return false;
			}
			str=document.all.pjName.value;
			if(str == ""){
			    alert("项目名称不允许为空");
				return false;
			}
			str=document.all.pjItime.value;
			if(str == ""){
			    alert("实施时间不允许为空");
				return false;
			}
			str=$('#pjDepartment').combobox('getValue');
			if(str == ""){
			    alert("被审计单位不允许为空");
				return false;
			}
			str=$('#pjManager').combobox('getValue');
			if(str == ""){
			    alert("项目管理人员不允许为空");
				return false;
			}
			return true;
		}
		
		function addAttRow(str){
			var k=document.all.attList.rows.length;
			newRow=document.all.attList.insertRow(k);	
			newRow.ln=k;
			newRow.id=k;
			newRow.align="left"; 
			newRow.style.backgroundColor="#e8e6e7"; 
			newRow.style.height="26px";
			
			c1=newRow.insertCell(0);
			c1.innerHTML="&nbsp;<img src='../../img/fujian1.gif' />附件"+"-"+str;
			
		}
		
		function addFile(){
			var k=document.all.attFileList.rows.length;
			newRow=document.all.attFileList.insertRow(k);	
			newRow.ln=k;
			newRow.id=k;
			
			c1=newRow.insertCell(0);
			c1.innerHTML="<img src='../../img/fujian.gif'/><input type='file' name='upload' id='upload' style='display:;' onchange='addAttRow(this.value)' />&nbsp;<a href='#' onclick='addFile()'>添加</a>&nbsp;&nbsp;&nbsp;&nbsp;";
			
		}
		
	</script>
	<form name="MyForm" method="post" action="" enctype="multipart/form-data">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td class="divtopleft">&nbsp;</td>
        <td class="divtopmid">新建</td>
        <td class="divtopright">&nbsp;</td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td align="center" style="border-left:solid 1px #6890b0; border-right:solid 1px #6890b0;">
    <br/>
	    <table width="100%">
	      <tr>
	        <td align="right">客户：</td>
	        <td>
	        	<input type="text"/>
	       	</td>
	        <td align="right">日期：</td>
	        <td><input id="pjItime" class="easyui-datebox" name="bean.pjItime"  required="true" readonly="true"></input></td>
	       </tr>
	      <tr>
	        <td align="right">销货单号：</td>
	        <td><input type="text"/></td>
	        <td align="right">缸号色号：</td>
	        <td><input type="text"/></td>
	      </tr>
	      <tr>
	        <td align="right">品种：</td>
	        <td><input type="text"/></td>
	        <td align="right">码数：</td>
	        <td><input type="text"/></td>
	        
	      </tr>
	      <tr>
	        <td align="right">单价：</td>
	        <td><input type="text"/></td>
	        <td align="right">代表：</td>
	        <td><input type="text"/></td>
	        
	      </tr>
	      </table>
	      <br/><br/><br/><br/><br/><br/><br/>
      </td>
      </tr>
  <tr>
    <td>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td class="divtopleft01">&nbsp;</td>
        <td align="right" class="divtopmid01">
        <font style="color:red;">注意：.</font>&nbsp;&nbsp;
        <img src="../../img/bot_queding.gif" style="cursor:hand;" onclick="pjInfoSaveAdd();"/> 
        <img src="../../img/bot_quxiao.gif" style="cursor:hand;" onclick="quxiao();"/></td>
        <td class="divtopright01">&nbsp;</td>
      </tr>
    </table>
    </td>
  </tr>
</table>
</form>
</body>
</html>
