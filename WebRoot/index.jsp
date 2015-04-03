<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
	${msg}
	<div class="col-md-12 position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>
	</div>
	<div class="index_bg">
		<div class="index_text">本系统旨在为实现中国电力建设工程咨询中南有限公司各类工程资料的自动化管理，提高文档查询效率，而开发的工程资料管理系统项目；通过此系统，用户可将已整理好的工程文档和技术资料录入管理系统，存放于中心服务器的数据库中；经授权的用户可以通过网络访问系统，实现相关数据的录入、上传、查询、阅读、下载、备份等功能.本系统包含工程数据管理、工程资料管理及专家资料管理、待办事宜、系统管理五个版块，具体操作可参考说明文档。</div>
	</div>
</div>
<%@include file="footer.jsp" %>