package com.learnrest.rest.webservices.restfulwebservices.userregistration.repository;

import com.learnrest.rest.webservices.restfulwebservices.userregistration.domain.UserData;
import org.springframework.data.repository.CrudRepository;

public interface UserDataRepository extends CrudRepository<UserData, Long> {
}
