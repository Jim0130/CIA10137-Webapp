<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.productOrder.model.*"%>
<%-- �����m�߱ĥ� EL ���g�k���� --%>

<%
ProductOrderService productOrderSvc = new ProductOrderService();
List<ProductOrderVO> list = productOrderSvc.getAll();
pageContext.setAttribute("list", list);
%>

<html>
<head>
<title>�Ҧ��ӫ~�q���� - listAllProductOrder.jsp</title>

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

	<h4>�����m�߱ĥ� EL ���g�k����:</h4>
	<table id="table-1">
		<tr>
			<td>
				<h3>�Ҧ��ӫ~�q���� - listAllProductOrder.jsp</h3>
				<h4>
					<a href="select_page.jsp"><img src="images/back1.gif"
						width="100" height="32" border="0">�^����</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>�ӫ~�q��s��</th>
			<th>�|���s��</th>
			<th>�ӫ~���B</th>
			<th>�ͤ�§����B</th>
			<th>�ӫ~���b���B</th>
			<th>�|���I��</th>
			<th>�ͤ�§��s��</th>
			<th>����H</th>
			<th>����H�q��</th>
			<th>����H�a�}</th>
			<th>�ӫ~�q�榨�߮ɶ�</th>
			<th>�ӫ~�q��I�ڮɶ�</th>
			<th>�ӫ~�q�浲�׮ɶ�</th>
			<th>�ӫ~�q��I�ڪ��A</th>
			<th>�ӫ~�q��B�z���A</th>
			<th>�ӫ~�q�漷�ڪ��B</th>
			<th>�ӫ~�q�漷�ڪ��A</th>
			<th>�ק�</th>
			<th>�R��</th>
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
						<input type="submit" value="�ק�"> <input type="hidden"
							name="product_order_no"
							value="${productOrderVO.product_order_no}"> <input
							type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/productOrder/productOrder.do"
						style="margin-bottom: 0px;">
						<input type="button" disable value="�R��"> <input
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