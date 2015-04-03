<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>中国电力建设工程咨询中南有限公司文档管理系统</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
	<!--link rel="stylesheet/less" href="less/bootstrap.less" type="text/css" /-->
	<!--link rel="stylesheet/less" href="less/responsive.less" type="text/css" /-->
	<!--script src="js/less-1.3.3.min.js"></script-->
	<!--append ‘#!watch’ to the browser URL, then refresh the page. -->
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">

  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
  <![endif]-->

  <!-- Fav and touch icons -->
  <link rel="shortcut icon" href="img/logo.png">
  
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/scripts.js"></script>
</head>
<body>
<%
	String UserName = (String)session.getAttribute("UserName");
	String run = (String)request.getAttribute("run");
	String dispatcher = (String)request.getAttribute("dispatcher");
	if(UserName==null){
		request.setAttribute("msg", "<script>alert('非法访问,请先登录！');</script>");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	else{
		if(dispatcher!=null){
		}
		else{
			if(run==null||!run.equals("1")){
				request.setAttribute("msg", "<script>alert('拒绝请求，此为非法访问！');</script>");
				request.setAttribute("dispatcher", "true");//判断是否已跳转，防止循环跳转
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
	}
%>
<div class="top_bar_container">
  <div class="top_bar">
  	<div class="top_bar_left">欢迎你，<%=UserName %>！</div>
  	<a class="top_bar_right" onclick="javascript:logout()"></a>
  </div>
</div>
<div class="banner"></div>
<div class="nav_bar_container">
	<div class="nav_bar">
  	<ul class="nav"> 
      <li><span>工程数据管理</span> 
        <ul> 
        <li><a href="ActionServlet?act=project_data&op=add">工程数据录入</a></li> 
        <li><a href="ActionServlet?act=project_data&op=query">工程数据查询</a></li>
        </ul> 
      </li> 
      <li><span>技术资料管理</span> 
        <ul> 
        <li><a href="ActionServlet?act=technology_essay&op=add">技术资料录入</a></li> 
        <li><a href="ActionServlet?act=technology_essay&op=query">技术资料查询</a></li>
        </ul> 
      </li> 
      <li><span>工程专家管理</span> 
        <ul> 
        <li><a href="ProjectExpertServlet?op=insert">工程专家录入</a></li> 
        <li><a href="ProjectExpertServlet?op=query">工程专家查询</a></li> 
        </ul> 
      </li> 
      <li><span><a href="ActionServlet?act=Undo&op=management">待办事宜</a></span> 
      <li><span>系统管理</span> 
        <ul> 
        <li><a href="ActionServlet?act=system_mangement&op=newUser">新建用户</a></li> 
        <li><a href="ActionServlet?act=system_mangement&op=showUser">用户显示</a></li> 
        <li><a href="ActionServlet?act=system_mangement&op=log">系统日志</a></li> 
        <li><a href="ActionServlet?act=system_mangement&op=dataMaintenance">数据维护</a></li> 
        <li><a href="ActionServlet?act=system_mangement&op=changePwd">修改密码</a></li>
        </ul> 
      </li>
    </ul>
	</div>
</div>