<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="lms" uri="/lms-tags" %> 
<%@page import="com.eshore.pojo.Goods"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>淘淘网—开心淘！</title>
		<jsp:include page="../common/common.jsp"/>
		<script type="text/javascript" src="js/shopcart/bus.js"></script>
		<script type="text/javascript">
		    function query(pageNO){
				document.getElementById("curPage").value=pageNO;
	            document.getElementById("paidform").submit();
			}
		</script>
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
								<a href="shoppingcart?action=lookbus">查看购物车</a>
								<p>
							<li>
								<a href="shoppingcart?action=paid">查看已购买的宝贝</a>
								<p>
						</ul>
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
				<div id="right" align="left">
					<div
						style="padding-right: 3%; padding-left: 5%; width: 100%; height: 100%;">
						<div align="center">
							<div id="title" align="left">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								宝贝详细&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								单价（元）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								数量&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 总计（元）
							</div>
							<form action="shoppingcart" method="post" id="bus" name="paidform">
								<table width="100%" border="0" id="list">
									<input type="hidden" name="action" value="editbus">
									 <c:choose>
									      <c:when test="${empty pageObject.data}">
										      <div align="left">
												<br>
												<span>您还没有购买任何商品，看看其他商品吧……</span>
												<p>
												<jsp:include page="../recommend.jsp"/> 
											</div>
									      </c:when>
									      <c:otherwise>
									         <input type="hidden" name="curPage" id="curPage" value="${pageObject.curPage}"/>
									      	<c:forEach items="${pageObject.data}" var="tempgood" varStatus="status">
												<input type="hidden" id="gid" name="gid">
												<input type="hidden" id="gid${status.index}" name="gid${status.index}"
													value="${tempgood.good.gid}">
												<input type="hidden" id="number" name="number">
												<tr>
													<th width="5%">
														<a id="img-link"
															href="goods?sid=${tempgood.good.gid}&action=goodslist-select"><img
																src="${tempgood.good.gphoto }" border="0" width="50px" height="50px">
														</a>
													</th>
													<th width="15%" align="left">
														<a href="goods?sid=${tempgood.good.gid }&action=goodslist-select">
															${tempgood.good.gname}</a>
														<br>
														${tempgood.good.described}
														<br>
														型号：${tempgood.good.types}
													</th>
													<th width="10%">${tempgood.good.price}
														<br>
													</th>
													<th width="10%">
														<font color="red" style="font-family: Arial">${tempgood.number}</font>
													</th>
													<th width="10%">
														<font color="red" style="font-family: Arial">${tempgood.good.price*tempgood.number+tempgood.good.carriage}</font>
													</th>
												</tr>
											</c:forEach>
											<lms:page object="${pageObject}" script="query" >
								               <jsp:include page="../common/page.jsp" /> 
								            </lms:page>
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
