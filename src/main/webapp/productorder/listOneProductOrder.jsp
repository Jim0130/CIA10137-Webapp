<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.productOrder.model.*"%>
<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%
ProductOrderVO productOrderVO = (ProductOrderVO) request.getAttribute("productOrderVO"); //ProductOrderServlet.java(Concroller), �s�Jreq��productOrderVO����
%>

<html>
<head>
<title>�ӫ~�q���� - listOneProductOrder.jsp</title>

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

	<h4>�����Ƚm�߱ĥ� Script ���g�k����:</h4>
	<table id="table-1">
		<tr>
			<td>
				<h3>�ӫ~�q���� - listOneProductOrder.jsp</h3>
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