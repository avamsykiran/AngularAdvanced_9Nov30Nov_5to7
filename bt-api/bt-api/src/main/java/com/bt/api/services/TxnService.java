package com.bt.api.services;

import java.util.List;

import com.bt.api.entities.Txn;

public interface TxnService {

	List<Txn> getAllByAccount(Long accountNumber);
	Txn addTxn(Txn txn);
	Txn updateTxn(Txn txn);
	Txn getbyId(Long txnId);
	void deleteById(Long txnId);
}
