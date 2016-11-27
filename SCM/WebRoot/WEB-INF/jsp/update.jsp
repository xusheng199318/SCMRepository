<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/common.jspf" %>
<html>
<head>
	<title>this is update jsp</title>
</head>
<body>
	<form id="ff" method="post">
	<div>
		<label for="supId">供应商编号1：</label>
		<input type="text" name="supId" readonly="readonly"/>
    </div>
    <div>
		<label for="supName">供应商名称：</label>
		<input type="text" name="supName" />
    </div>
    <div>
		<label for="supLinkman">联系人：</label>
		<input type="text" name="supLinkman" />
    </div>
    <div>
		<label for="supPhone">电话：</label>
		<input type="text" name="supPhone" />
    </div>
    <div>
		<label for="supAddress">地址：</label>
		<input type="text" name="supAddress" />
    </div>
    <div>
		<label for="supPay">期初应付：</label>
		<input type="text" name="supPay" />
    </div>
    <div>
		<label for="supType">供应商类型：</label>
		<select id="cc" name="supType" style="width:200px;">  
			<c:forEach items="${applicationScope.sysParamMap.supType }" var="stype">
				<option value="${stype.value }">${stype.value }</option>
			</c:forEach> 
		</select>
    </div>
    <div>
		<label for="supRemark">备注：</label>
		<input type="text" name="supRemark" />
    </div>
    <input type="button" id="btn" value="提交"/>
</form>
</body>
	<script type="text/javascript">
	$("[name='supId']").validatebox({
	    required: true,
	    missingMessage:"请输入供应商编号"
	});
	$("[name='supName']").validatebox({
	    required: true,
	    missingMessage:"请输入供应商名称"
	});
	$("[name='supName']").validatebox({
	    required: true,
	    missingMessage:"请输入供应商名称"
	});
	$("[name='supLinkman']").validatebox({
	    required: true,
	    missingMessage:"请输入联系人"
	});
	$("[name='supPhone']").validatebox({
	    required: true,
	    missingMessage:"请输入联系电话"
	});
	$("[name='supAddress']").validatebox({
	    required: true,
	    missingMessage:"请输入联系地址"
	});
	$("[name='supPay']").validatebox({
	    required: true,
	    missingMessage:"请输入期初应付"
	});
	$("[name='supType']").validatebox({
	    required: true,
	    missingMessage:"请输入供应商类型"
	});
	
	
	$("#ff").form('disableValidation');
	
	var win = parent.$("iframe[title='供应商管理']").get(0).contentWindow;
	var row = win.$('#dg').datagrid("getSelections");
	//row = eval('(' + row[0] + ')');
	console.log(row);
	$('#ff').form('load',{
		supId : row[0].supId,
		supName : row[0].supName,
		supLinkman : row[0].supLinkman,
		supPhone : row[0].supPhone,
		supAddress : row[0].supAddress,
		supRemark : row[0].supRemark,
		supPay : row[0].supPay,
		supType : row[0].supType
	}); 
	
	$("#btn").click(function(){
		$("#ff").form("enableValidation");
		if($("#ff").form("validate")){
			$("#ff").form('submit', {
			    url : '${proPath}/supplier/updateSupplier.do',
			    /* onSubmit: function(){
			    	return true;
			    }, */
			    success:function(data){
			    	var win = parent.$("iframe[title='供应商管理']").get(0).contentWindow;
			    	var data1 = eval('(' + data + ')');
			    	if(data1.status == 0){
			    		console.log(data1.msg);
			    		parent.$('#win').window('close');
			    		win.$('#dg').datagrid("reload");
			    	}else{
			    		alert(data1.msg);
			    	}
			    }
			});
		}
	});
	</script>
</html>
