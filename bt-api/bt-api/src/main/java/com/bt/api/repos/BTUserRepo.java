package com.bt.api.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bt.api.entities.BTUser;

public interface BTUserRepo extends JpaRepository<BTUser, Long> {

	Optional<BTUser> findByUserName(String userName);
}
