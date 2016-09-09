<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/styles.css">
	</head>

	<body>
		<table>
			<tr>
				<td align="right" width="450">
				<div>
					<a id="img-link" href="index.jsp"> <img src="image/logo1.jpg" border="0"/> </a>
				</div>
				</td>
				<td align="center" width="700">
				<br>
					<div style="background-image: url(image/title4.jpg);width: 600px;height: 30px;padding-top: 3px;">
						<form action="goods" method="post" name="index-select">
							<input id="keyWord" type="text" name="keyWord"
								onblur="this.className='inputout';if(this.value==''){this.value='请输入关键字';}"
								onfocus="this.className='inputover';this.focus();if(this.value=='请输入关键字'){this.value='';}"
								size="40" value="请输入关键字" name="keyWord">
							<select name="keyClass" >
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
					</div>
				</td>
			</tr>
		</table>
		<hr>
	</body>
</html>
