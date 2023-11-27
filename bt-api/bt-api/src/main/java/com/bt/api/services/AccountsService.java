package com.bt.api.services;

import java.util.List;

import com.bt.api.models.Account;

public interface AccountsService {

	Account addAccount(Account account);
	Account updateAccount(Account account);
	List<Account> getAllByUserName(String userName);
	Account getById(Long accountNumber);
	
}
