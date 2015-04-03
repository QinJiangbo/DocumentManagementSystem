<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
${msg}
	<div class="position">
		<span>当前位置：</span><span><a href="UserServlet?act=index">首页</a></span>&gt;<span><a href="store_record_maintenance.jsp">入库记录维护</a></span>
	</div>
	<form action="DataMaintenanceServlet?op=recordMaintenance&tableName=${tableName}" method="post">
		<div class="new_user_input_container">
			<div class="new_user_input_item_container">
				<div class="new_user_input_label">表名：</div>
				<div class="new_user_mixed_input_container">
				<span class="mixed_left_select">
					<select name="table_name" onchange="getPid()">
						<option value=""></option>
						<c:choose>
							<c:when test = "${tableName=='燃机项目'}">
								<option value="燃机项目" selected="selected">燃机项目</option>
							</c:when>
							<c:otherwise>
								<option value="燃机项目">燃机项目</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test = "${tableName=='燃煤项目'}">
								<option value="燃煤项目" selected="selected">燃煤项目</option>
							</c:when>
							<c:otherwise>
								<option value="燃煤项目">燃煤项目</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test = "${tableName=='光伏发电项目'}">
								<option value="光伏发电项目" selected="selected">光伏发电项目</option>
							</c:when>
							<c:otherwise>
								<option value="光伏发电项目">光伏发电项目</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test = "${tableName=='生物质、垃圾发电项目'}">
								<option value="生物质、垃圾发电项目" selected="selected">生物质、垃圾发电项目</option>
							</c:when>
							<c:otherwise>
								<option value="生物质、垃圾发电项目">生物质、垃圾发电项目</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test = "${tableName=='变电工程项目'}">
								<option value="变电工程项目" selected="selected">变电工程项目</option>
							</c:when>
							<c:otherwise>
								<option value="变电工程项目">变电工程项目</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test = "${tableName=='送电工程项目'}">
								<option value="送电工程项目" selected="selected">送电工程项目</option>
							</c:when>
							<c:otherwise>
								<option value="送电工程项目">送电工程项目</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test = "${tableName=='工程前期数据'}">
								<option value="工程前期数据" selected="selected">工程前期数据</option>
							</c:when>
							<c:otherwise>
								<option value="工程前期数据">工程前期数据</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test = "${tableName=='国内外规程规范及相关标准'}">
								<option value="国内外规程规范及相关标准" selected="selected">国内外规程规范及相关标准</option>
							</c:when>
							<c:otherwise>
								<option value="国内外规程规范及相关标准">国内外规程规范及相关标准</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test = "${tableName=='公司科技成果'}">
								<option value="公司科技成果" selected="selected">公司科技成果</option>
							</c:when>
							<c:otherwise>
								<option value="公司科技成果">公司科技成果</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test = "${tableName=='工程总结'}">
								<option value="工程总结" selected="selected">工程总结</option>
							</c:when>
							<c:otherwise>
								<option value="工程总结">工程总结</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test = "${tableName=='合同及技术协议'}">
								<option value="合同及技术协议" selected="selected">合同及技术协议</option>
							</c:when>
							<c:otherwise>
								<option value="合同及技术协议">合同及技术协议</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test = "${tableName=='设备及厂家资料'}">
								<option value="设备及厂家资料" selected="selected">设备及厂家资料</option>
							</c:when>
							<c:otherwise>
								<option value="设备及厂家资料">设备及厂家资料</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test = "${tableName=='技术文献'}">
								<option value="技术文献" selected="selected">技术文献</option>
							</c:when>
							<c:otherwise>
								<option value="技术文献">技术文献</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test = "${tableName=='煤质资料'}">
								<option value="煤质资料" selected="selected">煤质资料</option>
							</c:when>
							<c:otherwise>
								<option value="煤质资料">煤质资料</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test = "${tableName=='技经'}">
								<option value="技经" selected="selected">技经</option>
							</c:when>
							<c:otherwise>
								<option value="技经">技经</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test = "${tableName=='其他'}">
								<option value="其他" selected="selected">其他</option>
							</c:when>
							<c:otherwise>
								<option value="其他">其他</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test = "${tableName=='工程专家'}">
								<option value="工程专家" selected="selected">工程专家</option>
							</c:when>
							<c:otherwise>
								<option value="工程专家">工程专家</option>
							</c:otherwise>
						</c:choose>
					</select>
				</span>
				</div>
			</div>
		</div>
		<div class="new_user_input_container">
			<div class="new_user_input_item_container">
				<div class="new_user_input_label">项目编号：</div>
				<div class="new_user_mixed_input_container">
				<span class="mixed_left_select">
					<select onchange="this.parentNode.nextSibling.firstChild.value=this.value">
						<c:forEach items="${Rows }" var="row">
						<option value="${row['项目编号'] }">${row['项目编号'] }</option>
						</c:forEach>
					</select>
				</span><span class="mixed_left_input"><input type="text" name="pid" value="${pid }" /></span>
				</div>
			</div>
		</div>
		<div class="new_user_input_container">
			<div class="new_user_input_item_container">
				<div class="maintenance_placeholder"></div>
				<div class="new_user_input">
					<button class="btn btn-default maintenance_button">查询</button>
				</div>
			</div>
		</div>
		<div class="new_user_input_container">
			<div class="show_user_item_container">
			<div class="table_head">
			    <table class="table table-bordered table-hover table-condensed" contenteditable="false">
			    <thead>
			    	<tr>
		    		<c:choose>
						<c:when test = "${tableName=='燃机项目'}">
							<th class="col4">项目编号</th>
				        	<th class="col4">项目类别</th>
				        	<th class="col4">审核状态</th>
				        	<th class="col4">操作</th>
						</c:when>
						<c:when test = "${tableName=='燃煤项目'}">
							<th class="col4">项目编号</th>
				        	<th class="col4">项目类别</th>
				        	<th class="col4">审核状态</th>
				        	<th class="col4">操作</th>
						</c:when>
						<c:when test = "${tableName=='光伏发电项目'}">
							<th class="col4">项目编号</th>
				        	<th class="col4">项目类别</th>
				        	<th class="col4">审核状态</th>
				        	<th class="col4">操作</th>
						</c:when>
						<c:when test = "${tableName=='生物质、垃圾发电项目'}">
							<th class="col4">项目编号</th>
				        	<th class="col4">项目类别</th>
				        	<th class="col4">审核状态</th>
				        	<th class="col4">操作</th>
						</c:when>
						<c:when test = "${tableName=='变电工程项目'}">
							<th class="col4">项目编号</th>
				        	<th class="col4">项目类别</th>
				        	<th class="col4">审核状态</th>
				        	<th class="col4">操作</th>
						</c:when>
						<c:when test = "${tableName=='送电工程项目'}">
							<th class="col4">项目编号</th>
				        	<th class="col4">项目类别</th>
				        	<th class="col4">审核状态</th>
				        	<th class="col4">操作</th>
						</c:when>
						<c:when test = "${tableName=='工程前期数据'}">
							<th class="col4">序号</th>
				        	<th class="col4">类别</th>
				        	<th class="col4">审核状态</th>
				        	<th class="col4">操作</th>
						</c:when>
						<c:when test = "${tableName=='国内外规程规范及相关标准'}">
							<th class="col4">标准编号</th>
				        	<th class="col4">名称</th>
				        	<th class="col4">审核状态</th>
				        	<th class="col4">操作</th>
						</c:when>
						<c:when test = "${tableName=='公司科技成果'}">
							<th class="col4">名称</th>
				        	<th class="col4">专业</th>
				        	<th class="col4">审核状态</th>
				        	<th class="col4">操作</th>
						</c:when>
						<c:when test = "${tableName=='工程总结'}">
							<th class="col4">项目编号</th>
				        	<th class="col4">项目类别</th>
				        	<th class="col4">审核状态</th>
				        	<th class="col4">操作</th>
						</c:when>
						<c:when test = "${tableName=='合同及技术协议'}">
							<th class="col4">项目编号</th>
				        	<th class="col4">专业名称</th>
				        	<th class="col4">审核状态</th>
				        	<th class="col4">操作</th>
						</c:when>
						<c:when test = "${tableName=='设备及厂家资料'}">
							<th class="col4">设备名称</th>
				        	<th class="col4">厂家名称</th>
				        	<th class="col4">审核状态</th>
				        	<th class="col4">操作</th>
						</c:when>
						<c:when test = "${tableName=='技术文献'}">
							<th class="col4">名称</th>
				        	<th class="col4">专业</th>
				        	<th class="col4">审核状态</th>
				        	<th class="col4">操作</th>
						</c:when>
						<c:when test = "${tableName=='煤质资料'}">
							<th class="col4">标准编号</th>
				        	<th class="col4">工程名称</th>
				        	<th class="col4">审核状态</th>
				        	<th class="col4">操作</th>
						</c:when>
						<c:when test = "${tableName=='技经'}">
							<th class="col4">项目名称或编号</th>
				        	<th class="col4">类型</th>
				        	<th class="col4">审核状态</th>
				        	<th class="col4">操作</th>
						</c:when>
						<c:when test = "${tableName=='其他'}">
							<th class="col4">专家讲座</th>
				        	<th class="col4">审核状态</th>
				        	<th class="col4">操作</th>
						</c:when>
						<c:when test = "${tableName=='工程专家'}">
							<th class="col4">姓名</th>
				        	<th class="col4">身份证</th>
				        	<th class="col4">审核状态</th>
				        	<th class="col4">操作</th>
						</c:when>
						<c:otherwise>
							<th class="col4">项目编号</th>
				        	<th class="col4">项目类别</th>
				        	<th class="col4">审核状态</th>
				        	<th class="col4">操作</th>
						</c:otherwise>
					</c:choose>
				    </tr>
			    </thead>
			    </table>
			</div>
			<div class="table_body">
			     <table class="table table-bordered table-hover table-condensed" contenteditable="false">
			     <tbody>
					<c:forEach items="${rows }" var="row">
						<tr>
						<c:choose>
							<c:when test = "${tableName=='燃机项目'}">
								<td class="col4">${row['项目编号'] }</td>
								<td class="col4" class="col4">${row['项目类别'] }</td>
				        		<td class="col4">
				        		<c:choose>
				        			<c:when test="${row['审核状态']==-1}">
				        			未通过审核
				        			</c:when>
				        			<c:when test="${row['审核状态']==0}">
				        			保存
				        			</c:when>
				        			<c:when test="${row['审核状态']==1}">
				        			提交
				        			</c:when>
				        			<c:when test="${row['审核状态']==2}">
				        			审核通过
				        			</c:when>
				        		</c:choose>
				        		</td>
								<td class="col4"><a onclick="javascript:urlEncode2('${action}?op=query&ch=maintenance&id=${row['编号']}&method=init&projectType=燃机项目&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
							</c:when>
							<c:when test = "${tableName=='燃煤项目'}">
								<td class="col4">${row['项目编号'] }</td>
								<td class="col4">${row['项目类别'] }</td>
				        		<td class="col4">
				        		<c:choose>
				        			<c:when test="${row['审核状态']==-1}">
				        			未通过审核
				        			</c:when>
				        			<c:when test="${row['审核状态']==0}">
				        			保存
				        			</c:when>
				        			<c:when test="${row['审核状态']==1}">
				        			提交
				        			</c:when>
				        			<c:when test="${row['审核状态']==2}">
				        			审核通过
				        			</c:when>
				        		</c:choose>
				        		</td>
								<td class="col4"><a onclick="javascript:urlEncode2('${action}?op=query&ch=maintenance&id=${row['编号']}&method=init&projectType=燃煤项目&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
							</c:when>
							<c:when test = "${tableName=='光伏发电项目'}">
								<td class="col4">${row['项目编号'] }</td>
								<td class="col4">${row['项目类别'] }</td>
				        		<td class="col4">
				        		<c:choose>
				        			<c:when test="${row['审核状态']==-1}">
				        			未通过审核
				        			</c:when>
				        			<c:when test="${row['审核状态']==0}">
				        			保存
				        			</c:when>
				        			<c:when test="${row['审核状态']==1}">
				        			提交
				        			</c:when>
				        			<c:when test="${row['审核状态']==2}">
				        			审核通过
				        			</c:when>
				        		</c:choose>
				        		</td>
								<td class="col4"><a onclick="javascript:urlEncode2('${action}?op=query&ch=maintenance&id=${row['编号']}&method=init&projectType=光伏发电项目&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
							</c:when>
							<c:when test = "${tableName=='生物质、垃圾发电项目'}">
								<td class="col4">${row['项目编号'] }</td>
								<td class="col4">${row['项目类别'] }</td>
				        		<td class="col4">
				        		<c:choose>
				        			<c:when test="${row['审核状态']==-1}">
				        			未通过审核
				        			</c:when>
				        			<c:when test="${row['审核状态']==0}">
				        			保存
				        			</c:when>
				        			<c:when test="${row['审核状态']==1}">
				        			提交
				        			</c:when>
				        			<c:when test="${row['审核状态']==2}">
				        			审核通过
				        			</c:when>
				        		</c:choose>
				        		</td>
								<td class="col4"><a onclick="javascript:urlEncode2('${action}?op=query&ch=maintenance&id=${row['编号']}&method=init&projectType=生物质、垃圾发电项目&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
							</c:when>
							<c:when test = "${tableName=='变电工程项目'}">
								<td class="col4">${row['项目编号'] }</td>
								<td class="col4">${row['项目类别'] }</td>
				        		<td class="col4">
				        		<c:choose>
				        			<c:when test="${row['审核状态']==-1}">
				        			未通过审核
				        			</c:when>
				        			<c:when test="${row['审核状态']==0}">
				        			保存
				        			</c:when>
				        			<c:when test="${row['审核状态']==1}">
				        			提交
				        			</c:when>
				        			<c:when test="${row['审核状态']==2}">
				        			审核通过
				        			</c:when>
				        		</c:choose>
				        		</td>
								<td class="col4"><a onclick="$javascript:urlEncode2('{action}?op=query&ch=maintenance&id=${row['编号']}&method=init&projectType=变电工程项目&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
							</c:when>
							<c:when test = "${tableName=='送电工程项目'}">
								<td class="col4">${row['项目编号'] }</td>
								<td class="col4">${row['项目类别'] }</td>
				        		<td class="col4">
				        		<c:choose>
				        			<c:when test="${row['审核状态']==-1}">
				        			未通过审核
				        			</c:when>
				        			<c:when test="${row['审核状态']==0}">
				        			保存
				        			</c:when>
				        			<c:when test="${row['审核状态']==1}">
				        			提交
				        			</c:when>
				        			<c:when test="${row['审核状态']==2}">
				        			审核通过
				        			</c:when>
				        		</c:choose>
				        		</td>
								<td class="col4"><a onclick="javascript:urlEncode2('${action}?op=query&ch=maintenance&id=${row['编号']}&method=init&projectType=送电工程项目&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
							</c:when>
							<c:when test = "${tableName=='工程前期数据'}">
								<td class="col4">${row['序号'] }</td>
								<td class="col4">${row['类别'] }</td>
				        		<td class="col4">
				        		<c:choose>
				        			<c:when test="${row['审核状态']==-1}">
				        			未通过审核
				        			</c:when>
				        			<c:when test="${row['审核状态']==0}">
				        			保存
				        			</c:when>
				        			<c:when test="${row['审核状态']==1}">
				        			提交
				        			</c:when>
				        			<c:when test="${row['审核状态']==2}">
				        			审核通过
				        			</c:when>
				        		</c:choose>
				        		</td>
								<td class="col4"><a onclick="javascript:urlEncode2('${action}?op=query&ch=maintenance&id=${row['编号']}&method=init&projectType=工程前期数据&projectId=${row['序号']}')" target="_blank">查看</a></td>
							</c:when>
							<c:when test = "${tableName=='国内外规程规范及相关标准'}">
								<td class="col4">${row['标准编号'] }</td>
								<td class="col4">${row['名称'] }</td>
				        		<td class="col4">
				        		<c:choose>
				        			<c:when test="${row['审核状态']==-1}">
				        			未通过审核
				        			</c:when>
				        			<c:when test="${row['审核状态']==0}">
				        			保存
				        			</c:when>
				        			<c:when test="${row['审核状态']==1}">
				        			提交
				        			</c:when>
				        			<c:when test="${row['审核状态']==2}">
				        			审核通过
				        			</c:when>
				        		</c:choose>
				        		</td>
								<td class="col4"><a onclick="javascript:urlEncode2('${action}?op=query&ch=maintenance&id=${row['编号']}&method=init&projectType=国内外规程规范及相关标准&projectId=${row['标准编号']}')" target="_blank">查看</a></td>
							</c:when>
							<c:when test = "${tableName=='公司科技成果'}">
								<td class="col4">${row['名称'] }</td>
								<td class="col4">${row['专业'] }</td>
				        		<td class="col4">
				        		<c:choose>
				        			<c:when test="${row['审核状态']==-1}">
				        			未通过审核
				        			</c:when>
				        			<c:when test="${row['审核状态']==0}">
				        			保存
				        			</c:when>
				        			<c:when test="${row['审核状态']==1}">
				        			提交
				        			</c:when>
				        			<c:when test="${row['审核状态']==2}">
				        			审核通过
				        			</c:when>
				        		</c:choose>
				        		</td>
								<td class="col4"><a onclick="javascript:urlEncode2('${action}?op=query&ch=maintenance&id=${row['编号']}&method=init&projectType=公司科技成果&projectId=${row['名称']}')" target="_blank">查看</a></td>
							</c:when>
							<c:when test = "${tableName=='工程总结'}">
								<td class="col4">${row['项目编号'] }</td>
								<td class="col4">${row['项目类别'] }</td>
				        		<td class="col4">
				        		<c:choose>
				        			<c:when test="${row['审核状态']==-1}">
				        			未通过审核
				        			</c:when>
				        			<c:when test="${row['审核状态']==0}">
				        			保存
				        			</c:when>
				        			<c:when test="${row['审核状态']==1}">
				        			提交
				        			</c:when>
				        			<c:when test="${row['审核状态']==2}">
				        			审核通过
				        			</c:when>
				        		</c:choose>
				        		</td>
								<td class="col4"><a onclick="javascript:urlEncode2('${action}?op=query&ch=maintenance&id=${row['编号']}&method=init&projectType=工程总结&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
							</c:when>
							<c:when test = "${tableName=='合同及技术协议'}">
								<td class="col4">${row['项目编号'] }</td>
								<td class="col4">${row['专业名称'] }</td>
				        		<td class="col4">
				        		<c:choose>
				        			<c:when test="${row['审核状态']==-1}">
				        			未通过审核
				        			</c:when>
				        			<c:when test="${row['审核状态']==0}">
				        			保存
				        			</c:when>
				        			<c:when test="${row['审核状态']==1}">
				        			提交
				        			</c:when>
				        			<c:when test="${row['审核状态']==2}">
				        			审核通过
				        			</c:when>
				        		</c:choose>
				        		</td>
								<td class="col4"><a onclick="javascript:urlEncode2('${action}?op=query&ch=maintenance&id=${row['编号']}&method=init&projectType=合同及技术协议&projectId=${row['项目编号']}')" target="_blank">查看</a></td>
							</c:when>
							<c:when test = "${tableName=='设备及厂家资料'}">
								<td class="col4">${row['设备名称'] }</td>
								<td class="col4">${row['厂家名称'] }</td>
				        		<td class="col4">
				        		<c:choose>
				        			<c:when test="${row['审核状态']==-1}">
				        			未通过审核
				        			</c:when>
				        			<c:when test="${row['审核状态']==0}">
				        			保存
				        			</c:when>
				        			<c:when test="${row['审核状态']==1}">
				        			提交
				        			</c:when>
				        			<c:when test="${row['审核状态']==2}">
				        			审核通过
				        			</c:when>
				        		</c:choose>
				        		</td>
								<td class="col4"><a onclick="javascript:urlEncode2('${action}?op=query&ch=maintenance&id=${row['编号']}&method=init&projectType=设备及厂家资料&projectId=${row['设备名称']}')" target="_blank">查看</a></td>
							</c:when>
							<c:when test = "${tableName=='技术文献'}">
								<td class="col4">${row['名称'] }</td>
								<td class="col4">${row['专业'] }</td>
				        		<td class="col4">
				        		<c:choose>
				        			<c:when test="${row['审核状态']==-1}">
				        			未通过审核
				        			</c:when>
				        			<c:when test="${row['审核状态']==0}">
				        			保存
				        			</c:when>
				        			<c:when test="${row['审核状态']==1}">
				        			提交
				        			</c:when>
				        			<c:when test="${row['审核状态']==2}">
				        			审核通过
				        			</c:when>
				        		</c:choose>
				        		</td>
								<td class="col4"><a onclick="javascript:urlEncode2('${action}?op=query&ch=maintenance&id=${row['编号']}&method=init&projectType=技术文献&projectId=${row['名称']}')" target="_blank">查看</a></td>
							</c:when>
							<c:when test = "${tableName=='煤质资料'}">
								<td class="col4">${row['标准编号'] }</td>
								<td class="col4">${row['工程名称'] }</td>
				        		<td class="col4">
				        		<c:choose>
				        			<c:when test="${row['审核状态']==-1}">
				        			未通过审核
				        			</c:when>
				        			<c:when test="${row['审核状态']==0}">
				        			保存
				        			</c:when>
				        			<c:when test="${row['审核状态']==1}">
				        			提交
				        			</c:when>
				        			<c:when test="${row['审核状态']==2}">
				        			审核通过
				        			</c:when>
				        		</c:choose>
				        		</td>
								<td class="col4"><a onclick="javascript:urlEncode2('${action}?op=query&ch=maintenance&id=${row['编号']}&method=init&projectType=煤质资料&projectId=${row['标准编号']}')" target="_blank">查看</a></td>
							</c:when>
							<c:when test = "${tableName=='技经'}">
								<td class="col4">${row['项目名称或编号'] }</td>
								<td class="col4">${row['类型'] }</td>
				        		<td class="col4">
				        		<c:choose>
				        			<c:when test="${row['审核状态']==-1}">
				        			未通过审核
				        			</c:when>
				        			<c:when test="${row['审核状态']==0}">
				        			保存
				        			</c:when>
				        			<c:when test="${row['审核状态']==1}">
				        			提交
				        			</c:when>
				        			<c:when test="${row['审核状态']==2}">
				        			审核通过
				        			</c:when>
				        		</c:choose>
				        		</td>
								<td class="col4"><a onclick="javascript:urlEncode2('${action}?op=query&ch=maintenance&id=${row['编号']}&method=init&projectType=技经&projectId=${row['项目名称或编号']}')" target="_blank">查看</a></td>
							</c:when>
							<c:when test = "${tableName=='其他'}">
								<td class="col4">${row['专家讲座'] }</td>
				        		<td class="col4">
				        		<c:choose>
				        			<c:when test="${row['审核状态']==-1}">
				        			未通过审核
				        			</c:when>
				        			<c:when test="${row['审核状态']==0}">
				        			保存
				        			</c:when>
				        			<c:when test="${row['审核状态']==1}">
				        			提交
				        			</c:when>
				        			<c:when test="${row['审核状态']==2}">
				        			审核通过
				        			</c:when>
				        		</c:choose>
				        		</td>
								<td class="col4"><a onclick="javascript:urlEncode2('${action}?op=query&ch=maintenance&id=${row['编号']}&method=init&projectType=其他&projectId=${row['专家讲座']}')" target="_blank">查看</a></td>
							</c:when>
							<c:when test = "${tableName=='工程专家'}">
								<td class="col4">${row['姓名'] }</td>
								<td class="col4">${row['身份证'] }</td>
				        		<td class="col4">
				        		<c:choose>
				        			<c:when test="${row['审核状态']==-1}">
				        			未通过审核
				        			</c:when>
				        			<c:when test="${row['审核状态']==0}">
				        			保存
				        			</c:when>
				        			<c:when test="${row['审核状态']==1}">
				        			提交
				        			</c:when>
				        			<c:when test="${row['审核状态']==2}">
				        			审核通过
				        			</c:when>
				        		</c:choose>
				        		</td>
								<td class="col4"><a onclick="javascript:urlEncode2('${action}?op=query&ch=maintenance&id=${row['编号']}&method=init&projectType=工程专家&projectId=${row['身份证']}')" target="_blank">查看</a></td>
							</c:when>
							<c:otherwise>
								
							</c:otherwise>
						</c:choose>
						</tr>
					</c:forEach>
					</tbody>
					</table>
			</div>
			</div>
		</div>
		<div class="clearfix"></div>
	</form>
</div>
<%@include file="footer.jsp" %>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           