package com.productOrder.model;

import java.sql.Timestamp;

public class ProductOrderVO implements java.io.Serializable {
	private Integer product_order_no;
	private Integer member_no;
	private Integer product_price;
	private Integer product_coupon_discount;
	private Integer product_checkout_amount;
	private Integer member_points;
	private Integer birthday_coupon_no;
	private String recipient;
	private String recipient_phone;
	private String recipient_address;
	private Timestamp product_orderdate;
	private Timestamp product_paydate;
	private Timestamp order_closedate;
	private Byte product_payment_status;
	private Byte product_process_status;
	private Integer product_order_allocation_amount;
	private Byte product_order_allocation_status;

	public Integer getProduct_order_no() {
		return product_order_no;
	}

	public void setProduct_order_no(Integer product_order_no) {
		this.product_order_no = product_order_no;
	}

	public Integer getMember_no() {
		return member_no;
	}

	public void setMember_no(Integer member_no) {
		this.member_no = member_no;
	}

	public Integer getProduct_price() {
		return product_price;
	}

	public void setProduct_price(Integer product_price) {
		this.product_price = product_price;
	}

	public Integer getProduct_coupon_discount() {
		return product_coupon_discount;
	}

	public void setProduct_coupon_discount(Integer product_coupon_discount) {
		this.product_coupon_discount = product_coupon_discount;
	}

	public Integer getProduct_checkout_amount() {
		return product_checkout_amount;
	}

	public void setProduct_checkout_amount(Integer product_checkout_amount) {
		this.product_checkout_amount = product_checkout_amount;
	}

	public Integer getMember_points() {
		return member_points;
	}

	public void setMember_points(Integer member_points) {
		this.member_points = member_points;
	}

	public Integer getBirthday_coupon_no() {
		return birthday_coupon_no;
	}

	public void setBirthday_coupon_no(Integer birthday_coupon_no) {
		this.birthday_coupon_no = birthday_coupon_no;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getRecipient_phone() {
		return recipient_phone;
	}

	public void setRecipient_phone(String recipient_phone) {
		this.recipient_phone = recipient_phone;
	}

	public String getRecipient_address() {
		return recipient_address;
	}

	public void setRecipient_address(String recipient_address) {
		this.recipient_address = recipient_address;
	}

	public Timestamp getProduct_orderdate() {
		return product_orderdate;
	}

	public void setProduct_orderdate(Timestamp product_orderdate) {
		this.product_orderdate = product_orderdate;
	}

	public Timestamp getProduct_paydate() {
		return product_paydate;
	}

	public void setProduct_paydate(Timestamp product_paydate) {
		this.product_paydate = product_paydate;
	}

	public Timestamp getOrder_closedate() {
		return order_closedate;
	}

	public void setOrder_closedate(Timestamp order_closedate) {
		this.order_closedate = order_closedate;
	}

	public Byte getProduct_payment_status() {
		return product_payment_status;
	}

	public void setProduct_payment_status(Byte product_payment_status) {
		this.product_payment_status = product_payment_status;
	}

	public Byte getProduct_process_status() {
		return product_process_status;
	}

	public void setProduct_process_status(Byte product_process_status) {
		this.product_process_status = product_process_status;
	}

	public Integer getProduct_order_allocation_amount() {
		return product_order_allocation_amount;
	}

	public void setProduct_order_allocation_amount(Integer product_order_allocation_amount) {
		this.product_order_allocation_amount = product_order_allocation_amount;
	}

	public Byte getProduct_order_allocation_status() {
		return product_order_allocation_status;
	}

	public void setProduct_order_allocation_status(Byte product_order_allocation_status) {
		this.product_order_allocation_status = product_order_allocation_status;
	}

}
