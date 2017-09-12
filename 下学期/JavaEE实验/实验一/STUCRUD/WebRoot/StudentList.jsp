<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'StudentList.jsp' starting page</title>

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
	<jsp:useBean id="db" class="com.stu.db.DBBean" scope="page" />
	<%
		ResultSet rs = null;
		String SQL = "SELECT * FROM Student";
		rs = db.executeQuery(SQL);
	%>
	<center>
		学生列表 <br> <br> <a href="StudentAdd.html">添加</a> <br> <br>

		<table border="1" cellspacing="0" cellpadding="4">
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>操作</th>
			</tr>
			<%
				while (rs.next())
				{
			%>
			<tr>
				<td><%=rs.getString("ID")%></td>
				<td><%=rs.getString("Name")%></td>
				<td><a href='StudentEdit.jsp?ID=<%=rs.getString("ID")%>'>修改</a>&nbsp;
					<a href='servlet/DeleteStudent?ID=<%=rs.getString("ID")%>'>删除</a>
				</td>
			</tr>
			<%
				}
				db.close();
			%>
		</table>
		<br> <br> <a href="index.jsp">返回</a>
	</center>
</body>
</html>
