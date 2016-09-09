<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.eshore.pojo.Goods"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>淘淘网—开心淘！</title>
		<jsp:include page="../common/common.jsp"/>
		<script type="text/javascript" src="js/shopcart/bus.js"></script>
	</head>

	<body>
		<div id="top">
			<jsp:include page="../head.jsp"/> 
		</div>
		<p>
		<div>
			<jsp:include page="../logo_select1.jsp"/> 
		</div>
		<input id="status" type="hidden" name="status" value="${status }">
		<div align="center">
			<div style="width: 80%; height: 78%;">
				<div id="left" align="left">
					<div style="padding-top: 2px;">
						<div id="title">
							个人信息
						</div>
						<ul id="myinf">
							<li>
								<a href="user?action=show">我的信息</a>
								<p>
							<li>
								<a href="user?action=edit">修改基本信息</a>
								<p>
							<li>
								<a href="user/editpasswd.jsp">修改密码</a>
						</ul>
						<p>
						<div id="title">
							我的购物车
						</div>
						<ul>
							<li>
								<a href="shoppingcart?action=lookbus">购物车</a>
								<p>
							<li>
								<a href="shoppingcart?action=paid">已购买的宝贝</a>
								<p>
						</ul>
						<p>
						<div id="title">
							订单
						</div>
						<ul>
							<li>
								<a href="order?action=allOder">全部订单</a>
								<p>
							<li>
								<a href="order?action=notDelivered">待发货</a>
								<p>
							<li>
								<a href="order?action=delivered">待收货</a>
								<p>
							<li>
								<a href="order?action=received">交易成功</a>
								<p>
						</ul>
					</div>
				</div>
				<div id="right" align="left" style="width: 100%;height:100%">
					<div
						style="padding-right: 3%; padding-left: 5%; width: 92%; height: 100%;">
						<div align="center">
							<div id="title" align="left">
								<table width="90%">
									<tr style="text-align: center">
										<td width="100px" >订单号</td>
										<td width="180px">收货人</td>
										<td width="170px">收货地址（元）</td>
										<td width="100px">金额（元）</td>
										<td colspan="2" width="150px">操作</td>
									</tr>
								</table>
							</div>
							<form action="order" method="post" id="bus">
								<table width="100%" border="0" >
									<input type="hidden" name="action" value="editbus">
									<c:choose>
										<c:when test="${empty orders}">
											<div align="left">
												<br/>
												<span>无交易成功订单</span>
												<p>
												<jsp:include page="../recommend.jsp"/>
											</div>
										</c:when>
										<c:otherwise>
											<c:forEach items="${orders}" var="order" varStatus="status">
										
												<tr>
													<th id="orderId" width="100px">
														${order.orderId}
													</th>
													<th id="receiver" width="100px" align="left">
														${order.receiver}					
													</th>
													<th id="userAddr" width="150px">
														${order.userAddr}
													</th>
													<th width="100px">
														${order.money}
													</th>
													<th width="150px" style="text-align: left">
														<a href="order?action=deleteorder&orderId=${order.orderId}">删除</a>
													</th>
												</tr>
												</c:forEach>
												
												<tr>
													<td colspan="6" align="left">
														<a href="order?action=deleteall">删除全部</a>
													</td>
												</tr>
										</c:otherwise>
									</c:choose>
								</table>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div id="foot">
				<jsp:include page="../foot.jsp"/> 
			</div>
		</div>
	</body>
</html>
