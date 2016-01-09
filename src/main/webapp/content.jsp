<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻内容</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/aa.css">
<script type="text/javascript" src="js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="js/content.js"></script>
</head>
<script type="text/javascript">
	//页面加载时执行查询方法
	window.onload = function(){
		query();
	}
	function login1(){
		window.location="login.do";
	}
	function sign1(){
		window.location="sign.do";
	}
</script>
<body>
<form  action="">
<input type="hidden" id="hs" value="${session }" />
	<div id="abc">
    <div><h2 class="text-center">新闻列表</h2></div>
    <div align="right">
    	<a href='javascript:void(0)' onclick="login1()">登录</a>
		<a href='javascript:void(0)' onclick="sign1()">注册</a>
    </div><br><br>
    <div class="container text-center">
         <table class="table table-hover" id="table1" style="table-layout: fixed;"></table>
    </div>
    <div class="row">
        <ul class="pager">
            <li><a href="#" id="prev">上一页</a></li>
            <li><a href="#" id="next">下一页</a></li>
        </ul>
    </div>
 
</div>
</form>
</body>
</html>