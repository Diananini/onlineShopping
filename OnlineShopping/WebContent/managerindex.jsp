<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>淘淘网—开心淘！</title>
		<jsp:include page="common/common.jsp"/>
		<script type="text/javascript" src="js/common/index.js"></script>
	</head>

	<body>
		<div align="center">
			<div id="top">
				<jsp:include page="manager/head.jsp"></jsp:include>
			</div>
			<p>
			<div id="logoselect">
				<jsp:include page="logo_select.jsp"></jsp:include>				
			</div>
			<input id="status" type="hidden" name="status" value="${status}">
			<div id="main">
				<div>
					<br>
					<table border="1" id="list">
						<tr class="goodlist">
							<td>
								<br/>
								数
								<br/>
								<br/>
								码
								<br/>
							<td>
							<td>
								<a  href="goods?keyWord=cellphone&keyClass=2&action=index-select">品牌手机</a>
								<br>
								<a href="goods?keyWord=nokia&keyClass=1&action=index-select">诺基亚</a>|
								<a href="goods?keyWord=iphone&keyClass=1&action=index-select">iphone</a>|
							</td>
							<td>
								<a href="goods?keyWord=camera&keyClass=2&action=index-select">数码相机</a>
								<br>
								<a href="goods?keyWord=fujinon&keyClass=1&action=index-select">富士</a>|
								<a href="goods?keyWord=nikon&keyClass=1&action=index-select">尼康</a>|
								<br>
							</td>
							<td>
								<a href="goods?keyWord=notebook&keyClass=2&action=index-select">笔记本电脑</a>
								<br>
								<a href="goods?keyWord=lenovo&keyClass=1&action=index-select">联想</a>|
								<a href="goods?keyWord=dell&keyClass=1&action=index-select">dell</a>|
								<br>
								<a href="goods?keyWord=acer&keyClass=1&action=index-select">宏基</a>|
								<a href="goods?keyWord=benq&keyClass=1&action=index-select">明基</a>|
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div id="foot">
				<jsp:include page="foot.jsp"></jsp:include>
			</div>
		</div>
	</body>
</html>
