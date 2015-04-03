<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
${msg}
	<div class="position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a href="preserved_field_maintenance.jsp">预留字段维护</a></span>
	</div>
		<div class="preserved_input_container">
			<div class="new_user_input_item_container">
				<div class="new_user_input_label">字段维护表名：</div>
				<div class="new_user_mixed_input_container">
				<span class="mixed_left_select">
					<select name="filed_maintained_table_name" id= "filed_maintained_table_name" onchange="getPreservedField()">
						<option value=""></option>
						<option value="燃机项目">燃机项目</option>
						<option value="燃煤项目">燃煤项目</option>
						<option value="光伏发电项目">光伏发电项目</option>
						<option value="生物质、垃圾发电项目">生物质、垃圾发电项目</option>
						<option value="变电工程项目">变电工程项目</option>
						<option value="送电工程项目">送电工程项目</option>
						<option value="工程前期数据">工程前期数据</option>
						<option value="国内外规程规范及相关标准">国内外规程规范及相关标准</option>
						<option value="公司科技成果">公司科技成果</option>
						<option value="工程总结">工程总结</option>
						<option value="合同及技术协议">合同及技术协议</option>
						<option value="设备及厂家资料">设备及厂家资料</option>
						<option value="技术文献">技术文献</option>
						<option value="煤质资料">煤质资料</option>
						<option value="技经">技经</option>
						<option value="其他">其他</option>
						<option value="工程专家">工程专家</option>
					</select>
				</span>
				</div>
			</div>
		</div>
		<div class="preserved_input_container">
			<div class="new_user_input_item_container">
				<div class="new_user_input_label">预留字段编号：</div>
				<div class="new_user_mixed_input_container">
				<span class="mixed_left_select">
					<select name="preserved_field_id" id="preserved_field_id" onchange="preFieldChoosed()">
						
					</select>
				</span>
				</div>
			</div>
		</div>
		<div class="preserved_input_container">
			<div class="new_user_input_item_container">
				<div class="new_user_input_label">该字段未启用：</div>
				<div class="new_user_input">
				<input type="text" name="preserved_field_used" class="new_user_input_style" value="" />
			    </div>
			</div>
		</div>
		
		<div class="preserved_input_container">
		<div class="preserved_input">
		    <a class="btn btn-default maintenance_button" onclick="">替换字段名称</a><a class="btn btn-default maintenance_button" onclick="">启用该字段</a>
		</div>
		</div>
		<div class="clearfix"></div>
</div>
<%@include file="footer.jsp" %>