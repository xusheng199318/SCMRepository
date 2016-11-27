<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/common.jspf" %>
<html>
<head>
	<title>this is supplier jsp</title>
	<style type="text/css">
		.searchbox{
			margin:-3
		}
</style>
</head>
<body>
	<table id="dg"></table>
</body>
	<script type="text/javascript">
		$('#dg').datagrid({
		    url:'${proPath}/supplier/selectPage.do',
		    fitColumns:true,
		    pagination:true,
		    rownumbers:true,
		    singleSelect:true,
		    idField:'supId',
		    pageSize:5,
		    pageList:[3,5,10,20],
		    toolbar: [{
				iconCls: 'icon-ok',
				text : '选择供应商',
				handler: function(){
					console.log("新增");
					var rows = $("#dg").datagrid("getSelected");
					console.log(rows.supId);
					var win = parent.$("iframe[title='商品采购']").get(0).contentWindow;
					win.$("#ff").form('load',{
						supId:rows.supId,
						supName:rows.supName
					});
					parent.$("#win").window("close");
				}
			},'-',{
				text : "名称：<input id='supName' type='text' name='supName'/>"
			},'-',{
				text : "地址：<input id='supAddress' type='text' name='supAddress'>"
			}],
		    columns:[[
		        {checkbox:true},
				{field:'supId',title:'供应商编号',width:100},
				{field:'supName',title:'供应商名称',width:100},
				{field:'supLinkman',title:'联系人',width:100},
				{field:'supPhone',title:'电话',width:100},
				{field:'supAddress',title:'地址',width:100},
				{field:'supPay',title:'期初应付',width:100},
				{field:'supType',title:'供应商类型',width:100},
				{field:'supRemark',title:'备注',width:100,align:'right'}
		    ]]
		});
		
		//添加搜索框
		$('#supAddress').searchbox({
		    searcher:function(value,name){
		    	console.log($("#supName").val());
		    	console.log(value);
		    	$('#dg').datagrid('load',{
		    		supName : '%'+$("#supName").val()+'%',
		    		supAddress : '%'+value+'%'
		    	}); 
		    },
		    prompt:'请输入供应商地址'
		});
	</script>
</html>
