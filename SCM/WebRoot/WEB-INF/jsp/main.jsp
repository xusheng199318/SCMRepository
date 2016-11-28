<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/common.jspf" %>
<html>
<head>
	<title>this is main jsp</title>
</head>
<body class="easyui-layout">
	
	<!-- 头部 -->
    <div data-options="region:'north',title:'欢迎使用进销存管理系统',split:true" style="height:100px;">
    	欢迎您：${sessionScope.account.accLogin }
    </div>
    
    <!-- 导航菜单 -->
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:200px;">
    	<div id="aa" class="easyui-accordion" style="width:300px;height:200px;">
		    
		    <div title="基础数据录入">
				<ul style="list-style: none;padding: 0px;margin: 0px;">
					<li style="padding: 6px;">
						<a href="${proPath }/base/supplier.do" style="text-decoration: none;display: block; font-weight: bold;" title="供应商管理">供应商管理</a>
					</li>
					<li style="padding: 6px;">
						<a href="${proPath }/base/product.do" style="text-decoration: none;display: block; font-weight: bold;" title="商品管理">商品管理</a>
					</li>
				</ul>
		    </div>
		    
		    <div title="采购管理">
				<ul style="list-style: none;padding: 0px;margin: 0px;">
					<li style="padding: 6px;">
						<a href="${proPath }/base/buyGoods.do" style="text-decoration: none;display: block; font-weight: bold;" title="商品采购">商品采购</a>
					</li>
					<li style="padding: 6px;">
						<a href="${proPath }/base/returnGoods.do" style="text-decoration: none;display: block; font-weight: bold;" title="商品退货">商品退货</a>
					</li>
				</ul>
    		</div>
    		
    		<div title="报表查询">
				<ul style="list-style: none;padding: 0px;margin: 0px;">
					<li style="padding: 6px;">
						<a href="${proPath }/base/report.do" style="text-decoration: none;display: block; font-weight: bold;" title="供应商采购额统计">供应商采购额统计</a>
					</li>
				</ul>
    		</div>
    		
		</div>
    </div>
    
    <!-- 主体内容 -->
    <div data-options="region:'center',title:'主体内容'" style="padding:5px;background:#eee;">
   		<div id="tt"  style="width:500px;height:250px;">
		    <div title="系统介绍" style="padding:20px;display:none;">
				系统介绍
		    </div>
		</div>
    </div>
    
    <div id="win"></div>
    
    <script type="text/javascript">
  		$("#tt").tabs({
			border:false,
			fit:true
		});
  	</script>
  
  	<script type="text/javascript">
	  	$(function(){
	  		$("a[title]").click(function(){
	  			var title = this.title;
	  			var text = this.href;
		  		if($("#tt").tabs("exists",title)){
		  			console.log("面板已经存在");
		  			$("#tt").tabs("select",title);
		  		}else{
		  			$("#tt").tabs('add',{
			  			title: this.title,
			  			closable:true,
			  			content:"<iframe src='"+text+"' title='"+title+"' height='100%' width='100%' frameborder='0px' ></iframe>"
			  		});
		  		}
		  		return false;
	  		});
	  	});
	 </script>

</body>
</html>
