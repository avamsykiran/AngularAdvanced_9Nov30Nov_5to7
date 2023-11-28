package com.bt.api.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bt.api.entities.Txn;

public interface TxnRepo extends JpaRepository<Txn, Long> {

	@Query("SELECT t FROM Txn t INNER JOIN t.account a WHERE a.accountNumber=:accountNumber")
	List<Txn> getAllByAccount(Long accountNumber);
}
