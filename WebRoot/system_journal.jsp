<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
${msg}
	<div class="position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a href="ActionServlet?act=system_mangement&op=log">系统日志</a></span>
	</div>
	<form action="ActionServlet?act=fuel_machine_project&op=add" method="post">
		<div class="log_container">
			<div class="table_head">
				<table class="table table-bordered table-hover table-condensed"
					contenteditable="false">
					<thead>
						<tr>
							<th class="col5">用户姓名</th>
							<th class="col5">操作</th>
							<th class="col5">表名</th>
							<th class="col5">时间</th>
							<th class="col5">选项</th>
						</tr>
					</thead>
				</table>
			</div>
			<div class="table_body">
				<table class="table table-bordered table-hover table-condensed"
					contenteditable="false">
					<tbody>
						<c:forEach items="${rows}" var="row">
							<tr>
								<td class="col5">${row['用户姓名'] }</td>
								<td class="col5">${row['操作'] }</td>
								<td class="col5">${row['表名'] }</td>
								<td class="col5">${row['时间']}</td>
								<td class="col5">
								<c:choose>
									<c:when test="${empty uname }">
										<a onclick="javascript:urlEncode('LogServlet?act=delete&id=${row['编号']}')">删除</a>
									</c:when>
									<c:otherwise>
										<a onclick="javascript:urlEncode('LogServlet?act=delete&uname=${uname}&id=${row['编号']}')">删除</a>
									</c:otherwise>
								</c:choose>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</form>
		<div class="log_datetime_picker">
			<div class="col-md-12 input_menu_bar">
				<form action="LogServlet?act=batDelete" method="post" onsubmit="return compareDate()">
				<span class="uname_span">用户姓名</span>
				<select name="username" class="input_select">
					<option value=""></option>
					<c:forEach items="${Uname}" var="row">
						<option value="${ row['用户姓名'] }">${ row['用户姓名'] }</option>
					</c:forEach>
				</select>
				<span class="start_datetime_span">起始时间</span>
				<input type="date" name="starttime" id="starttime" value="yyyy-mm-dd" />
				<span class="end_datetime_span">截止时间</span>
				<input type="date" name="endtime" id="endtime" value="yyyy-mm-dd" />
				<button class="delete_log_btn btn btn-default" >删除</button>
			</form>
			</div>
		</div>
	
</div>
<%@include file="footer.jsp" %>