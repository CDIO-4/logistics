<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
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
<style type="text/css">
	ol,ul{list-style:none;padding:0;margin:0;}
	blockquote,q{quotes:none;}
	blockquote:before,blockquote:after,q:before,q:after{content:'';content:none;}
	table{border-collapse:collapse;border-spacing:0;}
	a{text-decoration:none;}
	.txt-rt{text-align:right;}
	.txt-lt{text-align:left;}
	.txt-center{text-align:center;}
	.float-rt{float:right;}
	.float-lt{float:left;}
	.clear{clear:both;}
	.pos-relative{position:relative;}
	.pos-absolute{position:absolute;}
	.vertical-base{vertical-align:baseline;}
	.vertical-top{vertical-align:top;}
	.underline{	padding-bottom:3px;	border-bottom: 1px solid #eee;}
	nav.vertical ul li{display:block;}
	nav.horizontal ul li{display: inline-block;}
	img{max-width:100%;}

/*-- Reset Code --*/



/*-- Index-Page-Styling --*/

body {
    font-family: 'Roboto', sans-serif;
    text-align: center;
    background: url("../sport_admin/assets/img/background.jpg");
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center;
    background-size: cover;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
}

body a {
    transition:0.5s all;
    -webkit-transition:0.5s all;
    -moz-transition:0.5s all;
    -o-transition:0.5s all;
    -ms-transition:0.5s all;
    text-decoration: none;
}

h1 {
    font-size: 45px;
    font-weight: 500;
    letter-spacing: 4px;
    margin: 60px 0;
    color: #FFFFFF;
}

.container {
    width: 50%;
    margin: 0 auto;
    padding: 40px;
    background-color: rgba(10, 10, 10, 0.77);
    border: 2px ridge rgba(238, 238, 238, 0.13);
    border-radius: 5px;
    -moz-box-shadow: 0 -5px 10px 1px rgba(16, 16, 16, 0.57);
    -webkit-box-shadow: 0 -5px 10px 1px rgba(16, 16, 16, 0.57);
    box-shadow: 0 -5px 10px 1px rgba(16, 16, 16, 0.57);
    border-bottom: none;
    border-bottom-left-radius: initial;
    border-bottom-right-radius: initial;
}

.login {
    width: 45%;
    float: left;
    text-align: left;
    padding-right: 40px;
}

::-webkit-input-placeholder {
    color: #CCC;
}

:-moz-placeholder {
    color: #CCC;
}

::-moz-placeholder {
    color: #CCC;
}

:-ms-input-placeholder {
    color: #CCC;
}

h2 {
    font-size: 35px;
    text-align: left;
    color: #FFF;
    font-weight: 100;
    margin-bottom: 20px;
}

ul.tick {
    float: left;
    list-style: none;
    display: inline-block;
    width: 100%;
    margin-bottom: 20px;
}

ul.tick li input[type="checkbox"] {
    display: none;
}

ul.tick li input[type="checkbox"]+label {
    position: relative;
    padding-left: 30px;
    border: #F0F8FF;
    display: inline-block;
    font-size: 13px;
    color: #EEE;
}

ul.tick li input[type="checkbox"]+label span:first-child {
    width: 17px;
    height: 17px;
    display: inline-block;
    border: 1px solid #EEE;
    position: absolute;
    top: -3px;
    left: 0;
    bottom: 4px;
}

ul.tick li input[type="checkbox"]:checked+label span:first-child:before {
    content: "";
    background: url(../img/tick.png)no-repeat;
    position: absolute;
    left: 3px;
    top: 3px;
    font-size: 10px;
    width: 10px;
    height: 10px;
}

.social-icons {
    margin-top: 20px;
    text-align: center;
}

.social-icons p {
    color: #CCC;
    margin-bottom: 15px;
}

.social-icons ul li {
    float: left;
    width: 32.9%;
}
.copyrights{text-indent:-9999px;height:0;line-height:0;font-size:0;overflow:hidden;}
li.twt {
    margin: 0 2px;
}

.social-icons ul li a {
    display:block;
}

.social-icons ul li a span {
    vertical-align: middle;
    color: #fff;
    font-size: 15px;
}

.social-icons ul li span.icons {
    background: url("../images/i1.png") no-repeat center;
    width: 30px;
    height: 30px;
    display: inline-block;
}

.social-icons ul li.weixin span.icons {
    background: url("../images/weixin.png") no-repeat;
    background-size: 100%;
}
.social-icons ul li.qq span.icons {
    background: url("../images/QQ.png") no-repeat;
    background-size: 100%;
}
.social-icons ul li.weibo span.icons {
    /*--w3layouts--*/
    /*--agileits--*/
    background: url("../images/weibo.png") no-repeat;
    background-size: 100%;
}

.social-icons ul li a:hover span.icons {
    transform: rotatey(360deg);
    -webkit-transform: rotatey(360deg);
    -o-transform: rotatey(360deg);
    -moz-transform: rotatey(360deg);
    -ms-transform: rotatey(360deg);
    transition: .5s all;
}

input[type="text"], input[type="password"] {
    width: 93.4%;
    margin-bottom: 20px;
    padding: 10px;
    float: left;
    background-color: transparent;
    border: none;
    font-size: 15px;
    border-bottom: 1px solid rgba(238, 238, 238, 0.41);
    outline: none;
    color: #FFF;
}

.send-button {
    margin-bottom: 20px;
}

.send-button input[type="submit"] {
    width: 60%;
    padding: 10px 0;
    font-size: 16px;
    font-weight: 100;
    background-color: transparent;
    color: #CCC;
    border: 1px solid rgba(238, 238, 238, 0.41);
    border-width: thin;
    cursor: pointer;
    outline: none;
    transition:0.5s all;
    -webkit-transition:0.5s all;
    -moz-transition:0.5s all;
    -o-transition:0.5s all;
    -ms-transition:0.5s all;
    text-decoration: none;
}

/*--w3layouts--*/
/*--agileits--*/
.send-button input[type="submit"]:hover {
    background-color: #000;
    border: 1px solid #FFF;
    color: #FFF;
    transition:0.5s all;
    -webkit-transition:0.5s all;
    -moz-transition:0.5s all;
    -o-transition:0.5s all;
    -ms-transition:0.5s all;
    text-decoration: none;
}

.login a {
    color: #CCC;
}

.login a:hover {
    color: #FFF;
}

.register {
    width: 44%;
    float: left;
    border-left: 1px solid #DDD;
    padding-left: 40px;
    text-align: left;
}

.register p {
    color: #CCC;
    margin-bottom: 10px;
}

.register p a {
    color: #CCC;
}

.register p a:hover {
    color: #FFF;
}

.footer {
    text-align: center;
    margin: 100px 20px 20px;
}
.footer p {
    color: #CCC;
    line-height: 25px;
    /*--w3layouts--*/
    /*--agileits--*/
}
.footer a {
    color: #CCC;
    text-decoration: none;
}
.footer a:hover {
    color: #FFF;
}

/*-- Index-Page-Styling --*/









/*--- Responsive Code ---*/



@media screen and (max-width: 1920px) {
    h1 {
        margin: 100px 0;
    }
}

@media screen and (max-width: 1600px) {
    h1 {
        margin: 60px 0;
    }
}

@media screen and (max-width: 1440px) {
    .container {
        width: 53%;
    }
}

@media screen and (max-width: 1366px) {
    h1 {
        margin: 50px 0;
    }
    .container {
        width: 57%;
    }
    /*--w3layouts--*/
    /*--agileits--*/
}

@media screen and (max-width: 1280px) {
    .container {
        width: 60%;
    }
}

@media screen and (max-width: 1024px) {
    .container {
        width: 76%;
    }
}

@media screen and (max-width: 966px) {
    .container {
        width: 80%;
    }
    .footer {
        margin: 50px 20px 20px;
    }
}

@media screen and (max-width: 853px) {
    .login {
        padding-right: 36px;
    }
    .register {
        padding-left: 36px;
    }
    .social-icons ul li {
        width: 32.8%;
    }
    .register p {
        font-size: 14px;
    }
}

@media screen and (max-width: 800px) {
    h1 {
        font-size: 43px;
    }
    .login {
        padding-right: 35px;
    }
    .register {
        padding-left: 34px;
    }
    .social-icons ul li span.icons {
        width: 28px;
    }
}

@media screen and (max-width: 768px) {
    .container {
        width: 85%;
    }
    .register p {
        font-size: 13.8px;
    }
}

@media screen and (max-width: 736px) {
    h1 {
        font-size: 40px;
    }
    .container {
        width: 87%;
        padding: 35px;
    }
    .login {
        padding-right: 34px;
    }
    .register {
        padding-left: 33px;
    }
    .social-icons ul li a span {
        font-size: 14px;
    }
    .register p {
        font-size: 13.2px;
    }
}

@media screen and (max-width: 667px) {
    h1 {
        font-size: 35px;
        letter-spacing: 3px;
    }
    .container {
        width: 55%;
        padding: 50px;
    }
    .login {
        padding: 0;
        width: 100%;
        margin-bottom: 50px;
    }
    .register {
        padding: 40px 0 0 0;
        width: 100%;
        border: none;
        border-top: 1px solid #DDD;
    }
}

@media screen and (max-width: 603px) {
    h1 {
        letter-spacing: 2px;
    }
}

@media screen and (max-width: 568px) {
    h1 {
        letter-spacing: 1px;
        margin: 30px 0;
    }
    .container {
        width: 60%;
        padding: 40px;
    }
}

@media screen and (max-width: 533px) {
    h1 {
        font-size: 32px;
    }
}

@media screen and (max-width: 480px) {
    .container {
        width: 70%;
        padding: 35px;
    }
    .send-button input[type="submit"] {
        width: 50%;
        padding: 8px 0;
    }
}

@media screen and (max-width: 414px) {
    h1 {
        font-size: 30px;
    }
    .container {
        width: 75%;
        padding: 25px;
    }
    .login {
        margin-bottom: 30px;
    }
    h2 {
        font-size: 30px;
        margin-bottom: 15px;
    }
    .register {
        padding: 30px 0 0 0;
    }
    .footer p {
        font-size: 14px;
    }
}

@media screen and (max-width: 384px) {
    h1 {
        letter-spacing: 0px;
    }
}

@media screen and (max-width: 375px) {
    .social-icons ul li span.icons {
        width: 27px;
    }
    .register p {
        font-size: 13px;
        line-height: 23px;
    }
}

@media screen and (max-width: 360px) {
    .container {
        width: 80%;
        padding: 20px;
    }
}

@media screen and (max-width: 320px) {
    .social-icons ul li {
        width: 32.7%;
    }
    .social-icons ul li span.icons {
        width: 25px;
    }
    .social-icons ul li a span {
        font-size: 12.4px;
    }
}


</style>
<!-- //Head -->

<!-- Body -->
<body>
	<div class="container w3layouts agileits" align="center"  style="margin-top:10%;">
		<div align="center"  style="width:40%;">
			<c:if test="${requestScope.login_result ne null }">
           <span style="color:#fff">账号或密码错误</span>
            </c:if>
			<form action="adminlogin" method="post">
				<input type="text" Name="admin.adminId" placeholder="用户名" required>
				<input type="password" Name="admin.adminPassword" placeholder="密码" required>
			<div class="tick w3layouts agileits" align="left">
			<ul>
				<li>
					<input type="checkbox" id="brand1" value="">
					<label for="brand1"><span style="color:#FFF">记住我</span></label>
				</li>
			</ul>
            </div>
            <div class="send-button w3layouts agileits">
					<input type="submit" value="登 录">
			</div>
			<a href="#">记住密码?</a>
			<div class="clear"></div>
			</form>
            
		</div>
        </div>
</body>
<!-- //Body -->

</html>