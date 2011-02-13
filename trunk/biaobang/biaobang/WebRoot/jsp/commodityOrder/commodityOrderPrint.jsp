<%@ page contentType="text/html;charset=GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>    
    <title>标榜洗车用品ERP系统</title>
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
</head>
<style type="text/css">
<!--
.STYLE1 {
	font-size: 36px;
	font-family: "黑体";
	color: #0066CC;
}
-->
</style>
<script type="text/javascript">
		function String.prototype.trim(){return this.replace(/(^\s*)|(\s*$)/g,"");}
	 	
	 	var rowNo="";//当前操作行数
	 	onload=function(){
			$('#specification').combobox({
				url:'../../staticData/specification.json',
				missingMessage : '必填',
				valueField:'id',
				textField:'text',
				onSelect:function(){
						specificationChange();
					}
			});
			
			specificationDiv.style.top=specificationList.offsetTop+166;
		}
		
		function specificationChange(){
			var val = $('#specification').combobox('getValue');
			commData.rows(0).cells(0).innerHTML=rowNo;
		}
		
		function tdClick(obj,no){
			specificationDiv.style.top=obj.offsetTop+144;
			//specificationDiv.style.left=obj.offsetLeft+contentTable.offsetLeft+5;
			rowNo=no;
			commData.rows(0).cells(0).innerHTML=no;
		}
		
		function listover(obj){
			obj.style.backgroundColor = '#FED8D6';
		}
		
		function listout(obj){
			 obj.style.backgroundColor = '#FFFFFF';
		}
		
 	</script>
<body>
<div style="width:90%;overflow:hidden;z-index=40;visibility:;position:absolute;display:;" id="specificationDiv">
	<table id="commData" width="100%" border="0" align="center" cellspacing="0" cellpadding="0" class="listtab">
	<tr onmouseout="listout(this)" onmouseover="listover(this)">
        <td width="5%" align="center">&nbsp;</td>
        <td width="9%" align="center">&nbsp;</td>
        <td width="24%" align="center">
              <select id="specification" class="easyui-combobox" style="width:150px;" name="specification">
              </select>
        </td>
        <td width="8%" align="center">
              <select name="select2" id="select2">
                <option value="A">提货</option>
                <option value="B">B货</option>
                <option value="C">换货</option>
                <option value="D">退货</option>
              </select>
        </td>
        <td width="7%" align="center">&nbsp;</td>
        <td width="5%" align="center">&nbsp;</td>
        <td width="7%" align="center">&nbsp;</td>
        <td width="5%" align="center"><div align="center">
            <input name="textfield" type="text" id="textfield" class="text" maxlength="4" style="width:38px;"  />
        </div></td>
        <td width="5%" align="center"><div align="center">
          <select name="select3" id="select3">
            <option value="箱">箱</option>
            <option value="个">个</option>
            <option value="件">件</option>
            <option value="支">支</option>
                    </select>
          </div></td>
        <td width="7%" align="center">&nbsp;</td>
        <td width="8%" align="center">&nbsp;</td>
        <td width="10%" align="center">&nbsp;</td>
      </tr>
      </table>
</div>
<table width="90%" border="0" align="center" cellspacing="0" cellpadding="0">
  <tr>
    <td><br/><div align="center"><u class="STYLE1">提货单</u></div></td>
  </tr>
  <tr>
    <td><div align="right"><input type="button" name="button" id="button" value="提交" onclick="specificationChange(1)" />日期：2011-1-1</div></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="50%"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td colspan="2" >客户资料</td>
            </tr>
          <tr>
            <td width="17%">客户名称：</td>
            <td width="83%">
				<select name="select" id="select">
                <option value="B-1091">广州市创壹广告设计有限公司</option>
                <option value="B-1091">创壹广告设计有限公司</option>
                <option value="B-1092">创壹广告设计</option>
              </select>
              <select name="select" id="select">
                <option value="B-1091">广州市创壹广告设计有限公司</option>
                <option value="B-1091">创壹广告设计有限公司</option>
                <option value="B-1092">创壹广告设计</option>
              </select>
			</td>
          </tr>
          <tr>
            <td>联系方式：</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>收货明细：</td>
            <td>&nbsp;</td>
          </tr>

        </table></td>
        <td width="516"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td colspan="2" >货运公司</td>
            </tr>
          <tr>
            <td width="16%">客户名称：</td>
            <td width="84%">&nbsp;</td>
          </tr>
          <tr>
            <td>联系方式：</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>收货明细：</td>
            <td>&nbsp;</td>
          </tr>
          
        </table></td>
        </tr>
      
    </table></td>
  </tr>
  <tr>
    <td style="border-right:solid 1px #0066CC;">
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="listtab" id="specificationList">
      <tr class="scrollColThead">
        <th width="5%" class="listtabtit"><div align="center">序号</div></th>
        <th width="9%" class="listtabtit"><div align="center">编码</div></th>
        <th width="24%" class="listtabtit"><div align="center">货名规格</div></th>
        <th width="8%" class="listtabtit"><div align="center">提单属性</div></th>
        <th width="7%" class="listtabtit"><div align="center">类别</div></th>
        <th width="5%" class="listtabtit"><div align="center">规格</div></th>
        <th width="7%" class="listtabtit"><div align="center">单价</div></th>
        <th width="5%" class="listtabtit"><div align="center">数量</div></th>
        <th width="5%" class="listtabtit"><div align="center">单位</div></th>
        <th width="7%" class="listtabtit"><div align="center">重量/吨</div></th>
        <th width="8%" class="listtabtit"><div align="center">体积/m3</div></th>
        <th width="10%" class="listtabtit"><div align="center">金额/元</div></th>
      </tr>
      <tr onmouseout="listout(this)" onmouseover="listover(this)">
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td onClick="tdClick(this,1);" align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
      </tr><tr onmouseout="listout(this)" onmouseover="listover(this)">
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td onClick="tdClick(this,2);" align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
      </tr>
      <tr onmouseout="listout(this)" onmouseover="listover(this)">
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td onClick="tdClick(this,3);" align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
      </tr>
      <tr onmouseout="listout(this)" onmouseover="listover(this)">
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td onClick="tdClick(this,4);" align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
      </tr>
      <tr onmouseout="listout(this)" onmouseover="listover(this)">
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td onClick="tdClick(this,5);" align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
      </tr>
      <tr onmouseout="listout(this)" onmouseover="listover(this)">
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td onClick="tdClick(this,6);" align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
      </tr>
      <tr onmouseout="listout(this)" onmouseover="listover(this)">
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td onClick="tdClick(this,7);" align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
      </tr>
      <tr onmouseout="listout(this)" onmouseover="listover(this)">
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td onClick="tdClick(this,8);" align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
      </tr>
      <tr onmouseout="listout(this)" onmouseover="listover(this)">
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td onClick="tdClick(this,9);" align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
      </tr>
      <tr onmouseout="listout(this)" onmouseover="listover(this)">
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td onClick="tdClick(this,10);" align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
        <td align="center">&nbsp;</td>
      </tr>
	  <tr>
        <td colspan="4">&nbsp;</td>
        <td colspan="2"><div align="right">合计</div></td>
        <td colspan="3">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td colspan="4">&nbsp;</td>
        <td colspan="2"><div align="right">其它费用</div></td>
        <td colspan="5">&nbsp;&nbsp;<input name="textfield" type="text" id="textfield" class="text" maxlength="4" style="width:280px;"  /></td>
        <td>&nbsp;<input name="textfield" type="text" id="textfield" class="text" maxlength="4" style="width:80px;"  /></td>
      </tr>
      <tr>
        <td colspan="9">&nbsp;</td>
        <td colspan="2"><div align="right">金额总计</div></td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td>备注</td>
        </tr>
        <tr>
          <td>(一)购货条款见背面。</td>
        </tr>
        <tr>
          <td>(二)提货单属性:</td>
        </tr>
        <tr>
          <td>(三)<input name="textfield" type="text" id="textfield" class="text" maxlength="4" style="width:280px;"  /></td>
        </tr>
        <tr>
          <td>(四)<input name="textfield" type="text" id="textfield" class="text" maxlength="4" style="width:280px;"  /></td>
        </tr>
        <tr>
          <td>(五)<input name="textfield" type="text" id="textfield" class="text" maxlength="4" style="width:280px;"  /></td>
        </tr>
      </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12%"><div align="right">制单：
        	  <select name="select" id="select">
                <option value="B-1091">张三</option>
                <option value="B-1091">李四</option>
              </select>
        </div></td>
        <td width="16%">&nbsp;</td>
        <td width="12%"><div align="right">审核：
        	<select name="select" id="select">
                <option value="B-1091">张三</option>
                <option value="B-1091">李四</option>
              </select>
        </div></td>
        <td width="17%">&nbsp;</td>
        <td width="12%"><div align="right">送货：
        	<select name="select" id="select">
                <option value="B-1091">张三</option>
                <option value="B-1091">李四</option>
              </select>
        </div></td>
        <td width="15%">&nbsp;</td>
        <td width="12%"><div align="right">客户：
        	<select name="select" id="select">
                <option value="B-1091">张三</option>
                <option value="B-1091">李四</option>
              </select>
        </div></td>
        <td width="15%">&nbsp;</td>
      </tr>
      
    </table></td>
  </tr>
</table>
</body>
</html>