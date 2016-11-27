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
		    idField:'supId',
		    pageSize:5,
		    pageList:[3,5,10,20],
		    toolbar: [{
				iconCls: 'icon-add',
				text : '新增',
				handler: function(){
					console.log("新增");
					parent.$("#win").window({
					    width:600,
					    height:400,
					    modal:true,
					    content:"<iframe src='${proPath}/base/insert.do' height='100%' width='100%' frameborder='0px' ></iframe>"
					});
				}
			},'-',{
				iconCls: 'icon-edit',
				text : "修改",
				handler: function(){
					console.log("修改");
					var arr = $("#dg").datagrid("getSelections");
					if(arr.length == 1){
						parent.$("#win").window({
						    width:600,
						    height:400,
						    modal:true,
						    content:"<iframe src='${proPath}/base/update.do' height='100%' width='100%' frameborder='0px' ></iframe>"
						});
					}else{
						alert("请选择行，并且只能选择一行");
					}
				}
			},'-',{
				iconCls: 'icon-remove',
				text : "删除",
				handler: function(){
					console.log("删除");
					var pk = new Array();
					var arr = $('#dg').datagrid("getChecked");
					var flag = false;
					if(arr.length>0){
						flag = true;
						for(var i=0;i<arr.length;i++){
							pk[i] = arr[i].supId;
						}
						console.log(pk);
						parent.$.messager.confirm('Confirm','你确定要删除该条记录吗？',function(r){
						    if (r){
						    	$.ajax({
						            type: "POST",
						            dataType: 'json',
						            traditional:true,
						            url: "${proPath}/supplier/deleteSupplier.do",
						            data: {pks : pk},
						            success: function (data) {
						                if(data.status>0){
						                	alert("删除成功");
						                	$('#dg').datagrid("load");
						                	$('#dg').datagrid("clearSelections");
						                }else{
						                	alert("请重新选择");
						                }
						            },
						            error: function (xhr, desc, err) {
						           		alert("删除错误，请联系管理员");
						            }
						        });
						    }
						});
					}else{
						alert("请选择要删除的记录！");
					}
					
					
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
				
				{
					field:'supType',
					title:'供应商类型',
					width:100,
					formatter: function(value,row,index){
						var str = "${applicationScope.sysParamMap.supType}";
						return valueToText(str,value);
					}
				},
				
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
