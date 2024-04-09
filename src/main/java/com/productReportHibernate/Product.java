package com.productReportHibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_no", updatable = false)
	private Integer product_no;

	public Product() {
		super();
	}

	public Product(Integer product_no) {
		super();
		this.product_no = product_no;
	}

	public Integer getProduct_no() {
		return product_no;
	}

	public void setProduct_no(Integer product_no) {
		this.product_no = product_no;
	}

}
