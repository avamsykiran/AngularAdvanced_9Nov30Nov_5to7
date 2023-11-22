package com.bt.api.models.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bt.api.models.Account;


public interface AccountRepo extends JpaRepository<Account, Long> {

	//@Query("SELECT a FROM Account a WHERE a.accountHolder.userName=:userName")
	@Query("SELECT a FROM Account a INNER JOIN a.accountHolder ah WHERE ah.userName=:userName")
	List<Account> getAllByUser(String userName);
}
