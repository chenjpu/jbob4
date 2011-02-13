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
    <td colspan="3"><div align="center"><u class="STYLE1">客户等级分类销售状况</u></div></td>
  </tr>
  <tr>
    <td colspan="3"><div align="center">&nbsp;</div></td>
  </tr>
  <tr>
    <td colspan="3" style="border-top:solid 1px #0066CC;border-right:solid 1px #0066CC;">
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="listtab">
      <tr height="22">
        <td width="63" height="22" align="right">月份</td>
        <td width="93" align="right"><div align="center">A</div></td>
        <td width="93" align="right"><div align="center">B</div></td>
        <td width="93" align="right"><div align="center">C</div></td>
        <td width="105" align="right"><div align="center">D</div></td>
        <td width="98" align="right"><div align="center">T</div></td>
      </tr>
      <tr height="22">
        <td height="22" align="right">　1</td>
        <td align="right">2,156,148.25 </td>
        <td align="right">3,682,178.46 </td>
        <td align="right">36,110.64 </td>
        <td align="right">3,590.80 </td>
        <td align="right">3,609.60 </td>
      </tr>
      <tr height="22">
        <td height="22" align="right">　2</td>
        <td align="right">4,554,097.56 </td>
        <td align="right">4,840,969.88 </td>
        <td align="right">96,332.20 </td>
        <td align="right">11,273.10 </td>
        <td align="right">9,004.80 </td>
      </tr>
      <tr height="22">
        <td height="22" align="right">　3</td>
        <td align="right">5,774,120.92 </td>
        <td align="right">4,833,640.53 </td>
        <td align="right">99,046.96 </td>
        <td align="right">12,544.00 </td>
        <td align="right">58,000.00 </td>
      </tr>
      <tr height="22">
        <td height="22" align="right">　4</td>
        <td align="right">4,965,839.75 </td>
        <td align="right">4,667,516.34 </td>
        <td align="right">85,961.10 </td>
        <td align="right">2,571.50 </td>
        <td align="right">28,440.00 </td>
      </tr>
      <tr height="22">
        <td height="22" align="right">　5</td>
        <td align="right">5,234,800.68 </td>
        <td align="right">4,506,620.64 </td>
        <td align="right">77,775.90 </td>
        <td align="right">3,785.50 </td>
        <td align="right">0.00 </td>
      </tr>
      <tr height="22">
        <td height="22" align="right">　6</td>
        <td align="right">5,432,504.32 </td>
        <td align="right">4,791,932.60 </td>
        <td align="right">32,676.20 </td>
        <td align="right">2,495.40 </td>
        <td align="right">92,040.00 </td>
      </tr>
      <tr height="22">
        <td height="22" align="right">　7</td>
        <td align="right">4,550,342.13 </td>
        <td align="right">4,814,001.54 </td>
        <td align="right">74,680.00 </td>
        <td align="right">7,685.10 </td>
        <td align="right">6,912.00 </td>
      </tr>
      <tr height="22">
        <td height="22" align="right">　8</td>
        <td align="right">5,787,471.69 </td>
        <td align="right">4,830,179.22 </td>
        <td align="right">66,874.20 </td>
        <td align="right">4,905.00 </td>
        <td align="right">3,264.00 </td>
      </tr>
      <tr height="22">
        <td height="22" align="right">　9</td>
        <td align="right">6,217,403.38 </td>
        <td align="right">5,442,595.64 </td>
        <td align="right">57,164.40 </td>
        <td align="right">6,039.90 </td>
        <td align="right">162,955.00 </td>
      </tr>
      <tr height="22">
        <td height="22" align="right">　10</td>
        <td align="right">5,053,361.60 </td>
        <td align="right">4,862,111.60 </td>
        <td align="right">52,301.84 </td>
        <td align="right">1,725.00 </td>
        <td align="right">197,810.00 </td>
      </tr>
      <tr height="22">
        <td height="22" align="right">　11</td>
        <td align="right">6,205,389.87 </td>
        <td align="right">5,139,005.60 </td>
        <td align="right">47,514.00 </td>
        <td align="right">14,028.40 </td>
        <td align="right">291,392.05 </td>
      </tr>
      <tr height="22">
        <td height="22" align="right">　12</td>
        <td align="right">6,359,416.60 </td>
        <td align="right">5,252,377.48 </td>
        <td align="right">58,460.20 </td>
        <td align="right">3,065.60 </td>
        <td align="right">0.00 </td>
      </tr>
      <tr height="22">
        <td height="22" align="right">合计</td>
        <td align="right">62,290,896.75 </td>
        <td align="right">57,663,129.53 </td>
        <td align="right">784,897.64 </td>
        <td align="right">73,709.30 </td>
        <td align="right">853,427.45 </td>
      </tr>
      <tr height="22">
        <td height="22" align="right">月均</td>
        <td align="right">5,190,908.06 </td>
        <td align="right">4,805,260.79 </td>
        <td align="right">65,408.14 </td>
        <td align="right">6,142.44 </td>
        <td align="right">71,118.95 </td>
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







