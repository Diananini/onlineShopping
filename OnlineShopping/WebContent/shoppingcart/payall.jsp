<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.eshore.pojo.Goods"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>淘淘网—开心淘！</title>
		<jsp:include page="../common/common.jsp"/>
		<script type="text/javascript" src="js/shopcart/pay.js"></script>
		<script type="text/javascript" src="js/common/pcts.js"></script>
	</head>

	<body>
		<div id="top">
			<jsp:include page="../head.jsp"/> 
		</div>
		<p>
		<div>
			<jsp:include page="../logo_select1.jsp"/> 
		</div>
		<div align="center">
			<div style="width: 80%; height: 100%;">
				<table width="100%" align="center" border="0">
					<tr>
						<td width="100%">
							<form action="shoppingcart" method="post" id="pay" name="pay">
								<input type="hidden" name="shopcartId" value="${shopcartId}">
								<input type="hidden" name="flag" value="payall">
								<input type="hidden" name="action" value="pay">
								<div style="padding-left: 3%; padding-top: 3px; ">
									<div>
										<div id="title">
											确认收货地址
										</div>
										<br>
										<table style="padding-left: 10%">
											<tr>
												<th align="right">
													地区：
												</th>
												<td>
													<select id="province" name="province">
														<!--  <option value="0" selected="selected">
															-选择省-
														</option>-->
													</select>
													<select id="city" name="city">
														<!--  <option value="0" selected="selected">
															-选择市-
														</option>-->
													</select>
													<select id="town" name="town">
														<!--  <option value="0" selected="selected">
															-选择城区-
														</option>-->
													</select>
												</td>
											</tr>
											<tr>
												<th align="right">
													邮政编码：
												</th>
												<td>
													<input type="text" name="postcode" class="digits"
														maxlength="6" minlength="6">
												</td>
											</tr>
											<tr>
												<th align="right">
													街道地址：
												</th>
												<td>
													<input type="text" name="address" class="digits"
														maxlength="6" minlength="6">
												</td>
											</tr>
											<tr>
												<th align="right">
													收货人姓名：
												</th>
												<td>
													<input type="text" name="name" class="required"
														maxlength="20" minlength="2">
												</td>
											</tr>
											<tr>
												<th align="right">
													联系电话:
												</th>
												<td>
													<input type="text" name="phone" class="digits"
														maxlength="11" minlength="11">
												</td>
											</tr>
										</table>
										<p>
										<div id="title">
											确认提交订单
										</div>
										<p>
										<table style="padding-left: 10%">
											<tr>
												<th align="right">
													实付费用：
												</th>
												<td>
													<div id="money" style="font-size: 25; font-family: Arial; color: red;">
				                                       ${countPrice}
				                                    </div>元(含运费)
												</td>
											</tr>
											<tr>
												<td colspan="2" align="center">
													<input type="submit" value="确认无误,购买"
														style="background-image: url(image/button1.jpg); width: 150px; height: 35px; border-style: none; font-weight: bold;">
												</td>
											</tr>
										</table>
									</div>
								</div>
							</form>
						</td>
					</tr>
				</table>
			</div>
			<div id="foot">
				<jsp:include page="../foot.jsp"/> 
			</div>

		</div>
	</body>
	<script language="javascript">
        	setup(); 
    </script>
</html>
