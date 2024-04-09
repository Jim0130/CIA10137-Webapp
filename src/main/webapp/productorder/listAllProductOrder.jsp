<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.productOrder.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
ProductOrderService productOrderSvc = new ProductOrderService();
List<ProductOrderVO> list = productOrderSvc.getAll();
pageContext.setAttribute("list", list);
%>

<html>
<head>
<title>所有商品訂單資料 - listAllProductOrder.jsp</title>

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
	width: 800px;
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

	<h4>此頁練習採用 EL 的寫法取值:</h4>
	<table id="table-1">
		<tr>
			<td>
				<h3>所有商品訂單資料 - listAllProductOrder.jsp</h3>
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
			<th>修改</th>
			<th>刪除</th>
		</tr>
		<%@ include file="page1.file"%>
		<c:forEach var="productOrderVO" items="${list}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>">

			<tr>
				<td>${productOrderVO.product_order_no}</td>
				<td>${productOrderVO.member_no}</td>
				<td>${productOrderVO.product_price}</td>
				<td>${productOrderVO.product_coupon_discount}</td>
				<td>${productOrderVO.product_checkout_amount}</td>
				<td>${productOrderVO.member_points}</td>
				<td>${productOrderVO.birthday_coupon_no}</td>
				<td>${productOrderVO.recipient}</td>
				<td>${productOrderVO.recipient_phone}</td>
				<td>${productOrderVO.recipient_address}</td>
				<td>${productOrderVO.product_orderdate}</td>
				<td>${productOrderVO.product_paydate}</td>
				<td>${productOrderVO.order_closedate}</td>
				<td>${productOrderVO.product_payment_status}</td>
				<td>${productOrderVO.product_process_status}</td>
				<td>${productOrderVO.product_order_allocation_amount}</td>
				<td>${productOrderVO.product_order_allocation_status}</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/productorder/productOrder.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="修改"> <input type="hidden"
							name="product_order_no"
							value="${productOrderVO.product_order_no}"> <input
							type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/productOrder/productOrder.do"
						style="margin-bottom: 0px;">
						<input type="button" disable value="刪除"> <input
							type="hidden" name="product_order_no"
							value="${productOrderVO.product_order_no}"> <input
							type="hidden" name="action" value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="page2.file"%>

</body>
</html>