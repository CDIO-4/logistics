<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Amaze UI Admin index Examples</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="/sport_adminimage/png" href="../sport_admin/assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="../sport_admin/assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="../sport_admin/assets/css/amazeui.min.css" />
<link rel="stylesheet" href="../sport_admin/assets/css/admin.css">
<script src="../sport_admin/assets/js/jquery.min.js"></script>
<script src="../sport_admin/assets/js/app.js"></script>
<style type="text/css">
p{
color:red;
font-size: 13px;
position:relative;
left:360px;
top:-38px;
display:none;

}
span{
color:red;
font-size: 13px;
position:relative;
left:360px;
top:-38px;
display:none;
}

</style>
<script type="text/javascript">
function checknull() {
	var p=document.getElementsByTagName("p");
	var input=document.getElementsByTagName("input");
	var textarea=document.getElementsByTagName("textarea");
	var span=document.getElementsByTagName("span");
	if(textarea[0].value==""){
		span[0].style.display="block";
		return false;
	}else{
		span[0].style.display="none";
	}
	for(var i=0;i<input.length;i++){
		if(input[i].value==""){
			p[i].style.display="block";
			return false;
		}else{
			p[i].style.display="none";
		}
	}
	return true;
	
	
}
</script>
</head>
<body>
	<!--[if lte IE 9]><p class="browsehappy">升级你的浏览器吧！ <a href="http://se.360.cn/" target="_blank">升级浏览器</a>以获得更好的体验！</p><![endif]-->
</head>

<body>
	<div class="admin-biaogelist">

				<div class="listbiaoti am-cf">
					<ul class="am-icon-flag on">栏目名称
					</ul>

					<dl class="am-icon-home" style="float: right;">
						当前位置： 首页 >
						<a href="#">新增车辆</a>
					</dl>



				</div>

				<div class="fbneirong">
					<form class="am-form" action="addCar" method="post" onSubmit="return checknull();">
						<div class="am-form-group am-cf">
							<div class="zuo">车牌号：</div>
							<div class="you">
								<input  type="text" name="car.carId" class="am-input-sm" id="doc-ipt-email-1"
									placeholder="如：冀D ZX0001">
									<p>该项不可为空!</p>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">车型：</div>
							<div class="you">
								<input type="text" name="car.carModel" class="am-input-sm" id="doc-ipt-pwd-1"
									placeholder="请输具体车型">
									<p>该项不可为空!</p>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">车辆描述：</div>
							<div class="you">
								<textarea name="car.description" class="am-input-sm" rows="3" id="doc-ta-1"></textarea>
								<span>该项不可为空!</span>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="zuo">车重：</div>
							<div class="you">
								<input type="text" name="car.carweight" class="am-input-sm" id="doc-ipt-file-1" placeholder="必填：单位为吨（T）">
								<p>该项不可为空!</p>
							</div>
						</div>

						<div class="am-form-group am-cf">
							<div class="zuo">车况：</div>
							<div class="you" style="height: 45px;">
								<input name="car.carState" class="am-input-sm" type="text"  placeholder="必填：优秀/良好/修理中" id="doc-ipt-file-1">
								<p>该项不可为空!</p>
							</div>
						</div>


						<div class="am-form-group am-cf">
							<div class="zuo">司机姓名：</div>
							<div class="you">
								<input  placeholder="必填"name="car.driverId" class="am-input-sm" type="text" id="doc-ipt-file-1">
								<p>该项不可为空!</p>
							</div>
						</div>

						<div class="am-form-group am-cf">
							<div class="zuo">司机电话：</div>
							<div class="you">
								<input  placeholder="必填"name="car.driverphone" class="am-input-sm" type="text" id="doc-ipt-file-1">
								<p>该项不可为空!</p>
							</div>
						</div>


						<div class="am-form-group am-cf">
							<div class="zuo">司机住址：</div>
							<div class="you">
								<input name="car.driveradress"  placeholder="必填" class="am-input-sm" type="text" id="doc-ipt-file-1">
								<p>该项不可为空</p>
							</div>
						</div>
						<div class="am-form-group am-cf">
							<div class="you" style="margin-left: 11%;">
								<button type="submit"  class="am-btn am-btn-success am-radius">保存车辆信息</button>
								&nbsp; &raquo; &nbsp;
								<button type="reset" class="am-btn am-btn-secondary am-radius">重置车辆信息</button>

							</div>
						</div>
					</form>
				</div>



				<div class="foods">
					
				</div>




			</div>


</body>
</html>