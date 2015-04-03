<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
${msg}
	<div class="position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a href="ActionServlet?act=system_mangement&op=changePwd">修改密码</a></span>
	</div>
	<form action="UserServlet?act=changePwd" method="post">
		<div class="new_user_input_container">
			<div class="new_user_input_item_container">
				<div class="new_user_input_label">用户姓名：</div>
				<div class="new_user_input">
					<div class="user_name_span">${UserName}</div>
				</div>
			</div>
		</div>
		<div class="new_user_input_container">
			<div class="new_user_input_item_container">
				<div class="new_user_input_label">旧密码：</div>
				<div class="new_user_input">
					<input name="old_password" type="password" class="new_user_input_style"/>
				</div>
			</div>
		</div>
		<div class="new_user_input_container">
			<div class="new_user_input_item_container">
				<div class="new_user_input_label">新密码：</div>
				<div class="new_user_input">
					<input name="new_password" type="password" class="new_user_input_style"/>
				</div>
			</div>
		</div>
		<div class="new_user_input_container">
			<div class="new_user_input_item_container">
				<div class="new_user_input_label">确认新密码：</div>
				<div class="new_user_input">
					<input name="confirm_password" type="password" class="new_user_input_style"/>
				</div>
			</div>
		</div>
		
		<div class="clearfix"></div>
		<div class="fuel_machine_project_input_container">
			<div class="col-md-12 input_menu_bar">
				<button class="input_menu_bar_verify btn btn-default">提交</button>
				<a class="input_menu_bar_nonverified btn btn-default ">返回</a>
			</div>
		</div>
	</form>
</div>
<%@include file="footer.jsp" %>