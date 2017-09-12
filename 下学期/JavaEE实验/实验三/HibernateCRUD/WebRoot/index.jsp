<%@page import="com.dao.UserDao" import="com.model.Users"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>

	<h2 align="center">Hibernate的CRUD</h2>
	
	<table align="center" border="1">
		<tr>
			<td colspan="3" align="center"><button id="btnAdduser" onclick="btnAdduer()">增加</button>
			</td>
		</tr>
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>操作</th>
		</tr>
		<%
			List<Users> ls = UserDao.findAll();
		          for(Users u : ls)
		          {
		%>
		<tr>
			<td><%=u.getId()%></td>
			<td><%=u.getName()%></td>
			<td><a
				href="UpdateUser.jsp?id=<%=u.getId()%>&name=<%=u.getName()%>">修改</a>&nbsp;
				<a href="servlet/Delete?id=<%=u.getId()%>&name=<%=u.getName()%>">删除</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>

<script>
	function btnAdduer() {
		window.location.href = "addUser.jsp";
	}
</script>
</html>
