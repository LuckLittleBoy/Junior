<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>班级管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

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
					var style="success";
					if(i%2==0)
					{
						style="";
					}
					var dom = classinfo[i];
					var arr = dom.split(",");
					var value = arr[1].replace(/[^0-9]/ig,"");
					$("#class_table").append("<tr class='"+style+"'><td>"
										+ (i+1)
										+ "</td><td>" + arr[0]
										+ "</td><td>" + arr[1]
										+ "</td><td>" + arr[2]
										+ "</td><td>"
										+ "<a href='javascript:void(0)' onclick='delClick(this)'>删除</a>"
										+ " | <a href='#modal-container-484146' role='button' data-toggle='modal' onclick='editClick("+arr[0]+")'>编辑</a>"
										+ " | <a href='#modal-container-495772' role='button' data-toggle='modal' onclick='lookClick("+value+")'>查看</a>"
										+ "</td></tr>");
				}
			},
			error : function(response) {
			}
		});
		
		$("#savebtn").click(function(){
		
			var cno1 = $("#c1").val();
			var cno2 = $("#c2").val();
			var cname1 = $("#c1 option:selected").text();
			var cname2 = $("#c2 option:selected").text();
			window.location.href="operateclass?operateid=3&cno="+cno1+cno2 + "&cname="+cname1+"-"+cname2;
		});
		$("#editbtn").click(function(){
			var cno1 = $("#c3").val();
			var cno2 = $("#c4").val();
			var cname1 = $("#c3 option:selected").text();
			var cname2 = $("#c4 option:selected").text();
			window.location.href="operateclass?operateid=1&cno="+cno1+cno2+"&cname="+cname1+"-"+cname2;
		});
});

function delClick(node)
{
	var r=confirm("确认删除吗？");
	if (r==true)
	{
		var tr1 = node.parentNode.parentNode;
		var arg = tr1.cells[1].innerText;
		var cname = tr1.cells[2].innerText;
		var num = tr1.cells[3].innerText;
		if(num>0)
		{
			alert(cname+"有学生，不能删除");
		}
		else
		{
			window.location.href="operateclass?operateid=0&cno="+arg;
		}
	}
	else
	{
	}
}
function editClick(arg)
{
	var str=arg+"";
	var dom1 = str.substring(0,4);
	var dom2 = str.substring(4,6);
	$("#c3 option").val(dom1);
	$("#c4 option").val(dom2);
}
function lookClick(arg)
{
	var str=arg+"";
	var dom1 = str.substring(0,4);
	var dom2 = str.substring(4,5);
	var info = "信"+dom1+"-"+dom2+"班";
	$("#labelinfo").text(info);
}
</script>
<body>
    <a id="modal-825223" href="#modal-container-825223" role="button" class="btn" data-toggle="modal">添加班级</a>
	<div class="modal fade" id="modal-container-825223" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">添加班级信息</h4>
				</div>
				<div class="modal-body">
					<select id="c1">
						<option value="1403">信1403</option>
						<option value="1404">信1404</option>
						<option value="1405">信1405</option>
						<option value="1406">信1406</option>
						<option value="1503">信1503</option>
						<option value="1504">信1504</option>
						<option value="1505">信1505</option>
						<option value="1506">信1506</option>
						<option value="1603">信1603</option>
						<option value="1604">信1604</option>
						<option value="1605">信1605</option>
						<option value="1606">信1606</option>
					</select>
					<span>-</span>
					<select id="c2">
						<option value="01">1班</option>
						<option value="02">2班</option>
					</select>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" id="savebtn" class="btn btn-primary">保存</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="modal-container-484146" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">修改班级信息</h4>
				</div>
				<div class="modal-body">
				<select id="c3">
						<option>信1403</option>
						<option>信1404</option>
						<option>信1405</option>
						<option>信1406</option>
						<option>信1503</option>
						<option>信1504</option>
						<option>信1505</option>
						<option>信1506</option>
						<option>信1603</option>
						<option>信1604</option>
						<option>信1605</option>
						<option>信1606</option>
					</select>
					<span>-</span>
					<select id="c4">
						<option>1班</option>
						<option>2班</option>
					</select>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" id="editbtn" class="btn btn-primary">保存</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="modal-container-495772" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">查看班级信息</h4>
				</div>
				<div class="modal-body">
					<label id="labelinfo"></label>
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
				<th>班级编号</th>
				<th>班级名称</th>
				<th>学生人数</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="class_table">
		</tbody>
	</table>
</body>
</html>
