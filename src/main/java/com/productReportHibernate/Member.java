package com.productReportHibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class Member implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_no", updatable = false)
	private Integer member_no;

	public Member() {
		super();
	}

	public Member(Integer member_no) {
		super();
		this.member_no = member_no;
	}

	public Integer getMember_no() {
		return member_no;
	}

	public void setMember_no(Integer member_no) {
		this.member_no = member_no;
	}

}
