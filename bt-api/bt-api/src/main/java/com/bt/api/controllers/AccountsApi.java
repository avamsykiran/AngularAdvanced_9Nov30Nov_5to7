package com.bt.api.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bt.api.entities.Account;
import com.bt.api.entities.Txn;
import com.bt.api.services.AccountsService;
import com.bt.api.services.TxnService;

@RestController
@CrossOrigin
@RequestMapping("/accounts")
public class AccountsApi {

	@Autowired
	private AccountsService accountsService;
	
	@Autowired
	private TxnService txnService;
	
	@GetMapping
	public ResponseEntity<List<Account>> getAllAccountsOfCurrentUser(Principal currentUser){
		return ResponseEntity.ok(accountsService.getAllByUserName(currentUser.getName()));
	}
	
	@GetMapping("/{accountNumber}")
	public ResponseEntity<Account> getAccountById(@PathVariable("accountNumber") Long accountNumber){
		Account acc = accountsService.getById(accountNumber);
		return acc!=null?ResponseEntity.ok(acc) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{accountNumber}/txns")
	public ResponseEntity<List<Txn>> getAllTxnsByAccount(@PathVariable("accountNumber") Long accountNumber){
		return ResponseEntity.ok(txnService.getAllByAccount(accountNumber));
	}
	
	@PostMapping
	public ResponseEntity<Account> addAccount(@RequestBody Account account){
		return new ResponseEntity<>(accountsService.addAccount(account),HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Account> updateAccount(@RequestBody Account account){
		return new ResponseEntity<>(accountsService.updateAccount(account),HttpStatus.CREATED);
	}
}
