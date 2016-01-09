/**
 * 查询所有用户
 */
function queryComment(e){
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
			url : "queryComment.do",
		   	data: {
                  pageNo: "1",
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
  		                        test+="<tr class='evenColor'><td>"+ c.title+"</td><td>"+ c.comment+"</td><td>"+ c.username+"</td><td><a href='javascript:void(0)' onclick=delComment("+c.id+")>删除</a></td></tr>";
  		                });
  		                test1="<tr><td><font size='4px'><B>新闻标题</B></font></td><td><font size='4px'><B>评论内容</B></font></td><td><font size='4px'><B>评论用户</B></font></td><td><font size='4px'><B>操作</B></font></td></tr>";
  		                $("#table1").html(test1+test);
  		                test2="<div style='text-align:center;width:100%'><input style='margin-left:34%' type='text' id='queryMComment' value='"+mUser+"' /><input type='submit' value='查询' onclick='queryMComment()'/></div>";
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
    	var mUser = document.getElementById("queryMComment").value;
        $.ajax({
            url: 'queryComment.do',
            data: {
                pageNo:i,
                type:1,
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
		                        test+="<tr class='evenColor'><td>"+ n.title+"</td><td>"+ n.comment+"</td><td>"+ n.username+"</td><td><a href='javascript:void(0)' onclick=delUser("+n.id+")>删除</a></td></tr>";
		                });
  		                test1="<tr><td><font size='4px'><B>新闻标题</B></font></td><td><font size='4px'><B>评论内容</B></font></td><td><font size='4px'><B>评论用户</B></font></td><td><font size='4px'><B>操作</B></font></td></tr>";
		                $("#table1").html(test1+test);
  		                test2="<div style='text-align:center;width:100%'><input style='margin-left:34%' type='text' id='queryMComment' value='"+mUser+"' /><input type='submit' value='查询' onclick='queryMComment()'/></div>";
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
    	var mUser = document.getElementById("queryMComment").value;
        $.ajax({
            url:'queryComment.do',
            data:{
                pageNo:i,
                type:1,
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
		                        test+="<tr class='evenColor'><td>"+ n.title+"</td><td>"+ n.comment+"</td><td>"+ n.username+"</td><td><a href='javascript:void(0)' onclick=delUser("+n.id+")>删除</a></td></tr>";
		                });
  		                test1="<tr><td><font size='4px'><B>新闻标题</B></font></td><td><font size='4px'><B>评论内容</B></font></td><td><font size='4px'><B>评论用户</B></font></td><td><font size='4px'><B>操作</B></font></td></tr>";
		                $("#table1").html(test1+test);
  		                test2="<div style='text-align:center;width:100%'><input style='margin-left:34%' type='text' id='queryMComment' value='"+mUser+"' /><input type='submit' value='查询' onclick='queryMComment()'/></div>";
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
function delComment(id){
	$.ajax({
		type: "POST",
		url : "delComment.do",
	   	data: {
              id: id,
              type:1,
          	  },
        dataType:"html",
			success : function(r) {
				window.location.href = "comment.do";
		},
		error :function(){
			alert("网络链接错误，请稍后再试！");
		}
	});
}

/**
 * 修改用户
 */
function updateComment(id){
	$.ajax({
		type: "POST",
		url : "updateComment.do",
	   	data: {
              id: id,
              type:1,
          	  },
        dataType:"html",
			success : function(r) {
				window.location.href="updateComment.do"
		},
		error :function(){
			alert("网络链接错误，请稍后再试！");
		}
	});
}

/**
 * 模糊查询
 */
function queryMComment(){
	var mUser = document.getElementById("queryMComment").value;
	queryComment(mUser);
}