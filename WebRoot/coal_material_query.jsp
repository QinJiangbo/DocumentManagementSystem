<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content">
	${msg}
	<div class=" position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a
			href="CoalMaterialServlet?op=query">煤质资料查询</a></span>
	</div>
	<form action="CoalMaterialServlet?op=query"
		method="post">
		<div class=" fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">标准编号：</div>
					<div class="fuel_machine_project_input">
						<input type="text" name="pid" />
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">工程名称：</div>
					<div class="fuel_machine_project_input">
						<input type="text" name="project_name" />
					</div>
				</div>
			</div>
		</div>
		<div class=" fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">硫[St.d](%)：</div>
					<div class="fuel_machine_project_input">
						<select name="sulfur" class="input_select">
							<option value=""></option>
							<option value="≤0.50">≤0.50</option>
							<option value="0.51～1.00">0.51～1.00</option>
							<option value="1.01～2.00">1.01～2.00</option>
							<option value="2.01～3.00">2.01～3.00</option>
							<option value=">3.00">>3.00</option>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">灰分[Ad](%)：</div>
					<div class="fuel_machine_project_input">
						<select name="ash" class="input_select">
							<option value=""></option>
							<option value="≤20.00">≤20.00</option>
							<option value="20.01～30.00">20.01～30.00</option>
							<option value="30.01～40.00">30.01～40.00</option>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class=" fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">水分[Mar](%)：</div>
					<div class="fuel_machine_project_input">
						<select name="moisture" class="input_select">
							<option value=""></option>
							<option value="≤8.0">≤8.0</option>
							<option value="8.1～12.0">8.1～12.0</option>
							<option value="12.1～20.0">12.1～20.0</option>
							<option value=">20.0">>20.0</option>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">干燥无灰基挥发分[Vdaf](%)：</div>
					<div class="fuel_machine_project_input">
						<select name="vdaf" class="input_select">
							<option value=""></option>
							<option value="≤10">≤10</option>
							<option value="10～20">10～20</option>
							<option value="20～37">20～37</option>
							<option value="＞37">＞37</option>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class=" fuel_machine_project_input_container">
			<div class="project_input_item_left">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">低位发热量(Kcal/kg)：</div>
					<div class="fuel_machine_project_input">
						<select name="net_calorific_power" class="input_select">
							<option value=""></option>
							<option value="1500～2000">1500～2000</option>
							<option value="2000～2500">2000～2500</option>
							<option value=">2500">>2500</option>
						</select>
					</div>
				</div>
			</div>
			<div class="project_input_item_right">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_label">可磨系数[HGI](/)：</div>
					<div class="fuel_machine_project_input">
						<select name="HGI" class="input_select">
							<option value=""></option>
							<option value=">40～60">>40～60</option>
							<option value=">60～80">>60～80</option>
							<option value=">80">>80</option>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
		<c:choose>
		<c:when test="${isPreparationOneUsed==1}">
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
		</c:when>
		<c:otherwise>
		</c:otherwise>
		</c:choose>
		</div>
		<c:choose>
		<c:when test="${isPreparationTwoUsed==1}">
		<div class="project_input_item_right">
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
		</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
		</c:choose>
		</div>
		<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
		<c:choose>
		<c:when test="${isPreparationThreeUsed==1}">
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
		</c:when>
		<c:otherwise>
		</c:otherwise>
		</c:choose>
		</div>
		<c:choose>
		<c:when test="${isPreparationFourUsed==1}">
		<div class="project_input_item_right">
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
		</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
		</c:choose>
		</div>
		<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
		<c:choose>
		<c:when test="${isPreparationFiveUsed==1}">
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
		</c:when>
		<c:otherwise>
		</c:otherwise>
		</c:choose>
		</div>
		<c:choose>
		<c:when test="${isPreparationSixUsed==1}">
		<div class="project_input_item_right">
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
		</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
		</c:choose>
		</div>
		<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
		<c:choose>
		<c:when test="${isPreparationSevenUsed==1}">
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
		</c:when>
		<c:otherwise>
		</c:otherwise>
		</c:choose>
		</div>
		<c:choose>
		<c:when test="${isPreparationEightUsed==1}">
		<div class="project_input_item_right">
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
		</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
		</c:choose>
		</div>
		<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
		<c:choose>
		<c:when test="${isPreparationNineUsed==1}">
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
		</c:when>
		<c:otherwise>
		</c:otherwise>
		</c:choose>
		</div>
		<c:choose>
		<c:when test="${isPreparationTenUsed==1}">
		<div class="project_input_item_right">
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
		</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
		</c:choose>
		</div>
		<div class=" fuel_machine_project_input_container">
			<div class=" input_menu_bar">
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
					<th class="col4">标准编号</th>
					<th class="col4">工程名称</th>
					<th class="col4">硫</th>
					<th class="col4">用户操作</th>
				</tr>
			</thead>
		</table>
	</div>
	<div class="query_table_body">
		<table class="table table-bordered table-hover table-condensed"
			contenteditable="false">
			<tbody>
				<c:forEach items="${rows }" var="row">
					<tr>
						<td class="col4">${row['标准编号'] }</td>
						<td class="col4">${row['工程名称'] }</td>
						<td class="col4">${row['硫'] }</td>
						<td class="col4"><a onclick="javascript:urlEncode2('CoalMaterialServlet?op=query&ch=view&id=${row['编号'] }&method=init&projectType=煤质资料&projectId=${row['标准编号']}')" target="_blank">查看</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
		</c:otherwise>
	</c:choose>
	
</div>
<%@include file="footer.jsp"%>