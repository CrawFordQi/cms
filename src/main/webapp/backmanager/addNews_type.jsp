<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻CMS系统修改</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/manager.css">
<script type="text/javascript" src="js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="js/manageruser.js"></script>
</head>
<body>

 <div class="container text-center">
         <table class="table table-hover" id="table1" style="table-layout: fixed;">
	    		<tr><td>新闻类型：<input type="text" id="username" name="username" /></td></tr>
	    	 	<tr><td><input type="submit" value="添加新闻类型" onclick="addNews_type()"><a href="manager.do" >返回</a></td></tr>
         </table>
    </div>
</body>
<script type="text/javascript">
function addNews_type(){
	if ($("#username").val() == "") {
        alert("用户名不能为空");
    }else{
	$.ajax({
		type: "POST",
		url : "addNews_type.do",
	   	data: {
              news_type_name: $("#username").val(),
           	  },
			success : function(r) {
				 alert("添加成功！");
				 window.location.href="news_type.do";
		},
		error :function(){
			alert("网络链接错误，请稍后再试！");
		}
	});
}
}
</script>
</html>