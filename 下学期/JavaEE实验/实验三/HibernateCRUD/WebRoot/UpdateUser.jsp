<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改信息</title>
</head>
<body>
   <h2 align="center">修改信息</h2>
    <%request.setCharacterEncoding("utf-8"); %>
	<form action="servlet/Update" method="post">
		<table align="center">
			<tr>
				<td>请输入学号：</td>
				<td><input type="text" name="id" value="<%=request.getParameter("id") %>" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>请输入姓名：</td>
				<td><input type="text" name="name" value="<%=new String(request.getParameter("name").getBytes("ISO-8859-1"),"utf-8") %>">
				</td>
			</tr>
			<tr>
			   <td colspan="2"><input type="submit" value="保存"></td>
			</tr>
		</table>
	</form>
</body>
</html>