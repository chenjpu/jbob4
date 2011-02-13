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
    <td colspan="3"><div align="center"><u class="STYLE1">产品12月销售情况</u></div></td>
  </tr>
  <tr>
    <td colspan="3"><div align="center">&nbsp;</div></td>
  </tr>
  <tr>
    <td colspan="3" style="border-top:solid 1px #0066CC;border-right:solid 1px #0066CC;">
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="listtab">
      <tr height="22">
        <td height="22" align="right">序号</td>
        <td align="center">货名规格</td>
        <td align="center">销售量</td>
        <td align="center">百分比</td>
        <td align="center">销售额</td>
        <td align="center">百分比</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">1</td>
        <td>化油器清洗剂</td>
        <td align="center">51,025 </td>
        <td align="center">39.60%</td>
        <td align="center">4,884,961.20 </td>
        <td align="center">41.34%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">2</td>
        <td>多功能泡沫</td>
        <td align="center">29,984 </td>
        <td align="center">23.27%</td>
        <td align="center">1,640,185.62 </td>
        <td align="center">13.88%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">3</td>
        <td>仪表蜡</td>
        <td align="center">9,007 </td>
        <td align="center">6.99%</td>
        <td align="center">946,257.18 </td>
        <td align="center">8.01%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">4</td>
        <td>柏油清洁剂</td>
        <td align="center">6,066 </td>
        <td align="center">4.71%</td>
        <td align="center">801,999.70 </td>
        <td align="center">6.79%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">5</td>
        <td>刹车油</td>
        <td align="center">3,258 </td>
        <td align="center">2.53%</td>
        <td align="center">773,154.40 </td>
        <td align="center">6.54%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">6</td>
        <td>防冻液</td>
        <td align="center">6,541 </td>
        <td align="center">5.08%</td>
        <td align="center">586,373.20 </td>
        <td align="center">4.96%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">7</td>
        <td>喷漆</td>
        <td align="center">5,414 </td>
        <td align="center">4.20%</td>
        <td align="center">311,887.20 </td>
        <td align="center">2.64%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">8</td>
        <td>车底胶</td>
        <td align="center">1,801 </td>
        <td align="center">1.40%</td>
        <td align="center">229,921.60 </td>
        <td align="center">1.95%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">9</td>
        <td>发动机清洗剂</td>
        <td align="center">2,925 </td>
        <td align="center">2.27%</td>
        <td align="center">207,806.80 </td>
        <td align="center">1.76%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">10</td>
        <td>轮胎光亮剂</td>
        <td align="center">1,671 </td>
        <td align="center">1.30%</td>
        <td align="center">193,151.40 </td>
        <td align="center">1.63%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">11</td>
        <td>玻璃水</td>
        <td align="center">3,865 </td>
        <td align="center">3.00%</td>
        <td align="center">179,554.80 </td>
        <td align="center">1.52%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">12</td>
        <td>车底装甲</td>
        <td align="center">729 </td>
        <td align="center">0.57%</td>
        <td align="center">186,957.78 </td>
        <td align="center">1.58%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">13</td>
        <td>水箱宝</td>
        <td align="center">2,005 </td>
        <td align="center">1.56%</td>
        <td align="center">165,643.20 </td>
        <td align="center">1.40%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">14</td>
        <td>积碳净</td>
        <td align="center">591 </td>
        <td align="center">0.46%</td>
        <td align="center">69,869.20 </td>
        <td align="center">0.59%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">15</td>
        <td>雨刷精</td>
        <td align="center">372 </td>
        <td align="center">0.29%</td>
        <td align="center">43,176.80 </td>
        <td align="center">0.37%</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">16</td>
        <td>134a雪种</td>
        <td align="center">60 </td>
        <td align="center">0.05%</td>
        <td align="center">19,015.30 </td>
        <td align="center">0.16%</td>
      </tr>
      <tr height="22">
        <td height="22" colspan="2" align="center">总销售</td>
        <td align="center">128,842 </td>
        <td align="center">96.47%</td>
        <td align="center">11,817,152.68 </td>
        <td align="center">94.00%</td>
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







