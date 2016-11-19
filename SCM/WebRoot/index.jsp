<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/common.jspf" %>
<html>
<head>
</head>
<body>
	<form action="supplier/insert.do" method="post">
		供应商名字:<input type="text"	name="supName"/><br/><br/> 	
		联系人:<input type="text" name="supLinkman"/>
		<input type="submit" value="ok">
		<c:forEach items="${applicationScope.sysParamMap.supType }" var="stype">
			<option value="${stype.key }">${stype.key }+${stype.value }</option>
		</c:forEach>
	</form>
</body>
</html>
