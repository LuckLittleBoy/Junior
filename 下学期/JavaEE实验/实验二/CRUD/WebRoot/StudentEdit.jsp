<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>My JSP 'StudentEdit.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
	<jsp:useBean id="db" class="com.stu.db.DBBean" scope="page" />
	<%
		ResultSet rs = null;

		request.setCharacterEncoding("utf-8");
		String strID = "";
		strID = request.getParameter("ID");
		String SQL = "SELECT * FROM Student where ID='" + strID + "'";
		rs = db.executeQuery(SQL);
	%>
	<center>

		<%
			if (rs.next() == true)
			{
		%>

		<br>
		<br>编辑学生信息<br>
		<form name="f1" id="f1" action="action/StudentEdit.action"
			method="post">
			<table border="0">
				<tr>
					<td>学号:</td>
					<td><input type="text" readonly="readonly" name="ID" id="ID"
						value="<%=rs.getString("ID")%>"> 学号不允许编辑</td>
				</tr>
				<tr>
					<td>姓名:</td>
					<td><input type="text" name="Name" id="Name"
						value="<%=rs.getString("Name")%>">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value=" 确定 ">
					</td>
				</tr>
			</table>
		</form>
		<%
			} else
			{
		%>
		<br>
		<br>编辑学生信息<br>
		<br> 学号为<%=strID%>的学生数据在数据库中不存在!<br>
		<br> <a href="StudentList.jsp">返回</a>
		<%
			}
		%>
	</center>
</body>
</html>
