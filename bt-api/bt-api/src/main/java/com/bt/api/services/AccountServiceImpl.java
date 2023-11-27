package com.bt.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bt.api.models.Account;
import com.bt.api.models.repos.AccountRepo;

@Service
public class AccountServiceImpl implements AccountsService {

	@Autowired
	private AccountRepo accountRepo;
	
	@Override
	public Account addAccount(Account account) {
		if(account!=null) {
			account.setCurrentBalance(0.0);
			account = accountRepo.save(account);
		}
		return account;
	}

	@Override
	public Account updateAccount(Account account) {
		if(account!=null) {
			account = accountRepo.save(account);
		}
		return account;
	}

	@Override
	public List<Account> getAllByUserName(String userName){
		return accountRepo.getAllByUser(userName);
	}

	@Override
	public Account getById(Long accountNumber) {
		return accountRepo.findById(accountNumber).orElse(null);
	}

	
}
