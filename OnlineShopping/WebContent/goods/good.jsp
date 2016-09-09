<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.eshore.pojo.Goods"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>淘淘网—开心淘！</title>
		<jsp:include page="../common/common.jsp"/>
		<script type="text/javascript" src="js/good/good.js"></script>
	</head>

	<body>
		<div id="top">
			<jsp:include page="../head.jsp"/>
		</div>
		<p>
		<div>
			<jsp:include page="../logo_select1.jsp"/>
		</div>
		<div align="center">
			<br>
			<input id="status" type="hidden" name="status" value="${status}">
			<div
				style="background-image: url(image/title3.jpg); width: 1000; height: 400">
				<font color="red" size="7">${good.gname}</font>
				<font size="7">详细</font>
				<a href="#good-top"></a>
				<br>
				<table width="80%" height="80%" align="center">
					<tr>
						<td>
							<input id="gid" type="hidden" name="gid"
								value="${good.gid}">
							<img src="${good.gphoto}" width="300" height="300" border="0">
						</td>
						<td>
							<div>
								单价：
								<font color="red" size="5">${good.price}</font>元
								<br>
								运费：
								<font color="red" size="5">${good.carriage}</font>元
								<br>
								生厂商：
								<font color="red" size="5">${good.producer}</font>
								<br>
								出产地：
								<font color="red" size="5">${good.paddress}</font>
								<br>
								其他：
								<font color="red" size="5">${good.described}</font>
								<br>
								<form action="" id="goodnum">
									我要买
									<input type="text" name="number" size="4" value="1" maxlength=5
										id="number">
									件
								</form>
								<a id="img-link" class="active-buy"
									href="shoppingcart?gid=${good.gid}&number=1&action=good"><img
										src="image/pay.jpg" border="0"> </a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a id="img-link" class="active-intobus"
									href="shoppingcart?gid=${good.gid}&number=1&action=intobus"><img
										src="image/addbus.jpg" border="0"> </a>
								<a id="lookbus"></a>
							</div>
						</td>
					</tr>
				</table>
			</div>
			<div id="foot">
				<jsp:include page="../foot.jsp"></jsp:include>
			</div>
		</div>
	</body>
</html>
