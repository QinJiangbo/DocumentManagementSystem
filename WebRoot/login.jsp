<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
  
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/scripts.js"></script>
</head>
<body class="login_bg">
${msg }
<div id="login_content">
<div class="login_block">
<div class="row clearfix">
		<div class="col-md-12 column" >
			<form action="UserServlet?act=login" method="post" onsubmit="return login_check()">
				<div id="login_container">
					<div class="form-group">
						<label for="name">用户名：</label>
						<input type="text" class="form-control login_input" id="name" name="name" />
						<span class="glyphicon glyphicon-user" id="user_icon"></span>
					</div>
					<div class="form-group">
						<label for="password">密码：</label>
						<input type="password" class="form-control login_input" id="pwd" name="pwd"/>
						<span class="glyphicon glyphicon-lock" id="pwd_icon"></span>
					</div>
					<br>
					<input type="submit" class="btn btn-primary" id="login_btn" value="登录"/>
					<br>
				</div>
			</form>
		</div>
	</div>
</div>
</div>
</body>
</html>
  