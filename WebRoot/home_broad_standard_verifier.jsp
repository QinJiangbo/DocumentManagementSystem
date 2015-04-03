<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content">
	${msg}
	<div class="position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a
			href="ActionServlet?act=Undo&op=home_broad_standard">国内外标准规范审核</a></span>
	</div>
	<div class="new_user_input_container">
		<div class="show_user_item_container">
		<div class="table_head">
			<table class="table table-bordered table-hover table-condensed"
				contenteditable="false">
				<thead>
					<tr>
						<th class="col4">标准编号</th>
						<th class="col4">名称</th>
						<th class="col4">国别</th>
						<th class="col4">操作</th>
					</tr>
				</thead>
			</table>
		</div>
		<div class="table_body">
		    <table class="table table-bordered table-hover table-condensed"
				contenteditable="false">
				<tbody>
					<c:forEach items="${homeBroadStandardRows}" var="row">
						<tr id="${row['标准编号']}">
							<td class="col4">${row['标准编号']}</td>
							<td class="col4">${row['名称']}</td>
							<td class="col4">${row['国别']}</td>
							<td class="col4"><a onclick="javascript:urlEncode2('HomeBroadStandardServlet?op=verify&ch=${row['编号']}&method=init&projectType=国内外规程规范及相关标准&projectId=${row['标准编号']}')" target="_blank">审核</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		</div>
	</div>
</div>
<%@include file="footer.jsp"%>
