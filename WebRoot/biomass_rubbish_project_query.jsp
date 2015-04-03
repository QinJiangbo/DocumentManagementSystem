<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content">
	${msg}
	<div class="position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a
			href="BiomassRubbishProjectServlet?op=query">生物质、垃圾发电项目查询</a></span>
	</div>
	<form action="BiomassRubbishProjectServlet?op=query"
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
							<c:forEach items="${typeRows }" var="row">
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
							<c:forEach items="${nationRows }" var="row">
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
					<div class="fuel_machine_project_input_label">建设方式 ：</div>
					<div class="fuel_machine_project_input">
						<select name="construction_mode" class="input_select">
							<option value=""></option>
							<c:forEach items="${constructionModeRows }" var="row">
								<option value="${row['建设方式'] }">${row['建设方式'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">锅炉类型：</div>
					<div class="fuel_machine_project_input">
						<select name="boiler_type" class="input_select">
							<option value=""></option>
							<c:forEach items="${boilerTypeRows }" var="row">
								<option value="${row['锅炉类型'] }">${row['锅炉类型'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">燃料类型：</div>
					<div class="fuel_machine_project_input">
						<select name="fuel_type" class="input_select">
							<option value=""></option>
							<c:forEach items="${fuelTypeRows }" var="row">
								<option value="${row['燃料类型'] }">${row['燃料类型'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">除尘方式：</div>
					<div class="fuel_machine_project_input">
						<select name="dusting_method" class="input_select">
							<option value=""></option>
							<c:forEach items="${dustingMethodRows }" var="row">
						     <option value="${row['除尘方式'] }">${row['除尘方式'] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">脱硫方式：</div>
					<div class="fuel_machine_project_input">
						<select name="sulfur_removal_method" class="input_select">
							<option value=""></option>
							<c:forEach items="${sulfurRemovalMethodRows }" var="row">
						     <option value="${row['脱硫方式'] }">${row['脱硫方式'] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">循环冷却方式：</div>
					<div class="fuel_machine_project_input">
						<select name="circulating_cooling_method" class="input_select">
							<option value=""></option>
							<c:forEach items="${circulatingCoolingMethodRows }" var="row">
						     <option value="${row['循环冷却方式'] }">${row['循环冷却方式'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>

		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">水源：</div>
					<div class="fuel_machine_project_input">
						<select name="water_source" class="input_select">
							<option value=""></option>
							<c:forEach items="${waterSourceRows }" var="row">
						     <option value="${row['水源'] }">${row['水源'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">冷却塔型式：</div>
					<div class="fuel_machine_project_input">
						<select name="cooling_tower_pattern" class="input_select">
							<option value=""></option>
							<c:forEach items="${coolingTowerPatternRows }" var="row">
						     <option value="${row['冷却塔型式'] }">${row['冷却塔型式'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>

		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">消防标准：</div>
					<div class="fuel_machine_project_input">
						<select name="fire_protection_standard" class="input_select">
							<option value=""></option>
							<c:forEach items="${fireProtectionStandardRows }" var="row">
						     <option value="${row['消防标准'] }">${row['消防标准'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">原水预处理：</div>
					<div class="fuel_machine_project_input">
						<select name="raw_water_preprocess" class="input_select">
							<option value=""></option>
							<c:forEach items="${rawWaterPreprocessRows }" var="row">
						     <option value="${row['原水预处理'] }">${row['原水预处理'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">设计基本地震加速度：</div>
					<div class="fuel_machine_project_input">
						<select name="design_basic_seismic_acceleration" class="input_select">
							<option value=""></option>
							<c:forEach items="${designBasicSeismicAccelerationRows }" var="row">
						     <option value="${row['设计基本地震加速度'] }">${row['设计基本地震加速度'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">基础型式：</div>
					<div class="fuel_machine_project_input">
						<select name="foundation_type" class="input_select">
							<option value=""></option>
							<c:forEach items="${foundationTypeRows }" var="row">
						     <option value="${row['基础型式'] }">${row['基础型式'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">主厂房结构型式：</div>
					<div class="fuel_machine_project_input">
						<select name="main_factory_structure_pattern" class="input_select">
							<option value=""></option>
							<c:forEach items="${mainFactoryStructurePatternRows }" var="row">
						     <option value="${row['主厂房结构型式'] }">${row['主厂房结构型式'] }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<c:choose>
			<c:when test="${isPreparationOneUsed==1}">
			<div class="project_input_item_right">
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
			</div>
			</c:when>
			<c:otherwise>
			</c:otherwise>
			</c:choose>
		</div>
		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
			<c:choose>
			<c:when test="${isPreparationTwoUsed==1}">
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
			</c:when>
			<c:otherwise>
			</c:otherwise>
			</c:choose>
			</div>
			<c:choose>
			<c:when test="${isPreparationThreeUsed==1}">
			<div class="project_input_item_right">
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
			</div>
			</c:when>
			<c:otherwise>
			</c:otherwise>
			</c:choose>
		</div>
		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
			<c:choose>
			<c:when test="${isPreparationFourUsed==1}">
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
			</c:when>
			<c:otherwise>
			</c:otherwise>
			</c:choose>
			</div>
			<c:choose>
			<c:when test="${isPreparationFiveUsed==1}">
			<div class="project_input_item_right">
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
			</div>
			</c:when>
			<c:otherwise>
			</c:otherwise>
			</c:choose>
		</div>
		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
			<c:choose>
			<c:when test="${isPreparationSixUsed==1}">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">${preparationSixNewName}：</div>
					<div class="fuel_machine_project_input">
						<select name="preparation_six" class="input_select">
							<option value=""></option>
							<c:forEach items="${ preparationSixRows }" var="row">
						          <option value="${ row['预留六'] }">${ row['预留六'] }</option>
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
			<c:when test="${isPreparationSevenUsed==1}">
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">${preparationSevenNewName}：</div>
					<div class="fuel_machine_project_input">
						<select name="preparation_seven" class="input_select">
							<option value=""></option>
							<c:forEach items="${ preparationSevenRows }" var="row">
						          <option value="${ row['预留七'] }">${ row['预留七'] }</option>
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
			<c:when test="${isPreparationEightUsed==1}">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">${preparationEightNewName}：</div>
					<div class="fuel_machine_project_input">
						<select name="preparation_eight" class="input_select">
							<option value=""></option>
							<c:forEach items="${ preparationEightRows }" var="row">
						          <option value="${ row['预留八'] }">${ row['预留八'] }</option>
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
			<c:when test="${isPreparationNineUsed==1}">
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">${preparationNineNewName}：</div>
					<div class="fuel_machine_project_input">
						<select name="preparation_nine" class="input_select">
							<option value=""></option>
							<c:forEach items="${ preparationNineRows }" var="row">
						          <option value="${ row['预留九'] }">${ row['预留九'] }</option>
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
			<c:when test="${isPreparationTenUsed==1}">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">${preparationTenNewName}：</div>
					<div class="fuel_machine_project_input">
						<select name="preparation_ten" class="input_select">
							<option value=""></option>
							<c:forEach items="${ preparationTenRows }" var="row">
						          <option value="${ row['预留十'] }">${ row['预留十'] }</option>
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
						<td class="col4">${ row['项目编号'] }</td>
						<td class="col4">${ row['项目名称'] }</td>
						<td class="col4">${ row['项目类别'] }</td>
						<td class="col4"><a onclick="javascript:urlEncode2('BiomassRubbishProjectServlet?op=query&ch=view&id=${row['编号'] }&method=init&projectType=生物质、垃圾发电项目&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
		</c:otherwise>
	</c:choose>
	
</div>
<%@include file="footer.jsp"%>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           