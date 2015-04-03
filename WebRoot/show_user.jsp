<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
${msg}
	<div class="position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a href="ActionServlet?act=system_mangement&op=showUser">显示用户</a></span>
	</div>
	<form action="ActionServlet?act=fuel_machine_project&op=add" method="post">
		<div class="new_user_input_container">
			<div class="show_user_item_container">
				<div class="table_head">
					<table class="table table-bordered table-hover table-condensed"
						contenteditable="false">
						<thead>
							<tr>
								<th class="col4">用户姓名</th>
								<th class="col4">用户权限</th>
								<th class="col4">操作查看</th>
								<th class="col4">用户设置</th>
							</tr>
						</thead>
					</table>
				</div>
				<div class="table_body">
					<table class="table table-bordered table-hover table-condensed"
						contenteditable="false">
						<tbody>
							<c:forEach items="${rows }" var="row">
								<tr>
									<td class="col4">${row['用户姓名'] }</td>
									<td class="col4">${row['权限'] }</td>
									<td class="col4"><a onclick="javascript:urlEncode('LogServlet?act=view&uname=${row['用户姓名'] }')" target="_blank">查看</a></td>
									<td class="col4"><a onclick="javascript:urlEncode('UserServlet?act=update&id=${row['用户编号']}')" target="_blank">用户设置</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
	</form>
</div>
<%@include file="footer.jsp" %>