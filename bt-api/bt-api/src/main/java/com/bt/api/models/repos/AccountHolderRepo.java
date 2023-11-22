package com.bt.api.models.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bt.api.models.AccountHolder;

public interface AccountHolderRepo extends JpaRepository<AccountHolder, Long> {

	Optional<AccountHolder> findByUserName(String userName);
}
