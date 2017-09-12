<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="extended/jquery-1.9.1.min.js"></script>
  </head>
  <script type="text/javascript">
  $(document).ready(function(){
  	$.ajax({
			type : "POST",
			url : "classAction",
			dataType : "text",

			//请求成功完成后要执行的方法  
			success : function(msg) {
				var classinfo=msg.trim().split(" ");
				for ( var i = 0; i < classinfo.length; i++)
				{
					var dom = classinfo[i];
					var arr = dom.split(",");
					$("#cno").append("<option value='"+arr[0]+"'>"+arr[1]+"</option");
				}
			},
			error : function(response) {
			}
		});
  });
  </script>
  <body>
    <form name="f1" id="f1" action="registerAction" method="post">
      <table border="0">
        <tr>
          <td>学号:</td>
          <td><input type="text" name="sno" id="sno"></td>
        </tr>
        <tr>
          <td>姓名:</td>
          <td><input type="text" name="sname" id="sname"></td>
        </tr>
        <tr>
          <td>性别:</td>
          <td>
          <input type="radio" name="ssex" value="男" checked="checked">男
          <input type="radio" name="ssex" value="女">女
          </td>
        </tr>
        <tr>
          <td>出生日期:</td>
          <td><input type="text" name="sbirth" id="sbirth" title="形如19950628"></td>
        </tr>
        <tr>
          <td>密码:</td>
          <td><input type="password" name="spwd" id="spwd"></td>
        </tr> 
        <tr>
          <td>联系电话:</td>
          <td><input type="text" name="stel" id="stel"></td>
        </tr>
        <tr>
          <td>地址:</td>
          <td><input type="text" name="saddress" id="saddress"></td>
        </tr>
        <tr>
          <td>所在班级:</td>
          <td>
          	<select name ="cno" id="cno">
          	</select>
          </td>
        </tr>
        <tr>
          <td>
          	<input type="submit" value="注册">
          </td>
          <td><a href="Login.html">登陆</a></td>
        </tr>
      </table>
    </form>
  </body>
</html>
