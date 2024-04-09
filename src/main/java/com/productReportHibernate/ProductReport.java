package com.productReportHibernate;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_report")
public class ProductReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_report_no", updatable = false)
	private Integer product_report_no;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "product_no")
	private Product product;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "member_no")
	private Member member;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "admin_no")
	private Admin admin;

	@Column(name = "report_reason", length = 100)
	private String report_reason;

	@Column(name = "report_date")
	private Timestamp report_date;

	@Column(name = "report_status")
	private Byte report_status;

	public ProductReport() {
		super();
	}

	public ProductReport(Product product, Member member, Admin admin, String report_reason,
			Timestamp report_date, Byte report_status) {
		super();
		this.product = product;
		this.member = member;
		this.admin = admin;
		this.report_reason = report_reason;
		this.report_date = report_date;
		this.report_status = report_status;
	}

	public Integer getProduct_report_no() {
		return product_report_no;
	}

	public void setProduct_report_no(Integer product_report_no) {
		this.product_report_no = product_report_no;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getReport_reason() {
		return report_reason;
	}

	public void setReport_reason(String report_reason) {
		this.report_reason = report_reason;
	}

	public Timestamp getReport_date() {
		return report_date;
	}

	public void setReport_date(Timestamp report_date) {
		this.report_date = report_date;
	}

	public Byte getReport_status() {
		return report_status;
	}

	public void setReport_status(Byte report_status) {
		this.report_status = report_status;
	}
}
