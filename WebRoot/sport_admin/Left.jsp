<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%String path=request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Amaze UI Admin index Examples</title>
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta name="renderer" content="webkit">
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="assets/css/amazeui.min.css"/>
<link rel="stylesheet" href="assets/css/admin.css">
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/app.js"></script>
</head>
<body>

<div style="width:100%;height:1000px;" class="nav-navicon admin-main admin-sidebar">
    
    
    <div class="sideMenu am-icon-dashboard" style="color:#aeb2b7; margin: 10px 0 0 0;font-size: 17px;"> 欢迎系统管理员：清风抚雪</div>
    <div class="sideMenu">
      <h3 class="am-icon-flag"><em></em> <a href="#">订单管理</a></h3>
      <ul>
        <li><a href="login.jsp" target="show">生成订单</a></li>
        <li><a href="login.jsp" target="show">查询订单</a></li>
        <li><a href="login.jsp" target="show">订单配送</a></li>
        <li><a href="login.jsp" target="show">订单接收</a></li>
      </ul>
     
      <h3 class="am-icon-users"><em></em> <a href="#">路线管理</a></h3>
      <ul>
        <li><a href="login.jsp" target="show">新增路线</a> </li>
        <li><a href="login.jsp" target="show">删除路线</a></li>
        <li><a href="login.jsp" target="show">查找路线</a></li>
      </ul>
       <h3 class="am-icon-cart-plus"><em></em> <a href="#"> 车辆管理</a></h3>
      <ul>
        <li><a href="CarList" target="show">车辆列表</a></li>
        <li><a href="car_add.jsp" target="show">新增车辆</a></li>
        
      </ul>
      <h3 class="am-icon-volume-up"><em></em> <a href="#">数据统计</a></h3>
      <ul>
        <li><a href="login.jsp" target="show">生成报表</a> </li>
      </ul>
      <h3 class="am-icon-gears"><em></em> <a href="#">问题订单处理</a></h3>
      <ul>
        <li><a href="login.jsp" target="show">修改订单信息</a></li>
        <li><a href="login.jsp" target="show">重新派送</a></li>
      </ul>
    </div>
    <!-- sideMenu End --> 
    
    <script type="text/javascript">
			jQuery(".sideMenu").slide({
				titCell:"h3", //鼠标触发对象
				targetCell:"ul", //与titCell一一对应，第n个titCell控制第n个targetCell的显示隐藏
				effect:"slideDown", //targetCell下拉效果
				delayTime:300 , //效果时间
				triggerTime:150, //鼠标延迟触发时间（默认150）
				defaultPlay:true,//默认是否执行效果（默认true）
				returnDefault:true //鼠标从.sideMen移走后返回默认状态（默认false）
				});
		</script> 

    
    
    
    
    
    
    
</div>

</body>
</html>