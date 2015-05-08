<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ch">
<%@ include file="../common/meta.jsp"%>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/ace/admin.car.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/falgun/bootbox.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/falgun/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/falgun/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(".date").datetimepicker({
			language:  'zh-CN',
	        weekStart: 1,
	        todayBtn:  1,
	        format:'yyyy-mm-dd',
			autoclose: 1,
			todayHighlight: 1,
			startView: 2,
			minView: 2,
			forceParse: 0
	    });
	});
</script>
</head>
<body>
	<div class="layout">
		<!-- top -->
		<%@ include file="../top.jsp"%>
		<!-- 导航 -->
		<%@ include file="../menu.jsp"%>
		
		<input type="hidden" id="hf_id" />

		<div class="main-wrapper">
			<div class="container-fluid">
				<div class="row-fluid ">
					<div class="span12">
						<div class="content-widgets light-gray">
							<div class="widget-head  bondi-blue" >
								<h3>车辆管理</h3>
							</div>
							<div class="box well form-inline">
								<span>车牌号码：</span>
								<input type="text" id="_name" >
								<a onclick="$.adminCar.initSearchDataTable()"
									class="btn btn-info" data-loading-text="正在加载..."><i class="icon-search"></i>查询</a>
							</div>
							<div class="widget-container">
								
									<a class="btn btn-success" style="float: right; margin: 5px;" onclick="$.adminCar.showaddModal()"><i class="icon-plus"></i> 新增</a>
								<table class="responsive table table-striped table-bordered"
									id="dt_table_view">
									<thead>
										<tr>
											<th >车牌号码</th>
											<th >车型</th>
											<th >发动机编号</th>
											<th >车主</th>
											<th >品牌</th>
											<th >颜色</th>
											<th >变速箱</th>
											<th >操作</th>
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="../foot.jsp"%>
	</div>

	<!-- 编辑新增弹出框 -->
	<div class="modal hide fade" id="_modal">
		<div class="modal-header blue">
			<button type="button" class="close" data-dismiss="modal">×</button>
			<label id="_modal_header_label"></label>
		</div>
		<div class="modal-body" style="min-height: 200px;">
			<div class="row-fluid">
				<div class="span12">
					<div class="form-container grid-form form-background left-align form-horizontal">
						<form action="" method="get" id=''>
							<div class="control-group">
								<label for="id" class="control-label">车牌号码：</label>
								<div class="controls">
									<input type="text" id="id" placeholder="" >
								</div>
							</div>
							<div class="control-group">
								<label for="name" class="control-label">车型：</label>
								<div class="controls">
									<select id='categoryid' >
										<c:forEach items="${categorys}" var="bean">
										<option value="${bean.id }">${bean.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label for="engineNo" class="control-label">发动机编号：</label>
								<div class="controls">
									<input type="text" id="engineNo" placeholder="">
								</div>
							</div>
							
							<div class="control-group">
								<label for="owner" class="control-label">车主：</label>
								<div class="controls">
									<input type="text" id="owner" placeholder="">
								</div>
							</div>
							<div class="control-group">
								<label for="trademark" class="control-label">品牌：</label>
								<div class="controls">
									<select id='trademark' >
										<option value=""></option>
										<option value="奥迪">奥迪</option>
										<option value="别克">别克</option>
										<option value="奔驰">奔驰</option>
										<option value="宝马">宝马</option>
										<option value="宝骏">宝骏</option>
										<option value="本田">本田</option>
										<option value="标致">标致</option>
										<option value="比亚迪">比亚迪</option>
										<option value="长城">长城</option>
										<option value="长安">长安</option>
										<option value="大众">大众</option>
										<option value="丰田">丰田</option>
										<option value="福特">福特</option>
										<option value="广汽">广汽</option>
										<option value="江淮">江淮</option>
										<option value="吉利">吉利</option>
									</select>
								</div>
							</div>
							
							<div class="control-group">
								<label for="gearbox" class="control-label">变速箱：</label>
								<div class="controls">
										<select id='gearbox' >
										<option value=""></option>
										<option value="自动">自动</option>
										<option value="手动">手动</option>
										<option value="手自一体">手自一体</option>
									</select>
								</div>
							</div>
								<div class="control-group">
								<label for="color" class="control-label">颜色：</label>
								<div class="controls">
										<select id='color' >
										<option value=""></option>
										<option value="黑色">黑色</option>
										<option value="灰色">灰色</option>
										<option value="白色">白色</option>
										<option value="黄色">黄色</option>
										<option value="红色">红色</option>
										<option value="蓝色">蓝色</option>
										<option value="橙色">橙色</option>
										
									</select>
								</div>
							</div>
							
						</form>
					</div>
				</div>
			</div>
		</div>
		
		<div class="modal-footer center" id="div_footer">
			<a class="btn btn-primary" onclick="$.adminCar.save()">保存</a>
			<a href="#" class="btn" data-dismiss="modal" id="closeViewModal">关闭</a>
		</div>
	</div>
</body>
</html>