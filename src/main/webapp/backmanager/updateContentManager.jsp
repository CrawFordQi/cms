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
<form action="updateContentManager.do" method="post" enctype="multipart/form-data">
 <div class="container text-center">
         <table class="table table-hover" id="table1" style="table-layout: fixed;">
	         <c:forEach var="user" begin="0" items="${list}">
	         <input type="hidden" name="id" value="${user.id }">
	         	 <c:if test="${user.image != ''}">
				     <div id="imgD"><img id="img" src="/upload/${user.image }" /><input type="button" value="删除" onclick="delImage()"/></div>
				     <div><input id="imgFile" type="file" name="textFile" style="display:none" /></div>
				</c:if>
				<c:if	test="${user.image == ''}">
					<input id="imgFile" type="file" name="textFile" />
				</c:if>
	    		<tr><td>新闻标题：<input type="text" id="title" name="title" value="${user.title }"/></td></tr>
	    		<tr><td>新闻内容：<TEXTAREA id="content" name="content" >${user.content }</textarea></td></tr>
	    	 	<tr><td><input type="submit" value="修改" ><a href="contentManager.do" >返回</a></td></tr>
	    	 </c:forEach>
         </table>
    </div>
</form>
</body>
<script type="text/javascript">

function delImage(){
	alert(1);
	$("#imgD").hide();
	$("#imgFile").css('display','block');
}

function updateContentManager(id){
	if ($("#title").val() == "") {
        alert("标题不能为空");
	}else if($("#content").val() == ""){
		 alert("内容不能为空");
	}else{
	$.ajax({
		type: "POST",
		url : "updateContentManager.do",
	   	data: {
	   			title: $("#title").val(),
	   			content:$("#content").val(),
	   			id:id,
          	  },
			success : function(r) {
				 window.location.href="contentManager.do";
		},
		error :function(){
			alert("网络链接错误，请稍后再试！");
		}
	});
}
}
</script>
</html>