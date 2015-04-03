<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content">
	${msg}
	<div class="position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a
			href="ActionServlet?act=Undo&op=non_passed">未通过审核</a></span>
	</div>
	<div class="new_user_input_container">
		<div class="show_user_item_container">
		<div class="table_head">
			<table class="table table-bordered table-hover table-condensed"
				contenteditable="false">
				<thead>
					<tr>
						<th class="col4">表名</th>
						<th class="col4">项目名称</th>
						<th class="col4">操作</th>
					</tr>
				</thead>
			</table>
		</div>
		<div class="table_body">
		    <table class="table table-bordered table-hover table-condensed"
				contenteditable="false">  
				<tbody>
					<c:forEach items="${fuelMachineProjectRows}" var="row">
						<tr>
							<td class="col4">燃机项目</td>
							<td class="col4">${row['项目名称']}</td>
							<td class="col4"><a onclick="javascript:urlEncode2('FuelMachineProjectServlet?op=update&ch=unpass&id=${row['编号']}&method=init&projectType=燃机项目&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
						</tr>
					</c:forEach>
					<c:forEach items="${fuelCoalProjectRows}" var="row">
						<tr>
							<td class="col4">燃煤项目</td>
							<td class="col4">${row['项目名称']}</td>
							<td class="col4"><a onclick="javascript:urlEncode('FuelCoalProjectServlet?op=update&ch=unpass&id=${row['编号']}&method=init&projectType=燃煤项目&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
						</tr>
					</c:forEach>
					<c:forEach items="${photovoltaicGenerationProjectRows}" var="row">
						<tr>
							<td class="col4">光伏发电项目</td>
							<td class="col4">${row['项目名称']}</td>
							<td class="col4"><a onclick="javascript:urlEncode('PhotovoltaicGenerationProjectServlet?op=update&ch=unpass&id=${row['编号']}&method=init&projectType=光伏发电项目&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
						</tr>
					</c:forEach>
					<c:forEach items="${biomassRubbishProjectRows}" var="row">
						<tr>
							<td class="col4">生物质、垃圾发电项目</td>
							<td class="col4">${row['项目名称']}</td>
							<td class="col4"><a onclick="javascript:urlEncode('BiomassRubbishProjectServlet?op=update&ch=unpass&id=${row['编号']}&method=init&projectType=生物质、垃圾发电项目&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
						</tr>
					</c:forEach>
					<c:forEach items="${powerTransferEngineeringProjectRows}" var="row">
						<tr>
							<td class="col4">变电工程项目</td>
							<td class="col4">${row['项目名称']}</td>
							<td class="col4"><a onclick="javascript:urlEncode('PowerTransferEngineeringProjectServlet?op=update&ch=unpass&id=${row['编号']}&method=init&projectType=变电工程项目&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
						</tr>
					</c:forEach>
					<c:forEach items="${powerDeliverProjectRows}" var="row">
						<tr>
							<td class="col4">送电工程项目</td>
							<td class="col4">${row['项目名称']}</td>
							<td class="col4"><a onclick="javascript:urlEncode('PowerDeliverProjectServlet?op=update&ch=unpass&id=${row['编号']}&method=init&projectType=送电工程项目&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
						</tr>
					</c:forEach>
					<c:forEach items="${preEngineeringDataRows}" var="row">
						<tr>
							<td class="col4">工程前期数据</td>
							<td class="col4">${row['序号']}</td>
							<td class="col4"><a onclick="javascript:urlEncode('PreEngineeringDataServlet?op=update&ch=unpass&id=${row['编号']}&method=init&projectType=工程前期数据&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
						</tr>
					</c:forEach>
					<c:forEach items="${homeBroadStandardRows}" var="row">
						<tr>
							<td class="col4">国内外规程规范及相关标准</td>
							<td class="col4">${row['名称']}</td>
							<td class="col4"><a onclick="javascript:urlEncode('HomeBroadStandardServlet?op=update&ch=unpass&id=${row['编号']}&method=init&projectType=国内外规程规范及相关标准&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
						</tr>
					</c:forEach>
					<c:forEach items="${companyTechnologyAchievementRows}" var="row">
						<tr>
							<td class="col4">公司科技成果</td>
							<td class="col4">${row['名称']}</td>
							<td class="col4"><a onclick="javascript:urlEncode('CompanyTechnologyAchievementServlet?op=update&ch=unpass&id=${row['编号']}&method=init&projectType=公司科技成果&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
						</tr>
					</c:forEach>
					<c:forEach items="${engineerSummaryRows}" var="row">
						<tr>
							<td class="col4">工程总结</td>
							<td class="col4">${row['项目名称']}</td>
							<td class="col4"><a onclick="javascript:urlEncode('EngineeringSummaryServlet?op=update&ch=unpass&id=${row['编号']}&method=init&projectType=工程总结&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
						</tr>
					</c:forEach>
					<c:forEach items="${contractTechnologyProtocolRows}" var="row">
						<tr>
							<td class="col4">合同及技术协议</td>
							<td class="col4">${row['项目名称']}</td>
							<td class="col4"><a onclick="javascript:urlEncode('ContractTechnologyProtocolServlet?op=update&ch=unpass&id=${row['编号']}&method=init&projectType=合同及技术协议&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
						</tr>
					</c:forEach>
					<c:forEach items="${deviceVenderMaterialRows}" var="row">
						<tr>
							<td class="col4">设备及厂家资料</td>
							<td class="col4">${row['设备名称']}</td>
							<td class="col4"><a onclick="javascript:urlEncode('DeviceVenderMaterialServlet?op=update&ch=unpass&id=${row['编号']}&method=init&projectType=设备及厂家资料&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
						</tr>
					</c:forEach>
					<c:forEach items="${technologyEssayRows}" var="row">
						<tr>
							<td class="col4">技术文献</td>
							<td class="col4">${row['名称']}</td>
							<td class="col4"><a onclick="javascript:urlEncode('TechnologyEssayServlet?op=update&ch=unpass&id=${row['编号']}&method=init&projectType=技术文献&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
						</tr>
					</c:forEach>
					<c:forEach items="${coalMaterialRows}" var="row">
						<tr>
							<td class="col4">煤质资料</td>
							<td class="col4">${row['工程名称']}</td>
							<td class="col4"><a onclick="javascript:urlEncode('CoalMaterialServlet?op=update&ch=unpass&id=${row['编号']}&method=init&projectType=煤质资料&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
						</tr>
					</c:forEach>
					<c:forEach items="${technologyRows}" var="row">
						<tr>
							<td class="col4">技经</td>
							<td class="col4">${row['项目名称或编号']}</td>
							<td class="col4"><a onclick="javascript:urlEncode('TechnologyServlet?op=update&ch=unpass&id=${row['编号']}&method=init&projectType=技经&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
						</tr>
					</c:forEach>
					<c:forEach items="${otherRows}" var="row">
						<tr>
							<td class="col4">其它</td>
							<td class="col4">${row['专家讲座']}</td>
							<td class="col4"><a onclick="javascript:urlEncode('OtherServlet?op=update&ch=unpass&id=${row['编号']}&method=init&projectType=其它&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
						</tr>
					</c:forEach>
					<c:forEach items="${projectExpertRows}" var="row">
						<tr>
							<td class="col4">工程专家</td>
							<td class="col4">${row['姓名']}</td>
							<td class="col4"><a onclick="javascript:urlEncode('ProjectExpertServlet?op=update&ch=unpass&id=${row['编号']}&method=init&projectType=工程专家&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		</div>
	</div>
</div>
<%@include file="footer.jsp"%>
