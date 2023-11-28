package com.bt.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bt.api.entities.AccountHolder;
import com.bt.api.entities.BTUser;
import com.bt.api.models.SecurityToken;
import com.bt.api.securityconfig.JwtTokenUtil;
import com.bt.api.services.BTUserService;

@RestController
@CrossOrigin
public class UsersApi {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private BTUserService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<SecurityToken> createAuthenticationToken(@RequestBody BTUser user) throws Exception {
		authenticate(user.getUserName(), user.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserName());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new SecurityToken(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	@RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
	public ResponseEntity<BTUser> saveUser(@RequestBody BTUser user) throws Exception {
		return ResponseEntity.ok(userDetailsService.createAdmin(user));
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<AccountHolder> saveUser(@RequestBody AccountHolder user) throws Exception {
		return ResponseEntity.ok(userDetailsService.createAccountHolder(user));
	}
}
