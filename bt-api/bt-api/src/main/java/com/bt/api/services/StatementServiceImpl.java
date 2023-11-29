package com.bt.api.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bt.api.entities.Account;
import com.bt.api.entities.Txn;
import com.bt.api.entities.TxnType;
import com.bt.api.models.Statement;
import com.bt.api.repos.AccountRepo;
import com.bt.api.repos.TxnRepo;

@Service
public class StatementServiceImpl implements StatementService {
	
	@Autowired
	private AccountRepo accounRepo;
	
	@Autowired
	private TxnRepo txnRepo;

	@Override
	public Statement generateStatement(Long accountNumber, LocalDate start, LocalDate end) {
		
		Account account = accounRepo.findById(accountNumber).orElse(null);
		List<Txn> txns = txnRepo.getAllByAccount(accountNumber, start, end);
		
		double totalCredit=0;
		double totalDebit=0;
		double statementBalance=0;
		
		if(txns!=null && !txns.isEmpty()) {
			totalCredit = txns.stream().filter(t -> t.getType()==TxnType.CREDIT).mapToDouble(Txn::getAmount).sum();
			totalDebit = txns.stream().filter(t -> t.getType()==TxnType.DEBIT).mapToDouble(Txn::getAmount).sum();
			statementBalance = totalCredit - totalDebit;
		}
		
		return new Statement(account, start, end, txns, totalCredit, totalDebit, statementBalance); 
	}

}
