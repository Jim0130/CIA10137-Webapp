package com.productReportHibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_no", updatable = false)
	private Integer admin_no;

	public Admin() {
		super();
	}

	public Admin(Integer admin_no) {
		super();
		this.admin_no = admin_no;
	}

	public Integer getAdmin_no() {
		return admin_no;
	}

	public void setAdmin_no(Integer admin_no) {
		this.admin_no = admin_no;
	}

}
