package com.bt.api.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bt.api.entities.AccountHolder;

public interface AccountHolderRepo extends JpaRepository<AccountHolder, Long> {

	Optional<AccountHolder> findByUserName(String userName);
}
