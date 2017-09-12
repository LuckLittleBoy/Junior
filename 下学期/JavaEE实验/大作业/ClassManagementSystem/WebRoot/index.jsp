<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>班级管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<link rel="stylesheet" type="text/css" href="css/Mymessage.css">
	<script type="text/javascript" src="extended/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="js/Mymessage.js"></script>
  </head>
  
  <%
  String child;
  child = (String)session.getAttribute("child");
  if(child==null)
  {
  	child="1";
  }
  %>
  
  <script type="text/javascript">
  $(document).ready(function(){
  
  	var index = '<%=child%>';
  	if(index=="1")
  	{
  		$("#main").load("ClassInfo.jsp", function() {
  			$("#class").addClass("active");
		});
	}
	else if(index=="2")
	{
		$("#main").load("Student.jsp", function() {
  			$("#stu").addClass("active");
		});
	}
	else if(index=="3")
	{
		$("#main").load("Course.jsp", function() {
  			$("#kecheng").addClass("active");
		});
	}
	else if(index=="4")
	{
		$("#main").load("SelectCourse.jsp", function() {
  			$("#selectcourse").addClass("active");
		});
	}
	else if(index=="5")
	{
		$("#main").load("Score.jsp", function() {
  			$("#score").addClass("active");
		});
	}
	else
	{
		$("#main").load("Search.jsp", function() {
  			$("#searchAll").addClass("active");
		});
	}
  	$("#classinfo").click(function(){
  		$("#main").load("ClassInfo.jsp", function() {
  			$("#class").addClass("active");
  			$("#stu").removeClass("active");
  			$("#kecheng").removeClass("active");
  			$("#score").removeClass("active");
  			$("#selectcourse").removeClass("active");
  			$("#searchAll").removeClass("active");
		});
  	});
  	$("#student").click(function(){
  		$("#main").load("Student.jsp", function() {
  			$("#stu").addClass("active");
  			$("#class").removeClass("active");
  			$("#kecheng").removeClass("active");
  			$("#score").removeClass("active");
  			$("#selectcourse").removeClass("active");
  			$("#searchAll").removeClass("active");
		});
  	});
  	$("#course").click(function(){
  		$("#main").load("Course.jsp", function() {
  			$("#kecheng").addClass("active");
  			$("#class").removeClass("active");
  			$("#stu").removeClass("active");
  			$("#score").removeClass("active");
  			$("#selectcourse").removeClass("active");
  			$("#searchAll").removeClass("active");
		});
  	});
  	$("#selectc").click(function(){
  		$("#main").load("SelectCourse.jsp", function() {
  			$("#selectcourse").addClass("active");
  			$("#class").removeClass("active");
  			$("#stu").removeClass("active");
  			$("#kecheng").removeClass("active");
  			$("#score").removeClass("active");
  			$("#searchAll").removeClass("active");
		});
  	});
  	$("#grade").click(function(){
  		$("#main").load("Score.jsp", function() {
  			$("#score").addClass("active");
  			$("#class").removeClass("active");
  			$("#stu").removeClass("active");
  			$("#kecheng").removeClass("active");
  			$("#selectcourse").removeClass("active");
  			$("#searchAll").removeClass("active");
		});
  	});
  	$("#search").click(function(){
  		$("#main").load("Search.jsp", function() {
  			$("#searchAll").addClass("active");
  			$("#class").removeClass("active");
  			$("#stu").removeClass("active");
  			$("#kecheng").removeClass("active");
  			$("#selectcourse").removeClass("active");
  			$("#score").removeClass("active");
		});
  	});
  	
  	
  });
  </script>
  <body>
  <div class="container">
	<div class="row clearfix">
	<div class="col-md-12 column">
	<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="index.jsp">班级管理系统</a>
    </div>
    <div>
        <ul class="nav navbar-nav">
            <li id="class"><a href="javascript:void(0)" id="classinfo">班级管理</a></li>
            <li id="stu"><a href="javascript:void(0)" id="student">学生管理</a></li>
            <li id="kecheng"><a href="javascript:void(0)" id="course">课程管理</a></li>
            <li id="selectcourse"><a href="javascript:void(0)" id="selectc">选课管理</a></li>
            <li id="score"><a href="javascript:void(0)" id="grade">分数管理</a></li>
            <li id="searchAll"><a href="javascript:void(0)" id="search">综合查询</a></li>
        </ul>
    </div>
    </div>
	</nav>
	</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="panel panel-default">

				<div class="panel-body" id="main">
					
				</div>

			</div>
		</div>
	</div>
	</div>
  </body>
  <%
  session.removeAttribute("child");
  %>
</html>
