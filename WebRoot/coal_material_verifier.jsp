<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content">
	${msg}
	<div class="position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a
			href="ActionServlet?act=Undo&op=coal_material">煤质资料审核</a></span>
	</div>
	<div class="new_user_input_container">
		<div class="show_user_item_container">
		<div class="table_head">
			<table class="table table-bordered table-hover table-condensed "
				contenteditable="false">
				<thead>
					<tr>
						<th class="col4">标准编号</th>
						<th class="col4">工程名称</th>
						<th class="col4">硫</th>
						<th class="col4">操作</th>
					</tr>
				</thead>
			</table>
		</div>
		<div class="table_body">
			<table class="table table-bordered table-hover table-condensed "
				contenteditable="false">
				<tbody>
						<c:forEach items="${coalMaterialRows}" var="row">
						<tr id="${row['项目编号']}">
							<td class="col4">${row['标准编号']}</td>
							<td class="col4">${row['工程名称']}</td>
							<td class="col4">${row['硫']}</td>
							<td class="col4"><a onclick="javascript:urlEncode2('CoalMaterialServlet?op=verify&ch=${row['编号']}&method=init&projectType=煤质资料&projectId=${row['标准编号']}')" target="_blank">审核</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		</div>
	</div>
</div>
<%@include file="footer.jsp"%>
