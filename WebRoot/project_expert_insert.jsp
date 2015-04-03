<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
${msg}
	<div class="position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a href="project_expert_insert.jsp">工程专家录入</a></span>
	</div>
	<form action="ProjectExpertServlet?op=add" method="post" onsubmit="return pidCheck()">
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">姓名：</div>
				<div class="fuel_machine_project_input">
				<input type="hidden" name="id" value="${idRow }"/>
				<input type="text" name="name" value="${nameRow }" /></div>
			</div>
		</div>
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">专业 ：</div>
				<div class="mixed_input_container">
				<span class="mixed_right_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${ professionRows }" var="row">
						      <option value="${row['专业'] }">${row['专业'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_right_input"><input type="text" name="profession" value="${professionRow }" /></span>
				</div>
			</div>
		</div>
	</div>
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">所在单位：</div>
				<div class="fuel_machine_project_input"><input type="text" name="department" value="${departmentRow }" /></div>
			</div>
		</div>
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">学历 ：</div>
				<div class="mixed_input_container">
				<span class="mixed_right_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${ educationBackgroundRows }" var="row">
						      <option value="${row['学历'] }">${row['学历'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_right_input"><input type="text" name="education_background" value="${educationBackgroundRow }" /></span>
				</div>
			</div>
		</div>
	</div>
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">毕业学校：</div>
				<div class="fuel_machine_project_input"><input type="text" name="graduation_school" value="${graduationSchoolRow }" /></div>
			</div>
		</div>
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">参加工作时间 ：</div>
				<div class="fuel_machine_project_input"><input type="text" name="working_time" value="${workingTimeRow }" /></div>
			</div>
		</div>
	</div>
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">身份证：</div>
				<div class="fuel_machine_project_input"><input type="number" name="identified_card" value="${identifiedCardRow }" /></div>
			</div>
		</div>
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">职务 ：</div>
				<div class="fuel_machine_project_input"><input type="text" name="job" value="${jobRow }" /></div>
			</div>
		</div>
	</div>
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">职称：</div>
				<div class="mixed_input_container">
				<span class="mixed_right_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${ jobTitleRows }" var="row">
						      <option value="${row['职称'] }">${row['职称'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_right_input"><input type="text" name="job_title" value="${jobTitleRow }" /></span>
				</div>
			</div>
		</div>
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">联系电话：</div>
				<div class="fuel_machine_project_input"><input type="tel" name="contact_number" value="${contactNumberRow }" /></div>
			</div>
		</div>
	</div>
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">手机：</div>
				<div class="fuel_machine_project_input"><input type="tel" name="telephone" value="${telephoneRow }" /></div>
			</div>
		</div>
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">传真：</div>
				<div class="fuel_machine_project_input"><input type="number" name="fax" value="${faxRow }" /></div>
			</div>
		</div>
	</div>
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">E-mail：</div>
				<div class="fuel_machine_project_input"><input type="email" name="email" value="${emailRow }" /></div>
			</div>
		</div>
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">通讯地址：</div>
				<div class="fuel_machine_project_input"><input type="text" name="mailing_address" value="${mailingAddressRow }" /></div>
			</div>
		</div>
	</div>
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">邮编：</div>
				<div class="fuel_machine_project_input"><input type="text" name="postcode" value="${postcodeRow }" /></div>
			</div>
		</div>
		<div class="project_input_item_right">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_label">技术专长：</div>
				<div class="fuel_machine_project_input"><input type="text" name="technical_expertise" value="${technicalExpertiseRow }" /></div>
			</div>
		</div>
	</div>
	<div class="fuel_machine_project_input_container">
		<div class="project_input_item_left">
		<c:choose>
		<c:when test="${isPreparationOneUsed==1}">
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
				<div class="mixed_input_container">
				<span class="mixed_right_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${ preparationTwoRows }" var="row">
						          <option value="${ row['预留二'] }">${ row['预留二'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_right_input"><input type="text" name="preparation_two" value="${preparationTwoRow }" /></span>
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
				<div class="mixed_input_container">
				<span class="mixed_right_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<option value=""></option>
						<c:forEach items="${ preparationFourRows }" var="row">
						          <option value="${ row['预留四'] }">${ row['预留四'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_right_input"><input type="text" name="preparation_four" value="${preparationFourRow }" /></span>
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
		</c:when>
		<c:otherwise>
		</c:otherwise>
		</c:choose>
		</div>
	</div>
		<div class="fuel_machine_project_textArea_container">
		    <div class="project_input_item_container">
				<div class="fuel_machine_project_input_textArea_label">工作简历：</div>
				<div class="fuel_machine_project_input_textArea">
					<textArea class="fuel_machine_project_input" name="job_resume"></textArea>
				</div>
			</div>
		</div>
		<div class="fuel_machine_project_textArea_container">
		<div class="project_input_item_container">
			<div class="fuel_machine_project_input_textArea_label">主要业绩：</div>
			<div class="fuel_machine_project_input_textArea"><textArea class="fuel_machine_project_input" name="main_performance"></textArea></div>
		</div>
	</div>
		<div class="fuel_machine_project_textArea_container">
			<div class="project_input_item_container">
				<div class="fuel_machine_project_input_textArea_label">获奖情况：</div>
				<div class="fuel_machine_project_input_textArea">
					<textArea class="fuel_machine_project_input" name="awards"></textArea>
				</div>
			</div>
		</div>
		<div class="fuel_machine_project_textArea_container">
		<div class="project_input_item_container">
			<div class="fuel_machine_project_input_textArea_label">著作及论文：</div>
			<div class="fuel_machine_project_input_textArea"><textArea class="fuel_machine_project_input" name="papers"></textArea></div>
		</div>
	</div>
	<div class="fuel_machine_project_textArea_container">
		<div class="project_input_item_container">
			<div class="fuel_machine_project_input_textArea_label">备注：</div>
			<div class="fuel_machine_project_input_textArea"><textArea class="fuel_machine_project_input" name="remark"></textArea></div>
		</div>
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
												<a onclick="javascript:urlEncode('ProjectExpertServlet?op=query&ch=${op}&id=${ idRow }&method=checkSubFiles&path=${ myFile.filePath }')">打开下级目录</a>		
											</c:when>
											<c:when test="${op=='verify' }">
												<a onclick="javascript:urlEncode('ProjectExpertServlet?op=verify&ch=${ idRow }&method=checkSubFiles&path=${ myFile.filePath }')">打开下级目录</a>
											</c:when>
											<c:when test="${ch=='unpass' }">
												<a onclick="javascript:urlEncode('ProjectExpertServlet?op=update&ch=unpass&id=${ idRow }&method=checkSubFiles&path=${ myFile.filePath }')">打开下级目录</a>
											</c:when>
											<c:when test="${op=='maintenance' }">
												<a onclick="javascript:urlEncode('ProjectExpertServlet?op=maintenance&id=${ idRow }&ch=open&method=checkSubFiles&path=${ myFile.filePath }')">打开下级目录</a>
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
					<a class="btn btn-default back_to_parent_btn" disabled onclick="javascript:urlEncode('ProjectExpertServlet?op=query&ch=${op}&id=${ idRow }&method=checkParentFolder&currentPath=${ currentPath }')">返回上一级目录</a>
					</c:when>
					<c:when test="${op=='verify' }">
					<a class="btn btn-default back_to_parent_btn" disabled onclick="javascript:urlEncode('ProjectExpertServlet?op=verify&ch=${ idRow }&method=checkParentFolder&currentPath=${ currentPath }')">返回上一级目录</a>
					</c:when>
					<c:when test="${ch=='unpass' }">
					<a class="btn btn-default back_to_parent_btn" disabled onclick="javascript:urlEncode('ProjectExpertServlet?op=update&ch=unpass&id=${ idRow }&method=checkParentFolder&currentPath=${ currentPath }')">返回上一级目录</a>
					</c:when>
					<c:when test="${op=='maintenance' }">
					<a class="btn btn-default back_to_parent_btn" disabled onclick="javascript:urlEncode('ProjectExpertServlet?op=maintenance&ch=open&id=${ idRow }&method=checkParentFolder&currentPath=${ currentPath }')">返回上一级目录</a>
					</c:when>
					<c:otherwise></c:otherwise>
				</c:choose>
				</c:when>
				<c:otherwise>
					<c:choose>
					<c:when test="${op=='query'||op=='view' }">	
					<a class="btn btn-default back_to_parent_btn" onclick="javascript:urlEncode('ProjectExpertServlet?op=query&ch=${op}&id=${ idRow }&method=checkParentFolder&currentPath=${ currentPath }')">返回上一级目录</a>
					</c:when>
					<c:when test="${op=='verify' }">
					<a class="btn btn-default back_to_parent_btn" onclick="javascript:urlEncode('ProjectExpertServlet?op=verify&ch=${ idRow }&method=checkParentFolder&currentPath=${ currentPath }')">返回上一级目录</a>
					</c:when>
					<c:when test="${ch=='unpass' }">
					<a class="btn btn-default back_to_parent_btn" onclick="javascript:urlEncode('ProjectExpertServlet?op=update&ch=unpass&id=${ idRow }&method=checkParentFolder&currentPath=${ currentPath }')">返回上一级目录</a>
					</c:when>
					<c:when test="${op=='maintenance' }">
					<a class="btn btn-default back_to_parent_btn" onclick="javascript:urlEncode('ProjectExpertServlet?op=maintenance&ch=open&id=${ idRow }&method=checkParentFolder&currentPath=${ currentPath }')">返回上一级目录</a>
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