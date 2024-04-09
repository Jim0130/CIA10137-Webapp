<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.productOrder.model.*"%>

<%
//此為輸入格式有錯誤時的productOrderVO物件
ProductOrderVO productOrderVO = (ProductOrderVO) request.getAttribute("productOrderVO");
%>
--<%=productOrderVO == null%>--${productOrderVO.member_no}--
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>訂單資料新增 - addProductOrder.jsp</title>

<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}
</style>

<style>
table {
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	padding: 1px;
}

input[type="submit"] {
	padding: 10px 20px;
	background-color: #4c6caf;
	color: white;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	margin-top: 10px;
}

input[type="submit"]:hover {
	background-color: #6b7996;
}
</style>

</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td>
				<h3>訂單資料新增 - addProductOrder.jsp</h3>
			</td>
			<td>
				<h4>
					<a href="select_page.jsp"><img src="images/tomcat.png"
						width="100" height="100" border="0"><br>回首頁</a>
				</h4>
			</td>
		</tr>
	</table>
	<h3>資料新增:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="productOrder.do" name="form1">
		<table>

			<tr>
				<td>商品訂單<br>編號:<font color=red><b>*</b></font></td>
				<td><%=(productOrderVO != null) ? productOrderVO.getProduct_order_no() : ""%></td>
			</tr>
			<tr>
				<td>會員編號:</td>
				<td><input type="TEXT" name="member_no"
					value="<%=(productOrderVO != null) ? productOrderVO.getMember_no() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>商品金額:</td>
				<td><input type="TEXT" name="product_price"
					value="<%=(productOrderVO != null) ? productOrderVO.getProduct_price() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>生日禮券金額:</td>
				<td><input type="TEXT" name="product_coupon_discount"
					value="<%=(productOrderVO != null) ? productOrderVO.getProduct_coupon_discount() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>商品結帳金額:</td>
				<td><input type="TEXT" name="product_checkout_amount"
					value="<%=(productOrderVO != null) ? productOrderVO.getProduct_checkout_amount() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>會員點數:</td>
				<td><input type="TEXT" name="member_points"
					value="<%=(productOrderVO != null) ? productOrderVO.getMember_points() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>生日禮券編號:</td>
				<td><input type="TEXT" name="birthday_coupon_no"
					value="<%=(productOrderVO != null) ? productOrderVO.getBirthday_coupon_no() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>收件人:</td>
				<td><input type="TEXT" name="recipient"
					value="<%=(productOrderVO != null) ? productOrderVO.getRecipient() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>收件人電話:</td>
				<td><input type="TEXT" name="recipient_phone"
					value="<%=(productOrderVO != null) ? productOrderVO.getRecipient_phone() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>收件人地址:</td>
				<td><input type="TEXT" name="recipient_address"
					value="<%=(productOrderVO != null) ? productOrderVO.getRecipient_address() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>商品訂單<br>成立時間:
				</td>
				<td><input name="product_orderdate" id="f_date1" type="text"></td>
				<td><%=productOrderVO != null ? productOrderVO.getProduct_orderdate() : ""%></td>
			</tr>
			<tr>
				<td>商品訂單<br>付款時間:
				</td>
				<td><input name="product_paydate" id="f_date1" type="text"></td>
				<td><%=productOrderVO != null ? productOrderVO.getProduct_paydate() : ""%></td>
			</tr>
			<tr>
				<td>商品訂單<br>結案時間:
				</td>
				<td><input name="order_closedate" id="f_date1" type="text"></td>
				<td><%=productOrderVO != null ? productOrderVO.getOrder_closedate() : ""%></td>
			</tr>
			<tr>
				<td>商品訂單<br>付款狀態:
				</td>
				<td><input type="TEXT" name="product_payment_status"
					value="<%=(productOrderVO != null) ? productOrderVO.getProduct_payment_status() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>商品訂單<br>處理狀態:
				</td>
				<td><input type="TEXT" name="product_process_status"
					value="<%=(productOrderVO != null) ? productOrderVO.getProduct_process_status() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>商品訂單<br>撥款金額:
				</td>
				<td><input type="TEXT" name="product_order_allocation_amount"
					value="<%=(productOrderVO != null) ? productOrderVO.getProduct_order_allocation_amount() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>商品訂單<br>撥款狀態:
				</td>
				<td><input type="TEXT" name="product_order_allocation_status"
					value="<%=(productOrderVO != null) ? productOrderVO.getProduct_order_allocation_status() : ""%>"
					size="45" /></td>
			</tr>

		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="送出新增">
	</FORM>

</body>
</html>