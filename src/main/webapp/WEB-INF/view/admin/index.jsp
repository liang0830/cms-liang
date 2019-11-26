<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link href="/resource/bootstrap/css/bootstrap.css" rel="stylesheet">  
 <script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script> 
 <script type="text/javascript" src="/resource/bootstrap/js/bootstrap.js"></script>
    
<title>CMS管理平台</title>
</head>
<body style="background:#F0F8FF;">	
<nav class="navbar navbar-inverse" role="navigation" style="background:#F0F8FF;">
    	<%@include  file="../common/top110.jsp" %>
</nav>
<marquee>欢迎管理员 --${user.username }-- 登录,点击左侧列表进行操作</marquee>
<div class="row">
	<div class="col-md-2">
		<div style="margin-left:20px ">
			<ul class="nav nav-pills nav-stacked" id="menu">
			  <li class="active"><a href="javascript:showFuction($(this),'/admin/articles')">文章管理</a></li>
			  <li><a href="javascript:showFuction($(this),'/admin/users')">用户管理</a></li>
			  <li><a href="javascript:showFuction($(this),'/link/list')">友情链接管理</a></li>
			  <li><a href="#">轮播图管理</a></li>
			  <li><a href="#">公告管理</a></li>
			  <li><a href="#">投票管理</a></li>
			</ul>
		</div>
	</div>
	<div class="col-md-10"  style=" min-height:500px; border-left: solid">
		<div id="content">
			
		</div>
	</div>
</div>

<nav class="navbar navbar-inverse navbar-fixed-bottom"  style="background:#F0F8FF;">
	<div align="center"> <font color="#000000" size="5">CMS系统-管理界面</font> </div>
</nav>

<script type="text/javascript">
	function showFuction(obj,url){
		$("#content").load(url)
	}
</script>
</body>
</html>