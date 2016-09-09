<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>淘淘网—开心淘！</title>
		<jsp:include page="common/common.jsp"/>
		<script type="text/javascript" src="js/common/login.js"></script>
	</head>

	<body>
		<div align="center">
			<div id="top">
				<jsp:include page="head.jsp"></jsp:include>
			</div>
			<p>
			<div>
				<a id="img-link" href="index.jsp"> <img src="image/logo.jpg" border="0"/> </a>
			</div>
			<br>
			<br>
			<div style="width: 80%; height: 60%">
				<img src="image/loginlogo.jpg" align="left"
					style="padding-left: 25%" border="0"/>
				<br><br><br><br><br>
				<div id="loginbg" align="center">
					<div align="center">
						<form action="login" method="post" id="login">
							<table width="100%">
								<tr>
									<td colspan="2">
										<font color="red" size="5">${status}</font>
									</td>
								</tr>
								<tr>
									<th width="20%">
										用户名：
									</th>
									<td width="70%">
										<input type="text" name="uname" value="${uname}"
											maxlength="50" minlength="3">
									</td>
								</tr>
								<tr></tr>
								<tr>
									<th width="20%">
										密&nbsp;&nbsp;码：
									</th>
									<td width="70%">
										<input type="password" name="passwd" maxlength="50"
											minlength="3">
									</td>
								</tr>
								<tr>
									<td colspan="2" align="center">
										<br>
										<input type="hidden" name="action" value="login">
										<input class="submit" type="submit" value="登&nbsp;&nbsp;录">
										&nbsp;&nbsp;
										<a href="register.jsp">免费注册</a>
									</td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
			<div id="foot">
				<jsp:include page="foot.jsp"></jsp:include>
			</div>
		</div>
	</body>
</html>
