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
    <link href="../../css/pagination.css" rel="stylesheet" type="text/css" media="all" />
	<link href="../../css/comm.css" type="text/css" rel="stylesheet"/>
	<script src="../../ajax/comm.js"></script>
	<style type="text/css"> 
	<!--
	.STYLE1 {
		font-size: 28px;
		font-family: "黑体";
		color: #0066CC;
	}
	-->
	</style> 
	<script type="text/javascript">
		
		function listover(obj){
			obj.style.backgroundColor = '#FED8D6';
		}
		
		function listout(obj){
			 obj.style.backgroundColor = '#FFFFFF';
		}
		
 	</script>
	</head>	
	<body>
	<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="3">
    <div align="right">
    月份：<a href="#">1月</a>
    <a href="#">2月</a>
    <a href="#">3月</a>
    <a href="#">4月</a>
    <a href="#">5月</a>
    <a href="#">6月</a>
    <a href="#">7月</a>
    <a href="#">8月</a>
    <a href="#">9月</a>
    <a href="#">10月</a>
    <a href="#">11月</a>
    <a href="#">12月</a>
    <input type="button" name="button" id="button" value="导出文件" onclick="specificationChange(1)" />
    </div>
    <br>
    </td>
  </tr>
  <tr>
    <td colspan="3"><div align="center"><u class="STYLE1">客户12月销售状况</u></div></td>
  </tr>
  <tr>
    <td colspan="3"><div align="center">&nbsp;</div></td>
  </tr>
  <tr>
    <td colspan="3" style="border-top:solid 1px #0066CC;border-right:solid 1px #0066CC;">
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="listtab">
      <tr height="22">
        <td width="40" height="22" align="right">序号</td>
        <td align="center">经销商</td>
        <td width="93" align="center">销售量</td>
        <td width="105" align="center">百分比</td>
        <td width="98" align="center">销售额</td>
        <td width="94" align="center">百分比</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">1</td>
        <td>永福路新环球</td>
        <td align="right">14,007 </td>
        <td align="right">10.87%</td>
        <td align="right">1,355,478.40 </td>
        <td align="right">11.47%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">2</td>
        <td width="136">北京陈英强</td>
        <td align="right">12,054 </td>
        <td align="right">9.36%</td>
        <td align="right">1,093,700.10 </td>
        <td align="right">9.26%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">3</td>
        <td>东莞王燕平</td>
        <td align="right">7,346 </td>
        <td align="right">5.70%</td>
        <td align="right">732,782.40 </td>
        <td align="right">6.20%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">4</td>
        <td>厦门丁磊</td>
        <td align="right">4,933 </td>
        <td align="right">3.83%</td>
        <td align="right">573,770.80 </td>
        <td align="right">4.86%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">5</td>
        <td>成都叶桂庭</td>
        <td align="right">7,258 </td>
        <td align="right">5.63%</td>
        <td align="right">572,054.80 </td>
        <td align="right">4.84%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">6</td>
        <td>金华吴晓春</td>
        <td align="right">5,298 </td>
        <td align="right">4.11%</td>
        <td align="right">494,024.00 </td>
        <td align="right">4.18%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">7</td>
        <td>西安梁昕燕</td>
        <td align="right">4,722 </td>
        <td align="right">3.66%</td>
        <td align="right">407,979.60 </td>
        <td align="right">3.45%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">8</td>
        <td>深圳安轮</td>
        <td align="right">3,878 </td>
        <td align="right">3.01%</td>
        <td align="right">381,959.40 </td>
        <td align="right">3.23%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">9</td>
        <td>临沂陈文彬</td>
        <td align="right">4,501 </td>
        <td align="right">3.49%</td>
        <td align="right">357,169.60 </td>
        <td align="right">3.02%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">10</td>
        <td>昆明翁爱龙</td>
        <td align="right">3,459 </td>
        <td align="right">2.68%</td>
        <td align="right">307,698.00 </td>
        <td align="right">2.60%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">11</td>
        <td>宁波夏卫仙</td>
        <td align="right">3,724 </td>
        <td align="right">2.89%</td>
        <td align="right">306,808.80 </td>
        <td align="right">2.60%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">12</td>
        <td>佛山恒友</td>
        <td align="right">1,766 </td>
        <td align="right">1.37%</td>
        <td align="right">189,113.20 </td>
        <td align="right">1.60%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">13</td>
        <td>三元里广泰隆</td>
        <td align="right">1,558 </td>
        <td align="right">1.21%</td>
        <td align="right">167,328.00 </td>
        <td align="right">1.42%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">14</td>
        <td>上海麦国喜</td>
        <td align="right">1,938 </td>
        <td align="right">1.50%</td>
        <td align="right">165,629.20 </td>
        <td align="right">1.40%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">15</td>
        <td>福州陈益新</td>
        <td align="right">1,537 </td>
        <td align="right">1.19%</td>
        <td align="right">163,363.20 </td>
        <td align="right">1.38%</td>
      </tr>
      <tr height="22">
        <td height="22" colspan="2" align="center">总销售</td>
        <td align="right">128,842 </td>
        <td align="right">60.52%</td>
        <td align="right">11,817,152.68 </td>
        <td align="right">61.51%</td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="3"></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
	</body>
</html>







