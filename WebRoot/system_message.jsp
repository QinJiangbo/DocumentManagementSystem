<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
${msg}
	<div class="position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a href="system_message.jsp">系统消息</a></span>
	</div>
	<form action="ActionServlet?act=fuel_machine_project&op=add" method="post">
		<div class="new_user_input_container">
			<div class="show_user_item_container">
			    <table class="table table-bordered table-hover table-condensed" contenteditable="false">
			    <thead>
			    <tr>
			        <th>项目编号</th>
			        <th>项目名称</th>
			        <th>项目类别</th>
			        <th>审核状态</th>
			        <th colspan="2">操作</th>
			        <th>阅读状态</th>
			    </tr>
			    </thead>
			    <tbody>
			    <!-- 测试数据 -->
			    <tr>
			        <td>1</td>
			        <td>光伏发电研究</td>
			        <td>光伏发电</td>
			        <td>通过</td>
			        <td>查看</td>
			        <td>删除</td>
			        <td>已阅读</td>
			    </tr>
				<c:forEach items="${message }" var="row">
				    <tr>
				        <td>${row.pid }</td>
				        <td>${row.type }</td>
				        <td>${row.status }</td>
				        <td>${row.check }</td>
				        <td>${row.delete }</td>
				        <td>${row.read }</td>
				    </tr>
				</c:forEach>
				</tbody>
				</table>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="fuel_machine_project_input_container">
			<div class="col-md-12 input_menu_bar">
				<button class="input_menu_bar_submit btn btn-default">提交</button>
				<a class="input_menu_bar_store btn btn-default">保存</a> <a
					class="input_menu_bar_reset btn btn-default">重置</a> <a
					class="input_menu_bar_back btn btn-default">返回</a>
			</div>
		</div>
	</form>
</div>
<%@include file="footer.jsp" %>