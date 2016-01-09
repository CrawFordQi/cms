<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>统计模块</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/manager.css">
<script type="text/javascript" src="js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="js/statistics.js"></script>
</head>
<script type="text/javascript">
window.onload = function(){
	selectAll();
}
</script>
<body>
<!-- 头  --> 
 <jsp:include  page="top.jsp"/>
<!-- 中间部分 -->
<div class="container text-center"><font size=4px><b>统计模块</b></font></div>
	<div class="container text-center">
		<SELECT id="selectAll">
				<OPTION VALUE="1" >一周内</OPTION>
				<OPTION VALUE="2" >一个月内</OPTION>
				<OPTION VALUE="3" >三个月内</OPTION>
	    </SELECT>
		全部新闻的访问量
		<input type="submit" onclick="selectAll()"  value="查询"/>
	</div>
	<div class="container text-center">
		<SELECT id="selectSingle">
					<OPTION VALUE="1" >一周内</OPTION>
					<OPTION VALUE="2" >一个月内</OPTION>
					<OPTION VALUE="3" >三个月内</OPTION>
		    </SELECT>
			<SELECT id="selectClasses">
			    		 <c:forEach var="content" begin="0" items="${list}">
								<OPTION VALUE="${content.id }" >${content.news_type_name }</OPTION>
			    		 </c:forEach>
		    		 </SELECT>
			    新闻的访问量
			<input type="submit" onclick="selectSingle()" value="查询"/>
	</div>
	<div class="container text-center">
		<font style="color:red;size:1px">*默认查询一周内全部新闻访问量</font>
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