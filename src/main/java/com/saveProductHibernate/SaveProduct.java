package com.saveProductHibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "save_product")
public class SaveProduct {
	
	@EmbeddedId
	private CompositeDetail compositeKey;

	public CompositeDetail getCompositeKey() {
		return compositeKey;
	}

	public void setCompositeKey(CompositeDetail compositeKey) {
		this.compositeKey = compositeKey;
	}
	
	public SaveProduct(Integer memberId, Integer productId) {
		this.compositeKey = new CompositeDetail(memberId, productId);
	}

	@Embeddable
	public static class CompositeDetail implements Serializable {
		private static final long serialVersionUID = 1L;

		@Column(name = "member_no")
		private Integer member_no;

		@Column(name = "product_no")
		private Integer product_no;

		public CompositeDetail() {
			super();
		}

		public CompositeDetail(Integer member_no, Integer product_no) {
			super();
			this.member_no = member_no;
			this.product_no = product_no;
		}

		public Integer getMember_no() {
			return member_no;
		}

		public void setMember_no(Integer member_no) {
			this.member_no = member_no;
		}

		public Integer getProduct_no() {
			return product_no;
		}

		public void setProduct_no(Integer product_no) {
			this.product_no = product_no;
		}

		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((member_no == null) ? 0 : member_no.hashCode());
			result = prime * result + ((product_no == null) ? 0 : product_no.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;

			if (obj != null && getClass() == obj.getClass()) {
				CompositeDetail compositeKey = (CompositeDetail) obj;
				if (member_no.equals(compositeKey.member_no) && product_no.equals(compositeKey.product_no)) {
					return true;
				}
			}
			return false;
		}
	}

}