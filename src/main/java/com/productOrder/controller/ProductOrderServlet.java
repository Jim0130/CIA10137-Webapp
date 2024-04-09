package com.productOrder.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.productOrder.model.ProductOrderService;
import com.productOrder.model.ProductOrderVO;

@WebServlet("/productorder/productOrder.do")
public class ProductOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("product_order_no");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入商品訂單編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/productorder/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer product_order_no = null;
			try {
				product_order_no = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("商品訂單編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/productorder/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			ProductOrderService productOrderSvc = new ProductOrderService();
			ProductOrderVO productOrderVO = productOrderSvc.getOneProductOrder(product_order_no);
			if (productOrderVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/productorder/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("productOrderVO", productOrderVO); // 資料庫取出的productOrderVO物件,存入req
			String url = "/productorder/listOneProductOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneProductOrder.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllProductOrder.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer product_order_no = Integer.valueOf(req.getParameter("product_order_no"));

			/*************************** 2.開始查詢資料 ****************************************/
			ProductOrderService productOrderSvc = new ProductOrderService();
			ProductOrderVO productOrderVO = productOrderSvc.getOneProductOrder(product_order_no);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("productOrderVO", productOrderVO); // 資料庫取出的productOrderVO物件,存入req
			String url = "/productorder/update_productOrder_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_productOrder_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_productOrder_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer product_order_no = Integer.valueOf(req.getParameter("product_order_no").trim());

			Integer member_no = Integer.valueOf(req.getParameter("member_no").trim());

			Integer product_price = Integer.valueOf(req.getParameter("product_price").trim());

			Integer product_coupon_discount = Integer.valueOf(req.getParameter("product_coupon_discount").trim());

			Integer product_checkout_amount = Integer.valueOf(req.getParameter("product_checkout_amount").trim());

			Integer member_points = Integer.valueOf(req.getParameter("member_points").trim());

			Integer birthday_coupon_no = Integer.valueOf(req.getParameter("birthday_coupon_no").trim());

			String recipient = req.getParameter("recipient");
			String recipientReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (recipient == null || recipient.trim().length() == 0) {
				errorMsgs.add("員工姓名: 請勿空白");
			} else if (!recipient.trim().matches(recipientReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			String recipient_phone = req.getParameter("recipient_phone").trim();
			if (recipient_phone == null || recipient_phone.trim().length() == 0) {
				errorMsgs.add("收件人電話請勿空白");
			}

			String recipient_address = req.getParameter("recipient_address").trim();
			if (recipient_address == null || recipient_address.trim().length() == 0) {
				errorMsgs.add("收件人地址請勿空白");
			}

			java.sql.Timestamp product_orderdate = null;
			try {
				product_orderdate = java.sql.Timestamp.valueOf(req.getParameter("product_orderdate").trim());
			} catch (IllegalArgumentException e) {
				product_orderdate = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入商品訂單成立時間!");
			}

			java.sql.Timestamp product_paydate = null;
			try {
				product_paydate = java.sql.Timestamp.valueOf(req.getParameter("product_paydate").trim());
			} catch (IllegalArgumentException e) {
				product_paydate = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入商品訂單付款時間!");
			}

			java.sql.Timestamp order_closedate = null;
			try {
				order_closedate = java.sql.Timestamp.valueOf(req.getParameter("order_closedate").trim());
			} catch (IllegalArgumentException e) {
				order_closedate = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入商品訂單結案時間!");
			}

			Byte product_payment_status = Byte.valueOf(req.getParameter("product_payment_status").trim());

			Byte product_process_status = Byte.valueOf(req.getParameter("product_process_status").trim());

			Integer product_order_allocation_amount = Integer
					.valueOf(req.getParameter("product_order_allocation_amount").trim());

			Byte product_order_allocation_status = Byte
					.valueOf(req.getParameter("product_order_allocation_status").trim());

			ProductOrderVO productOrderVO = new ProductOrderVO();
			productOrderVO = new ProductOrderVO();
			productOrderVO.setProduct_order_no(product_order_no);
			productOrderVO.setMember_no(member_no);
			productOrderVO.setProduct_price(product_price);
			productOrderVO.setProduct_coupon_discount(product_coupon_discount);
			productOrderVO.setProduct_checkout_amount(product_checkout_amount);
			productOrderVO.setMember_points(member_points);
			productOrderVO.setBirthday_coupon_no(birthday_coupon_no);
			productOrderVO.setRecipient(recipient);
			productOrderVO.setRecipient_phone(recipient_phone);
			productOrderVO.setRecipient_address(recipient_address);
			productOrderVO.setProduct_orderdate(product_orderdate);
			productOrderVO.setProduct_paydate(product_paydate);
			productOrderVO.setOrder_closedate(order_closedate);
			productOrderVO.setProduct_payment_status(product_payment_status);
			productOrderVO.setProduct_process_status(product_process_status);
			productOrderVO.setProduct_order_allocation_amount(product_order_allocation_amount);
			productOrderVO.setProduct_order_allocation_status(product_order_allocation_status);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("productOrderVO", productOrderVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/productorder/update_productOrder_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			ProductOrderService productOrderSvc = new ProductOrderService();
			productOrderVO = productOrderSvc.updateProductOrder(product_order_no, member_no, product_price,
					product_coupon_discount, product_checkout_amount, member_points, birthday_coupon_no, recipient,
					recipient_phone, recipient_address, product_orderdate, product_paydate, order_closedate,
					product_payment_status, product_process_status, product_order_allocation_amount,
					product_order_allocation_status);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("productOrderVO", productOrderVO); // 資料庫update成功後,正確的的productOrderVO物件,存入req
			String url = "/productorder/listOneProductOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("insert".equals(action)) { // 來自addProductOrder.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			Integer member_no = Integer.valueOf(req.getParameter("member_no").trim());

			Integer product_price = Integer.valueOf(req.getParameter("product_price").trim());

			Integer product_coupon_discount = Integer.valueOf(req.getParameter("product_coupon_discount").trim());

			Integer product_checkout_amount = Integer.valueOf(req.getParameter("product_checkout_amount").trim());

			Integer member_points = Integer.valueOf(req.getParameter("member_points").trim());

			Integer birthday_coupon_no = Integer.valueOf(req.getParameter("birthday_coupon_no").trim());

			String recipient = req.getParameter("recipient");
			String recipientReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (recipient == null || recipient.trim().length() == 0) {
				errorMsgs.add("員工姓名: 請勿空白");
			} else if (!recipient.trim().matches(recipientReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			String recipient_phone = req.getParameter("recipient_phone").trim();
			if (recipient_phone == null || recipient_phone.trim().length() == 0) {
				errorMsgs.add("收件人電話請勿空白");
			}

			String recipient_address = req.getParameter("recipient_address").trim();
			if (recipient_address == null || recipient_address.trim().length() == 0) {
				errorMsgs.add("收件人地址請勿空白");
			}

			java.sql.Timestamp product_orderdate = null;
			try {
				product_orderdate = java.sql.Timestamp.valueOf(req.getParameter("product_orderdate").trim());
			} catch (IllegalArgumentException e) {
				product_orderdate = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入商品訂單成立時間!");
			}

			java.sql.Timestamp product_paydate = null;
			try {
				product_paydate = java.sql.Timestamp.valueOf(req.getParameter("product_paydate").trim());
			} catch (IllegalArgumentException e) {
				product_paydate = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入商品訂單付款時間!");
			}

			java.sql.Timestamp order_closedate = null;
			try {
				order_closedate = java.sql.Timestamp.valueOf(req.getParameter("order_closedate").trim());
			} catch (IllegalArgumentException e) {
				order_closedate = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入商品訂單結案時間!");
			}

			Byte product_payment_status = Byte.valueOf(req.getParameter("product_payment_status").trim());

			Byte product_process_status = Byte.valueOf(req.getParameter("product_process_status").trim());

			Integer product_order_allocation_amount = Integer
					.valueOf(req.getParameter("product_order_allocation_amount").trim());

			Byte product_order_allocation_status = Byte
					.valueOf(req.getParameter("product_order_allocation_status").trim());

			ProductOrderVO productOrderVO = new ProductOrderVO();
			productOrderVO = new ProductOrderVO();
			productOrderVO.setMember_no(member_no);
			productOrderVO.setProduct_price(product_price);
			productOrderVO.setProduct_coupon_discount(product_coupon_discount);
			productOrderVO.setProduct_checkout_amount(product_checkout_amount);
			productOrderVO.setMember_points(member_points);
			productOrderVO.setBirthday_coupon_no(birthday_coupon_no);
			productOrderVO.setRecipient(recipient);
			productOrderVO.setRecipient_phone(recipient_phone);
			productOrderVO.setRecipient_address(recipient_address);
			productOrderVO.setProduct_orderdate(product_orderdate);
			productOrderVO.setProduct_paydate(product_paydate);
			productOrderVO.setOrder_closedate(order_closedate);
			productOrderVO.setProduct_payment_status(product_payment_status);
			productOrderVO.setProduct_process_status(product_process_status);
			productOrderVO.setProduct_order_allocation_amount(product_order_allocation_amount);
			productOrderVO.setProduct_order_allocation_status(product_order_allocation_status);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("productOrderVO", productOrderVO); // 含有輸入格式錯誤的productOrderVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/productorder/addProductOrder.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			ProductOrderService productOrderSvc = new ProductOrderService();
			productOrderVO = productOrderSvc.addProductOrder(member_no, product_price, product_coupon_discount,
					product_checkout_amount, member_points, birthday_coupon_no, recipient, recipient_phone,
					recipient_address, product_orderdate, product_paydate, order_closedate, product_payment_status,
					product_process_status, product_order_allocation_amount, product_order_allocation_status);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/productorder/listAllProductOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllProductOrder.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer product_order_no = Integer.valueOf(req.getParameter("product_order_no"));

			/*************************** 2.開始刪除資料 ***************************************/
			ProductOrderService productOrderSvc = new ProductOrderService();
			productOrderSvc.deleteProductOrder(product_order_no);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/productorder/listAllProductOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}
}
