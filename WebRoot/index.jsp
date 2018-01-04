<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>登录表单</title>

	<!-- Meta-Tags -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- //Meta-Tags -->

	<!-- Style --> <link rel="stylesheet" href="css/style.css" type="text/css" media="all">



</head>
<!-- //Head -->

<!-- Body -->
<body>
	<div class="container w3layouts agileits" align="center"  style="margin-top:10%;">
		<div align="center"  style="width:40%;">
			<form action="#" method="post">
				<input type="text" Name="Userame" placeholder="用户名" required>
				<input type="password" Name="Password" placeholder="密码" required>
			</form>
            <div class="tick w3layouts agileits" align="left">
			<ul>
            
				<li>
					<input type="checkbox" id="brand1" value="">
					<label for="brand1"><span style="color:#FFF">记住我</span></label>
				</li>
			</ul>
            </div>
			<div class="send-button w3layouts agileits">
				<form>
					<input type="submit" value="登 录">
				</form>
			</div>
			<a href="#">记住密码?</a>
			<div class="clear"></div>
		</div>
        </div>
</body>
<!-- //Body -->

</html>