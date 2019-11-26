<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>欢迎回来</title>
<link type="text/css" rel="stylesheet" href="/resource/css/normalize.css" /> 
<link type="text/css" rel="stylesheet" href="/resource/css/demo.css"/> 
<link type="text/css" rel="stylesheet" href="/resource/css/component.css" />
</head>
<body>
<div class="container demo-1"> 
    <div class="content"> 
        <div id="large-header" class="large-header"> 
            <canvas id="demo-canvas"></canvas> 
            <div class="logo_box"> 
                <h3>欢迎登录</h3>
                <form action="/user/login" method="post" id="valiateform">
                	<p align="center" style="color: red">${errorMsg}</p>
                    <div class="input_outer"> 
                        <span class="u_user"></span> 
                        <input name="username" value="${user.username }" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户"> 
                    </div> 
                    <div class="input_outer"> 
                        <span class="us_uer"></span> 
                        <input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="${user.password}" type="password" placeholder="请输入密码"> 
                    </div>
                    <div class="mb2" style="margin-left: 130px;"><button type="submit" class="act-but submit" style="color: #FFFFFF">登录</button></div> 
                    <p class="w-100" align="right">
						如果没有有帐号，请<a style="color:#00FFFF" href="/user/register">点这里注册</a>
					</p>
                </form> 
            </div> 
        </div> 
    </div> 
</div>

<script type="text/javascript" src="/resource/js/aa/TweenLite.min.js"></script> 
<script type="text/javascript" src="/resource/js/aa/EasePack.min.js"></script> 
<script type="text/javascript" src="/resource/js/aa/rAF.js"></script> 
<script type="text/javascript" src="/resource/js/aa/demo-1.js"></script>
<script type="text/javascript">
		
		$(function() {
			$("#valiateform").validate({
				//校验规则
				rules : {
					username : {
						required : true,
					},
					password : {
						required : true,
					}
				},
				//不满足校验规则信息提示
				messages : {
					username : {
						required : "请输入用户名",
						
					},
					password: {
						required: "密码不能为空",
					},
				}

			})

		})
	</script>
</body>
</html>