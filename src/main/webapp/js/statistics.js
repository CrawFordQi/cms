/**
 * 查询全部
 */
function selectAll(){
	var selectAll = document.getElementById('selectAll').value;
	    	$('#prev').addClass('hide');
			var i;
			var test='';
			var test1='';
			var test2='';
	 		$.ajax({
				type: "POST",
				url : "querySelectAll.do",
			   	data: {
	                  pageNo: "1",
	                  selectAll:selectAll,
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
	  		                        test+="<tr class='evenColor'><td>"+ c.title+"</td><td>"+ c.count+"</td></tr>";
	  		                });
	  		                test1="<tr><td><font size='4px'><B>新闻标题</B></font></td><td><font size='4px'><B>阅读数量</B></font></td></tr>";
	  		                $("#table1").html(test1+test);
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
	    	var selectAll = document.getElementById('selectAll').value;
	        $.ajax({
	            url: 'querySelectAll.do',
	            data: {
	                pageNo:i,
	                selectAll:selectAll,
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
  		                        test+="<tr class='evenColor'><td>"+ n.title+"</td><td>"+ n.count+"</td></tr>";
			                });
	  		                test1="<tr><td><font size='4px'><B>新闻标题</B></font></td><td><font size='4px'><B>阅读数量</B></font></td></tr>";
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
	        var test2='';
	    	var selectAll = document.getElementById('selectAll').value;
	        $.ajax({
	            url:'querySelectAll.do',
	            data:{
	                pageNo:i,
	                selectAll:selectAll,
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
	  		                test1="<tr><td><font size='4px'><B>新闻标题</B></font></td><td><font size='4px'><B>阅读数量</B></font></td></tr>";
	  		                $("#table1").html(test1+test);
	 				 });
			},
	            error : function() {alert("通讯失败了") }
	        });
	    });
	});


	/**
	 * 查询分类后
	 */
	function selectSingle(){
		var selectSingle = document.getElementById('selectSingle').value;
		var selectClasses = document.getElementById('selectClasses').value;
		    	$('#prev').addClass('hide');
				var i;
				var test='';
				var test1='';
				var test2='';
		 		$.ajax({
					type: "POST",
					url : "querySelectAll.do",
				   	data: {
		                  pageNo: "1",
		                  selectAll:selectSingle,
		                  selectClasses:selectClasses,
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
		  		                        test+="<tr class='evenColor'><td>"+ c.title+"</td><td>"+ c.count+"</td></tr>";
		  		                });
		  		                test1="<tr><td><font size='4px'><B>新闻标题</B></font></td><td><font size='4px'><B>阅读数量</B></font></td></tr>";
		  		                $("#table1").html(test1+test);
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
		    	var selectAll = document.getElementById('selectAll').value;
		        $.ajax({
		            url: 'querySelectAll.do',
		            data: {
		                pageNo:i,
		                selectAll:selectAll,
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
	  		                        test+="<tr class='evenColor'><td>"+ n.title+"</td><td>"+ n.count+"</td></tr>";
				                });
		  		                test1="<tr><td><font size='4px'><B>新闻标题</B></font></td><td><font size='4px'><B>阅读数量</B></font></td></tr>";
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
		        var test2='';
		    	var selectAll = document.getElementById('selectAll').value;
		        $.ajax({
		            url:'querySelectAll.do',
		            data:{
		                pageNo:i,
		                selectAll:selectAll,
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
		  		                test1="<tr><td><font size='4px'><B>新闻标题</B></font></td><td><font size='4px'><B>阅读数量</B></font></td></tr>";
		  		                $("#table1").html(test1+test);
		 				 });
				},
		            error : function() {alert("通讯失败了") }
		        });
		    });
		});

