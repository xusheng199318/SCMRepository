<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/common.jspf" %>
<html>
<head>
	<title>this is product jsp</title>
	<style type="text/css">
		.searchbox{
			margin: -5
		}
	</style>
</head>
<body>
	<table id="dg"></table>
	<form  style="padding:5px;margin:0px;background:#eee;"  action="">
		采购数量：<input type="text" id='bodAmount' name='bodAmount' class="easyui-numberbox"  data-options="min:1,max:1000000000">
		价格：<input type="text" id='bodBuyPrice' name='bodBuyPrice' class="easyui-numberbox"   data-options="min:0,precision:2">
		手机串号：<textarea  id='bodImeiList' name='bodImeiList'></textarea>
	</form>
</body>
	<script type="text/javascript">
		$('#dg').datagrid({
		    url:'${proPath}/goods/selectGoods.do',
		    singleSelect:true,
		    fitColumns:true,
		    pagination:true,
		    rownumbers:true,
		    pageSize:5,
		    pageList:[3,5,10,20],
		    toolbar: [{
				iconCls: 'icon-save',
				text : '保存',
				handler: function(){
					var win = parent.$("iframe[title='商品采购']").get(0).contentWindow;
					var rows = $("#dg").datagrid("getSelected");
					win.$("#dg").datagrid('appendRow',{
						goodsId: rows.goodsId,
						goodsName: rows.goodsName,
						goodsUnit: rows.goodsUnit,
						goodsType: rows.goodsType,
						goodsColor: rows.goodsColor,
						bodAmount: $("#bodAmount").val(),
						bodBuyPrice: $("#bodBuyPrice").val(),
						bodTotalPrice: $("#bodAmount").val()*$("#bodBuyPrice").val(),
						bodImeiListr: $("#bodImeiListr").val()
					});
					parent.$("#win").window('close');
				}
			},'-',{
				text : "<input id='ss' type='text' name='keyword'/>"
			}],
		    columns:[[
		        {checkbox:true},
				{field:'goodsId',title:'产品编号',width:100},
				{field:'goodsName',title:'产品名称',width:100},
				{field:'goodsUnit',title:'单位',width:100},
				{field:'goodsType',title:'型号',width:100},
				{field:'goodsColor',title:'颜色',width:100,align:'right'}
		    ]] 
		});
		
		//添加搜索框
		$('#ss').searchbox({
		    searcher:function(value,name){
		    	console.log(value + "," + name);
		    	$('#dg').datagrid('load',{
		    		goodsName : '%'+value+'%'
		    	}); 
		    },
		    prompt:'请输入商品名称'
		});
	</script>
</html>
