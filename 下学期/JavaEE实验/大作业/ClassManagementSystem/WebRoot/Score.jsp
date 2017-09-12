<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>分数管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  <style>
  .score{background-color:transparent;width:40px;color:#FF0000;}
  #dafen{font-size:16px;font-weight:900;margin-left:-10px;}
  </style>
    <script type="text/javascript">
	$(document).ready(function(){

	var list;
	$.ajax({
			type : "POST",
			url : "gradeAction",
			dataType : "text",

			//请求成功完成后要执行的方法  
			success : function(msg) {
				list = eval("(" + msg + ")");
				var j=0;
				var k=0;
				for ( var i = 0; i < list.length; i++) {
					var dom = list[i];
					
					if (dom != "" && dom != "null") {
						var style="success";
						if(i%2==0)
						{
							style="";
						}
						if(dom.score==0)
						{
							$("#score_table1").append("<tr class='"+style+"'><td>"
										+ (++j)
										+ "</td><td>" + dom.gno 
										+ "</td><td>" + dom.sno
										+ "</td><td>" + dom.kno
										+ "</td><td>" + "<input type='text' name='score' id='"+dom.gno+"' class='score' value='"+dom.score+"' disabled/>"
										+ "</td></tr>");
						}
						else
						{
							$("#score_table2").append("<tr class='"+style+"'><td>"
										+ (++k)
										+ "</td><td>" + dom.gno 
										+ "</td><td>" + dom.sno
										+ "</td><td>" + dom.kno
										+ "</td><td>" + "<lable id='"+dom.gno+"'>"+dom.score+"</label>"
										+ "</td><td>"
										+ "</td></tr>");
										
							if(dom.score<60)
							{
								$("#"+dom.gno).css("color","red");
							}
						}
					}
				}
			},
			error : function(response) {
			}
		});	
		
		$("#editbtn").click(function(){
			$(".score").attr("disabled",false);
			$("input[type='text']").each(function () {
                    if($(this).val()=="0")
                    {
                    	$(this).focus();
                    	$(this).css("color","#000");
                    	$(this).select();
                    	return false;
                    }
            });
			$(".score").change(function(){
  				$(this).css("color","#000");
  				$(this).attr("disabled",true);
  				var gno=$(this).attr("id");
  				var score = $(this).val();
  				$.ajax({
					type : "POST",
					url : "operategrade",
					data : {"gno":gno,"score":score,"operateid":1},
					dataType : "text",
					
					success : function(msg) {
						showMsg("打分成功","center");
						setTimeout("location.reload();",1500);
					},
					error : function() {
					}
				});
			});
			$(".score").focus(function ()
			{
				$(this).select();
				$(this).css("color","#000");
			});
		});
	});
	
</script>
  <body>
  	<b>————————————未打分————————————</b>
  	<br>
  	<a href='javascript:void(0)' id="editbtn" role="button" class="btn">打分</a>
	<br>
  	<table class="table table-hover">
		<thead>
			<tr>
				<th>序号</th>
				<th>编号</th>
				<th>姓名</th>
				<th>所选课程</th>
				<th>分数</th>
			</tr>
		</thead>
		<tbody id="score_table1">
		</tbody>
	</table>
	<br>
	<br>
	<b>————————————以打分————————————</b>
	<br><br>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>序号</th>
				<th>编号</th>
				<th>姓名</th>
				<th>所选课程</th>
				<th>分数</th>
			</tr>
		</thead>
		<tbody id="score_table2">
		</tbody>
	</table>
  </body>
</html>
