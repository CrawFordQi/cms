<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统用户管理</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/manager.css">
<script type="text/javascript" src="js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="js/manageradmin.js"></script>
<script type="text/javascript">
window.onload = function(){
	queryAdmin();
}
</script>
</head>
<body>
<!-- 头  --> 
	<jsp:include  page="top.jsp"/>
<!-- 中间部分 -->
<shiro:hasRole name="admin">
	用户[<shiro:principal/>]拥有角色admin<br/>
</shiro:hasRole>
<div class="container text-center"><font size=4px><b>系统用户管理</b></font></div>
	<div>
		<table class="table table-hover" id="table2" ></table>
	</div>
    <div class="container text-center">
        <table class="table table-hover" id="table1"  style="table-layout: fixed;"></table>
    </div>
      <div class="container text-right">
        <input style='margin-right: 22%;background-color:#00A2CA;' type="submit" value="添加用户"  onclick="addAdmin()"/>
    </div>
<!-- 分页 -->
	<div class="row">
		<ul class="pager">
		    <li><a href="#" id="prev">上一页</a></li>
		    <li><a href="#" id="next">下一页</a></li>
		</ul>
	</div>
</body>
<script type="text/javascript">
function addAdmin(){
	 window.location.href="addAdminA.do";
}
</script>
</html>