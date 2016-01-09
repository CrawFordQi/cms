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
<style>
#sub{width:100px;height:35px;line-height:35px;border:none;}
</style>
<body>
<input type="hidden" id="hs" value="${session }" />
<c:forEach var="session" begin="0" items="${session }">
	<input type="hidden" id="session" value="${session.id }" />
</c:forEach>
 	<div id="abc">
    <h2 class="text-center">新闻详细</h2><br><br>
    <div class="container text-center">
    <c:forEach var="content" begin="0" items="${list}">
    <input type="hidden" id="hid" value="${ content.id }" />
         		 <div>
                     <font size="5px">${ content.title }</font>
                     <div align="left">
                     	<font style="font-size: 1px;margin-left: 250px;color:#CDC0B0;">浏览人数：${ content.pplus }</font>
                     </div>
                     <hr color="blue" width="60%" style=""/>
         	     </div>
                 <div>
                 <c:if test="${content.image != null}">
				     <img src="/upload/${content.image }" /><br>
				</c:if>
         			${ content.content }
         	     </div>
         	      <hr color="blue" width="60%" style=""/>
         	 </c:forEach>
         	
		         	 <c:forEach var="comment" begin="0" items="${comment}">
							 <div align="left">	<font style="font-size: 3px;margin-left: 250px;color:#242424;font-weight:bold;">评论内容 ：</font>${comment.comment }</div>
		         	  </c:forEach>
    		 <div align="left"><font style="font-size: 3px;margin-left: 250px;color:#242424;font-weight:bold;">评&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp论 ：</font><textarea style="width:307px;height:80px;" id="comment" name="commetn"></textarea></div>
    		 <div>
    		 	<input type="submit" id="sub"  value="提交评论" onclick="comment()">
    		 </div>
     </div>
</div>
</body>
<script type="text/javascript">
function comment(){
	var id = document.getElementById("hid").value;
	var hs = document.getElementById("hs").value;
	var session = document.getElementById("session").value;
	if(hs.length > 0 || "" != hs.length){
		if ($("#comment").val() == "") {
	        alert("评论内容不能为空");
	    }else{
		$.ajax({
			type: "POST",
			url : "insertComment.do",
		   	data: {
		   	      id:id,
	              comment: $("#comment").val(),
	              user_id:session,
	          	  },
				success : function(data) {
				if(data == 1){
					window.location.href="content.jsp";
				}
				else{
					alert("评论失败，请稍候再试！");
				}
			},
			error :function(){
				alert("网络链接错误，请稍后再试！");
			}
		});
		}
	}else{
		alert("长时间未操作或已退出登录，请重新登录后评论！");
		window.location.href="login.do";
	}
}
</script>
</html>