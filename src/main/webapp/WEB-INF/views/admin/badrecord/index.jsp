<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ch">
<%@ include file="../common/meta.jsp"%>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/ace/admin.badrecord.js"></script>
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
								<h3>违章管理</h3>
							</div>
							<div class="box well form-inline">
								<span>车牌号码：</span>
								<input type="text" id="_name" >
								<a onclick="$.adminBadRecord.initSearchDataTable()"
									class="btn btn-info" data-loading-text="正在加载..."><i class="icon-search"></i>查询</a>
							</div>
							<div class="widget-container">
								
									<a class="btn btn-success" style="float: right; margin: 5px;" onclick="$.adminBadRecord.showaddModal()"><i class="icon-plus"></i> 新增</a>
								<table class="responsive table table-striped table-bordered"
									id="dt_table_view">
									<thead>
										<tr>
											<th >id</th>
											<th >车牌号码</th>
											<th >违章地址</th>
											<th >违章类型</th>
											<th >违章日期</th>
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
								<label for="name" class="control-label">车牌号码：</label>
								<div class="controls">
									<select name='carid' id="carid">
										<c:forEach items="${cars}" var="bean">
											<option value="${bean.id }">${bean.id }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label for="address" class="control-label">违章地址：</label>
								<div class="controls">
										<input type="text" id="address" placeholder="">
								</div>
							</div>
							<div class="control-group">
								<label for='type' class="control-label">违章类型：</label>
								<div class="controls">
									<select id='type' >
										<option value=""></option>
										<option value="闯红灯">闯红灯</option>
										<option value="不按规定道路行驶">不按规定道路行驶</option>
										<option value="违法停车">违法停车</option>
										<option value="违章掉头">违章掉头</option>
										<option value="违法静止标志">违法静止标志</option>
										<option value="超速10-20%">超速10-20%</option>
										<option value="超速20-50%">超速20-50%</option>
										<option value="超速50%以上">超速50%以上</option>
										<option value="超载">超载</option>
									</select>
								</div>
							</div>
							<div class="control-group" id='control_projectStep'>
								<label for="createDate" class="control-label">违章时间：</label>
								<div class="controls">
									<div class=" input-append date">
										 <input id="createDate"  type="text" value="" readonly="readonly" >
										 <span class="add-on"><i class="icon-th"></i></span>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		
		<div class="modal-footer center" id="div_footer">
			<a class="btn btn-primary" onclick="$.adminBadRecord.save()">保存</a>
			<a href="#" class="btn" data-dismiss="modal" id="closeViewModal">关闭</a>
		</div>
	</div>
</body>
</html>