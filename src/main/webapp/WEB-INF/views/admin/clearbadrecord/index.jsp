<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ch">
<%@ include file="../common/meta.jsp"%>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/falgun/bootbox.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/falgun/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/falgun/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript">
	function getBadRecord(){
		$.ajax({
			type : "get",
			url : $.ace.getContextPath() + "/admin/badrecord/get?id="+$("#badrecordid").val(),
			dataType : "json",
			success : function(json) {
				if(json.resultMap.state=='success'){
					$("#carid").val(json.resultMap.object.car.id);
					$("#address").val(json.resultMap.object.address);
					$("#state").val(json.resultMap.object.state);
					$("#type").val(json.resultMap.object.badRecordType.id);
					$("#createDate").val(json.resultMap.object.createDate);
				}else{
					noty({"text":""+ json.resultMap.msg +"","layout":"top","type":"warning"});
				}
			}
		});
	}
	function cleanBadRecord(){
		$.ajax({
			type : "get",
			url : $.ace.getContextPath() + "/admin/badrecord/clean?id="+$("#badrecordid").val()+"&license="+$("#license").val(),
			dataType : "json",
			success : function(json) {
				if(json.resultMap.state=='success'){
					noty({"text":""+ json.resultMap.msg +"","layout":"top","type":"success","timeout":"2000"});
				}else{
					noty({"text":""+ json.resultMap.msg +"","layout":"top","type":"warning"});
				}
			}
		});
	}
	$(document).ready(function(){
		
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
								<h3>违章处理</h3>
							</div>
							
							<div class="container">
								<form class="form-horizontal">
								  <div class="control-group">
								    <label class="control-label" for="inputEmail">违章编号</label>
								    <div class="controls">
								      <input type="text" id="badrecordid" placeholder="">
								       <button type="button" class="btn" onclick="getBadRecord()">查询</button>
								    </div>
								  </div>
								  
								  <div class="control-group">
								<label for="name" class="control-label">车牌号码：</label>
								<div class="controls">
									<input type="text" name='carid' id="carid" placeholder=""  readonly="readonly">
								</div>
							</div>
							<div class="control-group">
								<label for="address" class="control-label">违章地址：</label>
								<div class="controls">
										<input type="text" id="address" placeholder=""  readonly="readonly">
								</div>
							</div>
							<div class="control-group">
								<label for='type' class="control-label">违章类型：</label>
								<div class="controls">
									<input type="text"  id='type' placeholder=""  readonly="readonly">
								</div>
							</div>
							<div class="control-group" id='control_projectStep'>
								<label for="createDate" class="control-label">违章时间：</label>
								<div class="controls">
										 <input id="createDate"  type="text"  readonly="readonly" >
								</div>
							</div>
							<div class="control-group" id='control_projectStep'>
								<label for="createDate" class="control-label">驾照号码：</label>
								<div class="controls">
										 <input id="license"  type="text"  >
								</div>
							</div>
								  <div class="control-group">
								    <div class="controls">
								      <button type="button" class="btn" onclick="cleanBadRecord()">处理</button>
								    </div>
								  </div>
								</form>
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
										<c:forEach items="${badRecordTypes}" var="bean">
											<option value="${bean.id }">${bean.name }</option>
										</c:forEach>
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
							
							<div class="control-group">
								<label for="state" class="control-label">处理状态：</label>
								<div class="controls">
									<select name='state' id="state">
											<option value="已经处理">已经处理</option>
											<option value="未处理">未处理</option>
									</select>
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