package com.learn.domain;

import java.sql.Date;

public class User {

	private long id;
	private String name;
	private String phone;
	private String address;
	private String addressDetail;
	private String userDtatus;
	private String userClass;
	private String email;
	private boolean marketingAgree;
	private String socialLogin;
	private Date last_loggedAt;
	private Date createdAt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getUserDtatus() {
		return userDtatus;
	}

	public void setUserDtatus(String userDtatus) {
		this.userDtatus = userDtatus;
	}

	public String getUserClass() {
		return userClass;
	}

	public void setUserClass(String userClass) {
		this.userClass = userClass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isMarketingAgree() {
		return marketingAgree;
	}

	public void setMarketingAgree(boolean marketingAgree) {
		this.marketingAgree = marketingAgree;
	}

	public String getSocialLogin() {
		return socialLogin;
	}

	public void setSocialLogin(String socialLogin) {
		this.socialLogin = socialLogin;
	}

	public Date getLast_loggedAt() {
		return last_loggedAt;
	}

	public void setLast_loggedAt(Date last_loggedAt) {
		this.last_loggedAt = last_loggedAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", addressDetail="
				+ addressDetail + ", userDtatus=" + userDtatus + ", userClass=" + userClass + ", email=" + email
				+ ", marketingAgree=" + marketingAgree + ", socialLogin=" + socialLogin + ", last_loggedAt="
				+ last_loggedAt + ", createdAt=" + createdAt + "]";
	}
}
