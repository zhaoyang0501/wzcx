<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]><html lang="en" class="ie6 ielt7 ielt8 ielt9"><![endif]--><!--[if IE 7 ]><html lang="en" class="ie7 ielt8 ielt9"><![endif]--><!--[if IE 8 ]><html lang="en" class="ie8 ielt9"><![endif]--><!--[if IE 9 ]><html lang="en" class="ie9"> <![endif]--><!--[if (gt IE 9)|!(IE)]><!--> 
<html lang="en"><!--<![endif]--> 
	<head>
		<meta charset="utf-8">
		<title>Dashboard - Akira</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
		<link href="css/site.css" rel="stylesheet">
		<!--[if lt IE 9]><script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
	</head>
	<body>
		<div class="container">
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container">
						<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </a> <a class="brand" href="#">违章查询</a>
						<div class="nav-collapse">
							<ul class="nav">
								<li >
									<a href="index.html">新闻查询</a>
								</li>
								<li>
									<a href="settings.htm">公告查询</a>
								</li>
								<li >
									<a href="help.htm">道路查询</a>
								</li>
								<li class="active">
									<a href="help.htm">违章查询</a>
								</li>
							</ul>
							<ul class="nav pull-right">
								<li>
									<a href="profile.htm">苏A2rtdD</a>
								</li>
								<li>
									<a href="login.htm">退出</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<h2>违章查询</h2>
					<form class="form-inline well">
					 <label class="control-label" for="inputEmail">车牌号码：</label>
					  <input type="text" class="input-small" id='_name' placeholder="车牌号码">
					   <label class="control-label" for="inputEmail">发动机号码：</label>
					  <input type="text" class="input-small" id='_name' placeholder="发动机号码">
					 
					  
					  <button type="button" class="btn" onclick="$.badrecord.initSearchDataTable()">查询</button>
					</form>
					<table class="table table-bordered table-striped" id='dt_table_view'>
						<thead>
							<tr>
							   <th>
									违章编号
								</th>
								<th>
									车牌号码
								</th>
								<th>
									违章时间
								</th>
								<th>
									违章类型
								</th>
								<th>
									违章地址
								</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>				
					
				</div>
			</div>
		</div>
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/site.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/badrecord.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/ace.js"></script>
		<script src="${pageContext.request.contextPath}/admin/js/falgun/jquery.dataTables.min.js"></script>
		<script src="${pageContext.request.contextPath}/admin/js/falgun/dataTables.bootstrap.js"></script>
		<script src="${pageContext.request.contextPath}/admin/js/falgun/TableTools.min.js"></script>
		<script type="text/javascript">
	$(function(){
		$.ace.setContextPath('${pageContext.request.contextPath}');
	});
	</script>
	</body>
</html>