package com.bt.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.bt.api.entities.BTUser;
import com.bt.api.repos.BTUserRepo;
import com.bt.api.services.BTUserService;

@Component
public class CreateInitialAdminUser implements CommandLineRunner {
	
	@Autowired
	private BTUserService userService;
	
	@Override
	public void run(String... args) throws Exception {
		try{
			userService.loadUserByUsername("Admin");
		}catch(UsernameNotFoundException exp) {
			userService.createAdmin(new BTUser("Admin","Admin"));
		}
	}

}
