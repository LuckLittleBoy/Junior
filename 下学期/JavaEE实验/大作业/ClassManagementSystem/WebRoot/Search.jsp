<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>综合查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <style>
  select{width:120px;}
  </style>
  <script type="text/javascript">

 var list;
 function searchBySno(text)
 {
 	$.ajax({
			type : "POST",
			url : "operategrade",
			data : {"sno":text,"operateid":2},
			dataType : "text",
					
			success : function(msg) {
				list = eval("(" + msg + ")");
				test();		
			},
			error : function() {
			}
	});
 }
 
 function test()
 {
 	var listcourse;
 	var credit=0;
 	var k=0;
	for ( var i = 0; i < list.length; i++) {
		var dom = list[i];
		var kno = dom.kno;
		
		$.ajax({
			async:false,
			type : "POST",
			url : "operatecourse",
			data : {
				"kno" : kno,
				"operateid" : 2
			},
			dataType : "text",

			success : function(msg) {
				listcourse = eval("(" + msg + ")");
				var style="success";
				if(k%2==0)
				{
					style="";
				}
				$("#search_table").append("<tr id='"+listcourse[0].kno+"' class='"+style+"'><td>"
				+ (++k) 
				+ "</td><td>" + listcourse[0].kno
				+ "</td><td>" + listcourse[0].kname
				+ "</td><td>" + listcourse[0].kproprety
				+ "</td><td>" + listcourse[0].kcredit
				+ "</td><td>" + list[k-1].score
				+ "</td></tr>");
				
				if(list[k-1].score<60)
				{
					$("#"+listcourse[0].kno).css("color","red");
				}
				else
				{
					credit=credit+listcourse[0].kcredit;
					$("#credit").text(credit);	
				}
			},
			error : function() {
			}
		});
	}
 } 
 $(document).ready(function(){
  	
  	var allcourse;
  	$.ajax({
		async:false,
		type : "POST",
		url : "courseAction",
		dataType : "text",

		success : function(msg) {
			allcourse = eval("(" + msg + ")");
			for ( var i = 0; i < allcourse.length; i++) {
				var dom = allcourse[i];
				if (dom != "" && dom != "null") {
					var style="success";
					if(i%2==0)
					{
						style="";
					}
					var arr=new Array();
					var num=0;
					for(var j=0;j<dom.grades.length;j++)
					{
						if(dom.grades[j].score>0)
						{
							arr[num]=dom.grades[j].score;
							num++;
						}
					}
					arr.sort();
					var avg=0;
					var sum=0;
					for(var k=0;k<arr.length;k++)
					{
					   sum+=arr[k];
					}
					
					avg=(sum/arr.length).toFixed(2);
					$("#course_table").append("<tr class='"+style+"'><td>"
									+ (i+1) 
									+ "</td><td>" + dom.kname
									+ "</td><td>" + arr[num-1]
									+ "</td><td>" + arr[0]
									+ "</td><td>" + avg
									+ "</td></tr>");
				}
			}
		},
		error : function(e) {
		}
	});
  	
  	$("#searchbtn").click(function(){
  		$("#search_thead").text("");
  		$("#search_thead").append("<tr><th>序号</th><th>课程编号</th><th>课程名称"
  			+"</th><th>性质</th><th>学分</th><th>分数</th></tr>");
  		$("#search_table").text("");
  		var text = $("#searchtext").val();

  		searchBySno(text);
		
	});
});
</script>
  <body>

	<h4><span class="label label-default">请选择检索条件</span></h4>
	<br>
	<select id="search_select">
		<option value="sno" selected>学号</option>
	</select>
	<br>
	<b>所得学分:</b><span id="credit" class="label label-info"></span>
	<div style="padding: 40px 0px 10px;">
	  <form class="bs-example bs-example-form" role="form">
		<div class="row">
			<div class="col-lg-6">
				<div class="input-group">
					<input type="text" id="searchtext" class="form-control">
					<span class="input-group-btn">
						<button id="searchbtn" class="btn btn-default" type="button">
							搜索
						</button>
					</span>
				</div>
			</div>
		</div>
	  </form>
    </div>
    
    <table class="table table-hover">
		<thead id="search_thead">
			
		</thead>
		<tbody id="search_table">
		</tbody>
	</table>
    
    <label>——————————统计每门课程的最高分、最低分和平均分——————————</label>
    <table class="table table-hover">
		<thead>
			<tr>
				<th>序号</th>
				<th>课程名称</th>
				<th>最高分</th>
				<th>最低分</th>
				<th>平均分</th>
			</tr>
		</thead>
		<tbody id="course_table">
		</tbody>
	</table>
  </body>
</html>
