<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/common.jspf"%>

<html>
  <head>
    <title>登录页面</title>
  </head>
  
  <body>
    <div id="myLogin">
    	<form id="ff" method="post" action="${proPath }/account/login.do">
		    <div>
				<label for="accLogin">用户名：</label>
				<input type="text" name="accLogin" id="accLogin"/>
		    </div><br/>
		    <div>
				<label for="accPass">密&nbsp;码：</label>
				<input type="password" name="accPass" />
		    </div><br/>
		 <div style="color: red">${requestScope.msg }</div>
		</form>
  </body>
  <script type="text/javascript">
  $('#myLogin').dialog({
      title: '登录界面',
      width: 400,
      height: 200,
      closed: false,
      cache: false,
      modal: true,
      buttons:[
	        {
				text:'登录',
				handler:function(){
					$("[name='accLogin']").validatebox({
					    required: true,
					    missingMessage:"请输入账号"
					});
					
					$("[name='accPass']").validatebox({
					    required: true,
					    missingMessage:"请输入密码"
					});
					
					if($("#ff").form("validate")){
						$("#ff").submit();
					}
				}
			},
			{
				text:'重置',
				handler:function(){}
			}
		]
  });
  </script>
</html>
