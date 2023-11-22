package com.bt.api.models;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="bt_users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("btuser")
public class BTUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private string userName;
	private string password;
	@Enumerated(EnumType.STRING)
	private BTRole role;
	
	public BTUser() {
		this.role=BTRole.ADMIN;
	}

	public BTUser(string userName, string password) {
		this();
		this.userName = userName;
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public string getUserName() {
		return userName;
	}

	public void setUserName(string userName) {
		this.userName = userName;
	}

	public string getPassword() {
		return password;
	}

	public void setPassword(string password) {
		this.password = password;
	}

	public BTRole getRole() {
		return role;
	}

	public void setRole(BTRole role) {
		this.role = role;
	}
	
	
	
}
