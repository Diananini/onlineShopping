<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>查看用户</title>
	</head>

	<body>
		<div align="center" style="width: 60%; padding-left: 10%">
			<fieldset>
				<legend>
					个人信息
				</legend>
				<div align="left" style="padding-left: 20%">
					<p>
						<label>
							姓名：
						</label>${uname }<br/>
						<label>
							性别：
						</label>${gender }<br/>
						<label>
							电话：
						</label>${phone }
					<p>
				</div>
			</fieldset>
		</div>
	</body>
</html>
