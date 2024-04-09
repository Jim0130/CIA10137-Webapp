package com.productOrder.model;

import java.sql.Timestamp;
import java.util.List;

public class ProductOrderService {

	private ProductOrderDAOInterface dao;

	public ProductOrderService() {
		dao = new ProductOrderJDBCDAO();
	}

	public ProductOrderVO addProductOrder(Integer member_no, Integer product_price, Integer product_coupon_discount, Integer product_checkout_amount, Integer member_points, Integer birthday_coupon_no, String recipient, String recipient_phone, String recipient_address, Timestamp product_orderdate, Timestamp product_paydate, Timestamp order_closedate, Byte product_payment_status, Byte product_process_status, Integer product_order_allocation_amount, Byte product_order_allocation_status) {

		ProductOrderVO productOrderVO = new ProductOrderVO();

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
		
		dao.insert(productOrderVO);

		return productOrderVO;
	}

	public ProductOrderVO updateProductOrder(Integer product_order_no, Integer member_no, Integer product_price, Integer product_coupon_discount, Integer product_checkout_amount, Integer member_points, Integer birthday_coupon_no, String recipient, String recipient_phone, String recipient_address, Timestamp product_orderdate, Timestamp product_paydate, Timestamp order_closedate, Byte product_payment_status, Byte product_process_status, Integer product_order_allocation_amount, Byte product_order_allocation_status) {

		ProductOrderVO productOrderVO = new ProductOrderVO();

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
		dao.update(productOrderVO);

		return productOrderVO;
	}

	public void deleteProductOrder(Integer product_order_no) {
		dao.delete(product_order_no);
	}

	public ProductOrderVO getOneProductOrder(Integer product_order_no) {
		return dao.findByPrimaryKey(product_order_no);
	}

	public List<ProductOrderVO> getAll() {
		return dao.getAll();
	}
}
