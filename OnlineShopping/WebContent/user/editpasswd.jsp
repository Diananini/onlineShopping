<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>修改密码</title>
		<script type="text/javascript" src="js/user/editpasswd.js"></script>
	</head>
	<body>
		<div align="center" style="width: 60%; padding-left: 10%">
			<fieldset>
				<legend>
					修改密码
				</legend>
				<form id="editpasswd" action="user" method="post">
					<div align="left" style="padding-left: 20%">
						<p>
							<label>
								&nbsp;&nbsp;原密码：
							</label>
							<input class="required" type="password" name="oldPasswd" maxlength="50" minlength="3">
						<p>
							<label>
								&nbsp;&nbsp;新密码：
							</label>
							<input id="passwd1" class="required" type="password" name="passwd1" maxlength="50" minlength="3">
						<p>
							<label>
								确认密码：
							</label>
							<input id="passwd2" class="required" type="password" name="passwd2" maxlength="50" minlength="3">
						<p>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="hidden" name="action" value="editpasswd">
							<input class="submit" type="submit" value="修&nbsp; 改">
					</div>
				</form>
			</fieldset>
		</div>
	</body>
</html>
