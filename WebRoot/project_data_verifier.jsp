<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content">
	${msg}
	<div class="position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a
			href="ActionServlet?act=Undo&op=project_data">工程数据审核</a></span>
	</div>
	<div class="new_user_input_container">
		<div class="show_user_item_container">
		<div class="table_head">
			<table class="table table-bordered table-hover table-condensed"
				contenteditable="false">
				<thead>
					<tr>
						<th class="col5">表名</th>
						<th class="col5">项目编号</th>
						<th class="col5">项目名称</th>
						<th class="col5">项目类别</th>
						<th class="col5">操作</th>
					</tr>
				</thead>
			</table>
		</div>
		<div class="table_body">
		    <table class="table table-bordered table-hover table-condensed"
				contenteditable="false">
				<tbody>
					<c:forEach items="${fuelMachineProjectRows}" var="row">
						<tr id="${row['编号']}">
							<td class="col5">燃机项目</td>
							<td class="col5">${row['项目编号']}</td>
							<td class="col5">${row['项目名称']}</td>
							<td class="col5">${row['项目类别']}</td>
							<td class="col5"><a onclick="javascript:urlEncode2('FuelMachineProjectServlet?op=verify&ch=${row['编号']}&method=init&projectType=燃机项目&projectId=${row['项目编号']}')" target="_blank">审核</a></td>
						</tr>
					</c:forEach>
					<c:forEach items="${fuelCoalProjectRows}" var="row">
						<tr id="${row['编号']}">
							<td class="col5">燃煤项目</td>
							<td class="col5">${row['项目编号']}</td>
							<td class="col5">${row['项目名称']}</td>
							<td class="col5">${row['项目类别']}</td>
							<td class="col5"><a onclick="javascript:urlEncode2('FuelCoalProjectServlet?op=verify&ch=${row['编号']}&method=init&projectType=燃煤项目&projectId=${row['项目编号']}')" target="_blank">审核</a></td>
						</tr>
					</c:forEach>
					<c:forEach items="${photovoltaicGenerationProjectRows}" var="row">
						<tr id="${row['编号']}">
							<td class="col5">光伏发电项目</td>
							<td class="col5">${row['项目编号']}</td>
							<td class="col5">${row['项目名称']}</td>
							<td class="col5">${row['项目类别']}</td>
							<td class="col5"><a onclick="javascript:urlEncode2('PhotovoltaicGenerationProjectServlet?op=verify&ch=${row['编号']}&method=init&projectType=光伏发电项目&projectId=${row['项目编号']}')" target="_blank">审核</a></td>
						</tr>
					</c:forEach>
					<c:forEach items="${biomassRubbishProjectRows}" var="row">
						<tr id="${row['编号']}">
							<td class="col5">生物质、垃圾发电项目</td>
							<td class="col5">${row['项目编号']}</td>
							<td class="col5">${row['项目名称']}</td>
							<td class="col5">${row['项目类别']}</td>
							<td class="col5"><a onclick="javascript:urlEncode2('BiomassRubbishProjectServlet?op=verify&ch=${row['编号']}&method=init&projectType=生物质、垃圾发电项目&projectId=${row['项目编号']}')" target="_blank">审核</a></td>
						</tr>
					</c:forEach>
					<c:forEach items="${powerTransferEngineeringProjectRows}" var="row">
						<tr id="${row['编号']}">
							<td class="col5">变电项目</td>
							<td class="col5">${row['项目编号']}</td>
							<td class="col5">${row['项目名称']}</td>
							<td class="col5">${row['项目类别']}</td>
							<td class="col5"><a onclick="javascript:urlEncode2('PowerTransferEngineeringProjectServlet?op=verify&ch=${row['编号']}&method=init&projectType=变电工程项目&projectId=${row['项目编号']}')" target="_blank">审核</a></td>
						</tr>
					</c:forEach>
					<c:forEach items="${powerDeliverProjectRows}" var="row">
						<tr id="${row['编号']}">
							<td class="col5">送电项目</td>
							<td class="col5">${row['项目编号']}</td>
							<td class="col5">${row['项目名称']}</td>
							<td class="col5">${row['项目类别']}</td>
							<td class="col5"><a onclick="javascript:urlEncode2('PowerDeliverProjectServlet?op=verify&ch=${row['编号']}&method=init&projectType=送电工程项目&projectId=${row['项目编号']}')" target="_blank">审核</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		</div>
	</div>
</div>
<%@include file="footer.jsp"%>
