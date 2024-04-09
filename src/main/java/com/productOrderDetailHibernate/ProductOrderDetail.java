package com.productOrderDetailHibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product_order_detail")
public class ProductOrderDetail {

	@EmbeddedId
	private CompositeDetail compositeKey;

	@Column(name = "product_qty")
	private Integer product_qty;

	@Column(name = "product_price")
	private Integer product_price;

	@Column(name = "comments_status")
	private Byte comments_status;

	public ProductOrderDetail() {
		super();
	}

	public ProductOrderDetail(CompositeDetail compositeKey, Integer product_qty, Integer product_price,
			Byte comments_status) {
		super();
		this.compositeKey = compositeKey;
		this.product_qty = product_qty;
		this.product_price = product_price;
		this.comments_status = comments_status;
	}

	public CompositeDetail getCompositeKey() {
		return compositeKey;
	}

	public void setCompositeKey(CompositeDetail compositeKey) {
		this.compositeKey = compositeKey;
	}

	public Integer getProduct_qty() {
		return product_qty;
	}

	public void setProduct_qty(Integer product_qty) {
		this.product_qty = product_qty;
	}

	public Integer getProduct_price() {
		return product_price;
	}

	public void setProduct_price(Integer product_price) {
		this.product_price = product_price;
	}

	public Byte getComments_status() {
		return comments_status;
	}

	public void setComments_status(Byte comments_status) {
		this.comments_status = comments_status;
	}

	@Embeddable
	public static class CompositeDetail implements Serializable {
		private static final long serialVersionUID = 1L;

		@Column(name = "product_no")
		private Integer product_no;

		@Column(name = "product_order_no")
		private Integer product_order_no;

		public CompositeDetail() {
			super();
		}

		public CompositeDetail(Integer product_no, Integer product_order_no) {
			super();
			this.product_no = product_no;
			this.product_order_no = product_order_no;
		}

		public Integer getProduct_no() {
			return product_no;
		}

		public void setProduct_no(Integer product_no) {
			this.product_no = product_no;
		}

		public Integer getProduct_order_no() {
			return product_order_no;
		}

		public void setProduct_order_no(Integer product_order_no) {
			this.product_order_no = product_order_no;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((product_no == null) ? 0 : product_no.hashCode());
			result = prime * result + ((product_order_no == null) ? 0 : product_order_no.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;

			if (obj != null && getClass() == obj.getClass()) {
				CompositeDetail compositeKey = (CompositeDetail) obj;
				if (product_no.equals(compositeKey.product_no)
						&& product_order_no.equals(compositeKey.product_order_no)) {
					return true;
				}
			}
			return false;
		}
	}
}
