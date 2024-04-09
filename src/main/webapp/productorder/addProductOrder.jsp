<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.productOrder.model.*"%>

<%
//������J�榡�����~�ɪ�productOrderVO����
ProductOrderVO productOrderVO = (ProductOrderVO) request.getAttribute("productOrderVO");
%>
--<%=productOrderVO == null%>--${productOrderVO.member_no}--
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>�q���Ʒs�W - addProductOrder.jsp</title>

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
				<h3>�q���Ʒs�W - addProductOrder.jsp</h3>
			</td>
			<td>
				<h4>
					<a href="select_page.jsp"><img src="images/tomcat.png"
						width="100" height="100" border="0"><br>�^����</a>
				</h4>
			</td>
		</tr>
	</table>
	<h3>��Ʒs�W:</h3>

	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="productOrder.do" name="form1">
		<table>

			<tr>
				<td>�ӫ~�q��<br>�s��:<font color=red><b>*</b></font></td>
				<td><%=(productOrderVO != null) ? productOrderVO.getProduct_order_no() : ""%></td>
			</tr>
			<tr>
				<td>�|���s��:</td>
				<td><input type="TEXT" name="member_no"
					value="<%=(productOrderVO != null) ? productOrderVO.getMember_no() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�ӫ~���B:</td>
				<td><input type="TEXT" name="product_price"
					value="<%=(productOrderVO != null) ? productOrderVO.getProduct_price() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�ͤ�§����B:</td>
				<td><input type="TEXT" name="product_coupon_discount"
					value="<%=(productOrderVO != null) ? productOrderVO.getProduct_coupon_discount() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�ӫ~���b���B:</td>
				<td><input type="TEXT" name="product_checkout_amount"
					value="<%=(productOrderVO != null) ? productOrderVO.getProduct_checkout_amount() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�|���I��:</td>
				<td><input type="TEXT" name="member_points"
					value="<%=(productOrderVO != null) ? productOrderVO.getMember_points() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�ͤ�§��s��:</td>
				<td><input type="TEXT" name="birthday_coupon_no"
					value="<%=(productOrderVO != null) ? productOrderVO.getBirthday_coupon_no() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>����H:</td>
				<td><input type="TEXT" name="recipient"
					value="<%=(productOrderVO != null) ? productOrderVO.getRecipient() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>����H�q��:</td>
				<td><input type="TEXT" name="recipient_phone"
					value="<%=(productOrderVO != null) ? productOrderVO.getRecipient_phone() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>����H�a�}:</td>
				<td><input type="TEXT" name="recipient_address"
					value="<%=(productOrderVO != null) ? productOrderVO.getRecipient_address() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�ӫ~�q��<br>���߮ɶ�:
				</td>
				<td><input name="product_orderdate" id="f_date1" type="text"></td>
				<td><%=productOrderVO != null ? productOrderVO.getProduct_orderdate() : ""%></td>
			</tr>
			<tr>
				<td>�ӫ~�q��<br>�I�ڮɶ�:
				</td>
				<td><input name="product_paydate" id="f_date1" type="text"></td>
				<td><%=productOrderVO != null ? productOrderVO.getProduct_paydate() : ""%></td>
			</tr>
			<tr>
				<td>�ӫ~�q��<br>���׮ɶ�:
				</td>
				<td><input name="order_closedate" id="f_date1" type="text"></td>
				<td><%=productOrderVO != null ? productOrderVO.getOrder_closedate() : ""%></td>
			</tr>
			<tr>
				<td>�ӫ~�q��<br>�I�ڪ��A:
				</td>
				<td><input type="TEXT" name="product_payment_status"
					value="<%=(productOrderVO != null) ? productOrderVO.getProduct_payment_status() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�ӫ~�q��<br>�B�z���A:
				</td>
				<td><input type="TEXT" name="product_process_status"
					value="<%=(productOrderVO != null) ? productOrderVO.getProduct_process_status() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�ӫ~�q��<br>���ڪ��B:
				</td>
				<td><input type="TEXT" name="product_order_allocation_amount"
					value="<%=(productOrderVO != null) ? productOrderVO.getProduct_order_allocation_amount() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�ӫ~�q��<br>���ڪ��A:
				</td>
				<td><input type="TEXT" name="product_order_allocation_status"
					value="<%=(productOrderVO != null) ? productOrderVO.getProduct_order_allocation_status() : ""%>"
					size="45" /></td>
			</tr>

		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="�e�X�s�W">
	</FORM>

</body>
</html>