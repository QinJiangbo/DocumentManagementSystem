<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="content">
${msg}
	<div class="position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a href="ActionServlet?act=system_mangement&op=dataMaintenance">数据维护</a></span>
	</div>
	<div class="project_expert_management_row1">
		<a class="btn btn-primary link_button" href="ActionServlet?act=system_mangement&op=dataMaintenance&ch=fieldMaintenance">预留字段维护</a>
	</div>
	<div class="project_expert_management_row2">
		<a class="btn btn-primary link_button" href="ActionServlet?act=system_mangement&op=dataMaintenance&ch=recordMaintenance">入库记录维护</a>
	</div>
	<div class="project_expert_management_row2">
		<a class="btn btn-primary link_button" href="ActionServlet?act=system_mangement&op=dataMaintenance&ch=clearDatabase">清理数据库</a><!-- 这里有一个弹出框“确定删除数据库中未入库记录以及文件？” -->
	</div>
</div>
<%@include file="footer.jsp" %>