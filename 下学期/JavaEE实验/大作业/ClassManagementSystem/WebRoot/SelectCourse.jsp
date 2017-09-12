<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>选课</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
  
   var sno;
   var gno;
    function selectClick(node)
    {
    	var tr1 = node.parentNode.parentNode;
		sno=tr1.cells[1].innerText;
    	$("#course_table").html("");
    	var list;
		$.ajax({
			type : "POST",
			url : "courseAction",
			dataType : "text",

			//请求成功完成后要执行的方法  
			success : function(msg) {
				list = eval("(" + msg + ")");
				for ( var i = 0; i < list.length; i++) {
					var dom = list[i];
					
					if (dom != "" && dom != "null") {
						var style="success";
						if(i%2==0)
						{
							style="";
						}
						
						$("#course_table").append("<tr class='"+style+"'><td>"
										+ (i+1)
										+ "</td><td>" + dom.kno
										+ "</td><td>" + dom.kname
										+ "</td><td>" + dom.kproprety
										+ "</td><td>" + dom.kcredit 
										+ "</td><td><input name='course' type='checkbox' value='"+dom.kno+"'/>"
										+ "</td></tr>");
					}
				}
			},
			error : function(response) {
			}
		});
    }
  
  $(document).ready(function(){
  var courselist;
  $.ajax({
			type : "POST",
			url : "gradeAction",
			dataType : "text",

			//请求成功完成后要执行的方法  
			success : function(msg) {
				courselist = eval("(" + msg + ")");
			},
			error : function(response) {
			}
		});
  
  var stulist;
  $.ajax({
			type : "POST",
			url : "studentAction",
			dataType : "text",

			//请求成功完成后要执行的方法  
			success : function(msg) {
				stulist = eval("(" + msg + ")");
				for ( var i = 0; i < stulist.length; i++) {
					var dom = stulist[i];
					
					if (dom != "" && dom != "null") {
					  var exist=false;
					  for(var j=0;j<courselist.length;j++)
					  {
					  	if(dom.sno==courselist[j].sno)
					  	{
					  		exist=true;
					  	}
					  }
						var style="success";
						if(i%2==0)
						{
							style="";
						}
						var cname1 = dom.cno.substring(0,4);
						var cname2 = dom.cno.substring(4,6);
						var cname = "信"+cname1+"-"+cname2+"班";
					  if(!exist)
					  {
						$("#select_table").append("<tr class='"+style+"'><td>"
										+ (i+1) 
										+ "</td><td>" + dom.sno
										+ "</td><td>" + cname
										+ "</td><td>" + dom.sname
										+ "</td><td>"
										+ "<a href='#modal-container-123123' role='button' data-toggle='modal' onclick='selectClick(this)'>选课</a>"
										+ "</td><tr>");
					  }
					  else
					  {
					  	$("#selected_table").append("<tr class='"+style+"'><td>"
										+ (i+1) 
										+ "</td><td>" + dom.sno
										+ "</td><td>" + cname
										+ "</td><td>" + dom.sname
										+ "</td><tr>");
					  }
					 }
				}
			},
			error : function(response) {
			}
		});
		
		$("#savecourse").click(function(){
			$("input:checkbox").each(function(){
				if($(this).is(":checked"))
				{
					var kno = $(this).val();
					$.ajax({
						type : "POST",
						url : "operategrade",
						data:{"sno":sno,"kno":kno,"operateid":3},
						dataType : "text",

						//请求成功完成后要执行的方法  
						success : function(msg) {
							location.reload();
						},
						error : function(response) {
						}
					});
				}
			});
		});
    });
  </script>
  <body>
  
  	<div class="modal fade" id="modal-container-123123" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">选课信息</h4>
				</div>
				<div class="modal-body">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>序号</th>
								<th>课程号</th>
								<th>名称</th>
								<th>性质</th>
								<th>学分</th>
								<th></th>
							</tr>
						</thead>
						<tbody id="course_table">
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" id="savecourse" class="btn btn-primary" data-dismiss="modal">保存</button>
				</div>
			</div>
		</div>
	</div>
  	
  	<b>————————————未选课学生信息————————————</b>
  	<br><br>
    <table class="table table-hover">
		<thead>
			<tr>
				<th>序号</th>
				<th>学号</th>
				<th>所在班级</th>
				<th>姓名</th>
				<th>选课</th>
			</tr>
		</thead>
		<tbody id="select_table">
		</tbody>
	</table>
	<br>
	<br>
	<b>————————————已选课学生信息————————————</b>
	<br><br>
    <table class="table table-hover">
		<thead>
			<tr>
				<th>序号</th>
				<th>学号</th>
				<th>所在班级</th>
				<th>姓名</th>
			</tr>
		</thead>
		<tbody id="selected_table">
		</tbody>
	</table>
  </body>
</html>
