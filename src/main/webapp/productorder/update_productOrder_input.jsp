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
<title>�ӫ~�q���ƭק� - update_productOrder_input.jsp</title>

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
	width: 30%;
	border-collapse: separate;
	border-spacing: 0;
	margin-bottom: 20px;
}

th,td{
	padding: 20px 10px 0px 10px;
	border: 1px solid #CCCCCC;
	text-align: center;
}

input[type="text"], select {
	width: 100%;
	padding: 10px;
	margin: 1px 0;
}

.errorMsg {
	color: red;
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
				<h3>�ӫ~�q���ƭק� - update_productOrder_input.jsp</h3>
				<h4>
					<a href="select_page.jsp"><img src="images/back1.gif"
						width="100" height="32" border="0"><br>�^����</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>��ƭק�:</h3>

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
				<td>�ӫ~�q��s��<font color=red><b>*</b></font></td>
				<td><%=(productOrderVO != null) ? productOrderVO.getProduct_order_no() : ""%></td>
			</tr>
			<tr>
				<td>�|���s��</td>
				<td><input type="TEXT" name="member_no"
					value="<%=(productOrderVO != null) ? productOrderVO.getMember_no() : ""%> "
					size="45" /></td>
			</tr>
			<tr>
				<td>�ӫ~���B</td>
				<td><input type="TEXT" name="product_price"
					value="<%=(productOrderVO != null) ? productOrderVO.getProduct_price() : ""%> "
					size="45" /></td>
			</tr>
			<tr>
				<td>�ͤ�§����B</td>
				<td><input type="TEXT" name="product_coupon_discount"
					value="<%=(productOrderVO != null) ? productOrderVO.getProduct_coupon_discount() : ""%> "
					size="45" /></td>
			</tr>
			<tr>
				<td>�ӫ~���b���B</td>
				<td><input type="TEXT" name="product_checkout_amount"
					value="<%=(productOrderVO != null) ? productOrderVO.getProduct_checkout_amount() : ""%> "
					size="45" /></td>
			</tr>
			<tr>
				<td>�|���I��</td>
				<td><input type="TEXT" name="member_points"
					value="<%=(productOrderVO != null) ? productOrderVO.getMember_points() : ""%> "
					size="45" /></td>
			</tr>
			<tr>
				<td>�ͤ�§��s��</td>
				<td><input type="TEXT" name="birthday_coupon_no"
					value="<%=(productOrderVO != null) ? productOrderVO.getBirthday_coupon_no() : ""%> "
					size="45" /></td>
			</tr>
			<tr>
				<td>����H</td>
				<td><input type="TEXT" name="recipient"
					value="<%=(productOrderVO != null) ? productOrderVO.getRecipient() : ""%> "
					size="45" /></td>
			</tr>
			<tr>
				<td>����H�q��</td>
				<td><input type="TEXT" name="recipient_phone"
					value="<%=(productOrderVO != null) ? productOrderVO.getRecipient_phone() : ""%> "
					size="45" /></td>
			</tr>
			<tr>
				<td>����H�a�}</td>
				<td><input type="TEXT" name="recipient_address"
					value="<%=(productOrderVO != null) ? productOrderVO.getRecipient_address() : ""%> "
					size="45" /></td>
			</tr>
			<tr>
				<td>�ӫ~�q�榨�߮ɶ�</td>
				<td><input type="datetime" name="product_orderdate"
					value="<%=productOrderVO != null ? productOrderVO.getProduct_orderdate() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�ӫ~�q��I�ڮɶ�</td>
				<td><input type="datetime" name="product_paydate"
					value="<%=productOrderVO != null ? productOrderVO.getProduct_paydate() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�ӫ~�q�浲�׮ɶ�</td>
				<td><input type="datetime" name="order_closedate"
					value="<%=productOrderVO != null ? productOrderVO.getOrder_closedate() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�ӫ~�q��I�ڪ��A</td>
				<td><input type="TEXT" name="product_payment_status"
					value="<%=(productOrderVO != null) ? productOrderVO.getProduct_payment_status() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�ӫ~�q��B�z���A</td>
				<td><input type="TEXT" name="product_process_status"
					value="<%=(productOrderVO != null) ? productOrderVO.getProduct_process_status() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�ӫ~�q�漷�ڪ��B</td>
				<td><input type="TEXT" name="product_order_allocation_amount"
					value="<%=(productOrderVO != null) ? productOrderVO.getProduct_order_allocation_amount() : ""%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�ӫ~�q�漷�ڪ��A</td>
				<td><input type="TEXT" name="product_order_allocation_status"
					value="<%=(productOrderVO != null) ? productOrderVO.getProduct_order_allocation_status() : ""%>"
					size="45" /></td>
			</tr>

		</table>
		<br> <input type="hidden" name="action" value="update"> 
		<input type="hidden" name="product_order_no" value="<%=productOrderVO.getProduct_order_no()%>"> 
		<input type="submit" value="�e�X�ק�">
	</FORM>
</body>
</html>