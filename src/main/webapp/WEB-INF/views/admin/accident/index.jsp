<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ch">
<%@ include file="../common/meta.jsp"%>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/ace/admin.accident.js"></script>
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
								<h3>事故管理</h3>
							</div>
							<div class="box well form-inline">
								
								<div class="input-append date">
									<input id="start_" type="text" value="" readonly="readonly" style="width:80px;">
									<span class="add-on"><i class="icon-th"></i></span>
								</div>
								<span >~</span>
								<div class="input-append date">
									<input id="end_" type="text" value="" readonly="readonly" style="width:80px;">
									<span class="add-on"><i class="icon-th"></i></span>
								</div>
								
								
								<a onclick="$.adminAccident.initSearchDataTable()"
									class="btn btn-info" data-loading-text="正在加载..."><i class="icon-search"></i>查询</a>
							</div>
							<div class="widget-container">
								
									<a class="btn btn-success" style="float: right; margin: 5px;" onclick="$.adminAccident.showaddModal()"><i class="icon-plus"></i>发布</a>
								<table class="responsive table table-striped table-bordered"
									id="dt_table_view">
									<thead>
										<tr>
											<th >id</th>
											<th >事故车辆</th>
											<th >事故发生道路</th>
											<th >事故类型</th>
											<th >事故发生时间</th>
											<th >事故描述</th>
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
							<input type="hidden" id="id" value="">
							
							<div class="control-group">
								<label for="carid" class="control-label">事故车辆：</label>
								<div class="controls">
									<select name='carid' id="carid">
										<c:forEach items="${cars}" var="bean">
											<option value="${bean.id }">${bean.id }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="control-group" id='control_projectStep'>
								<label for="context" class="control-label">事故道路：</label>
								<div class="controls">
									<select name='loadid' id="loadid">
										<c:forEach items="${loads}" var="bean">
											<option value="${bean.id }">${bean.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							
							<div class="control-group">
								<label for="type" class="control-label">事故类型：</label>
								<div class="controls">
									<select name='type' id="type">
											<option value=""></option>
											<option value="直行事故">直行事故</option>
											<option value="追尾事故">追尾事故</option>
											<option value="超车事故">超车事故</option>
											<option value="左转弯事故">左转弯事故</option>
											<option value="右转变事故">右转变事故</option>
											<option value="窄道事故">窄道事故</option>
											<option value="弯道事故">弯道事故</option>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label for="title" class="control-label">事故发生时间：</label>
								<div class="controls">
									<div class=" input-append date">
										 <input id="createDate"  type="text" value="" readonly="readonly" >
										 <span class="add-on"><i class="icon-th"></i></span>
									</div>
								</div>
							</div>
							
							<div class="control-group" id='control_projectStep'>
								<label for="context" class="control-label">事故描述：</label>
								<div class="controls">
									<textarea name='remark' id='remark' rows="4" cols="">
									</textarea>
								</div>
							</div>
							
						</form>
					</div>
				</div>
			</div>
		</div>
		
		<div class="modal-footer center" id="div_footer">
			<a class="btn btn-primary" onclick="$.adminAccident.save()">保存</a>
			<a href="#" class="btn" data-dismiss="modal" id="closeViewModal">关闭</a>
		</div>
	</div>
</body>
</html>