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
    <td colspan="3"><div align="right">
    <input type="button" name="button" id="button" value="导出文件" onclick="specificationChange(1)" />
    </div></td>
  </tr>
  <tr>
    <td colspan="3"><div align="center"><u class="STYLE1">销售动态</u></div></td>
  </tr>
  <tr>
    <td colspan="3"><div align="center">&nbsp;</div></td>
  </tr>
  <tr>
    <td colspan="3" style="border-top:solid 1px #0066CC;border-right:solid 1px #0066CC;">
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="listtab">
      <tr>
        <td rowspan="2" valign="bottom"><div align="right">月份</div></td>
        <td><div align="center">销售量</div></td>
        <td colspan="2"><div align="center">增长率,%</div></td>
        <td><div align="center">销售额</div></td>
        <td colspan="2"><div align="center">增长率,%</div></td>
        </tr>
      <tr>
        <td><div align="center">箱</div></td>
        <td><div align="center">环比</div></td>
        <td><div align="center">同比</div></td>
        <td><div align="center">元</div></td>
        <td><div align="center">环比</div></td>
        <td><div align="center">同比</div></td>
      </tr>
      <tr onmouseout="listout(this)" onmouseover="listover(this)">
        <td height="22" align="right">　1</td>
        <td align="right">63,047 </td>
        <td align="right">-38.14 </td>
        <td align="right">-25.18 </td>
        <td align="right">5,881,456.55 </td>
        <td align="right">-37.34 </td>
        <td align="right">-25.61 </td>
      </tr>
      <tr onmouseout="listout(this)" onmouseover="listover(this)">
        <td height="22" align="right">　2</td>
        <td align="right">99,635 </td>
        <td align="right">58.03 </td>
        <td align="right">92.28 </td>
        <td align="right">9,511,677.54 </td>
        <td align="right">61.72 </td>
        <td align="right">86.30 </td>
      </tr>
      <tr onmouseout="listout(this)" onmouseover="listover(this)">
        <td height="22" align="right">　3</td>
        <td align="right">113,504 </td>
        <td align="right">13.92 </td>
        <td align="right">26.76 </td>
        <td align="right">10,780,052.41 </td>
        <td align="right">13.33 </td>
        <td align="right">18.61 </td>
      </tr>
      <tr onmouseout="listout(this)" onmouseover="listover(this)">
        <td height="22" align="right">　4</td>
        <td align="right">103,209 </td>
        <td align="right">-9.07 </td>
        <td align="right">4.62 </td>
        <td align="right">9,749,788.69 </td>
        <td align="right">-9.56 </td>
        <td align="right">3.24 </td>
      </tr>
      <tr onmouseout="listout(this)" onmouseover="listover(this)">
        <td height="22" align="right">　5</td>
        <td align="right">102,431 </td>
        <td align="right">-0.75 </td>
        <td align="right">16.46 </td>
        <td align="right">9,831,802.72 </td>
        <td align="right">0.84 </td>
        <td align="right">9.93 </td>
      </tr>
      <tr onmouseout="listout(this)" onmouseover="listover(this)">
        <td height="22" align="right">　6</td>
        <td align="right">109,656 </td>
        <td align="right">7.05 </td>
        <td align="right">4.67 </td>
        <td align="right">10,341,118.62 </td>
        <td align="right">5.18 </td>
        <td align="right">2.06 </td>
      </tr>
      <tr onmouseout="listout(this)" onmouseover="listover(this)">
        <td height="22" align="right">　7</td>
        <td align="right">98,010 </td>
        <td align="right">-10.62 </td>
        <td align="right">9.41 </td>
        <td align="right">9,464,303.75 </td>
        <td align="right">-8.48 </td>
        <td align="right">5.90 </td>
      </tr>
      <tr onmouseout="listout(this)" onmouseover="listover(this)">
        <td height="22" align="right">　8</td>
        <td align="right">109,548 </td>
        <td align="right">11.77 </td>
        <td align="right">65.03 </td>
        <td align="right">10,703,512.70 </td>
        <td align="right">13.09 </td>
        <td align="right">53.12 </td>
      </tr>
      <tr onmouseout="listout(this)" onmouseover="listover(this)">
        <td height="22" align="right">　9</td>
        <td align="right">127,200 </td>
        <td align="right">16.11 </td>
        <td align="right">27.50 </td>
        <td align="right">11,983,533.92 </td>
        <td align="right">11.96 </td>
        <td align="right">21.15 </td>
      </tr>
      <tr onmouseout="listout(this)" onmouseover="listover(this)">
        <td height="22" align="right">　10</td>
        <td align="right">109,351 </td>
        <td align="right">-14.03 </td>
        <td align="right">13.74 </td>
        <td align="right">10,315,728.24 </td>
        <td align="right">-13.92 </td>
        <td align="right">10.58 </td>
      </tr>
      <tr onmouseout="listout(this)" onmouseover="listover(this)">
        <td height="22" align="right">　11</td>
        <td align="right">124,689 </td>
        <td align="right">14.03 </td>
        <td align="right">30.40 </td>
        <td align="right">11,848,768.32 </td>
        <td align="right">14.86 </td>
        <td align="right">27.10 </td>
      </tr>
      <tr onmouseout="listout(this)" onmouseover="listover(this)">
        <td height="22" align="right">　12</td>
        <td align="right">128,304 </td>
        <td align="right">2.90 </td>
        <td align="right">25.89 </td>
        <td align="right">11,817,152.68 </td>
        <td align="right">-0.27 </td>
        <td align="right">25.89 </td>
      </tr>
      <tr onmouseout="listout(this)" onmouseover="listover(this)">
        <td height="22" align="right">合计</td>
        <td align="right">1,288,584 </td>
        <td align="right">51.20 </td>
        <td align="right">291.60 </td>
        <td align="right">122,228,896.14 </td>
        <td align="right">51.43 </td>
        <td align="right">238.27 </td>
      </tr>
      <tr onmouseout="listout(this)" onmouseover="listover(this)">
        <td height="22" align="right">月均</td>
        <td align="right">107,382 </td>
        <td align="right">4.27 </td>
        <td align="right">24.30 </td>
        <td align="right">10,185,741.35 </td>
        <td align="right">4.29 </td>
        <td align="right">19.86 </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="3"><font style="color:red;">注：以上数据只统计以“箱”为单位的销售情况</font></td>
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







