<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
${msg}
	<div class="position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a href="FileDiskServlet?method=init">文件管理</a></span>
	</div>
	<div class="file_container"> 
	<form action="FileDiskServlet?method=createNewFolder" method="post">
		<div class="filebar_top">
			<span class="filebar_top_path">当前路径：</span>
			<input type="text" disabled class="filebar_top_path_text" value="${ displayDir }" />
			<c:choose>
			<c:when test="${ currentPath eq rootPath }">
			    <button type="button" class="filebar_top_button" disabled onclick="javascript:urlEncode('FileDiskServlet?method=checkParentFolder&currentPath=${ currentPath }')">返回上级目录</button>
			</c:when>
			<c:otherwise>
			    <button type="button" class="filebar_top_button" onclick="javascript:urlEncode('FileDiskServlet?method=checkParentFolder&currentPath=${ currentPath }')">返回上级目录</button>
			</c:otherwise>
			</c:choose>
		</div>
		<div class="file_table_head">
			<table >
				<thead>
					<tr>
						<th class="file_manage_name_title">文件名称</th>
						<th class="filesize_title">文件大小</th>
						<th class="file_lastmodified_title">最后修改时间</th>
						<th colspan="2" class="file_operator">文件操作</th>
					</tr>
				</thead>
			</table>
		</div>
		<div class="file_table_body">
			<table >
				<tbody>
					<c:forEach items="${ myFileList }" var="myFile">
						<c:choose>
							<c:when test="${ myFile.fileType =='File' }">
								<tr>
									<td class="filename">${ myFile.fileName }</td>
									<td class="filesize">${ myFile.fileSize }K</td>
									<td class="lastmodified">${ myFile.lastModified }</td>
									<td class="filedel"><a  onclick="javascript:deleteAlert('FileDiskServlet?method=deleteFile&path=${ myFile.filePath }&currentPath=${ currentPath }');">删除文件</a></td>
									<td class="fileopen"></td>
								</tr>
							</c:when>
							<c:otherwise>
							    <tr>
									<td class="foldername">${ myFile.fileName }</td>
									<td class="filesize">${ myFile.fileSize }M</td>
									<td class="lastmodified">${ myFile.lastModified }</td>
									<td class="filedel"><a onclick="javascript:deleteAlert('FileDiskServlet?method=deleteFolder&path=${ myFile.filePath }&currentPath=${ currentPath }');">删除文件夹</a></td>
									<td class="fileopen"><a onclick="javascript:urlEncode('FileDiskServlet?method=checkSubFiles&path=${ myFile.filePath }')">打开下级目录</a></td>
								</tr>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="filebar_bottom">
			<span class="filebar_bottom_path">新建文件夹：</span>
			<input type="hidden" name="currentPath" value="${ currentPath }">
			<input type="text" class="filebar_bottom_path_text" name="newFolder" />
			<input type="submit" class="filebar_bottom_button" value="确定" />
		</div>
		</form>
	</div>
</div>
<%@include file="footer.jsp" %>