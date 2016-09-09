<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>淘淘网—开心淘！</title>
		<link rel="stylesheet" type="text/css" href="css/styles.css">
	</head>

	<body>
		<div align="center">
			<div id="top">
				<%if(request.getSession().getAttribute("manager_name")!=null
							&&!request.getSession().getAttribute("manager_name").equals("")){//管理员
					%>
					<jsp:include page="../manager/head.jsp"/> 
					<%
				}else{%>
				<jsp:include page="../head.jsp"/> 
				<%} %>
			</div>
			<p>
			<div id="logoselect">
				<%if(request.getSession().getAttribute("manager_name")!=null
							&&!request.getSession().getAttribute("manager_name").equals("")){//管理员
					%>
					<table>
						<tr>
							<td align="left" width="300">
							<div>
								<a id="img-link" href="managerindex.jsp"> <img src="image/logo1.jpg" border="0"/> </a>
							</div>
							</td>
							<td align="left" width="700">
							<br>
								<div style="width: 150px;height: 30px;padding-top: 3px;">
									<img src="image/homelogo.jpg" border="0"/>
									<a id="homePage" href="managerindex.jsp">返回首页</a>
								</div>
							</td>
						</tr>
					</table>
					<%
				}else{%>
				<jsp:include page="../logo_select1.jsp"/>  
				<%} %>
				
			</div>
			<div>
				<div style="background-color: #E1F0F0; width: 1000px; height: 35px; font-size: 25px; color: red">
					<table width="1000px">
						<tr>
							<td width="13%">图片</td>
							<td width="21%">产品</td>
							<td width="9%">单价</td>
							<td width="9%">运费</td>
							<td width="9%">型号</td>
							<td width="15%">出产地</td>
							<%if(request.getSession().getAttribute("manager_name")!=null
									&&!request.getSession().getAttribute("manager_name").equals("")){//管理员
								%>
							<td width="15%" style="text-align: center">操作</td>
							<%
							}%>
						</tr>
					</table>
				</div>
				<div id="main">
					<table width="1000px" border="0" id="list">
					    <c:choose>
					    	<c:when test="${empty goods}">
					    		<div align="left">
									<span>抱歉，没有找到符合您条件的商品，请看看别的</span>
									<br>
									<jsp:include page="../recommend.jsp"/> 
								</div>
					       </c:when>
					       <c:otherwise>
					           <c:forEach items="${goods}" var="good">
									<tr height="100px">
										<td width="13%">
											<a href="goods?sid=${good.gid}&action=goodslist-select">
											  <img src="${good.gphoto}" width="100px" height="100px" border="0">
											 </a>
										</td>
										<td width="21%">
											<a href="goods?sid=${good.gid}&action=goodslist-select">
												${good.gname}</a>
											<br>
											${good.described}
											<br>
											出厂日期：${good.pdate}
										</td>
										<td width="9%">${good.price}￥
										</td>
										<td width="9%">${good.carriage}￥
										</td>
										<td width="9%">${good.types}</td>
										<td width="15%">${good.paddress}</td>
										<%if(request.getSession().getAttribute("manager_name")!=null
											&&!request.getSession().getAttribute("manager_name").equals("")){//管理员
											%>
										<td width="15%" style="text-align: center"><a href="goods?action=deleteGood&gid=${good.gid}">删除</a></td>
										<%
										}%>
									</tr>
								</c:forEach>
					       </c:otherwise>
					    </c:choose>
					</table>
				</div>
				<div id="foot">
					<jsp:include page="../foot.jsp"/> 
				</div>
			</div>
		</div>
	</body>
</html>
