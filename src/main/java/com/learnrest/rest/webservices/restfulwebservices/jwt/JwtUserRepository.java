package com.learnrest.rest.webservices.restfulwebservices.jwt;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtUserRepository extends JpaRepository<JwtUserDetails, Long> {

    JwtUserDetails findByUserName(String userName);
}

