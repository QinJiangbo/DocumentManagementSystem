<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="content">
	<div class="position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a href="technology_essay_management.jsp">技术资料录入与查询</a></span>
	</div>
	<c:choose>
		<c:when test = "${op eq 'add' }">
			<div class="project_data_management_row1">
				<a class="btn btn-lg btn-primary link_button left_btn_style" href="PreEngineeringDataServlet?op=insert">工程前期数据录入</a>
				<a class="btn btn-lg btn-primary link_button right_btn_style" href="HomeBroadStandardServlet?op=insert">国内外相关规范录入</a>
			</div>
			
			<div class="project_data_management_row2">
				<a class="btn btn-lg btn-primary link_button left_btn_style" href="CompanyTechnologyAchievementServlet?op=insert">公司科技成果录入</a>
				<a class="btn btn-lg btn-primary link_button right_btn_style" href="EngineeringSummaryServlet?op=insert">工程总结录入</a>
			</div>
			<div class="project_data_management_row2">
				<a class="btn btn-lg btn-primary link_button left_btn_style" href="ContractTechnologyProtocolServlet?op=insert">合同及技术协议录入</a>
				<a class="btn btn-lg btn-primary link_button right_btn_style" href="DeviceVenderMaterialServlet?op=insert">设备厂家资料录入</a>
			</div>
			<div class="project_data_management_row2">
				<a class="btn btn-lg btn-primary link_button left_btn_style" href="TechnologyEssayServlet?op=insert">技术文献录入</a>
				<a class="btn btn-lg btn-primary link_button right_btn_style" href="CoalMaterialServlet?op=insert">煤质资料录入</a>
			</div>
			<div class="project_data_management_row2">
				<a class="btn btn-lg btn-primary link_button left_btn_style" href="TechnologyServlet?op=insert">技经录入</a>
				<a class="btn btn-lg btn-primary link_button right_btn_style" href="OtherServlet?op=insert">其它录入</a>
			</div>
		</c:when>
		<c:otherwise>
			<div class="project_data_management_row1">
				<a class="btn btn-lg btn-primary link_button left_btn_style" href="PreEngineeringDataServlet?op=query">工程前期数据查询</a>
				<a class="btn btn-lg btn-primary link_button right_btn_style" href="HomeBroadStandardServlet?op=query">国内外相关规范查询</a>
			</div>
			
			<div class="project_data_management_row2">
				<a class="btn btn-lg btn-primary link_button left_btn_style" href="CompanyTechnologyAchievementServlet?op=query">公司科技成果查询</a>
				<a class="btn btn-lg btn-primary link_button right_btn_style" href="EngineeringSummaryServlet?op=query">工程总结查询</a>
			</div>
			<div class="project_data_management_row2">
				<a class="btn btn-lg btn-primary link_button left_btn_style" href="ContractTechnologyProtocolServlet?op=query">合同及技术协议查询</a>
				<a class="btn btn-lg btn-primary link_button right_btn_style" href="DeviceVenderMaterialServlet?op=query">设备厂家资料查询</a>
			</div>
			<div class="project_data_management_row2">
				<a class="btn btn-lg btn-primary link_button left_btn_style" href="TechnologyEssayServlet?op=query">技术文献查询</a>
				<a class="btn btn-lg btn-primary link_button right_btn_style" href="CoalMaterialServlet?op=query">煤质资料查询</a>
			</div>
			<div class="project_data_management_row2">
				<a class="btn btn-lg btn-primary link_button left_btn_style" href="TechnologyServlet?op=query">技经查询</a>
				<a class="btn btn-lg btn-primary link_button right_btn_style" href="OtherServlet?op=query">其它查询</a>
			</div>
		</c:otherwise>
	</c:choose>
	
	<div class="project_data_management_row1"></div>
</div>
<%@include file="footer.jsp" %>