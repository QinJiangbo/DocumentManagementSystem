<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content">
	${msg}
	<div class="position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a
			href="FuelCoalProjectServlet?op=query">燃煤项目查询</a></span>
	</div>
	<form action="FuelCoalProjectServlet?op=query"
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
		<div class=" fuel_machine_project_input_container">
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
					<div class="fuel_machine_project_input_label">机组容量(MW)：</div>
					<div class="fuel_machine_project_input">
						<select name="unit_capacity" class="input_select">
							<option value=""></option>
							<option value="0~150">0~150</option>
							<option value="150">150</option>
							<option value="150~200">150~200</option>
							<option value="200">200</option>
							<option value="200~300">200~300</option>
							<option value="300">300</option>
							<option value="300~350">300~350</option>
							<option value="350">350</option>
							<option value="350~600">350~600</option>
							<option value="600">600</option>
							<option value="600~1000">600~1000</option>
							<option value="1000">1000</option>
							<option value="1000以上">1000以上</option>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">建设方式：</div>
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
		</div>

		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">锅炉型式：</div>
					<div class="fuel_machine_project_input">
						<select name="boiler_pattern" class="input_select">
							<option value=""></option>
							<c:forEach items="${boilerPatternRows }" var="row">
						     <option value="${row['锅炉型式'] }">${row['锅炉型式'] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
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
		</div>
		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">煤质类别：</div>
					<div class="fuel_machine_project_input">
						<select name="coal_type" class="input_select">
							<option value=""></option>
							<c:forEach items="${coalTypeRows }" var="row">
						     <option value="${row['煤质类别'] }">${row['煤质类别'] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">机组等级：</div>
					<div class="fuel_machine_project_input">
						<select name="unit_level" class="input_select">
							<option value=""></option>
							<c:forEach items="${unitLevelRows }" var="row">
						     <option value="${row['机组等级'] }">${row['机组等级'] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">机组型式：</div>
					<div class="fuel_machine_project_input">
						<select name="unit_pattern" class="input_select">
							<option value=""></option>
							<c:forEach items="${unitPatternRows }" var="row">
						     <option value="${row['机组型式'] }">${row['机组型式'] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">凝结水泵设置：</div>
					<div class="fuel_machine_project_input">
						<select name="condensate_bump_configuration" class="input_select">
							<option value=""></option>
							<c:forEach items="${condensateBumpConfigurationRows }" var="row">
						     <option value="${row['凝结水泵设置'] }">${row['凝结水泵设置'] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">磨煤机型式：</div>
					<div class="fuel_machine_project_input">
						<select name="coal_mill_pattern" class="input_select">
							<option value=""></option>
							<c:forEach items="${coalMillPatternRows }" var="row">
						     <option value="${row['磨煤机型式'] }">${row['磨煤机型式'] }</option>
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
					<div class="fuel_machine_project_input_label">脱硫方式 ：</div>
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
					<div class="fuel_machine_project_input_label">脱硝方式：</div>
					<div class="fuel_machine_project_input">
						<select name="denitration_method" class="input_select">
							<option value=""></option>
							<c:forEach items="${denitrationMethodRows }" var="row">
						     <option value="${row['脱硝方式'] }">${row['脱硝方式'] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">厂外来煤方式 ：</div>
					<div class="fuel_machine_project_input">
						<select name="external_coal_method" class="input_select">
							<option value=""></option>
							<c:forEach items="${externalCoalMethodRows }" var="row">
						     <option value="${row['厂外来煤方式 '] }">${row['厂外来煤方式 '] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">煤场型式：</div>
					<div class="fuel_machine_project_input">
						<select name="coal_yard_pattern" class="input_select">
							<option value=""></option>
							<c:forEach items="${coalYardPatternRows }" var="row">
						     <option value="${row['煤场型式 '] }">${row['煤场型式 '] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">除灰系统：</div>
					<div class="fuel_machine_project_input">
						<select name="ash_removal_system" class="input_select">
							<option value=""></option>
							<c:forEach items="${ashRemovalSystemRows }" var="row">
						     <option value="${row['除灰系统 '] }">${row['除灰系统'] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">石子煤系统(PC炉中速磨)：</div>
					<div class="fuel_machine_project_input">
						<select name="PC_stove_medium_speed_coal_child_system" class="input_select">
							<option value=""></option>
							<c:forEach items="${PCStoveMediumSpeedCoalChildSystemRows }" var="row">
						     <option value="${row['PC炉中速磨石子煤系统'] }">${row['PC炉中速磨石子煤系统'] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>

		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">除渣系统(PC炉)：</div>
					<div class="fuel_machine_project_input">
						<select name="PC_stove_slag_removal_system" class="input_select">
							<option value=""></option>
							<c:forEach items="${PCStoveSlagRemovalSystemRows }" var="row">
						     <option value="${row['PC炉除渣系统'] }">${row['PC炉除渣系统'] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">除渣系统(CFB炉)：</div>
					<div class="fuel_machine_project_input">
						<select name="CFB_stove_slag_removal_system" class="input_select">
							<option value=""></option>
							<c:forEach items="${CFBStoveSlagRemovalSystemRows }" var="row">
						     <option value="${row['CFB炉除渣系统'] }">${row['CFB炉除渣系统'] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>

		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">床料系统(CFB炉)：</div>
					<div class="fuel_machine_project_input">
						<select name="CFB_stove_bed_material" class="input_select">
							<option value=""></option>
							<c:forEach items="${CFBStoveBedMaterialRows }" var="row">
						     <option value="${row['CFB炉床料系统'] }">${row['CFB炉床料系统'] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">石灰石细碎系统(CFB炉)：</div>
					<div class="fuel_machine_project_input">
						<select name="CFB_stove_limestone_break_system" class="input_select">
							<option value=""></option>
							<c:forEach items="${CFBStoveLimestoneBreakSystemRows }" var="row">
						     <option value="${row['CFB炉石灰石细碎系统'] }">${row['CFB炉石灰石细碎系统'] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>

		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">灰渣厂外输送：</div>
					<div class="fuel_machine_project_input">
						<select name="ash_external_export" class="input_select">
							<option value=""></option>
							<c:forEach items="${ashExternalExportRows }" var="row">
						     <option value="${row['灰渣厂外输送'] }">${row['灰渣厂外输送'] }</option>
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
							<c:forEach items="${coolingTowePatternRows }" var="row">
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
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">海水淡化处理：</div>
					<div class="fuel_machine_project_input">
						<select name="sea_water_desalination_process" class="input_select">
							<option value=""></option>
							<c:forEach items="${seaWaterDesalinationProcessRows }" var="row">
						     <option value="${row['海水淡化处理'] }">${row['海水淡化处理'] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>

		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">锅炉补给水处理 ：</div>
					<div class="fuel_machine_project_input">
						<select name="boiler_feedwater_process" class="input_select">
							<option value=""></option>
							<c:forEach items="${boilerFeedwaterProcessRows }" var="row">
						     <option value="${row['锅炉补给水处理'] }">${row['锅炉补给水处理'] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">凝结水精处理：</div>
					<div class="fuel_machine_project_input">
						<select name="condensate_polishing" class="input_select">
							<option value=""></option>
							<c:forEach items="${condensatePolishingRows }" var="row">
						     <option value="${row['凝结水精处理'] }">${row['凝结水精处理'] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>

		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">冷却水处理：</div>
					<div class="fuel_machine_project_input">
						<select name="cooling_water_process" class="input_select">
							<option value=""></option>
							<c:forEach items="${coolingWaterProcessRows }" var="row">
						     <option value="${row['冷却水处理'] }">${row['冷却水处理'] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">氢气站：</div>
					<div class="fuel_machine_project_input">
						<select name="hydrogen_station" class="input_select">
							<option value=""></option>
							<c:forEach items="${hydrogenStationRows }" var="row">
						     <option value="${row['氢气站'] }">${row['氢气站'] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>

		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">烟囱内筒型式：</div>
					<div class="fuel_machine_project_input">
						<select name="stack_inner_tank_pattern" class="input_select">
							<option value=""></option>
							<c:forEach items="${stackInnerTankPatternRows }" var="row">
						     <option value="${row['烟囱内筒型式'] }">${row['烟囱内筒型式'] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">基础型式(主厂区)：</div>
					<div class="fuel_machine_project_input">
						<select name="main_factory_foundation_pattern" class="input_select">
							<option value=""></option>
							<c:forEach items="${mainFactoryFoundationPatternRows }" var="row">
						     <option value="${row['主厂区基础型式'] }">${row['主厂区基础型式'] }</option>
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
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">脱硝用氨：</div>
					<div class="fuel_machine_project_input">
						<select name="ammonia_for_denitration" class="input_select">
							<option value=""></option>
							<c:forEach items="${ammoniaForDenitrationRows }" var="row">
						     <option value="${row['脱硝用氨'] }">${row['脱硝用氨'] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">消防标准 ：</div>
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
					<div class="fuel_machine_project_input_label">主厂房布置：</div>
					<div class="fuel_machine_project_input">
						<select name="main_factory_layout" class="input_select">
							<option value=""></option>
							<c:forEach items="${mainFactoryLayoutRows }" var="row">
						     <option value="${row['主厂房布置'] }">${row['主厂房布置'] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">设计基本地震加速度(g)：</div>
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
					<div class="fuel_machine_project_input_label">发电厂出线电压等级(KV)：</div>
					<div class="fuel_machine_project_input">
						<select name="power_station_outlet_voltage_class" class="input_select">
							<option value=""></option>
							<c:forEach items="${powerStationOutletVoltageClassRows }" var="row">
						     <option value="${row['发电厂出线电压等级'] }">${row['发电厂出线电压等级'] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">发电机回路GCB配置：</div>
					<div class="fuel_machine_project_input">
						<select name="dynamo_loop_GCB_installation" class="input_select">
							<option value=""></option>
							<c:forEach items="${dynamoLoopGCBInstallationRows }" var="row">
						     <option value="${row['发电机回路GCB配置'] }">${row['发电机回路GCB配置'] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">高压配电装置电气主接线：</div>
					<div class="fuel_machine_project_input">
						<select name="high_voltage_distribution_device_main_electrical_connection" class="input_select">
							<option value=""></option>
							<c:forEach items="${highVoltageDistributionDeviceMainElectricalConnectionRows }" var="row">
						     <option value="${row['高压配电装置电气主接线'] }">${row['高压配电装置电气主接线'] }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">高压配电装置型式：</div>
					<div class="fuel_machine_project_input">
						<select name="high_voltage_distribution_device_pattern" class="input_select">
							<option value=""></option>
							<c:forEach items="${highVoltageDistributionDevicePatternRows }" var="row">
						     <option value="${row['高压配电装置型式'] }">${row['高压配电装置型式'] }</option>
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
				<c:forEach items="${ rows }" var="row">
					<tr>
						<td class="col4">${row['项目编号'] }</td>
						<td class="col4">${row['项目名称'] }</td>
						<td class="col4">${row['项目类别'] }</td>
						<td class="col4"><a onclick="javascript:urlEncode2('FuelCoalProjectServlet?op=query&ch=view&id=${row['编号'] }&method=init&projectType=燃煤项目&projectId=${row['项目编号']}')" target="_blank" >查看</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
		</c:otherwise>
	</c:choose>
	
</div>
<%@include file="footer.jsp"%>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            