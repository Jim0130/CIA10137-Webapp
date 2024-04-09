<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>EZ�� ProductOrder: Home</title>

<style>
table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
	border: 3px ridge Gray;
	height: 80px;
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

input[type="submit"] {
	padding: 2px 10px;
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

<style>
.round-image {
	border-radius: 50%;
}
</style>
</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td><h3>EZBan ProductOrder: Home</h3>
				<img src="images/ezbanlogo.png" alt="EZBAN Logo" width="100"
				height="100" border="0" class="round-image">
				<h4>( MVC )</h4></td>
		</tr>
	</table>

	<p>This is the Home page for EZBan ProductOrder: Home</p>

	<h3>��Ƭd��:</h3>

	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<ul>
		<li><a href='listAllProductOrder.jsp'>List</a> all ProductOrders.
			<br> <br></li>


		<li>
			<FORM METHOD="post" ACTION="productOrder.do">
				<b>��J�ӫ~�q��s�� (�p1001):</b> <input type="text" name="product_order_no">
				<input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="�e�X">
			</FORM>
		</li>

		<jsp:useBean id="productOrderSvc" scope="page"
			class="com.productOrder.model.ProductOrderService" />

		<li>
			<FORM METHOD="post" ACTION="productOrder.do">
				<b>��ܰӫ~�q��s��:</b> <select size="1" name="product_order_no">
					<c:forEach var="productOrderVO" items="${productOrderSvc.all}">
						<option value="${productOrderVO.product_order_no}">${productOrderVO.product_order_no}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="�e�X">
			</FORM>
		</li>

		<li>
			<FORM METHOD="post" ACTION="productOrder.do">
				<b>��ܦ���H�m�W:</b> <select size="1" name="product_order_no">
					<c:forEach var="productOrderVO" items="${productOrderSvc.all}">
						<option value="${productOrderVO.product_order_no}">${productOrderVO.recipient}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="�e�X">
			</FORM>
		</li>
	</ul>

	<h3>�ӫ~�q��޲z</h3>

	<ul>
		<li><a href='addProductOrder.jsp'>Add</a> a new ProductOrder.</li>
	</ul>

</body>
</html>