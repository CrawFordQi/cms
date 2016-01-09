<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-2.1.0.min.js"></script>
</head>
<script type="text/javascript">
	function login(){
		var form = document.forms[0];
		form.action="registered.do";
		form.method="post";
		form.submit();
	}
	function registered(){
		if ($("#username").val() == "") {
            alert("用户名不能为空");
        }
        else if ($("#password").val() == "") {
            alert("密码不能为空");
        }else{
		$.ajax({
			type: "POST",
			url : "registered.do",
		   	data: {
                  username: $("#username").val(),
                  password: $("#password").val(),
              	  },
 			success : function(data) {
				if(data == 1){
					window.location.href="content.jsp";
				}
				else{
					alert("登录失败,请输入正确的帐号和密码！");
				}
			},
			error :function(){
				alert("网络链接错误，请稍后再试！");
			}
		});
	}
}
</script>
<body>
<div class="container" style="padding-top:150px">
    <div class="col-md-4 col-sm-4 col-xs-4" >
    </div>
    <div class="row">
        <div class="col-md-4 col-sm-4 col-xs-11">
            <div class="panel panel-default">
                <div class=panel-heading>
                    <h3 class=text-center>CMS系统注册</h3>
                </div>
                <div class=panel-body>
                    <div class="row">
                        <div class="col-md-3 col-md-offset-1">
                            <td>用&nbsp&nbsp户&nbsp&nbsp名：</td>
                        </div>
                        <div class="col-md-3">
                            <input  name="username" id="username" type="text">
                        </div>
                    </div><br>
                    <div class="row">
                        <div class="col-md-3 col-md-offset-1">
                            <td>密&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp码：</td>
                        </div>
                        <div class="col-md-3">
                            <input  name="password" id="password" type="password" onkeyup="value=value.replace(/[^\w=@#]|_/ig,'')">
                        </div>
                    </div><br>
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2">
                            <input type="submit" value="注册" class="btn btn-primary btn-lg btn-block" onclick="registered()"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>