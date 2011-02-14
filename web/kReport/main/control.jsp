<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title>kReport</title>
		<script language="JavaScript" type="text/JavaScript">
			function changeFrame(){
				if(document.getElementById("dividerImage").src.indexOf("toleft") != -1){
					document.getElementById("dividerImage").src="image/toright.jpg";
					window.parent.document.getElementById("mainFrame").cols = "0,11,*";
				}
				else{
					document.getElementById("dividerImage").src="image/toleft.jpg";
					window.parent.document.getElementById("mainFrame").cols = "163,11,*";
				}
			}
		</script>
		<style type="text/css">
		html,body{ margin:0px; font-size:12px; background:#ffffff; height:100% }
        </style>
	</head>
 
	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			style="height:100%" align="left">
			<tr >
				<td background="image/bg.jpg">
					<img id="dividerImage" src="image/toleft.jpg"
						onClick="changeFrame()" style="cursor:pointer;" />
				</td>
			</tr>
		</table>
	</body>
</html>
