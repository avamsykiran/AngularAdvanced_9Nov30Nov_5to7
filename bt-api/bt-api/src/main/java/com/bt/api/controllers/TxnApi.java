package com.bt.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bt.api.entities.Txn;
import com.bt.api.services.TxnService;

@RestController
@CrossOrigin
@RequestMapping("/txns")
public class TxnApi {

	@Autowired
	private TxnService txnService;
	
	@GetMapping("/{txnId}")
	public ResponseEntity<Txn> getById(@PathVariable("txnId")Long txnId){
		Txn txn = txnService.getbyId(txnId);
		return txn!=null? ResponseEntity.ok(txn): ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Txn> addTxn(@RequestBody Txn txn){
		return new ResponseEntity<>(txnService.addTxn(txn),HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Txn> updateTxn(@RequestBody Txn txn){
		return new ResponseEntity<>(txnService.updateTxn(txn),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{txnId}")
	public ResponseEntity<Void> deleteTxn(@PathVariable("txnId")Long txnId){
		txnService.deleteById(txnId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
