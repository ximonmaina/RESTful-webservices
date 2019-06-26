package com.learnrest.rest.webservices.restfulwebservices.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtRelationalUserDetailsService implements UserDetailsService {

	private JwtUserRepository jwtUserRepository;

	@Autowired
	public JwtRelationalUserDetailsService(JwtUserRepository jwtUserRepository) {
		this.jwtUserRepository = jwtUserRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		JwtUserDetails user = jwtUserRepository.findByUsername(username);
//		System.out.println("username is: " + username);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}

		return user;
	}

}