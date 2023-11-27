package com.bt.api.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ach")
public class AccountHolder extends BTUser {

	private String fullName;
	private String mobileNumber;
	private String mailId;
	
	public AccountHolder() {
		this.setRole(BTRole.ACCOUNT_HOLDER);
	}

	public AccountHolder(String userName, String password, String fullName, String mobileNumber, String mailId) {
		super(userName, password);
		this.fullName = fullName;
		this.mobileNumber = mobileNumber;
		this.mailId = mailId;
		this.setRole(BTRole.ACCOUNT_HOLDER);
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	
	
}
