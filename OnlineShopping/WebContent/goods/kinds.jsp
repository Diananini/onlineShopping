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
			<jsp:include page="../manager/head.jsp"/> 
		</div>
		<p>
		<table>
			<tr>
				<td align="left" width="300">
				<div>
					<a id="img-link" href="managerindex.jsp"> <img src="image/logo1.jpg" border="0"/> </a>
				</div>
				</td>
				<td align="left" width="700">
				<br>
					<div style="width: 150px;height: 30px;padding-top: 3px;">
						<img src="image/homelogo.jpg" border="0"/>
						<a id="homePage" href="managerindex.jsp">返回首页</a>
					</div>
				</td>
			</tr>
		</table>
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
								<a href="manager/editpasswd.jsp">修改密码</a>
								<p>
						</ul>
						<p>
						<div id="title">
							商品管理
						</div>
						<ul id="goodManage">
							<li>
								<a href="goods/addGood.jsp">添加商品</a>
								<p>
							<li>
								<a href="goods/deleteGood.jsp">删除商品</a>
								<p>
							
						</ul>
						<ul>
							<li>
								<a href="goods?action=showKinds">商品类管理</a>
								<p>
						</ul>
						<p>
						<div id="title">
							订单管理
						</div>
						<ul>
							<li>
								<a href="order?action=allNotDelivered">待发货</a>
								<p>
							<li>
								<a href="order?action=allDelivered">待收货</a>
								<p>
							<li>
								<a href="order?action=allReceived">交易成功</a>
								<p>
						</ul>
					</div>
				</div>
				<div id="right" align="left" style="width: 100%;height:100%">
					<div
						style="padding-right: 3%; padding-left: 5%; width: 92%; height: 100%;">
						<div align="center">
							<div id="title" align="left">
								<table width="100%">
									<tr style="text-align: center">
										<td width="200px" >商品类别</td>
										<td width="200px">商品数</td>
										<td width="200px">操作</td>
									</tr>
								</table>
							</div>
							<form action="order" method="post" id="order">
								<table width="100%" border="0" >
									<c:choose>
										<c:when test="${empty kinds}">
											<div align="left">
												<br/>
												<span>无任何商品</span>
												<p>
											</div>
										</c:when>
										<c:otherwise>
											<c:forEach items="${kinds}" var="kind" varStatus="status">
		
												<tr style="text-align: center">
													<th  width="200px">
														${kind.kinds}
													</th>
													<th  width="200px">
														${kind.counts}					
													</th>
													
													<th width="200px">
														<a href="goods?action=deleteKinds&kinds=${kind.kinds}">删除</a>
													</th>
												</tr>
												</c:forEach>
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
