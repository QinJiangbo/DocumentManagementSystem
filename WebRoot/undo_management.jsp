<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> -->
<div class="content">
	<div class="position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a href="ActionServlet?act=Undo&op=management">待办事宜</a></span>
	</div>
			<div class="project_data_management_row1">
				<c:choose>
				    <c:when test="${project_data==0}">
				    	<a class="btn btn-lg btn-primary link_button left_btn_style" href="#">工程数据审核</a>
				    </c:when>
				    <c:otherwise>
				        <a class="btn btn-lg btn-primary link_button left_btn_style color_red" href="ActionServlet?act=Undo&op=project_data">工程数据审核(${project_data })</a>
				    </c:otherwise>
				</c:choose>
				<c:choose>
				    <c:when test="${non_passed==0}">
				        <a class="btn btn-lg btn-primary link_button right_btn_style" href="#">未通过审核</a>
				    </c:when>
				    <c:otherwise>
				        <a class="btn btn-lg btn-primary link_button right_btn_style color_red" href="ActionServlet?act=Undo&op=non_passed">未通过审核(${non_passed })</a>
				    </c:otherwise>
				</c:choose>
			</div>
			
			<div class="project_data_management_row2">
				<c:choose>
				    <c:when test="${other==0}">
				        <a class="btn btn-lg btn-primary link_button left_btn_style" href="#">其他审核</a>
				    </c:when>
				    <c:otherwise>
				        <a class="btn btn-lg btn-primary link_button left_btn_style color_red" href="ActionServlet?act=Undo&op=other">其他审核(${other })</a>
				    </c:otherwise>
				</c:choose>
				<c:choose>
				    <c:when test="${pre_engineering_data==0}">
				        <a class="btn btn-lg btn-primary link_button right_btn_style" href="#">工程前期数据审核</a>
				    </c:when>
				    <c:otherwise>
				        <a class="btn btn-lg btn-primary link_button right_btn_style color_red" href="ActionServlet?act=Undo&op=pre_engineering_data">工程前期数据审核(${pre_engineering_data })</a>
				    </c:otherwise>
				</c:choose>
			</div>
			<div class="project_data_management_row2">
				<c:choose>
				    <c:when test="${home_broad_standard==0}">
				        <a class="btn btn-lg btn-primary link_button left_btn_style" href="#">国内外标准规范审核</a>
				    </c:when>
				    <c:otherwise>
				        <a class="btn btn-lg btn-primary link_button left_btn_style color_red" href="ActionServlet?act=Undo&op=home_broad_standard">国内外标准规范审核(${home_broad_standard })</a>
				    </c:otherwise>
				</c:choose>
				<c:choose>
				    <c:when test="${company_technology_achievement==0}">
				        <a class="btn btn-lg btn-primary link_button right_btn_style" href="#">公司技术成果审核</a>
				    </c:when>
				    <c:otherwise>
				        <a class="btn btn-lg btn-primary link_button right_btn_style color_red" href="ActionServlet?act=Undo&op=company_technology_achievement">公司技术成果审核(${company_technology_achievement })</a>
				    </c:otherwise>
				</c:choose>
			</div>
			<div class="project_data_management_row2">
				<c:choose>
				    <c:when test="${engineering_summary==0}">
				        <a class="btn btn-lg btn-primary link_button left_btn_style" href="#">工程总结审核</a>
				    </c:when>
				    <c:otherwise>
				        <a class="btn btn-lg btn-primary link_button left_btn_style color_red" href="ActionServlet?act=Undo&op=engineering_summary">工程总结审核(${engineering_summary })</a>
				    </c:otherwise>
				</c:choose>
				<c:choose>
				    <c:when test="${contract_technology_protocol==0}">
				        <a class="btn btn-lg btn-primary link_button right_btn_style" href="#">合同及技术协议审核</a>
				    </c:when>
				    <c:otherwise>
				        <a class="btn btn-lg btn-primary link_button right_btn_style color_red" href="ActionServlet?act=Undo&op=contract_technology_protocol">合同及技术协议审核(${contract_technology_protocol })</a>
				    </c:otherwise>
				</c:choose>
			</div>
			<div class="project_data_management_row2">
				<c:choose>
				    <c:when test="${device_vender_meterial==0}">
				        <a class="btn btn-lg btn-primary link_button left_btn_style" href="#">设备及厂家资料审核</a>
				    </c:when>
				    <c:otherwise>
				        <a class="btn btn-lg btn-primary link_button left_btn_style color_red" href="ActionServlet?act=Undo&op=device_vender_meterial">设备及厂家资料审核(${device_vender_meterial })</a>
				    </c:otherwise>
				</c:choose>
				<c:choose>
				    <c:when test="${technology_essay==0}">
				        <a class="btn btn-lg btn-primary link_button right_btn_style" href="#">技术文献审核</a>
				    </c:when>
				    <c:otherwise>
				        <a class="btn btn-lg btn-primary link_button right_btn_style color_red" href="ActionServlet?act=Undo&op=technology_essay">技术文献审核(${technology_essay })</a>
				    </c:otherwise>
				</c:choose>
			</div>
			<div class="project_data_management_row2">
				<c:choose>
				    <c:when test="${coal_material==0}">
				        <a class="btn btn-lg btn-primary link_button left_btn_style" href="#">煤质资料审核</a>
				    </c:when>
				    <c:otherwise>
				        <a class="btn btn-lg btn-primary link_button left_btn_style color_red" href="ActionServlet?act=Undo&op=coal_material">煤质资料审核(${coal_material })</a>
				    </c:otherwise>
				</c:choose>
				<c:choose>
				    <c:when test="${technology==0}">
				        <a class="btn btn-lg btn-primary link_button right_btn_style" href="#">技经审核</a>
				    </c:when>
				    <c:otherwise>
				        <a class="btn btn-lg btn-primary link_button right_btn_style color_red" href="ActionServlet?act=Undo&op=technology">技经审核(${technology })</a>
				    </c:otherwise>
				</c:choose>
			</div>
			
			<div class="project_data_management_row2">
				<c:choose>
				    <c:when test="${project_expert==0}">
				        <a class="btn btn-lg btn-primary link_button left_btn_style" href="#">工程专家信息审核</a>
				    </c:when>
				    <c:otherwise>
				        <a class="btn btn-lg btn-primary link_button left_btn_style color_red" href="ActionServlet?act=Undo&op=project_expert">工程专家信息审核(${project_expert })</a>
				    </c:otherwise>
				</c:choose>
				
				<a class="btn btn-lg btn-primary link_button right_btn_style" href="FileDiskServlet?method=init">已录入项目文件管理</a>
			</div>
	<div class="project_data_management_row1"></div>
</div>
<%@include file="footer.jsp" %>