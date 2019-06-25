package com.learnrest.rest.webservices.restfulwebservices.jwt;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtUserRepository extends CrudRepository<JwtUserDetails, Long> {

    JwtUserDetails findByUsername(String username);
}
