<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻评论管理</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/manager.css">
<script type="text/javascript" src="js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="js/comment.js"></script>
<script type="text/javascript">
window.onload = function(){
	queryComment();
}
</script>
</head>
<body>
<!-- 头  --> 
<jsp:include  page="top.jsp"/>
<!-- 中间部分 -->
<div class="container text-center"><font size=4px><b>评论内容管理</b></font></div>
	<div>
		<table class="table table-hover" id="table2" ></table>
	</div>
    <div class="container text-center">
        <table class="table table-hover" id="table1"  style="table-layout: fixed;"></table>
    </div>
<!-- 分页 -->
	<div class="row">
		<ul class="pager">
		    <li><a href="#" id="prev">上一页</a></li>
		    <li><a href="#" id="next">下一页</a></li>
		</ul>
	</div>
</body>
</html>