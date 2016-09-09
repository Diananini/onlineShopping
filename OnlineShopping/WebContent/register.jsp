<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>注册用户</title>
		<jsp:include page="common/common.jsp"/>
		<script type="text/javascript" src="js/common/register.js"></script>

	</head>
	<body>
		<div align="center">
			<div id="top">
				<jsp:include page="head.jsp"/>
			</div>
			<p>
			<div>
				<a id="img-link" href="index.jsp"> <img src="image/logo.jpg" border="0"/> </a>
			</div>
			<br>
			<br>
			<br>
			<br>
			<div style="width: 80%; height: 60%">
				<img src="image/registerlogo.jpg" align="left"
					style="padding-left: 25%" border="0"/>
				<br>
				<br>
				<br>
				<br>
				<br>
				<form action="register" method="post" id="register">
					<div align="center">
						<div
							style="background-color: #e8ffff; height: 14px; font-size: 14px;padding-left: 60%;">
							<span>*</span>表示必须填写
						</div>
						<font color="red">${status}</font>
						<p>
							<label>
								&nbsp;&nbsp;用户名：
								<span>*</span>
							</label>
							<input type="text" name="uname" value="${uname }"
								class="required" maxlength="50" minlength="3"/>
						<p>
							<label>
								登陆密码：
								<span>*</span>
							</label>
							<input id="passwd" type="password" name="passwd" class="required"
								maxlength="50"/>
						<p>
							<label>
								确认密码：
								<span>*</span>
							</label>
							<input id="passwd1" type="password" name="passwd1"
								class="required" maxlength="50" />
						<p>
							<label>
								&nbsp;&nbsp;性别(M/F)：
								<span>*</span>
							</label>
							<input type="text" name="gender"
								class="required" maxlength="1" minlength="1"/>
						<p>
							<label>
								联系电话：
								<span>*</span>
							</label>
							<input type="text" name="phone" class="phone" maxlength="50"
								minlength="11"/>
						<p>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input class="submit" type="submit" value="注  册">
					</div>
				</form>
			</div>
			<div id="foot">
				<jsp:include page="foot.jsp"/> 
			</div>
		</div>
	</body>
</html>
