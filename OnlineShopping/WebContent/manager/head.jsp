<%@ page language="java" import="java.util.*,com.eshore.pojo.CommonUsers,com.eshore.factory.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>淘淘网—开心淘</title>
		<link rel="stylesheet" type="text/css" href="css/styles.css">
	</head>

	<body>
			
		<div>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
			<%
				if (session.getAttribute("manager_name") == null	
						|| session.getAttribute("manager_name").equals("")) {
					
			%>
			
			您好，欢迎来淘淘网！
			<a href="login.jsp">[请登录]</a>
			<a href="register.jsp">[免费注册]</a>
			<%
				} else {
			%>
			<br>
			您好,管理员
			<a href="shoppingcart?action=lookbus"> <font><%=session.getAttribute("manager_name")%></font>
			</a>，欢迎来淘淘网！
			<a href="login?action=logout">[注销]</a>
			<%
				}
			%>
			<br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;
				<img src="image/bag.png" border="0"/>
				<a href="goods?action=showKinds">商品管理</a>
				&nbsp;&nbsp;&nbsp;
				<img src="image/logo.png" border="0"/>
				<a href="order?action=allNotDelivered">订单管理</a>
				<br>
		</div>
	</body>
</html>
