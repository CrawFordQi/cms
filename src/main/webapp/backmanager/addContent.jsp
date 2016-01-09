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
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
</head>
<body>
<form id="contentB" action="addContentB.do" method="post" enctype="multipart/form-data">
 <div class="container text-center">
         <table class="table table-hover" id="table1" style="table-layout: fixed;">
	    		<tr><td>新闻标题：<input type="text" id="title" name="title" /></td></tr>
	    		<tr><td>新闻内容：<TEXTAREA NAME="content" id="content" style="margin: 0px; width: 180px; height: 45px;"></TEXTAREA></td></tr>
	    		<tr><td><input type="file" name="textFile"/></td></tr>
         </table>
         <SELECT id="select" name="news_type">
		    		 <c:forEach var="content" begin="0" items="${list}">
							<OPTION VALUE="${content.id }" >${content.news_type_name }</OPTION>
		    		 </c:forEach>
	    		 </SELECT>	
    </div>
    <input type="submit" value="添加新闻" ><a href="contentManager.do" >返回</a>
 </form>
</body>
<script type="text/javascript">
function addContentB(){
	alert($('#contentB').serialize());
	if ($("#title").val() == "") {
        alert("新闻标题不能为空");
    }else if ($("#content").val() == "") {
        alert("新闻内容不能为空");
    }else{
    	$.ajax({
            type: "POST",
            url:"addContentB.do",
            data:$('#contentB').serialize(),// 你的formid
            error: function(request) {
                alert("Connection error");
            },
            success: function(data) {
                $("#commonLayout_appcreshi").parent().html(data);
            }
        });
	}
}
</script>
</html>