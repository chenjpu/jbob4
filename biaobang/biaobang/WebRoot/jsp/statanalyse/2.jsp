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
    <td colspan="3"><div align="center"><u class="STYLE1">区域销售状况</u></div></td>
  </tr>
  <tr>
    <td colspan="3"><div align="center">&nbsp;</div></td>
  </tr>
  <tr>
    <td colspan="3" style="border-top:solid 1px #0066CC;border-right:solid 1px #0066CC;">
    <table cellspacing="0" cellpadding="0" width="100%" class="listtab">
      <tr height="22">
        <td width="63" height="22" align="right">月份</td>
        <td width="93" align="center">E东</td>
        <td width="93" align="center">G广州</td>
        <td width="93" align="center">N北</td>
        <td width="105" align="center">S南</td>
        <td width="98" align="center">T</td>
        <td width="94" align="center">W西</td>
      </tr>
      <tr height="22">
        <td height="22" align="right">　1</td>
        <td align="right">1,285,965.30 </td>
        <td align="right">2,306,203.70 </td>
        <td align="right">322,033.60 </td>
        <td align="right">1,506,315.60 </td>
        <td align="right">3,609.60 </td>
        <td align="right">457,509.95 </td>
      </tr>
      <tr height="22">
        <td height="22" align="right">　2</td>
        <td align="right">2,002,483.72 </td>
        <td align="right">3,315,620.34 </td>
        <td align="right">1,120,453.24 </td>
        <td align="right">1,954,741.84 </td>
        <td align="right">9,004.80 </td>
        <td align="right">1,109,373.60 </td>
      </tr>
      <tr height="22">
        <td height="22" align="right">　3</td>
        <td align="right">1,889,798.26 </td>
        <td align="right">3,200,898.51 </td>
        <td align="right">2,080,739.92 </td>
        <td align="right">2,035,389.82 </td>
        <td align="right">58,000.00 </td>
        <td align="right">1,512,525.90 </td>
      </tr>
      <tr height="22">
        <td height="22" align="right">　4</td>
        <td align="right">1,772,070.83 </td>
        <td align="right">3,237,477.90 </td>
        <td align="right">1,665,991.12 </td>
        <td align="right">1,825,719.84 </td>
        <td align="right">28,440.00 </td>
        <td align="right">1,220,629.00 </td>
      </tr>
      <tr height="22">
        <td height="22" align="right">　5</td>
        <td align="right">2,364,115.18 </td>
        <td align="right">2,993,008.00 </td>
        <td align="right">1,363,947.84 </td>
        <td align="right">1,861,109.50 </td>
        <td align="right">0.00 </td>
        <td align="right">1,240,802.20 </td>
      </tr>
      <tr height="22">
        <td height="22" align="right">　6</td>
        <td align="right">2,089,245.60 </td>
        <td align="right">3,107,802.20 </td>
        <td align="right">1,604,661.32 </td>
        <td align="right">1,952,198.40 </td>
        <td align="right">92,040.00 </td>
        <td align="right">1,505,701.00 </td>
      </tr>
      <tr height="22">
        <td height="22" align="right">　7</td>
        <td align="right">1,805,430.73 </td>
        <td align="right">3,235,054.00 </td>
        <td align="right">1,441,774.80 </td>
        <td align="right">2,052,034.84 </td>
        <td align="right">6,912.00 </td>
        <td align="right">912,414.40 </td>
      </tr>
      <tr height="22">
        <td height="22" align="right">　8</td>
        <td align="right">2,203,160.72 </td>
        <td align="right">3,103,812.50 </td>
        <td align="right">1,942,433.51 </td>
        <td align="right">2,122,860.98 </td>
        <td align="right">3,264.00 </td>
        <td align="right">1,314,434.20 </td>
      </tr>
      <tr height="22">
        <td height="22" align="right">　9</td>
        <td align="right">2,305,946.08 </td>
        <td align="right">3,188,138.30 </td>
        <td align="right">1,946,610.60 </td>
        <td align="right">2,697,821.34 </td>
        <td align="right">162,955.00 </td>
        <td align="right">1,657,774.60 </td>
      </tr>
      <tr height="22">
        <td height="22" align="right">　10</td>
        <td align="right">2,358,746.60 </td>
        <td align="right">3,275,719.20 </td>
        <td align="right">887,263.40 </td>
        <td align="right">2,040,690.64 </td>
        <td align="right">197,810.00 </td>
        <td align="right">1,533,898.40 </td>
      </tr>
      <tr height="22">
        <td height="22" align="right">　11</td>
        <td align="right">2,075,830.16 </td>
        <td align="right">3,037,617.40 </td>
        <td align="right">2,038,637.11 </td>
        <td align="right">2,584,530.00 </td>
        <td align="right">187,488.85 </td>
        <td align="right">1,924,148.80 </td>
      </tr>
      <tr height="22">
        <td height="22" align="right">　12</td>
        <td align="right">2,892,391.20 </td>
        <td align="right">3,145,212.14 </td>
        <td align="right">1,560,986.10 </td>
        <td align="right">2,581,659.84 </td>
        <td align="right">0.00 </td>
        <td align="right">1,584,998.80 </td>
      </tr>
      <tr height="22">
        <td height="22" align="right">合计</td>
        <td align="right">25,045,184.38 </td>
        <td align="right">37,146,564.19 </td>
        <td align="right">17,975,532.56 </td>
        <td align="right">25,215,072.64 </td>
        <td align="right">749,524.25 </td>
        <td align="right">15,974,210.85 </td>
      </tr>
      <tr height="22">
        <td height="22" align="right">月均</td>
        <td align="right">2,087,098.70 </td>
        <td align="right">3,095,547.02 </td>
        <td align="right">1,497,961.05 </td>
        <td align="right">2,101,256.05 </td>
        <td align="right">62,460.35 </td>
        <td align="right">1,331,184.24 </td>
      </tr>
    </table></td>
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







