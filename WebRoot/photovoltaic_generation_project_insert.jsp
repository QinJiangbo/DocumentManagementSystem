<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
${msg}
	<div class="position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a href="PhotovoltaicGenerationProjectServlet?op=insert">光伏发电项目录入</a></span>
	</div>
	<form action="PhotovoltaicGenerationProjectServlet?op=add" method="post" onsubmit="return pidCheck()">
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">项目编号：</div>
				<div class="fuel_machine_project_input">
				<input type="hidden" name="id" value="${idRow }"/>
				<input type="text" name="pid" value="${pidRow }" /></div>
			</div>
		</div>
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">项目名称：</div>
				<div class="fuel_machine_project_input"><input type="text" name="name" value="${nameRow }" /></div>
			</div>
		</div>
	</div>
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">项目类别：</div>
				<div class="mixed_input_container">
				<span class="mixed_left_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${ typeRows }" var="row">
						      <option value="${row['项目类别'] }">${row['项目类别'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_left_input"><input type="text" name="type" value="${typeRow }" /></span>
				</div>
			</div>
		</div>
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">项目所在国：</div>
				<div class="mixed_input_container">
				<span class="mixed_right_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${nationRows }" var="row">
						     <option value="${row['项目所在国'] }">${row['项目所在国'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_right_input"><input type="text" name="nation" value="${nationRow }" /></span>
				</div>
			</div>
		</div>
	</div>
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">项目所在地区：</div>
				<div class="fuel_machine_project_input"><input type="text" name="area" value="${areaRow }" /></div>
			</div>
		</div>
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">总容量：</div>
				<div class="mixed_input_container">
				<span class="mixed_right_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${ totalCapacityRows }" var="row">
						      <option value="${row['总容量'] }">${row['总容量'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_right_input"><input type="number" name="total_capacity" value="${totalCapacityRow }" /></span>
				</div>
			</div>
		</div>
	</div>
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">日照时间 ：</div>
				<div class="fuel_machine_project_input"><input type="text" name="sunshine_duration" value="${sunshineDurationRow }" /></div>
			</div>
		</div>
		<div class="project_input_item_right">
			<div class="project_input_item_container">
			
				<div class="fuel_machine_project_input_label">太阳总辐射：</div>
				<div class="fuel_machine_project_input"><input type="text" name="total_solar_radiation" value="${totalSolarRadiationRow }" /></div>
			</div>
		</div>
	</div>
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">供电类型：</div>
				<div class="mixed_input_container">
				<span class="mixed_left_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${ powerSupplyTypeRows }" var="row">
						      <option value="${row['供电类型'] }">${row['供电类型'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_left_input"><input type="text" name="power_supply_type" value="${powerSupplyTypeRow }" /></span>
				</div>
			</div>
		</div>
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">建筑类型：</div>
				<div class="mixed_input_container">
				<span class="mixed_right_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${ buildingTypeRows }" var="row">
						      <option value="${row['建筑类型'] }">${row['建筑类型'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_right_input"><input type="text" name="building_type" value="${buildingTypeRow }" /></span>
				</div>
			</div>
		</div>
	</div>
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">运行方式：</div>
				<div class="mixed_input_container">
				<span class="mixed_left_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${ runningModeRows }" var="row">
						      <option value="${row['运行方式'] }">${row['运行方式'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_left_input"><input type="text" name="running_mode" value="${runningModeRow }" /></span>
				</div>
			</div>
		</div>
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">电池类型：</div>
				<div class="mixed_input_container">
				<span class="mixed_right_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${ batteryTypeRows }" var="row">
						      <option value="${row['电池类型'] }">${row['电池类型'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_right_input"><input type="text" name="battery_type" value="${batteryTypeRow }" /></span>
				</div>
			</div>
		</div>
	</div>
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">厂区面积(m^2)：</div>
				<div class="fuel_machine_project_input">
					<input type="number" name="factory_area" value="${factoryAreaRow }" />
				</div>
			</div>
		</div>
		<c:choose>
		<c:when test="${isPreparationOneUsed==1}">
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">${preparationOneNewName}：</div>
				<div class="mixed_input_container">
				<span class="mixed_left_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${ preparationOneRows }" var="row">
						          <option value="${ row['预留一'] }">${ row['预留一'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_left_input"><input type="text" name="preparation_one" value="${preparationOneRow }" /></span>
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
		<c:when test="${isPreparationTwoUsed==1}">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">${preparationTwoNewName}：</div>
				<div class="mixed_input_container">
				<span class="mixed_left_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${ preparationTwoRows }" var="row">
						          <option value="${ row['预留二'] }">${ row['预留二'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_left_input"><input type="text" name="preparation_two" value="${preparationTwoRow }" /></span>
				</div>
			</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
		</c:choose>
		</div>
		<c:choose>
		<c:when test="${isPreparationThreeUsed==1}">
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">${preparationThreeNewName}：</div>
				<div class="mixed_input_container">
				<span class="mixed_left_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${ preparationThreeRows }" var="row">
						          <option value="${ row['预留三'] }">${ row['预留三'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_left_input"><input type="text" name="preparation_three" value="${preparationThreeRow }" /></span>
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
		<c:when test="${isPreparationFourUsed==1}">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">${preparationFourNewName}：</div>
				<div class="mixed_input_container">
				<span class="mixed_left_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${ preparationFourRows }" var="row">
						          <option value="${ row['预留四'] }">${ row['预留四'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_left_input"><input type="text" name="preparation_four" value="${preparationFourRow }" /></span>
				</div>
			</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
		</c:choose>
		</div>
		<c:choose>
		<c:when test="${isPreparationFiveUsed==1}">
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">${preparationFiveNewName}：</div>
				<div class="mixed_input_container">
				<span class="mixed_left_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${ preparationFiveRows }" var="row">
						          <option value="${ row['预留五'] }">${ row['预留五'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_left_input"><input type="text" name="preparation_five" value="${preparationFiveRow }" /></span>
				</div>
			</div>
		</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
		</c:choose>
	</div>
	<c:choose>
		<c:when test="${op!='verify' }">
			<div class="fuel_machine_project_input_container">
				<div class="project_input_item_left">
					<div class="project_input_item_container">
						<div class="fuel_machine_project_input_label">审核人：</div>
						<div class="mixed_input_container">
							<span class="mixed_right_select"> 
							<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
									<option value=""></option>
									<c:forEach items="${ verifierRows }" var="row">
										<option value="${ row['用户姓名'] }">${ row['用户姓名'] }</option>
									</c:forEach>
							</select>
							</span><span class="mixed_left_input"><input type="text"
								name="verifier" value="${verifierRow }" /></span>
						</div>
					</div>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="fuel_machine_project_textArea_container">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_textArea_label">审核意见：</div>
					<div class="fuel_machine_project_input_textArea">
						<textArea class="fuel_machine_project_input"
							name="verify_comment">${verifyCommentRow}</textArea>
					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${ch=='unpass'}">
			<div class="fuel_machine_project_textArea_container">
				<div class="project_input_item_container">
					<div class="fuel_machine_project_input_textArea_label">审核意见：</div>
					<div class="fuel_machine_project_input_textArea">
						<textArea class="fuel_machine_project_input"
							name="verify_comment">${verifyCommentRow}</textArea>
					</div>
				</div>
			</div>
		</c:when>
	</c:choose>
	<div class="clearfix"></div>
	<div class="fuel_machine_project_input_container">
		<div class="input_menu_bar">
			<c:choose>
		    <c:when test="${op=='insert' || op=='update' ||op=='maintenance'||op=='save'}">
		        <button class="input_menu_bar_submit btn btn-default">提交</button>
			    <a class="input_menu_bar_store btn btn-default" onclick="save()">保存</a>
			    <a class="input_menu_bar_reset btn btn-default" onclick="clearField()">重置</a>
			    <a class="input_menu_bar_back btn btn-default" href="ActionServlet?act=index">返回</a>
			    <a class="input_menu_bar_back btn btn-default" onclick="uploadFile('${pageName}')">上传文件</a>
		    </c:when>
		</c:choose>
		<c:choose>
			<c:when test="${op=='verify' }">
		        <button class="input_menu_bar_verify btn btn-default" onclick="pass('${pageName}')">审核通过</button>
		        <button class="input_menu_bar_nonverified btn btn-default" onclick="unpass('${pageName}')">审核不通过</button>
			</c:when>
		</c:choose>
		</div>
	</div>
	</form>
	
	<div class="action_state">
		<div class="pageName">${pageName}</div>
		<div class="actionDo">${op}</div>
		<div class="ch">${ ch }</div>
	</div>
</div>
<c:choose>
	<c:when test="${empty myFileList}">
	</c:when>
	<c:otherwise>
	<c:choose>
	<c:when test="${op=='verify'||op=='query'||op=='view'||op=='maintenance'||ch=='unpass'}">
		<div class="download">
<form action="DownloadServlet?method=zipFilesDownload" method="post">
	<div class="query_table_area">
			<div class="query_file_table_head">
				<table>
					<thead>
						<tr>
						    <th class="file_checkbox"></th>
							<th class="file_name_title">文件名称</th>
							<th class="filesize_title">文件大小</th>
							<th class="file_lastmodified_title">最后修改时间</th>
							<th colspan="2" class="file_operator">文件操作</th>
						</tr>
					</thead>
				</table>
			</div>
			<div class="query_file_table_body">
				<table>
					<tbody>
						<c:forEach items="${ myFileList }" var="myFile">
							<c:choose>
								<c:when test="${ myFile.fileType =='File' }">
									<tr>
									    <td class="file_checkbox"><input type="checkbox" name="downloadFile" value="${ myFile.filePath }" /></td>
										<td class="file_name">${ myFile.fileName }</td>
										<td class="file_size">${ myFile.fileSize }K</td>
										<td class="file_lastmodified">${ myFile.lastModified }</td>
										<td class="file_download"><a onclick="FtpDownload('DownloadServlet?method=singleFileDownload&path=${ myFile.filePath }')">下载</a></td>
										<td class="fileopen"></td>
									</tr>
								</c:when>
								<c:otherwise>
									<tr>
									    <td class="file_checkbox"></td>
										<td class="folder_name">${ myFile.fileName }</td>
										<td class="file_size">${ myFile.fileSize }M</td>
										<td class="file_lastmodified">${ myFile.lastModified }</td>
										<td class="file_download"></td>
										<td class="fileopen">
										<c:choose>
											<c:when test="${op=='query'||op=='view' }">
												<a onclick="javascript:urlEncode('PhotovoltaicGenerationProjectServlet?op=query&ch=${op}&id=${ idRow }&method=checkSubFiles&path=${ myFile.filePath }')">打开下级目录</a>		
											</c:when>
											<c:when test="${op=='verify' }">
												<a onclick="javascript:urlEncode('PhotovoltaicGenerationProjectServlet?op=verify&ch=${ idRow }&method=checkSubFiles&path=${ myFile.filePath }')">打开下级目录</a>
											</c:when>
											<c:when test="${ch=='unpass' }">
												<a onclick="javascript:urlEncode('PhotovoltaicGenerationProjectServlet?op=update&ch=unpass&id=${ idRow }&method=checkSubFiles&path=${ myFile.filePath }')">打开下级目录</a>
											</c:when>
											<c:when test="${op=='maintenance' }">
												<a onclick="javascript:urlEncode('PhotovoltaicGenerationProjectServlet?op=maintenance&id=${ idRow }&ch=open&method=checkSubFiles&path=${ myFile.filePath }')">打开下级目录</a>
											</c:when>
											<c:otherwise></c:otherwise>
										</c:choose>
										</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="download_menu">
		    <a class="btn btn-default download_btn" onclick="zipFileDownload()">一键下载全部选中文件</a>
			<c:choose>
				<c:when test="${ currentPath eq initPath || currentPath == '' }">
				<c:choose>
					<c:when test="${op=='query'||op=='view' }">	
					<a class="btn btn-default back_to_parent_btn" disabled onclick="javascript:urlEncode('PhotovoltaicGenerationProjectServlet?op=query&ch=${op}&id=${ idRow }&method=checkParentFolder&currentPath=${ currentPath }')">返回上一级目录</a>
					</c:when>
					<c:when test="${op=='verify' }">
					<a class="btn btn-default back_to_parent_btn" disabled onclick="javascript:urlEncode('PhotovoltaicGenerationProjectServlet?op=verify&ch=${ idRow }&method=checkParentFolder&currentPath=${ currentPath }')">返回上一级目录</a>
					</c:when>
					<c:when test="${ch=='unpass' }">
					<a class="btn btn-default back_to_parent_btn" disabled onclick="javascript:urlEncode('PhotovoltaicGenerationProjectServlet?op=update&ch=unpass&id=${ idRow }&method=checkParentFolder&currentPath=${ currentPath }')">返回上一级目录</a>
					</c:when>
					<c:when test="${op=='maintenance' }">
					<a class="btn btn-default back_to_parent_btn" disabled onclick="javascript:urlEncode('PhotovoltaicGenerationProjectServlet?op=maintenance&ch=open&id=${ idRow }&method=checkParentFolder&currentPath=${ currentPath }')">返回上一级目录</a>
					</c:when>
					<c:otherwise></c:otherwise>
				</c:choose>
				</c:when>
				<c:otherwise>
					<c:choose>
					<c:when test="${op=='query'||op=='view' }">	
					<a class="btn btn-default back_to_parent_btn" onclick="javascript:urlEncode('PhotovoltaicGenerationProjectServlet?op=query&ch=${op}&id=${ idRow }&method=checkParentFolder&currentPath=${ currentPath }')">返回上一级目录</a>
					</c:when>
					<c:when test="${op=='verify' }">
					<a class="btn btn-default back_to_parent_btn" onclick="javascript:urlEncode('PhotovoltaicGenerationProjectServlet?op=verify&ch=${ idRow }&method=checkParentFolder&currentPath=${ currentPath }')">返回上一级目录</a>
					</c:when>
					<c:when test="${ch=='unpass' }">
					<a class="btn btn-default back_to_parent_btn" onclick="javascript:urlEncode('PhotovoltaicGenerationProjectServlet?op=update&ch=unpass&id=${ idRow }&method=checkParentFolder&currentPath=${ currentPath }')">返回上一级目录</a>
					</c:when>
					<c:when test="${op=='maintenance' }">
					<a class="btn btn-default back_to_parent_btn" onclick="javascript:urlEncode('PhotovoltaicGenerationProjectServlet?op=maintenance&ch=open&id=${ idRow }&method=checkParentFolder&currentPath=${ currentPath }')">返回上一级目录</a>
					</c:when>
					<c:otherwise></c:otherwise>
				</c:choose>
				</c:otherwise>
			</c:choose>
		</div>
	</form>
</div>
	</c:when>
</c:choose>
	</c:otherwise>
</c:choose>
<%@include file="footer.jsp" %>