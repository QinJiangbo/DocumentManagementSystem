<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="content">
${msg}
	<div class="position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a href="modify_recorded_file.jsp">修改已录入项目文件</a></span>
	</div>
	<div class="new_user_input_container">
		<div class="show_user_item_container">
			<table class="table table-bordered table-hover table-condensed"
				contenteditable="false">
				<thead>
					<tr>
						<th>项目编号</th>
						<th>项目名称</th>
						<th>项目类别</th>
						<th>操作</th>
					</tr>
					<tr>
						<td>1</td>
						<td>燃机项目</td>
						<td>燃机项目</td>
						<td>审核</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${rows}" var="row">
						<tr id="${row['项目编号']}">
							<td>${row['项目编号']}</td>
							<td>${row['项目名称']}</td>
							<td>${row['项目类别']}</td>
							<td><a href='#'>审核</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%@include file="footer.jsp" %>
  