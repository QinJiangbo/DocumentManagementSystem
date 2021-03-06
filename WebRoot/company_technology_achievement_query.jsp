<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
${msg}
	<div class=" position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a href="CompanyTechnologyAchievementServlet?op=query">公司技术成果查询</a></span>
	</div>
	<form action="CompanyTechnologyAchievementServlet?op=query" method="post">
		<div class=" fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">名称：</div>
					<div class="fuel_machine_project_input">
						<input type="text" name="name" />
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">专业：</div>
					<div class="fuel_machine_project_input">
						<select name="profession" class="input_select">
							<option value=""></option>
							<c:forEach items="${ professionRows }" var="row">
						      <option value="${row['专业'] }">${row['专业'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class=" fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">完成时间：</div>
					<div class="mixed_input_container">
						<span class="mixed_left_select"> 
						<select name="complete_time" onchange="this.parentNode.nextSibling.firstChild.value=this.value">
								<option value=""></option>
								<c:forEach items="${ completeTimeRows }" var="row">
									<option value="${row['完成时间'] }">${row['完成时间'] }</option>
								</c:forEach>
						</select>
						</span><span class="mixed_left_input"><input type="text" name="complete_time" /></span>
					</div>
				</div>
			</div>
		</div>
		<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
		<c:choose>
		<c:when test="${isPreparationOneUsed==1}">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">${preparationOneNewName}：</div>
				<div class="fuel_machine_project_input">
					<select name="preparation_one" class="input_select">
						<option value=""></option>
						<c:forEach items="${ preparationOneRows }" var="row">
					          <option value="${ row['预留一'] }">${ row['预留一'] }</option>
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
		<c:when test="${isPreparationTwoUsed==1}">
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">${preparationTwoNewName}：</div>
				<div class="fuel_machine_project_input">
					<select name="preparation_two" class="input_select">
						<option value=""></option>
						<c:forEach items="${ preparationTwoRows }" var="row">
					          <option value="${ row['预留二'] }">${ row['预留二'] }</option>
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
		<c:when test="${isPreparationThreeUsed==1}">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">${preparationThreeNewName}：</div>
				<div class="fuel_machine_project_input">
					<select name="preparation_three" class="input_select">
						<option value=""></option>
						<c:forEach items="${ preparationThreeRows }" var="row">
					          <option value="${ row['预留三'] }">${ row['预留三'] }</option>
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
		<c:when test="${isPreparationFourUsed==1}">
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">${preparationFourNewName}：</div>
				<div class="fuel_machine_project_input">
					<select name="preparation_four" class="input_select">
						<option value=""></option>
						<c:forEach items="${ preparationFourRows }" var="row">
					          <option value="${ row['预留四'] }">${ row['预留四'] }</option>
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
		<c:when test="${isPreparationFiveUsed==1}">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">${preparationFiveNewName}：</div>
				<div class="fuel_machine_project_input">
					<select name="preparation_five" class="input_select">
						<option value=""></option>
						<c:forEach items="${ preparationFiveRows }" var="row">
					          <option value="${ row['预留五'] }">${ row['预留五'] }</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
		</c:choose>
		</div>
	</div>
	<div class="clearfix"></div>
	<div class=" fuel_machine_project_input_container">
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
					<th class="col4">名称</th>
					<th class="col4">专业</th>
					<th class="col4">完成时间</th>
					<th class="col4">用户操作</th>
				</tr>
			</thead>
		</table>
	</div>
	<div class="query_table_body">
		<table class="table table-bordered table-hover table-condensed"
			contenteditable="false">
			<tbody>
				<c:forEach items="${rows }" var="row">
					<tr>
						<td class="col4">${row['名称'] }</td>
						<td class="col4">${row['专业'] }</td>
						<td class="col4">${row['完成时间'] }</td>
						<td class="col4"><a onclick="javascript:urlEncode2('CompanyTechnologyAchievementServlet?op=query&ch=view&id=${row['编号'] }&method=init&projectType=公司科技成果&projectId=${row['名称']}')" target="_blank">查看</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
		</c:otherwise>
	</c:choose>
	
</div>
<%@include file="footer.jsp" %>