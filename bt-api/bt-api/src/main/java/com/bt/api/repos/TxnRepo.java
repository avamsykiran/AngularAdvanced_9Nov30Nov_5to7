package com.bt.api.repos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.bt.api.entities.Txn;

public interface TxnRepo extends JpaRepository<Txn, Long> {

	@Query("SELECT t FROM Txn t INNER JOIN t.account a WHERE a.accountNumber=:accountNumber")
	List<Txn> getAllByAccount(Long accountNumber);
	
	@Query("SELECT t FROM Txn t INNER JOIN t.account a WHERE a.accountNumber=:accountNumber AND t.txnDate BETWEEN :start AND :end")
	List<Txn> getAllByAccount(Long accountNumber,@DateTimeFormat(iso=ISO.DATE) LocalDate start,@DateTimeFormat(iso=ISO.DATE) LocalDate end);
}
