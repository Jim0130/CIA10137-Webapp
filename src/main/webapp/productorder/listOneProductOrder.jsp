<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.productOrder.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
ProductOrderVO productOrderVO = (ProductOrderVO) request.getAttribute("productOrderVO"); //ProductOrderServlet.java(Concroller), 存入req的productOrderVO物件
%>

<html>
<head>
<title>商品訂單資料 - listOneProductOrder.jsp</title>

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
	width: 600px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 5px;
	text-align: center;
}
</style>

</head>
<body bgcolor='white'>

	<h4>此頁暫練習採用 Script 的寫法取值:</h4>
	<table id="table-1">
		<tr>
			<td>
				<h3>商品訂單資料 - listOneProductOrder.jsp</h3>
				<h4>
					<a href="select_page.jsp"><img src="images/back1.gif"
						width="100" height="32" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>商品訂單編號</th>
			<th>會員編號</th>
			<th>商品金額</th>
			<th>生日禮券金額</th>
			<th>商品結帳金額</th>
			<th>會員點數</th>
			<th>生日禮券編號</th>
			<th>收件人</th>
			<th>收件人電話</th>
			<th>收件人地址</th>
			<th>商品訂單成立時間</th>
			<th>商品訂單付款時間</th>
			<th>商品訂單結案時間</th>
			<th>商品訂單付款狀態</th>
			<th>商品訂單處理狀態</th>
			<th>商品訂單撥款金額</th>
			<th>商品訂單撥款狀態</th>
		</tr>
		<tr>
			<td><%=productOrderVO.getProduct_order_no()%></td>
			<td><%=productOrderVO.getMember_no()%></td>
			<td><%=productOrderVO.getProduct_price()%></td>
			<td><%=productOrderVO.getProduct_coupon_discount()%></td>
			<td><%=productOrderVO.getProduct_checkout_amount()%></td>
			<td><%=productOrderVO.getMember_points()%></td>
			<td><%=productOrderVO.getBirthday_coupon_no()%></td>
			<td><%=productOrderVO.getRecipient()%></td>
			<td><%=productOrderVO.getRecipient_phone()%></td>
			<td><%=productOrderVO.getRecipient_address()%></td>
			<td><%=productOrderVO.getProduct_orderdate()%></td>
			<td><%=productOrderVO.getProduct_paydate()%></td>
			<td><%=productOrderVO.getOrder_closedate()%></td>
			<td><%=productOrderVO.getProduct_payment_status()%></td>
			<td><%=productOrderVO.getProduct_process_status()%></td>
			<td><%=productOrderVO.getProduct_order_allocation_amount()%></td>
			<td><%=productOrderVO.getProduct_order_allocation_status()%></td>
		</tr>
	</table>

</body>
</html>