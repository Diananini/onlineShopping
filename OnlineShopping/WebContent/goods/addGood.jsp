<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>添加商品</title>
	</head>
	<body>
		<div align="center" style="width: 60%; padding-left: 10%">
			<fieldset>
				<div align="center">
							<form action="goods" method="post" id="goods">
								<table width="100%" border="0" >
									<tr style="text-align: left">
										<th  width="200px">
											商品名：
										</th>
										<td>
											<input type="text" size="30" id="gname" name="gname" maxlength=10>
										</td>
									</tr>
									<tr style="text-align: left">
										<th  width="200px">
											商品种类：
										</th>
										<td>
											<input type="text" size="30" id="kinds" name="kinds" maxlength=10>
										</td>
									</tr>
									<tr style="text-align: left">
										<th  width="200px">
											商品图：
										</th>
										<td>
											<input type="file" size="30" id="gphoto" name="gphoto" maxlength=30>
										</td>
									</tr>
									<tr style="text-align: left">
										<th  width="200px">
											商品型号：
										</th>
										<td>
											<input type="text" size="30" id="types" name="types" maxlength=10>
										</td>
									</tr>
									<tr style="text-align: left">
										<th  width="200px">
											生产厂家：
										</th>
										<td>
											<input type="text" size="30" id="producer" name="producer" maxlength=30>
										</td>
									</tr>
									<tr style="text-align: left">
										<th  width="200px">
											单价：
										</th>
										<td>
											<input type="text" size="30" id="price" name="price" maxlength=10>
										</td>
									</tr>
									<tr style="text-align: left">
										<th  width="200px">
											邮费：
										</th>
										<td>
											<input type="text" size="30" id="carriage" name="carriage" maxlength=10>
										</td>
									</tr>
									<tr style="text-align: left">
										<th  width="200px">
											生产日期：
										</th>
										<td>
											<input type="text" size="30" id="pdate" name="pdate" maxlength=20>
										</td>
									</tr>
									<tr style="text-align: left">
										<th  width="200px">
											厂家地址：
										</th>
										<td>
											<input type="text" size="30" id="paddress" name="paddress" maxlength=30>
										</td>
									</tr>
									<tr style="text-align: left">
										<th  width="200px">
											商品描述：
										</th>
										<td>
											<textarea maxlength="290" id="described" name="described" cols="30" rows="5" >
											</textarea>
										</td>
									</tr>		
								</table>
								<input type="hidden" name="action" value="addGood">
								<input class="submit" type="submit" 
											value="添&nbsp; 加">
							</form>
						</div>
			</fieldset>
		</div>
	</body>
</html>
