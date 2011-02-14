<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>kReport</title>
</head>


<frameset id="frame" rows="91,*,22" cols="*" frameborder="no" border="0" framespacing="0" onunload="deregisterUser()">
  <frame src="${base}/kReport/main/top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame"/>
  <frameset cols="163,11,*" id="mainFrame" frameborder="no" border="0" framespacing="0">
  	  <frame src="${base}/kReport/main/menu.jsp" name="leftFrame" scrolling="no" noresize="noresize" id="leftFrame"/>
	  <frame src="${base}/kReport/main/control.jsp" name="middleFrame" scrolling="no" noresize>
	  <frame src="" name="workFrame" id="workFrame"/>
  </frameset>
  <frame src="${base}/kReport/main/bottom.jsp" name="bottomFrame" scrolling="No" noresize="noresize" id="bottomFrame"/>
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>
