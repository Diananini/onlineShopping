<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title></title>
	</head>

	<body>
		<div>
			<a id="img-link" href="index.jsp"> <img src="image/logo.jpg" border="0"/> </a>
		</div>
		<br>
		<div
			style="background-image: url(image/title1.jpg); width: 1000px; height: 75px;">
			<br>
			<form action="goods" method="post" name="index-select">
				<input id="keyWord" type="text" name="keyWord"
					onblur="this.className='inputout';if(this.value==''){this.value='请输入关键字';}"
					onfocus="this.className='inputover';this.focus();if(this.value=='请输入关键字'){this.value='';}"
					size="50" value="请输入关键字" name="keyWord">
				<select name="keyClass">
					<option value="0" selected="selected">
						查询条件
					</option>
					<option value="1">
						按商品名
					</option>
					<option value="2">
						按商品种类
					</option>
				</select>
				<input type="hidden" name="action" value="index-select">
				<input class="submit" type="submit" value="搜 索">
			</form>
			<br>
		</div>
	</body>
</html>
