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
    <title>业务跟踪系统</title>
    <link href="../../css/pagination.css" rel="stylesheet" type="text/css" media="all" />
	<link href="../../css/comm.css" type="text/css" rel="stylesheet"/>
	<script src="../../ajax/comm.js"></script>
	
	<link rel="stylesheet" type="text/css" href="../../jquery-easyui-1.2/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../../jquery-easyui-1.2/themes/icon.css">
	<script type="text/javascript" src="../../jquery-easyui-1.2/jquery-1.4.4.js"></script>
	<script type="text/javascript" src="../../jquery-easyui-1.2/jquery.easyui.min.js"></script>
	<style type="text/css"> 
	
	/*重点：固定表头样式*/
	.scrollColThead {position: relative;top: expression(this.parentElement.parentElement.parentElement.scrollTop);z-index:2;}
	
	</style> 
	<script type="text/javascript">
		function String.prototype.trim(){return this.replace(/(^\s*)|(\s*$)/g,"");}
	 		
 		onload=function(){
		$('#pjSources').combobox({
				url:'../../staticData/pjSourceInfo.json',
				valueField:'id',
				textField:'text',
				onLoadSuccess:function(){
					$('#pjSources').combobox('setValue', '${queryBean.pjSources}');
				}
			});
			
		$('#pjCategory').combobox({
				url:'../../staticData/pjStatusInfo.json',
				valueField:'id',
				textField:'text',
				onLoadSuccess:function(){
					$('#pjCategory').combobox('setValue', '${queryBean.pjCategory}');
				}
			});
	    $('#pjManager').combobox({
				url:'../../staticData/pjAuditorsInfo.json',
				valueField:'id',
				textField:'text',
				onLoadSuccess:function(){
					$('#pjManager').combobox('setValue', '${queryBean.pjManager}');
				}
		    });
			$('#pjItime1').datebox( {
				currentText : '今天',
				closeText : '关闭',
				disabled : false,
				formatter : formatDate
	
			});
			$('#pjItime2').datebox( {
				currentText : '今天',
				closeText : '关闭',
				disabled : false,
				formatter : formatDate
	
			});
			$('#pjItime3').datebox( {
				currentText : '今天',
				closeText : '关闭',
				disabled : false,
				formatter : formatDate
	
			});
			$('#pjItime4').datebox( {
				currentText : '今天',
				closeText : '关闭',
				disabled : false,
				formatter : formatDate
	
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
	
		
		function listover(obj){
			obj.style.backgroundColor = '#FED8D6';
		}
		
		function listout(obj){
			 obj.style.backgroundColor = '#FFFFFF';
		}
		
 	</script>
	</head>	
	<body>
	<script type="text/javascript">
		
		function pjInfoQuery(){
		if(isChecked()){
			document.MyForm.action="../../pjInfo/queryObject.action";
			document.MyForm.submit();
			}
		}
		function isChecked(){
			var tf=compareDate(document.all.pjItime1.value,document.all.pjItime2.value);
			if(tf==1){
				alert("结束时间不能小于开始时间!");
				return false;
			}

			return true;
		}
		/*
	     *时间比较
	     *时间格式: yyyy-mm-dd hh:mm:ss 不够位数不补0
	     *
	     */
	    function compareDate(date1, date2){
	    	if(date1 == "" || date2 ==""){
	    		return 0;
	    	}
	        year1 = date1.substring(0,date1.indexOf("-"));
	        year2 = date2.substring(0,date2.indexOf("-"));
	        month1 = date1.substring(date1.indexOf("-")+1,date1.lastIndexOf("-"));
	        month2 = date2.substring(date2.indexOf("-")+1,date2.lastIndexOf("-"));
	        day1 = date1.substring(date1.lastIndexOf("-")+1);
	        day2 = date2.substring(date2.lastIndexOf("-")+1);
	        /*
	        alert("year1=" + year1);
	        alert("year2=" + year2);
	        alert("month1=" + month1);
	        alert("month2=" + month2);
	        alert("day1=" + day1);
	        alert("day2=" + day2);
	        */
	        if(parseInt(year1) < parseInt(year2)||parseInt(year1) == parseInt(year2)){
	        	if( parseInt(month1) < parseInt(month2)||parseInt(month1) == parseInt(month2) ){
		           if( parseInt(day1) < parseInt(day2) || parseInt(day1) == parseInt(day2)){
			            return 0;
			        }
		        }
	        }
	        return 1;
	    }
		
		function pjInfoAdd(){
			document.all.addObjectDIV.style.display="";
			document.all.addIframe.src="shipmentInfoAdd.jsp";
			
		}
		function pjInfoEdit(id){
			document.all.addObjectDIV.style.display="";
			document.all.addIframe.src="../../pjInfo/toEditObject.action?bean.pjNo="+id;

		}
		function pjInfoDel(id){
			if (confirm('确定删除吗？')) {
				var url="../../pjInfo/delObject.action?bean.pjNo="+id;
				send(url);
				if(strText == 'true'){
					pjInfoQuery();
					alert("操作成功！");
				}else{
					alert(strText);
				}
			}
		}
		function pjInfoDelBatch(){
			var pjk = document.all("pjInfoId");
			var str="'0'";
			if(pjk.checked){
				pjInfoDel(pjk.value);		
			}else{
				for(i=0;i<pjk.length;i++){
					if(pjk[i].checked){
						str+=","+pjk[i].value
					}
				}	
			}
			
			if(str == "'0'"){
			  alert("请勾选需要操作的记录!");
			}else{
				pjInfoDel(str);
			}
		}
		
		function setChenked(){
			var chk = document.all("pjInfoId");
			var chks = document.all("checkIds");
			var tf=true;
			if(chks.checked){
				tf=true;
			}else{
				tf=false;
			}
			if(chk.checked){
				chk.checked=tf;		
			}else{
				for(i=0;i<chk.length;i++){
					chk[i].checked=tf;
				}	
			}
		}
	</script>
		<form name="MyForm" method="post" action="">
		<div id="addObjectDIV" style="width:650px;height:68%;overflow:hidden;z-index=18;visibility:;position:absolute; display:none;left: 18%; top: 15%;">
		
		 <iframe src="#" id="addIframe" name="addIframe" width="100%" height="100%" marginwidth="0" marginheight="0" frameborder="0" scrolling="no"></iframe> 

		</div>
<table border="0" align="center" cellpadding="0" cellspacing="0" class="mtab mtabtop">
  <tr>
    <td class="mtit"><img src="../../img/pictit.gif" width="13" height="13" > 查询条件</td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0" class="sreata">
      <tr>
        <th class="sreabg">客户</th>
        <td><input id="pjName" name="queryBean.pjName" class="easyui-validatebox" value="${queryBean.pjName}" validType="maxLength[20]" invalidMessage="注：20个汉字以内" required="false" /></td>
        <th class="sreabg">销货单号</th>
        <td><input id="pjName" name="queryBean.pjName" class="easyui-validatebox" value="${queryBean.pjName}" validType="maxLength[20]" invalidMessage="注：20个汉字以内" required="false" /></td>
        
        <th class="sreabg">缸号色号</th>
        <td><input id="pjName" name="queryBean.pjName" class="easyui-validatebox" value="${queryBean.pjName}" validType="maxLength[20]" invalidMessage="注：20个汉字以内" required="false" /></td>
        
        <th class="sreabg">时间</th>
        <td>
        <input id="pjItime1" class="easyui-datebox" name="queryBean.pjItime1" value="${queryBean.pjItime1}" size="10" required="false" readonly="true">
        ~
        <input id="pjItime2" class="easyui-datebox" name="queryBean.pjItime2" value="${queryBean.pjItime2}" size="10" required="false" readonly="true">
        </td>
       
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="60" align="right"><img src="../../img/sreach.gif" title="查询" style="cursor:hand;" onclick="pjInfoQuery();">&nbsp;</td>
  </tr>
</table>
<table border="0" align="center" cellpadding="0" cellspacing="0" class="mtab mtabtop">
  <tr>
    <td class="mtit"><img src="../../img/pictit.gif" width="13" height="13" > 结果列表</td>
  </tr>
</table>
<div style="width:100%;overflow:auto;z-index=1;display:;">
    <table style="width:100%" border="0" cellspacing="0" cellpadding="0">
      <tr class="scrollColThead">
        <td align="right" class="tablistbg">
           	<img src="../../img/bot_xinjian.gif" width="57" height="22" style="cursor:hand;" onclick="pjInfoAdd();">
        	<img src="../../img/bot_shanchu.gif" width="57" height="22" style="cursor:hand;" onclick="pjInfoDelBatch();">
        	<img src="../../img/bot_daochu.gif" style="cursor:hand;" onclick="riskExport()"/>
        	<img src="../../img/bot_daoru.gif" style="cursor:hand;" onclick="riskExport()"/>
        </td>
      </tr>     
    </table>
</div> 		 		
<div style="width:100%;height:280px;overflow:auto;z-index=2;display:;background-color:#fff;">
	 		
	<table id="tableData" cellspacing="0" class="listtab" width="100%">
      <tr class="scrollColThead">
    	<th class="listtabtit" ><input type="checkbox" id="checkIds" name="checkIds" onclick="setChenked()"></th>
		<th class="listtabtit">客户</th>
		<th class="listtabtit">日期</th>
		<th class="listtabtit">销货单号</th>
		<th class="listtabtit">缸号色号</th>
		<th class="listtabtit">品种</th>
		<th class="listtabtit">码数</th>
		<th class="listtabtit">单价</th>
		<th class="listtabtit">代表</th>
		<th class="listtabtit">操作</th>
      </tr>
         
      <tr onmouseout="listout(this)" onmouseover="listover(this)">
    	<td align="center"><span class="listtabtit">
        <input type="checkbox" id="pjInfoId" name="pjInfoId" value="''">
        </span></td>
        <td>合坚</td>
        <td>2011-12-1</td>
        <td>0001812</td>
        <td>B1009-102</td>
        <td>HF1750A</td>
        <td>2300</td>
        <td>28</td>
        <td>水</td>
        <td nowrap><a href="#">修改</a> | <a href="#">删除</a></td>
		</tr>
	</table>
			
</div>
        		
		<!-- 页码信息 -->	
		<div align="right" style="width:100%;height:20px;z-index=7;display:;left: 0px; top: 530px;">
			<table style="width:100%" border="0" cellspacing="0" cellpadding="0">
		      <tr class="scrollColThead">
		        <td align="right" class="tablistbg">
				每页显示&nbsp;<input type="text" name="pageBean.rowCount" value="${pageBean.rowCount}" size="3" maxlength="3" style="border:solid 1px #7f9db9;padding: 1 2;"/>
				条记录&nbsp;&nbsp;&nbsp;
				当前是第&nbsp;<font color='red'><span id="currPageIndex">${currPageIndex+1}</span></font>/<font color='red'><span id="allPageCount">${pageBean.allPageCount}</span></font> &nbsp;共
				<font color="red"><span id="recordCount">${pageBean.recordCount}</span></font>&nbsp;条记录,跳转
				<input type="text" size="3" id="pageNo" value="1" maxlength="3" style="border:solid 1px #7f9db9;padding: 1 2;" />
				<img src="../../images/Next_Down.gif" title="跳转" onclick="goPage()" style="cursor: hand;" />
				<input type="button" id="first" value="首  页" class="right_button_threeds" onClick="firstPage()" />
				<input type="button" id="previous" value="上一页" class="right_button_threeds" onClick="previousPage()" />
				<input type="button" id="next" value="下一页" class="right_button_three" onClick="nextPage()" />
				<input type="button" id="last" value="尾  页" class="right_button_three" onClick="lastPage()" />
				</td>
		      </tr>     
		    </table>
			
		</div>			
		<script type="text/javascript">
			var current=${currPageIndex+1};
			var rowCount=${pageBean.allPageCount};
			//转到下一页
			    function nextPage() {	
			    	if(current < rowCount){
			        	current = current + 1;
			        }else if(current == rowCount){     	
			        	return;
			        }
			        if(current == rowCount){	        	
			        	document.all.next.className="right_button_threeds";
			       		document.all.last.className="right_button_threeds";	       		
			        }
			       	document.all.first.className="right_button_three";
			       	document.all.previous.className="right_button_three";
			       	
			       	document.all.currPageIndex.innerHTML=current;
			       	go(current);
			    }
			//转到上一页    
			    function previousPage() {
			    	if(current > 1){
			        	current = current - 1;
			        }else{	        	
			        	return;
			        }
			    	if(current == 1){
			        	document.all.first.className="right_button_threeds";
			       		document.all.previous.className="right_button_threeds";
			        }
			        document.all.next.className="right_button_three";
			       	document.all.last.className="right_button_three";
			       	
			       	document.all.currPageIndex.innerHTML=current;
			       	go(current);
			    }
			//转到第一页
			    function firstPage() {
			    	if(current == 1){
			    		return;
			    	}else{
			    		current = 1;
			    	}	    	
			        document.all.first.className="right_button_threeds";
			       	document.all.previous.className="right_button_threeds";
			       	document.all.next.className="right_button_three";
			       	document.all.last.className="right_button_three";
			       	
			       	document.all.currPageIndex.innerHTML=current;
			       	go(current);
			    }
			//转到最后一页
			    function lastPage() {
			        if(current == rowCount){
			    		return;
			    	}else{
			    		current = rowCount;
			    	}	
			        document.all.first.className="right_button_three";
			       	document.all.previous.className="right_button_three";
			       	document.all.next.className="right_button_threeds";
			       	document.all.last.className="right_button_threeds";
			       	
			       	document.all.currPageIndex.innerHTML=current;
			       	go(current);
			    } 
			// 跳到输入的页号，pageNo是输入页码的输入框的名称 
			    function goPage() {
			        if (!isNumber(document.all.pageNo.value)){
				        alert("请正确输入跳转的页码！");
				        return;
			        }
			        var page = parseInt(document.all.pageNo.value);
			        if(page==NaN || page==undefined){
			        	count=1;
			        }else{
			        	current = page;
			        }				        
			        
			        if(current == 1){
			        	document.all.first.className="right_button_threeds";
			       		document.all.previous.className="right_button_threeds";
			       		document.all.next.className="right_button_three";
			       		document.all.last.className="right_button_three";
			        }else if(current == rowCount){
			        	document.all.first.className="right_button_three";
			       		document.all.previous.className="right_button_three";
			        	document.all.next.className="right_button_threeds";
			       		document.all.last.className="right_button_threeds";
			        }
			        document.all.currPageIndex.innerHTML=current;
			        go(current);
			    }
			//转到指定页
			    function go(current) {
			    	
			    	current = current - 1;
			    	document.MyForm.action="../../pjInfo/queryObject.action?currPageIndex="+current;
					document.MyForm.submit();
			    	
			    }
			    
			    //判断是否为数字，是则返回true,否则返回false
				function isNumber( s ){
					var regu = "^[0-9]+$";
					var re = new RegExp(regu);
					if (s.search(re) != -1) {
					    return true;
					} else {
					    return false;
					}
				}
				
				//更新当前页数、总页数、总记录数
				function setPageRecordCount(pageIndex,pageCount,recordCount){
					if(pageIndex != ''){
						document.all.currPageIndex.innerHTML=pageIndex;
					}
					if(pageCount != ''){
						document.all.allPageCount.innerHTML=pageCount;
					}
					if(recordCount != ''){
						document.all.recordCount.innerHTML=recordCount;
					}
					
				}							
				
			</script>			
		</form>		
		
	</body>
</html>







