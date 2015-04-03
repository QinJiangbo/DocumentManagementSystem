<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
${msg}
	<div class="position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a href="modify_user_info.jsp">修改用户信息</a></span>
	</div>
	<form action="LoginServlet" method="post" name="modify_form" onsubmit="return register_check()">
		<div class="new_user_input_container">
			<div class="new_user_input_item_container">
				<div class="new_user_input_label">用户权限：</div>
				<div class="new_user_input">
					<span class="radio_style"><input name="authority" id="authority" type="radio" value="1"/>一级用户</span><span class="radio_style"><input name="authority" id="authority" type="radio" value="2"/>二级用户</span><span class="radio_style"><input name="authority" id="authority" type="radio" value="3"/>三级用户</span><span class="radio_style"><input name="authority" id="authority" type="radio" value="4"/>四级用户</span><span class="radio_style"><input name="authority" id="authority" type="radio" value="5"/>五级用户</span>
				</div>
			</div>
		</div>
		<div class="new_user_input_container">
			<div class="new_user_input_item_container">
				<div class="new_user_input_label">用户名称：</div>
				<div class="new_user_input">
					<input name="reg_user_name" id="reg_user_name" class="new_user_input_style"/>
				</div>
			</div>
		</div>
		<div class="new_user_input_container">
			<div class="new_user_input_item_container">
				<div class="new_user_input_label">用户密码：</div>
				<div class="new_user_input">
					<input name="reg_password" id="reg_password" type="password" class="new_user_input_style"/>
				</div>
			</div>
		</div>
		<div class="new_user_input_container">
			<div class="new_user_input_item_container">
				<div class="new_user_input_label">用户邮箱：</div>
				<div class="new_user_input">
					<input name="email" id="email" type="email" class="new_user_input_style"/>
				</div>
			</div>
		</div>
		<div class="new_user_input_container">
			<div class="new_user_input_item_container">
				<div class="new_user_input_label">真实姓名：</div>
				<div class="new_user_input">
					<input name="real_name" id="real_name" class="new_user_input_style"/>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="fuel_machine_project_input_container">
			<div class="col-md-12 input_menu_bar">
				<input type="submit" class="new_user_input_submit btn btn-default" value="提交" />
				<a class="input_menu_bar_back btn btn-default">返回</a>
			</div>
		</div>
	</form>
</div>
<%@include file="footer.jsp" %>