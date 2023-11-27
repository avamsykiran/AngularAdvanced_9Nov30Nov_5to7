package com.bt.api.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.bt.api.models.AccountHolder;
import com.bt.api.models.BTUser;

public interface BTUserService extends UserDetailsService {
	public void createAdmin(BTUser btUser);
	public void createAccountHolder(AccountHolder accountHolder);
}
