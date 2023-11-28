package com.bt.api.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bt.api.entities.Account;
import com.bt.api.entities.Txn;
import com.bt.api.entities.TxnType;
import com.bt.api.repos.AccountRepo;
import com.bt.api.repos.TxnRepo;

@Service
@Transactional
public class TxnServiceImpl implements TxnService {

	@Autowired
	private AccountRepo accountRepo;
	
	@Autowired
	private TxnRepo txnRepo;
	
	@Override
	public List<Txn> getAllByAccount(Long accountNumber) {
		return txnRepo.getAllByAccount(accountNumber);
	}

	@Override
	public Txn getbyId(Long txnId) {
		return txnRepo.findById(null).orElse(null);
	}

	@Override
	public Txn addTxn(Txn txn) {
		Account account = accountRepo.findById(txn.getAccount().getAccountNumber()).orElse(null);
		
		if(account!=null) {
			double currentBal = account.getCurrentBalance() + (txn.getAmount() * (txn.getType()==TxnType.DEBIT?-1:1));
			account.setCurrentBalance(currentBal);
			txn = txnRepo.save(txn);
			accountRepo.save(account);
		}
		
		return txn;
	}

	@Override
	public Txn updateTxn(Txn txn) {
		Account account = accountRepo.findById(txn.getAccount().getAccountNumber()).orElse(null);
		Txn oldTxn = txnRepo.findById(txn.getTxnId()).orElse(null);
		
		if(account!=null && oldTxn!=null) {
			double currentBal = account.getCurrentBalance() 
					+ (txn.getAmount() * (txn.getType()==TxnType.DEBIT?-1:1))
					- (oldTxn.getAmount() * (oldTxn.getType()==TxnType.DEBIT?-1:1));
			
			account.setCurrentBalance(currentBal);
			txn = txnRepo.save(txn);
			accountRepo.save(account);
		}
		
		return txn;
	}

	@Override
	public void deleteById(Long txnId) {
		Txn oldTxn = txnRepo.findById(txnId).orElse(null);
		
		if(oldTxn!=null) {
			Account account = oldTxn.getAccount();
			
			double currentBal = account.getCurrentBalance() 
					- (oldTxn.getAmount() * (oldTxn.getType()==TxnType.DEBIT?-1:1));
			
			account.setCurrentBalance(currentBal);
			txnRepo.deleteById(txnId);
			accountRepo.save(account);
		}
	}

}
