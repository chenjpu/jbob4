<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="cn.blsoft.krport.engine.KReportContext" %>
<%@ page import="cn.blsoft.krport.po.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>kReport-Menu</title>
</head>
<style type="text/css">

.over{
	background:#99CCFF;cursor:hand;
}
.out{
	background:#FFFFFF;cursor:hand;
}
.hidden{
	display:none;
}
.menushow tbody{
	display:none;
}

body,html{
	height:100%; 
	font-family:arial,verdana,"宋体",; 
	font-size:14px;
	overflow:visible;
}

</style>
<script type="text/javascript">
function _clickMenuG(tbodyName){
	var tbody = document.getElementById(tbodyName);
	if(tbody.style.display=='none'){
		tbody.style.display='';
	}else{
		tbody.style.display='none';
	}
}
</script>
<body>
<table width="100%" >
 
       	<%
       	Map<String, KReportGroup> kreportGroups = KReportContext.kReports.getKreportGroups();
       	for(String ks:kreportGroups.keySet()){
       		KReportGroup kg=kreportGroups.get(ks);       	
       	%>
       	  <tr>
    <td>      
       	<table width="100%" cellspacing="0" >
          <thead>
              <tr onclick="_clickMenuG('G_<%=ks %>')" class="over">
                <th colspan="2" bgcolor="#0099CC"><%=kg.getDisplayName() %></th>
              </tr>
          </thead>
          <tbody id='G_<%=ks %>' style="display:none;">
          	  <%
          	  for(String key:kg.getKreports().keySet()) {
          	  %>
              <tr class=out onmouseover="className='over'" onmouseout="className='out'" onclick="parent.frames['workFrame'].location='<%=KReportContext.BASE+key%>.kReport'">
                <td width="5">&nbsp;</td>
                <td><img src="image/icon.jpg"/>&nbsp;<%=kg.getKreports().get(key).getDisplayName() %></td>
              </tr>
              <%
          	  }
              %>
            </tbody>
           </table>        
    </td>
  </tr>
        <%
       	}
        %>


  
</table>

</body>
</html>
