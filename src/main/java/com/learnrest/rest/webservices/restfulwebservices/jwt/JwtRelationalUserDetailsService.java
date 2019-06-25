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

	//	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();
//
//	static {
//		inMemoryUserList.add(new JwtUserDetails(1L, "admin",
//				"$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
//		inMemoryUserList.add(new JwtUserDetails(2L, "simon",
//				"$2a$10$f9mwhM.hZ9aJdlW4n5rMk.5GEWLc8tohyhYSbLf10aHyG8sFor89y", "ROLE_USER_2"));
//
//		//$2a$10$IetbreuU5KihCkDB6/r1DOJO0VyU9lSiBcrMDT.biU7FOt2oqZDPm
//	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		JwtUserDetails user = jwtUserRepository.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}

		return user;
	}

}