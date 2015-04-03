<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content">
	${msg}
	<div class="position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a
			href="PowerTransferEngineeringProjectServlet?op=query">变电工程项目查询</a></span>
	</div>
	<form action="PowerTransferEngineeringProjectServlet?op=query"
		method="post">
		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">项目编号：</div>
					<div class="fuel_machine_project_input">
						<input type="text" name="pid" />
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">项目名称：</div>
					<div class="fuel_machine_project_input">
						<input type="text" name="name" />
					</div>
				</div>
			</div>
		</div>
		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">项目类别：</div>
					<div class="fuel_machine_project_input">
						<select name="type" class="input_select">
							<option value=""></option>
							<c:forEach items="${ typeRows }" var="row">
						      <option value="${row['项目类别'] }">${row['项目类别'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">项目所在国：</div>
					<div class="fuel_machine_project_input">
						<select name="nation" class="input_select">
							<option value=""></option>
							<c:forEach items="${ nationRows }" var="row">
						      <option value="${row['项目所在国'] }">${row['项目所在国'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">变电站类型：</div>
					<div class="fuel_machine_project_input">
						<select name="power_transfer_type" class="input_select">
							<option value=""></option>
							<c:forEach items="${ powerTransferTypeRows }" var="row">
						      <option value="${row['变电站类型'] }">${row['变电站类型'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">单台主变容量 ：</div>
					<div class="fuel_machine_project_input">
						<select name="single_main_transformation_capacity"
							class="input_select">
							<option value=""></option>
							<c:forEach items="${ singleMainTransformationCapacityRows }" var="row">
						      <option value="${row['单台主变容量'] }">${row['单台主变容量'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">主变台数：</div>
					<div class="fuel_machine_project_input">
						<select name="main_transformation_number" class="input_select">
							<option value=""></option>
							<c:forEach items="${ mainTransformationNumberRows }" var="row">
						      <option value="${row['主变台数'] }">${row['主变台数'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">主变一次侧电压：</div>
					<div class="fuel_machine_project_input">
						<select name="main_transformation_primary_side_voltage"
							class="input_select">
							<option value=""></option>
							<c:forEach items="${ mainTransformationPrimarySideVoltageRows }" var="row">
						      <option value="${row['主变一次侧电压'] }">${row['主变一次侧电压'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="fuel_machine_project_input_container">

			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">主变二次侧电压：</div>
					<div class="fuel_machine_project_input">
						<select name="main_transformation_second_side_voltage"
							class="input_select">
							<option value=""></option>
							<c:forEach items="${ mainTransformationSecondSideVoltageRows }" var="row">
						      <option value="${row['主变二次侧电压'] }">${row['主变二次侧电压'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">主变第三绕组电压：</div>
					<div class="fuel_machine_project_input">
						<select name="main_transformation_third_winding_voltage"
							class="input_select">
							<option value=""></option>
							<c:forEach items="${ mainTransformationThirdWindingVoltageRows }" var="row">
						      <option value="${row['主变第三绕组电压'] }">${row['主变第三绕组电压'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="fuel_machine_project_input_container">

			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">主变一次侧电压配电装置电气主接线：</div>
					<div class="fuel_machine_project_input">
						<select
							name="main_transformation_primary_side_voltage_power_distribution_main_wire"
							class="input_select">
							<option value=""></option>
							<c:forEach items="${ mainTransformationPrimarySideVoltagePowerDistributionMainWireRows }" var="row">
						      <option value="${row['主变一次侧电压配电装置电气主接线'] }">${row['主变一次侧电压配电装置电气主接线'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">主变二次侧电压配电装置电气主接线：</div>
					<div class="fuel_machine_project_input">
						<select
							name="main_transformation_second_side_voltage_power_distribution_main_wire"
							class="input_select">
							<option value=""></option>
							<c:forEach items="${ mainTransformationSecondSideVoltagePowerDistributionMainWireRows }" var="row">
						      <option value="${row['主变二次侧电压配电装置电气主接线'] }">${row['主变二次侧电压配电装置电气主接线'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">主变第三绕组侧电压配电装置电气主接线
						：</div>
					<div class="fuel_machine_project_input">
						<select
							name="main_transformation_third_winding_voltage_power_distribution_main_wire"
							class="input_select">
							<option value=""></option>
							<c:forEach items="${ mainTransformationThirdWindingVoltagePowerDistributionMainWireRows }" var="row">
						      <option value="${row['主变第三绕组侧电压配电装置电气主接线'] }">${row['主变第三绕组侧电压配电装置电气主接线'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">主变一次侧电压配电装置型式：</div>
					<div class="fuel_machine_project_input">
						<select
							name="main_transformation_primary_side_voltage_power_distribution_pattern"
							class="input_select">
							<option value=""></option>
							<c:forEach items="${ mainTransformationPrimarySideVoltagePowerDistributionPatternRows }" var="row">
						      <option value="${row['主变一次侧电压配电装置型式'] }">${row['主变一次侧电压配电装置型式'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="fuel_machine_project_input_container">

			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">主变二次侧电压配电装置型式：</div>
					<div class="fuel_machine_project_input">
						<select
							name="main_transformation_second_side_voltage_power_distribution_pattern"
							class="input_select">
							<option value=""></option>
							<c:forEach items="${ mainTransformationSecondSideVoltagePowerDistributionPatternRows }" var="row">
						      <option value="${row['主变二次侧电压配电装置型式'] }">${row['主变二次侧电压配电装置型式'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">主变第三绕组侧电压配电装置型式：</div>
					<div class="fuel_machine_project_input">
						<select
							name="main_transformation_third_winding_voltage_power_distribution_pattern"
							class="input_select">
							<option value=""></option>
							<c:forEach items="${ mainTransformationThirdWindingVoltagePowerDistributionPatternRows }" var="row">
						      <option value="${row['主变第三绕组侧电压配电装置型式'] }">${row['主变第三绕组侧电压配电装置型式'] }</option>
							</c:forEach>
						</select>
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
					<th class="col4">项目编号</th>
					<th class="col4">项目名称</th>
					<th class="col4">项目类别</th>
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
						<td class="col4">${row['项目编号'] }</td>
						<td class="col4">${row['项目名称'] }</td>
						<td class="col4">${row['项目类别'] }</td>
						<td class="col4"><a onclick="javascript:urlEncode2('PowerTransferEngineeringProjectServlet?op=query&ch=view&id=${row['编号'] }&method=init&projectType=变电工程项目&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
		</c:otherwise>
	</c:choose>
	
</div>
<%@include file="footer.jsp"%>