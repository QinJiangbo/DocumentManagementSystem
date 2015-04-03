<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
${msg}
	<div class="position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a href="OtherServlet?op=query">其它查询</a></span>
	</div>
	<form action="OtherServlet?op=query" method="post">
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">专业讲座：</div>
				<div class="fuel_machine_project_input"><input type="text" name="expert_lecture" /></div>
			</div>
		</div>
		<c:choose>
			<c:when test="${isPreparationOneUsed==1}">
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">${preparationOneNewName}：</div>
					<div class="fuel_machine_project_input">
						<select class="input_select">
							<option value=""></option>
							<c:forEach items="${ preparationOneRows }" var="row">
						          <option value="${ row['预留一'] }">${ row['预留一'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			</c:when>
			<c:otherwise>
			</c:otherwise>
			</c:choose>
		</div>
		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
			<c:choose>
			<c:when test="${isPreparationTwoUsed==1}">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">${preparationTwoNewName}：</div>
					<div class="fuel_machine_project_input">
						<select class="input_select">
							<option value=""></option>
							<c:forEach items="${ preparationTwoRows }" var="row">
						          <option value="${ row['预留二'] }">${ row['预留二'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</c:when>
			<c:otherwise>
			</c:otherwise>
			</c:choose>
			</div>
			<c:choose>
			<c:when test="${isPreparationThreeUsed==1}">
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">${preparationThreeNewName}：</div>
					<div class="fuel_machine_project_input">
						<select class="input_select">
							<option value=""></option>
							<c:forEach items="${ preparationThreeRows }" var="row">
						          <option value="${ row['预留三'] }">${ row['预留三'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			</c:when>
			<c:otherwise>
			</c:otherwise>
			</c:choose>
		</div>
		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
			<c:choose>
			<c:when test="${isPreparationFourUsed==1}">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">${preparationFourNewName}：</div>
					<div class="fuel_machine_project_input">
						<select class="input_select">
							<option value=""></option>
							<c:forEach items="${ preparationFourRows }" var="row">
						          <option value="${ row['预留四'] }">${ row['预留四'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</c:when>
			<c:otherwise>
			</c:otherwise>
			</c:choose>
			</div>
			<c:choose>
			<c:when test="${isPreparationFiveUsed==1}">
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">${preparationFiveNewName}：</div>
					<div class="fuel_machine_project_input">
						<select class="input_select">
							<option value=""></option>
							<c:forEach items="${ preparationFiveRows }" var="row">
						          <option value="${ row['预留五'] }">${ row['预留五'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			</c:when>
			<c:otherwise>
			</c:otherwise>
			</c:choose>
		</div>
	<div class="clearfix"></div>
	<div class="fuel_machine_project_input_container">
		<div class="col-md-12 input_menu_bar">
				<button class="input_menu_bar_query btn btn-default">查询</button>
				<a class="input_menu_bar_reset btn btn-default" onclick="clearField()">重置</a>
				<a class="input_menu_bar_back btn btn-default" href="ActionServlet?act=index">返回</a>
		</div>
	</div>
	</form>
	<c:choose>
		<c:when test="${empty rows }"></c:when>
		<c:otherwise>
		<div class="query_table_head">
		<table class="table table-bordered table-hover table-condensed"
			contenteditable="false">
			<thead>
				<tr>
					<th class="col2_content">专家讲座</th>
					<th class="col2_operation">用户操作</th>
				</tr>
			</thead>
		</table>
	</div>
	<div class="query_table_body">
		<table class="table table-bordered table-hover table-condensed"
			contenteditable="false">
			<tbody>
				<c:forEach items="${rows}" var="row">
					<tr>
						<td class="col2_content">${row['专家讲座'] }</td>
						<td class="col2_operation"><a onclick="javascript:urlEncode2('OtherServlet?op=query&ch=view&id=${row['编号'] }&method=init&projectType=其他&projectId=${row['专家讲座']}')" target="_blank">查看</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
		</c:otherwise>
	</c:choose>
	
</div>
<%@include file="footer.jsp" %>