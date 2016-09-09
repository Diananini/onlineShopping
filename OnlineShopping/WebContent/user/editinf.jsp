	<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	<html>
		<head>
			<title>修改个人信息</title>
		<script type="text/javascript" src="js/user/editinf.js"></script>
	</head>
	
	<body>
			<div align="center" style="width: 60%; padding-left: 10%">
			<fieldset>
				<legend>修改个人信息 
					</legend>
			<form id="editinf" action="user" method="post">
					<div align="left" style="padding-left: 20%">
						<p>
							<label>
								用户名：
							</label>
								<input class="required" type="text" name="uname"
								value="${uname }" maxlength="50" minlength="3">
						<p>
						<label>
								性别（M/F）：
						</label>
								<input type="text" name="gender"
 										class="gender" maxlength="1"
								minlength="1" value="${gender }">
						<p>
						<label>
								&nbsp;&nbsp;电话：
						</label>
								<input type="text" name="phone"
 										class="phone" maxlength="50"
								minlength="11" value="${phone }">
						<p>
							<input type="hidden" name="action" value="editinf">
							<input class="submit" type="submit" 
											value="修&nbsp; 改">
					</div>
				</form>
				</fieldset>
			</div>
		</body>
	</html>
