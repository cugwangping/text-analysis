<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>管理员管理界面</title>
  <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"></link>
  <link rel="stylesheet" href="<%=path %>/easyui/themes/color.css" type="text/css"></link>
  <link rel="stylesheet" href="<%=path %>/easyui/themes/default/easyui.css" type="text/css"></link>
  <link rel="stylesheet" href="<%=path %>/easyui/themes/icon.css" type="text/css"></link>
  <script type="text/javascript" src="<%=path %>/easyui/jquery.min.js"></script>
  <script type="text/javascript" src="<%=path %>/easyui/jquery.easyui.min.js"></script>
   <script type="text/javascript" src="<%=path %>/easyui/locale/easyui-lang-zh_CN.js"></script>
   <script type="text/javascript">
	   function addTab(opts) {
			var t = $('#tt');
			if (t.tabs('exists', opts.title)) {
				t.tabs('select', opts.title);
			} else {
				t.tabs('add', opts);
			}
		}
   
	   function deleteuser(){
		  addTab({  
			    title:'删除用户',  
			    href:'manager/user/userlist.jsp',
			    fit:true,
			    border:false,
			    closable:true  
			    
			});
		}
   			
	   function addbusiness(){
		    addTab({  
			    title:'添加酒店',   
				href:'manager/business/businessadd.jsp',
				fit:true,
				border:false,
				closable:true  
				    
				});
	   }
	   function deletebusiness(){
		    addTab({  
			    title:'删除酒店',   
				href:'manager/business/businesslist.jsp',
				fit:true,
				border:false,
				closable:true  
				    
				});
	   } 			
	   function findAllPost(){
		   addTab({  
			    title:'删除评论',  
				href:'manager/review/reviewlist.jsp', 
				fit:true,
				border:false,
				closable:true  
				    
				});
	   }
   </script>
<body class="easyui-layout">
	<div align="center" data-options="region:'north',border:false" style="height:100px;background:#B3DFDA;padding:10px">
		<h3>推荐系统后台管理</h3>
	</div>
	<div data-options="region:'west',split:true,title:'功能列表'" style="width:250px;">
		<div class="easyui-accordion" data-options="fit:true">
		
			<div title="用户版块" data-options="selected:true" style="padding:10px;">
				<ul style="list-style: none">
					<li><a href="javascript:void(0)" onclick="deleteuser()">删除用户</a></li>
				</ul>
			</div>
			<div title="酒店版块" style="padding:10px">
				<ul style="list-style: none">
					<li><a href="javascript:void(0)" onclick="addbusiness()">添加酒店</a></li>
				</ul>
				<ul style="list-style: none">
					<li><a href="javascript:void(0)" onclick="deletebusiness()">删除酒店</a></li>
				</ul>
			</div>
			<div title="评论版块" style="padding:10px">
				<ul style="list-style: none">
					<li><a href="javascript:void(0)" onclick="deletereview()">删除评论</a></li>
				</ul>
			</div>
		</div>
		
	</div>
	
	<div data-options="region:'south',border:false" style="height:50px;padding:10px;" align="center">
		Contact us:<br>
		中国地质大学（武汉） 信息工程学院  <br>
	
	</div>
	
	
	
	
	<div id="center"  data-options="region:'center',title:'数据区'" style="overflow: hidden;">
			 <div id="tt" class="easyui-tabs" fit="true"  border="false">
			 </div>
	</div> 
</body>
</html>