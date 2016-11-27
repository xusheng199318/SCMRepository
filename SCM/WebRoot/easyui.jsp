<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <c:set var="proPath" value="${pageContext.request.contextPath }"/>
  
	<link rel="stylesheet" type="text/css" href="${proPath }/jquery-easyui-1.3.5/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${proPath }/jquery-easyui-1.3.5/themes/icon.css">
    <script type="text/javascript" src="${proPath }/jquery-easyui-1.3.5/jquery.min.js"></script>
    <script type="text/javascript" src="${proPath }/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
    
    <title>My JSP 'easyui.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript">
		$(function() {
			alert("Jquery可以使用了!");
		});
	</script>
  </head>
  
  <body>
    <div id="p" class="easyui-panel"
		style="width:500px;height:200px;padding:10px;" title="My Panel"
		iconCls="icon-save" collapsible="true">easyUI 可以使用</div>
		${proPath }
		
  </body>
</html>
