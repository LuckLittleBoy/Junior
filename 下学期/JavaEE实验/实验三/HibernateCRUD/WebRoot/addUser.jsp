<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>增加页面</title>
</head>
<body>
	<h2 align="center">增加用户</h2>
	<form action="servlet/add" method="post">
		<table align="center">
			<tr>
				<td>请输入学号：</td>
				<td><input type="text" name="id">
				</td>
			</tr>
			<tr>
				<td>请输入姓名：</td>
				<td><input type="text" name="name">
				</td>
			</tr>
			<tr>
			   <td colspan="2"><input type="submit" value="保存"></td>
			</tr>
		</table>
	</form>
</body>
</html>