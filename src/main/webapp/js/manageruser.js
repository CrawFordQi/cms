/**
 * 查询所有用户
 */
function queryUser(e){
    	$('#prev').addClass('hide');
		var i;
		var test='';
		var test1='';
		var test2='';
		var mUser=e;
		if(mUser == null){
			mUser='';
		};
 		$.ajax({
			type: "POST",
			url : "queryUser.do",
		   	data: {
                  pageNo: "1",
                  type:0,
                  mUser:mUser,
              	  },
            dataType:"html",
 			success : function(r) {
 				  var jsonobj=eval('('+r+')');
 	 				 $.each(jsonobj,function(i,n){
	 	 	 					 if(n.countAll<=5){
	 	  		                    $('#next').addClass('hide');
	 	  		                }else{
	 	  		                	$('#next').removeClass('hide');
	 	  		                }
  		                $.each(n.data,function(i,c){
  		                        test+="<tr class='evenColor'><td>"+ c.username+"</td><td><a href='updateUser.do?id="+c.id+"'>修改</a><a href='javascript:void(0)' onclick=delUser("+c.id+")>删除</a></td></tr>";
  		                });
  		                test1="<tr><td><font size='4px'><B>用户名</B></font></td><td><font size='4px'><B>操作</B></font></td></tr>";
  		                $("#table1").html(test1+test);
  		                test2="<div style='text-align:center;width:100%'><input style='margin-left:34%' type='text' id='queryMUser' value='"+mUser+"' /><input type='submit' value='查询' onclick='queryMUser()'/></div>";
		                $("#table2").html(test2);
 	 				 });
			},
			error :function(){
				alert("网络链接错误，请稍后再试！");
			}
		});
	}

/**
 * 分页
 */
$(function(){
    var i=1;
    var test='';
    var test1='';
    $("#prev").click(function () {  //上一页
        i--;//当前页 从2开始
        var test='';
    	var mUser = document.getElementById("queryMUser").value;
        $.ajax({
            url: 'queryUser.do',
            data: {
                pageNo:i,
                type:0,
                mUser:mUser,
            },
            dataType:"html",
            type: "post",
            success: function(r){
            	var jsonobj=eval('('+r+')');
 				 $.each(jsonobj,function(c,n){
	 	 					 if(5 *i <= n.countAll){
	 	 						 $('#next').removeClass('hide');
	  		                }
	 	 					 if(i == 1){
	 	 						$('#prev').addClass('hide');
	 	 					 }
		                $.each(n.data,function(i,n){
		                        test+="<tr class='evenColor'><td>"+ n.username+"</td><td><a href='javascript:void(0)' onclick=updateUser("+n.id+")>修改</a><a href='javascript:void(0)' onclick=delUser("+n.id+")>删除</a></td></tr>";
		                });
  		                test1="<tr><td><font size='4px'><B>用户名</B></font></td><td><font size='4px'><B>操作</B></font></td></tr>";
		                $("#table1").html(test1+test);
  		                test2="<div style='text-align:center;width:100%'><input style='margin-left:34%' type='text' id='queryMUser' value='"+mUser+"' /><input type='submit' value='查询' onclick='queryMUser()'/></div>";
		                $("#table2").html(test2);
 				 });
		},
            error : function() {alert("通讯失败了") }
        })
    });
    $("#next").click(function(){   //下一页
        $('#prev').removeClass('hide');
        i++;//当前页 从1开始
        var test='';
        var test1='';
        var test2='';
    	var mUser = document.getElementById("queryMUser").value;
        $.ajax({
            url:'queryUser.do',
            data:{
                pageNo:i,
                type:0,
                mUser:mUser,
            },
            dataType:"html",
            type:"post",
            success: function(r){
            	var jsonobj=eval('('+r+')');
 				 $.each(jsonobj,function(c,n){
	 	 					 if(5 * i >= n.countAll){
	  		                    $('#next').addClass('hide');
	  		                }
		                $.each(n.data,function(i,n){
		                        test+="<tr class='evenColor'><td>"+ n.username+"</td><td><a href='javascript:void(0)' onclick=updateUser("+n.id+")>修改</a><a href='javascript:void(0)' onclick=delUser("+n.id+")>删除</a></td></tr>";
		                });
  		                test1="<tr><td><font size='4px'><B>用户名</B></font></td><td><font size='4px'><B>操作</B></font></td></tr>";
		                $("#table1").html(test1+test);
  		                test2="<div style='text-align:center;width:100%'><input style='margin-left:34%' type='text' id='queryMUser' value='"+mUser+"' /><input type='submit' value='查询' onclick='queryMUser()'/></div>";
		                $("#table2").html(test2);
 				 });
		},
            error : function() {alert("通讯失败了") }
        });
    });
});

/**
 * 删除用户
 */
function delUser(id){
	$.ajax({
		type: "POST",
		url : "delUser.do",
	   	data: {
              id: id,
              type:0,
          	  },
        dataType:"html",
			success : function(r) {
				window.location.href = "manager.do";
		},
		error :function(){
			alert("网络链接错误，请稍后再试！");
		}
	});
}

/**
 * 修改用户
 */
function updateUser(id){
	$.ajax({
		type: "POST",
		url : "updateUser.do",
	   	data: {
              id: id,
              type:0,
          	  },
        dataType:"html",
			success : function(r) {
				window.location.href="updateUser.do?id="+id;
		},
		error :function(){
			alert("网络链接错误，请稍后再试！");
		}
	});
}

/**
 * 模糊查询
 */
function queryMUser(){
	var mUser = document.getElementById("queryMUser").value;
	queryUser(mUser);
}