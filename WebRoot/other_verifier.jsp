<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content">
	${msg}
	<div class="position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a
			href="ActionServlet?act=Undo&op=other">其他审核</a></span>
	</div>
	<div class="new_user_input_container">
		<div class="show_user_item_container">
		<div class="table_head">
			<table class="table table-bordered table-hover table-condensed"
				contenteditable="false">
				<thead>
					<tr>
						<th class="col2_content">专业讲座</th>
						<th class="col2_operation">操作</th>
					</tr>
				</thead>
			</table>
		</div>
		<div class="table_body">
		    <table class="table table-bordered table-hover table-condensed"
				contenteditable="false">
				<tbody>
					<c:forEach items="${otherRows}" var="row">
						<tr id="${row['专家讲座']}">
							<td class="col2_content">${row['专家讲座']}</td>
							<td class="col2_operation"><a onclick="javascript:urlEncode2('OtherServlet?op=verify&ch=${row['编号']}&method=init&projectType=其他&projectId=${row['专家讲座']}')" target="_blank">审核</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		</div>
	</div>
</div>
<%@include file="footer.jsp"%>
