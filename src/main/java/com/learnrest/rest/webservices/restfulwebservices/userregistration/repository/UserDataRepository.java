package com.learnrest.rest.webservices.restfulwebservices.userregistration.repository;

import com.learnrest.rest.webservices.restfulwebservices.userregistration.domain.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserDataRepository extends JpaRepository<UserData, Long> {

    UserData findById(long id);

    Optional<UserData> findUserDataById(long id);
}
