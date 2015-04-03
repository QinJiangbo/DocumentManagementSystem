<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
${msg}
	<div class="position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a href="BiomassRubbishProjectServlet?op=insert">生物质、垃圾发电项目录入</a></span>
	</div>
	<form action="BiomassRubbishProjectServlet?op=add" method="post" onsubmit="return pidCheck()">
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">项目编号：</div>
				<div class="fuel_machine_project_input">
				<input type="hidden" name="id" value="${idRow }"/>
				<input type="text" name="pid" value="${pidRow }" /></div>
			</div>
		</div>
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">项目名称：</div>
				<div class="fuel_machine_project_input"><input type="text" name="name" value="${nameRow }" /></div>
			</div>
		</div>
	</div>
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">项目类别：</div>
				<div class="mixed_input_container">
				<span class="mixed_left_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${typeRows }" var="row">
						     <option value="${row['项目类别'] }">${row['项目类别'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_left_input"><input type="text" name="type" value="${typeRow }" /></span>
				</div>
			</div>
		</div>
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">项目所在国：</div>
				<div class="mixed_input_container">
				<span class="mixed_right_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${nationRows }" var="row">
						     <option value="${row['项目所在国'] }">${row['项目所在国'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_right_input"><input type="text" name="nation" value="${nationRow }" /></span>
				</div>
			</div>
		</div>
	</div>
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">项目所在地区：</div>
				<div class="fuel_machine_project_input"><input type="text" name="area" value="${areaRow }" /></div>
			</div>
		</div>
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">装机数量：</div>
				<div class="fuel_machine_project_input"><input type="number" name="installation_number" value="${installationNumberRow }" /></div>
			</div>
		</div>
	</div>
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">建设方式 ：</div>
				<div class="mixed_input_container">
				<span class="mixed_left_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
					<option value=""></option>
					<c:forEach items="${constructionModeRows }" var="row">
					    <option value="${row['建设方式'] }">${row['建设方式'] }</option>
					</c:forEach>
					</select>
				</span><span class="mixed_left_input"><input type="text" name="construction_mode" value="${constructionModeRow }" /></span>
				</div>
			</div>
		</div>
		<div class="project_input_item_right">
			<div class="project_input_item_container">
			
				<div class="fuel_machine_project_input_label">锅炉类型：</div>
				<div class="mixed_input_container">
				<span class="mixed_right_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${boilerTypeRows }" var="row">
						     <option value="${row['锅炉类型'] }">${row['锅炉类型'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_right_input"><input type="text" name="boiler_type" value="${boilerTypeRow }" /></span>
				</div>
			</div>
		</div>
	</div>
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">燃料类型：</div>
				<div class="mixed_input_container">
				<span class="mixed_left_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${fuelTypeRows }" var="row">
						     <option value="${row['燃料类型'] }">${row['燃料类型'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_left_input"><input type="text" name="fuel_type" value="${fuelTypeRow }" /></span>
				</div>
			</div>
		</div>
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">除尘方式：</div>
				<div class="mixed_input_container">
				<span class="mixed_right_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${dustingMethodRows }" var="row">
						     <option value="${row['除尘方式'] }">${row['除尘方式'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_right_input"><input type="text" name="dusting_method" value="${dustingMethodRow }" /></span>
				</div>
			</div>
		</div>
	</div>
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">脱硫方式：</div>
				<div class="mixed_input_container">
				<span class="mixed_left_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${sulfurRemovalMethodRows }" var="row">
						     <option value="${row['脱硫方式'] }">${row['脱硫方式'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_left_input"><input type="text" name="sulfur_removal_method" value="${sulfurRemovalMethodRow }" /></span>
				</div>
			</div>
		</div>
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">年平均气温[℃]：</div>
				<div class="fuel_machine_project_input"><input type="number" name="average_temperature" value="${averageTemperatureRow }" /></div>
			</div>
		</div>
	</div>
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">极端最高气温[℃]：</div>
				<div class="fuel_machine_project_input">
					<input type="number" name="extreme_high_temperature" value="${extremeHighTemperatureRow }" />
				</div>
			</div>
		</div>
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">极端最低气温[℃] ：</div>
				<div class="fuel_machine_project_input">
					<input type="number" name="extreme_low_temperature" value="${extremeLowTemperatureRow }" />
				</div>
			</div>
		</div>
	</div>
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">平均相对湿度[%]：</div>
				<div class="fuel_machine_project_input"><input type="number" name="average_relative_humid" value="${averageRelativeHumidRow }" /></div>
			</div>
		</div>
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">循环冷却方式：</div>
				<div class="mixed_input_container">
				<span class="mixed_right_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${circulatingCoolingMethodRows }" var="row">
						     <option value="${row['循环冷却方式'] }">${row['循环冷却方式'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_right_input"><input type="text" name="circulating_cooling_method" value="${circulatingCoolingMethodRow }" /></span>
				</div>
			</div>
		</div>
	</div>
	
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">水源：</div>
				<div class="mixed_input_container">
				<span class="mixed_left_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${waterSourceRows }" var="row">
						     <option value="${row['水源'] }">${row['水源'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_left_input"><input type="text" name="water_source" value="${waterSourceRow }" /></span>
				</div>
			</div>
		</div>
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">冷却塔型式：</div>
				<div class="mixed_input_container">
				<span class="mixed_right_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${coolingTowerPatternRows }" var="row">
						     <option value="${row['冷却塔型式'] }">${row['冷却塔型式'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_right_input"><input type="text" name="cooling_tower_pattern" value="${coolingTowerPatternRow }" /></span>
				</div>
			</div>
		</div>
	</div>
	
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">消防标准：</div>
				<div class="mixed_input_container">
				<span class="mixed_left_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${fireProtectionStantardRows }" var="row">
						     <option value="${row['消防标准'] }">${row['消防标准'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_left_input"><input type="text" name="fire_protection_standard" value="${fireProtectionStandardRow }" /></span>
				</div>
			</div>
		</div>
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">原水预处理：</div>
				<div class="mixed_input_container">
				<span class="mixed_right_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${rawWaterPreprocessRows }" var="row">
						     <option value="${row['原水预处理'] }">${row['原水预处理'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_right_input"><input type="text" name="raw_water_preprocess" value="${rawWaterPreprocessRow }" /></span>
				</div>
			</div>
		</div>
	</div>
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">厂区面积[m^2] ：</div>
				<div class="fuel_machine_project_input"><input type="number" name="factory_area" value="${factoryAreaRow }" /></div>
			</div>
		</div>
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">设计基本地震加速度：</div>
				<div class="mixed_input_container">
				<span class="mixed_right_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${designBasicSeismicAccelerationRows }" var="row">
						     <option value="${row['设计基本地震加速度'] }">${row['设计基本地震加速度'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_right_input"><input type="number" name="design_basic_seismic_acceleration" value="${designBasicSeismicAccelerationRow }" /></span>
				</div>
			</div>
		</div>
	</div>
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">基础型式：</div>
				<div class="mixed_input_container">
				<span class="mixed_left_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${foundationTypeRows }" var="row">
						     <option value="${row['基础型式'] }">${row['基础型式'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_left_input"><input type="text" name="foundation_type" value="${foundationTypeRow }" /></span>
				</div>
			</div>
		</div>
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">主厂房结构型式：</div>
				<div class="mixed_input_container">
				<span class="mixed_right_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${mainFactoryStructurePatternRows }" var="row">
						     <option value="${row['主厂房结构型式'] }">${row['主厂房结构型式'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_right_input"><input type="text" name="main_factory_structure_pattern" value="${mainFactoryStructurePatternRow }" /></span>
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
				<div class="mixed_input_container">
				<span class="mixed_left_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${ preparationOneRows }" var="row">
						          <option value="${ row['预留一'] }">${ row['预留一'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_left_input"><input type="text" name="preparation_one" value="${preparationOneRow }" /></span>
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
				<div class="mixed_input_container">
				<span class="mixed_right_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${ preparationTwoRows }" var="row">
						          <option value="${ row['预留二'] }">${ row['预留二'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_right_input"><input type="text" name="preparation_two" value="${preparationTwoRow }" /></span>
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
				<div class="mixed_input_container">
				<span class="mixed_left_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${ preparationThreeRows }" var="row">
						          <option value="${ row['预留三'] }">${ row['预留三'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_left_input"><input type="text" name="preparation_three" value="${preparationThreeRow }" /></span>
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
				<div class="mixed_input_container">
				<span class="mixed_right_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${ preparationFourRows }" var="row">
						          <option value="${ row['预留四'] }">${ row['预留四'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_right_input"><input type="text" name="preparation_four" value="${preparationFourRow }" /></span>
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
				<div class="mixed_input_container">
				<span class="mixed_left_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${ preparationFiveRows }" var="row">
						          <option value="${ row['预留五'] }">${ row['预留五'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_left_input"><input type="text" name="preparation_five" value="${preparationFiveRow }" /></span>
				</div>
			</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
		</c:choose>
		</div>
		<c:choose>
		<c:when test="${isPreparationSixUsed==1}">
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">${preparationSixNewName}：</div>
				<div class="mixed_input_container">
				<span class="mixed_right_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${ preparationSixRows }" var="row">
						          <option value="${ row['预留六'] }">${ row['预留六'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_right_input"><input type="text" name="preparation_six" value="${preparationSixRow }" /></span>
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
		<c:when test="${isPreparationSevenUsed==1}">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">${preparationSevenNewName}：</div>
				<div class="mixed_input_container">
				<span class="mixed_left_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${ preparationSevenRows }" var="row">
						          <option value="${ row['预留七'] }">${ row['预留七'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_left_input"><input type="text" name="preparation_seven" value="${preparationSevenRow }" /></span>
				</div>
			</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
		</c:choose>
		</div>
		<c:choose>
		<c:when test="${isPreparationEightUsed==1}">
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">${preparationEightNewName}：</div>
				<div class="mixed_input_container">
				<span class="mixed_right_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${ preparationEightRows }" var="row">
						          <option value="${ row['预留八'] }">${ row['预留八'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_right_input"><input type="text" name="preparation_eight" value="${preparationEightRow }" /></span>
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
		<c:when test="${isPreparationNineUsed==1}">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">${preparationNineNewName}：</div>
				<div class="mixed_input_container">
				<span class="mixed_left_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${ preparationNineRows }" var="row">
						          <option value="${ row['预留九'] }">${ row['预留九'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_left_input"><input type="text" name="preparation_nine" value="${preparationNineRow }" /></span>
				</div>
			</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
		</c:choose>
		</div>
		<c:choose>
		<c:when test="${isPreparationTenUsed==1}">
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">${preparationTenNewName}：</div>
				<div class="mixed_input_container">
				<span class="mixed_right_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${ preparationTenRows }" var="row">
						          <option value="${ row['预留十'] }">${ row['预留十'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_right_input"><input type="text" name="preparation_ten" value="${preparationTenRow }" /></span>
				</div>
			</div>
		</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
		</c:choose>
		</div>
		<div class="fuel_machine_project_textArea_container">
		<div class="project_input_item_container">
			<div class="fuel_machine_project_input_textArea_label">循环水系统概述：</div>
			<div class="fuel_machine_project_input_textArea"><textArea class="fuel_machine_project_input" name="water_circulation_system_overview">${waterCirculationSystemOverviewRow}</textArea></div>
		</div>
	</div>
	<c:choose>
		<c:when test="${op!='verify' }">
			<div class="fuel_machine_project_input_container">
				<div class="project_input_item_left">
					<div class="project_input_item_container">
						<div class="fuel_machine_project_input_label">审核人：</div>
						<div class="mixed_input_container">
							<span class="mixed_right_select">
						    <select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
									<option value=""></option>
									<c:forEach items="${ verifierRows }" var="row">
										<option value="${ row['用户姓名'] }">${ row['用户姓名'] }</option>
									</c:forEach>
							</select>
							</span><span class="mixed_left_input"><input type="text"
								name="verifier" value="${verifierRow }" /></span>
						</div>
					</div>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="fuel_machine_project_textArea_container">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_textArea_label">审核意见：</div>
					<div class="fuel_machine_project_input_textArea">
						<textArea class="fuel_machine_project_input"
							name="verify_comment">${verifyCommentRow}</textArea>
					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${ch=='unpass'}">
			<div class="fuel_machine_project_textArea_container">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_textArea_label">审核意见：</div>
					<div class="fuel_machine_project_input_textArea">
						<textArea class="fuel_machine_project_input"
							name="verify_comment">${verifyCommentRow}</textArea>
					</div>
				</div>
			</div>
		</c:when>
	</c:choose>
	<div class="clearfix"></div>
	<div class="fuel_machine_project_input_container">
		<div class="input_menu_bar">
			<c:choose>
		    <c:when test="${op=='insert' || op=='update' ||op=='maintenance'||op=='save'}">
		        <button class="input_menu_bar_submit btn btn-default">提交</button>
			    <a class="input_menu_bar_store btn btn-default" onclick="save()">保存</a>
			    <a class="input_menu_bar_reset btn btn-default" onclick="clearField()">重置</a>
			    <a class="input_menu_bar_back btn btn-default" href="ActionServlet?act=index">返回</a>
			    <a class="input_menu_bar_back btn btn-default" onclick="uploadFile('${pageName}')">上传文件</a>
		    </c:when>
		</c:choose>
		<c:choose>
			<c:when test="${op=='verify' }">
		        <button class="input_menu_bar_verify btn btn-default" onclick="pass('${pageName}')">审核通过</button>
		        <button class="input_menu_bar_nonverified btn btn-default" onclick="unpass('${pageName}')">审核不通过</button>
			</c:when>
		</c:choose>
		</div>
	</div>
	</form>
	<div class="action_state">
		<div class="pageName">${pageName}</div>
		<div class="actionDo">${op}</div>
		<div class="ch">${ ch }</div>
		
	</div>
</div>
<c:choose>
	<c:when test="${empty myFileList}">
	</c:when>
	<c:otherwise>
	<c:choose>
	<c:when test="${op=='verify'||op=='query'||op=='view'||op=='maintenance'||ch=='unpass'}">
		<div class="download">
<form action="DownloadServlet?method=zipFilesDownload" method="post">
	<div class="query_table_area">
			<div class="query_file_table_head">
				<table>
					<thead>
						<tr>
						    <th class="file_checkbox"></th>
							<th class="file_name_title">文件名称</th>
							<th class="filesize_title">文件大小</th>
							<th class="file_lastmodified_title">最后修改时间</th>
							<th colspan="2" class="file_operator">文件操作</th>
						</tr>
					</thead>
				</table>
			</div>
			<div class="query_file_table_body">
				<table>
					<tbody>
						<c:forEach items="${ myFileList }" var="myFile">
							<c:choose>
								<c:when test="${ myFile.fileType =='File' }">
									<tr>
									    <td class="file_checkbox"><input type="checkbox" name="downloadFile" value="${ myFile.filePath }" /></td>
										<td class="file_name">${ myFile.fileName }</td>
										<td class="file_size">${ myFile.fileSize }K</td>
										<td class="file_lastmodified">${ myFile.lastModified }</td>
										<td class="file_download"><a onclick="FtpDownload('DownloadServlet?method=singleFileDownload&path=${ myFile.filePath }')">下载</a></td>
										<td class="fileopen"></td>
									</tr>
								</c:when>
								<c:otherwise>
									<tr>
									    <td class="file_checkbox"></td>
										<td class="folder_name">${ myFile.fileName }</td>
										<td class="file_size">${ myFile.fileSize }M</td>
										<td class="file_lastmodified">${ myFile.lastModified }</td>
										<td class="file_download"></td>
										<td class="fileopen">
										<c:choose>
											<c:when test="${op=='query'||op=='view' }">
												<a onclick="javascript:urlEncode('BiomassRubbishProjectServlet?op=query&ch=${op}&id=${ idRow }&method=checkSubFiles&path=${ myFile.filePath }')">打开下级目录</a>		
											</c:when>
											<c:when test="${op=='verify' }">
												<a onclick="javascript:urlEncode('BiomassRubbishProjectServlet?op=verify&ch=${ idRow }&method=checkSubFiles&path=${ myFile.filePath }')">打开下级目录</a>
											</c:when>
											<c:when test="${ch=='unpass' }">
												<a onclick="javascript:urlEncode('BiomassRubbishProjectServlet?op=update&ch=unpass&id=${ idRow }&method=checkSubFiles&path=${ myFile.filePath }')">打开下级目录</a>
											</c:when>
											<c:when test="${op=='maintenance' }">
												<a onclick="javascript:urlEncode('BiomassRubbishProjectServlet?op=maintenance&id=${ idRow }&ch=open&method=checkSubFiles&path=${ myFile.filePath }')">打开下级目录</a>
											</c:when>
											<c:otherwise></c:otherwise>
										</c:choose>
										</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="download_menu">
		    <a class="btn btn-default download_btn" onclick="zipFileDownload()">一键下载全部选中文件</a>
			<c:choose>
				<c:when test="${ currentPath eq initPath || currentPath == '' }">
				<c:choose>
					<c:when test="${op=='query'||op=='view' }">	
					<a class="btn btn-default back_to_parent_btn" disabled onclick="javascript:urlEncode('BiomassRubbishProjectServlet?op=query&ch=${op}&id=${ idRow }&method=checkParentFolder&currentPath=${ currentPath }')">返回上一级目录</a>
					</c:when>
					<c:when test="${op=='verify' }">
					<a class="btn btn-default back_to_parent_btn" disabled onclick="javascript:urlEncode('BiomassRubbishProjectServlet?op=verify&ch=${ idRow }&method=checkParentFolder&currentPath=${ currentPath }')">返回上一级目录</a>
					</c:when>
					<c:when test="${ch=='unpass' }">
					<a class="btn btn-default back_to_parent_btn" disabled onclick="javascript:urlEncode('BiomassRubbishProjectServlet?op=update&ch=unpass&id=${ idRow }&method=checkParentFolder&currentPath=${ currentPath }')">返回上一级目录</a>
					</c:when>
					<c:when test="${op=='maintenance' }">
					<a class="btn btn-default back_to_parent_btn" disabled onclick="javascript:urlEncode('BiomassRubbishProjectServlet?op=maintenance&ch=open&id=${ idRow }&method=checkParentFolder&currentPath=${ currentPath }')">返回上一级目录</a>
					</c:when>
					<c:otherwise></c:otherwise>
				</c:choose>
				</c:when>
				<c:otherwise>
					<c:choose>
					<c:when test="${op=='query'||op=='view' }">	
					<a class="btn btn-default back_to_parent_btn" onclick="javascript:urlEncode('BiomassRubbishProjectServlet?op=query&ch=${op}&id=${ idRow }&method=checkParentFolder&currentPath=${ currentPath }')">返回上一级目录</a>
					</c:when>
					<c:when test="${op=='verify' }">
					<a class="btn btn-default back_to_parent_btn" onclick="javascript:urlEncode('BiomassRubbishProjectServlet?op=verify&ch=${ idRow }&method=checkParentFolder&currentPath=${ currentPath }')">返回上一级目录</a>
					</c:when>
					<c:when test="${ch=='unpass' }">
					<a class="btn btn-default back_to_parent_btn" onclick="javascript:urlEncode('BiomassRubbishProjectServlet?op=update&ch=unpass&id=${ idRow }&method=checkParentFolder&currentPath=${ currentPath }')">返回上一级目录</a>
					</c:when>
					<c:when test="${op=='maintenance' }">
					<a class="btn btn-default back_to_parent_btn" onclick="javascript:urlEncode('BiomassRubbishProjectServlet?op=maintenance&ch=open&id=${ idRow }&method=checkParentFolder&currentPath=${ currentPath }')">返回上一级目录</a>
					</c:when>
					<c:otherwise></c:otherwise>
				</c:choose>
				</c:otherwise>
			</c:choose>
		</div>
	</form>
</div>
	</c:when>
</c:choose>
	</c:otherwise>
</c:choose>
<%@include file="footer.jsp" %>