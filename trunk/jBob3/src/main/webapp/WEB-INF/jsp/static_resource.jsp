<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- my97日期控件 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js" charset="utf-8"></script>
<!-- easyui控件 -->
<link id="easyuiTheme" rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery-easyui/themes/<c:out value="${cookie.easyuiThemeName.value}" default="default"/>/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery-easyui/themes/icon.css" type="text/css"></link>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<!-- easyui portal插件 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery-easyui-portal/portal.css" type="text/css"></link>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui-portal/jquery.portal.js" charset="utf-8"></script>
<!-- cookie插件 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.cookie.js" charset="utf-8"></script>
<!-- xhEditor插件库 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/xheditor-1.1.14/xheditor-1.1.14-zh-cn.min.js" charset="utf-8"></script>
<!-- 自己定义的样式和JS扩展 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/style/jbob.css" type="text/css"></link>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/syUtil.js" charset="utf-8"></script>