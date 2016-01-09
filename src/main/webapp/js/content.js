function query(){
    	$('#prev').addClass('hide');
		var i;
		var test='';
		var test1='';
		$.ajax({
			type: "POST",
			url : "content.do",
		   	data: {
                  pageNo: "1",
              	  },
            dataType:"html",
 			success : function(r) {
 				  var jsonobj=eval('('+r+')');
 	 				 $.each(jsonobj,function(i,n){
 	 					 $.each(n.countAll,function(i,n){
	 	 						alert(n.countAll); 
	 	 	 					 if(n.countAll.length<=5){
	 	  		                    $('#next').addClass('hide');
	 	  		                }
 	 					 });
 	 				
  		                $.each(n.data,function(i,n){
  		                        test+="<tr class='evenColor'><td>"+ n.title+"</td><td><a href='javascript:void(0)' onclick=lookContent("+n.id+")>查看详情</a></td></tr>";
  		                });
  		                test1="<tr><td><font size='4px'><B>新闻标题</B></font></td><td><font size='4px'><B>操作</B></font></td></tr>";
  		                $("#table1").html(test1+test);
 	 				 });
			},
			error :function(){
				alert("网络链接错误，请稍后再试！");
			}
		});
	}

function lookContent(id){
	var hs = document.getElementById("hs").value;
	if(hs.length > 0 || "" != hs.length){
	    $.ajax({
	        url: 'queryContentJsp.do',
	        data: {
	            id:id
	        },
	        dataType:"html",
	        type: "post",
	        success: function(){
	        	window.location.href="queryContent.do?id="+id;
	        },
	        error: function () {
	            alert("通讯失败了")
	        }
	    })
	   }else{
		   alert("会员用户才能查看详情！")
	   }
	}

$(function(){
    var i=1;
    var test='';
    var test1='';
    $("#prev").click(function () {  //上一页
        i--;//当前页 从2开始
        var test='';
        $.ajax({
            url: 'content.do',
            data: {
                pageNo:i,
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
		                        test+="<tr class='evenColor'><td>"+ n.title+"</td><td><a href='javascript:void(0)' onclick=lookContent("+n.id+")>查看详情</a></td></tr>";
		                });
		                test1="<tr><td><font size='4px'><B>新闻标题</B></font></td><td><font size='4px'><B>操作</B></font></td></tr>";
		                $("#table1").html(test1+test);
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
        $.ajax({
            url:'content.do',
            data:{
                pageNo:i,
            },
            dataType:"html",
            type:"post",
            success: function(r){
            	var jsonobj=eval('('+r+')');
 				 $.each(jsonobj,function(c,n){
	 	 					 if(5 * i > n.countAll){
	  		                    $('#next').addClass('hide');
	  		                }
		                $.each(n.data,function(i,n){
		                        test+="<tr class='evenColor'><td>"+ n.title+"</td><td><a href='javascript:void(0)' onclick=lookContent("+n.id+")>查看详情</a></td></tr>";
		                });
		                test1="<tr><td><font size='4px'><B>新闻标题</B></font></td><td><font size='4px'><B>操作</B></font></td></tr>";
		                $("#table1").html(test1+test);
 				 });
		},
            error : function() {alert("通讯失败了") }
        });
    });
});