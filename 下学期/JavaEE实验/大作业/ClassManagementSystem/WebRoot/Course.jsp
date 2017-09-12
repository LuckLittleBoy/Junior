<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>课程管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
	$(document).ready(function(){
	
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
										+ "</td><td>"
										+ "<a href='javascript:void(0)' onclick='delClick("+dom.kno+")'>删除</a>"
										+ " | <a href='#modal-container-853789' role='button' data-toggle='modal' onclick='editClick(this)'>编辑</a>"
										+ " | <a href='#modal-container-259872' role='button' data-toggle='modal' onclick='lookClick(this)'>查看</a>"
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
		window.location.href="operatecourse?operateid=0&kno="+arg;
	}
	else
	{
	}
}
function editClick(node)
{
	var tr1 = node.parentNode.parentNode;
	$("#editkno").val(tr1.cells[1].innerText);
	$("#editkname").val(tr1.cells[2].innerText);
	var proprety = tr1.cells[3].innerText;
	$("input[name='kproprety'][value='"+proprety+"']").attr("checked",true);
	var credit = tr1.cells[4].innerText;
	$("input[name='kcredit'][value='"+credit+"']").attr("checked",true);
}
function lookClick(node)
{
	var tr1 = node.parentNode.parentNode;
	$("#lookkno").text(tr1.cells[1].innerText);
	$("#lookkname").text(tr1.cells[2].innerText);
	$("#lookkproprety").text(tr1.cells[3].innerText);
	$("#lookkcredit").text(tr1.cells[4].innerText);
}
</script>
  <body>
  	
  	<a id="modal-242332" href="#modal-container-242332" role="button"
		class="btn" data-toggle="modal">添加课程</a>
	<div class="modal fade" id="modal-container-242332" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">添加课程信息</h4>
				</div>
				<div class="modal-body">
					<form name="f1" id="f1" action="operatecourse?operateid=3" method="post">
						<table border="0">
							<tr>
								<td>编号:</td>
								<td><input type="text" name="kno" id="kno">
								</td>
							</tr>
							<tr>
								<td>名称:</td>
								<td><input type="text" name="kname" id="kname">
								</td>
							</tr>
							<tr>
								<td>性质:</td>
								<td>
								<input type="radio" name="kproprety" value="必修" checked="checked">必修&nbsp;
								<input type="radio" name="kproprety" value="选修">选修&nbsp;
								<input type="radio" name="kproprety" value="限选">限选&nbsp;
								<input type="radio" name="kproprety" value="学位">学位
								</td>
							</tr>
							<tr>
								<td>学分:</td>
								<td>
								<input type="radio" name="kcredit" value="1" checked="checked">1分 &nbsp;
								<input type="radio" name="kcredit" value="2">2分 &nbsp;
								<input type="radio" name="kcredit" value="3">3分 &nbsp;
								<input type="radio" name="kcredit" value="4">4分 
								</td>
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
	
	<div class="modal fade" id="modal-container-853789" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">修改课程信息</h4>
				</div>
				<div class="modal-body">
					<form name="f2" id="f2" action="operatecourse?operateid=1" method="post">
						<table border="0">
							<tr>
								<td>编号:</td>
								<td><input type="text" name="kno" id="editkno">
								</td>
							</tr>
							<tr>
								<td>名称:</td>
								<td><input type="text" name="kname" id="editkname">
								</td>
							</tr>
							<tr>
								<td>性质:</td>
								<td>
								<input type="radio" name="kproprety" value="必修">必修
								<input type="radio" name="kproprety" value="选修">选修
								<input type="radio" name="kproprety" value="限选">限选
								<input type="radio" name="kproprety" value="学位">学位
								</td>
							</tr>
							<tr>
								<td>学分:</td>
								<td>
								<input type="radio" name="kcredit" value="1">1分 
								<input type="radio" name="kcredit" value="2">2分 
								<input type="radio" name="kcredit" value="3">3分 
								<input type="radio" name="kcredit" value="4">4分 
								</td>
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
	<div class="modal fade" id="modal-container-259872" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">查看课程信息</h4>
				</div>
				<div class="modal-body">
					<label>编号:</label>&nbsp;<label id="lookkno"></label><br>
					<label>名称:</label>&nbsp;<label id="lookkname"></label><br>
					<label>性质:</label>&nbsp;<label id="lookkproprety"></label><br>
					<label>学分:</label>&nbsp;<label id="lookkcredit"></label><br>
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
				<th>编号</th>
				<th>名称</th>
				<th>性质</th>
				<th>学分</th>
			</tr>
		</thead>
		<tbody id="course_table">
		</tbody>
	</table>
  </body>
</html>
