<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/common.jspf" %>
<html>
<head>
	<title>this is goods jsp</title>
	<style type="text/css">
		.searchbox{
			margin:-3
		}
</style>
</head>
<body>
	<form style="padding:15px;margin:0px;background:#eee;" id="ff" action="">
   请填写采购信息：<br/><br/>
 	供应商：<input type="hidden" id="supId" name="supId"/>
 	<input type="text" id="supName" name="supName"/>
 	仓库：<!-- <input type="text" id="shId" name="shId"> --> 
 		<select id="cc" class="easyui-combobox" name="shId" style="width:200px;">  
			<c:forEach items="${applicationScope.sysParamMap.shId }" var="shId">
				<option value="${shId.key }">${shId.value }</option>
			</c:forEach> 
		</select>
		
 	日期：<input  type="text" id="boDate"
				class="easyui-datebox" name="boDate" data-options="novalidate:true" required="required"></input>

    应付：<input type="text" id="boPayable" name="boPayable"/><br>
    已付：<input type="text" id="boPaid" name="boPaid"/>
 	欠款：<input type="text" id="boArrears" name="boArrears"/>
 	原始单号：<input type="text" id="boOriginal" name="boOriginal"/><br>
 	经手人：<input type="text" id="boAttn" name="boAttn"/>
 	操作员：<input type="text" id="boOperator" name="boOperator"/>
 	备注：<input type="text" id="boRemark" name="boRemark"/>
 </form>
	
	<table id="dg"></table>
</body>
	<script type="text/javascript">
		var editIndex = undefined;
		$('#dg').datagrid({
		    //url:'${proPath}/goods/selectGoods.do',
		    fitColumns:true,
		    rownumbers:true,
		    idField:'goodsId',
		    toolbar: [{
				iconCls: 'icon-add',
				text : '添加商品',
				handler: function(){
					console.log("新增");
					parent.$("#win").window({
						title:"请选择要添加的商品",
					    width:600,
					    height:400,
					    modal:true,
					    content:"<iframe src='${proPath}/base/product.do' height='100%' width='100%' frameborder='0px' ></iframe>"
					});
				}
			},'-',{
				iconCls: 'icon-remove',
				text : "删除商品",
				handler: function(){
					console.log("删除");
					var rows = $("#dg").datagrid("getSelections");
					
					if(rows.length>0){
						for(var i=rows.length-1;i>=0;i--){
							var index = $("#dg").datagrid("getRowIndex",rows[i]);
							console.log(index);
							$("#dg").datagrid("deleteRow",index);
						}
					}else{
						alert("请选中至少一行");
					}
				}
			},'-',{
				iconCls: 'icon-ok',
				text : "提交商品",
				handler: function(){
					$("#ff").form("enableValidation");
					console.log("修改");
					var flag = $("#ff").form("validate");
					console.log(flag);
					var rows = $("#dg").datagrid("getRows");
					console.log(rows);
					rows = JSON.stringify(rows);
					console.log(rows);
					$("#ff").form('submit',{
					    url:"${proPath}/buyOrder/insertOrder.do",
					    onSubmit : function(param){
					    	param.rows = rows;
							return true;
					    }, 
					    success:function(data){
					    	var result = eval('(' + data + ')');
							alert(result.msg);
					    }
					});
					
				}
			}],
		    columns:[[
		        {checkbox:true},
				{field:'goodsId',title:'商品编号',width:100},
				{field:'goodsName',title:'商品名称',width:100},
				{field:'goodsUnit',title:'单位',width:100},
				{field:'goodsType',title:'型号',width:100},
				{field:'goodsColor',title:'颜色',width:100},
				{field:'bodAmount',title:'数量',width:100,editor:"numberbox"},
				{field:'bodBuyPrice',title:'进价',width:100,editor:{type:"numberbox",options:{precision:2}}},
				{field:'bodTotalPricent',title:'合计',width:100,editor:{type:"numberbox",options:{precision:2}}},
				{field:'bodImeiListr',title:'串号列表',width:100,align:'right',editor:"textarea"}
		    ]],
		    onDblClickCell: function(index,field,value){
				console.log(index+","+value);
				//判断是否有被选中的行，如果有，就关闭编辑
				if(editIndex != undefined){
					$(this).datagrid("endEdit",editIndex);
					editIndex = undefined;
				}
				
				$(this).datagrid("beginEdit",index);
				editIndex = index;
			},
			onClickCell : function(index,field,value){
				if(editIndex != undefined){
					var amount = $(this).datagrid("getEditor",{index:editIndex,field:"bodAmount"});
					var buyPrice = $(this).datagrid("getEditor",{index:editIndex,field:"bodBuyPrice"});
					var bodTotalPricent = $(amount.target).numberbox("getValue")*$(buyPrice.target).numberbox("getValue")
					
					var buyPrice = $(this).datagrid("getEditor",{index:editIndex,field:"bodTotalPricent"});
					$(buyPrice.target).numberbox("setValue",bodTotalPricent);
					
					$(this).datagrid("endEdit",editIndex);
					editIndex = undefined;
					
					
				}
			}
		});
		
		$('#supName').searchbox({
		    searcher:function(value,name){
		    	console.log($("#supName").val());
		    	console.log(value);
		    	parent.$("#win").window({
		    		 title:"请选择供应商",
		    		 width:1000,
		    		 height:600,
		    		 modal:true,
		    		 content:"<iframe src='${proPath}/base/selectSupplier.do' height='100%' width='100%' frameborder='0px'></iframe>"
		    	});
		    	/* $('#dg').datagrid('load',{
		    		supName : '%'+$("#supName").val()+'%',
		    		supAddress : '%'+value+'%'
		    	}); */ 
		    },
		    prompt:'请输入供应商地址'
		});
		
	</script>
</html>
