<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<link rel="icon" type="/sport_adminimage/png"
	href="../sport_admin/assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="../sport_admin/assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="../sport_admin/assets/css/amazeui.min.css" />
<link rel="stylesheet" href="../sport_admin/assets/css/admin.css">
<script src="../sport_admin/assets/js/jquery.min.js"></script>
<script src="../sport_admin/assets/js/app.js"></script>
</head>

<body>
	<div class="am-cf admin-main">
		<div class="admin-biaogelist">

			<div class="listbiaoti am-cf">
				<ul class="am-icon-flag on">栏目名称
				</ul>

				<dl class="am-icon-home" style="float: right;">
					当前位置： 首页 >
					<a href="#">商品列表</a>
				</dl>

				<dl>
					<button type="button"
						class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus">
						添加产品</button>
				</dl>


			</div>
			<form action="CarList" method="post">

				<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
					<ul>
						<li><span
							style="font-size:18px;color:#9a9c98;position:relative;top:-3px;">Search&nbsp;:</span>

						</li>
						<li><input
							style="width:150px;height:25px;position:relative;top:-3px;"
							type="text" name="carNumber" value="<s:property value="%{carNumber}"/>" placeholder="输入车牌号"
							class="am-input-sm" id="doc-ipt-email-1"></li>
						<li><input
							style="width:150px;height:25px;position:relative;top:-3px;"
							type="text" value="<s:property value="%{carModel}"/>" name="carModel" placeholder="输入车型"
							class="am-input-sm" id="doc-ipt-email-1"></li>
						<span
							style="font-size:14px;color:#9a9c98;position:relative;left:-340px;">载重&nbsp;:</span>
						<li style="margin-left: 50px;margin-right: 30px;"><input
							style="width:100px;height:25px;position:relative;top:-3px;"
							type="text" name="weightLow" value="<s:property value="%{weightLow}"/>" placeholder="载重下限"
							class="am-input-sm" id="doc-ipt-email-1"></li>
						<li style="font-size:20px;color:#9a9c98;position:relative;top:-3px;margin-left: -22px;">~</li>
						<li style="margin-left: -4px;"><input
							style="width:100px;height:25px;position:relative;top:-3px;"
							type="text" value="<s:property value="%{weightHight}"/>" name="weightHight" placeholder="载重上限"
							class="am-input-sm" id="doc-ipt-email-1"></li>


						<li><input type="submit"
								class="am-btn am-radius am-btn-xs am-btn-success"
								style="margin-top: -5px;" value="搜索"></li>
					</ul>
				</div>
			</form>


			<form class="am-form am-g">
				<table width="100%"
					class="am-table am-table-bordered am-table-radius am-table-striped">
					<thead>
						<tr class="am-success">
							<th class="table-check"><input type="checkbox" /></th>
							<th class="table-id" style="width:15%">车牌号</th>
							<th class="table-id" style="width:150px">车辆型号</th>
							<th class="table-title" style="width:50px">车辆载重</th>
							<th class="table-type" style="width:100px">司机姓名</th>
							<th class="table-author am-hide-sm-only" style="width:100px">车况
								<i class="am-icon-check am-text-warning"></i> <i
								class="am-icon-close am-text-primary"></i>
							</th>
							<th class="table-date am-hide-sm-only" style="width:50px">是否空闲</th>
							<th width="163px" class="table-set" style="width:20%">操作</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="car" items="${pb.list }">
							<tr>
								<td><input type="checkbox" /></td>
								<td style="width:15%">${car.carId }</td>
								<td style="width:150px">${car.carModel }</td>
								<td style="width:50px">${car.carweight }吨</td>
								<td style="width:100px">${car.driverId }</td>
								<td class="am-hide-sm-only" style="width:100px">${car.carState }</td>
								<td class="am-hide-sm-only" style="width:50px">${car.ifFree }</td>
								<td><div class="am-btn-toolbar">
										<div class="am-btn-group am-btn-group-xs">
											<a 
												class="am-btn am-btn-default am-btn-xs am-text-success am-round">
												<span class="am-icon-search"></span>
											</a>
											<a
												onclick="javascript:location.href='CarEdit?carId=${car.carId }'" class="am-btn am-btn-default am-btn-xs am-text-secondary am-round">
												<span class="am-icon-pencil-square-o"></span>
											</a>
											<a
												class="am-btn am-btn-default am-btn-xs am-text-warning  am-round">
												<span class="am-icon-copy"></span>
											</a>
											<a
												class="am-btn am-btn-default am-btn-xs am-text-danger am-round">
												<span class="am-icon-trash-o"></span>
											</a>
										</div>
									</div></td>
							</tr>
						</c:forEach>
					</tbody>

				</table>

				<div class="am-btn-group am-btn-group-xs">
					<button type="button" class="am-btn am-btn-default">
						<span class="am-icon-plus"></span> 删除
					</button>
					<button type="button" class="am-btn am-btn-default">
						<span class="am-icon-save"></span> 上架
					</button>
					<button type="button" class="am-btn am-btn-default">
						<span class="am-icon-save"></span> 下架
					</button>
					<button type="button" class="am-btn am-btn-default">
						<span class="am-icon-save"></span> 移动
					</button>
					<button type="button" class="am-btn am-btn-default">
						<span class="am-icon-plus"></span> 新增
					</button>
					<button type="button" class="am-btn am-btn-default">
						<span class="am-icon-save"></span> 保存
					</button>
					<button type="button" class="am-btn am-btn-default">
						<span class="am-icon-archive"></span> 移动
					</button>
					<button type="button" class="am-btn am-btn-default">
						<span class="am-icon-trash-o"></span> 删除
					</button>
				</div>

				<ul class="am-pagination am-fr">
					<li><a
						href="CarList?p=${(pb.currentPage - 1) > 0 ? pb.currentPage-1 : 1 }">«</a></li>
					<c:set var="i" value="1" />
					<c:forEach begin="0" end="${pb.totalPage-1 }">
						<li><a href="CarList?p=${i }">${i }</a></li>
						<c:set var="i" value="${i+1 }" />
					</c:forEach>
					<li><a
						href="CarList?p=${(pb.currentPage + 1) > pb.totalPage ? pb.totalPage : (pb.currentPage + 1)}">»</a></li>
				</ul>


				<hr />
				<p>注：.....</p>
			</form>




			<div class="foods">
				<ul>
					版权所有@2015. 模板收集自
					<a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a>
					- More Templates
					<a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
				</ul>
				<dl>
					<a href="" title="返回头部" class="am-icon-btn am-icon-arrow-up"></a>
				</dl>
			</div>
		</div>



	</div>
</body>
</html>
