package com.bt.api.services;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bt.api.entities.AccountHolder;
import com.bt.api.entities.BTRole;
import com.bt.api.entities.BTUser;
import com.bt.api.repos.AccountHolderRepo;
import com.bt.api.repos.BTUserRepo;

@Service
public class BTUserServiceImpl implements BTUserService {

	@Autowired
	private BTUserRepo userRepo;
	
	@Autowired
	private AccountHolderRepo accountHolderRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		BTUser user = userRepo.findByUserName(username).orElse(null);
		
		if(user==null) {
			user = accountHolderRepo.findByUserName(username).orElse(null);
			if(user==null) {
				throw new UsernameNotFoundException("Invalid User Identity");
			}
		}
		GrantedAuthority role = new SimpleGrantedAuthority(user.getRole().toString());
		UserDetails userDetails = new User(username, user.getPassword(), Collections.singleton(role));
		return userDetails;
	}

	@Override
	public BTUser createAdmin(BTUser btUser) {
		if(btUser!=null) {
			btUser.setPassword(passwordEncoder.encode(btUser.getPassword()));
			btUser.setRole(BTRole.ADMIN);
			btUser = userRepo.save(btUser);
		}
		return btUser;
	}
	
	@Override
	public AccountHolder createAccountHolder(AccountHolder accountHolder) {
		if(accountHolder!=null) {
			accountHolder.setPassword(passwordEncoder.encode(accountHolder.getPassword()));
			accountHolder.setRole(BTRole.ACCOUNT_HOLDER);
			accountHolder = accountHolderRepo.save(accountHolder);
		}
		return accountHolder;
	}
	
}
