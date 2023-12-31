package com.bt.api.services;

import java.util.List;

import com.bt.api.entities.Account;

public interface AccountsService {

	Account addAccount(Account account,String userName);
	Account updateAccount(Account account);
	List<Account> getAllByUserName(String userName);
	Account getById(Long accountNumber);
	
}
