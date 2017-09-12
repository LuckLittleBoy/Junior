<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

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
					$(".cno").append("<option value='"+arr[0]+"'>"+arr[1]+"</option");
				}
			},
			error : function(response) {
			}
		});
	
	var list;
	$.ajax({
			type : "POST",
			url : "studentAction",
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
						var cname1 = dom.cno.substring(0,4);
						var cname2 = dom.cno.substring(4,6);
						var cname = "信"+cname1+"-"+cname2+"班";
						$("#stu_table").append("<tr class='"+style+"'><td>"
										+ (i+1) 
										+ "</td><td>" + dom.sno
										+ "</td><td>" + cname
										+ "</td><td>" + dom.sname
										+ "</td><td>" + dom.ssex
										+ "</td><td>" + dom.sbirth
										+ "</td><td>" + dom.spwd
										+ "</td><td>" + dom.stel
										+ "</td><td>" + dom.saddress
										+ "</td><td>"
										+ "<a href='javascript:void(0)' onclick='delClick("+dom.sno+")'>删除</a>"
										+ " | <a href='#modal-container-353443' role='button' data-toggle='modal' onclick='editClick(this)'>编辑</a>"
										+ " | <a href='#modal-container-436706' role='button' data-toggle='modal' onclick='lookClick(this)'>查看</a>"
										+ "</td></tr>");
					}
				}
			},
			error : function(response) {
			}
		});
		
});

function delClick(arg)
{
	var r=confirm("确认删除吗？");
	if (r==true)
	{
		window.location.href="operatestu?operateid=0&sno="+arg;
	}
	else
	{
	}
}
function editClick(node)
{
	var tr1 = node.parentNode.parentNode;
	var cname = tr1.cells[2].innerText;
	var cno = cname.replace(/[^0-9]/ig,"");
	$("#editsno").val(tr1.cells[1].innerText);
	$("#editcno option[value='"+cno+"']").attr("selected",true);
	$("#editsname").val(tr1.cells[3].innerText);
	var sex = tr1.cells[4].innerText;
	$("input[name='ssex'][value='"+sex+"']").attr("checked",true);
	$("#editsbirth").val(tr1.cells[5].innerText);
	$("#editspwd").val(tr1.cells[6].innerText);
	$("#editstel").val(tr1.cells[7].innerText);
	$("#editsaddress").val(tr1.cells[8].innerText);
	
}
function lookClick(node)
{
	var tr1 = node.parentNode.parentNode;
	$("#looksno").text(tr1.cells[1].innerText);
	$("#looksname").text(tr1.cells[2].innerText);
	$("#lookssex").text(tr1.cells[3].innerText);
	$("#looksbirth").text(tr1.cells[4].innerText);
	$("#lookspwd").text(tr1.cells[5].innerText);
	$("#lookstel").text(tr1.cells[6].innerText);
	$("#looksaddress").text(tr1.cells[7].innerText);
	$("#lookcno").text(tr1.cells[8].innerText);
}
</script>
<body>
	<a id="modal-360159" href="#modal-container-360159" role="button"
		class="btn" data-toggle="modal">添加学生</a>
	<div class="modal fade" id="modal-container-360159" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">添加学生信息</h4>
				</div>
				<div class="modal-body">
					<form name="f1" id="f1" action="operatestu?operateid=3" method="post">
						<table border="0">
							<tr>
								<td>学号:</td>
								<td><input type="text" name="sno" id="sno">
								</td>
							</tr>
							<tr>
								<td>姓名:</td>
								<td><input type="text" name="sname" id="sname">
								</td>
							</tr>
							<tr>
								<td>性别:</td>
								<td><input type="radio" name="ssex" value="男"
									checked="checked">男 <input type="radio" name="ssex"
									value="女">女</td>
							</tr>
							<tr>
								<td>出生日期:</td>
								<td><input type="text" name="sbirth" id="sbirth"
									title="形如19950628">
								</td>
							</tr>
							<tr>
								<td>密码:</td>
								<td><input type="password" name="spwd" id="spwd">
								</td>
							</tr>
							<tr>
								<td>联系电话:</td>
								<td><input type="text" name="stel" id="stel">
								</td>
							</tr>
							<tr>
								<td>地址:</td>
								<td><input type="text" name="saddress" id="saddress">
								</td>
							</tr>
							<tr>
								<td>所在班级:</td>
								<td><select name="cno" class="cno">
								</select></td>
							</tr>
							<tr>
								<td><input type="submit" value="添加"></td>
							</tr>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="modal-container-353443" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">修改学生信息</h4>
				</div>
				<div class="modal-body">
					<form name="f2" id="f2" action="operatestu?operateid=1" method="post">
						<table border="0">
							<tr>
								<td>学号:</td>
								<td><input type="text" name="sno" id="editsno">
								</td>
							</tr>
							<tr>
								<td>姓名:</td>
								<td><input type="text" name="sname" id="editsname">
								</td>
							</tr>
							<tr>
								<td>性别:</td>
								<td><input type="radio" name="ssex" value="男">男 
								<input type="radio" name="ssex" value="女">女</td>
							</tr>
							<tr>
								<td>出生日期:</td>
								<td><input type="text" name="sbirth" id="editsbirth"
									title="形如19950628">
								</td>
							</tr>
							<tr>
								<td>密码:</td>
								<td><input type="password" name="spwd" id="editspwd">
								</td>
							</tr>
							<tr>
								<td>联系电话:</td>
								<td><input type="text" name="stel" id="editstel">
								</td>
							</tr>
							<tr>
								<td>地址:</td>
								<td><input type="text" name="saddress" id="editsaddress">
								</td>
							</tr>
							<tr>
								<td>所在班级:</td>
								<td><select name="cno" id="editcno" class="cno">
								</select></td>
							</tr>
							<tr>
								<td><input type="submit" value="修改"></td>
							</tr>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="modal-container-436706" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">查看学生信息</h4>
				</div>
				<div class="modal-body">
					<label>学号:</label>&nbsp;<label id="looksno"></label><br>
					<label>姓名:</label>&nbsp;<label id="looksname"></label><br>
					<label>性别:</label>&nbsp;<label id="lookssex"></label><br>
					<label>出生日期:</label>&nbsp;<label id="looksbirth"></label><br>
					<label>密码:</label>&nbsp;<label id="lookspwd"></label><br>
					<label>联系电话:</label>&nbsp;<label id="lookstel"></label><br>
					<label>地址:</label>&nbsp;<label id="looksaddress"></label><br>
					<label>所在班级:</label>&nbsp;<label id="lookcno"></label>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					
				</div>
			</div>
		</div>
	</div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>序号</th>
				<th>学号</th>
				<th>所在班级</th>
				<th>姓名</th>
				<th>性别</th>
				<th>出生日期</th>
				<th>密码</th>
				<th>联系电话</th>
				<th>家庭地址</th>
			</tr>
		</thead>
		<tbody id="stu_table">
		</tbody>
	</table>
</body>
</html>
