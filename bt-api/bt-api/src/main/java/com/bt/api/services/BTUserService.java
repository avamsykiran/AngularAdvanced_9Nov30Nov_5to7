package com.bt.api.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.bt.api.entities.AccountHolder;
import com.bt.api.entities.BTUser;

public interface BTUserService extends UserDetailsService {
	public BTUser createAdmin(BTUser btUser);
	public AccountHolder createAccountHolder(AccountHolder accountHolder);
}
