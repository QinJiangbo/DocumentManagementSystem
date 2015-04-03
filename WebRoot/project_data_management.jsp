<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="content">
	<div class="position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a href="project_data_management.jsp">工程数据录入与查询</a></span>
	</div>
	<c:choose>
		<c:when test = "${op eq 'add' }">
			<div class="project_data_management_row1">
				<a class="btn btn-lg btn-primary link_button left_btn_style" href="FuelMachineProjectServlet?op=insert">燃机项目录入</a>
				<a class="btn btn-lg btn-primary link_button right_btn_style" href="FuelCoalProjectServlet?op=insert">燃煤项目录入</a>
			</div>
			
			<div class="project_data_management_row2">
				<a class="btn btn-lg btn-primary link_button left_btn_style" href="PhotovoltaicGenerationProjectServlet?op=insert">光伏发电项目录入</a>
				<a class="btn btn-lg btn-primary link_button right_btn_style" href="BiomassRubbishProjectServlet?op=insert">生物质、垃圾发电项目录入</a>
			</div>
			<div class="project_data_management_row2">
				<a class="btn btn-lg btn-primary link_button left_btn_style" href="PowerTransferEngineeringProjectServlet?op=insert">变电项目录入</a>
				<a class="btn btn-lg btn-primary link_button right_btn_style" href="PowerDeliverProjectServlet?op=insert">送电项目录入</a>
			</div>
		</c:when>
		<c:otherwise>
			<div class="project_data_management_row1">
				<a class="btn btn-lg btn-primary link_button left_btn_style" href="FuelMachineProjectServlet?op=query">燃机项目查询</a>
				<a class="btn btn-lg btn-primary link_button right_btn_style" href="FuelCoalProjectServlet?op=query">燃煤项目查询</a>
			</div>
			
			<div class="project_data_management_row2">
				<a class="btn btn-lg btn-primary link_button left_btn_style" href="PhotovoltaicGenerationProjectServlet?op=query">光伏发电项目查询</a>
				<a class="btn btn-lg btn-primary link_button right_btn_style" href="BiomassRubbishProjectServlet?op=query">生物质、垃圾发电项目查询</a>
			</div>
			<div class="project_data_management_row2">
				<a class="btn btn-lg btn-primary link_button left_btn_style" href="PowerTransferEngineeringProjectServlet?op=query">变电项目查询</a>
				<a class="btn btn-lg btn-primary link_button right_btn_style" href="PowerDeliverProjectServlet?op=query">送电项目查询</a>
			</div>
		</c:otherwise>
	</c:choose>
</div>
<%@include file="footer.jsp" %>