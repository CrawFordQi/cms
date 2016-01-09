/**
 * 新闻查寻
 */
function contentManager(e){
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
			url : "queryContentManagerPage.do",
		   	data: {
                  pageNo: "1",
                  type:1,
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
  		                        test+="<tr class='evenColor'><td>"+ c.title+"</td><td><a href='javascript:void(0)' onclick=updateContentManager("+c.id+")>修改</a><a href='javascript:void(0)' onclick=delContentManager("+c.id+")>删除</a></td></tr>";
  		                });
  		                test1="<tr><td><font size='4px'><B>新闻标题</B></font></td><td><font size='4px'><B>操作</B></font></td></tr>";
  		                $("#table1").html(test1+test);
  		                test2="<div style='text-align:center;width:100%'><input style='margin-left:34%' type='text' id='queryMContent' value='"+mUser+"' /><input type='submit' value='查询' onclick='queryMContent()'/></div>";
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
    	var mUser = document.getElementById("queryMContent").value;
        $.ajax({
            url: 'queryContentManagerPage.do',
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
		                        test+="<tr class='evenColor'><td>"+ n.title+"</td><td><a href='javascript:void(0)' onclick=updateContentManager("+n.id+")>修改</a><a href='javascript:void(0)' onclick=delContentManager("+n.id+")>删除</a></td></tr>";
		                });
  		                test1="<tr><td><font size='4px'><B>新闻标题</B></font></td><td><font size='4px'><B>操作</B></font></td></tr>";
  		                $("#table1").html(test1+test);
  		                test2="<div style='text-align:center;width:100%'><input style='margin-left:34%' type='text' id='queryMContent' value='"+mUser+"' /><input type='submit' value='查询' onclick='queryMContent()'/></div>";
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
    	var mUser = document.getElementById("queryMContent").value;
        $.ajax({
            url:'queryContentManagerPage.do',
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
		                        test+="<tr class='evenColor'><td>"+ n.title+"</td><td><a href='javascript:void(0)' onclick=updateContentManager("+n.id+")>修改</a><a href='javascript:void(0)' onclick=delContentManager("+n.id+")>删除</a></td></tr>";
		                });
  		                test1="<tr><td><font size='4px'><B>新闻标题</B></font></td><td><font size='4px'><B>操作</B></font></td></tr>";
  		                $("#table1").html(test1+test);
  		                test2="<div style='text-align:center;width:100%'><input style='margin-left:34%' type='text' id='queryMContent' value='"+mUser+"' /><input type='submit' value='查询' onclick='queryMContent()'/></div>";
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
function delContentManager(id){
	$.ajax({
		type: "POST",
		url : "delContentManager.do",
	   	data: {
              id: id,
          	  },
        dataType:"html",
			success : function(r) {
				window.location.href = "contentManager.do";
		},
		error :function(){
			alert("网络链接错误，请稍后再试！");
		}
	});
}

/**
 * 修改用户
 */
function updateContentManager(id){
	window.location.href="updateContentManagerA.do?id="+id;
}

/**
 * 模糊查询
 */
function queryMContent(){
	var queryMContent = document.getElementById("queryMContent").value;
	contentManager(queryMContent);
}